package pers.li.model.action.model_chain.hard.basic_chain;

/**
 * create by lishengbo on 2017-12-25 16:15
 * 实际工作者：
 */
public class ImpHandler extends  AbsHandler {
    @Override
    public void execute() {
        /**先判断是否还有工作的人*/
        /**若仍有在工作的人，则先去执行他的工作内容*/
        if(super.getHandler()!=null){
            System.out.println("other people working...");
            super.getHandler().execute();
        }else{
            System.out.println("mine worked");
        }
    }
}
