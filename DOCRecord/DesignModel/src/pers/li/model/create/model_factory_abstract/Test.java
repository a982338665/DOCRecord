package pers.li.model.create.model_factory_abstract;

/**
 * 抽象工厂类--
 *
 * 需要增加新的工厂时，直接添加新的工厂类即可-面向接口编程应用（依赖倒置原则，开闭原则）
 *
 */
public class Test {
      
        public static void main(String[] args) {  
            Provider provider = new SendMailFactory();  
            Sender sender = provider.produce();  
            sender.Send();  
        }  
    }  
