package CH22_Collections.listinterface;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Timing {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        Long duration = timeOperation(linkedList);  // 실제 작업시간..

//        System.out.println(duration);


        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack.peek());



    }

    private static Long timeOperation(List<Integer> arrayList) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) { //140
            arrayList.add(0,i);
        }
        
        return System.currentTimeMillis() - start;
    }
}
