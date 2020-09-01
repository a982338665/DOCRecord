package pers.li.model.action.model_chain.hard.simple_chain;

/**
 * create by lishengbo on 2017-12-25 16:22
 * 测试简单责任链模式：链式需要自定义指定
 */
public class Test {
    public static void main(String[] args) {
        A_AbsHandler absHandler1=new A_ImpHandler();

        A_AbsHandler absHandler2=new A_ImpHandler();

        A_AbsHandler absHandler3=new A_ImpHandler();

        absHandler1.setA_absHandler(absHandler2);
        absHandler2.setA_absHandler(absHandler3);

        absHandler1.execute();
    }
}
