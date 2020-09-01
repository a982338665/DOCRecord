package pers.li.jms.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.annotation.Resource;
import javax.jms.*;

/**
 * create by lishengbo on 2018-04-25 14:59
 */
public class ProducerServiceImpl implements ProducerService{


    @Autowired
    JmsTemplate jmsTemplate;

//  资源方式注解：能获取指定的name
    @Resource(name="queueDestination")
    Destination destination;
//  资源方式注解：能获取指定的name
    @Resource(name="topicDestination")
    Destination destination2;


    /**
     * 队列模式
     * @param message
     */
    public void sendMessage(final String message) {
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage(message);
                System.out.println("发送消息："+textMessage.getText());
                return textMessage;
            }
        });
    }

    /**
     * 主题模式
     * @param message
     */
    public void sendMessageTopic(final String message) {
        jmsTemplate.send(destination2, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage(message);
                System.out.println("发送消息："+textMessage.getText());
                return textMessage;
            }
        });
    }
}
