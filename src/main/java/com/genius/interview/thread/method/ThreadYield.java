package com.genius.interview.thread.method;

public class ThreadYield {

    public static void main(String[] args) {
        Thread3 thread3 = new Thread3("张三");
        Thread3 thread4 = new Thread3("李四");
        thread3.setPriority(Thread.MAX_PRIORITY);
        thread4.setPriority(Thread.MIN_PRIORITY);
        thread3.start();
        thread4.start();
    }

}

class Thread3 extends Thread {

    public Thread3(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i <= 50; i++) {
            System.out.println("" + Thread.currentThread().getName() + "------" + i);
            // 当i为30时，该线程就会把CPU时间让掉，让其他或者自己的线程执行（也就是谁先抢到谁执行）
            if (i == 30) {
                Thread.yield();
            }
        }
    }
}