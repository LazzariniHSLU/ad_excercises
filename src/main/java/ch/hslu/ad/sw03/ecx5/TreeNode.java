package ch.hslu.ad.sw03.ecx5;

import java.util.Objects;

public class TreeNode<T extends Comparable> implements Comparable { //Only extensions of the Comparable are allowed as T
    private TreeNode<T> leftChild;
    private TreeNode<T> rightChild;


    public TreeNode<T> getLeftChild() {
        return leftChild;
    }

    public TreeNode<T> getRightChild() {
        return rightChild;
    }

    public T getData() {
        return data;
    }

    private T data;

    public TreeNode(T data) {
        this.data = data;
    }


    public void setLeftChild(TreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(TreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public int compareTo(Object o) {
        return this.data.compareTo(o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode<?> treeNode = (TreeNode<?>) o;
        return Objects.equals(data, treeNode.data);
    }

    @Override
    public int hashCode() {

        return Objects.hash(data);
    }
}
