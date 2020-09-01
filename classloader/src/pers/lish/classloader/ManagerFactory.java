package pers.lish.classloader;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
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
    public static final String CLASS_PATH="G:\\idea_work_maven\\classloader\\out\\production\\classloader\\";
    //实现热加载的类的全名称（包名+类名）
    public static final String factPath="pers.lish.classloader.oneManager";

    public static BaseManager getManager(String className){
        File loadFile=new File(CLASS_PATH+factPath.replace(".","\\")+".class");
        long lastModified=loadFile.lastModified();
        //如果没有该热加载类的信息，证明此类未被加载进去，则需要加载此类到jvm
        if(loadtimemap.get(className)==null){
            getLoad(className, lastModified);
        }//如果被编译类的时间戳变化了，则需重新加载到jvm
        else if(loadtimemap.get(className).getLoadTime()!=lastModified){
            getLoad(className, lastModified);
        }
        return loadtimemap.get(className).getBaseManager();
    }

    private static void getLoad(String className, long lastModified) {
        MyClassLoader myClassLoader=new MyClassLoader(CLASS_PATH);
        Class<?> loadclass=null;
        try {
            loadclass=myClassLoader.loadClass(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        BaseManager manager= getManager(loadclass);
        LoadInfo loadInfo=new LoadInfo(myClassLoader,lastModified);
        loadInfo.setBaseManager(manager);
        loadtimemap.put(className,loadInfo);

    }

    /**
     * 以反射方式创建BaseManager子类对象
     * @param loadclass
     * @return
     */
    private static BaseManager getManager(Class<?> loadclass) {
        try {
            return (BaseManager)loadclass.getConstructor(new Class[]{}).newInstance(new Object[]{});
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return  null;
    }

}
