package CH26_Stream;

import java.util.stream.IntStream;

public class Int_Stream {
    public static void main(String[] args) {

        IntStream
                .range(1, 10) // 1부터 9까지 정수
                .skip(5)  // 5개 넘긴다. 즉 6~9출력
                .forEach(x -> System.out.println(x));


        System.out.println();

        int val = IntStream.range(1, 2).sum(); // 1 2 3 4 까지의 합
        System.out.println(val);
    }
}
