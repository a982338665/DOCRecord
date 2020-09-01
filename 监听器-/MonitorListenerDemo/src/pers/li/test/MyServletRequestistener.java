package pers.li.test;

import pers.li.httpsession.User;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * create by lishengbo on 2018-05-02 11:12
 * 统计在线人数,按ip获取
 */
@WebListener
public class MyServletRequestistener implements ServletRequestListener {
    //在线用户集合
    private ArrayList<UserDetail> userList;


    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {

        userList=( ArrayList<UserDetail> )servletRequestEvent.getServletContext().getAttribute("userList");

        if(userList==null){
            userList=new ArrayList<>();
        }
        HttpServletRequest request = (HttpServletRequest)servletRequestEvent.getServletRequest();
        String SessionId = request.getSession().getId();
        if(SessionUtil.getUserSessionId(userList,SessionId)==null){
            UserDetail userDetail = new UserDetail();
            userDetail.setSessionIdString(SessionId);
            userDetail.setFirstTimeString(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            userDetail.setIpString(request.getRemoteAddr());
            userList.add(userDetail);

        }
        System.out.println(userList);
        servletRequestEvent.getServletContext().setAttribute("userList",userList);
    }


}
