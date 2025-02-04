package week2.practice;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread t1 = new Thread(new IncrementThread(counter));
        Thread t2 = new Thread(new IncrementThread(counter));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("2000이 나올까요? 결과 : " + counter.getValue());
    }
}
