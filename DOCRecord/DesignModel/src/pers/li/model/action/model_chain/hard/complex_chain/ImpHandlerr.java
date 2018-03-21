package pers.li.model.action.model_chain.hard.complex_chain;

/**
 * create by lishengbo on 2017-12-25 17:21
 */
public class ImpHandlerr extends ComplexHandler{
    @Override
    public void processed() {
        System.out.println("链式封装A-----");
    }
}

class ImpHandlerr2 extends ComplexHandler{
    @Override
    public void processed() {
        System.out.println("链式封装B-----");
    }
}

class ImpHandlerr3 extends ComplexHandler{
    @Override
    public void processed() {
        System.out.println("链式封装C-----");
    }
}