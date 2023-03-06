package CH23_Network.multithread;

public class App1 {
    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                // 실행 계획
                for (int i = 0; i < 100; i++) {
                    System.out.println(i  + " < ");
                    try {
                        Thread.sleep(500);  // 0.5 sleep

                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        // 쓰레드 생성시 Runnable 구현한 객체가 필요함..
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();

        System.out.println("메인스레드 내용 !! ");   // 메인스레드

    }
}
