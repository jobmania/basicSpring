package CH10_상속._1_상속;

public class App {
    public static void main(String[] args) {
        Animal ani = new Animal();
        ani.eat();

        Bird bird = new Bird();
        bird.fly();
        bird.eat();// 상속.
    }
}
