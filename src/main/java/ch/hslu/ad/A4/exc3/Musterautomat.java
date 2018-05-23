package ch.hslu.ad.A4.exc3;

public class Musterautomat {
    /**
     * Erzeugt für das Pattern einen Musterautomaten.
     *
     * @param pattern Pattern, nach dem später gesucht werden soll.
     * @return Musterautomat in Form eines int‐Arrays.
     */
    private static int[] initNext(final String pattern) {
        final int m = pattern.length();
        final int[] next = new int[m];
        int i = 0;
        int j = -1;
        next[0] = -1;
        // special value! (‐1 = no reference to a following state)
        do {
            if ((j == -1) || (pattern.charAt(i) == pattern.charAt(j))) {
            // (j == ‐1) must be first operand!
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        } while (i < (m - 1));
        return next;
    }

    public static int kmpSearch(final String string, final String pattern) {
        final int n = string.length();
        final int m = pattern.length();
        int i = 0; // index to string a
        int j = 0; // index to pattern p respectively state
        // 1. generate next
        int[] next = initNext(pattern);
        // 2. search for p
        do {
            if ((j == -1) ||(string.charAt(i) == pattern.charAt(j))){ // (j == ‐1) first!
                i++; // process next character
                j++;
            } else{
                j = next[j]; // go to next state
            }
        } while ((j < m) && (i < n));
        if (j == m) {
            return (i -m); // pattern found: index to position in a
        } else {
            return -1; // pattern not found
        }
    }
}
