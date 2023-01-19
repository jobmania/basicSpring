package CH14_oop.timer;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {


        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("헬로우~~~");
            }
        }, 0, 1, TimeUnit.MINUTES);




    }
}

class Task extends TimerTask{

    @Override
    public void run() {
        System.out.println("헬로우!!");
    }
}