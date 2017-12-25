package pers.lish.girl.aoplearning.dynamicproxy_modle.chain;

import java.util.Arrays;
import java.util.List;

/**
 * 客户端
 * create by lishengbo on 2017-12-25 09:39
 */
public class ChainClient {

static class HandlerA extends ChainHandler {
    @Override
    protected void handlerProcess() {
        System.out.println("A");
    }
}
static class HandlerB extends ChainHandler {
    @Override
    protected void handlerProcess() {
        System.out.println("B");
    }
}
static class HandlerC extends ChainHandler {
    @Override
    protected void handlerProcess() {
        System.out.println("C");
    }
}

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        List<ChainHandler> chainHandlers= Arrays.asList(
                new HandlerA(),
                new HandlerB(),
                new HandlerC()
        );
        Chain chain=new Chain(chainHandlers);
        chain.procced();
    }
}
