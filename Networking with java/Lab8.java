
class PriorityThread extends Thread {

    PriorityThread(String name) {
        super(name);
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(
                getName() + " : " + i
                + " Priority: " + getPriority()
            );
        }
    }
}

public class Lab8 {
    public static void main(String[] args) {

        PriorityThread t1 =
            new PriorityThread("Low Priority");

        PriorityThread t2 =
            new PriorityThread("Normal Priority");

        PriorityThread t3 =
            new PriorityThread("High Priority");

        t1.setPriority(1);
        t2.setPriority(5);
        t3.setPriority(10);

        t1.start();
        t2.start();
        t3.start();
    }
}
