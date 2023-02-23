package CH24_Lamda._4_lamda_Interface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class ReplaceAll {

    public static void main(String[] args) {

        // replaceAll 각각의 아이템의 연산 결과로 대체한다.

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(3);
        numbers.add(4);
        numbers.add(7);
        numbers.add(9);

        // 1
        numbers.replaceAll(new UnaryOperator<Integer>(){
            @Override
            public Integer apply(Integer integer) {
                return integer * integer;
            }
        });
        numbers.forEach(t -> System.out.println(t));

        // 2
        numbers.replaceAll(n -> n * n);

        numbers.forEach(t -> System.out.println(t));

        System.out.println("===============");
        List<String> friends = new ArrayList<String>();
        friends.add("무현");
        friends.add("명박");
        friends.add("근혜");
        friends.add("재인");

        friends.replaceAll(s -> "안녕~ " + s);

        friends.forEach(t -> System.out.println(t));
    }
}
