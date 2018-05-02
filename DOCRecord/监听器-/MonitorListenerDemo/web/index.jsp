<%@ page import="pers.li.test.UserDetail" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: cjh
  Date: 2018-04-27
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  用户当前在线人数：${onlineUserNum} <br/>
  <%
    ArrayList<UserDetail> userList=(ArrayList<UserDetail>)request.getServletContext().getAttribute("userList");
    if(userList!=null){
      for (int i = 0; i <userList.size() ; i++) {
        UserDetail userDetail = userList.get(i);
        System.out.println(userDetail.getIpString());
  %>
  IP：<%=userDetail.getIpString()%>|
  firstTime：<%=userDetail.getFirstTimeString()%>|
  SessionId：<%=userDetail.getSessionIdString()%><br/>
  <%
      }
    }
  %>
  <%=request.getSession().getAttribute("currentUser")%>
  <button onclick="location.href='<%=request.getContextPath()%>/init.jsp '">init</button>
  <button onclick="location.href='<%=request.getContextPath()%>/destory.jsp '">destory</button>
  </body>
</html>
