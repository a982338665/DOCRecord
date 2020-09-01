package pers.li.jms.producer;

/**
 * create by lishengbo on 2018-04-25 14:59
 */
public interface ProducerService {

    void sendMessage(String message);
    void sendMessageTopic(String message);
}
