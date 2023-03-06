package CH24_Lamda._4_lamda_Interface;

import java.util.ArrayList;
import java.util.List;

public class RemoveIf {

    public static void main(String[] args) {
        // 특정 타입(제네릭)을 검사해서(test) boolean 참,거짓으로 리턴한다.
        List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(5);
        numbers.add(7);
        numbers.add(2);
        numbers.add(9);
        numbers.add(10);
        numbers.add(4);

        // 리스트에 아이템들을 검사해서 참이면 삭제
        numbers.removeIf(n -> n > 6);

        numbers.forEach(t -> System.out.println(t));
    }
}
