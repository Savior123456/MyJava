package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecialSQLMapper {


    /**
     * 通过用户名模糊查询用户信息
     * @return
     */
    List<User> getUserByLike(@Param("mohu") String mohu);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    int deleteMore(@Param("ids") String ids);


    /**
     * 通化表名查询用户信息
     * @param tableName
     * @return
     */
    List<User> getUserByTableName(@Param("tableName") String tableName);

    /**
     * 添加用户信息，获取自增的主键
     * @param user
     */
    void insertUser(User user);
}
