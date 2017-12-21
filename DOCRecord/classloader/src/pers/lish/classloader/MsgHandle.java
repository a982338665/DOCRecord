package pers.lish.classloader;

/**
 * create by lishengbo on 2017-12-21 10:16
 * 后台线程检测类
 */
public class MsgHandle implements Runnable {


    @Override
    public void run() {
        while (true){
            BaseManager manager=ManagerFactory.getManager(ManagerFactory.factPath);
            manager.logic();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
