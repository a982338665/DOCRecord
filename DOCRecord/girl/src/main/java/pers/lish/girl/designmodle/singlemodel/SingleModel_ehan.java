package pers.lish.girl.designmodle.singlemodel;

/**
 * create by lishengbo on 2017-12-26 11:13
 * 饿汉式 单例模式
 */
public class SingleModel_ehan {
    private static SingleModel_ehan singleModel_ehan =new SingleModel_ehan();

    private SingleModel_ehan(){

    }

    public static  SingleModel_ehan getInstance(){

        return singleModel_ehan;
    }


}
