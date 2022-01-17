package com.genius.interview.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 */
public class UserServiceProxyFactory implements InvocationHandler {

    Object impl;

    public <T> Object getProxy(Class<T> clz) {
        try {
            impl = clz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        // 生成动态代理
        return Proxy.newProxyInstance(clz.getClassLoader(), clz.getInterfaces(), this);
    }

    /**
     * 参数：1.当前代理對象 2.当前方法 3.当前方法执行的时候的参数
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object invoke = method.invoke(impl, args);
        after();
        return invoke;
    }

    public void before() {
        System.out.println("之后");
    }

    public void after() {
        System.out.println("之后");
    }

}
