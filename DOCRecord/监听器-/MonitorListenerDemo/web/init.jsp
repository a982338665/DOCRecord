<%@ page import="pers.li.httpsession.User" %><%--
  Created by IntelliJ IDEA.
  User: cjh
  Date: 2018-05-02
  Time: 09:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServletPath();
    //request的一种属性
    request.setAttribute("requestName","requestValue");
    //request中访问路径索敌啊的参数
//    request.getParameter("");
    request.getSession().setAttribute("sessionName","sessionValue");
    //测试对象绑定监听--httpsession包下
    request.getSession().setAttribute("currentUser",new User());
    request.getSession().getServletContext().setAttribute("contextName","contextValue");
    %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    初始化页面
    <button onclick="location.href='<%=request.getContextPath()%>/init.jsp '">init</button>
    <button onclick="location.href='<%=request.getContextPath()%>/destory.jsp '">destory</button>
</body>
</html>
