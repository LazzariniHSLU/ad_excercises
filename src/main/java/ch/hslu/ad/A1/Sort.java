package ch.hslu.ad.A1;

public class Sort {


    /**
     * Sortiert das int-Array aufsteigend gemäss direktes einfügen.
     *
     * @param array Zu sortierendes Array.
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
            array[j] = elt; //insert elt
        }
    }

    /**
     * Sortiert das int-Array aufsteigend gemäss direktes Auswählen.
     *
     * @param array Zu sortierendes Array.
     */
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

    /**
     * Sortiert das int-Array aufsteigend gemäss bubble Sort
     *
     * @param array Zu sortierendes Array
     */
    public static void bubbleSort(final int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 1; j < n; j++) {
                if (array[j] < array[j - 1]) {
                    int swapValue = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = swapValue;
                }
            }
        }
    }

    /**
     * Sortiert das int-Array aufsteigend gemäss shell Sort
     * @param array Zu sortierendes Array
     */
    public static void shellSort(final int[] array) {
        for(int n = 2; n < array.length; n += 2){
            int divident = array.length/n;
            for (int i = array.length / n; i < array.length; i++) {

                if(array[i] < array[i-divident]){
                    int swapValue = array[i];
                    array[i] = array[i - divident];
                    array[i - divident] = swapValue;
                }
            }
        }
    }

    public static void shellSortHibbard(int[] array)
    {
        int n = array.length;
        int  j, k, h, element;

        int[] spalten = {2147483647, 1131376761, 410151271, 157840433,
                58548857, 21521774, 8810089, 3501671, 1355339, 543749, 213331,
                84801, 27901, 11969, 4711, 1968, 815, 271, 111, 41, 13, 4, 1};

        for (k = 0; k < spalten.length; k++)
        {
            h = spalten[k];
            // Sortiere die "Spalten" mit Insertionsort
            for (int i = h; i < n; i++)
            {
                element = array[i];
                j = i;
                while (j >= h && array[j-h] > element)
                {
                    array[j] = array[j-h];
                    j = j - h;
                }
                array[j] = element;
            }
        }
    }

    public static void shellSort2(final int[] array){

        for (int i = 0; i < array.length / 2; i++) {

            if(array[i] > array[i+4]){
                int swapValue = array[i];
                array[i] = array[i + 4];
                array[i + 4] = swapValue;
            }


        }
        for (int i = 0; i < (array.length - array.length / 4); i++) {
            if (array[i] > array[i + 2]) {
                int swapValue = array[i];
                array[i] = array[i + 2];
                array[i + 2] = swapValue;
            }
        }

        for (int i = 0; i < array.length - array.length / 8; i++) {
            if (array[i] > array[i + 1]) {
                int swapValue = array[i];
                array[i] = array[i + 1];
                array[i + 1] = swapValue;
            }
        }
    }
}
