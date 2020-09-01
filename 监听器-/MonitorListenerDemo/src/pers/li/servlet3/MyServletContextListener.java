package pers.li.servlet3;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * create by lishengbo on 2018-05-02 11:07
 */
@WebListener("thsi is my servlet 3.0 Listener")
public class MyServletContextListener implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("使用注解方式注册监听器---");

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("使用注解方式销毁监听器---");

    }
}
