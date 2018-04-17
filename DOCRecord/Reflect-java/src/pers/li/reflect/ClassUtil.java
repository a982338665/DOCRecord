package pers.li.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * create by lishengbo on 2018-04-14 13:43
 * Class的API
 */
public class ClassUtil {

    /**
     * 打印类的信息，包含累的成员函数，成员变量
     * @param o 该对象所属类的信息
     */
    public static void  printClassMessage(Object o){
        //获取类的类类型
        // o 传递的是那个子类的对象，c就是该子类的类类型
        Class c=o.getClass();
        //获取类的名称
        System.out.println("类的名称："+c.getName());
        //Method为方法对象
        //getMethods方法获取的是所有的public的函数，包括父类继承而来的
        //getDeclaredMethods获取的是所有该类自己声明的方法，不问访问权限，父类继承来的就不算了
        Method[] ms= c.getMethods();
        Method[] dms = c.getDeclaredMethods();
        for (int i = 0; i <ms.length ; i++) {
            //得到方法的返回值类型的类类型
            Class returnType=ms[i].getReturnType();
            //返回值类型
            System.out.print(returnType.getName()+" ");
            //得到方法的名称
            System.out.print(ms[i].getName()+"(");
            //获取参数类型--得到的是参数列表的类型的类类型
            Class[] parans=ms[i].getParameterTypes();
            for (Class class1:parans
                 ) {
                System.out.print(class1.getName()+",");
            }
            System.out.println(")");
        }
        /**
         * 成员变量也是对象 java.lang.reflect.Field
         * Field类封装了关于成员变量的操作
         * getFields()方法获取的是所有的public 的成员变量信息
         * getDeclaredFields获取的是该类自己声明的成员变量的信息
         */
//          Field[] fields = c.getFields();
            Field[] fields = c.getDeclaredFields();
        for (Field f:fields
             ) {
            //得到成员变量的类型的类类型 例如string.class
            Class fieldType=f.getType();
            String typeName=fieldType.getName();
            //得到成员变量的名称
            String fieldname=f.getName();
            System.out.println(typeName+" "+fieldname);

        }


    }

    public static void main(String[] args) {

        String he="hello";
        ClassUtil.printClassMessage(he);


    }
}
