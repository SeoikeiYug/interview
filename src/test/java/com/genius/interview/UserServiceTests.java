package com.genius.interview;

import com.genius.interview.design.factory.FactoryShare;
import com.genius.interview.design.factory.FactoryShareMethod;
import com.genius.interview.proxy.UserService;
import com.genius.interview.proxy.UserServiceImpl;
import com.genius.interview.proxy.UserServiceProxyFactory;
import com.genius.interview.proxy.UserServiceProxyFactoryCglib;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTests {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testProxy() {
        UserServiceProxyFactory userServiceProxyFactory = new UserServiceProxyFactory();
        UserService userService = (UserService) userServiceProxyFactory.getProxy(UserServiceImpl.class);
        userService.save();
        System.out.println(userService instanceof UserServiceImpl);
    }

    @Test
    public void testProxyCglib() {
        UserServiceProxyFactoryCglib userServiceProxyFactoryCglib = new UserServiceProxyFactoryCglib();
        UserService userService = (UserService) userServiceProxyFactoryCglib.getProxy(UserServiceImpl.class);
        userService.save();
        System.out.println(userService instanceof UserServiceImpl);
    }

}
