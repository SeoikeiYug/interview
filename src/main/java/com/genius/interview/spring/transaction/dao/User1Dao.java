package com.genius.interview.spring.transaction.dao;

import com.genius.interview.spring.transaction.bean.User1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface User1Dao extends JpaRepository<User1, Integer>, JpaSpecificationExecutor<User1> {

    User1 getUser1ById(Integer id);

}
