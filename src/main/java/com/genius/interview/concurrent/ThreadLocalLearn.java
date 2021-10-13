package com.genius.interview.concurrent;

public class ThreadLocalLearn {

    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    private static void print(String str) {
        // 打印当前线程中本地内存中本地变量的值
        System.out.println(str + ": " + threadLocal.get());
        // 清除本地内存中的本地变量
        threadLocal.remove();
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            // 设置线程1中本地变量的值
            threadLocal.set("localVal1");
            // 调用打印方法
            print("thread1");
            // 打印本地变量
            System.out.println("after remove: " + threadLocal.get());
        });

        Thread t2 = new Thread(() -> {
            // 设置线程2中本地变量的值
            threadLocal.set("localVal2");
            // 调用打印方法
            print("thread2");
            // 打印本地变量
            System.out.println("after remove: " + threadLocal.get());
        });

        t1.start();
        t2.start();
    }

}
