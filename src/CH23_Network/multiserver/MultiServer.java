package CH23_Network.multiserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MultiServer {

    public static void main(String[] args) {
        MultiServer multiServer = new MultiServer();
        multiServer.start();
    }

    public void start() {
        ServerSocket serverSocket = null;
        Socket socket = null;


        try {
            serverSocket = new ServerSocket(8000);
            while(true){
                System.out.println("[클라이언트 연결 대기중..]");
                socket = serverSocket.accept();

//            client 가 접속할때마다 새로운 스레드를 생성..
                ReceiveThread receiveThread = new ReceiveThread(socket);
                receiveThread.start();

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
class ReceiveThread extends Thread {

    // 바 컬렉션과 동기화(Java Collection Synchronization)
    // 각각의 스레들이 공유하는 출력리스트(동시 스레드 사용시 에러방지..)

    static List<PrintWriter> list =
            Collections.synchronizedList(new ArrayList<PrintWriter>()); //멀티 스레드 충돌방지


    Socket socket;
    BufferedReader in;
    PrintWriter out ;

    public ReceiveThread (Socket socket) throws IOException {
        this.socket = socket;
        out = new PrintWriter(socket.getOutputStream());
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        list.add(out); // 출력스트림을 리스트에 저장..
    }


    @Override
    public void run() {
        ///

    }


    private void sendAll (String s ){
        for( PrintWriter out : list){
            out.println(s);
            out.flush();
        }
    }

}
