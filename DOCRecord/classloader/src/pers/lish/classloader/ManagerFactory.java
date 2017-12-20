package pers.lish.classloader;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 工厂模式
 * create by lishengbo on 2017-12-20 18:10
 * 加载manager的工厂
 */
public class ManagerFactory {
    //记录热加载类的加载信息
    private static  final Map<String,LoadInfo> loadtimemap=new HashMap<String,LoadInfo>();
    //要加载的类的classpath
    private static final String CLASS_PATH="G:\\idea_work_maven\\classloader\\out";
    //实现热加载的类的全名称（包名+类名）
    private static final String factPath="pers.lish.classloader.oneManager";

    private static BaseManager getManager(String className){
        File loadFile=new File(CLASS_PATH+factPath.replace(".","\\"+".class"));
        return null;
    }
}
