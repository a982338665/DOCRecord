package pers.lish.girl.designmodle.singlemodel;

/**
 * create by lishengbo on 2017-12-26 11:39
 * 懒汉式
 */
public class SingleModel_lazy {

    private SingleModel_lazy(){

    }
    private static SingleModel_lazy singleModel_lazy=null;

    public synchronized static SingleModel_lazy getInstance(){
        if(singleModel_lazy==null){
            singleModel_lazy=new SingleModel_lazy();
        }
        return singleModel_lazy;
    }
}
