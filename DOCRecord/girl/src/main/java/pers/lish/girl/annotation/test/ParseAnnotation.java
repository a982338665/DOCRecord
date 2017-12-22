package pers.lish.girl.annotation.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * create by lishengbo on 2017-12-22 11:04
 * 利用反射机制-解析注解
 */
public class ParseAnnotation {

    public void parseMethod(Class clazz) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchMethodException, InstantiationException{
        Object obj = clazz.getConstructor(new Class[]{}).newInstance(new Object[]{});
        System.err.println(obj.toString());
        //获取类的方法集合
        Method[] declaredMethods = clazz.getDeclaredMethods();
        //遍历每个方法
        for(Method method :declaredMethods){
            //打印方法名称
            System.err.println(method.getName());
            //判断此方法时候含有指定注解HelloWorld.class
            HelloWorld say = method.getAnnotation(HelloWorld.class);
            String name = "";
            //若helloworld注解存在，则将注解里name的值赋值给name，并将该参数动态传入此方法
            if(say != null){
                name = say.name();
                //方法传入实例对象和参数值
                method.invoke(obj, name);
            }
            //判断此方法时候含有指定注解Yts.class
            Yts yts = (Yts)method.getAnnotation(Yts.class);
            if(yts != null){
                if(Yts.YtsType.util.equals(yts.classType())){
                    System.out.println("this is a util method");
                }else{
                    System.out.println("this is a other method");
                }
            }
        }
    }
    @SuppressWarnings("unchecked")
    public void parseType(Class clazz) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        Yts yts = (Yts) clazz.getAnnotation(Yts.class);
        if(yts != null){
            if(Yts.YtsType.util.equals(yts.classType())){
                System.out.println("this is a util class");
            }else{
                System.out.println("this is a other class");
            }
        }
    }
}
