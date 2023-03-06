package CH12_method_overloading.defaultconstructor;

public class Person {

    private String name;
    private int age;
    // 디폴트 생성자
    public Person(){
        System.out.println("생성!");
        name = "모름;";
        age = 17;
    }


    public Person(String name){
        System.out.println("생성!");
        this.name = name;
        age = 17;

    }


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // String name

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
