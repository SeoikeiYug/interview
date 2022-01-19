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

    @Test
    public void test_transaction_required_required_exception() {
        testService.test_transaction_required_required_exception();
    }

    @Test
    public void test_transaction_required_exception() {
        testService.test_transaction_required_exception();
    }

    @Test
    public void test_transaction_required_exception_try() {
        testService.test_transaction_required_exception_try();
    }
}
