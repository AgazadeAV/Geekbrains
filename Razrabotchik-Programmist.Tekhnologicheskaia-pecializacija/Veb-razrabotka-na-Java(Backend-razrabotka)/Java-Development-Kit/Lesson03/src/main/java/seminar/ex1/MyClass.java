package seminar.ex1;

import java.io.DataInput;
import java.io.InputStream;

public class MyClass<T extends Comparable<T>, V extends InputStream & DataInput, K extends Number> {
    private T t;
    private V v;
    private K k;

    public MyClass(T t, V v, K k) {
        this.t = t;
        this.v = v;
        this.k = k;
    }

    public T getT() {
        return t;
    }

    public V getV() {
        return v;
    }

    public K getK() {
        return k;
    }

    void print() {
        System.out.printf("t = %s, v = %s, k = %s",
                t.getClass().getName(),
                v.getClass().getName(),
                k.getClass().getName());
    }
}