class MyThread extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Count: " + i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Thread Interrupted");
                return;
            }
        }
    }
}

public class Lab7 {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();

        try {
            Thread.sleep(2000);
            t.interrupt();
            System.out.println("Thread Stopped");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}