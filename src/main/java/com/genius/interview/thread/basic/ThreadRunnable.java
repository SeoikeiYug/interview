package com.genius.interview.thread.basic;

public class ThreadRunnable implements Runnable {

    public static void main(String[] args) {
        ThreadRunnable threadRunnable = new ThreadRunnable();
        Thread thread = new Thread(threadRunnable);
        thread.start();
        System.out.println("main is ok");
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("runnable is ok");
    }

}
