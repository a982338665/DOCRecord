package pers.lish.girl.aoplearning.dynamicproxy_modle.chain;

import java.util.List;

/**
 * create by lishengbo on 2017-12-25 09:17
 * 自己封装链式调用关系---递归思想
 */
public class Chain {

    /**封装链式关系**/
    private List<ChainHandler> chainHandlers;
    /**提供链式关系的构造方法*/
    public Chain(List<ChainHandler> chainHandlers) {
        this.chainHandlers = chainHandlers;
    }
    /**游标定义*****/
    private int index=0;

    public  void procced(){
        if(index>=chainHandlers.size()){
            return ;
        }
        chainHandlers.get(index++).execute(this);
    }
}
