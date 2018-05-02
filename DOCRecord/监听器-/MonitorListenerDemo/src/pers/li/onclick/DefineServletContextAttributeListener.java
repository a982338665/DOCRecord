package pers.li.onclick;

import javax.servlet.*;

/**
 * create by lishengbo on 2018-04-27 15:09
 * 1.8好像没有此类
 * 一个服务中，可以注册多个监听器
 * 监听器的启动顺序：按web.xml中的注册顺序加载
 * 加载优先级：监听器>过滤器>Servlet(拦截器)
 *_____________________________________
 * 监听对象：监听各个域对象的创建，销毁和其属性的变化
 jsp的九大内置对象:用户环境对象/用户会话对象、监听请求消息对象
 -ServletContext -application
 -上下文对象，有容器创建和初始化，范围整个web应用，有且只有一个，在关闭服务时销毁
 -HttpSession	-session
 -会话，保存上下文的机制，针对每一个会话的，放在服务端，通过sessionId区分，浏览器或服务器结束时销毁
 -ServletRequest	-request
 *
 *
 */
public class DefineServletContextAttributeListener implements ServletContextAttributeListener{

    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("servletContext_attributeAdded———————"+servletContextAttributeEvent.getName());

    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("servletContext_attributeRemoved—————"+servletContextAttributeEvent.getName());

    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("servletContext_attributeReplaced—————"+servletContextAttributeEvent.getName());

    }
}
