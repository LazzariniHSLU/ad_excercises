package ch.hslu.ad.N1.exc2;

import ch.hslu.ad.E1.excercices.Fibonacci;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AdditionTask implements Runnable {

    Logger LOG = LogManager.getLogger(Fibonacci.class);
    private int rangeBegin;
    private int rangeEnd;
    private volatile Thread runThread;
    private volatile boolean isStopped = false;

    public AdditionTask(int begin, int end) {
        rangeBegin = begin;
        rangeEnd = end;
    }

    public void stopRequest(){
        isStopped = true;
        if(runThread!= null){
            runThread.interrupt();
        }
    }

    public boolean isStopped(){
        return isStopped;
    }

    @Override
    public void run() {
        this.runThread = Thread.currentThread(); // Initialisierungsphase
        long sum = 0;
       /* try{
            while (Thread.currentThread().isInterrupted() == false){
                // Arbeitsphase
                for (int i = this.rangeBegin; i <= this.rangeEnd; i++) {
                    sum += i;
                }
            }
        }
        catch(InterruptedException ex){

        }
        finally{
            // Aufräumphase
            if (!isStopped()) {
                LOG.info(runThread.getName() + ": SUM"  + " -> " + sum);
            } else {
                LOG.info(runThread.getName() + ": interrupted.");
            }
        }*/
    }
}
