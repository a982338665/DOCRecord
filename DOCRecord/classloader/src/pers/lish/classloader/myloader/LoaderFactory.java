package pers.lish.classloader.myloader;

import pers.lish.classloader.BaseManager;
import pers.lish.classloader.LoadInfo;
import pers.lish.classloader.MyClassLoader;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * 工厂类---用于进行类加载，调用，实现
 * create by lishengbo on 2017-12-21 15:18
 */
public class LoaderFactory {

    //定义返回的加载管理接口；
    private static LoaderManager loaderManager;
    //记录热加载类的加载信息,Map<类名,时间戳>
    private static  final Map<String,String> loadtimemap=new HashMap<String,String>();
    //要加载的项目class文件的输出路径
    public static final String project_class_out_path=ListeningManager.project_class_out_path;
    //实现热加载的类的全名称（包名+类名）

    public static LoaderManager getManager(String classname) {

        File loadFile=new File(project_class_out_path+classname.replace(".","\\")+".class");
        long lastModified=loadFile.lastModified();
        //如果没有该热加载类的信息，证明此类未被加载进去，则需要加载此类到jvm
        if(loadtimemap.get(classname)==null){
            getLoad(classname, lastModified);
        }//如果被编译类的时间戳变化了，则需重新加载到jvm
        else if(Long.parseLong(loadtimemap.get(classname))!=lastModified){
            getLoad(classname, lastModified);
        }
        return loaderManager;
    }

    /**
     * 重新加载类-------，在此过程中给热加载管理接口赋值
     * @param classname
     * @param lastModified
     */
    private static void getLoad(String classname, long lastModified) {
        ClassLoaderCommon myClassLoader=new ClassLoaderCommon(project_class_out_path);
        Class<?> loadclass=null;
        try {
            loadclass=myClassLoader.loadClass(classname);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        loaderManager= getManager(loadclass);
//        LoadInfo loadInfo=new LoadInfo(myClassLoader,lastModified);
//        loadInfo.setBaseManager(manager);
        loadtimemap.put(classname,lastModified+"");
    }
    /**
     * 以反射方式创建BaseManager子类对象
     * @param loadclass
     * @return
     */
    private static LoaderManager getManager(Class<?> loadclass) {
        try {
            return (LoaderManager)loadclass.getConstructor(new Class[]{}).newInstance(new Object[]{});
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
