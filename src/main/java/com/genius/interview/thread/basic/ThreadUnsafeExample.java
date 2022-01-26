package com.genius.interview.thread.basic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程不安全示例
 */
public class ThreadUnsafeExample {

    public static void main(String[] args) throws InterruptedException {
        final int threadSize = 1000;
        ThreadUnsafeExample threadUnsafeExample = new ThreadUnsafeExample();
        final CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < threadSize; i++) {
            executorService.execute(() -> {
                threadUnsafeExample.add();
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(threadUnsafeExample.get());
    }

    private int cnt = 0;

    public void add() {
        cnt++;
    }

    public int get() {
        return cnt;
    }

}
