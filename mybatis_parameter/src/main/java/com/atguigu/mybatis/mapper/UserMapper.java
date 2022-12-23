package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * Mybatis获取参数值的两种方式：#{}占位符赋值   ${}字符串拼接
 * 1.若mapper接口方法的参数为单个的字面量类型
 * 此时可以通过两种方式获取均可，一定注意${}的单引号问题
 * 2.若mapper接口方法的参数为多个字面量类型
 * 此时Mybatis会将参数放在map集合中，一两种方式存储
 * a>以arg0，arg1...为键，以参数为值
 * b>以param1，param2...为键，以参数为值
 * 只需要通过#{}和${}访问map集合的键，就可以获取相对于的值
 * 3.若mapper接口方法的参数为map集合类型的参数
 * 只需要通过#{}和${}访问map集合的键，就可以获取相对于的值
 * 4.若mapper接口方法的参数为实体类类型的参数
 * 只需要通过#{}和${}访问实体类中的属性名，就可以获取相对于的属性值
 * 5.可以在mapper接口方法的参数上设置@Param注解
 * 此时Mybatis会将这些参数放在map中，以这两种方式进行存储
 * a>以@Param注解的value属性值为键，以参数为值
 * b>以param1，param2...为键，以参数为值
 */
public interface UserMapper {

    /**
     * 根据姓名查询用户信息
     * @param username
     * @return
     */
    User getUserByUsername(String username);

    /**
     * 通过用户名和密码检测登录
     * @param username
     * @param password
     * @return
     */
    User checkLogin(String username,String password);

    /**
     * 验证登录，以map集合作为参数
     * @param map
     * @return
     */
    User checkLoginByMap(Map<String,Object> map);

    /**
     * 添加用户啊
     * @param user
     */
    void insertUser(User user);

    /**
     * 验证登录，使用@Param注解
     * @param username
     * @param password
     * @return
     */
    User checkLoginByParam(@Param("username")String username, @Param("password") String password);
}
