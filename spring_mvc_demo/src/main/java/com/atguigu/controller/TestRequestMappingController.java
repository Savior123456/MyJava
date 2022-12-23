package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 *
 *1.@RequestMapping注解标识的位置
 *@RequestMapping标识一个类：设置映射请求的请求路径的初始信息
 *@RequestMapping标识一个方法：设置映射请求请求路径的具体信息
 *
 *2.@RequestMapping注解value属性
 * 作用：通过请求的请求路径匹配请求
 * value属性是数组类型，即当前浏览器所发送请求的请求路径匹配value属性中的任何一个值
 * 则当前请求就会被注解所标识的方法进行处理
 *
 *3.@RequestMapping注解的method属性
 * 作用：通过请求的请求方式匹配请求
 * method属性是RequestMethod类型的数组，即当前浏览器所发送的请求方式与匹配的method属性中一个匹配则不会报错
 * 若当前请求的请求地址满足请求映射的value属性，但是请求方式不满足method属性，则浏览器报错
 * 405：Request method 'POST' not supported
 *
 *4.param属性
 * "param"：要求请求映射所匹配的请求必须携带param请求参数
 * "!param"：要求请求映射所匹配的请求必须不能携带param请求参数
 * "param=value"：要求请求映射所匹配的请求必须携带param请求参数且param=value
 * "param!=value"：要求请求映射所匹配的请求必须携带param请求参数但是param!=value
 *
 * 5.headers属性
 * 浏览器发送的请求头信息必须满足headers属性的设置
 * 若没有匹配直接报错404
 */
@Controller
//@RequestMapping("/test")
public class TestRequestMappingController {

    //此时控制器方法所匹配的请求路径为/test/hello
    @RequestMapping(value = {"/hello","/abc"},
            method = {RequestMethod.GET, RequestMethod.POST},
//            params = {"username","!password","age=20","gender!=女"}
            headers = {"referer"}
    )
    public String hello(){
        return "success";
    }


    /**
     * ？：表示任意的单个字符(不包括问号与/)
     * *：表示任意的0个或多个字符(不包括问号与/）
     * **：表示任意层数的任意目录
     **/
    //注意：在使用**时，只能使用/**/xxx的方式

    @RequestMapping("/a?c/test/ant")
    public String testAnt(){
        return "success";
    }

    @RequestMapping("/test/rest/{username}/{id}")
    public String testRest(@PathVariable("username") String username,@PathVariable("id") Integer id){
        System.out.println("id:"+id +"\nusername:"+username);
        return "success";
    }


}
