package pers.lish.girl.designmodle.chain_model.middle_chain;

/**
 * create by lishengbo on 2017-12-25 16:41
 * 抽象工作类
 */
public abstract class B_Handler {

    private B_Handler b_handler;

    public B_Handler getB_handler() {
        return b_handler;
    }

    public void setB_handler(B_Handler b_handler) {
        this.b_handler = b_handler;
    }

    public abstract  void  processed();

    public void  execute(){
        processed();
        if(b_handler!=null){
            b_handler.execute();
        }

    }
}
