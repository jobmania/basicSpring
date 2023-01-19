package CH16_innerClass.hashcode;

public class Fox {
    String name;

    public Fox(){
        System.out.println(this);  // 생성된 클래스의 주소..
        this.name = "폭스";
    }
}
