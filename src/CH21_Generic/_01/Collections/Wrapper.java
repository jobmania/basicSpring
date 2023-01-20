package CH21_Generic._01.Collections;

// <E> 제너릭 타입 ; 타입이 정해지지않은타입
public class Wrapper <E> {

    private E object;

    public E getObject() {
        return object;
    }

    public void setObject(E object) {
        this.object = object;
    }
}
