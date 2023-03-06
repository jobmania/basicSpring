package CH23_Network.multithread;

public class MultiThread {
    public static void main(String[] args) {
//        longTask();

//        ---------------
//        Runnable task = new Runnable() {
//            @Override
//            public void run() {
//                longTask();
//            }
//        };
//        --------


//        Thread t1 = new Thread(new LongTask());
//        t1.start();

        Runnable task = () -> longTask();
        Thread t2 = new Thread(task);
        t2.start();  // 멀티쓰레드로 실행

        System.out.println("메인스레드 실행..");

    }

    static class LongTask implements Runnable{
        @Override
        public void run() {
            longTask();
        }
    }


    public static void longTask() {
        long t= System.currentTimeMillis();
        long end = t + 3000; // 3초 더하기

        while(true) {
            if (System.currentTimeMillis() >= end) {
                System.out.println("긴 작업 종료");
                break; // 3초 정도 대기하다가 빠져나감
            }
        }
    }
}
