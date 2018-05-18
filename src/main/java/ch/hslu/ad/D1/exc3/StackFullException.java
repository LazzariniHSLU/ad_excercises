package ch.hslu.ad.D1.exc3;

public class StackFullException extends Exception {
    public StackFullException(int size){
        super(String.format("Stack with size of %d is full", size));
    }
}
