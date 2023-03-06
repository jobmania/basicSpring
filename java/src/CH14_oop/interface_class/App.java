package CH14_oop.interface_class;

public class App {
    public static void main(String[] args) {

        Describable[] objects = {new Computer(), new Person()};

        for (Describable object : objects) {
             System.out.println(object.getDescription());
        }

    }
}
