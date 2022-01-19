package com.genius.interview.spring.transaction.service;

import com.genius.interview.spring.transaction.bean.User2;

public interface User2Service {

    void addRequired(User2 user);

    void addRequiredException(User2 user);

    void addRequiredNew(User2 user);

    void addRequiredNewException(User2 user);

    void addNotSupport(User2 user);

}
