$(function(){
	$("#main-nav").load($.getRootPath()+"/webpage/pages/left/left.html",function(){
		$("header").load($.getRootPath()+"/webpage/pages/top/header.html",function(){
			$("#sjtjbbzk").addClass("in");
			$("#sjtjbb").addClass("active");
			$("#dssjdc").addClass("active");			
		});

	});
	
	var dateRange1 = new pickerDateRange('date1', {
		stopToday : false,
		isTodayValid : true,
		
		needCompare : false,
		defaultText : ' 至 ',
		autoSubmit : false,
		inputTrigger : 'input_trigger1',
		theme : 'ta'
	});
	
	$.ajaxSeentao($.getRootPath()+"/dataStatistics/getCity.rest", "",function(json){
		if(json.code===1){

			ischool.layout.hide();
			
			var obj = JSON.parse(json.data);
			var str="<option value='0'>选择地市</option>";
			for(var i=0 ; i<obj.length;i++){
				str+= "<option value='"+obj[i].code+"'>"+obj[i].name+"</option>";
			}
			$("#selectCity").html(str);
		}else{
			ischool.layout.error(json.errorMessage,2000);
			
		}
        
    },{type:"post"});
	
	$("#chaxun").click(function(){
		var a=$("#selectCity").val();
		var b=$("#date1").val();
		var c=$("#selectCity").find("option:selected").text();
		if(a==='0' || ''===b){
			ischool.layout.alert("警告","必须选择地市和时间！");
			return;
		}
		b=b.replace(" 至 ","|");
		$.ajaxSeentao($.getRootPath()+"/dataStatistics/getDataForCity.rest", "{\"code\":\""+a+"\",\"time\":\""+b+"\",\"name\":\""+c+"\"}",function(json){
			if(json.code===1){

				ischool.layout.hide();
				var obj = JSON.parse(json.data);
				
				console.log(obj);
				var str="";
				for (var i = 0; i < obj.length; i++) {
					str += "<tr><td>"+obj[i].区县+"</td><td>"+
					obj[i].订购用户+"</td><td>"+
					obj[i].退订用户+"</td><td>"+
					obj[i].PC登录+"</td><td>"+
					obj[i].APP登录+"</td><td>"+
					obj[i].PC发通知+"</td><td>"+
					obj[i].APP发通知+"</td><td>"+
					obj[i].查看通知+"</td><td>"+
					obj[i].PC发作业+"</td><td>"+
					obj[i].APP发作业+"</td><td>"+
					obj[i].PC做作业+"</td><td>"+
					obj[i].APP做作业+"</td><td>";
				}
				$("tbody").html(str);
				
			}else{
				ischool.layout.error(json.errorMessage,2000);
				
			}
	        
	    },{type:"post"});
	});
	
	
	$("#daochu").click(function(){
		var a=$("#selectCity").val();
		var b=$("#date1").val();
		var c=$("#selectCity").find("option:selected").text();
		if(a==='0' || ''===b){
			ischool.layout.alert("警告","必须选择地市和时间！");
			return;
		}
		b=b.replace(" 至 ","|");
		$.ajaxSeentao($.getRootPath()+"/dataStatistics/exportDataForCity.rest", "{\"code\":\""+a+"\",\"time\":\""+b+"\",\"name\":\""+c+"\"}",function(json){
			if(json.code===1){

				ischool.layout.hide();
				var a = document.createElement('a');
				a.href= $.getRootPath()+json.data;
				a.download = c+"区县数据统计.xlsx";
				a.click();
				a=null;
				
			}else{
				ischool.layout.error(json.errorMessage,2000);
				
			}
	        
	    },{type:"post"});
		
	});
	
});