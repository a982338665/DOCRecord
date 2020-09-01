var d=false;
$(function(){
	
	$("#main-nav").load($.getRootPath()+"/webpage/pages/left/left.html",function(){
		$("header").load($.getRootPath()+"/webpage/pages/top/header.html",function(){
			$("#yhglzk").addClass("in");
			$("#yhglxt").addClass("active");
			$("#xgmm").addClass("active");
		});

	});
	
	$("#oldPass").blur(function(){
		yzOldPass();
	});
	$("#sub").click(function(){
		if(!d){
			yzOldPass();
		}
		
		var a=pwdcheck();
		var b=repwdcheck();
		if(a&&b&&d){
			var repwd = $("#repassword").val();
			$.ajaxSeentao($.getRootPath()+"/user/updateIPass.rest",repwd ,function(json){
				if(json.code===1){
					ischool.layout.success("修改成功");
					ischool.layout.hide();
				}else{
					
					ischool.layout.error(json.errorMessage,2000);
				}
			});
		}
	});
});
function yzOldPass(){
	var pwd = $("#oldPass").val();

    if(pwd == ""){
        html = "";
        html += '原密码不能为空';
        $('#oldPwdWaring1').html(html);
        d=false;
        return ;
    }else{
    	$.ajaxSeentao($.getRootPath()+"/user/isPass.rest", pwd,function(json){
    		ischool.layout.hide();
			if(json.code===1){
				html = "";
		        html += '';
		        $('#oldPwdWaring1').html(html);
		        d=true;
			}else{
				html = "";
		        html += '输入的原密码不对！';
		        $('#oldPwdWaring1').html(html);
		        d=false;
			}
		});
        
        return ;       
    }
}
function pwdcheck(){
    var pwd = $("#password").val();
    if(pwd == ""){
        html = "";
        html += '密码不能为空';
        $('#oldPwdWaring').html(html);
        return false;
    }else{
        html = "";
        html += '';
        $('#oldPwdWaring').html(html);
        return true;       
    }
}
function repwdcheck(){
    var pwd = $("#password").val();
    var repwd = $("#repassword").val();
    if(pwd != repwd){
        console.log(pwd);
        console.log(repwd);         
        html = '两次输入密码不一样';
        $('#repass').html(html);
        return false;
    }else{
        html = "";
        html += '';
        $('#repass').html(html);
        return true;       
    }
}