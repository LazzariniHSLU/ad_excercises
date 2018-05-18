package ch.hslu.ad.A1.exc04;

import ch.hslu.ad.A2.exc02.Sort;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

public class SortTest {

    private int arrayLength = 30000;

    //region Insertion Sort
    @Test
    public void insertionSort2() {
        int[] test = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] result = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Arrays.sort(result);
        Sort.insertionSort(test);
        assertTrue(compareArrays(test, result));
    }

    @Test
    public void performanceInSortRandom() {
        int[] test = new int[arrayLength];
        int[] result = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            int number = new Random().nextInt();
            test[i] = number;
            result[i] = number;
        }
        Arrays.sort(result);
        long start = System.currentTimeMillis();
        Sort.insertionSort(test);
        long end = System.currentTimeMillis();
        assertTrue(compareArrays(test, result));
        System.out.println("Insert Sorting a random array took " + (end - start) + " milliseconds");
    }

    @Test
    public void performanceInSortAlreadySorted() {
        int[] test = new int[arrayLength];
        int[] result = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            test[i] = i;
            result[i] = i;
        }
        Arrays.sort(result);
        long start = System.currentTimeMillis();
        Sort.insertionSort(test);
        long end = System.currentTimeMillis();
        assertTrue(compareArrays(test, result));
        System.out.println("Insert Sorting a sorted array took " + (end - start) + " milliseconds");
    }

    @Test
    public void performanceInSortDescSorted() {
        int[] test = new int[arrayLength];
        int[] result = new int[arrayLength];
        int j = arrayLength;
        for (int i = 0; i < arrayLength; i++) {
            int number = j--;
            test[i] = number;
            result[i] = number;
        }
        Arrays.sort(result);
        long start = System.currentTimeMillis();
        Sort.insertionSort(test);
        long end = System.currentTimeMillis();
        assertTrue(compareArrays(test, result));
        System.out.println("Insert Sorting a desc sorted array took " + (end - start) + " milliseconds");
    }
    //endregion

    //region Selection Sort
    @Test
    public void selectionSort() {
        int[] test = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] result = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Sort.selectionSort(test);
        assertTrue(compareArrays(test, result));
    }

    @Test
    public void performanceSelSortRandom() {

        int[] test = new int[arrayLength];
        int[] result = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            int number = new Random().nextInt();
            test[i] = number;
            result[i] = number;
        }
        Arrays.sort(result);
        long start = System.currentTimeMillis();
        Sort.selectionSort(test);
        long end = System.currentTimeMillis();
        assertTrue(compareArrays(test, result));
        System.out.println("Select Sorting a random array took " + (end - start) + " milliseconds");

    }


    @Test
    public void performanceSelSortAlreadySorted() {
        int[] test = new int[arrayLength];
        int[] result = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            test[i] = i;
            result[i] = i;
        }
        Arrays.sort(result);
        long start = System.currentTimeMillis();
        Sort.selectionSort(test);
        long end = System.currentTimeMillis();
        assertTrue(compareArrays(test, result));
        System.out.println("Select Sorting a sorted array took " + (end - start) + " milliseconds");
    }

    @Test
    public void performanceSelSortDescSorted() {
        int[] test = new int[arrayLength];
        int[] result = new int[arrayLength];
        int j = arrayLength;
        for (int i = 0; i < arrayLength; i++) {
            int number = j--;
            test[i] = number;
            result[i] = number;
        }
        Arrays.sort(result);
        long start = System.currentTimeMillis();
        Sort.selectionSort(test);
        long end = System.currentTimeMillis();
        assertTrue(compareArrays(test, result));
        System.out.println("Select Sorting a desc sorted array took " + (end - start) + " milliseconds");
    }
    //endregion

    //region Bubble Sort
    @Test
    public void bubbleSort() {
        int[] test = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] result = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Sort.bubbleSort(test);
        assertTrue(compareArrays(test, result));
    }

    @Test
    public void performanceBubblelSortRandom() {

        int[] test = new int[arrayLength];
        int[] result = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            int number = new Random().nextInt();
            test[i] = number;
            result[i] = number;
        }
        Arrays.sort(result);
        long start = System.currentTimeMillis();
        Sort.bubbleSort(test);
        long end = System.currentTimeMillis();
        assertTrue(compareArrays(test, result));
        System.out.println("Bubble Sorting a random array took " + (end - start) + " milliseconds");

    }


    @Test
    public void performanceBubbleSortAlreadySorted() {
        int[] test = new int[arrayLength];
        int[] result = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            test[i] = i;
            result[i] = i;
        }
        Arrays.sort(result);
        long start = System.currentTimeMillis();
        Sort.bubbleSort(test);
        long end = System.currentTimeMillis();
        assertTrue(compareArrays(test, result));
        System.out.println("Bubble Sorting a sorted array took " + (end - start) + " milliseconds");
    }

    @Test
    public void performanceBubbleSortDescSorted() {
        int[] test = new int[arrayLength];
        int[] result = new int[arrayLength];
        int j = arrayLength;
        for (int i = 0; i < arrayLength; i++) {
            int number = j--;
            test[i] = number;
            result[i] = number;
        }
        Arrays.sort(result);
        long start = System.currentTimeMillis();
        Sort.bubbleSort(test);
        long end = System.currentTimeMillis();
        assertTrue(compareArrays(test, result));
        System.out.println("Bubble Sorting a desc sorted array took " + (end - start) + " milliseconds");
    }
    //endregion

    //region Shell Sort
    @Test
    public void shellSort() {
        int[] test = new int[]{5, 33, 12, 13, 8, 1, 41, 12, 27, 26};
        int[] result = new int[]{5, 33, 12, 13, 8, 1, 41, 12, 27, 26};
        Arrays.sort(result);
        Sort.shellSort(test);
        assertTrue(compareArrays(test, result));
    }

    @Test
    public void shellSortHibbard() {
        int[] test = new int[]{5, 33, 12, 13, 8, 1, 41, 12, 27};
        int[] result = new int[]{5, 33, 12, 13, 8, 1, 41, 12, 27};
        Arrays.sort(result);
        Sort.shellSortHibbard(test);
        assertTrue(compareArrays(test, result));
    }

    @Test
    public void shellSortHibbardRandom() {
        int[] test = new int[arrayLength];
        int[] result = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            int number = new Random().nextInt();
            test[i] = number;
            result[i] = number;
        }
        Arrays.sort(result);
        long start = System.currentTimeMillis();
        Sort.shellSortHibbard(test);
        long end = System.currentTimeMillis();
        assertTrue(compareArrays(test, result));
        System.out.println("Shell Sorting (Hibbard) a random array took " + (end - start) + " milliseconds");
    }

    //endregion
    //region Quick Sort
    @Test
    public void quickSort() {
        char[] v = randomChars(arrayLength);
        char[] test = v;
        char[] result = v;
        Arrays.sort(result);
        long start = System.currentTimeMillis();
        Sort.quickSort(test, 0, test.length - 1);
        long end = System.currentTimeMillis();
        assertTrue(compareArrays(test, result));
        System.out.println("Quick Sorting a random array took " + (end - start) + " milliseconds");
    }

    @Test
    public void quickSortOneParam() {
        char[] test = new char[]{'a', 'o', 'z', 'b', 'y', 'r', 't', 's', 'w', 'v', 'f', 'd', 'p'};
        char[] result = new char[]{'a', 'o', 'z', 'b', 'y', 'r', 't', 's', 'w', 'v', 'f', 'd', 'p'};
        Arrays.sort(result);
        Sort.quickSort(test);
        assertTrue(compareArrays(test, result));
    }

    @Test
    public void quickInsertionSort() {
        char[] array = randomChars(arrayLength);
        char[] quick = Arrays.copyOf(array, array.length);

        long startQuick = System.currentTimeMillis();
        Sort.quickSort(quick, 0, quick.length - 1);
        long endQuick = System.currentTimeMillis();

        long startArray = System.currentTimeMillis();
        Sort.quickInsertionSort(array, 0 , array.length - 1, 60);
        long endArray = System.currentTimeMillis();

        System.out.println("Quick Sort took " + (endQuick - startQuick) +"ms");
        System.out.println("Quick Insertion Sort took " + (endArray - startArray) +"ms");
    }
    //endregion

    //region Helper Methods
    private char[] randomChars(final int length) {
        char[] array = new char[length];
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Random r = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = alphabet.charAt(r.nextInt(alphabet.length()));
        }
        return array;
    }

    private boolean compareArrays(int[] array1, int[] array2) {
        boolean b = true;
        if (array1 != null && array2 != null) {
            if (array1.length != array2.length)
                b = false;
            else
                for (int i = 0; i < array2.length; i++) {
                    if (array2[i] != array1[i]) {
                        b = false;
                    }
                }
        } else {
            b = false;
        }
        return b;
    }

    private boolean compareArrays(char[] array1, char[] array2) {
        boolean b = true;
        if (array1 != null && array2 != null) {
            if (array1.length != array2.length)
                b = false;
            else
                for (int i = 0; i < array2.length; i++) {
                    if (array2[i] != array1[i]) {
                        b = false;
                    }
                }
        } else {
            b = false;
        }
        return b;
    }
    //endregion
}