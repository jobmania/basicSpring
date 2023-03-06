package CH18_Enum.method;

public class App {
    public static void main(String[] args) {
        Fruits[] fruits = Fruits.values();

        for (Fruits fruit : fruits) {
            System.out.println(fruit);

        }

        int ordinal = Fruits.BANANA.ordinal();


    }
}
