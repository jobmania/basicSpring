package CH22_Collections.hashset;

import java.util.TreeSet;

public class Tree_Set {
    public static void main(String[] args) {

        // 정렬 o
        TreeSet<Integer> list = new TreeSet<>();
        list.add(3);
        list.add(23);
        list.add(43);
        list.add(13);
        System.out.println(list);


        TreeSet<String> strings = new TreeSet<>();
        strings.add("abc");
        strings.add("aaa");
        strings.add("aaa");
        strings.add("baa");
        strings.add("caa");
        strings.add("cba");
        System.out.println(strings);


        TreeSet<Person> people = new TreeSet<>();
        people.add(new Person("엄"));
        people.add(new Person("엄1"));
        people.add(new Person("엄4"));
        people.add(new Person("엄3"));
        people.add(new Person("엄"));

        // 해당 클래스는 implements Comparable<Person>로 인터페이스를 구현하여서 중복을 제거.
        System.out.println(people);
    }
}

class Person implements Comparable<Person>{
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return name.compareTo(o.name);
    }
}
