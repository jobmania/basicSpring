package CH24_Lamda._3_lamdaReturn;

public class App {

    //  인터페이스에 return이 있다면
    public static void main(String[] args) {
        Joiner joiner = (s1 , s2) ->{
            String text = s1 + " + 준 + " + s2;
            return text;
        };

        String join = joiner.join("엄", "식");
        System.out.println("join = " + join);

        System.out.println("-------------------------------------------");

        // 한줄일때 리턴과 {} 생략가능
        Joiner joiner2 = (s1 , s2) -> s1 + " + 갈 + " + s2;
        String join1 = joiner2.join("매", "찜");
        System.out.println("joiner2 = " + join1);
    }
}

interface Joiner{
    String join(String txt1, String txt2);
}