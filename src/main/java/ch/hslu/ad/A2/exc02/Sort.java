package ch.hslu.ad.A2.exc02;

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

    public static void insertionSortPartially(final char[] array, int from, int to){
        char elt;
        int j;
        for (int i = from; i < to; i++) {
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
     *
     * @param array Zu sortierendes Array
     */
    public static void shellSort(final int[] array) {
        for (int n = 2; n < array.length; n += 2) {
            int divident = array.length / n;
            for (int i = array.length / n; i < array.length; i++) {

                if (array[i] < array[i - divident]) {
                    int swapValue = array[i];
                    array[i] = array[i - divident];
                    array[i - divident] = swapValue;
                }
            }
        }
    }

    /**
     * Sortiert das int-Array aufsteigend gemäss shell Sort mit Hibbard
     * @param array Zu sortierendes Array
     */
    public static void shellSortHibbard(int[] array) {
        int n = array.length;
        int j, k, h, element;

        int[] spalten = {2147483647, 1131376761, 410151271, 157840433,
                58548857, 21521774, 8810089, 3501671, 1355339, 543749, 213331,
                84801, 27901, 11969, 4711, 1968, 815, 271, 111, 41, 13, 4, 1};

        for (k = 0; k < spalten.length; k++) {
            h = spalten[k];
            // Sortiere die "Spalten" mit Insertionsort
            for (int i = h; i < n; i++) {
                element = array[i];
                j = i;
                while (j >= h && array[j - h] > element) {
                    array[j] = array[j - h];
                    j = j - h;
                }
                array[j] = element;
            }
        }
    }

    public static void shellSort2(final int[] array) {

        for (int i = 0; i < array.length / 2; i++) {

            if (array[i] > array[i + 4]) {
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

    /**
     * Vertauscht zwei bestimmte Zeichen im Array.
     *
     * @param a           Zeichen‐Array
     * @param firstIndex  Index des ersten Zeichens
     * @param secondIndex Index des zweiten Zeichens
     */
    private static final void exchange(final char[] a,
                                       final int firstIndex,
                                       final int secondIndex) {
        char tmp;
        tmp = a[firstIndex];
        a[firstIndex] = a[secondIndex];
        a[secondIndex] = tmp;
    }

    /**
     * ortiert das Array gemöss QuickSort
     * @param a Zu sortierendes Array
     * @param left Anfang links
     * @param right Ende rechtsS
     */
    public static final void quickSort(final char[] a, final int left, final int right) {
        int up = left; // linke Grenze
        int down = right - 1; // rechte Grenze (ohne Trennelement)
        char t = a[right]; // rechtes Element als Trennelement
        boolean allChecked = false;
        do {
            while (a[up] < t) {
                up++; // suche grösseres (>=) Element von links an
            }
            while ((a[down] >= t) && (down > up)) {
                down--; // suche echt kleineres(<) Element von rechts an
            }
            if (down > up) { // solange keine Überschneidung
                exchange(a, up, down);
                up++;
                down--; // linke und rechte Grenze verschieben
            } else {
                allChecked = true; // Austauschen beendet
            }
        } while (!allChecked);
        exchange(a, up, right); // Trennelement an endgültige Position (a[up])
        if (left < (up - 1)) quickSort(a, left, (up - 1)); // linke Hälfte
        if ((up + 1) < right) quickSort(a, (up + 1), right); // rechte Hälfte, ohne T’Elt.
    }


    public static final void quickSort(final char[] a) {
        int right = a.length - 1;
        int left = 0;
        int up = 0; // linke Grenze
        int down = right - 1; // rechte Grenze (ohne Trennelement)
        char t = a[a.length - 1]; // rechtes Element als Trennelement
        boolean allChecked = false;
        do {
            while (a[up] < t) {
                up++; // suche grösseres (>=) Element von links an
            }
            while ((a[down] >= t) && (down > up)) {
                down--; // suche echt kleineres(<) Element von rechts an
            }
            if (down > up) { // solange keine Überschneidung
                exchange(a, up, down);
                up++;
                down--; // linke und rechte Grenze verschieben
            } else {
                allChecked = true; // Austauschen beendet
            }
        } while (!allChecked);
        exchange(a, up, right); // Trennelement an endgültige Position (a[up])
        if (left < (up - 1)) quickSort(a, left, (up - 1)); // linke Hälfte
        if ((up + 1) < right) quickSort(a, (up + 1), right); // rechte Hälfte, ohne T’Elt.
    }


    /**
     * ortiert das Array gemöss QuickSort
     * @param a Zu sortierendes Array
     * @param left Anfang links
     * @param right Ende rechts
     * @param m Grenze für insertionSort
     */
    public static final void quickInsertionSort(final char[] a, final int left, final int right, int m) {
        int up = left; // linke Grenze
        int down = right - 1; // rechte Grenze (ohne Trennelement)
        char t = a[right]; // rechtes Element als Trennelement
        boolean allChecked = false;
        do {
            while (a[up] < t) {
                up++; // suche grösseres (>=) Element von links an
            }
            while ((a[down] >= t) && (down > up)) {
                down--; // suche echt kleineres(<) Element von rechts an
            }
            if (down > up) { // solange keine Überschneidung
                exchange(a, up, down);
                up++;
                down--; // linke und rechte Grenze verschieben
            } else {
                allChecked = true; // Austauschen beendet
            }
        } while (!allChecked);
        exchange(a, up, right); // Trennelement an endgültige Position (a[up])

        if (left < (up - 1)) {
            int size = up - left;
            if(size < m){
                Sort.insertionSortPartially(a, left, up -1);
            }
            else {
                quickInsertionSort(a, left, (up - 1), m); // linke Hälfte
            }
        }
        if ((up + 1) < right){
            int size = right - up;
            if(size < m){
                insertionSortPartially(a, up + 1, right);
            }
            else {
                quickInsertionSort(a, (up + 1), right,m); // rechte Hälfte, ohne T’Elt.
            }
        }
    }
}
