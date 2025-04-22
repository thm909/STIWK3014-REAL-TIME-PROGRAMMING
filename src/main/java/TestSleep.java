public class TestSleep {
    public static void main(String[] args) {

        for (int i = 1; i <= 20; i++) {
            ThreadPrinter thread = new ThreadPrinter(i);
            thread.start();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}