package ch.hslu.ad.sw06.exc01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Einfacher Task für die Demonstration eines Wait-Pools.
 */
public final class MyTask implements Runnable {
    private static final Logger LOG =
            LogManager.getLogger(MyTask.class);
    private final Object lock;
    public MyTask(final Object lock) {
        this.lock = lock;
    }
    @Override
    public void run() {
        LOG.info("warten...");
        synchronized (lock) {
            try {
                lock.wait(); // man muss auf dem syncden Objekt wait aufrufen
            } catch (InterruptedException ex) {
                return;
            }
        }
        LOG.info("...aufgewacht");
    }
}
