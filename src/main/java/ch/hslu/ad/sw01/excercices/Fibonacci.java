package ch.hslu.ad.sw01.excercices;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Array;

public class Fibonacci {
    Logger LOG = LogManager.getLogger(Fibonacci.class);


    public int fiboRec1(int n) {
        if (n <= 0) { //rekursionsbasis
            return 0;
        } else if (n == 1) { //rekursionsbasis
            return 1;
        } else { //rekursionsvorschrift
            return fiboRec1(n - 1) + fiboRec1(n - 2);
        }
    }

    public int[] fiboRec2(int n){
        int[] cache = new int[n+1];
        return fiboRec2(n, cache);
    }

    private int[] fiboRec2(int n, int[] cache) {
        if (n <= 0) {   //rekursionsbasis
            cache[0] = 0;
            return cache;
        } else if (n == 1) { //rekursionsbasis
            cache[1] = 1;
            return cache;
        } else {  //rekursionsvorschrift
            if (cache[n - 2] == 0) { //Wenn Array[n] leer ist
                cache = fiboRec2(n - 2, cache);
            }
            if (cache[n - 1] == 0) {
                cache = fiboRec2(n - 1, cache);
            }
            cache[n] = cache[n - 2] + cache[n - 1];

            return cache;
        }
    }

    public int fiboIter(int n) {
        int a = 0, b = 1, c = 1;
        for (int i = 0; i < n; i++) {
            a = b;
            b = c;
            c = a + b;
        }
        return a;
    }

}
