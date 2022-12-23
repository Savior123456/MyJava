package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 向域对象共享数据
 * 1.通过ModelAndView向请求域共享数据
 * 使用ModelAndView时，可以使用其Model功能向请求域共享数据
 * 使用View功能设置逻辑视图
 *
 * 2.使用model向请求域中共享数据
 * 3.使用modelMap向请求域中共享数据
 * 4.使用map向请求域中共享数据
 */
@Controller
public class TestScopeController {
    
    @RequestMapping("/test/mav")
    public ModelAndView testMav1(){
        /**
         * ModelAndView有Model和View的功能
         * Model主要用于向请求域共享数据
         * View主要用于设置视图，实现页面跳转
         */
        ModelAndView mav = new ModelAndView();
        //向请求域共享数据
        mav.addObject("testRequestScope","hello modelAndView");
        //设置逻辑试图
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("/test/model")
    public String testModel2(Model model){
        model.addAttribute("testRequestScope","hello model");
        return "success";
    }

    @RequestMapping("/test/modelMap")
    public String testModel3(ModelMap modelMap){
        modelMap.addAttribute("testRequestScope","hello modelMap");
        return "success";
    }

    @RequestMapping("/test/map")
    public String testModel4(Map<String ,Object> map){
        map.put("testRequestScope","hello map");
        return "success";
    }

    @RequestMapping("/testSession")
    public String testSession(HttpSession session){
        session.setAttribute("testSessionScope", "hello,session");
        return "success";
    }

    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session){
        ServletContext application = session.getServletContext();
        application.setAttribute("testApplicationScope", "hello,application");
        return "success";
    }
}
