package ch.hslu.ad.N4.exc01;

import java.util.Arrays;
import java.util.Random;

public class PerformanceMeasure {


    private static void testPerformance(final int[] array, final int threshold) {

        SortTask sort = new SortTask(array, threshold);
        long startTime, runTime;

        startTime = System.currentTimeMillis();
        sort.compute();
        runTime = System.currentTimeMillis() - startTime;
        System.out.print("Mergsort - Threshold: "  + runTime + "ms");

    }


    public static void main(final String args[]) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        int k = 50000000;
        long startTime, runTime;
        Random randomGenerator = new Random();
        int[] arraySource = new int[k];

        for (int i = 0; i < arraySource.length; i++) {
            // array[i] = array.length-i;
            arraySource[i] = randomGenerator.nextInt();
        }

        for(int i = 2; i<12; i++) {
            int[] array = Arrays.copyOf(arraySource, arraySource.length);
            testPerformance(array, k/i);
            System.out.println("- Threshold: Arraylength/" + i);
        }

    }
}
