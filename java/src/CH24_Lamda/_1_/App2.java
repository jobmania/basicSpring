package CH24_Lamda._1_;

public class App2 {
    public static void main(String[] args) {
        Runner runner = () -> {
            System.out.println("헬로우!");
        } ;

        // 해당 메소드 실행 ..
        runner.execute();

    }
}

interface Runner{
    void execute();
}
