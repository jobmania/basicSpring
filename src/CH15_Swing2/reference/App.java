package CH15_Swing2.reference;

public class App {
    public static void main(String[] args) {
        Person p1 = new Person();
        System.out.println(p1);
        Person p2 = p1;

        test(p2);
    }

    private static void test(Person p2) {
        System.out.println(p2);

    }
}
