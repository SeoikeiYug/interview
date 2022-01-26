package com.genius.interview.thread.method;

public class ThreadNonWithJoin {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "主线程运行开始！");
        Thread2 thread1 = new Thread2("A");
        Thread2 thread2 = new Thread2("B");
        thread1.start();
        thread2.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "主线程运行结束！");
    }

}

class Thread2 extends Thread {

    private String name;

    public Thread2(String name) {
        super(name);
        this.name = name;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程运行开始！");
        for (int i = 0; i < 5; i++) {
            System.out.println("子线程" + name + "运行: " + i);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "线程运行结束！");
    }
}