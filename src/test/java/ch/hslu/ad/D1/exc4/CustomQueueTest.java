package ch.hslu.ad.D1.exc4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class CustomQueueTest {

    @Test
    public void enqueue() {
        CustomQueue<Character> queue = new CustomQueue<>(7);
        queue.enqueue('D');
        queue.enqueue('E');
        queue.enqueue('Q');
        queue.enqueue('U');
        queue.enqueue('E');
        queue.enqueue('U');
        queue.enqueue('E');
        assertEquals(7, queue.size());
    }

    @Test
    public void dequeue() {
        CustomQueue<Character> queue = new CustomQueue<>(7);
        queue.enqueue('D');
        queue.enqueue('E');
        queue.enqueue('Q');
        queue.enqueue('U');
        queue.enqueue('E');
        queue.enqueue('U');
        queue.enqueue('E');

        String test = "";
        while (!queue.isEmpty()) {
            test += queue.dequeue();
        }

        assertEquals(test, "DEQUEUE");
    }

    @Test
    public void size() {
        CustomQueue<Character> queue = new CustomQueue<>(7);
        queue.enqueue('D');
        queue.enqueue('E');
        queue.enqueue('Q');
        queue.enqueue('U');
        queue.enqueue('E');
        queue.enqueue('U');
        assertEquals(6, queue.size());
    }

    @Test
    public void isEmpty() {
        CustomQueue<Character> queue = new CustomQueue<>(6);
        assertTrue(queue.isEmpty());
    }

    @Test
    public void isFull() {
        CustomQueue<Character> queue = new CustomQueue<>(4);
        queue.enqueue('F');
        queue.enqueue('U');
        queue.enqueue('L');
        queue.enqueue('L');
        assertTrue(queue.isFull());
    }
}