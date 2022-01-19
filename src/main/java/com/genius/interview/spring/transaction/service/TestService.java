package com.genius.interview.spring.transaction.service;

public interface TestService {

    void non_transaction_required_required_exception();

    void non_transaction_required_exception();

    void test_transaction_required_required_exception();

    void test_transaction_required_exception();

    void test_transaction_required_exception_try();

}
