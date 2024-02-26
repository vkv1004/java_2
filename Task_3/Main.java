package Task_3;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[8];
        Thread thr1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (arr) {
                    for (int i = 0; i < 8; i++) {
                        arr[i] = i*i;
                        System.out.println(arr[i]);
                    }
                    arr.notify();
                }
            }
        });
        Thread thr2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (arr) {
                    try {
                        arr.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (int i = 0; i < 8; i++) {
                        System.out.print(arr[i] + " ");
                    }
                }
            }
        });
        thr2.start();
        thr1.start();
    }
}