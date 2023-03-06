package CH19_Exception.try_catch;

import java.util.Scanner;

public class App2 {

    static Scanner scanner = new Scanner(System.in);
    public static int getNumber() {

        System.out.println("방구뽕 : ");
        String line = scanner.nextLine();

        int number =0;
        while(true){
            try {
                // 예외 발생 가능한 코드
                number = Integer.parseInt(line);
                System.out.println(number +" 이다");
            }catch (NumberFormatException e){
                System.out.println("응 에러 시발.");
                break;
            }finally {
                System.out.println("응 이제 꺼져");

            }
        }

        scanner.close();

        return number;

    }
}
