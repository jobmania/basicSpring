package CH21_Generic._01.hierarchy;

public class Creature {

    private String name;

    public Creature(String name) {
        this.name = name;
    }

    public void feed(){
        System.out.println("생물 피드");
    }


    @Override
    public String toString() {
        return "Creature{" +
                "name='" + name + '\'' +
                '}';
    }
}
