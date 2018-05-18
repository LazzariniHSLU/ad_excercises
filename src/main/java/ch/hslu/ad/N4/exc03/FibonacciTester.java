package ch.hslu.ad.N4.exc03;

import java.util.concurrent.ForkJoinPool;
import java.util.function.Function;

import ch.hslu.ad.E1.excercices.Fibonacci;
import org.perf4j.StopWatch;

public class FibonacciTester {

    private static int FIBONUMBER = 37;

    public static void main(String[] args) throws InterruptedException {
        Fibonacci fib = new Fibonacci();

        //Da mac OS die CPU Frequenz immer tief hält, ist der erste Aufruf laengsamer,
        // da die CPU "warm" werden muss

        System.out.println("ForkJoin:");
        perf4jCheck(f->fiboNumberWithForkJoinPool(f), FIBONUMBER);

        System.out.println("CommonPool:");
        perf4jCheck(f->fiboNumberWithCommonPool(f), FIBONUMBER);

        System.out.println("Iter:");
        perf4jCheck(f->fib.fiboIter(f), FIBONUMBER);

        System.out.println("Rec:");
        perf4jCheck(f->fib.fiboRec1(f), FIBONUMBER);

    }

    static void performanceCheck(Function<Integer, Integer> func, final int n) {
        long start = System.currentTimeMillis();
        int test = func.apply(n);
        long end = System.currentTimeMillis();
        System.out.println("It took " + (end - start) + "ms to calculate " + test + "\n");
    }

    static void perf4jCheck(Function<Integer, Integer> func, final int n){
        StopWatch watch =  new StopWatch();
        int test = func.apply(n);
        System.out.println(watch.stop("Result: " + test) + "\n");
    }

    public static Integer fiboNumberWithCommonPool(Integer n) {
        FibonacciTask fib = new FibonacciTask(n);
        return fib.invoke();
    }

    public static Integer fiboNumberWithForkJoinPool(final Integer n) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        FibonacciTask fib = new FibonacciTask(n);
        return forkJoinPool.invoke(fib);
    }
}
