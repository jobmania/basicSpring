package CH26_Stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class File_Stream {
    public static void main(String[] args) {
        try {
            //자바의 Files 클래스의 lines 메소드는 해당 파일의 각 라인을 스트링 타입의 스트림으로 만들어줍니다.
            Files.lines(Path.of("C:\\Users\\admin\\IdeaProjects\\java\\text.txt"))
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
