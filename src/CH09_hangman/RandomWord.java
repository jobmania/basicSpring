package CH09_hangman;

import java.util.Random;

public class RandomWord {

    private String books = "improve assessment member motivation affect suspect unfortunate " +
            "available business girlfriend gutter transition liability classroom executive define " +
            "operational descent judgment champion variable referral advertising flawed improvement " +
            "crackpot personal performance inquiry civilization";

    private String[] words;
    private String selectWord;
    private Random random;
    private char[] characters;

    public RandomWord() {
        this.words = this.books.split(" ");
        this.random = new Random();
        this.selectWord = this.words[this.random.nextInt(this.words.length)];
        this.characters = new char[this.selectWord.length()];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        char[] var5;
        int var4 = (var5 = this.characters).length;

        for(int var3 = 0; var3 < var4; ++var3) {
            char c = var5[var3];
            sb.append(c == 0 ? '_' : c);
            sb.append(' ');
        }

        return sb.toString();
    }

    public void addGuess(char c) {
        for(int i = 0; i < this.selectWord.length(); ++i) {
            if (c == this.selectWord.charAt(i)) {
                this.characters[i] = c;
            }
        }

    }

    public boolean isCompleted() {
        char[] var4;
        int var3 = (var4 = this.characters).length;

        for(int var2 = 0; var2 < var3; ++var2) {
            char c = var4[var2];
            if (c == 0) {
                return false;
            }
        }

        return true;
    }
}
