package org.kodluyoruz;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable{
    private final Semaphore semaphore;
    private final java.util.concurrent.BlockingQueue<Integer> myQueue;
    private final Long SLEEPTIME;

    public Producer(Semaphore semaphore, BlockingQueue<Integer> myQueue, Long sleepTime) {
        this.semaphore = semaphore;
        this.myQueue = myQueue;
        this.SLEEPTIME = sleepTime;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        try {
            semaphore.acquire();
            for (int i = 0; i < 5; i++) {
                myQueue.add(myQueue.size() + 1);
                Thread.sleep(SLEEPTIME);
            }
            System.out.println("Liste:" + myQueue);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(threadName );
            semaphore.release();
        }

    }
}
