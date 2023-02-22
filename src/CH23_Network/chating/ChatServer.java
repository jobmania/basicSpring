package CH23_Network.chating;

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer  {

    ServerSocket serverSocket;
    List<ChatHandler> list = new ArrayList<>();

    public ChatServer() {
        try {
            this.serverSocket = new ServerSocket(9500);


            while(true){
                Socket socket = serverSocket.accept();
                ChatHandler handler = new ChatHandler(socket,list);  /// Thread thread = new Thread();
                handler.start();
                list.add(handler);  // 리스트에 각각의 클라이언트 해늘러 객체 추가.

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new ChatServer();
    }
}
