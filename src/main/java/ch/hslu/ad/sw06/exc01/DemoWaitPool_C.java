package ch.hslu.ad.sw06.exc01;

/**
 * Demonstration eines Wait-Pools.
 */
public final class DemoWaitPool_C {
    private static final Object lock = new Object();

    public static void main(final String args[]) throws InterruptedException {
        synchronized (lock) {
            final MyTask waiter = new MyTask(lock);
            new Thread(waiter).start();
            Thread.sleep(1000);
            lock.notify();
        }
    }
}
