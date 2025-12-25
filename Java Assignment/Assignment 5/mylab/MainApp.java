class ThreadA extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread A: " + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ThreadB extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread B: Hello");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class MainApp {
    public static void main(String[] args) {

        ThreadA t1 = new ThreadA();
        ThreadB t2 = new ThreadB();

        try {
            t1.start();
            t1.join();
            t2.start();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }

        System.out.println("Both threads executed and logs inserted successfully.");
    }
}
