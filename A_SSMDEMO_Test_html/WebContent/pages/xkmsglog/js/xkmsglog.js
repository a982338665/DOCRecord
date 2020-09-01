$(function(){
	$("#main-nav").load($.getRootPath()+"/webpage/pages/left/left.html",function(){
		$("header").load($.getRootPath()+"/webpage/pages/top/header.html",function(){
			$("#yhxxglzk").addClass("in");
			$("#yhxxgl").addClass("active");
			$("#ptrzcx").addClass("active");			
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
	
	$.ajaxSeentao($.getRootPath()+"/xklog/getOutLogApiType.rest", "",function(json){
		if(json.code===1){

			ischool.layout.hide();
			
			var obj = JSON.parse(json.data);
			var str="<option value='0'>选择接口</option>";
			for(var i=0 ; i<obj.length;i++){
				str+= "<option value='"+obj[i].L_REQ_URI+"'>"+obj[i].L_REQ_URI+"</option>";
			}
			$("#selectAPI").html(str);
		}else{
			ischool.layout.error(json.errorMessage,2000);
			
		}
        
    },{type:"post"});
	
	$("#chaxun").click(function(){
		//var a=$("#selectAPI").val();
		//var a1=$("#selectType").val();
		var b=$("#date1").val();
		var c=$("#con").val()?$("#con").val():"";
		console.log(c);
		if(c==='' || ''===b){
			ischool.layout.alert("警告","必须填写电话和时间！");
			return;
		}
		b=b.replace(" 至 ","|");
		$.ajaxSeentao($.getRootPath()+"/checkMessage/getMessageSendLog.rest", "{\"time\":\""+b+"\",\"mobile\":\""+c+"\"}",function(json){
			if(json.code===1){

				ischool.layout.hide();
				var obj = JSON.parse(json.data);
				
				console.log(obj);
				
				var str="";
				for (var i = 0; i < obj.length; i++) {
					var type = obj[i].send_status;
					if(0===type){
						type='未发送';
					}else{
						type='已发送';
					}
					var value=obj[i].context_ws;
					value=value.length>20?(value.substring(0,20)+"..."):value;
					var value1=obj[i].mobile;
					//value1=value1.length>20?(value1.substring(0,20)+"..."):value1;
					//var value2=obj[i].create_time;
					//value2=value2.length>20?(value2.substring(0,20)+"..."):value2;
					
					var time=timeCon2(obj[i].create_time);
					str += "<tr><td title='"+
					obj[i].mobile+"'>"+
					value1+"</td><td>"+
					type+"</td><td title='"+
					obj[i].context_ws+"'> <span class='content'>"+
					value+"</span></td><td>"+
					time+"</td><td>";
				}
				$("tbody").html(str);
				$(".content").click(function(){
					var text=$(this).parent().prop('title');
					alert(text);
				});
				
			}else{
				ischool.layout.error(json.errorMessage,2000);
				
			}
	        
	    },{type:"post"});
	});
	
	
});