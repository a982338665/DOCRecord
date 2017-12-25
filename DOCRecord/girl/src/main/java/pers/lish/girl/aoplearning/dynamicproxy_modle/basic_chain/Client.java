package pers.lish.girl.aoplearning.dynamicproxy_modle.basic_chain;

/**
 * create by lishengbo on 2017-12-25 09:01
 * 客户端：
 * 链式调用时每次都需要自己去设置链式关系；
 */
public class Client {
    static class HandlerA extends Handler {

            public HandlerA(){
                System.out.println("handleA--");
            }

            @Override
            protected void handleProcess() {
                System.out.println("A");
            }
        }
        static class HandlerB extends Handler {
            @Override
            protected void handleProcess() {
                System.out.println("B");
            }
        }
        static class HandlerC extends Handler {
            @Override
            protected void handleProcess() {
                System.out.println("C");
            }
        }

        /**
         *
         * @param args
         */
    public static void main(String[] args) {
        HandlerA a=new HandlerA();
        HandlerB b=new HandlerB();
        HandlerC c=new HandlerC();
        a.setSuccessor(b);
        b.setSuccessor(c);
        a.execute();

    }
}
