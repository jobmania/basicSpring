package CH22_Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TestArray {
    public static void main(String[] args) {


        ArrayList<Double> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("입력해라 숫자 or 'q' ");



            String s = scanner.nextLine();
            String trim = s.trim();  // 공백삭제

            if(trim.equalsIgnoreCase("Q")){
                scanner.close();
                System.out.println("종료다 임마");
                break; // 소문자 대문자 둘다 동일하게 취급
            }



            Double d = Double.parseDouble(trim);
            numbers.add(d);

            System.out.println("입력된 것은?   ");
            System.out.println(d);
            double total = 0;
            try{
                for (Double number : numbers) {

                    total += number;

                }
                Collections.sort(numbers);
                System.out.println(numbers);
                System.out.println("평균값 " + total/numbers.size() );
            } catch (NumberFormatException e){
                System.out.println(e.getMessage());

            }
        }

    }
}
