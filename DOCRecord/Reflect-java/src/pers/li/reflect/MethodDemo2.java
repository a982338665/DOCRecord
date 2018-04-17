package pers.li.reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * create by lishengbo on 2018-04-17 13:51
 * 泛型的实质：仅作用于编译期，使用反射可以验证
 */
public class MethodDemo2 {
    public static void main(String[] args) {

        ArrayList arrayList=new ArrayList();
        ArrayList<String> list=new ArrayList();
        list.add("lisehngbo");

        Class<? extends ArrayList> c1 = arrayList.getClass();
        Class<? extends ArrayList> c2 = list.getClass();

        System.out.println(c1==c2);

        //反射操作都是在编译之后的
        //c1=c2为true说明编译之后集合的泛型市区泛型化的
        //java中集合的泛型是防止错误输入的，只在编译阶段有效 -- 绕过编译无效
        //验证：通过方法反射操作便可以绕过编译
        //ArrayList<String> list=new ArrayList();仅能存放String类型是因为泛型在编译期有效，若反射绕过编译，便都可以存放
        Method m=null;
        try {
            m = c2.getMethod("add", Object.class);
            m.invoke(list,20);
            m.invoke(list,true);
            System.out.println(list.toString());
            //不能使用以下遍历方式进行遍历，因为添加对象时，已经绕过泛型，有其他类型数据存在
           /* for (String s:
                 list) {
                System.out.println(s);
            }*/

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
