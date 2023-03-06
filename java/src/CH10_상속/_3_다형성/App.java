package CH10_상속._3_다형성;

public class App {
    public static void main(String[] args) {

        // 자식 객체는 부모타입으로 선언가능..
//        Cat houseCat = new HouseCat();
//        houseCat.vocal();
//
//        Cat roadCat = new RoadCat();
//        roadCat.vocal();
//
//        Cat tiger = new Tiger();
//        tiger.vocal();

        Cat[] cats = {new HouseCat(), new RoadCat(), new Tiger()};
//        cats[0].vocal();
//        cats[0].hunt();
//
//        cats[1].vocal();
//        cats[1].hunt();
//
//        cats[2].vocal();
//        cats[2].hunt();




        for (Cat cat : cats) {
            cat.vocal();
            cat.hunt();
        }


        // 부모 타입으로 선언한 것은 업캐스팅
        Cat cat1 = new HouseCat();

        // 다시 자식 객체로 선언하는 것 다운캐스팅
        HouseCat cat2 = (HouseCat) cat1;



        // 캐스팅 ( 형변환)
        Cat cat3 = new HouseCat();  // HouseCat 실제객체
        Cat cat44 = cat3 ; // 참조변수의 주소값을 넣어줌 // 객체의 주소가 복사됨..
        HouseCat cat4 = (HouseCat) cat3;  // 객체의 주소가 복사됨..


    }
}
