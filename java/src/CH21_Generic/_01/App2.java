package CH21_Generic._01;

import CH21_Generic._01.Collections.Pair;
import CH21_Generic._01.hierarchy.Cat;

public class App2 {
    public static void main(String[] args) {
        Pair<Integer, Cat> pair = new Pair<>(5, new Cat("하입보이"));

        System.out.println(pair);
        System.out.println(pair.getValue());
        System.out.println(pair.getValue2());


    }
}
