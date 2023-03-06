package CH14_oop.interface_Inheritance;

public interface DefaultRunnable extends Runnable {
    default void displayDetails() {
        System.out.println("표시할 디테일 없음");  // 인터페이스내에서  구현 가능한 메소드.. 강제로 구현하지 않아도됨..
    }
}
