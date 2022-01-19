package com.genius.interview.spring.transaction.service.impl;

import com.genius.interview.spring.transaction.bean.User1;
import com.genius.interview.spring.transaction.bean.User2;
import com.genius.interview.spring.transaction.dao.User1Dao;
import com.genius.interview.spring.transaction.dao.User2Dao;
import com.genius.interview.spring.transaction.service.User2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class User2ServiceImpl implements User2Service {

    @Autowired
    private User2Dao user2Dao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addRequired(User2 user) {
        user2Dao.save(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addRequiredException(User2 user) {
        user2Dao.save(user);
        throw new RuntimeException();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addRequiredNew(User2 user) {
        user2Dao.save(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addRequiredNewException(User2 user) {
        user2Dao.save(user);
        throw new RuntimeException();
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void addNotSupport(User2 user) {
        user2Dao.save(user);
        throw new RuntimeException();
    }

}
