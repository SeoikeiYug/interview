package com.genius.interview.thread.lock;

public class LockSynchronizedStatic implements Runnable {

    static LockSynchronizedStatic INSTANCE1 = new LockSynchronizedStatic();
    static LockSynchronizedStatic INSTANCE2 = new LockSynchronizedStatic();

    @Override
    public void run() {
        method();
    }

    public static synchronized void method() {
        System.out.println("我是线程: " + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "结束");
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(INSTANCE1);
        Thread thread2 = new Thread(INSTANCE2);
        thread1.start();
        thread2.start();
    }
}
