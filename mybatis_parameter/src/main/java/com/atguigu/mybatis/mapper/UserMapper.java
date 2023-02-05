package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * mybatis获取参数值的两种方式： #{} ${}
 */
public interface UserMapper {

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    User getUserByUsername(String username);

    /**
     * 验证登录
     * @param username
     * @param password
     * @return
     */
    User checkLogin(String username, String password);

    User checkLoginByMap(Map<String, Object> map);

    /**
     * 接口参数为实体类型时，直接通过#{}或${}访问map的键（与实体类属性值一致）就可以访问参数值
     * @param user
     */
    void insertUser(User user);

    /**
     * 用@Param注解，就可以使用注解设定的值来作为map的键值，所以可以用括号中的值来访问参数
     * @param username
     * @param password
     * @return
     */
    User checkLoginByParam(@Param("username") String username, @Param("password") String password);

}
