package CH19_Exception.throw_exception3;

public class Thermostat {


    // throw 예외  : 이 메소드를 호출할때 이 예외를 처리하게한다...
    public void setTemperature(double temperature) {

        setMachineTemperature(temperature);


        System.out.println("온도 느매"  + temperature);
    }

    private void setMachineTemperature(double temperature) {
        if(temperature < 0 || temperature > 35){
            throw new RuntimeException("응 온도 비정상 ㄲㅉ");
        }
    }

}
