package demo;

import com.google.gson.Gson;

public class GsonTest {

    public static void main(String[] args) {
        Gson gson = new Gson();  // 제이슨으로 변환해주는 라이브러리

        // 자바 객체 => 제이슨
        Employee emp = new Employee(11, "형섭", "wewe@gmail.com");
        String jsonString = gson.toJson(emp);

        System.out.println(jsonString);


        // 제이슨문자열 => 자바 객체
        String jsonString2 ="{\"id\":11,\"name\":\"형섭\",\"email\":\"wewe@gmail.com\"}";
        Employee fromJson = gson.fromJson(jsonString2, Employee.class);
        System.out.println(fromJson);
    }
}
