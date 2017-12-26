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
<!-- 使用绝对路径来访问项目--------------------------------- -->
<base href="<%=basePath%>"></base>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 以下三个路径为生成的虚拟路径--------------------------- -->
<script type='text/javascript' src='dwr/engine.js'></script>
<script type='text/javascript' src='dwr/interface/Demo.js'></script>
<script type='text/javascript' src='dwr/interface/DwrPush.js'></script>
<script type='text/javascript' src='dwr/util.js'></script>
<script type='text/javascript' src='webapp/js/jquery.min.3.1.1.js'></script>
<script type="text/javascript">
	$(function() {
		//这句话千万不能少 ，表示允许使用推送技术    
		dwr.engine.setActiveReverseAjax(true);
	});
	function firstDwr() {
		/*用来测试jquery是否引入成功**/
		//alert($);
		/* alert(window.location.pathname);  */
		Demo.getHello($("#msg").val(), callBackHello);
	}

	function callBackHello(data) {
		//alert(data);
		$("#ul").html($("#ul").html() + "</br>" + data);
	}
	//------------------------------

	$(function() {
		//这句话千万不能少 ，表示允许使用推送技术    
		dwr.engine.setActiveReverseAjax(true);
		$("#sign").click(function() {
			DwrPush.send($("#msg").val());
		});
	});

	function callback(msg) {
		$("#ul").html($("#ul").html() + "</br>" + msg);
	}
</script>
<!-- <script language="javascript">
	if (typeof jQuery == 'undefined') {
		window.alert("没有jquery");
	}
</script> -->
</head>
<body>
	<ul id="ul" style="color: red; font-size: 60px"></ul>


	<input type="text" name="msg" size="30" id="msg"
		style="height: 60px; font-size: 35px" />
	<input type="button" id="sign" value="发布信息" />
	<input type="button" name="button" value="测试" onclick="firstDwr()">
</body>
</html>
