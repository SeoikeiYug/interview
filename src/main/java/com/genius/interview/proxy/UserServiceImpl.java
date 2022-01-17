package com.genius.interview.proxy;

public class UserServiceImpl implements UserService {

    @Override
    public void save() {
        System.out.println("保存用户");
    }

}
