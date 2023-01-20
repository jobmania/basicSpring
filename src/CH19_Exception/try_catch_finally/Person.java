package CH19_Exception.try_catch_finally;

public class Person {

    void setName(String name) {
        if(name==null){
            try {
                throw new Exception("이름이 없잖아 갠");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("소코마데다"+ name);

    }
}
