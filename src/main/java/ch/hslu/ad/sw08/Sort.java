package ch.hslu.ad.sw08;

public class Sort {


    /**
     * Sortiert das int‐Array aufsteigend, erst ab Index array[1]. * @param array Zu sortierendes Array.
     */
    public static void insertionSort(final int[] array) {
        int elt;
        int j;
        for (int i = 1; i < array.length; i++) {
            elt = array[i]; // next elt for insert
            j = i; // array[1]..array[j‐1] already sorted

            while ((j > 0) && (array[j - 1] > elt)) {
                array[j] = array[j - 1]; //left shift
                j--; //go further left
            }
            array[j] = elt; // insert elt

        }
    }

    public static void selectionSort(final int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int lowestIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[lowestIndex]) {
                    lowestIndex = j;
                }
            }
            int swapValue = array[i];
            array[i] = array[lowestIndex];
            array[lowestIndex] = swapValue;

        }
    }
}
