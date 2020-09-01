package pers.li.model.action.model_vister;

public interface Subject {
        public void accept(Visitor visitor);  
        public String getSubject();  
    }  
