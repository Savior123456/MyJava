package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    User getUserById(@Param("id") Integer id);

    /**
     * 查询所有用户信息
     * @return
     */
    List<User> getAllUser();

    /**
     * 查询用户的总数量
     * @return
     */
    Integer getCount();

    /**
     * 根据id查询用户信息为map
     * @return
     */
    Map<String,Object> getUserByIdToMap(@Param("id")Integer id);


    /**
     *查询所有用户信息以list保存
     * @return
     */
    List<Map<String,Object>> getAllUserToMap();


    /**
     * 查询多个结果的情况的两种解决方案
     * 1.将mapper接口方法的返回值设置为泛型是map的list集合
     * List<Map<String,Object>> getAllUserToMap();
     *
     * 2.将每条数据转化的map集合放在一个大的map中，但必须通过@MapKey进行注解
     * @MapKey("id")
     * Map<String, Object> getAllUserToMapDouble();
     * */
    @MapKey("id")
    Map<String,Object> getAllUserToMapDouble();

}
