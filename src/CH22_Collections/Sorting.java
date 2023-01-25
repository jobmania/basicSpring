package CH22_Collections;

import java.util.ArrayList;
import java.util.Collections;

public class Sorting {

    public static void main(String[] args) {
        ArrayList<Double> doubles = new ArrayList<>();

        doubles.add(7.53);
        doubles.add(9.53);
        doubles.add(7.43);
        doubles.add(6.9);

        Collections.sort(doubles);  // 오름차순 정렬


        System.out.println(doubles);

    }
}
