package CH22_Collections;

import java.util.ArrayList;
import java.util.Collections;

public class Custom_Object {

    public static void main(String[] args) {

        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("엄준식"));
        list.add(new Person("332"));
        list.add(new Person("카라3"));
        list.add(new Person("엄식4"));
        list.add(new Person("준식5"));

        list.set(0, new Person("김찬호"));


        Collections.sort(list);  // 문자 Comparable를 구현해야함.. 그래야지 비교해서 정렬 가능.

        for (Person person : list) {
            System.out.println("person = " + person);
        }
    }
}


class Person implements Comparable<Person> {
    String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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