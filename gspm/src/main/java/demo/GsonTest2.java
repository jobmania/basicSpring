package demo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Arrays;
import java.util.List;

public class GsonTest2 {
    public static void main(String[] args) {
        Employee emp1 = new Employee(2, "우효", "asaas@naver.com");
        Employee emp2 = new Employee(5, "우효홋", "ffffs@naver.com");
        List<Employee> employeeList = Arrays.asList(emp1, emp2);

        Gson gson = new Gson();

        String jsonString = gson.toJson(employeeList);
        System.out.println(jsonString);

        List list = gson.fromJson(jsonString, List.class);
        System.out.println(list);

        Object fromJson = gson.fromJson(jsonString, new TypeToken<List<Employee>>() { }.getType());
        System.out.println(fromJson);
    }
}
