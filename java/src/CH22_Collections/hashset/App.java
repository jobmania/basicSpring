package CH22_Collections.hashset;

import java.util.HashSet;

public class App {
    public static void main(String[] args) {
        HashSet<String> strings = new HashSet<>();
        // set은 인덱스가 없으며, 중복 x, 순서가 없다..
        strings.add("무");
        strings.add("모");
        strings.add("모");
        strings.add("마");
        strings.add("망가");
        strings.add("망각");
        strings.add("혼돈");

        System.out.println(strings);
        System.out.println(strings.contains("망각"));
    }
}
