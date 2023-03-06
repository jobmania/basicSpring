package CH20_File.reading;

import java.io.*;

public class App {
    public static void main(String[] args) {
        // 파일 있는지 없는지 체크..
        String fileLocation = "C:\\Users\\admin\\test\\test.txt";
        System.out.println(new File(fileLocation).exists());


        // 파일리더가 바이트단위로 읽고(한문자씩),
        //용량이 많은 파일은.. Buffer를 이용해 한번에 여러글자를 읽는다.
        try (BufferedReader reader = new BufferedReader(new FileReader(fileLocation))) {
             // try-with-resource 문 : 해당 try문이 끝나면 자동으로 close..
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);


            }
        } catch (FileNotFoundException e) {
            System.out.println("응 파일 없어 " + fileLocation);
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("파일 못읽는다~" + fileLocation);
            System.out.println(e.getMessage());
        }


    }

}
