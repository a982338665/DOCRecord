package pers.lish.girl.aoplearning.dynamicproxy_modle.chain;

/**
 * create by lishengbo on 2017-12-25 09:28
 */
public abstract  class  ChainHandler {

    public void execute(Chain chain){
        handlerProcess();
        chain.procced();
    }

    protected  abstract void handlerProcess();
}
