package org.lxp.springboot;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * Created by linxiaopeng on 2018-10-30.
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface Blog {

    @AliasFor("btype")
    String value() default "";

    @AliasFor("value")
    String btype() default "";
}
