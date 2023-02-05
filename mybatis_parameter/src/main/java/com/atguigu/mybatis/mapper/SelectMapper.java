package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {

    /**
     *
     * @param id
     * @return
     */
    User getUserBuyId(@Param("id") Integer id);

    List<User> getAllUser();

    Integer getCount();




    /**
     * 查询用户信息，以map返回
     * @param id
     * @return
     */
    Map<String, Object> getUserByIdToMap(@Param("id") Integer id);


    //查询结果为多条时（多个map），可以使用List<Map<String,Object>>，或者map包map @MapKey("id")

    /**
     * 查询所有用户信息，以map返回
     * @return
     */
    List<Map<String,Object>> getAllUserToMap();

    /**
     *MapKey注解可以将字段值作为map的key
     *
     * @return
     */
    @MapKey("id")
    Map<String,Object> getAllUserToMapKey();
}
