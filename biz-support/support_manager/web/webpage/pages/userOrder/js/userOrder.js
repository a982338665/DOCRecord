$(function(){
	$("#main-nav").load($.getRootPath()+"/webpage/pages/left/left.html",function(){
		$("header").load($.getRootPath()+"/webpage/pages/top/header.html",function(){
			$("#yhxxglzk").addClass("in");
			$("#yhxxgl").addClass("active");
			$("#ddjlcx").addClass("active");			
		});

	});
	
	
	
	
	$("#chaxun").click(function(){
		var a=$("#inputText1").val();
		
		if(!a||a==='' ){
			ischool.layout.alert("警告","搜索内容不能为空！");
			return;
		}
		
		$.ajaxSeentao($.getRootPath()+"/orderpackage/getOrderingPackageType.rest", a,function(json){
			if(json.code===1){

				ischool.layout.hide();
				var obj = JSON.parse(json.data);
				
				console.log(obj);
				
				var str="";
				for (var i = 0; i < obj.length; i++) {
					var orderType = obj[i].订购种类;
					if(1===orderType){
						orderType='订购';
					}else if(2===orderType){
						orderType='退订';
					}
					var orderType1 = obj[i].订购状态;
					if(1===orderType1){
						orderType1='处理中';
					}else if(2===orderType1){
						orderType1='成功';
					}else if(3===orderType1){
						orderType1='失败';
					}
					var time=timeCon2(obj[i].创建时间);
					var time1=timeCon2(obj[i].处理时间);
					str += "<tr><td>"+
					orderType+"</td><td>"+
					orderType1+"</td><td>"+
					obj[i].学生姓名+"</td><td>"+
					obj[i].学生登录名+"</td><td>"+
					obj[i].家长姓名+"</td><td>"+
					obj[i].套餐+"</td><td>"+
					obj[i].学生ii号+"</td><td>"+
					obj[i].订购号码+"</td><td>"+
					time+"</td><td>"+
					
					time1+"</td><td>";
				}
				$("tbody").html(str);
				
				
			}else{
				ischool.layout.error(json.errorMessage,2000);
				
			}
	        
	    },{type:"post"});
	});
	
	
});