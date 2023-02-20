package CH23_Network;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 9500);  // 접속하려는 ip,port
            System.out.println("연결 성공..");

            //             1. 클라이언트 => 소켓
            String msg = "내가 클라이언테으ㅔ서 보내는 메세ㅈ야 안녕하세요!";
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            writer.println(msg);
            writer.flush(); // 버퍼를 ㅣ비운다 ==> 전송!!
            System.out.println(" 내가 안녕 하세요 보냈다고 !");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
