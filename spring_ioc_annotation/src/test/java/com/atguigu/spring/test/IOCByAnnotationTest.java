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
     *
     * 通过注解+扫描所配置的bean，其id默认为类名的小驼峰，可以在注解中设置id，@Controller("userController")
     *
     * 自动装配注解 @Autowired，注释的位置如下
     * 1、放在需要自动装配的成员变量上，此时目标类型不需要set方法
     * 2、标识在set方法上
     * 3、为当前成员变量赋值的有参构造
     *
     * @Autowired通过
     *  1、byType的方式在IOC容器中匹配某个bean为属性赋值
     *  2、当匹配多个bean时，会自动转化为byName的方式实现匹配，即将要赋值的属性的属性名作为id去匹配
     *  3、若有多个类型匹配的bean且id都与要赋值的属性名不同，报错
     *  4、可以通过添加@Qualifier注解来指定特定id的bean赋值
     *     @Autowired
     *     @Qualifier("userServiceImpl")
     *     private UserService userService;
     *
     *
     * @Autowired注解中有个属性值required，默认值为true，要求必须完成装配，无匹配时报错，false则在无匹配bean时直接使用默认值
     */

    @Test
    public void test(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        UserController userController = ioc.getBean(UserController.class);
//        System.out.println(userController);
//        UserService userService = ioc.getBean(UserService.class);
//        System.out.println(userService);
//        UserDao userDao = ioc.getBean(UserDao.class);
//        System.out.println(userDao);
        userController.saveUser();
    }

}
