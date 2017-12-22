package pers.lish.girl.annotation.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * create by lishengbo on 2017-12-22 11:26
 * Method类代表一个方法，所以invoke（调用）就是调用Method类代表的方法。它可以让你实现动态调用，例如你可以动态的传人参数
 */
public class invokTest {

    public static void main(String[] args) {
        String[] names = {"tom", "tim", "allen", "alice"};
        Class<?> clazz = Test33.class;
        try {
            Method method = clazz.getMethod("sayHi", String.class);
            for (String name : names)
                method.invoke(clazz.newInstance(), name);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}

class Test33 {
    public void sayHi(String name) {
        System.out.println("Hi " + name);
    }
}