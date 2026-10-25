
class MyThread extends Thread {
    boolean suspended = false;
    boolean stopped = false;

    public synchronized void suspendThread() {
        suspended = true;
    }

    public synchronized void resumeThread() {
        suspended = false;
        notify();
    }

    public synchronized void stopThread() {
        stopped = true;
        suspended = false;
        notify();
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            synchronized (this) {
                while (suspended) {
                    try {
                        wait();
                    } catch (Exception e) {
                    }
                }

                if (stopped)
                    break;
            }

            System.out.println("Count: " + i);

            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
    }
}

public class Lab5 {
    public static void main(String[] args)
            throws Exception {

        MyThread t = new MyThread();

        t.start();
        Thread.sleep(1000);

        t.suspendThread();
        System.out.println("Thread Suspended");
        Thread.sleep(1000);

        t.resumeThread();
        System.out.println("Thread Resumed");
        Thread.sleep(1000);

        t.stopThread();
        System.out.println("Thread Stopped");
    }
}
