package pers.lish.classloader.myloader;

/**
 * 后台线程检测
 * create by lishengbo on 2017-12-21 15:20
 */
public class ThreadListen  implements  Runnable{

    @Override
    public void run() {
        while (true){
            //此处执行类时间戳监测,参数为被监听的类文件集合
            LoaderManager loaderManager=LoaderFactory.getManager(ListeningManager.getClassNameList().get(0));
            loaderManager.logic();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
