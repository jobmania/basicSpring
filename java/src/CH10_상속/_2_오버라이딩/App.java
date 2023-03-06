package CH10_상속._2_오버라이딩;

public class App {
    public static void main(String[] args) {

        HouseCat houseCat = new HouseCat();
        houseCat.vocal();

        RoadCat roadCat = new RoadCat();
        roadCat.vocal();

        Tiger tiger = new Tiger();
        tiger.vocal();


    }
}
