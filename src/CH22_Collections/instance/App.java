package CH22_Collections.instance;


import java.io.Serializable;

public class App {
    public static void main(String[] args) {

        Creature c1 = new Creature();
        Object c2 = c1;
        Cat c3 = new Cat();
        Serializable c4 = (Serializable) c3;

        System.out.println(c3 instanceof Object);
        System.out.println(c3 instanceof Serializable);
        System.out.println(c3 instanceof Creature);
        System.out.println(c3 instanceof Cat);
        // instanceof 객체 타입을 본다.

    }


}

class Creature implements Serializable{
    private static final long serialVersionUID = 1L;

}

class Cat extends Creature{
    private static final long serialVersionUID = 1L;
}