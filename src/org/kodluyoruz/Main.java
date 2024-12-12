package org.kodluyoruz;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        final int SIZE = 300;
        final int LIMIT = 3;
        Semaphore semaphore = new Semaphore(LIMIT);
        java.util.concurrent.BlockingQueue<Integer> myQueue = new ArrayBlockingQueue<>(SIZE);
        Thread thread1 = new Thread(new Producer(semaphore, myQueue, 1000L), "Thread A");
        Thread thread2 = new Thread(new Producer(semaphore, myQueue, 1000L), "Thread B");
        Thread thread3 = new Thread(new Producer(semaphore, myQueue, 1000L), "Thread C");

        try {
            thread1.start();
            thread1.join();

            thread2.start();
            thread2.join();

            thread3.start();
            thread3.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
/*
        Thread.sleep(2000);
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        myQueue.add(4);

        System.out.println(myQueue.peek());

        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());  */

    }
}
