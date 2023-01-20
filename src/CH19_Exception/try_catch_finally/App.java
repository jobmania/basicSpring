package CH19_Exception.try_catch_finally;

public class App {
    public static void main(String[] args) {
        Person p1 = new Person();

        try {
            p1.setName("준식");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
        //예외 발생하든 안하든 무조건 실행
            System.out.println("나는 하입보이~");
        }

    }
}
