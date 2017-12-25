package pers.lish.girl.designmodle.chain_model.complex_chain;

import java.util.Arrays;
import java.util.List;

/**
 * create by lishengbo on 2017-12-25 17:24
 */
public class Test {
    public static void main(String[] args) {
        List<ComplexHandler> chains= Arrays.asList(
            new ImpHandlerr(),new ImpHandlerr3(),new ImpHandlerr2()
        );
        Chain chain=new Chain(chains);
        chain.execute();
    }

}
