package com.genius.interview;

import com.genius.interview.spring.transaction.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestServiceTests {

    @Autowired
    private TestService testService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test_transaction_required_not_support() {
        testService.transaction_required_not_support();
    }

    /**
     * REQUIRED_NEW 调用方法无事务，事务独立，中间报错不会影响已执行事务
     */
    @Test
    public void test_non_transaction_required_new_required_new_exception() {
        testService.non_transaction_new_required_required_exception();
    }

    /**
     * REQUIRED_NEW 调用方法无事务，事务独立，中间报错不会影响已执行事务
     */
    @Test
    public void test_non_transaction_new_required_exception() {
        testService.non_transaction_new_required_exception();
    }

    @Test
    public void test_transaction_required_required_new_required_new_exception() {
        testService.transaction_required_required_new_required_new_exception();
    }

    @Test
    public void test_transaction_required_required_new_exception() {
        testService.transaction_required_required_new_exception();
    }

    @Test
    public void test_transaction_required_required_new_exception_try() {
        testService.transaction_required_required_new_exception_try();
    }

    /**
     * REQUIRED 调用方法无事务，事务独立，中间报错不会影响已执行事务
     */
    @Test
    public void test_non_transaction_required_required_exception() {
        testService.non_transaction_required_required_exception();
    }

    /**
     * REQUIRED 调用方法无事务，事务独立，中间报错不会影响已执行事务
     */
    @Test
    public void test_non_transaction_required_exception() {
        testService.non_transaction_required_exception();
    }

    /**
     * REQUIRED_NEW 调用方法有事务，事务整合为一个整体，中间报错会影响已执行事务，已执行事务回滚
     */
    @Test
    public void test_transaction_required_required_exception() {
        testService.test_transaction_required_required_exception();
    }

    /**
     * REQUIRED_NEW 调用方法有事务，事务整合为一个整体，中间报错会影响已执行事务，已执行事务回滚
     */
    @Test
    public void test_transaction_required_exception() {
        testService.test_transaction_required_exception();
    }

    /**
     * REQUIRED_NEW 调用方法有事务，事务整合为一个整体，中间报错会影响已执行事务，已执行事务回滚
     */
    @Test
    public void test_transaction_required_exception_try() {
        testService.test_transaction_required_exception_try();
    }
}
