package ch.hslu.ad.sw06.exc02;

public class Latch implements Synch {
    private int sema;

    public Latch() {
        this.sema = 1;
    }

    @Override
    public synchronized void acquire() throws InterruptedException {
        while (sema > 0) {
            this.wait();
        }
    }

    @Override
    public synchronized boolean acquire(int timeout) throws InterruptedException {
        if (sema > 0) {
            this.wait(timeout);
        }
        return (sema > 0);
    }

    @Override
    public synchronized void release() {
        this.notifyAll();
        sema--;
    }
}
