package com.junit.spring.junittest.services;

import com.junit.spring.config.PageResult;
import com.junit.spring.junittest.model.UserModel;

import java.util.Map;

public interface UserService {
    PageResult<UserModel> findAllUser(int currPage, int pageSize);

    Map<String, String> createUser(UserModel userModel);
}
