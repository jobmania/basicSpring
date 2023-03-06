package CH22_Collections.hash_map;

import java.util.HashMap;
import java.util.Map;

public class Iterating {
    public static void main(String[] args) {
        HashMap<String, String> months = new HashMap<>();
        months.put("JAN", "1월");
        months.put("FEB", "2월");
        months.put("MAR", "3월");
        months.put("APR", "4월");
        months.put("JUN", "5월");
        months.put("JUL", "6월");

        // 1 람다
        months.forEach((k,v) -> System.out.println(k+ " : " + v));

        //2 entrySet() : kev, value를 가져오는 객체  ,, keySet은 키값만 출력
        for(Map.Entry<String,String> entry : months.entrySet()){
            String k = entry.getKey();
            String v = entry.getValue();
            System.out.println(k + " ; " + v );
        }


        //var 타입 생략 가능
        for(var entry : months.entrySet()){
            String k = entry.getKey();
            String v = entry.getValue();
            System.out.println(k + " -> " + v );
        }



        // 3 key, value값 반복문
        for(String k : months.keySet()){
            System.out.println(k + " 은 " + months.get(k));
        }

    }
}
