package ch.hslu.ad.sw06.exc02;

/**
 * Schnittstelle für die Zutrittsverwaltung geschützter Bereiche.
 */
public interface Synch {
    /**
     * Eintritt in einen geschützten Bereich erlangen,
     * falls kein Zutritt möglich ist warten.
     * @throws InterruptedException wenn das Warten unterbrochen wird.
     */
    public void acquire() throws InterruptedException;
    public boolean acquire(int timeout) throws InterruptedException;
    /**
     * Freigabe des geschützten Bereiches.
     */
    public void release();
}