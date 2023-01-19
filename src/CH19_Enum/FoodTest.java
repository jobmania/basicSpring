package CH19_Enum;

public class FoodTest {
    public static void main(String[] args) {

        Food food0 = new Food("치킨",1000);
        Food food1 = new Food("족발",2000);
        Food food2 = new Food("튀김",3000);

        Food[] list = {food0,food1,food2};

        for (Food food : list) {
            System.out.println(food);
        }


    }
}

class Food{
    String name;
    int price;

    public Food(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
