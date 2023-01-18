package CH14_oop.interface_class;

public class Computer implements Describable {
    @Override
    public String getDescription() {
        return "컴퓨터";
    }
}
