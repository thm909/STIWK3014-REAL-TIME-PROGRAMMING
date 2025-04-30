package org.example;

public class NormalThread {
    static int counter = 0;

    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter++;
        }
    }
}

