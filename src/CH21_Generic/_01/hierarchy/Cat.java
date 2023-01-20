package CH21_Generic._01.hierarchy;

public class Cat extends Mammal{
    public Cat(String name) {
        super(name);
    }

    public void eat(){
        System.out.println("냠냠 먹는당~");
    }
}
