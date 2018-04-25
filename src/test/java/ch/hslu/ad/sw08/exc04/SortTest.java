package ch.hslu.ad.sw08.exc04;

import ch.hslu.ad.sw08.Sort;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class SortTest {

    //region Insertion Sort
    @Test
    public void insertionSort2() {
        int[] test = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        Sort.insertionSort(test);
        assertEquals(test[0], 0);
        assertEquals(test[4], 4);
        assertEquals(test[10], 10);
    }

    @Test
    public void performanceInSortRandom() {
        int[] test = new int[2000];
        for (int i = 0; i < 2000; i++) {
            test[i] = new Random().nextInt();
        }
        long start = System.currentTimeMillis();
        Sort.insertionSort(test);
        long end = System.currentTimeMillis();
        System.out.println("Sorting a random array took " + (end - start)+ " milliseconds");
    }

    @Test
    public void performanceInSortAlreadySorted() {
        int[] test = new int[2000];
        for (int i = 0; i < 2000; i++) {
            test[i] = i;
        }
        long start = System.currentTimeMillis();
        Sort.insertionSort(test);
        long end = System.currentTimeMillis();
        System.out.println("Sorting a sorted array took " + (end - start)+ " milliseconds");
    }

    @Test
    public void performanceInSortDescSorted() {
        int[] test = new int[2000];
        int j = 2000;
        for (int i = 0; i < 2000; i++) {
            test[i] = j--;
        }
        long start = System.currentTimeMillis();
        Sort.insertionSort(test);
        long end = System.currentTimeMillis();
        System.out.println("Sorting a desc sorted array took " + (end - start)+ " milliseconds");
    }
    //endregion

    //region Selection Sort
    @Test
    public void selectionSort() {
        int[] test = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        Sort.selectionSort(test);
        assertEquals(test[0], 0);
        assertEquals(test[4], 4);
        assertEquals(test[10], 10);
    }

    @Test
    public void performanceSelSortRandom() {
        int[] test = new int[2000];
        for (int i = 0; i < 2000; i++) {
            test[i] = new Random().nextInt();
        }
        long start = System.currentTimeMillis();
        Sort.selectionSort(test);
        long end = System.currentTimeMillis();
        System.out.println("Select Sorting a random array took " + (end - start)+ " milliseconds");
    }


    @Test
    public void performanceSelSortAlreadySorted() {
        int[] test = new int[2000];
        for (int i = 0; i < 2000; i++) {
            test[i] = i;
        }
        long start = System.currentTimeMillis();
        Sort.selectionSort(test);
        long end = System.currentTimeMillis();
        System.out.println("Select Sorting a sorted array took " + (end - start)+ " milliseconds");
    }

    @Test
    public void performanceSelSortDescSorted() {
        int[] test = new int[2000];
        int j = 2000;
        for (int i = 0; i < 2000; i++) {
            test[i] = j--;
        }
        long start = System.currentTimeMillis();
        Sort.selectionSort(test);
        long end = System.currentTimeMillis();
        System.out.println("Select Sorting a desc sorted array took " + (end - start)+ " milliseconds");
    }
    //endregion
}