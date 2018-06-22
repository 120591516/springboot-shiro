package com.wangwt.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by admin on 2018/6/20.
 */
@Controller
public class LoginController {
        @RequestMapping("/toLogin")
    public String toLogin(){
        return "/login/login";
    }

    /**
     * 登录
     */
    @RequestMapping("/login")
    public String login(String name,String password){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
        try {
            subject.login(token);

        }catch (AuthenticationException e){
                e.printStackTrace();
        }
        return  null;
    }
}
