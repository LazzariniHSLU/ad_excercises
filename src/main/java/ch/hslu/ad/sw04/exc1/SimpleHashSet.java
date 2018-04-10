package ch.hslu.ad.sw04.exc1;

public class SimpleHashSet<T> {
    private T[] data;

    public SimpleHashSet(int lenght) {
        this.data = (T[]) new Object[lenght];
    }

    public int length(){
        return this.data.length;
    }

    public int getIndex(T item){
        return item.hashCode() % this.data.length;
    }

    public void add(T item){
        if(!this.contains(item)){
          int index = item.hashCode() % this.data.length;
          this.data[index] = item;
        }
    }

    public boolean contains(T item){
        return this.data[getIndex(item)] != null;
    }

    public void remove(T item){
        this.data[getIndex(item)] = null;
    }
}
