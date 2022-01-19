package com.genius.interview.spring.transaction.service;

public interface TestService {

    void transaction_required_not_support();

    void non_transaction_new_required_required_exception();

    void non_transaction_new_required_exception();

    void transaction_required_required_new_required_new_exception();

    void transaction_required_required_new_exception();

    void transaction_required_required_new_exception_try();

    void non_transaction_required_required_exception();

    void non_transaction_required_exception();

    void test_transaction_required_required_exception();

    void test_transaction_required_exception();

    void test_transaction_required_exception_try();

}
