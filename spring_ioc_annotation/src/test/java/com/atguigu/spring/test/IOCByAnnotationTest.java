package com.atguigu.spring.test;

import com.atguigu.spring.controller.UserController;
import com.atguigu.spring.dao.UserDao;
import com.atguigu.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCByAnnotationTest {

    @Test
    public void test(){
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        UserController bean = ioc.getBean(UserController.class);
//        System.out.println(bean);
//        UserService bean1 = ioc.getBean(UserService.class);
//        System.out.println(bean1);
//        UserDao bean2 = ioc.getBean(UserDao.class);
//        System.out.println(bean2);
        bean.saveUser();
    }
}
