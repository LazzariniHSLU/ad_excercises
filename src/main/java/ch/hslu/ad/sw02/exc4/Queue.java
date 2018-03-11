package ch.hslu.ad.sw02.exc4;

public interface Queue<T> {
    boolean enqueue(T element);
    T dequeue();
    int size();
    boolean isEmpty();
    boolean isFull();

}
