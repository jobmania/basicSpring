package CH14_oop.interface_class;

public class Person implements Describable {

    @Override
    public String getDescription() {
        return "사람";
    }
}
