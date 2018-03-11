package ch.hslu.ad.sw02.exc2;

import org.omg.CosNaming.NamingContextPackage.NotFound;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomList<T> implements Iterable<T> {
    private Node<T> head;
    private int size = 0;

    private class CustomListIterator implements Iterator<T> {
        private Node<T> node;

        public CustomListIterator(Node<T> node) {
            this.node = node;
        }

        @Override
        public boolean hasNext() {
            if (node == null) {
                return false;
            } else {
                return true;
            }
        }

        @Override
        public T next() {
            Node returnElement = null;
            if (this.hasNext()) {
                returnElement = node;
                this.node = node.getNext();

            } else {
                throw new NoSuchElementException();
            }
            return (T) returnElement.getData();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new CustomListIterator(head);
    }

    public void add(T element) {
        Node<T> old = this.head;
        this.head = new Node<T>(element);
        this.head.setNext(old);
        size += 1;
    }

    public void add(CustomList<T> elementsToAdd){
        for(T element : elementsToAdd){
            this.add(element);
        }
    }

    public void removeFirst() {
        Node<T> newHead = head.getNext();
        head = newHead;
        size--;
    }

    public void removeLast() {
        //TODO: Implement
    }

    public void remove(T obj) {
        Node<T> node = head;
        Node<T> previuosNode = null;
        for (int i = 0; i < this.size; i++) {
            if (node.getData().equals(obj) && previuosNode == null) { //ist der erste in der Liste
                this.removeFirst();
                return;
            } else if (node.getData().equals(obj) && previuosNode != null) {
                Node<T> nextNode = node.getNext();
                previuosNode.setNext(nextNode);
                size--;
                return;
            }
            previuosNode = node;
            node = node.getNext();
        }

    }

    public int size() {
        return this.size;
    }

}
