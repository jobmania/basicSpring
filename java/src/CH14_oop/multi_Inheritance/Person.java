package CH14_oop.multi_Inheritance;

// 클래스는 하나만 상속 가능하나 인터페이스는 다중 상속 가능.
public class Person implements Speaker,Greeter{
    @Override
    public void greet() {
        System.out.println("ㅎㅇ~");
    }

    @Override
    public void speak() {
        System.out.println("슈슈슉ㄱ 슈");
    }
}
