package pers.li.mq.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * create by lishengbo on 2018-04-25 13:46
 * 消息提供者：
 * 队列模式：
 *  多个消费者共享同一批数据，且数据仅供一个消费者使用
 *
 *
 */
public class AooProducer {

    //单点故障url
    private static final String url="tcp://127.0.0.1:61616";
    //单点故障url时，进行故障转移的url-- 17故障时，自动连接18，参数为随机从列表中选择一台，此处只配置生产者，master.slave
    private static final String url2="failover:(tcp://127.0.0.1:61617,tcp://127.0.0.1:61618)?randomize=true";
    private static final String queueName="queue-test";


    public static void main(String[] args) throws JMSException {

        //创建连接工厂
        ConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(url2);
//        ConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(url);
        //创建连接
        Connection connection = activeMQConnectionFactory.createConnection();
        //启动连接
        connection.start();
        //创建会话
        //第一个参数：是否使用事务 第二个：连接的应答模式设置为自动连接
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建一个目标
        Destination queue = session.createQueue(queueName);
        //创建生产者
        MessageProducer producer = session.createProducer(queue);
        //循坏向目标地址发送消息
        for (int i = 0; i <100 ; i++) {
            //创建消息
            TextMessage textMessage = session.createTextMessage("test-->"+i);
            //发布消息
            producer.send(textMessage);
            //打印日志
            System.out.println("发送消息："+textMessage.getText());
        }
        //关闭连接
        connection.close();
    }
}
