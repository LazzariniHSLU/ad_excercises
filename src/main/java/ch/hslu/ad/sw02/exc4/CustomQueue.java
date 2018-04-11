package ch.hslu.ad.sw02.exc4;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;

public class CustomQueue<T> implements Queue<T>{
    private T[] queue;
    private int enqueueIndex;
    private int dequeueIndex;
    private int size;


    public CustomQueue(int size) {
        this.queue = (T[]) new Object[size];
    }

    @Override
    public boolean enqueue(T element) {
        if(isFull()){
            throw new BufferOverflowException();
        }
        queue[enqueueIndex] = element;
        enqueueIndex = (enqueueIndex + 1) % queue.length;
        size++;
        return true;
    }

    @Override
    public T dequeue() {
        if(isEmpty()){
            throw new BufferUnderflowException();
        }
        T element = queue[dequeueIndex];
        queue[dequeueIndex] = null; // For the GC
        dequeueIndex = (dequeueIndex + 1) % queue.length;
        size--;
        return element;

    }

    @Override
    public int size() {
        return size;
    }

    public int length(){
        return queue.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == queue.length;
    }
}
