package ch.hslu.ad.A4.exc5;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Search {
    /**
     * Durchsucht eine Zeichenkette mittels quickSearch.
     *
     * @param a Zeichenkette, die durchsucht wird.
     * @return Index der Fundstelle oder ‐1, falls Pattern in a nicht gefunden wurde.
     */
    public static int quickSearch(final String a, final String p) {
        final int n = a.length();
        final int m = p.length();
        final int range = 256; // ‐> ASCII‐Range
        final int[] shift = new int[range];
        // init shift‐array
        for (int i = 0; i < range; i++) {
            shift[i] = m + 1;
        }
        // overwrite fields according pattern
        for (int i = 0; i < m; i++) {
            shift[p.charAt(i)] = m - i;
        }
        // search
        int i = 0; // index to string
        int j = 0; // index to pattern p
        do {
            if (a.charAt(i + j) == p.charAt(j)) { // match
                j++;
            } else { // mismatch
                if ((i + m) < n) { // a.charAt(i1+m) is not outside a
                    i += shift[a.charAt(i + m)]; // jump forward
                    j = 0;
                } else {
                    break; // (mismatch) && (no shift is possible)
                }
            }
        } while ((j < m) && ((i + m) <= n));
        // (pattern p not found) && (end of a not reached)
        if (j == m) {
            return i; // pattern found
        } else {
            return -1; // pattern not found
        }
    }

    public static int optimalMismatch(String string, String pattern) {
        int[][] helperP = new int[2][pattern.length()];

        final int n = string.length();
        final int m = pattern.length();
        final int range = 256; // ‐> ASCII‐Range
        final int[] shift = new int[range];
        // init shift-array
        for (int i = 0; i < range; i++) {
            shift[i] = m + 1;
        }

        //init helper-array
        for (int i = 0; i < m; i++) {
            helperP[0][i] = pattern.charAt(i);
            helperP[1][i] = i;
        }


        // overwrite fields according pattern
        for (int i = 0; i < m; i++) {
            shift[pattern.charAt(i)] = m - i;
        }
        // search
        int i = 0; // index to string
        int j = 0; // index to pattern p
        do {
            if (string.charAt(i + helperP[1][j]) == helperP[0][j]) { // match
                j++;
            } else { // mismatch
                if (((i + helperP[1][j]) + m) < n) { // a.charAt(i1+m) is not outside a
                    i += shift[string.charAt(i + m)];// + helperP[1][j]))]; // jump forward
                    swapArray(helperP, j);
                    j = 0;
                } else {
                    break; // (mismatch) && (no shift is possible)
                }
            }
        } while ((j < m) && (((i + helperP[1][j]) + m) <= n));
        // (pattern p not found) && (end of a not reached)
        if (j == m) {
            return i; // pattern found
        } else {
            return -1; // pattern not found
        }
    }

    private static void swapArray(int[][] array, int actualIndex) {
        if (actualIndex != 0) {
            int a = array[0][actualIndex - 1];
            int b = array[1][actualIndex - 1];

            array[0][actualIndex - 1] = array[0][actualIndex];
            array[1][actualIndex - 1] = array[1][actualIndex];

            array[0][actualIndex] = a;
            array[1][actualIndex] = b;
        }
    }

}
