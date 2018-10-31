package org.lxp.springboot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.lxp.springboot.Blog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

/**
 * Created by linxiaopeng on 2018-10-30.
 */
@Aspect
@Component
public class LoggingAop {
    private static String key1="blog";
    Logger logger = LoggerFactory.getLogger(getClass());

//    Around
//    before around
//    Before
//    call method();
//    after around
//    After
//    AfterReturning/AfterThrowing

    @Pointcut("execution(public * org.lxp.springboot.*.*(..))")
    public void bussinessLog(){}

    @Before("bussinessLog() && @annotation(blog)")
    public void beforelog(JoinPoint joinPoint,Blog blog) throws Throwable{
        //执行时间  Around 增强 proceedingJoinPoint.proceed()调用前的代码 先于 Before执行，最接近实际方法调用前
        logger.info("Before");
    }

    @Around("bussinessLog() && @annotation(blog)")
    public void aroundlog(ProceedingJoinPoint proceedingJoinPoint,Blog blog) throws Throwable{
        logger.info("Around");
        logger.info("before around");
        MDC.put(key1,blog.value());
        //执行时间  Before 增强前
        proceedingJoinPoint.proceed();
        //增强方法返回后立即执行，最接近实际方法调用后
        logger.info("after around");

    }

    @After("bussinessLog()")
    public void afterlog(JoinPoint joinPoint) throws Exception{
        //执行时间  Around 增强方法返回前的代码先于 After 执行
        logger.info("After");
        MDC.remove(key1);
    }

    @AfterReturning("bussinessLog()")
    public void afterReturninglog(JoinPoint joinPoint) throws Exception{
        //执行时间  After 增强方法返回前的代码先于 AfterReturning 执行
        logger.info("AfterReturning");
    }

    @AfterThrowing("bussinessLog()")
    public void afterThrowinglog(JoinPoint joinPoint) throws Exception{
        //执行时间  After 增强方法返回前的代码先于 AfterThrowing 执行
        //AfterThrowing 与 AfterReturning是互斥的。抛异常才执行 AfterThrowing
        logger.info("AfterThrowing");

    }
}
