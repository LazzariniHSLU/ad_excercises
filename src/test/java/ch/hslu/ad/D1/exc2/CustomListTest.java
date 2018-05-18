package ch.hslu.ad.D1.exc2;

import org.junit.Test;

import static org.junit.Assert.*;

public class CustomListTest {

    @Test
    public void add() {
        CustomList<Integer> testList = new CustomList();
        testList.add(2);
        testList.add(1);
    }

    @Test
    public void addMultiple(){
        CustomList<Integer> testList = new CustomList<>();
        testList.add(2);
        testList.add(4);
        CustomList<Integer> elementsToAdd = new CustomList<>();
        elementsToAdd.add(3);
        elementsToAdd.add(1);
        testList.add(elementsToAdd);
        assertEquals(4, testList.size());
    }

    @Test
    public void size() {
        CustomList<Integer> testList = new CustomList<>();
        int counter = 0;
        testList.add(2);
        testList.add(1);
        for(int i: testList){
            counter ++;
        }
        assertEquals(counter, testList.size());
    }

    @Test
    public void removeFirst() {
        CustomList<Integer> testList = new CustomList<>();
        testList.add(2);
        testList.add(1);
        testList.removeFirst();
        assertEquals(1, testList.size());
    }

    @Test
    public void removeFirstPosition() {
        CustomList<Integer> testList = new CustomList<>();
        testList.add(2);
        testList.add(1);
        testList.add(4);
        testList.remove(4);
        assertEquals(2, testList.size());
    }
    @Test
    public void remove() {
        CustomList<Integer> testList = new CustomList<>();
        testList.add(2);
        testList.add(4);
        CustomList<Integer> elementsToAdd = new CustomList<>();
        elementsToAdd.add(3);
        elementsToAdd.add(1);
        testList.add(elementsToAdd);
        testList.remove(1);
        assertEquals(3, testList.size());
    }

    @Test
    public void removeLastPosition() {
        CustomList<Integer> testList = new CustomList<>();
        testList.add(2);
        testList.add(1);
        testList.add(4);
        testList.add(3);
        testList.remove(2);
        assertEquals(3, testList.size());
    }

    @Test
    public void removeUnexisting() {
        CustomList<Integer> testList = new CustomList<>();
        testList.add(2);
        testList.add(1);
        testList.add(4);
        testList.add(3);
        testList.remove(0);
        assertEquals(4, testList.size());
    }
}