package com.atguigu.spring.test;

import com.atguigu.spring.pojo.Person;
import com.atguigu.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCByXMLTest {

    /**
     * 获取bean的三种方式
     * 1、根据bean的id获取
     * 2、根据bean的类型获取,（这时匹配类型的bean只能有一个），用得较多
     * 3、根据bean的id和类型获取
     * 
     *根据类型来获取bean时，在满足bean唯一性的前提下，其实只是看：『对象 instanceof 指定的类
     * 型』的返回结果，只要返回的是true就可以认定为和类型匹配，能够获取到
     * 通过bean的类型、继承的类、实现的接口的类型都可以获取bean
     */
    @Test
    public void testIOC(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
//        Student studentOne = (Student)ioc.getBean("studentOne");
//        Student studentOne = ioc.getBean(Student.class);
//        Student studentOne = ioc.getBean("studentOne",Student.class);
        Person person = ioc.getBean(Person.class);
        System.out.println(person);
    }

}
