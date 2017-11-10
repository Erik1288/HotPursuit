package com.eric.guava.future;

import com.google.common.util.concurrent.*;

import javax.annotation.Nullable;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * User: nanxing
 * Date: 10/11/2017
 */
public class GuavaFutureTest {
    public static void main(String[] args) throws IOException {
        ListeningExecutorService listeningExecutorService
                = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "Eric-Handler-ThreadPool");
            }
        }));
        ListenableFuture<String> listenableFuture = listeningExecutorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return search();
            }
        });

        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "Eric-Callback-SingleThread-ThreadPool");
            }
        });

        // 非常灵活，理论上主线程可以不block，下面的代码会被其它的线程进行回调
        Futures.addCallback(listenableFuture, new FutureCallback<String>() {
            @Override
            public void onSuccess(@Nullable String result) {
                System.out.println("onSuccess is called. " + "Thread name:" + Thread.currentThread().getName());
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("fail");
            }
        }, singleThreadExecutor);

        // 让主线程阻塞
        System.in.read();
    }

    private static String search() throws InterruptedException {
//        System.out.println(Thread.currentThread().isDaemon());
        System.out.println("search is called. " + "Thread name:" + Thread.currentThread().getName());
        Thread.sleep(5000);
        System.out.println("sleep done");
        return "hello world";
    }
}
