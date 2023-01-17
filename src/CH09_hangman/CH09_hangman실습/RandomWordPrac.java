package CH09_hangman.CH09_hangman실습;

import java.util.Random;

public class RandomWordPrac {

    // 랜덤 문자를 만들고 이를 변환하고 검사하는 로직
    private String books = "improve assessment member motivation affect suspect unfortunate " +
            "available business girlfriend gutter transition liability classroom executive define " +
            "operational descent judgment champion variable referral advertising flawed improvement " +
            "crackpot personal performance inquiry civilization";




    public String SelectWords(){   // 랜덤 단어 선택
        String[] strings = books.split(" ");
        Random random = new Random();
       return strings[random.nextInt(strings.length)];
    }

    public String hideWords(String word){  // 단어를  _ _ _ _ 로 변환.
        StringBuilder sb = new StringBuilder();
        char[] chars = word.toCharArray(); /// 단어를 character 배열로 변환...

        for (char c : chars) {
            sb.append("_");

        }
        return sb.toString();
    }





}
