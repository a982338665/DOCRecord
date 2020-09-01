<%@ page language="java" contentType="text/html; charset=UTF-8"  
        pageEncoding="UTF-8"%>  
 <%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
    <html>  
    <head>  
	<base href="<%=basePath%>"></base>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
    <title>Insert title here</title>  
    <script type='text/javascript' src='dwr/engine.js'></script>  
    <script type='text/javascript' src='dwr/interface/Demo.js'></script>  
    <script type='text/javascript' src='dwr/util.js'></script>  
      
      
    <script type="text/javascript">   
        function firstDwr(){   
        	/* alert(window.location.pathname);  */
            Demo.getHello("adsf",callBackHello) ;  
        }   
          
        function callBackHello(data){   
          alert(data);   
        }   
    </script>   
    </head>  
    <body>  
      <input  type="button"  name="button"  value="测试"  onclick="firstDwr()">  
    </body>  
    </html>  