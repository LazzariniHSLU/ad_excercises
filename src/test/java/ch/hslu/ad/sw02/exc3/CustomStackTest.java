package ch.hslu.ad.sw02.exc3;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomStackTest {

    @Test
    public void isEmpty() {
        CustomStack<Integer> stack = new CustomStack(3);
        assertEquals(true, stack.isEmpty());
    }

    @Test
    public void isFull() {
        CustomStack<Integer> stack = new CustomStack(3);
        try {
            stack.push(4);
            stack.push(3);
            stack.push(2);
        }
        catch (StackFullException ex){
            Assert.fail("Exception caught");
        }
        assertEquals(true, stack.isFull());

    }

    @Test
    public void size() {
        CustomStack<Integer> stack = new CustomStack(3);
        try {
            stack.push(4);
            stack.push(3);
            stack.push(2);
        }
        catch (StackFullException ex){
            Assert.fail("Exception caught");
        }
        assertEquals(3, stack.size());
    }

    @Test
    public void pushFullStack() {
        CustomStack<Integer> stack = new CustomStack<>(1);
        try{
            stack.push(3);
            stack.push(2);
            Assert.fail();
        }
        catch (StackFullException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void pop() {
        CustomStack<Integer> stack = new CustomStack<>(3);
        try{
            stack.push(3);
            stack.push(2);
            stack.push(1);
        }
        catch (StackFullException e) {
            e.printStackTrace();
        }
        int returnValue = stack.pop();
        assertEquals(1, returnValue);
        assertEquals(2, stack.size());
    }

    @Test
    public void peek() {
        CustomStack<Integer> stack = new CustomStack<>(3);
        try{
            stack.push(3);
            stack.push(2);
            stack.push(1);
        }
        catch (StackFullException e) {
            e.printStackTrace();
        }
        int returnValue = stack.peek();
        assertEquals(1, returnValue);
        assertEquals(3, stack.size());
    }
}