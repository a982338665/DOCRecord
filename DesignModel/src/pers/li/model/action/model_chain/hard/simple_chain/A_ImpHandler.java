package pers.li.model.action.model_chain.hard.simple_chain;

/**
 * create by lishengbo on 2017-12-25 16:34
 */
public class A_ImpHandler extends A_AbsHandler {

    public  void execute(){
        /**先判断是否还有工作的人*/
        /**若仍有在工作的人，则先去执行他的工作内容*/
        if(super.getA_absHandler()!=null){
            System.out.println("other people working...");
            super.getA_absHandler().execute();
        }else{
            System.out.println("mine worked");
        }
    }

}
