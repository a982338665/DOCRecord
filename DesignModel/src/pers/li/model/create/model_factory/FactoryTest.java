package pers.li.model.create.model_factory;

public class FactoryTest {
  
    public static void main(String[] args) {

        /**
         * 简单工厂模式测试———————————————————————————————————————————————————————
         */
        SendFactory factory = new SendFactory();
        Sender sender = factory.produce("sms");
        sender.Send();
        /**
         * 多个工厂方法模式测试————————————————————————————————————————————————————
         */
        Sender sender2 = factory.produceMail();
        sender.Send();
        /**
         * 静态工厂模式测试———————————————————————————————————————————————————————
         */
        Sender sender3 = SendFactory.produceMailstatic();
        sender.Send();

        /**
         * 由于静态工厂模式不需要实例化工厂类，所以最常用=======
         */



    }  
}