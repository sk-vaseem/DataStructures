class SharedResource {
    synchronized void printNumbers(String threadName) {
        System.out.println(threadName + " started printing...");
        for (int i = 1; i <= 10; i++) {
            System.out.println(threadName + " prints: " + i);
            try {
                Thread.sleep(500); // Simulates a delay
            } catch (InterruptedException e) {
                System.out.println(threadName + " interrupted.");
            }
        }
        System.out.println(threadName + " finished printing.");
    }
}

class MyThread extends Thread {
    SharedResource resource;

    MyThread(SharedResource resource) {
        this.resource = resource;
    }

    public void run() {
        resource.printNumbers(Thread.currentThread().getName());
    }
}

class MyRunnable implements Runnable {
    SharedResource resource;

    MyRunnable(SharedResource resource) {
        this.resource = resource;
    }

    public void run() {
        resource.printNumbers(Thread.currentThread().getName());
    }
}

public class Main {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        MyThread t1 = new MyThread(resource);
        Thread t2 = new Thread(new MyRunnable(resource));

        t1.setName("Thread 1");
        t2.setName("Thread 2");

        t1.start();
        t2.start();
    }
}
