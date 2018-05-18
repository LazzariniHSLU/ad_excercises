package ch.hslu.ad.A2.exc04;

import org.junit.Test;

public class FixedSizeHeapTest {

    @Test
    public void add() {
        FixedSizeHeap heap = new FixedSizeHeap(6);
        heap.add(20);
        heap.add(10);
        heap.add(5);
        heap.add(12);
        heap.add(7);
        heap.add(50);

        heap.print();
    }

    @Test
    public void shrink(){
        FixedSizeHeap heap = new FixedSizeHeap(6);
        heap.add(20);
        heap.add(10);
        heap.add(5);
        heap.add(12);
        heap.add(7);
        heap.add(50);
        heap.getMax();

        heap.print();

    }
}