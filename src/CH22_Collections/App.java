package CH22_Collections;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(7);
        list.add(5);
        list.add(9);
        list.add(11);

        //람다식
        list.forEach( (v) -> System.out.println(v) ) ;

        ArrayList<String> stringArrayList = new ArrayList<>();

        stringArrayList.add("엄");
        stringArrayList.add("준");
        stringArrayList.add("랄");
        stringArrayList.add("식");

        //람다식
        stringArrayList.forEach(System.out::println) ;

    }
}
