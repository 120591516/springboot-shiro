package com.wangwt.service.impl;

import com.wangwt.mapper.UserMapper;
import com.wangwt.pojo.User;
import com.wangwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2018\6\9 0009.
 */
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUserByUsername(String username) {
        return userMapper.selectUserByUsername(username);
    }
}
