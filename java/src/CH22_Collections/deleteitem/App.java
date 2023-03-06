package CH22_Collections.deleteitem;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        List<Cat> cats = new ArrayList<>();
        Cat c1 = new Cat("랄로");
        cats.add(c1);

        Cat c2 = new Cat("파카");
        Cat c3 = new Cat("도파");
        Cat c4 = new Cat("미야");

        cats.add(c2);
        cats.add(c3);
        cats.add(c4);

        cats.remove(1);
        cats.remove(c1);

    }



}


class Cat{
    private String name;

    public Cat(String name) {
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
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}