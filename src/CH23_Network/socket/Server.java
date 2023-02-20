package CH23_Network.socket;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9500);

            while(true){

                // 대기 연결을 기다리는 중
                System.out.println("연결 기다리는 중 ! ");
                Socket socket = serverSocket.accept();
                InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
                System.out.println("연결 수락됨. 이름은" + isa.getAddress());

                // 소켓 => 서버
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String line = reader.readLine();
                System.out.println("서버에서 받은 메시지 : " + line);

                // 서버 => 소켓
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
                writer.println("Server to Client"+line);
                writer.flush(); // 버퍼를 비운다 ==> 전송!!

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
