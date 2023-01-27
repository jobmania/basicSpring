package CH22_Collections.hash_map;

import java.util.HashMap;

public class App {
    public static void main(String[] args) {

        HashMap<Integer, String> people = new HashMap<>();

        people.put(1, "가재");
        people.put(2, "게");
        people.put(3, "푸들");
        people.put(4, "뚜울");

        // 람다 식 -> 다음 코드실행
        people.forEach((k,v) -> System.out.println("키값: "+k+ " 값 : " + v));

        System.out.println(people.get(3));

    }
}
