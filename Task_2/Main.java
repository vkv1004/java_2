package Task_2;

class Thread0 extends Thread {
    private String name;
    private int count;

    public Thread0(String name, int count) {
        this.name = name;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.println(name);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Thread thr1 = new Thread0("Первый", 5);
        Thread thr2 = new Thread0("Второй", 7);
        thr1.start();
        thr2.start();
    }
}