package pers.li.model.create.model_builder;

import java.util.ArrayList;
import java.util.List;

/**
 *  建造者模式和工厂模式的区别：
 *
 *  1.工厂模式创建单个产品，建造者创建符合对象
 *
 */
public class Builder {

    private List<Sender> list = new ArrayList<Sender>();

    public void produceMailSender(int count) {
        for (int i = 0; i < count; i++) {
            list.add(new MailSender());
        }
    }

    public void produceSmsSender(int count) {
        for (int i = 0; i < count; i++) {
            list.add(new SmsSender());
        }
    }

    public static void main(String[] args) {
        Builder builder = new Builder();
        builder.produceMailSender(10);
    }
}
