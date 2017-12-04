$(function(){
	$("#main-nav").load($.getRootPath()+"/webpage/pages/left/left.html",function(){
		$("header").load($.getRootPath()+"/webpage/pages/top/header.html",function(){
			$("#tcglzk").addClass("in");
			$("#tcgl").addClass("active");
			$("#tcpzgl").addClass("active");			
		});
		//屏蔽界面輸入元素以及按钮
		$("input[name=functionName]").attr("readonly","readonly");
		$("input[name=functionDesc]").attr("readonly","readonly");
		$("input[name=functionDetail]").attr("readonly","readonly");
		$(".btn").attr("disabled","disabled");
		getfun();
	});
	$("#fangqi").click(function(){
		window.history.back(-1); 
		
	});
	
	$("#functionName").blur(function(){ 
		yanzheng(0);
	});
	
	$("#sub").click(function(){
		if(yanzheng(0)){
			var s=$("#fun").searchFormatSeentao();
			s["functionId"]=$.getUrlSearch("functionId");
			s["functionDesc"]=$("#functionDesc").text();
			s["functionDetail"]=$("#functionDetail").text();
			//console.log(s);
			var sj = $.jsonToString(s);
			$.ajaxSeentao($.getRootPath()+"/packagemgr/functionmgrsave.rest", sj,function(json){
				if(json.code===1){
					ischool.layout.success(json.data,$.getRootPath()+'/webpage/pages/userpackage/configFunction.html');
				}else{
					ischool.layout.error(json.errorMessage,2000);
				}
			});	
		}
		
	});
	
	
})
     
function getfun(){
	var id=$.getUrlSearch("functionId");
	if(id && ''!=id){
		
		$.ajaxSeentao($.getRootPath()+"/packagemgr/functionmgrview.rest ",'{"functionId":"'+id+'"}' ,function(json){
			if(json.code===1){
				ischool.layout.hide();
				var obj = JSON.parse(json.data);
//				
//				console.log(obj);
				var functionDesc = obj.functionDesc;
				if(!functionDesc){
					functionDesc='';
				}
				var functionDetail = obj.functionDetail;
				if(!functionDetail){
					functionDetail='';
				}
				$("#functionName").val(obj.functionName);
				$("#functionDesc").val(functionDesc);
				$("#functionDetail").val(functionDetail);
				//解除屏蔽界面輸入元素以及按钮
				$("input[name=functionName]").removeAttr("readonly");
				$("input[name=functionDesc]").removeAttr("readonly");
				$("input[name=functionDetail]").removeAttr("readonly");
				$(".btn").removeAttr("disabled");

			}else{
				ischool.layout.error(json.errorMessage,2000);
			}
		});
	}else{
		return;
	}
	
}
function yanzheng(d){
	var r=false;

	if(d===0 || d===1){
		var packageName=$("#functionName").val();
		if(packageName==''){
			$("#tcNameT").html("功能名不能为空！");
		}else if(packageName.length>15){
			$("#tcNameT").html("功能名不能大于15字！");
		}else{
			$("#tcNameT").html("");
			r=true;
		}
	}
	
    
	return r;
}