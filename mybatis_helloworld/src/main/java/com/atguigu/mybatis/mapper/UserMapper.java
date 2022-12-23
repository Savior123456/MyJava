package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {
    /**
     * 增加用户信息
     * @return
     */
    int insertUser();

    /**
     * 修改用户信息
     */
    void updateUser();

    /**
     * 删除用户信息
     * @return
     */
    int deleteUser();

    /**
     * 根据Id查询用户信息
     * @return
     */
    User getUserById();

    /**
     * 获取所有用户信息
     * @return
     */
    List<User> getAllUser();
}
