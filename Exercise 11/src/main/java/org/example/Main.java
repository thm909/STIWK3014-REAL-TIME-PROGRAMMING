package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BankAccountWithLock account = new BankAccountWithLock(1000.0);

        Thread reader1 = new Thread(() -> account.getBalance(), "Reader-1");
        Thread reader2 = new Thread(() -> account.getBalance(), "Reader-2");
        Thread writer1 = new Thread(() -> account.deposit(500), "Writer-1");
        Thread writer2 = new Thread(() -> account.withdraw(300), "Writer-2");
        Thread writer3 = new Thread(() -> account.withdraw(1500), "Writer-3");

        writer1.start();
        reader1.start();
        writer2.start();
        reader2.start();
        writer3.start();
    }
}
