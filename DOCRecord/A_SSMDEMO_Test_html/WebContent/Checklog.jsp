<%@page import="org.springframework.web.context.ContextLoader"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 >项目日志查询</h2>
<form action="hello2/logcheck" method="post">
				 <div class='row-fluid'>
                    <div class='span12 icon-over-input'>
                    <input class="span12" id="userName" name="userName" placeholder="用户名" type="text" value="" />
                        <i class='icon-user muted'></i>
                    </div>
                </div>
                <div class='row-fluid'>
                    <div class='span12 icon-over-input'>
    			    <input class="span12" id="userPass" name="userPass" placeholder="密码" type="password" value="" />
                        <i class='icon-lock muted'></i>
                    </div>
                </div>
                <input type="submit" value="提交" /> 
</form>
</body>
</html>