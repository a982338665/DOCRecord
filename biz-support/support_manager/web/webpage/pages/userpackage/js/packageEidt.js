$(function(){
	$("#main-nav").load($.getRootPath()+"/webpage/pages/left/left.html",function(){
		$("header").load($.getRootPath()+"/webpage/pages/top/header.html",function(){
			$("#tcglzk").addClass("in");
			$("#tcgl").addClass("active");
			$("#tcpzgl").addClass("active");			
		});
		//屏蔽界面輸入元素以及按钮
		enableInputsAndBtn(false);
		
		$.ajaxSeentao($.getRootPath()+"/packagemgr/functionmgrlist.rest",function(json){
			ischool.layout.hide();
			var pc='';
			var mob='';
			for(var i=0;i<json.length;i++){
				if(json[i].platform===1){
					mob+='<label class="radio span6"><input value="'+
					json[i].functionId+'" name="functionStr" type="checkbox" AUTOCOMPLETE="off">'+
					json[i].functionName+'</label>'
				}else if(json[i].platform===2){
					pc+='<label class="radio span6"><input value="'+
					json[i].functionId+'" name="functionStr" type="checkbox" AUTOCOMPLETE="off">'+
					json[i].functionName+'</label>'
				}
			}
			$("#pc").html(pc);
			$("#mob").html(mob);
			userTc();
	},{mask:false});
	});
	$("#fangqi").click(function(){
		window.history.back(-1); 
	});
	$("#packageType").change(function(){
		var packageType=$("#packageType").val();
		if(packageType==="2"){
			$("#packageP").hide();
			
		}else{
			$("#packageP").show();
		}

	});
	
	
	$("#sub").click(function(){
		var yanzheng1=false;
		var packageType=$("#packageType").val();
		if(packageType==="1"){
			 yanzheng1=yanzheng(0);
		}else{
			 yanzheng1=yanzheng(1);
			 $("#packagePrice").val("0");
			 
		}
		
		if(yanzheng1){
			var s=$("#taocanform").searchFormatSeentao();
			var id=$.getUrlSearch("packageId");
			if(id && ''!=id){
				s["packageId"]=id;
			}
			var sj=$.jsonToString(s);
			$.ajaxSeentao($.getRootPath()+"/packagemgr/packagemgrsave.rest",sj,function(json){
				ischool.layout.hide();
				if(json.code===1){
					ischool.layout.success(json.data,$.getRootPath()+'/webpage/pages/userpackage/packageConfig.html');
				}else{
					ischool.layout.error(json.errorMessage,2000);
				}
		});
		}
	});
	
	$("#packageName").blur(function(){ 
		yanzheng(1);
	});
	$("#packagePrice").blur(function(){ 
		yanzheng(2);
	});
	
})

function userTc(){
	var id=$.getUrlSearch("packageId");
	if(id && ''!=id){
		$("title").text("修改套餐");
		$("#title1").text("修改套餐");
		$("#sub").text("保存");
		$("#packageTypeF").remove();
		$("#hasTermF").remove();
		
		$.ajaxSeentao($.getRootPath()+"/packagemgr/packagemgrfunctionlist.rest ",'{"packageId":"'+id+'"}' ,function(json){
			if(json.code===1){
				ischool.layout.hide();
				var obj = JSON.parse(json.data);
				console.log(obj);
				$("#packageType").val(obj.packageType);
				$("#packageName").val(obj.packageName);
				$("#packagePrice").val(obj.packagePrice);
				$("#packageDesc").val(obj.packageDesc);
				$("#validation_select").val(obj.hasTerm);
				if(obj.packageType===2){
					$("#packageP").hide();
				}
				
				var fun = obj.moFunctionBeans;
				for (var i = 0; i < fun.length; i++) {
					var inMenu=$("input[name='functionStr'][value='"+fun[i].functionId+"']");
					inMenu.prop("checked", true);
				}
				//解除屏蔽界面輸入元素以及按钮
				$("input[name=packageName]").removeAttr("readonly");
				$("input[name=packagePrice]").removeAttr("readonly");
				$("input[name=packageDesc]").removeAttr("readonly");
				$("input[name=functionStr]").removeAttr("readonly");
				$(".btn").removeAttr("disabled");
			}else{
				ischool.layout.error(json.errorMessage,2000);
			}
		},{mask:false});
	}else{
		//解除屏蔽界面輸入元素以及按钮
		enableInputsAndBtn(true);
		return;
	}
}
function yanzheng(d){
	var r=false;
	var r1=false;
	var r2=false;
	if(d===0 || d===1){
		var packageName=$("#packageName").val();
		if(packageName==''){
			$("#tcNameT").html("套餐名不能为空！");
		}else if(packageName.length>15){
			$("#tcNameT").html("套餐名不能大于15字！");
		}else{
			$("#tcNameT").html("");
			r1=true;
		}
	}
	if(d===0 || d===2){
		var packagePriceT=$("#packagePrice").val();
		var r1 = /^\+?[1-9][0-9]*$/; //正整数 
	    var test=r1.test(packagePriceT);
	    if(test){
	    	$("#packagePriceT").html("");
	    	r2=true;
	    }else{
	    	$("#packagePriceT").html("只可以填正整数！");
	    	r2=false;
	    }
	    if (packagePriceT>9999||packagePriceT<0){
	    	$("#packagePriceT").html("套餐价格区间0-9999！");
	    	r2=false;
	    }
	    
	}
	if(d===0 && r1 && r2){
		r=true;
	}else if(d===1 ){
		r=r1;
	}else if(d===2 ){
		r=r2;
	}
    
	return r;
}

function enableInputsAndBtn(switchOn){
	if (switchOn){
		//解除屏蔽界面輸入元素以及按钮
		$("input[name=packageName]").removeAttr("readonly");
		$("input[name=packagePrice]").removeAttr("readonly");
		$("input[name=packageDesc]").removeAttr("readonly");
		$("input[name=functionStr]").removeAttr("readonly");
		$(".btn").removeAttr("disabled");
		$(".hasterm").removeAttr("disabled");
		$(".packageType").removeAttr("disabled");
	}else{
	    //屏蔽界面輸入元素以及按钮
		$("input[name=packageName]").attr("readonly","readonly");
		$("input[name=packagePrice]").attr("readonly","readonly");
		$("input[name=packageDesc]").attr("readonly","readonly");
		$("input[name=functionStr]").attr("readonly","readonly");
		$(".btn").attr("disabled","disabled");
		$(".hasterm").attr("disabled","disabled");
		$(".packageType").attr("disabled","disabled");
	}
}