package ch.hslu.ad.sw03.ecx5;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeTest {

    @Test
    public void testToString() {
        BinaryTree<Integer> tree = new BinaryTree(5);
        tree.add(3);
        tree.add(2);
        tree.add(1);
        tree.add(4);
        tree.add(6);
        tree.add(7);
        tree.add(9);
        tree.add(8);
        tree.add(10);
        tree.print();
    }

    @Test
    public void add() {
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        tree.add(5);
        tree.add(3);
        tree.add(2);
        tree.add(1);
        tree.add(4);
        tree.add(6);
        tree.add(7);
        tree.add(9);
        tree.add(8);
        tree.add(10);


    }

    @Test
    public void size() {
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        tree.add(5);
        tree.add(3);
        tree.add(2);
        tree.add(1);
        tree.add(4);
        tree.add(6);
        tree.add(7);
        tree.add(9);
        tree.add(8);
        tree.add(10);
        assertEquals(10, tree.size());
    }
}