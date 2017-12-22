package pers.lish.girl.security;

import java.lang.annotation.*;

/**
 * create by lishengbo on 2017-12-22 14:04
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)//类级别
@Inherited //被该注释标记的类，若被继承，那么子类也遵从该注解
public @interface withinAnnotation {
}
