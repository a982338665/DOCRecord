package pers.lish.classloader.myloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * 核心类
 * 自定义java类加载器来实现java类的热加载
 * create by lishengbo on 2017-12-20 17:38
 */
public class ClassLoaderCommon extends  ClassLoader {

    /**
     * 要加载的java类的classpath路径
     **/
    private String classpath;

    /**
     * 加载器构造方法，内部调用系统类加载器
     * @param classpath
     */
    public ClassLoaderCommon(String classpath) {
        /**进行赋值之前先调用其父类的有参构造方法，参数为类构造器*/
        super(ClassLoader.getSystemClassLoader());
        this.classpath = classpath;
    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        //此处不再使用父类的类加载方法-------而是自定义
//        return super.findClass(name);
        //需要被加载的class文件内容--转换为字节数组
        byte[] data = this.loadClassData2(name);
        //自定义类加载：参数分别为 类名，字节数组，开始索引，结束索引
        return this.defineClass(name, data, 0, data.length);
    }

    /**
     * 加载class文件中的内容，将其转换为byte字节数组，便于提醒类加载器加载
     * @param name
     * @return
     */
    public byte[] loadClassData2(String name) {
        try {
            name = name.replace(".", "//");
            FileInputStream fileInputStream = new FileInputStream(new File(classpath + name + ".class"));
            //字节数组输出流--
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int b = 0;
            while ((b = fileInputStream.read()) != -1) {
                baos.write(b);
            }
            fileInputStream.close();
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
