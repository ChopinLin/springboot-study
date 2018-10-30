package org.lxp.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.BeanDefinitionParserDelegate;
import org.springframework.stereotype.Component;
import sun.applet.AppletClassLoader;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by linxiaopeng on 2018-7-25.
 */
@Component
public class AppTest {

    BeanDefinitionParserDelegate b;
    AbstractBeanDefinition a;
    DefaultListableBeanFactory d;
    Logger logger = LoggerFactory.getLogger(getClass());

    @Blog("testReturn")
    public void test(){
        logger.info("before inc()");
        inc();
        logger.info("after inc()");
    }


//    @Blog("testReturn")
    public int inc(){
        int x= 1;
        try {
            x = 2;
            logger.info("x={}",x);
            return x;
        }catch (Exception e){
            x=3;
            return x;
        }finally {
            x=5;
            return x;
        }
    }

    public static void main(String[] args){
//        boolean b = true;
//        if(b) System.out.println("hello java"+ b);
//        if(b == true)  System.out.println("hello jvm"+ b);
//        int i= new Test().inc();
//        System.out.println("i= "+i);
//        Executors.newCachedThreadPool();
        System.out.println("\\\\`");
    }
}
