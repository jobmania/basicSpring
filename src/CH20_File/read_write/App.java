package CH20_File.read_write;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) throws IOException {
        String text = "헬로우 ~2";

        Path path = Paths.get("text.txt");
//        Path path = Paths.get("C:\\User\\admin\\text.txt");
        Files.write(path, text.getBytes());

        //파일 읽기
        String readText = Files.readString(path); // 문자열로 읽기
        System.out.println(readText);
    }
}
