package com.atguigu.spring.test;

import com.atguigu.spring.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowireByXMLTest {

    /**
     * 自动装配：
     * 根据指定的策略，在IOC容器中匹配某个bean，自动为bean中的类类型的属性或接口类型的属性赋值
     *
     * autowire属性：
     * no, default:都表示不自动装配
     * byType: 根据要赋值的属性的类型匹配某个bean去赋值
     *  若没有匹配到，则不装配
     *  匹配多个时，会报错NoUniqueBeanDefinitionException
     * byName:将要赋值的属性的属性名作为bean的id在IOC容器中匹配某个bean，为属性赋值
     *
     */

    @Test
    public void testAutowire(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-autowire-xml.xml");
        UserController userController = ioc.getBean(UserController.class);
        userController.saveUser();
    }

}
