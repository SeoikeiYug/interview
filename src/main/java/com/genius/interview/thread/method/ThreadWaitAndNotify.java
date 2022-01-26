package com.genius.interview.thread.method;

public class ThreadWaitAndNotify {

    

    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        Printer printerA = new Printer("A", c, a);
        Printer printerB = new Printer("B", a, b);
        Printer printerC = new Printer("C", b, c);
        new Thread(printerA).start();
        Thread.sleep(100);
        new Thread(printerB).start();
        Thread.sleep(100);
        new Thread(printerC).start();
        Thread.sleep(100);
    }

}

class Printer implements Runnable {

    private final String name;
    private final Object prev;
    private final Object self;

    public Printer(String name, Object prev, Object self) {
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    @Override
    public void run() {
        int count = 10;
        while (count > 0) {
            synchronized (prev) {
                synchronized (self) {
                    System.out.print(name);
                    count--;
                    self.notify();
                }
                try {
                    prev.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}