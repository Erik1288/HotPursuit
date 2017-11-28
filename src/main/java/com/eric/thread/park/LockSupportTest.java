package com.eric.thread.park;

import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.LockSupport;

/**
 * Created by feierik on 17/11/24.
 */
public class LockSupportTest {

    @Test
    public void testPark() throws IOException {

        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread 1 slept.");
                System.out.println("thread 1 park.");

                LockSupport.park(Thread.currentThread());

                System.out.println("thread 1 done park.");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread 2 slept.");
                System.out.println("thread 2 unpark.");

                LockSupport.unpark(thread1);

                System.out.println("thread 2 done unpark.");
            }
        });

        thread1.start();
        thread2.start();

        System.in.read();
    }

    @Test
    public void testThreadStatusWhenQueueIsFull() throws IOException {

        final ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(5);

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        queue.put("" + i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "eric").start();

        System.in.read();
    }
}
