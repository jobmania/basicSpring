package CH09_hangman.pratice;

import java.util.Scanner;

public class HangManPrac {

    // 랜덤 글자를 부여 받고, 유저가 입력하고, 이를 검사하는 로직..

    private String randomWord ;
    private String hidingWord;
    private Scanner scanner = new Scanner(System.in);


    public void select(){   // 랜덤 문자 선택..
        RandomWordPrac random = new RandomWordPrac();
        this.randomWord = random.SelectWords();
        this.hidingWord = random.hideWords(randomWord);
    }

    public void run() {

        while(true){

            System.out.println("문제는 " + hidingWord);
            System.out.print("한 문자 입력 : ");
            String guess = this.scanner.nextLine();  //  nextLine()메소드는 Enter를 치기 전까지 쓴 문자열을 모두 리턴


            char checkC;
            // 한글자만 검사
            if(guess.length()==1){
                checkC = guess.charAt(0);
            }else {
                System.out.println("한글자만 입력해요");
                System.out.println(" ");
                continue;
            }



            char[] hideChars = hidingWord.toCharArray(); /// 단어를 character 배열로 변환...




            char[] randChars = randomWord.toCharArray();

            for( int i = 0 ; i < hideChars.length ; i++){
                if(checkC == randChars[i]){
                    hideChars[i]=checkC;
                }
            }

            // chars 배열을 다이 hide에 넣어준다.
            String str = String.valueOf(hideChars);
            this.hidingWord = str;


            // 검사

            if(randomWord.equals(hidingWord)) {
                System.out.println("답은 " + randomWord);
                System.out.println("문제를 푸셨습니다.");
                this.scanner.close();
                break;
            }

        }



    }


}
