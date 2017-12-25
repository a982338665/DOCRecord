package pers.lish.girl.aoplearning.dynamicproxy_modle.a_chain_basic;

/**
 * create by lishengbo on 2017-12-25 14:53
 */
public class ImplementHandler extends AbstractHandler {
    @Override
    public void execute() {
        AbstractHandler abstractHandler = super.getAbstractHandler();
        if(abstractHandler!=null){
            System.out.println("--------"+abstractHandler);
            abstractHandler.execute();
        }else{
            System.out.println("+++++++++++++++++");

        }
    }
}
