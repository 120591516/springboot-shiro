package com.wangwt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by admin on 2018/6/20.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/add")
    public String add(){
        return "/user/useradd";
    }
    @RequestMapping("/update")
    public String update(){
        return "/user/userUpdate";
    }
}
