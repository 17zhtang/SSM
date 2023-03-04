package com.atguigu.spring.proxy;

import java.lang.reflect.*;
import java.util.Arrays;

public class ProxyFactory {

    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxy(){
        /**
         * Proxy.newProxyInstance的参数：
         *ClassLoader loader 指定加载动态生成的代理类的类加载器
         *Class<?>[] interfaces 获取目标对象实现的所有接口的class对象的数组
         *InvocationHandler h 设置代理类中的抽象方法如何重写
         */
        ClassLoader classLoader = this.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //proxy表示代理的对象，method表示要执行的方法，args表示要执行方法的参数列表
                Object result = null;
                try {
                    System.out.println("日志，方法："+method.getName()+",参数："+ Arrays.toString(args));
                    result = method.invoke(target,args);
                    System.out.println("日志，方法："+method.getName()+",结果："+result);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("日志，方式："+method.getName()+"异常"+e);
                }  finally {
                    System.out.println("日志，方法："+method.getName()+"，方法执行完毕");
                }
                return result;
            }
        };
        return Proxy.newProxyInstance(classLoader, interfaces,h);
    }
}
