package CH23_Network.chating;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient3 extends JFrame implements ActionListener, Runnable  {


    private JTextArea output;                        // 대화상자 (전체)
    private JTextField input;                           // 입력창..
    private JButton sendBtn;
    private Socket socket;
    private ObjectInputStream reader = null;
    private ObjectOutputStream writer = null;
    private String nickName;


    public ChatClient3() {

        setTitle("클라이언트 채팅");
        // 센터에 TextArea만들기
        output = new JTextArea();
        output.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        output.setEditable(false);
        JScrollPane scroll = new JScrollPane(output);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // 항상 스크롤바가 세로로 떠있음

        // 하단에 버튼과 TextArea넣기
        JPanel bottom = new JPanel();
        bottom.setLayout(new BorderLayout());
        input = new JTextField();
        sendBtn = new JButton("보내기");


        bottom.add("Center", input); // 센터에 붙이기
        bottom.add("East", sendBtn); // 동쪽에 붙이기

        // container에 붙이기
        Container c = this.getContentPane();
        c.add("Center", scroll); // 센터에 붙이기
        c.add("South", bottom); // 남쪽에 붙이기

        // 윈도우 창 설정
        setBounds(300, 300, 300, 300);
        setVisible(true);




        // 윈도우 닫기 이벤트
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {

                try {

                    InfoDto dto = new InfoDto();
                    dto.setNickname(nickName);
                    dto.setCommand(Info.EXIT);
                    writer.writeObject(dto); // 소켓을 통해 서버로 전달.
                    writer.flush();
                } catch (IOException io) {
                    io.printStackTrace();
                }
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {  // 입력 누르면
        // 메세지 입력을 누르면 실행!
        try {
            // 서버로 보냄
            // JTextField값을 서버로보내기
            // 버퍼 비우기
            String msg = input.getText();
            InfoDto dto = new InfoDto();
            dto.setNickname(nickName);
            if (msg.equals("exit")) {
                dto.setCommand(Info.EXIT);
            } else {
                dto.setCommand(Info.SEND);
                dto.setMessage(msg);
            }
            writer.writeObject(dto);
            writer.flush();
            input.setText("");

        } catch (IOException io) {
            io.printStackTrace();
        }

    }

    private void service() {
        //서버 IP 입력받기

        String serverIP= JOptionPane.showInputDialog(this,"서버IP를 입력하세요","127.0.0.1");  //기본적으로 아이피 값이 입력되어 들어가게 됨
        if(serverIP==null || serverIP.length()==0){  //만약 값이 입력되지 않았을 때 창이 꺼짐
            System.out.println("서버 IP가 입력되지 않았습니다.");
            // 종료..
            System.exit(0);
        }
        //닉네임 받기
        nickName= JOptionPane.showInputDialog("닉네임을 입력하세요","Guest" );
//        if(nickName == null || nickName.length()==0){
//            nickName="guest";
//        }

//      Server Socket에 접속.
        try{
            socket = new Socket(serverIP,9500);
            reader= new ObjectInputStream(socket.getInputStream());
            writer = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("전송 준비 완료!");
        } catch(UnknownHostException e ){
            System.out.println("서버를 찾을 수 없습니다.");
            e.printStackTrace();
            System.exit(0);
        } catch(IOException e){
            System.out.println("서버와 연결이 안되었습니다.");
            e.printStackTrace();
            System.exit(0);
        }

        try{
            InfoDto dto = new InfoDto();
            dto.setCommand(Info.JOIN);
            dto.setNickname(nickName);
            writer.writeObject(dto);
            writer.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
        //스레드 생성해서 이 클라이언트 객체 입력 , 서버에서 오는 데이터 받기.
        Thread t = new Thread(this);
        t.start(); //시작하기
        input.addActionListener(this); // 엔터키 누를시 액션 이벤트 추가
        sendBtn.addActionListener(this);  //버튼 누를시 액션 이벤트 추가
    }

    @Override
    public void run() { // 쓰레드 실행시 : 서버제어 전달되는 dto 객체 받기 .
        //서버로부터 데이터 받기
        InfoDto dto= null;
        while(true){
            try{
                dto = (InfoDto) reader.readObject();
                if(dto.getCommand()==Info.EXIT){  //서버로부터 내 자신의 exit를 받으면 종료됨
                    reader.close();
                    writer.close();
                    socket.close();
                    System.exit(0); // 종료 ㅣ!!
                } else if(dto.getCommand()==Info.SEND){
                    output.append(dto.getMessage()+"\n");

                    int pos=output.getText().length();
                    output.setCaretPosition(pos);
                }
            }catch(IOException | ClassNotFoundException e){
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new ChatClient3().service();
    }
}
