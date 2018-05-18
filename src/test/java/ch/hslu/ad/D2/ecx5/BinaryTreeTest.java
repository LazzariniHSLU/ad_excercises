package ch.hslu.ad.D2.ecx5;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BinaryTreeTest {

    public BinaryTree<Integer> getTestTree(){
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
        return tree;
    }



    @Test
    public void testPrint() {
        BinaryTree<Integer> tree = getTestTree();
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
        assertEquals(10, tree.size());
    }

    @Test
    public void testSearch() {
        BinaryTree tree = getTestTree();
        assertTrue(tree.search(7));
    }

    @Test
    public void testSearchNotContained() {
        BinaryTree tree = getTestTree();
        assertFalse(tree.search(12));
    }

    @Test
    public void testRemove() {
        BinaryTree tree = getTestTree();
        assertTrue(tree.remove(1));
        assertEquals(9, tree.size());
        tree.print();
    }

    @Test
    public void size() {
        BinaryTree<Integer> tree = getTestTree();
        assertEquals(10, tree.size());
    }

    @Test
    public void testInorder() {
        BinaryTree tree = getTestTree();
        ArrayList list = tree.Inorder();
        assertEquals(1, list.get(0));
        assertEquals(10, list.get(9));
        assertEquals(10, list.size());
    }

    @Test
    public void testPreorder() {
        BinaryTree tree = getTestTree();
        ArrayList list = tree.Preorder();
        assertEquals(5, list.get(0));
        assertEquals(10, list.get(9));
        assertEquals(10, list.size());
    }

    @Test
    public void testInorderNull() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        ArrayList list = tree.Inorder();
        assertEquals(0, list.size());
    }
}