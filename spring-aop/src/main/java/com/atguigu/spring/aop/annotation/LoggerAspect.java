package com.atguigu.spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;


/**
 * @Before:前置通知，在目标对象方法执行之前执行
 * @After:后置通知，在目标对象的finally字句中执行
 * @AfterReturning:返回通知，目标对象方法返回值之后执行，异常时不执行
 * @AfterThrowing:异常通知
 *
 * 切入点表达式：设置在标识通知的注解的value属性中
 * 第一个*表示任意的访问修饰符和返回值类型
 * 第二个*表示类中任意方法
 * 类名的位置也可以设置为*，表示该包下的任意类
 * @Before("execution(* com.atguigu.spring.aop.annotation.CalculatorImpl.*(..))")
 *
 * 获取链接点的信息
 * 在通知方法的参数位置，设置JoinPoint类型的参数，就可以获得链接点所对应的方法的信息
 * Signature signature = joinPoint.getSignature();
 *
 * 重用切入点表达式，声明一个公用的切入点表达式
 *  @Pointcut("execution(* com.atguigu.spring.aop.annotation.CalculatorImpl.*(..))")
 *     public void pointCut(){}
 * 使用该表达式的切入点    @After("pointCut()")
 *
 */

@Component
@Aspect  //将组件标识为切面
public class LoggerAspect {

    //公共的切入点表达式
    @Pointcut("execution(* com.atguigu.spring.aop.annotation.CalculatorImpl.*(..))")
    public void pointCut(){}


//    @Before("execution(public int com.atguigu.spring.aop.annotation.CalculatorImpl.add(int,int))")
    //CalculatorImpl类的所有方法都加入前置通知
    @Before("execution(* com.atguigu.spring.aop.annotation.CalculatorImpl.*(..))")
    public void beforeAdviceMethod(JoinPoint joinPoint){
        //获取链接点对应方法的签名信息
        Signature signature = joinPoint.getSignature();
        //获取链接点所对应的方法的参数
        Object[] args = joinPoint.getArgs();
//        System.out.println("LoggerAspect,前置通知");
        System.out.println("LoggerAspect，方法："+signature.getName()+"，参数："+ Arrays.toString(args));
    }

    //后置通知
    @After("pointCut()")
    public void afterAdviceMethod(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect 方法："+signature.getName()+"，执行完毕");
    }

    //在返回通知中若想获取目标对象的返回值，需要在AfterReturning中设置returning属性，设定属性名
    //就可以把通知方法的某个参数指定为目标对象的返回值的参数
    @AfterReturning(value = "pointCut()",returning = "result")
    public void afterReturningAdviceMethod(JoinPoint joinPoint, Object result){
        Signature signature = joinPoint.getSignature();

        System.out.println("LoggerAspect 方法："+signature.getName()+"，结果:"+result);
    }

    //在异常通知中若想获取目标对象的异常，需要在AfterThrowing中设置throwing属性，设定属性名
    //就可以把通知方法的某个参数指定为目标对象的异常的参数
    @AfterThrowing(value = "pointCut()",throwing = "ex")
    public void afterThrowingAdviceMethod(JoinPoint joinPoint,Throwable ex){
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect 方法："+signature.getName()+"异常："+ex);
    }


    @Around("pointCut()")
    //环绕通知的方法的返回值一定要和目标对象的方法的返回值一致
    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint){
        Object result = null;
        try {
            System.out.println("环绕通知-->前置通知");
            //表示目标对象方法的执行
            result = joinPoint.proceed();
            System.out.println("环绕通知-->返回通知");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环绕通知-->异常通知");
        }finally {
            System.out.println("环绕通知-->后置通知");
        }
        return result;
    }
}
