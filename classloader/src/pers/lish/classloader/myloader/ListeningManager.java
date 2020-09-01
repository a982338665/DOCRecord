package pers.lish.classloader.myloader;

import java.util.ArrayList;
import java.util.List;

/**
 * 监听管理：
 *  --1.确定项目class文件存储路径：project_class_out_path
 *  --2.确定要热部署的文件路径集合：classNameList
 * 所有需要被热部署的类的集合
 * create by lishengbo on 2017-12-21 15:26
 */
public class ListeningManager {

    public static final  String project_class_out_path="G:\\idea_work_maven\\classloader\\out\\production\\classloader\\";

    public static  List<String> classNameList=new ArrayList<String>();

    static  {
        classNameList.add("pers.lish.classloader.myloader.LoaderTest1");
    }

    public static List<String> getClassNameList(){

        return classNameList;
    }
}
