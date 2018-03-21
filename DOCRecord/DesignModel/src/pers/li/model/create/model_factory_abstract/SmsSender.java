package pers.li.model.create.model_factory_abstract;

public class SmsSender implements Sender {
  
    @Override  
    public void Send() {  
        System.out.println("this is sms sender!");  
    }  
} 