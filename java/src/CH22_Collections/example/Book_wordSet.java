package CH22_Collections.example;

import java.io.*;
import java.util.Iterator;
import java.util.TreeSet;

public class Book_wordSet {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\admin\\IdeaProjects\\java\\src\\CH22_Collections\\example\\gatsby.txt");

        System.out.println(file.exists());

        TreeSet<String> frList = loadWorks(file);

        displayWords(frList);



    }

    private static void displayWords(TreeSet<String> frList) {

        int count = 0;
        for (String s : frList) {
            if(count == 6) {
                System.out.println();
                count = 0;
            }
            if(s.length() < 6) continue;
            System.out.print(s + "     ");
            count++;
        }

    }

    private static TreeSet<String> loadWorks(File file) {

        TreeSet<String> wordSet = new TreeSet<>();


        try {
            BufferedReader br = new BufferedReader(new FileReader(file));  // 파일 읽기

            String line;

            while ((line = br.readLine()) != null) {
                String[] words = line.split("[^A-Za-z]+");

                for (var word : words) {
                    wordSet.add(word.toLowerCase());

                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return wordSet;
    }
}
