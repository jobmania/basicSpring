package CH12_method_overloading.defaultconstructor;

public class App {

    public static void main(String[] args) {
        Person person1 = new Person("준식");
        Person person2 = new Person();
        Person person3 = new Person("인욱",51);

        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);

    }
}
