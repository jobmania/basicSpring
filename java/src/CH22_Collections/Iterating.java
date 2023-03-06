package CH22_Collections;

import java.util.ArrayList;

public class Iterating {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(7);
        list.add(57);
        list.add(72);
        list.add(17);
        list.add(57);
        list.add(87);
        list.add(74);

        for (Integer integer : list) {
            System.out.println("integer = " + integer);
        }

    }
}
