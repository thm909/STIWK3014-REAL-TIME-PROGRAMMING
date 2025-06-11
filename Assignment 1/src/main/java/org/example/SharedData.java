package org.example;

import java.util.concurrent.atomic.AtomicInteger;

public class SharedData {
    public static AtomicInteger javaFileCount = new AtomicInteger(0);
    public static AtomicInteger issueCount = new AtomicInteger(0);
}
