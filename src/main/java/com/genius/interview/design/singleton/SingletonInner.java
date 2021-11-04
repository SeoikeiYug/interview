package com.genius.interview.design.singleton;

public class SingletonInner {

    private SingletonInner() {

    }

    // 建立一个内部类来维护单例
    public static class SingletonFactory {
        private static SingletonInner singletonInner = new SingletonInner();
    }

    // 获取实例
    public static SingletonInner getInstance() {
        return SingletonFactory.singletonInner;
    }

    // 如果该对象被用于序列化，可以保证对象在序列化前后保持一致
    public Object readResolve() {
        return getInstance();
    }

}
