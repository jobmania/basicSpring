package CH20_File.write_line;

import java.io.*;

public class App {


    public static void main(String[] args) {

        String fileLocation = "C:\\Users\\admin\\test\\test2.txt";
        try(BufferedWriter reader = new BufferedWriter(new FileWriter(fileLocation))) {
           reader.write("이걸?~!~");
           reader.newLine();
            reader.write("2400~!~");
            reader.newLine();
            reader.write("자 죽자~!~");
            reader.newLine();
            reader.write("2400~!~");
            reader.newLine();

        } catch (IOException e) {
            System.out.println(e.getMessage() +"파일없어 ");
        }

    }
}
