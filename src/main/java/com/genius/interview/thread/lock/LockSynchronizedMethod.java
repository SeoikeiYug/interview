package com.genius.interview.thread.lock;

public class LockSynchronizedMethod implements Runnable {

    static LockSynchronizedMethod INSTANCE = new LockSynchronizedMethod();

    @Override
    public void run() {
        method();
    }

    public synchronized void method() {
        System.out.println("我是线程: " + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "结束");
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(INSTANCE);
        Thread thread2 = new Thread(INSTANCE);
        thread1.start();
        thread2.start();
    }
}
