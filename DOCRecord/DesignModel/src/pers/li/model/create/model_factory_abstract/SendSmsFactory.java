package pers.li.model.create.model_factory_abstract;

public class SendSmsFactory implements Provider{
      
        @Override  
        public Sender produce() {  
            return new SmsSender();  
        }  
    }  
