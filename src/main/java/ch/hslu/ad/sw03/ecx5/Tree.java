package ch.hslu.ad.sw03.ecx5;

public interface Tree<T> {

     boolean add(T element);
     boolean search(T element);
     boolean remove(T element);
     int size();
}
