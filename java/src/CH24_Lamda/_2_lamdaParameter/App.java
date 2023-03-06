package CH24_Lamda._2_lamdaParameter;

public class App {
    public static void main(String[] args) {
        Runner runner = (t) -> {
            System.out.println(t);
        };

        runner.execute("엄준식");

        Runner runner2 = (s) -> {
            System.out.println(s);
        };

        runner2.execute("무자식");
    }
}

interface Runner{
    void execute(String text);
}