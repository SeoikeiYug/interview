package com.genius.interview.thread.basic;

public class ThreadInterruptedTest {

    public static void main(String[] args) throws InterruptedException {
        ThreadInterrupted threadInterrupted = new ThreadInterrupted();
        threadInterrupted.start();
        Thread.sleep(1000);
        threadInterrupted.interrupt();
    }

}

class ThreadInterrupted extends Thread {

    @Override
    public void run() {
        while (!interrupted()) {
            System.out.println("I am still running!");
        }
        System.out.println("Thread end");
    }

}