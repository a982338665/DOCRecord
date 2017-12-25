package pers.lish.girl.aoplearning.dynamicproxy_modle.basic_chain;

/**
 * create by lishengbo on 2017-12-25 08:45
 * 模板设计模式：---责任链模式
 */
public abstract class Handler {

    /**
     * 判断接下来是否会有人去处理
     */
    private Handler successor;

    public Handler getSuccessor() {
        return successor;
    }

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    /**
     * 子类需要去实现的方法
     */
    protected abstract void handleProcess();
    /**
     * 对外暴露的方法
     */
    public  void execute(){
        handleProcess();
        if(successor!=null){
            successor.execute();
        }
    }
}
