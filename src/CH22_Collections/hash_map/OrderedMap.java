package CH22_Collections.hash_map;

import java.util.*;

public class OrderedMap {
    public static void main(String[] args) {
        HashMap<String, String> months = new LinkedHashMap<>();  // 입력된 순으로 정렬

//        TreeMap<String, String> months = new TreeMap<>();  // 키값순으로만 정렬됨

//        Comparator<String> compare = (s1, s2) -> s1.compareTo(s2);
//        TreeMap<String, String> months = new TreeMap<>(compare);  // 키값순으로 정렬

        months.put("JAN", "1월");
        months.put("FEB", "2월");
        months.put("APR", "4월");
        months.put("JUN", "5월");
        months.put("JUL", "6월");
        months.put("MAR", "3월");

        // 1 람다
        months.forEach((k,v) -> System.out.println(k+ " : " + v));

        //2 entrySet() : kev, value를 가져오는 객체  ,, keySet은 키값만 출력
        for(Map.Entry<String,String> entry : months.entrySet()){
            String k = entry.getKey();
            String v = entry.getValue();
            System.out.println(k + " ; " + v );
        }

    // 밸류 값으로 정렬하기 ..
        List<String> valueList = new ArrayList<>(months.values());
        valueList.sort(String::compareTo);
        for (String value : valueList) {
            String key = getKey(months, value);
            System.out.println( key + " : " + value);
        }


    }

    public static <K,V> K getKey(Map<K, V> map, V value) {

        for (K key : map.keySet()) {
            if (value.equals(map.get(key))) {
                return key;
            }
        }
        return null;
    }
}
