package com.atguigu.spring.test;

import com.atguigu.spring.controller.UserController;
import com.atguigu.spring.dao.UserDao;
import com.atguigu.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCByAnnotationTest {

    /**
     * 常用注解，含义不同，但功能相同，只是便于理解代码\
     * @Component 将类标识为普通组件
     * @Controller 将类标识为控制层组件
     * @Service 将类标识为业务层组件
     * @Repository 将类标识为持久层组件
     *
     * 注解需要在spring配置文件中设置 context:component-scan标签
     */

    @Test
    public void test(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        UserController userController = ioc.getBean(UserController.class);
        System.out.println(userController);
        UserService userService = ioc.getBean(UserService.class);
        System.out.println(userService);
        UserDao userDao = ioc.getBean(UserDao.class);
        System.out.println(userDao);
    }

}
