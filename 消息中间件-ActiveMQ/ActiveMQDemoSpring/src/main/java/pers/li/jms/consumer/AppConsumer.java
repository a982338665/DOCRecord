package pers.li.jms.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * create by lishengbo on 2018-04-25 17:39
 */
public class AppConsumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
    }
}
