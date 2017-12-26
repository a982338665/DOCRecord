package pers.lish.girl.aoplearning.dynamicproxy_jdk;

import pers.lish.girl.aoplearning.staticproxy.RealClass;
import pers.lish.girl.aoplearning.staticproxy.Subject;

import java.lang.reflect.Proxy;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

/**
 * create by lishengbo on 2017-12-22 16:21
 * 优点：
 *    代码简洁易读
 *    public static Object newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)
 */
public class JDKTest {

    public static void main(String[] args) {
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        System.out.println(System.getProperty("user.dir"));
        Properties properties = System.getProperties();
        Set<String> names = properties.stringPropertyNames();
        Set<String> sort = new TreeSet<String>();//排下序
        for(String name : names){
            sort.add(name);
        }
        for(String name : sort){
            System.out.println(name+"="+properties.getProperty(name));
        }
//        System.out.println(System.getProperties().);
        System.out.println(System.getProperties().toString());
        //当前类+真实接口+代理实现类（真实实现类）
        Subject subject= (Subject) Proxy.newProxyInstance(JDKTest.class.getClassLoader(),new Class[]{Subject.class},new jdkSubject(new RealClass()));
        subject.request();
        subject.hello();
    }
}
