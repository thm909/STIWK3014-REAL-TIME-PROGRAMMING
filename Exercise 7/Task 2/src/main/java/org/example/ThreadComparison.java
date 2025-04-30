package org.example;

public class ThreadComparison {
    public static void main(String[] args) throws InterruptedException {

        Thread[] normalThreads = new Thread[10];
        long startNormal = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            normalThreads[i] = new Thread();
            normalThreads[i].start();
        }
        for (int i = 0; i < 10; i++) {
            normalThreads[i].join();
        }
        long endNormal = System.nanoTime();

        Thread[] syncThreads = new Thread[10];
        long startSync = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            syncThreads[i] = new SynchronizedThread();
            syncThreads[i].start();
        }
        for (int i = 0; i < 10; i++) {
            syncThreads[i].join();
        }
        long endSync = System.nanoTime();


        double timeNormal = (endNormal - startNormal) / 1_000_000_000.0;
        double timeSync = (endSync - startSync) / 1_000_000_000.0;

        System.out.printf("Normal thread = %.9f seconds\n", timeNormal);
        System.out.printf("Synchronized thread = %.9f seconds\n", timeSync);
    }
}