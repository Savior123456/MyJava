package com.atguigu.spring.controller;


import com.atguigu.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller("userController")
public class UserController {

    @Autowired //自动装配
    @Qualifier("userServiceImpl")
    private UserService userService;

    public void saveUser(){
        userService.saveUser();
    }
}
