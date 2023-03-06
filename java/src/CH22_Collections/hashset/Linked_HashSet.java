package CH22_Collections.hashset;

import java.util.LinkedHashSet;

public class Linked_HashSet {
    public static void main(String[] args) {
        // 순서 보장
        LinkedHashSet<String> strings = new LinkedHashSet<>();
        strings.add("무");
        strings.add("모");
        strings.add("모");
        strings.add("마");
        strings.add("망가");
        strings.add("망각");
        strings.add("혼돈");
        strings.add("혼돈");
        strings.add("강혼돈");
        strings.add("무");

        System.out.println(strings);
        System.out.println(strings.contains("망각"));

    }
}
