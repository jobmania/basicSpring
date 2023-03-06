package CH22_Collections.exam;

public class MeterExam {
    public static void main(String[] args) {

        Taxi taxi = new Taxi();
        taxi.start();
        taxi.stop(2500);
    }
}

interface Meter{
    public int BASE_FARE = 3000;
    public abstract void start();

    public abstract void stop(int distance);

}

class Taxi implements Meter{

    @Override
    public void start() {

    }

    @Override
    public void stop(int distance) {
        System.out.println(BASE_FARE + 2 *distance + " 입니다");
    }
}