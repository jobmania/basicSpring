package CH12_method_overloading.methodoverloading;

public class App {

    public static void main(String[] args) {
        Person person = new Person();
        person.greet();
        person.greet("인간아");
        person.greet("시바이누");
        person.greet(188);
        person.greet(188, "시바이누");


    }
}
