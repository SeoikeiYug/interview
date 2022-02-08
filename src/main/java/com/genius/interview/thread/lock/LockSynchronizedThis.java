package com.genius.interview.thread.lock;

public class LockSynchronizedThis implements Runnable {

    static LockSynchronizedThis lockSynchronizedThis = new LockSynchronizedThis();

    @Override
    public void run() {
        // 同步代码块形式——锁为this，两个线程使用的锁是一样的，线程1必须要等到线程0释放了该锁后，才能执行
        synchronized (this) {
            System.out.println("我是线程" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "结束");
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(lockSynchronizedThis);
        Thread thread2 = new Thread(lockSynchronizedThis);
        thread1.start();
        thread2.start();
    }

}
