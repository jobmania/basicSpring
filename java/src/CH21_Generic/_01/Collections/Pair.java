package CH21_Generic._01.Collections;

public class Pair <T,S>{

    private T value;
    private S value2;

    public Pair(T value, S value2) {
        this.value = value;
        this.value2 = value2;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public S getValue2() {
        return value2;
    }

    public void setValue2(S value2) {
        this.value2 = value2;
    }


    @Override
    public String toString() {
        return "Pair{" +
                "value=" + value +
                ", value2=" + value2 +
                '}';
    }
}
