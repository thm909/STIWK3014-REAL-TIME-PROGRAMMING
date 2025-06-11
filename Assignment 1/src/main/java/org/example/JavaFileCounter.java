package org.example;
import java.io.File;

public class JavaFileCounter extends Thread {
    private final File folder;

    public JavaFileCounter(File folder) {
        this.folder = folder;
        setName("JavaFileCounter-Thread");
    }

    @Override
    public void run() {
        countJavaFiles(folder);
    }

    private void countJavaFiles(File file) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    countJavaFiles(f);
                } else if (f.getName().endsWith(".java")) {
                    org.example.SharedData.javaFileCount.incrementAndGet();
                }
            }
        }
    }
}
