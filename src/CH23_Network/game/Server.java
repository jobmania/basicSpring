package CH23_Network.game;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Server extends JFrame {

    // 출력 UI
    private JTextArea textArea;

    // Client와 통신하기 위한 Socket
    private Socket socket = null;

    // 서버 생성을 위한 ServerSocket
    private ServerSocket serverSocket = null;

    // Client로부터 데이터를 읽어들이기 위한 입력스트림
    private BufferedReader inStream = null;

    // Client로 데이터를 내보내기 위한 출력 스트림
    private PrintWriter outStream = null;

    // 서버 포트
    private int port = 30000;

    // 랜덤숫자
    private int randomNumber = 0;

    // 남은 횟수
    private int remainCnt = 5;


    public Server() throws IOException {
        renderUI(); //UI창 만들기
        initServer(); // 서버소켓 생성
        doProcess(); // 클라 접속시 게임실행
    }

    /**
     * 클라이언트와 통신
     */

    private void doProcess() throws IOException {

        textArea.setText(" 클라이언트 접속 대기 .... \n");
        try {
            // 클라이언트 접속대기
            socket = serverSocket.accept();
            inStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outStream = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

            sendMessage("★★★ 서버에 접속되었습니다. ★★★ ");
            sendMessage("★★★ 게임을 시작합니다 ★★★");
            textArea.append("★★★ 유저 접속 ★★★\n");


            while (true) {

                String receiveMsg = receive();
                remainCnt--; // 맞출때마다 -1감소..
                textArea.append(String.format("받은 숫자 : %s \n", receiveMsg));

                if (Integer.parseInt(receiveMsg) > randomNumber) {
                    sendMessage(" 숫자가 큽니다. ");
                } else if (Integer.parseInt(receiveMsg) < randomNumber) {
                    sendMessage(" 숫자가 작습니다. ");
                } else {
                    sendMessage("정답");
                    break;
                }

                if (remainCnt == 0) {
                    sendMessage("정말 안타깝군요. 나의 승리입니다.");
                    break;
                } else {
                    sendMessage(String.format("추측 횟수가 %d회 남았습니다.", remainCnt));
                }

            }
        }catch (IOException e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }

    }


    /**
     * Client -> Server Msg
    * */
    private String receive() throws IOException {
        return inStream.readLine();
    }

    /**
    *  Server -> Client Msg
    * */
    private void sendMessage(String s) {
        outStream.println(s);
        outStream.flush();
    }






    /**
     * 서버초기화
     */
    private void initServer() {
        try {
            serverSocket = new ServerSocket(port);
            randomNumber = (int) (Math.random() * 50 + 1);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    /**
     * 화면 UI를 렌더링한다.
     * */
    private void renderUI() {
        this.setTitle("서버");

        textArea = new JTextArea(20, 30);
        textArea.setEditable(false);

        add( textArea , BorderLayout.CENTER);

        pack(); // 윈도우 창크기를 안에 내용에 맞게 조정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    public static void main(String[] args) throws IOException {
        new Server();
    }
}
