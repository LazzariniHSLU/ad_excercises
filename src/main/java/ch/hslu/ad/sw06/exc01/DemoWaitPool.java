package ch.hslu.ad.sw06.exc01;

/**
 * Demonstration eines Wait-Pools.
 */
public final class DemoWaitPool {
    private static final Object lock = new Object();

    public static void main(final String args[]) throws InterruptedException {
        final MyTask waiter = new MyTask(lock);
        new Thread(waiter).start();
        Thread.sleep(1000);
        synchronized (lock) { //man kann nur in einem sync block notifyien ansonsten könnten zwei threads notifiy aufrufen das signal könnte verloren werden.
            lock.notify();
        }
    }
}
