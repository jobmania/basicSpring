package CH23_Network.myServer;

import CH23_Network.socket.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer {
    public static void main(String[] args) throws IOException {
        BufferedReader in = null;
        PrintWriter out = null;

        ServerSocket serverSocket = null;
        Socket socket = null;

//        키보드 입력을 받기 위함.
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("[Server실행] Client 연결 대기중...");
            serverSocket = new ServerSocket(8000);
            socket = serverSocket.accept();

            // 클라이언트 연결
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());


            while(true){


                String inputMessage = in.readLine(); // 수신데이터 한줄씩 읽기



                if("quit".equalsIgnoreCase(inputMessage)) break; // 종료

                System.out.println("From Client: " + inputMessage);
                System.out.println("전송하기 >>>>  ");
                String outputMessage = scanner.nextLine(); // 전송할 데이터 입력.....
                out.println(outputMessage);
                out.flush(); // 소켓에 전송....
                if("quit".equalsIgnoreCase(outputMessage)) break; // 종료

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            scanner.close();
            if (serverSocket != null)  serverSocket.close();
            if (socket != null) socket.close();
            System.out.println("연결종료");
        }


    }
}
