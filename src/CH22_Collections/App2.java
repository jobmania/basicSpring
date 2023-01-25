package CH22_Collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class App2 {

    public static void main(String[] args) {


        List<Integer> numbers = new LinkedList<>();  // ArrayList, LinkedList 호환 가능.함.

        numbers.add(2);
        numbers.add(23);
        numbers.add(24);
        numbers.add(25);
        displayList(numbers);



        List<Integer> numbers2 = new ArrayList<>();  // ArrayList, LinkedList 호환 가능.함.

        numbers.add(2);
        numbers.add(23);
        numbers.add(24);
        numbers.add(25);
        displayList(numbers);



    }

    private static void displayList(List<Integer> numbers) {
        for (Integer number : numbers) {
            System.out.println(number);
        }
    }


}
