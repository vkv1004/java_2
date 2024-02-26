package Task_4;

public class Main {
    private static final Object lock = new Object();
    private static int count = 1;

    public static void main(String[] args) {
        Thread thr1 = new Thread(new PrintOdd());
        Thread thr2 = new Thread(new PrintEven());

        thr1.start();
        thr2.start();
    }

    static class PrintOdd implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                while (count <= 10) {
                    if (count % 2 != 0) {
                        System.out.println(count);
                        count++;
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    static class PrintEven implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                while (count <= 10) {
                    if (count % 2 == 0) {
                        System.out.println(count);
                        count++;
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
