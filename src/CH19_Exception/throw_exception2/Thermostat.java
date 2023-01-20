package CH19_Exception.throw_exception2;

public class Thermostat {


    // throw 예외  : 이 메소드를 호출할때 이 예외를 처리하게한다...
    public void setTemperature(double temperature) throws Exception {

        setMachineTemperature(temperature);


        System.out.println("온도 느매"  + temperature);
    }

    private void setMachineTemperature(double temperature) throws Exception {
        if(temperature < 0 || temperature > 35){
            throw new Exception("응 온도 비정상 ㄲㅉ");
        }
    }

}
