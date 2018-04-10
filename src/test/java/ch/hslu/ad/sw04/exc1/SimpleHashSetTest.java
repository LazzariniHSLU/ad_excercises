package ch.hslu.ad.sw04.exc1;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleHashSetTest {

    @Test
    public void length() {
        SimpleHashSet<Integer> hashSet = new SimpleHashSet<>(10);
        assertEquals(10, hashSet.length());
    }

    @Test
    public void getIndex() {
        SimpleHashSet<Integer> hashSet = new SimpleHashSet<>(10);
        Integer value = new Integer(1);
        int index = value.hashCode() % 10;
        assertEquals(index, hashSet.getIndex(value));
    }

    @Test
    public void add() {
        SimpleHashSet<Integer> hashSet = new SimpleHashSet<>(10);
        hashSet.add(1);
        assertTrue(hashSet.contains(1));
    }

    @Test
    public void remove() {
        SimpleHashSet<Integer> hashSet = new SimpleHashSet<>(10);
        hashSet.add(1);
        hashSet.add(2);
        hashSet.remove(1);
        assertFalse(hashSet.contains(1));
    }
}