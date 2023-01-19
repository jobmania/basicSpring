package CH19_Enum.constructor;

public enum Fruits {
    APPLE("초록색"),
    BANANA("노색"),
    ORANGE("주황색");

    private String color;

    Fruits(String color){
        this.color = color;
    }


    @Override
    public String toString() {
        return "Fruits{" +
                "color='" + color + '\'' +
                '}';
    }
}
