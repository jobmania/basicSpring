package CH11_가위바위보.game.object;

public class GameObject {
    private int id;
    private String name;


    protected int getId() {   // 상속클래스에서만 사용가능..
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "GameObject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
