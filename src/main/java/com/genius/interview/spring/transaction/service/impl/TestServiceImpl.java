package com.genius.interview.spring.transaction.service.impl;

import com.genius.interview.spring.transaction.bean.User1;
import com.genius.interview.spring.transaction.bean.User2;
import com.genius.interview.spring.transaction.service.TestService;
import com.genius.interview.spring.transaction.service.User1Service;
import com.genius.interview.spring.transaction.service.User2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private User1Service user1Service;

    @Autowired
    private User2Service user2Service;

    @Override
    @Transactional
    public void transaction_required_not_support() {
        User1 user1 = new User1();
        user1.setName("张三");
        user1Service.addRequired(user1);

        User2 user2 = new User2();
        user2.setName("李四");
        user2Service.addNotSupport(user2);
    }

    @Override
    public void non_transaction_new_required_required_exception() {
        User1 user1 = new User1();
        user1.setName("张三");
        user1Service.addRequiredNew(user1);

        User2 user2 = new User2();
        user2.setName("李四");
        user2Service.addRequiredNew(user2);

        throw new RuntimeException();
    }

    @Override
    public void non_transaction_new_required_exception() {
        User1 user1 = new User1();
        user1.setName("张三");
        user1Service.addRequiredNew(user1);

        User2 user2 = new User2();
        user2.setName("李四");
        user2Service.addRequiredNewException(user2);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void transaction_required_required_new_required_new_exception() {
        User1 user1 = new User1();
        user1.setName("张三");
        user1Service.addRequired(user1);

        User2 user2 = new User2();
        user2.setName("李四");
        user2Service.addRequiredNew(user2);

        User2 user3 = new User2();
        user3.setName("王五");
        user2Service.addRequiredNew(user3);
        throw new RuntimeException();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void transaction_required_required_new_exception() {
        User1 user1 = new User1();
        user1.setName("张三");
        user1Service.addRequired(user1);

        User2 user2 = new User2();
        user2.setName("李四");
        user2Service.addRequiredNew(user2);

        User2 user3 = new User2();
        user3.setName("王五");
        user2Service.addRequiredNewException(user3);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void transaction_required_required_new_exception_try() {
        User1 user1 = new User1();
        user1.setName("张三");
        user1Service.addRequired(user1);

        User2 user2 = new User2();
        user2.setName("李四");
        user2Service.addRequiredNew(user2);

        User2 user3 = new User2();
        user3.setName("王五");
        try {
            user2Service.addRequiredException(user3);
        } catch (Exception e) {
            System.out.println("方法回滚");
        }
    }

    @Override
    public void non_transaction_required_required_exception() {
        User1 user1 = new User1();
        user1.setName("张三");
        user1Service.addRequired(user1);

        User2 user2 = new User2();
        user2.setName("李四");
        user2Service.addRequired(user2);

        throw new RuntimeException();
    }

    @Override
    public void non_transaction_required_exception() {
        User1 user1 = new User1();
        user1.setName("张三");
        user1Service.addRequired(user1);

        User2 user2 = new User2();
        user2.setName("李四");
        user2Service.addRequiredException(user2);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void test_transaction_required_required_exception() {
        User1 user1 = new User1();
        user1.setName("张三");
        user1Service.addRequired(user1);

        User2 user2 = new User2();
        user2.setName("李四");
        user2Service.addRequired(user2);

        throw new RuntimeException();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void test_transaction_required_exception() {
        User1 user1 = new User1();
        user1.setName("张三");
        user1Service.addRequired(user1);

        User2 user2 = new User2();
        user2.setName("李四");
        user2Service.addRequiredException(user2);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void test_transaction_required_exception_try() {
        User1 user1 = new User1();
        user1.setName("张三");
        user1Service.addRequired(user1);

        User2 user2 = new User2();
        user2.setName("李四");
        try {
            user2Service.addRequiredException(user2);
        } catch (Exception e) {
            System.out.println("方法回滚");
        }
    }

}
