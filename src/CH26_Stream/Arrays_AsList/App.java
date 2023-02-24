package CH26_Stream.Arrays_AsList;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {

        System.out.println();
        String[] items = {"치킨","원숭이","고릴라","치약","고라니","치과","고양이"};

        //배열을 리스트로
        List<String> list = Arrays.asList(items);
        list.stream()
                .filter(x -> x.startsWith("고")) //고릴라, 고라니, 고양이
                .sorted()                        //고라나 고릴라 고양이 (정렬)
                .forEach(x -> System.out.print(x + ", "));

        System.out.println("============");

        // 배열을 스트림으로
        int[] nums = { 9, 4, 6, 3, 1, 2, 7};
        Arrays.stream(nums)
                .filter(n -> n > 3)  //9,4,6,7
                .sorted()			 //4,6,7,9
                .map(s -> s * 10)	 //40,60,70,90
                .forEach(System.out::println);

        System.out.println("============");



        // Arrays.asList(배열) => 리스트로
        List<String> names = Arrays.asList("Eric", "Elena", "Java");

        names.stream()
                .filter(name -> name.contains("a"))  // 거짓일 경우 제거 , Eric 제거.
                .map(String::toUpperCase)
                .forEach(System.out::println);

        System.out.println("============");

        List<Integer> numbers = Arrays.asList(9,4,6,3,1,2,7);

        numbers.stream()
                .filter(n -> n>3) // 9,4,6,7
                .sorted()  // 오름차순
                .map(s->s*10)
                .forEach(System.out::println);


    }
}
