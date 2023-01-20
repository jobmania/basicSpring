package CH21_Generic._01;


import CH21_Generic._01.Collections.Wrapper;
import CH21_Generic._01.hierarchy.Cat;
import CH21_Generic._01.hierarchy.Creature;

public class App {

    public static void main(String[] args) {

        Cat cat1 = new Cat("호랑이");
        Wrapper<Cat> wrapper = new Wrapper<>();
        wrapper.setObject(cat1);
        Cat cat2 = wrapper.getObject();
        System.out.println(cat2);

        Creature cr1 = new Creature("우흐");
        Wrapper<Creature> wrapper2 = new Wrapper<>();
        wrapper2.setObject(cr1);
        Creature object2 = wrapper2.getObject();
        System.out.println(object2);

    }
}
