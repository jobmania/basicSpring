package CH26_Stream;

import java.util.stream.Stream;

public class App2 {
    public static void main(String[] args) {
        // Stream.of(T t ) 입력하는 데이터에 따라..
        Stream.of("엄","중","식").forEach(System.out::println);
        Stream.of(112,3,678).forEach(System.out::println);

        System.out.println();
        // limit(int)까지 generate 하기
        Stream.generate(() -> "헬로우").limit(5).forEach(System.out::println);
    }
}
