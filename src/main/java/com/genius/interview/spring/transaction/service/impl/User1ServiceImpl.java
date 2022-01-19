package com.genius.interview.spring.transaction.service.impl;

import com.genius.interview.spring.transaction.bean.User1;
import com.genius.interview.spring.transaction.dao.User1Dao;
import com.genius.interview.spring.transaction.service.User1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class User1ServiceImpl implements User1Service {

    @Autowired
    private User1Dao user1Dao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addRequired(User1 user) {
        user1Dao.save(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addRequiredNew(User1 user) {
        user1Dao.save(user);
    }
}
