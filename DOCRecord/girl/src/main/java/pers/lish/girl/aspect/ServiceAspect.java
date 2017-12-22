package pers.lish.girl.aspect;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * create by lishengbo on 2017-12-20 10:39
 * 业务逻辑拦截器定义（注解形式）
 */
@Aspect
@Component
public class ServiceAspect {

    private  final static Logger log= LoggerFactory.getLogger(HttpAspect.class);
    @Autowired
    private Aspect_Content aspect;
    /*********************以注解形式定义与方法级别上**************************************************************/
    /**
     * 所有带有注解@AdmainOnly的方法都要经过此拦截器---此注解写全类名
     * --匹配该类下的所有方法
     *  @Pointcut("@within(pers.lish.girl.aspect.Aspect_Content)")
     * --匹配pers.lish.girl包及其子包下的所有类的方法
     * @Pointcut("@within(pers.lish.girl..)")
     * *************************** 对象匹配**********************************************************
     * --匹配当前传入的代理对象的方法=====接口
     * @Pointcut("this(pers.lish.girl.aspect.Aspect_Content)")
     * --匹配实现该接口的目标对象的方法（例如：DemoDao implement IDao），即DemoDao的方法===该接口的所有实现类
     * @Pointcut("target(pers.lish.girl.IDao)")
     * --匹配所有以service结尾的bean中的方法
     * @Pointcut("bean(pers.lish.girl.IDao)")
     * *************************** 参数匹配：*********************************************************
     * --匹配girl包下，所有类的成员变量为long类型的所有方法
     * @Pointcut("args(Long)&&within(pers.lish.girl.*)")
     * @Pointcut("args(Long,..)&&within(pers.lish.girl.*)")
     * *************************** 注解匹配  *********************************************************
     *--1.方法级别注解：
     * @Pointcut("@annotation(pers.lish.girl.security.AdmainOnly)")
     * --2.类级别注解：被注解withinAnnotation标记的类的方法被匹配
     * @Pointcut("@within(pers.lish.girl.security.withinAnnotation) && within(pers.lish.girl..*)")
     * --3.target注解：在Spring环境下与@within注解一致
     * --4.参数注解：被注解withinAnnotation标记的类，作为其它类方法的参数，此中方法被匹配
     * @Pointcut("@within(pers.lish.girl.security.withinAnnotation) && within(pers.lish.girl..*)")
     *  *************************** execution()表达式  ************************************************
     *    //方法修饰符+任意返回值（*）+包名及子包+类+任意方法（*）+（..）（任意参数:无参则为(),第一个参数为Long的(Long)）+只拦截抛出异常的方法
    //    @Pointcut("execution(public * com.imooc.service..*Service.*(..)) throws Exception")
    //    @Pointcut("execution(public String com.imooc.service..*Service.*(..))")
    //    @Pointcut("execution(public void com.imooc.service..*Service.*(..))")
     * *************************** advice注解******* **************************************************
     *   @Before("admainOnly()")------方法执行之前织入
         @After()---------------------方法执行之后织入
         @Around()--------------------包含所有注解(万能注解)
         @AfterThrowing---------------方法抛出异常时执行
         @AfterReturning(returning = "o",pointcut = "log()")-----方法有返回值时执行，并且可以获取返回值
         public void  returning(Object o){log.info("response={}",o.toString());}
         //    @Around("log()")
         //    public Object  around(ProceedingJoinPoint proceedingJoinPoint){
         //        log.error("before={}",proceedingJoinPoint.getSignature().getName());
         //        Object result=null;
         //        try {
         //            result=proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
         //            log.error("afterReturning={}",result);
         //        } catch (Throwable throwable) {
         //            log.error("afterException={}",throwable);
         //            throwable.printStackTrace();
         //        }finally {
         //            log.error("afterresponse={}","-----------");
         //        }
         //        return  result;
         //    }
     *
     *
     */
    @Pointcut("@annotation(pers.lish.girl.security.AdmainOnly)")
    public void admainOnly(){}
    @Before("admainOnly()")
    public void after2(){
        log.error("注解形式拦截器定义-----------------");
        aspect.chackAccess();
    }


}
