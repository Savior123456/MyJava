package com.atguigu.controller;

import com.atguigu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestParamController {

    @RequestMapping("/param/servletAPI")
    public String getParamByServletAPI(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:"+username+"\npassword:"+password);
        return "success";
    }

    /**
     @RequestParam注解一共有三个属性：
    value：指定为形参赋值的请求参数的参数名
    required：设置是否必须传输此请求参数，默认值为true
    若设置为true时，则当前请求必须传输value所指定的请求参数，若没有传输该请求参数，且没有设置
    defaultValue属性，则页面报错400：Required String parameter 'xxx' is not present；若设置为
    false，则当前请求不是必须传输value所指定的请求参数，若没有传输，则注解所标识的形参的值为
    null
    defaultValue：不管required属性值为true或false，当value所指定的请求参数没有传输或传输的值
    为""时，则使用默认值为形参赋值
     * */

    @RequestMapping("/param")
    public String getParam(@RequestParam(value = "username",required = true) String username, @RequestParam("password") String password){
        System.out.println("username:"+username+"\npassword:"+password);
        return "success";
    }


    /**
     * 可以在控制器方法的形参位置设置一个实体类类型的形参，此时若浏览器传输的请求参数的参数名和实
     * 体类中的属性名一致，那么请求参数就会为此属性赋值
     * @param user
     * @return
     */
    @RequestMapping("/param/pojo")
    public String getParamByPojo(User user){
        System.out.println(user);
        return "success";
    }

    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request){
        request.setAttribute("testScope", "hello,servletAPI");
        return "success";
    }
}
