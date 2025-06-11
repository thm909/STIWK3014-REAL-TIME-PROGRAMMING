package org.example;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.File;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        File folder = new File("C:\\Users\\thmin\\IdeaProjects");

        JavaFileCounter fileThread = new JavaFileCounter(folder);
        IssueCounter issueThread = new IssueCounter(folder);

        fileThread.start();
        issueThread.start();

        fileThread.join();
        issueThread.join();

        System.out.println("Number of Java Files = " + org.example.SharedData.javaFileCount.get());
        System.out.println("Number of Issues = " + org.example.SharedData.issueCount.get());
    }
}
