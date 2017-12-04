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

<a href="">查看html日志</a>
<%-- <table cellspacing=1 cellpadding=0 width="100%" align=center border="0" class="table" id="tblTodoList">
    <tbody>
 
 
    <%
        StringBuilder sb = new StringBuilder();
       // String path = System.getProperty("user.dir").replace("bin", "logs");
       WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
		ServletContext servletContext = webApplicationContext.getServletContext();
		
		String path=servletContext.getRealPath("/") ;
        String fileName = path +"log_error\\errorlog"+".log";
        out.println(fileName);
        File file = new File(fileName);
        if (file.exists()) {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader read = new BufferedReader(isr);
            String str = "";
            while ((str = read.readLine()) != null) {
            		//sb.insert(0,"<tr class='tr'><td>" + fileName + "<td></tr>");
                    sb.insert(0,"<tr class='tr'><td>" + str + "<td></tr>");
   
            }
            out.print(sb.toString());
        } else {
            out.println("文件不存在！");
        }
 
    %>
 
    </tbody>
 
</table> --%>
</body>
</html>