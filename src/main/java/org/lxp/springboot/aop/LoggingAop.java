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

    @Pointcut("execution(public * org.lxp.springboot.*.*(..))")
    public void bussinessLog(){}

//    @Before("bussinessLog() && @annotation(blog)")
//    public void beforelog(JoinPoint joinPoint,Blog blog) throws Throwable{
//        MDC.put(key1,blog.btype());
//    }

    @Around("bussinessLog() && @annotation(blog)")
    public void aroundlog(ProceedingJoinPoint proceedingJoinPoint,Blog blog) throws Throwable{
        logger.info("before around");
        MDC.put(key1,blog.value());
        proceedingJoinPoint.proceed();
        logger.info("after around");

    }

    @After("bussinessLog()")
    public void afterlog(JoinPoint joinPoint) throws Exception{
        MDC.remove(key1);
    }

    @AfterReturning("bussinessLog()")
    public void afterReturninglog(JoinPoint joinPoint) throws Exception{
        logger.info("AfterReturning");
    }

    @AfterThrowing("bussinessLog()")
    public void afterThrowinglog(JoinPoint joinPoint) throws Exception{
        logger.info("AfterThrowing");

    }
}
