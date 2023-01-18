package CH14_oop.timer;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
//        Timer timer =   new Timer();
//        timer.scheduleAtFixedRate(new Task(),0L,1000L);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(new Task(), 0, 1, TimeUnit.MINUTES);

    }
}

class Task extends TimerTask{

    @Override
    public void run() {
        System.out.println("헬로우!!");
    }
}