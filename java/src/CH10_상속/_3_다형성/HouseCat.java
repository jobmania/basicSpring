package CH10_상속._3_다형성;

public class HouseCat extends Cat {
    //  부모클래스의 메소드와 똑같은 메소드를 만들면 오버라이딩 메소드..
    @Override
    public void vocal(){
        System.out.println("집집집");
    }
}
