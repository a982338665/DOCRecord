package pers.lish.girl.designmodle.chain_model.middle_chain;

/**
 * create by lishengbo on 2017-12-25 16:45
 */
public class B_ImHandler extends B_Handler {
    @Override
    public void processed() {
        System.out.println("B---");
    }
}
 class C_ImHandler extends B_Handler {
    @Override
    public void processed() {
        System.out.println("C---");
    }
}
 class D_ImHandler extends B_Handler {
    @Override
    public void processed() {
        System.out.println("D---");
    }
}
