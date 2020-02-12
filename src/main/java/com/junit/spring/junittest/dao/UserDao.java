package com.junit.spring.junittest.dao;

import com.junit.spring.junittest.model.UserModel;

import java.util.List;

public interface UserDao {
    List<UserModel> findAllUser();

    int createUser(UserModel userModel);
}
