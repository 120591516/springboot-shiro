package com.wangwt.service;


import com.wangwt.pojo.User;

/**
 * Created by Administrator on 2018\6\9 0009.
 */
public interface UserService {
    User getUserByUsername(String username);
}
