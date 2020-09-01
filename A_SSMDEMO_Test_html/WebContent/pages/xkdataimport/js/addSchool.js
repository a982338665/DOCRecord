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
});