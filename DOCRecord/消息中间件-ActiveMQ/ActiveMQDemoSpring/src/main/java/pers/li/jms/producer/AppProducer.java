package pers.li.jms.producer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * create by lishengbo on 2018-04-25 17:03
 * 启动类
 */
public class AppProducer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("producer.xml");
        ProducerService bean = context.getBean(ProducerService.class);
        for (int i = 0; i <100 ; i++) {
            //队列模式
            bean.sendMessage("test"+"-->"+i);
            //主题模式
//            bean.sendMessageTopic("test"+"-->"+i);
        }
        context.close();
    }
}
