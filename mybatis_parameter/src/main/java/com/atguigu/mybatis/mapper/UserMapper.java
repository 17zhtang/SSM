package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;

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

}
