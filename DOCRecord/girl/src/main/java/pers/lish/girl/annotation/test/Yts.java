package pers.lish.girl.annotation.test;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.*;
/**
 * create by lishengbo on 2017-12-22 11:02
 */
@Documented
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface Yts {
    public enum YtsType{util,entity,service,model}
    public YtsType classType() default YtsType.util;
}
