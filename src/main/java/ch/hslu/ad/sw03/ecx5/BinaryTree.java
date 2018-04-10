package ch.hslu.ad.sw03.ecx5;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class BinaryTree<T extends Comparable> implements Tree<T> {

    private TreeNode<T> root;
    private int size = 1;

    public BinaryTree(T root) {
        this.root = new TreeNode(root);
    }

    public BinaryTree(){

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
        return search(root, element);
    }

    private boolean search(TreeNode node, T element) {
        if (node == null) {
            return false;
        }
        if (element.equals(node.getData())) {
            return true;
        }
        if (element.compareTo(node.getData()) > 0) {
            return search(node.getRightChild(), element);
        } else if (element.compareTo(node.getData()) < 0) {
            return search(node.getLeftChild(), element);
        }
        return false;

    }

    @Override
    public boolean remove(T element) {
        return remove(root, element);
    }

    private boolean remove(TreeNode node, T element){
        if(node == null){
            return false;
        }
        if(element.equals(node.getData())){
            //TODO: Remove
            if(node.getLeftChild() == null && node.getRightChild() == null){
                node = null;
                this.size -= 1;
            }
            return true;
        }
        if(element.compareTo(node.getData())>0){
            return remove(node.getRightChild(), element);
        }
        else if(element.compareTo(node.getData())<0){
            return remove(node.getLeftChild(), element);
        }
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
            System.out.println(prefix + (isLeft ? "|-- " : "\\-- ") + n.getData());

            print(prefix + (isLeft ? "|   " : "    "), n.getLeftChild(), true);
            print(prefix + (isLeft ? "|   " : "    "), n.getRightChild(), false);
        }
    }

    public ArrayList Preorder(){
        return Preorder(root, new ArrayList());
    }

    private ArrayList Preorder(TreeNode node, ArrayList list){
        if(node != null){
            list.add(node.getData());
            Preorder(node.getLeftChild(), list);
            Preorder(node.getRightChild(), list);
            return list;
        }
        return list;
    }

    public ArrayList Inorder() {
        return Inorder(root, new ArrayList());
    }

    private ArrayList Inorder(TreeNode node, ArrayList list) {
        if(node != null){
            Inorder(node.getLeftChild(), list);
            list.add(node.getData());
            Inorder(node.getRightChild(), list);
            return list;
        }
        return list;
    }
}
