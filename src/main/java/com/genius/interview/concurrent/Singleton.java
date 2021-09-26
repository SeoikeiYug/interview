package com.genius.interview.concurrent;

public class Singleton {

    // 第三种方式
    private static volatile Singleton thirdSingleton;

    private Singleton(){

    }

    public static synchronized Singleton getThirdInstance() {
        if (thirdSingleton == null) {
            thirdSingleton = new Singleton();
        }
        return thirdSingleton;
    }

    // 第二种方式，double checked locking
    private static Singleton secondSingleton;

    public static Singleton getSecondInstance() {
        // single check
        if (secondSingleton == null) {
            synchronized (Singleton.class) {
                // double check
                if (secondSingleton == null) {
                    secondSingleton = new Singleton();
                }
            }
        }
        return secondSingleton;
    }

    // 第一种方式，多线程可能出现多个实例
    private static Singleton firstSingleton;

    public static Singleton getInstance() {
        if (firstSingleton == null) {
            firstSingleton = new Singleton();
        }
        return firstSingleton;
    }

}
