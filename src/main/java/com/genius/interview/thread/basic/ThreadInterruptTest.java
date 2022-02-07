package com.genius.interview.thread.basic;

public class ThreadInterruptTest {

    public static void main(String[] args) {
        ThreadInterrupt threadInterrupt = new ThreadInterrupt();
        threadInterrupt.start();
        threadInterrupt.interrupt();
        System.out.println("Main run");
    }

}

class ThreadInterrupt extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println("Thread run");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
