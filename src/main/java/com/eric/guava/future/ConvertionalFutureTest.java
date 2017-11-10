package com.eric.guava.future;

import java.util.concurrent.*;

/**
 * User: nanxing
 * Date: 10/11/2017
 */
public class ConvertionalFutureTest {

    // 如果用单元测试，进程会被kill，无法测试守护线程
    public static void main(String[] arg) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> futureResult = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return search();
            }
        });

        System.out.println(futureResult.isDone());
        // 传统的线程

        // 虽然有Thread的句柄，但感觉功能还是太有限
        try {
            // 只能阻塞当前的线程来尝试获取异步的结果
            String s = futureResult.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static String search() throws InterruptedException {
        System.out.println(Thread.currentThread().isDaemon());
        Thread.sleep(5000);
        System.out.println("sleep done");
        return "hello world";
    }
}
