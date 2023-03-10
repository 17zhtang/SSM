package com.atguigu.spring.test;

import com.atguigu.spring.controller.BookController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * 声明式事务的配置步骤
 * 1、在Spring的配置文件中配置事务管理器
 * 2、开启事务注解的驱动
 * 在需要被事务管理的方法上添加@transaction注解
 * @Transaction 注解标识在方法上或者类上
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:tx-xml.xml")
public class TxByXMLTest {

    @Autowired
    private BookController bookController;

    @Test
    public void testBuyBook(){
//        bookController.buyBook(1,1);
        bookController.buyBook(1,1);
    }


}
