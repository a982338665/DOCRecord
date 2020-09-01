

$(function(){
	$("#main-nav").load($.getRootPath()+"/webpage/pages/left/left.html",function(){
		$("header").load($.getRootPath()+"/webpage/pages/top/header.html",function(){
			$("#yhxxglzk").addClass("in");
			$("#yhxxgl").addClass("active");
			$("#drxxjs").addClass("active");			
		});

	});
	
	
	$.ajaxSeentao($.getRootPath()+"/area/getAllCity.rest",function(json){
		
		if(json.code===1){
			ischool.layout.hide();
			var obj = JSON.parse(json.data);
	
			var strn='<option value="0">请选择</option>';
			for (var int = 0; int < obj.length; int++) {
				
				strn +='<option value="'+obj[int].cCode+'">'+obj[int].cName+'</option>';
			}
			
			$("#ds").html(strn);
		}else{
			ischool.layout.error(json.errorMessage,2000);
		}

	});
	
	$("#ds").change(function(){
		var dscode=$("#ds").val();
		$.ajaxSeentao($.getRootPath()+"/area/getAllqx.rest",dscode,function(json){
			
			if(json.code===1){
				ischool.layout.hide();
				var obj = JSON.parse(json.data);
		
				var strn='<option value="0">请选择</option>';
				for (var int = 0; int < obj.length; int++) {
					
					strn +='<option value="'+obj[int].cCode+'">'+obj[int].cName+'</option>';
				}
				
				$("#qx").html(strn);
			}else{
				ischool.layout.error(json.errorMessage,2000);
			}

		});
	});
	$("#qx").change(function(){
		var dscode=$("#qx").val();
		$.ajaxSeentao($.getRootPath()+"/school/getSchoolByArea.rest",dscode,function(json){
			
			if(json.code===1){
				ischool.layout.hide();
				var obj = JSON.parse(json.data);
				
				var strn='<option value="0">请选择</option>';
				for (var int = 0; int < obj.length; int++) {
					
					strn +='<option value="'+obj[int].cSid+'">'+obj[int].cName+'</option>';
				}
				
				$("#school").html(strn);
			}else{
				ischool.layout.error(json.errorMessage,2000);
			}
			
		});
	});
	
	$("#sub").click(function(){
		var formData = new FormData();
		var name = $("#teaFile").val();
		
		if(null===name || name==='' ){
//			alert("请选择文件！");
			ischool.layout.alert("警告","请选择文件！");
			return;
		}
		formData.append("file",$("#teaFile")[0].files[0]);
		formData.append("name",name);
		formData.append("type","1");
		formData.append("schoolId",$("#school").val());
		//用于区别地区，是否为山东导入
		formData.append("isuse","true");
		$.ajax({ 
		url : $.getRootPath()+"/xkUser/upTeacher.rest", 
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

		ischool.layout.success("上传成功");
		}else{
		console.log("失败");
		console.log(responseStr.data);
//		ischool.layout.error(responseStr.errorMessage,2000);
		ischool.layout.error(responseStr.data);
		}
		}, 
		error : function(responseStr) { 
		console.log("error");
		} 
		});

		
	});
	
	$("#sub_out").click(function(){
		var formData = new FormData();
//		var name = $("#teaFile").val();
//		var schoolId=$("#school").val();
//		ischool.layout.alert(schoolId);
//		if(null===schoolId || schoolId==='' ){
//			ischool.layout.alert("警告","请选择学校！");
//			return;
//		}
//		ischool.layout.loadding("下载中...");
//		$.ajaxSeentao($.getRootPath()+"/school/getStudentBySchoolId.rest",schoolId,function(json){
//			if(json.code===1){
//				ischool.layout.alert("警告","临时文件创建成功！"+json.data);
//				ischool.layout.hide();
				downloadFile('../../../mould/BatchTeacher_shandong.xlsx',"教师信息导入模板.xlsx");
//			}else{
				ischool.layout.alert("警告","导出成功！");
//				ischool.layout.error(json.errorMessage,2000);
//			}

//		});

	});
	function downloadFile(url,fileName){
		var a = document.createElement('a');
		a.href= url;
		a.download = fileName;
		a.click();
		a=null;
	}
});
