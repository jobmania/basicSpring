package CH09_hangman;

import java.util.Scanner;

public class HangMan {

    private boolean running = true;
    private RandomWord randomWord = new RandomWord();
    private Scanner scanner;

    public HangMan() {
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        do {
            this.displayWord();
            this.getUserInput();
            this.checkUserInput();
        } while(this.running);

    }

    private void displayWord() {
        System.out.println(this.randomWord);
    }

    private void getUserInput() {
        System.out.print("한 문자 입력 : ");
        String guess = this.scanner.nextLine();
        char ch = guess.charAt(0);
        this.randomWord.addGuess(ch);
    }

    private void checkUserInput() {
        if (this.randomWord.isCompleted()) {
            System.out.println("잘 맞췄어요!");
            System.out.println("정답은 : " + this.randomWord.toString());
            this.running = false;
        }

    }

    public void close() {
        this.scanner.close();
    }
}
