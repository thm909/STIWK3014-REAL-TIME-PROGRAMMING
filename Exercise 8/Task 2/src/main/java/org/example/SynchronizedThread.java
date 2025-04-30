package org.example;


public class SynchronizedThread extends Thread {
        static int counter = 0;

        public synchronized void run() {
            for (int i = 0; i < 1000; i++) {
                counter++;
            }
        }
    }

