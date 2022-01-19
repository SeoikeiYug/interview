package com.genius.interview.spring.transaction.dao;

import com.genius.interview.spring.transaction.bean.User2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface User2Dao extends JpaRepository<User2, Integer>, JpaSpecificationExecutor<User2> {

    User2 getUser2ById(Integer id);

}
