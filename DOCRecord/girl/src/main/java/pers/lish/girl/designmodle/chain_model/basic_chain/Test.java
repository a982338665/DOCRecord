package pers.lish.girl.designmodle.chain_model.basic_chain;

/**
 * create by lishengbo on 2017-12-25 16:22
 * 测试简单责任链模式：链式需要自定义指定
 */
public class Test {
    public static void main(String[] args) {
        AbsHandler absHandler1=new ImpHandler();

        AbsHandler absHandler2=new ImpHandler();

        AbsHandler absHandler3=new ImpHandler();

        absHandler1.setHandler(absHandler2);
        absHandler2.setHandler(absHandler3);

        absHandler1.execute();
    }
}
