package com.atguigu.spring.test;

import com.alibaba.druid.support.json.JSONUtils;
import com.atguigu.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycleTest {

    /**
     * 生命周期
     * 1 实例化
     * 2 依赖注入
     * 3 初始化，需要bean的init-method属性指定初始化方法（在类中）,初始化前后可执行后置处理器的方法
     * 4 销毁（IOC容器关闭时），需要bean的destroy-method属性指定销毁方法
     *
     * 单例时，生命周期前三个步骤在获取IOC容器时执行。多例则在获取bean时执行
     */

    @Test
    public void test(){
        //ConfigurableApplicationContext是ApplicationContext的子接口，拓展了刷新和关闭容器的方法
        ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("spring-lifecycle.xml");
        User user = ioc.getBean(User.class);
        System.out.println(user);
        ioc.close();
    }


}
