package ch.hslu.ad.sw01.excercices;

import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciTest {

    @Test
    public void fiboRec1Test9() {
        Fibonacci fib = new Fibonacci();
        assertEquals(34, fib.fiboRec1(9));
    }

    @Test
    public void fiboRec1Test0() {
        Fibonacci fib = new Fibonacci();
        assertEquals(0, fib.fiboRec1(0));
    }

    @Test
    public void fiboRec1Test1() {
        Fibonacci fib = new Fibonacci();
        assertEquals(1, fib.fiboRec1(1));
    }

    @Test
    public void fiboRec1Test10() {
        Fibonacci fib = new Fibonacci();
        assertEquals(55, fib.fiboRec1(10));
    }

    @Test
    public void fiboRec1Test15() {
        Fibonacci fib = new Fibonacci();
        assertEquals(610, fib.fiboRec1(15));
    }

    @Test
    public void fiboRec2Test9() {
        Fibonacci fib = new Fibonacci();
        assertEquals(34, fib.fiboRec2(9)[9]);
        assertEquals(610, fib.fiboRec2(15)[15]);

    }

    @Test
    public void fiboRec2Test10() {
        Fibonacci fib = new Fibonacci();
        assertEquals(55, fib.fiboRec2(10)[10]);
    }

    @Test
    public void fiboRec2Test15() {
        Fibonacci fib = new Fibonacci();
        assertEquals(610, fib.fiboRec2(15)[15]);
    }

    @Test
    public void fiboIter() {
        Fibonacci fib = new Fibonacci();
        assertEquals(34, fib.fiboIter(9));
    }
    @Test
    public void fiboIter0() {
        Fibonacci fib = new Fibonacci();
        assertEquals(0, fib.fiboIter(0));
    }

    @Test
    public void fiboIter1() {
        Fibonacci fib = new Fibonacci();
        assertEquals(1, fib.fiboIter(1));
    }
}