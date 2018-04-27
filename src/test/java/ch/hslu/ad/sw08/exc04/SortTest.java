package ch.hslu.ad.sw08.exc04;

import ch.hslu.ad.sw08.Sort;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

public class SortTest {

    private int arrayLength = 20000;

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

    //region Helper Methods
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
    //endregion
}