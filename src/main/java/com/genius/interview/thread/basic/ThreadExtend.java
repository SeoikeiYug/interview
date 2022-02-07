package com.genius.interview.thread.basic;

public class ThreadExtend extends Thread {

    public static void main(String[] args) {
        ThreadExtend threadExtend = new ThreadExtend();
        threadExtend.setDaemon(false);
        threadExtend.start();
    }

    @Override
    public void run() {
        System.out.println("Thread is ok!");
    }
}
