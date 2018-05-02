package pers.li.onclick;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * create by lishengbo on 2018-04-27 16:27
 * 在session之前
 */
public class DefineHttpSessionAttributeListener implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("HttpSession_attributeAdded———————"+httpSessionBindingEvent.getName());

    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("HttpSession_attributeRemoved———————"+httpSessionBindingEvent.getName());

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("HttpSession_attributeReplaced———————"+httpSessionBindingEvent.getName());

    }


}
