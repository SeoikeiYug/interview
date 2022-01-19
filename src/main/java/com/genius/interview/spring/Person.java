package com.genius.interview.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class Person implements DisposableBean, InitializingBean, BeanFactoryAware, BeanNameAware {

    private String name;

    Person() {
        System.out.println("Constructor of person bean is invoked!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory method of person is invoked!");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("setBeanName method of person is invoked!");
    }

    public void initMethod() {
        System.out.println("custom init method of person bean is invoked!");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet method of person bean is invoked!");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean Destroy method of person bean is invoked!");
    }

    public void destroyMethod() {
        System.out.println("custom Destroy method of person bean is invoked!");
    }
}
