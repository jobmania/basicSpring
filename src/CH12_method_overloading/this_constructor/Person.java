package CH12_method_overloading.this_constructor;

public class Person {

    private String name;
    private int age;
    // 디폴트 생성자
    public Person(String name, int age){
        System.out.println("생성!");
        this.name = name;
        this.age = age;

    }



}
