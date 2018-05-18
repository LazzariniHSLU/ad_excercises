package ch.hslu.ad.N1.exc2;

import java.util.ArrayList;

public class AdditionDemo {

    public static void main(String[] args) {
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(new AdditionTask(1, 10)));
        }

        for (Thread thread : threads) {
            thread.start();
        }
    }
}
