package CH19_Exception.try_catch;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("입력" );
        String line = scanner.nextLine();

        int number =0;
        Boolean isNumber = true;
        try {
            // 예외 발생 가능한 코드
            number = Integer.parseInt(line);
            System.out.println(number +" 이다");
        }catch (NumberFormatException e){
            System.out.println("응 에러 시발.");
        }finally {

            System.out.println("응 이제 꺼져");
            scanner.close();



        }
    }
}
