package pers.li.test;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;

/**
 * create by lishengbo on 2018-05-02 11:12
 * 统计在线人数,按ip获取
 */
@WebListener
public class MyHttpSessionlistener implements HttpSessionListener {

    private  int userNum=0;

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        userNum++;
        httpSessionEvent.getSession().getServletContext().setAttribute("onlineUserNum",userNum);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        userNum--;
        httpSessionEvent.getSession().getServletContext().setAttribute("onlineUserNum",userNum);
        //在线用户集合
        ArrayList<UserDetail> userList=(ArrayList<UserDetail>)
                httpSessionEvent.getSession().getServletContext().getAttribute("userList");
        System.out.println(userList);
        if(httpSessionEvent.getSession().getId()!=null){

            userList.remove(SessionUtil.getUserSessionId(userList,httpSessionEvent.getSession().getId()));
        }
    }
}
