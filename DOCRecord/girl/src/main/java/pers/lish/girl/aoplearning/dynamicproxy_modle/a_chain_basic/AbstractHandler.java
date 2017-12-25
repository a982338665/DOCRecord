package pers.lish.girl.aoplearning.dynamicproxy_modle.a_chain_basic;

/**
 * create by lishengbo on 2017-12-25 14:50
 */
public abstract  class AbstractHandler {

    private AbstractHandler abstractHandler;

    public abstract void execute();

    public AbstractHandler getAbstractHandler() {
        return abstractHandler;
    }

    public void setAbstractHandler(AbstractHandler abstractHandler) {
        this.abstractHandler = abstractHandler;
    }
}
