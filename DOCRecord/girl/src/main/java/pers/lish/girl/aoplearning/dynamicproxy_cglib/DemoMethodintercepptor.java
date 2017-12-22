package pers.lish.girl.aoplearning.dynamicproxy_cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * create by lishengbo on 2017-12-22 17:22
 * 动态代理类---Cglib代理（主继承）
 */
public class DemoMethodintercepptor implements MethodInterceptor{

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //引用开始前做事
        System.out.println("代理前执行-===-------cglib--------");
        Object result=null;
        try {
            //动态获取对象，动态传参
            result = methodProxy.invokeSuper(o,objects);
        } catch (Exception e) {
            System.out.println("错误：-----"+e.getMessage());
            System.out.println("代理类不能改变实际的逻辑执行，所以异常要抛出");
            throw e;
        } finally {
            System.out.println("代理后执行---------cglib-------");
        }
        return result;
    }
}
