$(function(){
	$("#main-nav").load($.getRootPath()+"/webpage/pages/left/left.html",function(){
		$("header").load($.getRootPath()+"/webpage/pages/top/header.html",function(){
			$("#yhglzk").addClass("in");
			$("#yhglxt").addClass("active");
			$("#zdbdr").addClass("active");
		});

	});
	
	
	$("#upFile1").click(function(){
		
		var formData = new FormData();
		var name = $("#fileName1").val();
		
		if(null===name || name==='' ){
//			alert("请选择文件！");
			ischool.layout.alert("警告","请选择文件！");
			return;
		}
		formData.append("file",$("#files1")[0].files[0]);
		formData.append("name",name);
		formData.append("type","1");
		$.ajax({ 
		url : $.getRootPath()+"/dic/updic.rest", 
		type : 'POST', 
		data : formData, 
		// 告诉jQuery不要去处理发送的数据
		processData : false, 
		// 告诉jQuery不要去设置Content-Type请求头
		contentType : false,
		beforeSend:function(){
		console.log("正在进行，请稍候");
		ischool.layout.loadding("上传中...");
		},
		success : function(responseStr) { 
		if(responseStr.code===1){
		console.log("成功"+responseStr);
//		alert("上传成功");
		ischool.layout.success("上传成功");
		}else{
		console.log("失败");
//		alert(responseStr.errorMessage);
		ischool.layout.error(responseStr.errorMessage,2000);
		}
		}, 
		error : function(responseStr) { 
		console.log("error");
		} 
		});
		
	});
	
	$("#upFile2").click(function(){
		
		var formData = new FormData();
		var name = $("#fileName2").val();
		
		if(null===name || name==='' ){
//			alert("请选择文件！");
			ischool.layout.alert("警告","请选择文件！");
			return;
		}
		formData.append("file",$("#files2")[0].files[0]);
		formData.append("name",name);
		formData.append("type","2");
		$.ajax({ 
		url : $.getRootPath()+"/dic/updic.rest", 
		type : 'POST', 
		data : formData, 
		// 告诉jQuery不要去处理发送的数据
		processData : false, 
		// 告诉jQuery不要去设置Content-Type请求头
		contentType : false,
		beforeSend:function(){
		console.log("正在进行，请稍候");
		ischool.layout.loadding("上传中...");
		},
		success : function(responseStr) { 
		if(responseStr.code===1){
		console.log("成功"+responseStr);
//		alert("上传成功");
		ischool.layout.success("上传成功");
		}else{
		console.log("失败");
//		alert(responseStr.errorMessage);
		ischool.layout.error(responseStr.errorMessage,2000);
		}
		}, 
		error : function(responseStr) { 
		console.log("error");
		} 
		});
		
	});
	
	$("#dowFile1").click(function(){
		downloadFile('../../../mould/SA.xlsx',"系统字典模板.xlsx");
	});
	$("#dowFile2").click(function(){
		downloadFile('../../../mould/area_cmcc.xlsx',"地区字典模板.xlsx");
	});
	
	function downloadFile(url,fileName){
		var a = document.createElement('a');
		a.href= url;
		a.download = fileName;
		a.click();
		a=null;
	}
	
})