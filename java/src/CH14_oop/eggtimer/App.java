package CH14_oop.eggtimer;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class App {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new Task1(),0,5000);
        Timer timer1 = new Timer();
        timer1.scheduleAtFixedRate(new Task1(),0,30000);
    }
}

class Task1 extends TimerTask {

    @Override
    public void run() {
        System.out.println("계란 삶는 중");

    }
}

class Task2 extends TimerTask {

    @Override
    public void run() {

        JOptionPane.showConfirmDialog(null, "계란삶기 완료");
    }
}

