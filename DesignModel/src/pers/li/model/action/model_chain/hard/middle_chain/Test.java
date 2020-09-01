package pers.li.model.action.model_chain.hard.middle_chain;

/**
 * create by lishengbo on 2017-12-25 16:47
 */
public class Test {
    public static void main(String[] args) {
        B_Handler b_handler=new B_ImHandler();
        B_Handler c_handler=new C_ImHandler();
        B_Handler d_handler=new D_ImHandler();
        c_handler.setB_handler(d_handler);
        b_handler.setB_handler(c_handler);
        b_handler.execute();
    }

}
