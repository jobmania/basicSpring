package CH23_Network.multithread;

public class App2 {

    private int value = 0;

    private synchronized void increment(){
        value++;
    }


    public void run() throws InterruptedException {
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 50; i++) {
//                    value++;
//                }
//            }
//        };

        Runnable runnable = () -> {
            for (int i = 0; i < 9000; i++) {
                increment();
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t1.start();
        t2.start();


        t1.join();  // t1 끝날때까지 대기
        t2.join();  // t2 끝날때까지 대기

        System.out.println(value + " << value ");


    }

    public static void main(String[] args) throws InterruptedException {
        new App2().run();
    }
}