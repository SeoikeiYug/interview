package com.genius.interview.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 动态代理 cglib
 */
public class UserServiceProxyFactoryCglib implements MethodInterceptor {

    public <T> Object getProxy(Class<T> clz) {
        Enhancer en = new Enhancer();// 帮我们生成代理对象
        en.setSuperclass(clz);// 设置对谁进行代理
        en.setCallback(this);//回调函数
        return en.create();// 创建代理对象;
    }

    /**
     * proxyObj:被代理的原始对象 method:被代理的原始方法 arg:运行期的参数 methodProxy:产生的代理方法
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        // 打开事务
        System.out.println("打开事务！");
        // 调用原有方法
        Object invokeSuper = methodProxy.invokeSuper(o, objects);
        // 提交事务
        System.out.println("提交事务！");
        return invokeSuper;
    }
}
