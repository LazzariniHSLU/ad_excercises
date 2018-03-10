package ch.hslu.ad.sw01.excercices;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Aha_Beispiel {
    static final Logger log = LogManager.getLogger(Aha_Beispiel.class);
    static int counterTask1;
    static int counterTask2;
    static int counterTask3;

    public static void main(String[] args){
        task(200);
    }

    public static void task(final int n) {
        task1();
        task1();
        task1();
        task1();
        for (int i = 0; i < n; i++) {
            task2();
            task2();
            task2();
            for (int j = 0; j < n; j++) {
                task3();
                task3();
            }
        }
        log.info("Task1 = " + counterTask1 + " Task2 "+ counterTask2 + " Task3 " + counterTask3);
    }

    public static void task1() {
        counterTask1 += 1;
    }

    public static void task2() {
        counterTask2 += 1;
    }

    public static void task3() {
        counterTask3 += 1;
    }
}

