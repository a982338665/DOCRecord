package pers.lish.girl.aoplearning;

/**
 * create by lishengbo on 2017-12-22 18:10
 */
public abstract class Handler {

    //子类需要去实现的抽象方法
    protected abstract void handleProcess();
    //判断接下来是否有人去处理
    private Handler sucessor;

    public Handler getSucessor() {
        return sucessor;
    }

    public void setSucessor(Handler sucessor) {
        this.sucessor = sucessor;
    }
    //封装对外暴露的可执行方法
    public void excute(){
        //执行自己的handleProcess方法
        handleProcess();
    }
}
