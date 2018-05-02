package pers.li.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * create by lishengbo on 2018-04-27 16:27
 */
public class DefineSHttpSessionListener implements HttpSessionListener{
    /**
     * session创建：
     * 用户打开浏览器，第一次访问是创建
     * @param httpSessionEvent
     */
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

        System.out.println("session创建————————————");
    }

    /**
     * 退出登录：销毁
     * 关闭浏览器：一段时间后销毁（可设置大约值）
     * @param httpSessionEvent
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("session销毁————————————");

    }
}
