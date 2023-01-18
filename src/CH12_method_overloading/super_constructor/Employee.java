package CH12_method_overloading.super_constructor;

public class Employee extends Person{

    public Employee() {
        super("익명");  // 상위 클래스를 불러옴. , 부모클래스 생성자.

        System.out.println( super.getName()); // 부모 클래스 객체
    }
}
