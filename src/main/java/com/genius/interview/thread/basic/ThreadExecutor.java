package com.genius.interview.thread.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadExecutor {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Thread Run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Future<?> threadRun = executorService.submit(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Thread Run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadRun.cancel(true);
        System.out.println("Main run");
    }

}
