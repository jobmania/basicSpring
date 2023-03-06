package CH26_Stream.String_Array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        // 리스트 => .stream()
        // 리스트가 아닐경우  1. Stream.of(1,2,3) 정수형스트림 Stream.of('하나','둘') 문자열스트림
        //                2. 배열일경우 Array.stream(배열입력)

        Stream.of("Hello","Bottle","Africa")
                .sorted() // 정렬 ; 알파벳순..
                .findFirst()
                .ifPresent(System.out::println);


        System.out.println("=====================");

        //// 문자 배열...
        String[] items = {"치킨","원숭이","고릴라","치약","고라니","치과","고양이"};
        Stream.of(items) //배열을 입력해서 스트림 생성
                .filter(s -> s.startsWith("치")) //필터는 참이면 남기고 거짓이면 제거한다.
                .forEach(x -> System.out.print(x + ", "));

        System.out.println();
        System.out.println("====================");
        int[] numbers = {1, 234,87,69,50};
        Arrays.stream(numbers)
                .map(x -> x * x)
                .average() // 평균
                .ifPresent(System.out::println);




    }
}
