package pers.li.model.action.model_chain.hard.basic_chain;

/**
 * create by lishengbo on 2017-12-25 16:12
 * 抽象的工作者：
 * 进行链式时，需要持有上一个工作者的对象
 */
public abstract class AbsHandler {

    private AbsHandler handler;

    public AbsHandler getHandler() {
        return handler;
    }

    public void setHandler(AbsHandler handler) {
        this.handler = handler;
    }
    /**子类必须要重写的实际执行内容:抽象方法没有方法体***/
    public abstract void execute();
}
