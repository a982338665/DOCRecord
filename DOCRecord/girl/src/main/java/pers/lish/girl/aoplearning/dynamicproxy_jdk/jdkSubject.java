package pers.lish.girl.aoplearning.dynamicproxy_jdk;

import pers.lish.girl.aoplearning.staticproxy.RealClass;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 等同于aspect注解---动态获取反射方法----接口实现
 * create by lishengbo on 2017-12-22 16:14
 */
public class jdkSubject implements InvocationHandler {
    private RealClass realClass;
    /**
     * 引用真实实现类
     * @param realClass
     */
    public  jdkSubject ( RealClass realClass){
        this.realClass=realClass;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //引用开始前做事
        System.out.println("代理前执行-===---------------");
        Object result=null;
        try {
            //动态获取对象，动态传参
            result = method.invoke(realClass, args);
        } catch (Exception e) {
            System.out.println("错误：-----"+e.getMessage());
            System.out.println("代理类不能改变实际的逻辑执行，所以异常要抛出");
            throw e;
        } finally {
            System.out.println("代理后执行----------------");
        }
        return result;
    }
}
