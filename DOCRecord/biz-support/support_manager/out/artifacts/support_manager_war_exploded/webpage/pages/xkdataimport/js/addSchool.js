$(function(){
	$("#main-nav").load($.getRootPath()+"/webpage/pages/left/left.html",function(){
		$("header").load($.getRootPath()+"/webpage/pages/top/header.html",function(){
			$("#yhxxglzk").addClass("in");
			$("#yhxxgl").addClass("active");
			$("#cjxkxx").addClass("active");			
		});

	});
	
	
	$.ajaxSeentao($.getRootPath()+"/area/getAllCity.rest",function(json){
		
		if(json.code===1){
			ischool.layout.hide();
			var obj = JSON.parse(json.data);
	
			
			for (var int = 0; int < obj.length; int++) {
				var strn;
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
		
				
				for (var int = 0; int < obj.length; int++) {
					var strn;
					strn +='<option value="'+obj[int].cCode+'">'+obj[int].cName+'</option>';
				}
				
				$("#qx").html(strn);
			}else{
				ischool.layout.error(json.errorMessage,2000);
			}

		});
	});
	$("#sub").click(function(){
		var schoolName=$("#schoolName").val();
		if(schoolName && schoolName!=''){
			var s=$("#fun").searchFormatSeentao();
			var sj = $.jsonToString(s);
			$.ajaxSeentao($.getRootPath()+"/school/addSchool.rest",sj,function(json){
				
				if(json.code===1){

					ischool.layout.success(json.data,$.getRootPath()+'/webpage/pages/xkdataimport/addSchool.html');
					
				}else{
					ischool.layout.error(json.errorMessage,2000);
				}

			});
		}
		
	});
	
	$("#sub_in").click(function(){
		var formData = new FormData();
		var name = $("#teaFile").val();
		
		if(null===name || name==='' ){
//			alert("请选择文件！");
			ischool.layout.alert("警告","请选择文件！");
			return;
		}
		formData.append("file",$("#teaFile")[0].files[0]);
//		formData.append("name",name);
//		formData.append("type","1");
//		formData.append("schoolId",$("#school").val());
		$.ajax({ 
		url : $.getRootPath()+"/school/addSchoolBatch.rest", 
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
		if(responseStr.errorMessage!=null||responseStr.errorMessage!=''){
			console.log("成功"+responseStr);
			ischool.layout.success("上传成功")
			alert("导入失败学校如下:"+responseStr.errorMessage);
		}
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
	function downloadFile(url,fileName){
		var a = document.createElement('a');
		a.href= url;
		a.download = fileName;
		a.click();
		a=null;
	}
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
				downloadFile('../../../mould/BatchSchool_shandong.xlsx',"学校信息导入模板.xlsx");
//			}else{
				ischool.layout.alert("警告","导出成功！");
//				ischool.layout.error(json.errorMessage,2000);
//			}

//		});

	});
});