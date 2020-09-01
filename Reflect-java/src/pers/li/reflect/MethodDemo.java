package pers.li.reflect;

import java.lang.reflect.Method;

/**
 * create by lishengbo on 2018-03-14 11:39
 * 方法反射
 *
 */
public class MethodDemo {
    public static void main(String[] args) {
        //获取创建对象
        A s=new A();
        //获取对象类类型
        Class aClass = s.getClass();
        //获取一个方法即获取类的信息，获取方法名称和参数列表
        /*getMethod获取的是public方法
         *getDeclaredMethod获取自己声明的方法
         */
        try {
//            Method m = aClass.getMethod("print", new Class[]{int.class,int.class});
            Method m = aClass.getMethod("print", int.class, int.class);
            //方法的反射操作 --用m对象进行方法调用，和s.print调用效果相同
            s.print(10,20);
            Object invoke = m.invoke(s, 10, 20);
//            Object invoke = m.invoke(s, new Object[]{10,20});


        } catch (Exception e) {

            e.printStackTrace();
        }


    }
}

class A{


    public void  print(){
        System.out.println("no param");

    }

    public void  print(int x,int y){
        System.out.println(x+y);
    }

    public void  print(String x,String y){
        System.out.println("String:"+x+y);
    }
}