package CH25_MethodReference;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class App {

    // 메소드 레퍼런스로 사용될 메소드.
    public static void greet(){
        System.out.println("엄");

    }
    public static void main(String[] args) {
        ScheduledExecutorService service = new ScheduledThreadPoolExecutor(1);

        //1초 반복
        service.scheduleAtFixedRate(() -> App.greet(), 0, 1000, TimeUnit.MILLISECONDS);
        // ->  동일한 식
        service.scheduleAtFixedRate(App::greet, 0, 1000, TimeUnit.MILLISECONDS);

    }
}
