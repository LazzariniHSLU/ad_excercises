package ch.hslu.ad.A2.exc04;

public class FixedSizeHeap implements IntegerHeap {
    int[] array;
    int nextIndex = 0;
    int size = 0;

    public FixedSizeHeap(int size) {
        this.array = new int[size];
    }

    @Override
    public void add(int number) {
        if (!arrayIsFull()) {
            array[nextIndex] = number;
            grow(nextIndex);
            nextIndex++;
            size++;
        }
    }

    private void grow(int index) {
        int parent = (index - 1) / 2;
        if (array[index] > array[parent]) {
            swap(index, parent);
            if (parent > 0) {
                grow(parent);
            }
        }
    }

    private void swap(int index, int parent) {
        int value = array[index];
        array[index] = array[parent];
        array[parent] = value;
    }

    private void shrink(int index) {
        final int size = this.size;
        boolean sunk = false;
        int l = 1, f = 0, r = 2;
        while (!sunk && (l < size || r < size)) {
            int father = array[f];
            int left = l < size ? array[l] : father;
            int right = r < size ? array[r] : father;
            if (father < left || father < right) {
                int biggerChildIndex = left > right ? l : r;
                swap(f, biggerChildIndex);
                f = biggerChildIndex;
                l = (2 * f) + 1;
                r = 2 * (f + 1);
            } else {
                sunk = true;
            }
        }
    }

    @Override
    public int getMax() {
        if (isEmpty()) {
            throw new IllegalStateException("Empty Heap");
        }
        int max = array[0];
        array[0] = array[size - 1];
        array[size -1] = 0;
        shrink(0);


        return max;
    }

    @Override
    public boolean arrayIsFull() {
        return nextIndex == array.length;
    }

    @Override
    public boolean isEmpty() {
        return (nextIndex == 0);
    }

    public void print() {
        for (int i : array) {
            System.out.println(i);
        }
    }
}
