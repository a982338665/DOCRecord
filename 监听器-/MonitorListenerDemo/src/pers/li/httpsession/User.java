package pers.li.httpsession;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;

/**
 * create by lishengbo on 2018-05-02 10:29
 * 监听绑定到HttpSession域中的某个对象的状态事件监听器
 * 实体类的监听绑定
 * 如果要实现钝化或者活化，必须要进行序列化接口实现Serializable
 * 关闭时钝化，重启时活化
 */
public class User implements HttpSessionBindingListener ,HttpSessionActivationListener ,Serializable{

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 绑定
     * @param httpSessionBindingEvent
     */
    @Override
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("valueBound: name|"+httpSessionBindingEvent.getName());
    }

    /**
     * 解除绑定
     * @param httpSessionBindingEvent
     */
    @Override
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("valueUnbound: name|"+httpSessionBindingEvent.getName());

    }

    /**
     * 钝化方法
     * @param httpSessionEvent
     */
    @Override
    public void sessionWillPassivate(HttpSessionEvent httpSessionEvent) {
        System.out.println("sessionWillPassivate: name|"+httpSessionEvent.getSource());
    }

    /**
     * 活化方法
     * @param httpSessionEvent
     */
    @Override
    public void sessionDidActivate(HttpSessionEvent httpSessionEvent) {
        System.out.println("sessionDidActivate: name|"+httpSessionEvent.getSource());
    }
}
