package ch.hslu.ad.D1.exc3;

import java.util.NoSuchElementException;

public class CustomStack<T> implements Stack<T> {
    private T[] stack;
    private int index = 0;
    private final int DEFAULT_SIZE = 100;


    public CustomStack() {
        this.stack = (T[]) new Object[this.DEFAULT_SIZE];
    }

    public CustomStack(int size) {
        this.stack = (T[]) new Object[size];
    }

    @Override
    public boolean isEmpty() {
        return 0 == index;
    }

    @Override
    public boolean isFull() {
        return index == stack.length;
    }

    @Override
    public int size() {
        return index;
    }

    @Override
    public boolean push(T element) throws StackFullException {
        if (isFull()) {
            throw new StackFullException(stack.length);
        }

        this.stack[this.index] = element;
        this.index++;
        return true;
    }

    @Override
    public T pop() {
        if(isEmpty()){
            throw new NoSuchElementException("Stack is empty");
        }
        T element = stack[--index];
        stack[index] = null; // So that CG can delete object
        return element;

    }

    @Override
    public T peek() {
        if(isEmpty()){
            return null;
        }
        return stack[index -1];
    }
}
