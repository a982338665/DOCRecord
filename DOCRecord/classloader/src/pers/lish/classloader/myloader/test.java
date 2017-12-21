package pers.lish.classloader.myloader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 后台线程检测
 * create by lishengbo on 2017-12-21 15:19
 */
public class test {
    public static void main(String[] args) throws IOException, InterruptedException {
//        new Thread(new ThreadListen()).start();
//        readfile("G:\\idea_work_maven\\classloader\\out\\production\\classloader");
        while (true){
            System.out.println("1212313xcvbbxzc23");
            Thread.sleep(1000);
        }

    }

    public static ArrayList<String> getFiles(String path) {
        ArrayList<String> files = new ArrayList<String>();
        File file = new File(path);
        File[] tempList = file.listFiles();

        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
              System.out.println("文     件：" + tempList[i]);
                files.add(tempList[i].toString());
            }
            if (tempList[i].isDirectory()) {
              System.out.println("文件夹：" + tempList[i]);/**/
            }
        }
        return files;
    }
    public static boolean readfile(String filepath) throws FileNotFoundException, IOException {
        try {

            File file = new File(filepath);
            if (!file.isDirectory()) {
                System.out.println("文件");
                System.out.println("path=" + file.getPath());
                System.out.println("absolutepath=" + file.getAbsolutePath());
                System.out.println("name=" + file.getName());

            } else if (file.isDirectory()) {
                System.out.println("文件夹");
                String[] filelist = file.list();
                for (int i = 0; i < filelist.length; i++) {
                    File readfile = new File(filepath + "\\" + filelist[i]);
                    if (!readfile.isDirectory()) {
                        System.out.println("path=" + readfile.getPath());
                        System.out.println("absolutepath="
                                + readfile.getAbsolutePath());
                        System.out.println("name=" + readfile.getName());

                    } else if (readfile.isDirectory()) {
                        readfile(filepath + "\\" + filelist[i]);
                    }
                }

            }

        } catch (FileNotFoundException e) {
            System.out.println("readfile()   Exception:" + e.getMessage());
        }
        return true;
    }
}
