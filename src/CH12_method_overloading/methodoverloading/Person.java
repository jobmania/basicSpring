package CH12_method_overloading.methodoverloading;

public class Person {

    // 매개변수(파라미터)가 잇는 메소드와 없는 메소드를 구분한다.

    public void greet(){
        System.out.println("환영~");
    }


    public void greet(String num){
        System.out.println(num +" 환영~");
    }

    public void greet(int num){

        if(num > 185){
            System.out.println(num +"cm다 응~~");
        }
        System.out.println(" 환영~");
    }

    public void greet(int num, String name){

        if(num > 185){
            System.out.println(name+ "야  " + num +"cm다 응~~");
        }
        System.out.println(name + " 환영~");
    }

}
