package demo;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.InputStream;

public class ParsingJson {
    public static void main(String[] args) {
        String src = "C:\\Users\\admin\\IdeaProjects\\gspm\\src\\main\\java\\demo\\info.json";

        System.out.println(src);

        try {

            InputStream is = ParsingJson.class.getResourceAsStream(src); // 경로를 못찾는데?

            JSONTokener tokener = new JSONTokener(is);
            JSONObject object = new JSONObject(tokener); // 전체 객체를 object
            JSONArray empList = object.getJSONArray("employees");  // 필요한데이터

            for (Object emp : empList) {
                JSONObject employee = (JSONObject) emp;
                System.out.println(employee.toString());
            }

        }catch (NullPointerException e){
            System.out.println("파일없음");
            e.getMessage();
        }
    }
}
