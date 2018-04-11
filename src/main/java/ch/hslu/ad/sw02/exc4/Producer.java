package ch.hslu.ad.sw02.exc4;

import ch.hslu.ad.sw06.exc03.BoundedBuffer;

/**
 * Produzent, der eine maximale Anzahl Werte produziert und diese in eine Queue speichert.
 */
public final class Producer implements Runnable {

    private final BoundedBuffer<Integer> queue;
    private final int maxRange;
    private long sum;

    /**
     * Erzeugt einen Produzent, der eine bestimmte Anzahl Integer-Werte produziert.
     * @param queue Queue zum Speichern der Integer-Werte.
     * @param max Anzahl Integer-Werte.
     */
    public Producer(final BoundedBuffer<Integer> queue, final int max) {
        this.queue = queue;
        this.maxRange = max;
        this.sum = 0;
    }

    @Override
    public void run() {
        for (int i = 0; i < maxRange; i++) {
            try {
                sum += i;
                queue.put(i);
            } catch (InterruptedException ex) {
                return;
            }
        }
    }

    /**
     * Liefert die Summe aller gespeicherter Werte.
     * @return Summe.
     */
    public long getSum() {
        return sum;
    }
}
