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
	
	function getCounty(){
		$.ajaxSeentao($.getRootPath()+"/dataStatistics/getDailyCity.rest","",function(json){
			if(json.code===1){
				ischool.layout.hide();
				var obj = JSON.parse(json.data);
				console.log(obj);
				var str="";
				for(var i=0 ; i<obj.length;i++){
					str+= '<tr id="countryId"><td id="city">'+obj[i].name
					+'</td><td id="teachernumbycity'+i
					+'"></td><td id="returncallsnumbycity'+i
					+'"></td><td id="parentanumbycity'+i
					+'"></td><td id="parentsuseappbycity'+i
					+'"></td><td id="teacherdayactivitybycity'+i
					+'"></td><td id="parentdayactivitybycity'+i
					+'"></td><td id="teachermonthactivitybycity'+i
					+'"></td><td id="parentmonthactivitybycity'+i
					+'"></td><td id="daynumberofactivegardensbycity'+i
					+'"></td><td id="monthnumberofactivegardensbycity'+i
					+'"></td><td id="installnumbyteacherbycity'+i
					+'"></td><td id="installnumbyfamilybycity'+i
					+'"></td></tr>';
				}
				$("#dataList").html(str);
				getTeacherNumByCity();
				getReturnCallsNumByCity();
				getParentaNumByCity();
				getParentsuseappByCity();
				getTeacherdayactivitybycity();
				getParentdayactivitybycity();
				getTeachermonthactivitybycity();
				getParentmonthactivitybycity();
				getDaynumberofactivegardensbycity();
				getMonthnumberofactivegardensbycity();
				getInstallnumbyteacherByCity();
				getInstallnumbyfamilyByCity();
			}else{
				ischool.layout.error(json.errorMessage,2000);
			}
		},{type:"post"});
	}
	function getTeacherNumByCity(){
		var b=$("#date1").val();
		//b=b.replace(" 至 ","|");
		$.ajaxSeentao($.getRootPath()+"/dataStatistics/getTeacherNumByCity.rest", "{\"time\":\""+b+"\"}",function(json){
			if(json.code===1){
				ischool.layout.hide();
				var obj = JSON.parse(json.data);
				console.log(obj);
				for(var i=0 ; i<obj.length;i++){
					$("#teachernumbycity"+i).html(obj[i].num);
				}
			}else{
				ischool.layout.error(json.errorMessage,2000);
			}
		},{type:"post"});
	}
	function getReturnCallsNumByCity(){
		var b=$("#date1").val();
		//b=b.replace(" 至 ","|");
		$.ajaxSeentao($.getRootPath()+"/dataStatistics/getReturnCallsNumByCity.rest", "",function(json){
			if(json.code===1){
				ischool.layout.hide();
				var obj = JSON.parse(json.data);
				console.log(obj);
				for(var i=0 ; i<obj.length;i++){
					$("#returncallsnumbycity"+i).html(obj[i].num);
				}
			}else{
				ischool.layout.error(json.errorMessage,2000);
			}
		},{type:"post"});
	}
	function getParentaNumByCity(){
		var b=$("#date1").val();
		//b=b.replace(" 至 ","|");
		$.ajaxSeentao($.getRootPath()+"/dataStatistics/getParentaNumByCity.rest", "{\"time\":\""+b+"\"}",function(json){
			if(json.code===1){
				ischool.layout.hide();
				var obj = JSON.parse(json.data);
				console.log(obj);
				var str="";
				for (var i = 0; i < obj.length; i++) {
					$("#parentanumbycity"+i).html(obj[i].num);
				}
			}else{
				ischool.layout.error(json.errorMessage,2000);
				
			}
	        
	    },{type:"post"});
	}
	function getParentsuseappByCity(){
		var b=$("#date1").val();
		//b=b.replace(" 至 ","|");
		$.ajaxSeentao($.getRootPath()+"/dataStatistics/getParentsuseappByCity.rest", "{\"time\":\""+b+"\"}",function(json){
			if(json.code===1){
				ischool.layout.hide();
				var obj = JSON.parse(json.data);
				console.log(obj);
				var str="";
				for (var i = 0; i < obj.length; i++) {
					$("#parentsuseappbycity"+i).html(obj[i].num);
				}
			}else{
				ischool.layout.error(json.errorMessage,2000);
				
			}
	        
	    },{type:"post"});
	}
	function getTeacherdayactivitybycity(){
		var b=$("#date1").val();
		//b=b.replace(" 至 ","|");
		$.ajaxSeentao($.getRootPath()+"/dataStatistics/getTeacherdayactivitybycity.rest", "{\"time\":\""+b+"\"}",function(json){
			if(json.code===1){
				ischool.layout.hide();
				var obj = JSON.parse(json.data);
				//console.log(obj);
				for(var i=0 ; i<obj.length;i++){
					$("#teacherdayactivitybycity"+i).html(obj[i].num);
				}
			}else{
				ischool.layout.error(json.errorMessage,2000);
			}
		},{type:"post"});
	}
	function getParentdayactivitybycity(){
		var b=$("#date1").val();
		//b=b.replace(" 至 ","|");
		$.ajaxSeentao($.getRootPath()+"/dataStatistics/getParentdayactivitybycity.rest", "{\"time\":\""+b+"\"}",function(json){
			if(json.code===1){
				ischool.layout.hide();
				var obj = JSON.parse(json.data);
				//console.log(obj);
				for(var i=0 ; i<obj.length;i++){
					$("#parentdayactivitybycity"+i).html(obj[i].num);
				}
			}else{
				ischool.layout.error(json.errorMessage,2000);
			}
		},{type:"post"});
	}
	function getTeachermonthactivitybycity(){
		var b=$("#date1").val();
		//b=b.replace(" 至 ","|");
		$.ajaxSeentao($.getRootPath()+"/dataStatistics/getTeachermonthactivitybycity.rest", "{\"time\":\""+b+"\"}",function(json){
			if(json.code===1){
				ischool.layout.hide();
				var obj = JSON.parse(json.data);
				//console.log(obj);
				for(var i=0 ; i<obj.length;i++){
					$("#teachermonthactivitybycity"+i).html(obj[i].num);
				}
			}else{
				ischool.layout.error(json.errorMessage,2000);
			}
		},{type:"post"});
	}
	function getParentmonthactivitybycity(){
		var b=$("#date1").val();
		//b=b.replace(" 至 ","|");
		$.ajaxSeentao($.getRootPath()+"/dataStatistics/getParentmonthactivitybycity.rest", "{\"time\":\""+b+"\"}",function(json){
			if(json.code===1){
				ischool.layout.hide();
				var obj = JSON.parse(json.data);
				//console.log(obj);
				for(var i=0 ; i<obj.length;i++){
					$("#parentmonthactivitybycity"+i).html(obj[i].num);
				}
			}else{
				ischool.layout.error(json.errorMessage,2000);
			}
		},{type:"post"});
	}
	function getDaynumberofactivegardensbycity(){
		var b=$("#date1").val();
		//b=b.replace(" 至 ","|");
		$.ajaxSeentao($.getRootPath()+"/dataStatistics/getDaynumberofactivegardensbycity.rest", "{\"time\":\""+b+"\"}",function(json){
			if(json.code===1){
				ischool.layout.hide();
				var obj = JSON.parse(json.data);
				//console.log(obj);
				for(var i=0 ; i<obj.length;i++){
					$("#daynumberofactivegardensbycity"+i).html(obj[i].num);
				}
			}else{
				ischool.layout.error(json.errorMessage,2000);
			}
		},{type:"post"});
	}
	function getMonthnumberofactivegardensbycity(){
		var b=$("#date1").val();
		//b=b.replace(" 至 ","|");
		$.ajaxSeentao($.getRootPath()+"/dataStatistics/getMonthnumberofactivegardensbycity.rest", "{\"time\":\""+b+"\"}",function(json){
			if(json.code===1){
				ischool.layout.hide();
				var obj = JSON.parse(json.data);
				//console.log(obj);
				for (var i = 0; i < obj.length; i++) {
					$("#monthnumberofactivegardensbycity"+i).html(obj[i].num);
				}
			}else{
				ischool.layout.error(json.errorMessage,2000);
			}
	    },{type:"post"});
	}
	
	function getInstallnumbyteacherByCity(){
		var b=$("#date1").val();
		//b=b.replace(" 至 ","|");
		$.ajaxSeentao($.getRootPath()+"/dataStatistics/getInstallnumbyteacherByCity.rest", "{\"time\":\""+b+"\"}",function(json){
			if(json.code===1){
				ischool.layout.hide();
				var obj = JSON.parse(json.data);
				console.log(obj);
				var str="";
				for (var i = 0; i < obj.length; i++) {
					$("#installnumbyteacherbycity"+i).html(obj[i].num);
				}
			}else{
				ischool.layout.error(json.errorMessage,2000);
			}
	        
	    },{type:"post"});
	}
	function getInstallnumbyfamilyByCity(){
		var b=$("#date1").val();
		//b=b.replace(" 至 ","|");
		$.ajaxSeentao($.getRootPath()+"/dataStatistics/getInstallnumbyfamilyByCity.rest", "{\"time\":\""+b+"\"}",function(json){
			if(json.code===1){
				ischool.layout.hide();
				var obj = JSON.parse(json.data);
				console.log(obj);
				var str="";
				for (var i = 0; i < obj.length; i++) {
					$("#installnumbyfamilybycity"+i).html(obj[i].num);
				}
			}else{
				ischool.layout.error(json.errorMessage,2000);
			}
	        
	    },{type:"post"});
	}
	$("#chaxun").click(function(){
		var b=$("#date1").val();
		if(''===b){
			ischool.layout.alert("警告","必须选择时间！");
			return;
		}
		//若包含此字清空b并提示只能选择一个日期
		if(b.indexOf("至") >= 0){
			$("#date1").val("");
			window.location.href=$.getRootPath()+'/webpage/pages/datastatistics/dailybycounty.html';
//			ischool.layout.error("此统计只支持选择一个日期！",2000);
		}else{
			getCounty();

		}
	});
	$("#daochu").click(function(){   

	var dataList = $("#dataList").children("tr");
	var dataArray = [];
	for(var i=0;i<dataList.length;i++) {
		var trHtml = dataList.eq(i).find('td');
		var cityArray = {};
		cityArray['地市'] = trHtml.eq(0).text();
		cityArray['教师用户总数'] = trHtml.eq(1).text();
		cityArray['参与返还话费的教师人数'] = trHtml.eq(2).text();
		cityArray['返还话费教师人数占比']=" ";
		cityArray['家长用户总数'] = trHtml.eq(3).text();
		cityArray['收费家长使用app用户数'] = trHtml.eq(4).text();
		cityArray['家长使用APP占比']=" ";
		cityArray['教师日活跃度'] = trHtml.eq(5).text();
		cityArray['日活跃教师占比']=" ";
		cityArray['家长日活跃度'] = trHtml.eq(6).text();
		cityArray['日活跃家长占比']=" ";
		cityArray['教师月活跃度'] = trHtml.eq(7).text();
		cityArray['月活跃教师占比'] = " ";
		cityArray['家长月活跃度'] = trHtml.eq(8).text();
		cityArray['月活跃家长占比']=" ";
		cityArray['和校园园所数']=" ";
		cityArray['当日活跃园所数'] = trHtml.eq(9).text();
		cityArray['当日活跃园所数占比']=" ";
		cityArray['当月活跃园所数'] = trHtml.eq(10).text();
		cityArray['参与返费教师app安装率']=" ";
		cityArray['家长app安装率']=" ";
		cityArray['参与返费教师app安装人数'] = trHtml.eq(11).text();
		cityArray['家长app安装人数'] = trHtml.eq(12).text();
		dataArray.push(cityArray);
		}
		$.ajaxSeentao($.getRootPath()+"/dataStatistics/exportDataSouceForCity.rest", JSON.stringify(dataArray),function(json){
			if(json.code===1){

				ischool.layout.hide();
				var a = document.createElement('a');
				a.href= $.getRootPath()+json.data;
				a.download = c+"地市数据统计.xlsx";
				a.click();
				a=null;
				
			}else{
				ischool.layout.error(json.errorMessage,2000);
				
			}
	        
	    },{type:"post"});
		
	});
	
	function getElementsByClassName(n) {
		var classElements = [],allElements = document.getElementsByTagName('*');
		for (var i=0; i< allElements.length; i++ )
		{
		if (allElements[i].className == n ) {
		classElements[classElements.length] = allElements[i];
		}
		}
		return classElements;
	} 
	
});

