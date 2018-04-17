package pers.li.reflect;

/**
 * create by lishengbo on 2018-04-14 10:30
 */
public class ClassDemo {
    public static void main(String[] args) {

        //Foo作为一个类时，实例对象，如下表示
        Foo foo=new Foo();
        //Foo作为一个对象时，他是java.lang.Class的一个实例对象，并且只能由虚拟机创建这个实例对象
        /** 创建类的实例对象的三种方式**********************************/
        //所以写的每一个类都是Class的实例对象，有三种表示方式
        //1.-->任何一个类都有一个静态的成员变量class
        Class c1=Foo.class;
        //2.-->已知该类对象，通过getClass方法
        Class c2=foo.getClass();
        //官网c1,c2表示了foo类的类类型（class type），即Class对象
        //因为Class（c1,c2）都是Foo这个类的实例对象，所以二者相等
        System.out.println(c1==c2);
        //3.-->Class.forName
        //  ·不仅表示类的类类型，还代表了动态加载类
        //  ·区分编译和运行
        //  ·编译时加载类为静态加载，运行时加载类为动态加载类
        Class c3=null;
        try {
            c3 = Class.forName("pers.li.reflect.Foo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(c3==c2);//同上为true
        /** 根据类类型即Class创建该类的实例对象**************************/
        Object o = null;
        try {
            o = c1.newInstance();//需要此类本身含有无参构造方法
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Foo foo1=(Foo)o;
        /** 基本数据类型的类类型***************************************/
        //只要是类中申明的，均含有类类型，除去package，因为他是在类外
        Class cc1=int.class;//int的类类型， 字节码
        Class cc2=String.class;//String的类类型， 字节码
        Class cc3=double.class;
        Class cc4=Double.class;
        Class cc5=void.class;
        System.out.println(cc1.getName());
        System.out.println(cc2.getName());
        System.out.println(cc2.getSimpleName());//不包含包名的类名称
        System.out.println(cc4.getName());


    }
}


class  Foo{
    void print(){
        System.out.println("------------");
    }
        }