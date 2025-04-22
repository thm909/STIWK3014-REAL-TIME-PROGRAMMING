public class ThreadPrinter extends Thread {

    private int threadNumber;

    public ThreadPrinter(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        try {
            System.out.println("Thread " + threadNumber + ": ONE");
            Thread.sleep(10);
            System.out.println("Thread " + threadNumber + ": TWO");
            Thread.sleep(10);
            System.out.println("Thread " + threadNumber + ": THREE");
            Thread.sleep(10);
            System.out.println("Thread " + threadNumber + ": xxxxxxxxxxx");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}