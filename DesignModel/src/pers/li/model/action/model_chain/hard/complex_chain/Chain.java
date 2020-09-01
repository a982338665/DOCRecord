package pers.li.model.action.model_chain.hard.complex_chain;

import java.util.List;

/**
 * create by lishengbo on 2017-12-25 17:15
 * 封装链式处理
 */
public class Chain {

    public Chain(List<ComplexHandler> list) {
        this.list = list;
    }

    private List<ComplexHandler> list;

    /**设定游标***/
    private  int index=0;

    public List<ComplexHandler> getList() {
        return list;
    }

    public void setList(List<ComplexHandler> list) {
        this.list = list;
    }

    public  void  execute(){
        if(index>=list.size()){
            return;
        }else{
            list.get(index++).execute(this);
        }
    }


}
