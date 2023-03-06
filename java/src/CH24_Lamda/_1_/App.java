package CH24_Lamda._1_;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class App {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("하나");
        list.add("둘");
        list.add("셋");
        list.add("넷");

        
        // 람다식 사용시  함수형 인터페이스 일때만 사용이 가능하다 예시 -> Test 인터페이스
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);

            }
        });

        System.out.println("------------------------------------");
        // 람다식으로 표현

        list.forEach( s -> {});

        list.forEach( item -> {
                    System.out.println(item);
                }
                );

    }
}
