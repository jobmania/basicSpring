package CH25_MethodReference;

public class App2 {

    public static void main(String[] args) {
        Greeter g1 = () -> System.out.println("엄");
        g1.greet();

        Greeter g2 = App2::sayHello;
        g2.greet();

    }

    private static void sayHello(){
        System.out.println("엄준식화이팅");
    }
}

interface Greeter{
    void greet();
}