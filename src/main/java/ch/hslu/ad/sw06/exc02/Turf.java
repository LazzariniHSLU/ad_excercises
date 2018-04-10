package ch.hslu.ad.sw06.exc02;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class Turf {
    private static final Logger LOG = LogManager.getLogger(Turf.class); //...ist zu initialisieren

    public static void main(final String[] args) {
        Synch starterBox = new Latch();
        List<Thread> threads = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            threads.add(new Thread(new RaceHorse(starterBox), "Horse " + i));
            threads.get(i-1).start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LOG.info("Start...");
        starterBox.release();
        if(new Random().nextBoolean()){
            for(Thread thread : threads){
                thread.interrupt();
            }
        }
    }
}