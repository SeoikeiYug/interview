package com.genius.interview.thread;

import java.util.Scanner;

public class ThreadExitMethod {

    public static void main(String[] args) {
//        ThreadExitMethod.exit1();
//        ThreadExitMethod.exit2();
//        ThreadExitMethod.exit3();
        ThreadExitMethod.overall();
//        ThreadExitMethod.canNotStop();
    }

    public static void canNotStop() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("线程启动了");
                // 对于这种情况，即使线程调用了interrupt()方法并且isInterrupted()，但线程还是会继续运行，根本停不下来！
                while (true) {
                    System.out.println(isInterrupted());
                }
            }
        };
        thread.start();
        // 注意，此方法不会中断一个正在运行的线程，它的作用是：在线程受到阻塞时抛出一个中断信号，这样线程就得以退出阻塞的状态
        thread.interrupt();
        while (true) {
            System.out.println("是否isInterrupted：" + thread.isInterrupted());
        }
    }

    private static volatile boolean flag = true;

    public static void overall() {
        Thread thread = new Thread(() -> {
            System.out.println("开始休眠");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("结束休眠，开始死循环");
            while (flag) {
            }
            System.out.println("子线程结束");
        });
        thread.start();
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入1抛出一个中断异常，输入2修改循环标志位，输入3判断线程是否阻塞，输入其他结束Scanner\n");
        while (scanner.hasNext()) {
            String text = scanner.next();
            System.out.println("你输入了: " + text);
            if ("1".equals(text)) {
                thread.interrupt();
            } else if ("2".equals(text)) {
                flag = false;
            } else if ("3".equals(text)) {
                System.out.println(thread.isInterrupted());
            } else {
                scanner.close();
                break;
            }
        }
        System.out.println("主线程结束");
    }

    public static void exit3() {
        Thread thread = new Thread(() -> {
            System.out.println("线程启动了！");
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println(Thread.currentThread().isInterrupted());
            }
            System.out.println("线程结束了！");
        });
        thread.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
        System.out.println("线程是否被中断: " + thread.isInterrupted());
    }

    public static void exit2() {
        Thread thread = new Thread(() -> {
            System.out.println("线程启动了！");
            try {
                Thread.sleep(1000 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程结束了！");
        });
        thread.start();
        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }

    public static volatile boolean exit = false;

    public static void exit1() {
        new Thread(() -> {
            System.out.println("线程启动了！");
            while (!exit) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("线程结束了！");
        }).start();
        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        exit = true;
    }

}
