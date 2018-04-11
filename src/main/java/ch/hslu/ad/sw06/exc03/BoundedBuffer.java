package ch.hslu.ad.sw06.exc03;

import java.util.ArrayDeque;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class BoundedBuffer<T> {

    private ArrayDeque<T> queue = new ArrayDeque<>();
    private final Semaphore putSema;
    private final Semaphore getSema;
    private final int capacity;

    public BoundedBuffer(int n) {
        queue = new ArrayDeque<>(n);
        putSema = new Semaphore(n);
        getSema = new Semaphore(0);
        capacity = n;
    }

    public T get() throws InterruptedException {
        getSema.acquire();
        T elem;
        synchronized (queue){
            elem = queue.removeLast();
        }
        putSema.release();
        return elem;
    }

    public T get(final int timeout) throws InterruptedException{
        getSema.tryAcquire(timeout, TimeUnit.MILLISECONDS);
        T elem;
        synchronized (queue){
            elem = queue.removeLast();
        }
        putSema.release();
        return elem;
    }

    public void put(final T value) throws InterruptedException {
       putSema.acquire();
       synchronized (queue){
           queue.addFirst(value);
       }
       getSema.release();
    }

    public void put(final T value, final int timeout) throws InterruptedException {
        putSema.tryAcquire(timeout, TimeUnit.MILLISECONDS);
        synchronized (queue){
            queue.addFirst(value);
        }
        getSema.release();
    }

    public boolean empty(){
        return queue.isEmpty();
    }

    public boolean full(){
        return (queue.size() == capacity);
    }

    public int size(){
        return queue.size();
    }

    public T front() throws InterruptedException{
        getSema.acquire();
        T elem;
        synchronized (queue){
            elem = queue.getFirst();
        }
        putSema.release();
        return elem;
    }

    public T back() throws InterruptedException{
        getSema.acquire();
        T elem;
        synchronized (queue){
            elem = queue.getLast();
        }
        putSema.release();
        return elem;
    }
}
