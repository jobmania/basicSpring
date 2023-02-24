package CH26_Stream;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(12);
        numbers.add(16);


        numbers.stream()
                .filter( a -> a < 10)  // 10보다 작은 것은 제거
                .map( a -> a*2)  // 하나씩 x 2
                .forEach(System.out::println);
        System.out.println("-----------------");
        numbers.forEach(System.out::println);


    }
}
