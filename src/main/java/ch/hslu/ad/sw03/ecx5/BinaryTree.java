package ch.hslu.ad.sw03.ecx5;

import ch.hslu.ad.sw02.exc4.CustomQueue;

public class BinaryTree<T extends Comparable> implements Tree<T> {

    private TreeNode<T> root;
    private int size = 1;

    public BinaryTree(T root) {
        this.root = new TreeNode(root);
    }

    @Override
    public boolean add(T element) {
        if (element == null) {
            throw new NullPointerException();
        }
        if (root.getData().equals(element)) {
            return true; // already inside our Tree
        }
        return add(root, element);
    }

    /***
     *
     * @param node
     * @param element
     * @return false if element has not been added and true if element has been added to tree
     */
    private boolean add(TreeNode<T> node, T element) {
        if (node == null) {
            return false;
        }
        if (node.getData().equals(element)) {
            return true;
        }
        if (element.compareTo(node.getData()) < 0) {
            if (node.getLeftChild() == null) {
                //not set yet
                node.setLeftChild(new TreeNode<>(element));
                size += 1;
                return true;
            }

            return add(node.getLeftChild(), element);

        }

        if (element.compareTo(node.getData()) > 0) {
            if (node.getRightChild() == null) {
                node.setRightChild(new TreeNode<>(element));
                size += 1;
                return true;
            }
            return add(node.getRightChild(), element);

        }
        return false;
    }

    @Override
    public boolean search(T element) {
        return false;
    }

    @Override
    public boolean remove(T element) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    public void print() {

        print("", root, false);
    }

    private void print(String prefix, TreeNode n, boolean isLeft) {
        if (n != null) {
            System.out.println (prefix + (isLeft ? "|-- " : "\\-- ") + n.getData());
            print(prefix + (isLeft ? "|   " : "    "), n.getLeftChild(), true);
            print(prefix + (isLeft ? "|   " : "    "), n.getRightChild(), false);
        }
    }
}
