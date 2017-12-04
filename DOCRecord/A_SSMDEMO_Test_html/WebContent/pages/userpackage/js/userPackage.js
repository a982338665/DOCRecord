$(function(){
	$("#main-nav").load($.getRootPath()+"/webpage/pages/left/left.html",function(){
		$("header").load($.getRootPath()+"/webpage/pages/top/header.html",function(){
			$("#yhxxglzk").addClass("in");
			$("#yhxxgl").addClass("active");
			$("#yhtccx").addClass("active");			
		});

	});
	
	
	
	
	$("#chaxun").click(function(){
		var a=$("#inputText1").val();
		
		if(!a||a==='' ){
			ischool.layout.alert("警告","搜索内容不能为空！");
			return;
		}
		
		$.ajaxSeentao($.getRootPath()+"/orderpackage/getOrderPackage.rest", a,function(json){
			if(json.code===1){

				ischool.layout.hide();
				var obj = JSON.parse(json.data);
				
				console.log(obj);
				
				var str="";
				for (var i = 0; i < obj.length; i++) {
										
					var time=timeCon2(obj[i].创建时间);
					str += "<tr><td>"+
					obj[i].学生姓名+"</td><td>"+
					obj[i].学生登录名+"</td><td>"+
					obj[i].家长姓名+"</td><td>"+
					obj[i].套餐内容+"</td><td>"+
					obj[i].订购电话+"</td><td>"+
					obj[i].学生ii号+"</td><td>"+
					time+"</td><td>";
				}
				$("tbody").html(str);
				
				
			}else{
				ischool.layout.error(json.errorMessage,2000);
				
			}
	        
	    },{type:"post"});
	});
	
	
});