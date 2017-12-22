package pers.lish.girl.annotation.test;

import java.lang.annotation.*;

/**
 * create by lishengbo on 2017-12-22 11:01
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface HelloWorld {
    public String name()default "";
}
