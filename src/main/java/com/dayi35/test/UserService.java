package com.dayi35.test;

import com.dayi35.framework.service.BaseServiceImpl;

import javax.inject.Inject;

/**
 * Created by leeton on 10/10/17.
 */
public class UserService extends BaseServiceImpl<User> {

    public UserService(){}

    @Inject
    public UserService(UserDao userDao){
        super(userDao);
    }

}
