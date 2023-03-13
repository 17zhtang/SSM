package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    /**
     * 路径/被解析成localhost:8080/SpringMVC/
     * @return
     */
    @RequestMapping("/")
    public String protal(){
        //将逻辑视图返回，index会被视图解析器解析
        //<!-- 视图前缀 -->
        // <property name="prefix" value="/WEB-INF/templates/"/>
        // <!-- 视图后缀 -->
        // <property name="suffix" value=".html"/>
        return "index";
    }

    @RequestMapping("/hello")
    public String hello(){
        return "success";
    }

}
