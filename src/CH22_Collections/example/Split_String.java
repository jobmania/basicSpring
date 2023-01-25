package CH22_Collections.example;

public class Split_String {
    public static void main(String[] args) {
        String text1 = "Gotta leave you all behind and face the truth";
        String text2 = "u검은고양이를 키우는 집사이다. m이름은 마고이다. j주로 마선생,u마고경이라고 n부른다.e";


        String[] words = text1.split("[^A-Za-z]+"); /// A~z 영어문자아니면 제외
        String[] words2 = text2.split("[^가-힣]+"); // 한글이외 제외

        for (String s : words) {
            if(s.length() > 2){
                System.out.println(s);
            }
        }




    }
}
