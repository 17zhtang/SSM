package com.atguigu.spring.factory;

import com.atguigu.spring.pojo.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * FactoryBean接口需要由工厂类实现
 * 有三个方法：
 * getObject
 * getObjectType
 * isSingleton
 * 当把工厂类配置为bean时，会把getObject所返回的对象交给IOC容器管理
 */
public class UserFactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }

}
