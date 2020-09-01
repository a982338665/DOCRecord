package pers.li.model.create.model_factory_abstract;

public class MailSender implements Sender {
        @Override  
        public void Send() {  
            System.out.println("this is mailsender!");  
        }  
    }  
