package com.genius.interview.thread.lock;

public class LockSynchronizedSource {

    Object object = new Object();

    public void method1() {
        synchronized (object) {

        }
        method2();
    }

    private static void method2() {

    }

}
