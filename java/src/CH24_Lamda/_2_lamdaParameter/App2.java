package CH24_Lamda._2_lamdaParameter;

public class App2 {
    public static void main(String[] args) {

        Runner2 run = (n ,t) -> {
            System.out.println( n +  " + " + t );
        };

        run.execute("담원", "티원");

        // 메소드를 통해서
        greet(run);
    }


    private static void greet(Runner2 run){
        run.execute("무기","악마");
    }


}

interface Runner2{
    void execute(String name, String text);
}