package pers.li.model.create.model_factory_abstract;

public class SendMailFactory implements Provider {
      
    @Override  
    public Sender produce(){  
        return new MailSender();  
    }  
} 