package pers.li.reflect.classforname;

/**
 * create by lishengbo on 2018-04-14 11:31
 */
public class ClassForNameDemo {

    /**
     * args 只接受cmd命令中的参数 即执行时候
     * javac Word.java
     * javac ClassForNameDemo.java
     * java  ClassForNameDemo Word
     * _______________________________
     * javac Excel.java
     * java  ClassForNameDemo Excel
     * _______________________________
     *
     * 由以上可看出，ClassForNameDemo仅会经过一次编译，便可终生使用,此为运行时加载类为动态加载类
     * 因此,在新增功能时,只需要写一个类(ppt)去实现一个接口（Interface），调用时就会自己去执行
     * @param args
     */
    public static void main(String[] args) {
//        System.out.println(args.toString());
        Class aClass=null;
        try {

            aClass = Class.forName(args[0]);
            Interface anInterface=(Interface)aClass.newInstance();
            anInterface.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
