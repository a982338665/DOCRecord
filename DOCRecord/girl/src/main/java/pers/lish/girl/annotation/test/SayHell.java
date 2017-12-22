package pers.lish.girl.annotation.test;

import java.lang.reflect.InvocationTargetException;

/**
 * create by lishengbo on 2017-12-22 11:06
 */
@Yts(classType = Yts.YtsType.util)
public class SayHell {

    @HelloWorld(name = " 小明 ")
    @Yts
    public void sayHello(String name){
        if(name == null || name.equals("")){
            System.out.println("hello world!");
        }else{
            System.out.println(name + "say hello world!");
        }
    }

    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchMethodException, InstantiationException {
        ParseAnnotation parse = new ParseAnnotation();
        parse.parseMethod(SayHell.class);
        parse.parseType(SayHell.class);
    }
}