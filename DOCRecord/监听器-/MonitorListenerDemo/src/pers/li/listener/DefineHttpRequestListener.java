package pers.li.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import java.util.Enumeration;

/**
 * create by lishengbo on 2018-04-27 16:27
 * 在session之前
 */
public class DefineHttpRequestListener implements ServletRequestListener{

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("request销毁——————————————————————————————");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        String name = servletRequestEvent.getServletRequest().getParameter("name");
        servletRequestEvent.getServletRequest().getParameterNames();
        System.out.println("request初始化——————————————————————————————"+name);

    }
}
