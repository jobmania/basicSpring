package CH20_File;

import java.io.File;

public class App {

    public static void main(String[] args) {
        File directory = new File("."); // 현재 프로젝트 폴더의 객체
        System.out.println(directory.getAbsolutePath());

        for(String f : directory.list()){
            System.out.println(f);
        }
    }
}
