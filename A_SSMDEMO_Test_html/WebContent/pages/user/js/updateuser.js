var d=false;
var oldUserBean;
$(function(){
	
	$("#main-nav").load($.getRootPath()+"/webpage/pages/left/left.html",function(){
		$("header").load($.getRootPath()+"/webpage/pages/top/header.html",function(){
			$("#yhglzk").addClass("in");
			$("#yhglxt").addClass("active");
			$("#ptyhgl").addClass("active");
		});

	});
	$.ajaxSeentao($.getRootPath()+"/menu/getAllMenu.rest", name,function(json){
		if(json.code===1){
			ischool.layout.hide();
			var obj = JSON.parse(json.data);
			console.log(obj);
			var jsonArray=[];
			
			for(var i=0;i<obj.length;i++){
				if("0"===obj[i].menuParent){
					var length = jsonArray.length;
					jsonArray[length]={};
					jsonArray[length]["menuName"]=obj[i].menuName;
					jsonArray[length]["menuCode"]=obj[i].menuCode;
					jsonArray[length]["id"]=obj[i].id;
					jsonArray[length]["chird"]=[];
					for(var j=0;j<obj.length;j++){
						if(obj[i].menuCode===obj[j].menuParent){
							var chird = jsonArray[length].chird;
							var length2 = chird.length;
							var jsonch={};
							
							jsonch["menuName"]=obj[j].menuName;
							jsonch["menuCode"]=obj[j].menuCode;
							jsonch["id"]=obj[j].id;
							chird[length2]=jsonch;
						}
						
					}
				}
				
				
				
			}
			var str;
			for(var i=0;i<jsonArray.length;i++){
				str+="<tr>" +"<td><label class='checkbox'>" +
				"<input name='mainMenu' type='checkbox' class=\"checkall\" value='"+jsonArray[i].id+"'/>" +
				jsonArray[i].menuName+"</label></td><td>"
					for(var j=0;j<jsonArray[i].chird.length;j++){
						str+="<label class='checkbox'><input name='menu' type='checkbox' class=\"checkboxone\" value='"+
						jsonArray[i].chird[j].id+"'/>" +
						jsonArray[i].chird[j].menuName+"</label>" 
					}
				str+="</td></tr>" 
			}
			
			$("tbody").html(str);
			
			$(".checkall").click(function () {
	            $(this).parents("tr").find(".checkboxone").prop("checked", this.checked);
	        });
	        $(".checkboxone").click(function () {
	            var $subs = $(this).parents("tr").find(".checkboxone")
	            $(this).parents("tr").find(".checkall").prop("checked", $subs.length == $subs.filter(":checked").length ? true : false);
	        });
	        userTc();
		}else{
			ischool.layout.error(json.errorMessage,2000);
		}
	});
	$("#login_name").blur(function(){
		yzLname();
	});
	$("#sub").click(function(){
		var b=fromvalid();
		yzLname();
		if(b && d){
			var s=$("#user").searchFormatSeentao();
			if(oldUserBean&&oldUserBean.id){
				s["type"]=oldUserBean.id;
				var lpass=$("#login_pass").val();
				if(oldUserBean&&oldUserBean.loginPass==lpass){
					delete s.login_pass;
				}
				
			}else{
				s["type"]="-1";
			}
			var sj=$.jsonToString(s);
			
			
			
			$.ajaxSeentao($.getRootPath()+"/user/addOrUpdateUser.rest", sj,function(json){
				if(json.code===1){
					ischool.layout.success(json.data,$.getRootPath()+'/webpage/pages/user/adduser.html');
				}else{
					ischool.layout.error(json.errorMessage,2000);
				}
			});
		}else{
			ischool.layout.alert("警告","有字段为空或用户名重复！");
		}
	});
	
});
function yzLname(){
	var lname=$("#login_name").val();
	if(oldUserBean&&oldUserBean.loginName==lname){
		d=true;
		return;
	}
	if(lname&&''!=lname){
		$.ajaxSeentao($.getRootPath()+"/user/isLogName.rest",lname ,function(json){
			if(json.code===1){
				d=true;
				ischool.layout.hide();
			}else{
				d=false;
				ischool.layout.error(json.errorMessage,2000);
			}
		});
	}
}
function fromvalid(){
	var fname=$("#full_name").val();
	var lname=$("#login_name").val();
	var lpass=$("#login_pass").val();
	if(fname&&lname&&lpass&&''!=fname&&''!=lname&&''!=lpass){
		return true;
	}
	return false;
}
function userTc(){
	var id=$.getUrlSearch("id");
	if(id && ''!=id){
		$("title").text("修改用户");
		$("#title1").text("修改用户");
		$.ajaxSeentao($.getRootPath()+"/user/getUserById.rest", id,function(json){
			if(json.code===1){
				ischool.layout.hide();
				var obj = JSON.parse(json.data);
				var userBean = obj.userBean;
				oldUserBean=userBean;
				var userMenuBean = obj.UserMenuBean;
				console.log(userMenuBean);
				
				$("#login_name").val(userBean.loginName);
				$("#full_name").val(userBean.fullName);
				$("#login_pass").val(userBean.loginPass);
				
				for (var i = 0; i < userMenuBean.length; i++) {
					var inMenu=$("input[name='menu'][value='"+userMenuBean[i].menuId+"']");
					inMenu.prop("checked", true);
					var $subs = inMenu.parents("tr").find(".checkboxone")
		            inMenu.parents("tr").find(".checkall").prop("checked", $subs.length == $subs.filter(":checked").length ? true : false);
				}
				
			}else{
				ischool.layout.error(json.errorMessage,2000);
			}
		});
	}else{
		return;
	}
}