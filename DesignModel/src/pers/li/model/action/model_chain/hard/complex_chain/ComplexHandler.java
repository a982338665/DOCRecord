package pers.li.model.action.model_chain.hard.complex_chain;

/**
 * create by lishengbo on 2017-12-25 17:14
 * 抽象工作类
 */
public abstract class ComplexHandler {
    public abstract  void  processed();
    public void  execute(Chain chain){
        processed();
        chain.execute();
    }

}
