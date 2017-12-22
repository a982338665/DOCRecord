package pers.lish.girl.aoplearning.dynamicproxy_cglib;

import org.springframework.cglib.proxy.Enhancer;
import pers.lish.girl.aoplearning.staticproxy.RealClass;
import pers.lish.girl.aoplearning.staticproxy.Subject;

/**
 * create by lishengbo on 2017-12-22 17:26
 * 利用继承来实现的动态代理
 * cglib
 */
public class CglibTest {
    public static void main(String[] args) {
        Enhancer enhancer=new Enhancer();
        //要代理的类
        enhancer.setSuperclass(RealClass.class);
        //代理类
        enhancer.setCallback(new DemoMethodintercepptor());
        //创建代理对象
        Subject subject= (Subject) enhancer.create();
        subject.request();
        subject.hello();

    }
}
