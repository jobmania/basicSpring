package CH11_가위바위보.game;

import CH11_가위바위보.game.object.GameObject;
import CH11_가위바위보.game.object.Paper;
import CH11_가위바위보.game.object.Rock;
import CH11_가위바위보.game.object.Scissors;

import java.util.Random;
import java.util.Scanner;

public class Game {

    GameObject [] objects = { new Scissors(), new Rock() , new Paper()};

    Random random = new Random();

    Scanner scanner = new Scanner(System.in);

    private int [][] comparison = {{0,-1,1},{1,0,-1},{-1,1,0}};  // 가위 0 바위 1 보 2


    public void run() {
        System.out.println("게임 시작 ....");

        int count = 0;
        int sum = 0;

        while(count < 3){

            System.out.print("입력 해봐 : 0, 1, 2 만 선택 가능 ===> ");
            int num;

            while (true){
                num = scanner.nextInt();
                if(num ==1 || num == 0 || num == 2){
                    break;
                }
                System.out.println(" 0, 1, 2, 만 가능하다 다시입력");
            }


            int num2 = random.nextInt(objects.length);
            GameObject object1 = objects[num];
            GameObject object2 = objects[num2];

            int myNum = comparison[num][num2];
            System.out.println("내가 낸 것은 " + objects[num].getName());
            System.out.println("상대 낸 것은 " + objects[num2].getName());


            switch (myNum){
                case 0:
                    System.out.println("너는 비겼다 ");
                    sum += myNum;
                    break;
                case 1:
                    System.out.println("너는 이겼다 ");
                    sum += myNum;
                    break;
                case -1:
                    System.out.println("너는 졌다 ");
                    sum += myNum;
                    break;
            }
            count++;
        }


        if(sum>1){
            System.out.println("이김");
        } else if (sum ==0) {
            System.out.println("비김");
        } else {
            System.out.println("짐");
        }


    }
}
