package com.junit.spring.junittest.controller;

import com.junit.spring.config.PageResult;
import com.junit.spring.junittest.model.UserModel;
import com.junit.spring.junittest.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class JunitTestController {
    private static final Logger logger = LoggerFactory.getLogger(JunitTestController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/finAlldUser/{currPage}/{pageSize}")
    public PageResult<UserModel> findAllUser(@PathVariable("currPage") int currPage,
                                             @PathVariable("pageSize") int pageSize){
        PageResult<UserModel> userVoList = userService.findAllUser(currPage,pageSize);
        return userVoList;
    }

    @PostMapping("/createUser")
    public Map<String, String>createUser(@RequestBody UserModel userModel){
        Map<String, String>retmap = new HashMap<>();
        if(userModel == null){
            retmap.put("retCode","01");
            retmap.put("message","Body can not be empty!");
        }
        retmap = userService.createUser(userModel);
        return retmap;

    }
}
