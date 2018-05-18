package ch.hslu.ad.N4.exc01;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

/**
 * Codebeispiel zu RecursiveAction für die Sortierung eines int-Arrays.
 */
@SuppressWarnings("serial")
public final class SortTask extends RecursiveAction {

    private final int threshold;
    private final int[] array;
    private final int min;
    private final int max;

    /**
     * Erzeugt einen Array-Sortier Task.
     * @param array Interger-Array.
     */
    public SortTask(final int[] array, int threshold) {
        this(array, 0, array.length, threshold);
    }

    private SortTask(final int[] array, final int min, final int max, int threshold) {
        this.array = array;
        this.min = min;
        this.max = max;
        this.threshold = threshold;
    }

    @Override
    protected void compute() {
        if (max - min < threshold) {
            sortSequentially(min, max);
        } else {
            final int mid = min + (max - min) / 2;
            invokeAll(new SortTask(array, min, mid, threshold), new SortTask(array, mid, max, threshold));
            merge(min, mid, max);
        }
    }

    private void sortSequentially(final int min, final int max) {
        Arrays.sort(array, min, max);
    }

    private void merge(final int min, int mid, int max) {
        // vordere Hälfte von array in Hilfsarray buf kopieren
        int[] buf = Arrays.copyOfRange(array, min, mid);
        int i = 0;
        int j = min;
        int k = mid;
        while (i < buf.length) {
            // jeweils das nächstgrösste Element zurückkopieren
            // bei k == max, Rest von buf zurückkopieren, falls vorhanden
            if (k == max || buf[i] < array[k]) {
                array[j] = buf[i];
                i++;
            } else {
                array[j] = array[k];
                k++;
            }
            j++;
        }
    }
}
