package pers.li.mq.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * create by lishengbo on 2018-04-25 14:12
 * 消费者
 */
public class AppConsumer {

    private static final String url="tcp://127.0.0.1:61616";
    private static final String queueName="queue-test";


    public static void main(String[] args) throws JMSException {

        //创建连接工厂
        ConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(url);
        //创建连接
        Connection connection = activeMQConnectionFactory.createConnection();
        //启动连接
        connection.start();
        //创建会话
        //第一个参数：是否使用事务 第二个：连接的应答模式设置为自动连接
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建一个目标
        Destination queue = session.createQueue(queueName);
        //创建消费者
        MessageConsumer consumer = session.createConsumer(queue);
        //创建一个监听器
        consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                //回调接收消息
                TextMessage textMessage= (TextMessage) message;
                try {
                    System.out.println("接受消息："+textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        //关闭连接 -- 监听不关闭连接
        //        connection.close();
    }
}
