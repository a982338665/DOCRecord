package pers.lish.girl.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * create by lishengbo on 2017-12-20 10:39
 */
@Aspect
@Component
public class HttpAspect {
    /**
     * 方法执行之前执行
     */
/*//    @Before("execution(public * pers.lish.girl.controller.GirlController.girlList(..))")
    @Before("execution(public * pers.lish.girl.controller.GirlController.*(..))")
    public void log(){
        System.err.print("调用开始-----------------");
    }
    @After("execution(public * pers.lish.girl.controller.GirlController.*(..))")
    public void after(){
        System.err.print("调用结束-----------------");
    }*/
    /********以上代码等同于以下******************************************************/
    /**
     * 日志的打印
     */
    private  final static Logger log= LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * pers.lish.girl.controller.GirlController.*(..))")
    public void log(){
    }

    @Before("log()")
    public void before(JoinPoint joinPoint){
        log.info("log调用开始-----------------");
        //url获取
       ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
       HttpServletRequest request = requestAttributes.getRequest();
       log.info("url={}",request.getRequestURI());
       log.info("method={}",request.getMethod());
       log.info("ip={}",request.getRemoteAddr());
       log.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
       log.info("args={}",joinPoint.getArgs());

    }
    @After("log()")
    public void after(){
        log.info("log调用结束-----------------");
//        System.err.print("调用结束-----------------");
    }

    /**
     * 接口响应内容获取
     * @param o
     */
    @AfterReturning(returning = "o",pointcut = "log()")
    public void  returning(Object o){
        log.info("response={}",o.toString());
    }

}
