package ch.hslu.ad.D1.exc3;

public interface Stack<T> {
    boolean isEmpty();
    boolean isFull();
    int size();
    boolean push(T element) throws StackFullException; // Checked Exception cause it's be
    T pop();
    T peek();
}
