package CH24_Lamda._4_lamda_Interface;

import java.util.function.Predicate;

public class PredicateEX {

    public static void main(String[] args) {
        // 특정타입(제네릭)을 검사test해서 참,거짓으로 리턴..
        Predicate<String> p1 = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() < 4;
            }
        };

        System.out.println("p1.test() = " +  p1.test("가나다"));
        System.out.println("p1.test() = " +  p1.test("가나다라"));


    }
}
