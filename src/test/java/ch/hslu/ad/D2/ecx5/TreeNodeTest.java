package ch.hslu.ad.D2.ecx5;

import org.junit.Test;

import static org.junit.Assert.*;

public class TreeNodeTest {

    @Test
    public void equals() {
        TreeNode<Integer> node = new TreeNode<>(1);
        assertTrue(node.equals(new TreeNode<>(1)));
    }
}