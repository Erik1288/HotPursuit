package com.eric.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by feierik on 17/11/23.
 */
public class Lock {
    public static void main(String[] args) {
        final ReentrantLock reentrantLock = new ReentrantLock();

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 2; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        reentrantLock.lock();
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        reentrantLock.unlock();
                    }

                }
            });
        }

    }
}
