package pers.lish.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 自定义java类加载器来实现java类的热加载
 * create by lishengbo on 2017-12-20 17:38
 */
public class MyClassLoader extends  ClassLoader {

    /**
     * 要加载的java类的classpath路径
     **/
    private String classpath;

    public MyClassLoader(String classpath) {
        super(ClassLoader.getSystemClassLoader());
        this.classpath = classpath;
    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
//        return super.findClass(name);
        byte[] data = this.loadClassData(name);
        return this.defineClass(name, data, 0, data.length);
    }

    /**
     * 加载class文件中的内容
     * @param name
     * @return
     */
    public byte[] loadClassData(String name) {
        try {
            name = name.replace(".", "//");
            FileInputStream fileInputStream = new FileInputStream(new File(classpath + name + ".class"));
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
