package pers.lish.girl.aoplearning.dynamicproxy_modle.a_chain_basic;

/**
 * 客户端自定义组装责任链
 */
public class Client {

    public static void main(String[] args) {
        //组装责任链
        Handler handler1 = new ConcreteHandler();
        Handler handler2 = new ConcreteHandler();
        handler1.setSuccessor(handler2);
        //提交请求
        handler1.handleRequest();
        //---------------------------------
        AbstractHandler abstractHandler=new ImplementHandler();
        AbstractHandler aabstractHandler=new ImplementHandler();
        AbstractHandler aaabstractHandler=new ImplementHandler();
        aabstractHandler.setAbstractHandler(aaabstractHandler);
        abstractHandler.setAbstractHandler(aabstractHandler);
        abstractHandler.execute();
    }

}