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
	
	$("#chaxun").click(function(){
		var b=$("#date1").val();
		if(''===b){
			ischool.layout.alert("警告","必须选择时间！");
			return;
		}
		b=b.replace(" 至 ","|");
		$.ajaxSeentao($.getRootPath()+"/dataContrast/dataContrast.rest", "{\"time\":\""+b+"\"}",function(json){
			if(json.code===1){

				ischool.layout.hide();
				var obj = JSON.parse(json.data);
				
				console.log(obj);
				var str="<tr><td>教师数量为:"+obj.teacherSize+"</td>";
				
				str += "<td>学生数量为:"+obj.childSize+"</td>";
				
				str += "<td>家长数量为:" + obj.parentSize+"</td></tr>";

				$("tbody").html(str);
				
			}else{
				ischool.layout.error(json.errorMessage,2000);
				
			}
	        
	    },{type:"post"});
	});
	
	
	$("#daochu1").click(function(){
		var b=$("#date1").val();
		if($("tbody").html() == ''){
			ischool.layout.alert("警告","必须先进行结果查询，才能进行数据导出！");
			return;
		}
		b=b.replace(" 至 ","|");
		$.ajaxSeentao($.getRootPath()+"/dataContrast/dataContrastExport.rest", "{\"exportRole\":\"1\"}",function(json){
			if(json.code===1){

				ischool.layout.hide();
				var a = document.createElement('a');
				a.href= $.getRootPath()+json.data;
				a.download = c+"教师数据统计表.xlsx";
				a.click();
				a=null;
				
			}else{
				ischool.layout.error(json.errorMessage,2000);
				
			}
	        
	    },{type:"post"});
		
	});
	
	$("#daochu2").click(function(){
		var b=$("#date1").val();
		if($("tbody").html() == ''){
			ischool.layout.alert("警告","必须先进行结果查询，才能进行数据导出！");
			return;
		}
		b=b.replace(" 至 ","|");
		$.ajaxSeentao($.getRootPath()+"/dataContrast/dataContrastExport.rest", "{\"exportRole\":\"2\"}",function(json){
			if(json.code===1){

				ischool.layout.hide();
				var a = document.createElement('a');
				a.href= $.getRootPath()+json.data;
				a.download = c+"学生数据统计表.xlsx";
				a.click();
				a=null;
				
			}else{
				ischool.layout.error(json.errorMessage,2000);
				
			}
	        
	    },{type:"post"});
		
	});
	
	$("#daochu3").click(function(){
		var b=$("#date1").val();
		if($("tbody").html() == ''){
			ischool.layout.alert("警告","必须先进行结果查询，才能进行数据导出！");
			return;
		}
		b=b.replace(" 至 ","|");
		$.ajaxSeentao($.getRootPath()+"/dataContrast/dataContrastExport.rest", "{\"exportRole\":\"3\"}",function(json){
			if(json.code===1){

				ischool.layout.hide();
				var a = document.createElement('a');
				a.href= $.getRootPath()+json.data;
				a.download = c+"家长数据统计表.xlsx";
				a.click();
				a=null;
				
			}else{
				ischool.layout.error(json.errorMessage,2000);
				
			}
	        
	    },{type:"post"});
		
	});
	
});