$(function(){
//	alert($.getRootPath());
	var cusername=$.cookie('userName1');
	var cuserpass=$.cookie("userPass1");

	if(null!=cusername){
		$("#remember_me1").prop("checked",true);
		$("#userName").val(cusername);
		$("#userPass").val(cuserpass);
		
	}

	$("#get").click(function(){
		var userName = $("#userName").val();
		var userPass = $("#userPass").val();
		if(''===userName || ''===userPass){
			ischool.layout.error("用户名密码不能为空",2000);
			
			return;
		}
		
		var loginjson = {};
		loginjson = $("#user").searchFormatSeentao();
		console.log($.jsonToString(loginjson));

		$.ajaxSeentao($.getRootPath()+"/user/login.rest", $.jsonToString(loginjson),function(json){
			if(json.code=='1'){

				$.cookie('fullName1',null);
				$.cookie('fullName1', json.data, {expires: 1 , path:'/'});
				
				var b=$("#remember_me1").prop("checked");
				
				if(b){
					$.cookie('userName1', userName, {expires: 30});
					$.cookie('userPass1', userPass, {expires: 30});
					
				}else{
					$.cookie('userName1',null);
					$.cookie('userPass1',null);

				}
				ischool.layout.success("登录成功",$.getRootPath()+'/webpage/pages/log/selectlog.html');
//				self.location=$.getRootPath();
			}else{
				ischool.layout.error(json.errorMessage,2000);
				
			}
	        console.log(json);
	    },{type:"post"});
		
	});
	
	document.onkeydown = function(event_e){  
        if(window.event)  
         event_e = window.event;  
         var int_keycode = event_e.charCode||event_e.keyCode;  
         if(int_keycode ==13){ 
       	  $('#get').click();
   		}
  	}  
	
	
})

