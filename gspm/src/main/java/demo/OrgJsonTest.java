package demo;


import org.json.JSONArray;
import org.json.JSONObject;

public class OrgJsonTest {

    public static void main(String[] args) {
        JSONObject jo = new JSONObject();
        jo.put("id", 12355);
        jo.put("name", "응앙앙");
        jo.put("email", "se22");
//        System.out.println(jo);
//
        Employee emp = new Employee(123, "뭏", "xxx@naver.com");   // 겟셋 메소드 필요함..
        JSONObject jo1 = new JSONObject(emp);
//        System.out.println(jo1);
        Employee emp2 = new Employee(1253, "몽뭏", "ㅋㅋㅌㅋxxx@naver.com");   // 겟셋 메소드 필요함..
        JSONObject jo2 = new JSONObject(emp2);

        JSONArray empList = new JSONArray();
        empList.put(jo1);
        empList.put(jo2);
//        System.out.println(empList.toString(5));  //객체 중간 공간 띄워서 주기.



        JSONObject obj = new JSONObject();
        obj.put("employees", empList);
        System.out.println(obj.toString(2));


    }

}
