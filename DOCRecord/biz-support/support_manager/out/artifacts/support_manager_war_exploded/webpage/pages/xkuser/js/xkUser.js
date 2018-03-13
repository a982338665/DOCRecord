$(function(){
	
	var xkUserBean;
	
	$("#main-nav").load($.getRootPath()+"/webpage/pages/left/left.html",function(){
		$("header").load($.getRootPath()+"/webpage/pages/top/header.html",function(){
			$("#yhxxglzk").addClass("in");
			$("#yhxxgl").addClass("active");
			$("#yhzlxg").addClass("active");
		});

	});
	
	$("#chaxun").click(function(){
		var ii =$("#inputText1").val();
		if(!ii ||''==ii){
			return;
		}
		$.ajaxSeentao($.getRootPath()+"/xkUser/getUsers.rest", ii,function(json){
			if(json.code=='1'){
//				ischool.layout.success("操作成功");
//				self.location=$.getRootPath();
				ischool.layout.hide();
				
				var obj = JSON.parse(json.data);
				
				console.log(obj);
				var strn;
				for(var i=0;i<obj.length;i++){
					var u=obj[i];
					var sex=(0 === u.cSex)?"女":"男";
					var occupations=("1000" === u.cOccupations)?"老师":
						("0100" === u.cOccupations)?"学生":("0010" === u.cOccupations)?"家长":"不详";
					var cMobile=u.cMobile?u.cMobile:"";
					var cLgnname=u.cLgnname?u.cLgnname:""
					var byname = u.cByname?u.cByname:"";
					var forename = u.cForename?u.cForename:"";
					strn+="<tr><td>" +
					byname + forename + "</td><td>" +
							sex + "</td><td>" +
							occupations + "</td><td>" +
							cMobile +	"</td><td>" +
							cLgnname + "</td><td>" +
							u.cIinum + "</td><td> " +
									"<a class='btn' name='xgzl' data-toggle='modal' href='#modal-example' role='button'>修改资料</a>" +
									"<a class='btn' name='xgmm' data-toggle='modal' href='#modal-example1' role='button'>修改密码</a></td></tr>";
				}
				$("tbody").html(strn);
				//绑定事件
				$("a[name='xgzl']").click(function(){
					var a=$.trim($(this).parent().prev().text());
					for(var i=0;i<obj.length;i++){
						var u=obj[i];
						if(u.cIinum==a){
							xkUserBean=obj[i];
						}
					}
					$("#byName").val(xkUserBean.cByname);
					$("#forName").val(xkUserBean.cForename);
					$("#lgName").val(xkUserBean.cLgnname);
					
					
					$("input:radio[name='gender'][value='"+xkUserBean.cSex+"']").prop("checked",true);
				});
				$("a[name='xgmm']").click(function(){
					var a=$.trim($(this).parent().prev().text());
					for(var i=0;i<obj.length;i++){
						var u=obj[i];
						if(u.cIinum==a){
							xkUserBean=obj[i];
						}
					}
					
				});
			}else{
				ischool.layout.error(json.errorMessage,2000);
				
			}
	        
	    },{type:"post"});
	});
	
	$("#updateXKUser").click(function(){
		var byName= $("#byName").val();
		var forName= $("#forName").val();
		var lgName= $("#lgName").val();
		var sex= $("input[name='gender']:checked").val();
		console.log(sex);
		if(''==byName || ''==forName || ''==lgName){
			ischool.layout.alert("警告","姓氏、名字、登录账号不能为空！");
			return;
		}
		var xkbean={};
		xkbean["cByname"]=byName;
		xkbean["cForename"]=forName;
		xkbean["cLgnname"]=lgName;
		xkbean["cSex"]=sex;
		xkbean["cSid"]=xkUserBean.cSid;
		
		$.ajaxSeentao($.getRootPath()+"/xkUser/updateXKUser.rest",$.jsonToString(xkbean),function(json){
			if(json.code=='1'){
				ischool.layout.success("修改成功");
				window.location.reload();
				
			}else{
				ischool.layout.error(json.errorMessage,2000);
				
			}
	        console.log(json);
	    },{type:"post"});

	});
	$("#ggmm").click(function(){
		
		if(pwdcheck() && repwdcheck()){
			var xkbean={};
			xkbean["cPwd"]=$("#password").val();
			xkbean["cSid"]=xkUserBean.cSid;
			$.ajaxSeentao($.getRootPath()+"/xkUser/updateXKUser.rest",$.jsonToString(xkbean),function(json){
				if(json.code=='1'){
					ischool.layout.success("修改成功");
					window.location.reload();
					
				}else{
					ischool.layout.error(json.errorMessage,2000);
					
				}
		        console.log(json);
		    },{type:"post"});
		}
	});
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
	
});
