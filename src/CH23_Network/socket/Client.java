package CH23_Network.socket;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 9500);  // 접속하려는 ip,port
            System.out.println("연결 성공..");

            //             1. 클라이언트 => 소켓
            String msg = " 보내는 메세지야 안녕하세요!";
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            writer.println(msg);
            writer.flush(); // 버퍼를 ㅣ비운다 ==> 전송!!
            System.out.println(" 내가 안녕 하세요 보냈다고 !");

//           2. 소켓 => 클라이언트
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = reader.readLine();
            System.out.println("서버에서 받은 메시지 : " + line);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
