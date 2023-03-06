package CH19_Exception.throw_exception3;

public class App {
    public static void main(String[] args)  {
        Thermostat thermostat = new Thermostat();
//        thermostat.setTemperature(60);
        try {
            thermostat.setTemperature(200);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
