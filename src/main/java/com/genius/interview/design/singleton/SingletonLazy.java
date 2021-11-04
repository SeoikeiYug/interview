package com.genius.interview.design.singleton;

public class SingletonLazy {

    private static SingletonLazy instance;

    private volatile static SingletonLazy instanceVolatile;

    private SingletonLazy() {

    }

    // 静态get方法
    public static synchronized SingletonLazy getInstanceSync() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }

    public static SingletonLazy getInstanceVolatile() {
        // 先检查实例是否存在， 如果不存在才进入下面的同步块
        if (instanceVolatile == null) {
            synchronized (SingletonLazy.class) {
                // 再次检查是否存在， 不存在创建实例
                if (instanceVolatile == null) {
                    instanceVolatile = new SingletonLazy();
                }
            }
        }
        return instanceVolatile;
    }

}
