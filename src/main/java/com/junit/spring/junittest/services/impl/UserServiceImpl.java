package com.junit.spring.junittest.services.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.junit.spring.config.PageResult;
import com.junit.spring.config.PageVO;
import com.junit.spring.junittest.dao.UserDao;
import com.junit.spring.junittest.model.UserModel;
import com.junit.spring.junittest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public PageResult<UserModel> findAllUser(int currPage, int pageSize) {
        Page page = PageHelper.startPage(currPage,pageSize);
        List<UserModel>userVoList = userDao.findAllUser();
        PageVO pageVO = new PageVO();
        pageVO.setPageCurr(currPage);
        pageVO.setPageSize(pageSize);
        pageVO.setStartPage(page.getStartRow()+1);
        pageVO.setEndpage(page.getEndRow());
        pageVO.setTotalRows(page.getTotal());
        pageVO.setTotalPages(page.getPages());
        PageResult<UserModel>pageResult = new PageResult<>(userVoList, pageVO,UserModel.class);
        return pageResult;
    }

    @Override
    public Map<String, String> createUser(UserModel userModel) {
        Map<String, String> map = new HashMap<>();
        map.put("retCode","00");
        int count = userDao.createUser(userModel);
        map.put("Message","Inserted record count is : " +String.valueOf(count));
        return map;
    }
}
