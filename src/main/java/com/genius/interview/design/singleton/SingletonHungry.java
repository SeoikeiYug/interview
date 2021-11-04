package com.genius.interview.design.singleton;

public class SingletonHungry {

    // 创建一个实例
    private final static SingletonHungry instance = new SingletonHungry();

    // 私有构造方法， 防止被实例化
    private SingletonHungry() {

    }

    // 静态get方法
    public static SingletonHungry getInstance() {
        return instance;
    }

}
