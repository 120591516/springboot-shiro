package com.wangwt.controller;

import com.wangwt.mapper.UserMapper;
import com.wangwt.pojo.User;
import com.wangwt.properties.MailProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2018\6\8 0008.
 */
@Controller
public class HelloWorldController {

    /**
     * 测试thymeleaf
     */
    @RequestMapping("/thymeleaf")
    public String thymeleaf(Model model){
        model.addAttribute("name","开发测试员");
        return "Test";
    }
    @Value("${mailhost}")
    private String mailhost;

    @Value("${mailName}")
    private String mailName;
    @Autowired
    private MailProperties mailProperties;

    @Autowired
    private UserMapper userMapper;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        System.out.println("注解加载的属性："+mailhost);
        System.out.println(mailProperties.getUsername());
        return "hello world";
    }
    @ResponseBody
    @RequestMapping("/getUser")
    public String getUser(@RequestParam(value = "username")String username) {
        User user=userMapper.selectUserByUsername(username);
        return user.getId()+"\\"+user.getPassword()+"\\"+user.getUsername();
    }
    @ResponseBody
    @RequestMapping("/userInfo")
    public User userInfo(@RequestParam(value = "username")String username) {
        User user=userMapper.selectUserByUsername(username);
        return user;
    }
}
