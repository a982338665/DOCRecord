<%--
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
    request.removeAttribute("requestName");
    //request中访问路径的参数
//    request.getParameter("");
    request.getSession().removeAttribute("sessionName");
    request.getSession().removeAttribute("currentUser");
    request.getSession().getServletContext().removeAttribute("contextName");
    %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   销毁页面
   <button onclick="location.href='<%=request.getContextPath()%>/init.jsp '">init</button>
   <button onclick="location.href='<%=request.getContextPath()%>/destory.jsp '">destory</button>
</body>
</html>
