package CH24_Lamda._5_Prac;

import java.util.ArrayList;
import java.util.List;

public class Exercise {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(9);
        list.add(1000);
        list.add(3);
        list.add(6);
        list.add(-20);
        list.add(4);

        /*
         * 0~10 값이 아닌 값들은 모두 제거
         * 그다음, 각 아이템들에 + 100 을 한다.
         * 그 결과를 콘솔에 표시
         *
         */

        list.removeIf(i -> i < 0 || i >10); // 0~10 값이 아닌 값들은 모두 제거
        list.forEach(System.out::println);
        list.replaceAll(i -> i + 100); // 각 아이템들에 + 100 을 한다.
        list.forEach(i -> System.out.println(i));
        // list.forEach(::); [인스턴스]::[메소드명(또는 new)] / 람다식이 건네는 파라미터와 받는 쪽의 파라미터가 동일할 때
        // println이 메소드명
        list.forEach(System.out::println);








    }
}
