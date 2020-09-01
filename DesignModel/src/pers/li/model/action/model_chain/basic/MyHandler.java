package pers.li.model.action.model_chain.basic;

public class MyHandler extends AbstractHandler implements Handler {
      
        private String name;  
      
        public MyHandler(String name) {  
            this.name = name;  
        }

    /**
     * 递归迭代
     */
    @Override
    public void operator() {
            System.out.println(name+"deal!");  
            if(getHandler()!=null){  
                getHandler().operator();  
            }  
        }  
    }  
