package org.kodluyoruz;

public interface Queue<T>{

    void add(T value);
    T peek();
    T poll();

}
