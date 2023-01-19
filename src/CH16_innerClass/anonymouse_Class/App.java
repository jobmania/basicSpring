package CH16_innerClass.anonymouse_Class;

public class App {


    public static void main(String[] args) {
        new App().start();
    }

    private void start() {
       String name = "엄준식";
        Runnable runner = new Runnable() { //익명클래스  인터페이스속성으로 생성.
            @Override
            public void run() {
                System.out.println(name);
            }
        };
        runner.run();
    }
}
