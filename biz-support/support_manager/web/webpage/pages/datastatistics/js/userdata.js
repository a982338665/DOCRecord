$(function(){
	$("#main-nav").load($.getRootPath()+"/webpage/pages/left/left.html",function(){
		$("header").load($.getRootPath()+"/webpage/pages/top/header.html",function(){
			$("#sjtjbbzk").addClass("in");
			$("#sjtjbb").addClass("active");
			$("#yhsjdc").addClass("active");			
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
			var str="";
			for(var i=0 ; i<obj.length;i++){
				str+= "<a onclick='edata(this)' class=\"btn btn-large\" data-code=\""+obj[i].code+"\" data-type='1' title=\""+obj[i].name+"\">"+obj[i].name+"</a>";
			}
			$("#teacher").html(str);
			str="";
			for(var i=0 ; i<obj.length;i++){
				str+= "<a onclick='edata(this)' class=\"btn btn-large\" data-code=\""+obj[i].code+"\" data-type='2' title=\""+obj[i].name+"\">"+obj[i].name+"</a>";
			}
			$("#student").html(str);
			str="";
			for(var i=0 ; i<obj.length;i++){
				str+= "<a onclick='edata(this)' class=\"btn btn-large\" data-code=\""+obj[i].code+"\" data-type='3' title=\""+obj[i].name+"\">"+obj[i].name+"</a>";
			}
			$("#family").html(str);
			
		}else{
			ischool.layout.error(json.errorMessage,2000);
			
		}
        
    },{type:"post"});
	
	
});
function edata(obj){
//	alert($(this).data("code"));
	var b=$("#date1").val();
	if(''===b){
		ischool.layout.alert("警告","必须选择时间！");
		return;
	}
	var a=$(obj).data("code");
	var c=$(obj).text();
	var d=$(obj).data("type");
	b=b.replace(" 至 ","|");
	$.ajaxSeentao($.getRootPath()+"/dataStatistics/exportDataForUser.rest", "{\"code\":\""+a+"\",\"time\":\""+b+"\",\"name\":\""+c+"\",\"type\":\""+d+"\"}",function(json){
		if(json.code===1){

			ischool.layout.hide();
			var a = document.createElement('a');
			a.href= $.getRootPath()+json.data;
			a.download = c+"用户数据统计.xlsx";
			a.click();
			a=null;
			
		}else{
			ischool.layout.error(json.errorMessage,2000);
			
		}
        
    },{type:"post"});
}