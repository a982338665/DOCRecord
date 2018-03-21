package pers.li.model.action.model_vister;

public class MySubject implements Subject {
      
        @Override  
        public void accept(Visitor visitor) {  
            visitor.visit(this);  
        }  
      
        @Override  
        public String getSubject() {  
            return "love";  
        }  
    }  
