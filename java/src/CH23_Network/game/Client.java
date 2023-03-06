package CH23_Network.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;



public class Client extends JFrame  implements ActionListener {

    private static final long serialVersionUID = 1L;

    // 문자열 입력창
    private JTextField textField;

    // 출력 UI
    private JTextArea textArea;

    // Server와 통신하기 위한 Socket
    private Socket socket = null;

    // Server로부터 데이터를 읽어들이기 위한 입력스트림
    private BufferedReader inStream = null;

    // 서버로 내보내기 위한 출력 스트림
    PrintWriter outSteam = null;

    InetAddress ia = null;

    // 서버 아이피
    private String serverId = "127.0.0.1";

    // 서버 포트
    private int serverPort = 30000;

    public Client() throws IOException {
        renderUI();
        initClient();
        doProcess();
    }

    /**
     * 서버와 통신
     * */
    private void doProcess() throws IOException {

        while (!socket.isClosed()) {
            String msg = receive();
            if (msg != null)
                textArea.append(msg + "\n");
        }


    }

    /**
     * 클라이언트 초기화 코드
     * */
    private void initClient() throws IOException {
        socket = new Socket(serverId, serverPort);
        inStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        outSteam = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
    }

    private void renderUI() {

        this.setTitle("클라이언트");

        textField = new JTextField(30);
        textField.addActionListener(this);  // 이벤트 발생시 actionPerformed 메소드 실행.

        textArea = new JTextArea(20, 30);
        textArea.setEditable(false);

        add(textField , BorderLayout.PAGE_END);
        add(textArea, BorderLayout.CENTER);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }


    //    이벤트 발생시 실행 코드

    @Override
    public void actionPerformed(ActionEvent e) {
//        이벤트 발생시 textField의 String을 서버에 전송..

        String message = textField.getText();
        sendMessage(message);
        textField.setText(""); // 입력창 비우기(공백)
    }

    public void sendMessage(String s){
        outSteam.println(s);
        outSteam.flush();
    }

    private String receive() throws IOException {
        return inStream.readLine();
    }



    public static void main(String[] args) throws IOException {
        new Client();
    }
}
