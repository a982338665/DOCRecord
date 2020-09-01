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
		$.ajaxSeentao($.getRootPath()+"/dataStatistics/getCounty.rest","",function(json){
			if(json.code===1){
				ischool.layout.hide();
				var obj = JSON.parse(json.data);
				console.log(obj);
				var str="";
				for(var i=0 ; i<obj.length;i++){
					str+= '<tr id="countryId"><td id="district">'+obj[i].num
					+'</td><td id="addteachernum'+i
					+'"></td><td id="teachernum'+i
					+'"></td><td id="returncallsnum'+i
					+'"></td><td id="addparentanum'+i
					+'"></td><td id="parentanum'+i
					+'"></td><td id="packagechargenum'+i
					+'"></td><td id="parentsuseapp'+i
					+'"></td><td id="teacheractivitybyday'+i
					+'"></td><td id="parentaactivitybyday'+i
					+'"></td><td id="teacheractivitybymonth'+i
					+'"></td><td id="parentaactivitybymonth'+i
					+'"></td><td id="daynumberofactivegardens'+i
					+'"></td><td id="monthnumberofactivegardens'+i
					+'"></td><td id="installnumbyteacher'+i
					+'"></td><td id="installnumbyfamily'+i
					+'"></td></tr>';
				}
				$("#dataList").html(str);
				getAddteachernum();
				getTeacherNum();
				getReturnCallsNum();
				getAddByFamilyNum();
				getParentaNum();
				getpackagechargenum();
				getParentsuseapp();
				getTeacheractivitybyday();
				getParentaactivitybyday();
				getTeacheractivitybymonth();
				getParentaactivitybymonth();
				getDaynumberofactivegardens();
				getMonthnumberofactivegardens();
				getInstallnumbyteacher();
				getInstallnumbyfamily();
			}else{
				ischool.layout.error(json.errorMessage,2000);
			}
		},{type:"post"});
	}
	function getAddteachernum(){
		var b=$("#date1").val();
//		b=b.replace(" 至 ","|");
		$.ajaxSeentao($.getRootPath()+"/dataStatistics/getAddteachernum.rest", "{\"time\":\""+b+"\"}",function(json){
			if(json.code===1){
				ischool.layout.hide();
				var obj = JSON.parse(json.data);
				console.log(obj);
				for(var i=0 ; i<obj.length;i++){
					$("#addteachernum"+i).html(obj[i].num);
				}
			}else{
				ischool.layout.error(json.errorMessage,2000);
			}
		},{type:"post"});
	}
	function getTeacherNum(){
		var b=$("#date1").val();
//		b=b.replace(" 至 ","|");
		$.ajaxSeentao($.getRootPath()+"/dataStatistics/getTeacherNum.rest", "{\"time\":\""+b+"\"}",function(json){
			if(json.code===1){
				ischool.layout.hide();
				var obj = JSON.parse(json.data);
				console.log(obj);
				for(var i=0 ; i<obj.length;i++){
					$("#teachernum"+i).html(obj[i].num);
				}
			}else{
				ischool.layout.error(json.errorMessage,2000);
			}
		},{type:"post"});
	}
	function getReturnCallsNum(){
		var b=$("#date1").val();
//		b=b.replace(" 至 ","|");
		$.ajaxSeentao($.getRootPath()+"/dataStatistics/getReturnCallsNum.rest", "",function(json){
			if(json.code===1){
				ischool.layout.hide();
				var obj = JSON.parse(json.data);
				console.log(obj);
				for(var i=0 ; i<obj.length;i++){
					$("#returncallsnum"+i).html(obj[i].num);
				}
			}else{
				ischool.layout.error(json.errorMessage,2000);
			}
		},{type:"post"});
	}
	
	function getAddByFamilyNum(){
		var b=$("#date1").val();
//		b=b.replace(" 至 ","|");
		$.ajaxSeentao($.getRootPath()+"/dataStatistics/getAddByFamilyNum.rest", "{\"time\":\""+b+"\"}",function(json){
			if(json.code===1){
				ischool.layout.hide();
				var obj = JSON.parse(json.data);
				console.log(obj);
				var str="";
				for (var i = 0; i < obj.length; i++) {
					$("#addparentanum"+i).html(obj[i].num);
				}
			}else{
				ischool.layout.error(json.errorMessage,2000);
				
			}
	        
	    },{type:"post"});
	};
	
	function getParentaNum(){
		var b=$("#date1").val();
//		b=b.replace(" 至 ","|");
		$.ajaxSeentao($.getRootPath()+"/dataStatistics/getParentaNum.rest", "{\"time\":\""+b+"\"}",function(json){
			if(json.code===1){
				ischool.layout.hide();
				var obj = JSON.parse(json.data);
				console.log(obj);
				var str="";
				for (var i = 0; i < obj.length; i++) {
					$("#parentanum"+i).html(obj[i].num);
				}
			}else{
				ischool.layout.error(json.errorMessage,2000);
				
			}
	        
	    },{type:"post"});
	}
	function getpackagechargenum(){
		var b=$("#date1").val();
//		b=b.replace(" 至 ","|");
		$.ajaxSeentao($.getRootPath()+"/dataStatistics/getpackagechargenum.rest", "{\"time\":\""+b+"\"}",function(json){
			if(json.code===1){
				ischool.layout.hide();
				var obj = JSON.parse(json.data);
				console.log(obj);
				var str="";
				for (var i = 0; i < obj.length; i++) {
					$("#packagechargenum"+i).html(obj[i].num);
				}
			}else{
				ischool.layout.error(json.errorMessage,2000);
				
			}
	        
	    },{type:"post"});
	}
	
	function getParentsuseapp(){
		var b=$("#date1").val();
//		b=b.replace(" 至 ","|");
		$.ajaxSeentao($.getRootPath()+"/dataStatistics/getParentsuseapp.rest", "{\"time\":\""+b+"\"}",function(json){
			if(json.code===1){
				ischool.layout.hide();
				var obj = JSON.parse(json.data);
				console.log(obj);
				var str="";
				for (var i = 0; i < obj.length; i++) {
					$("#parentsuseapp"+i).html(obj[i].num);
				}
			}else{
				ischool.layout.error(json.errorMessage,2000);
				
			}
	        
	    },{type:"post"});
	}
	function getTeacheractivitybyday(){
		var b=$("#date1").val();
//		b=b.replace(" 至 ","|");
		$.ajaxSeentao($.getRootPath()+"/dataStatistics/getTeacheractivitybyday.rest", "{\"time\":\""+b+"\"}",function(json){
			if(json.code===1){
				ischool.layout.hide();
				var obj = JSON.parse(json.data);
				//console.log(obj);
				for(var i=0 ; i<obj.length;i++){
					$("#teacheractivitybyday"+i).html(obj[i].num);
				}
			}else{
				ischool.layout.error(json.errorMessage,2000);
			}
		},{type:"post"});
	}
	function getParentaactivitybyday(){
		var b=$("#date1").val();
//		b=b.replace(" 至 ","|");
		$.ajaxSeentao($.getRootPath()+"/dataStatistics/getParentaactivitybyday.rest", "{\"time\":\""+b+"\"}",function(json){
			if(json.code===1){
				ischool.layout.hide();
				var obj = JSON.parse(json.data);
				console.log(obj);
				for (var i = 0; i < obj.length; i++) {
					$("#parentaactivitybyday"+i).html(obj[i].num);
				}
			}else{
				ischool.layout.error(json.errorMessage,2000);
			}
	    },{type:"post"});
	}
	function getTeacheractivitybymonth(){
		var b=$("#date1").val();
//		b=b.replace(" 至 ","|");
		$.ajaxSeentao($.getRootPath()+"/dataStatistics/getTeacheractivitybymonth.rest", "{\"time\":\""+b+"\"}",function(json){
			if(json.code===1){
				ischool.layout.hide();
				var obj = JSON.parse(json.data);
				console.log(obj);
				for (var i = 0; i < obj.length; i++) {
					$("#teacheractivitybymonth"+i).html(obj[i].num);
				}
			}else{
				ischool.layout.error(json.errorMessage,2000);
			}
	    },{type:"post"});
	}
	function getParentaactivitybymonth(){
		var b=$("#date1").val();
//		b=b.replace(" 至 ","|");
		$.ajaxSeentao($.getRootPath()+"/dataStatistics/getParentaactivitybymonth.rest", "{\"time\":\""+b+"\"}",function(json){
			if(json.code===1){
				ischool.layout.hide();
				var obj = JSON.parse(json.data);
				//console.log(obj);
				for (var i = 0; i < obj.length; i++) {
					$("#parentaactivitybymonth"+i).html(obj[i].num);
				}
			}else{
				ischool.layout.error(json.errorMessage,2000);
			}
	    },{type:"post"});
	}

	function getDaynumberofactivegardens(){
		var b=$("#date1").val();
//		b=b.replace(" 至 ","|");
		$.ajaxSeentao($.getRootPath()+"/dataStatistics/getDaynumberofactivegardens.rest", "{\"time\":\""+b+"\"}",function(json){
			if(json.code===1){
				ischool.layout.hide();
				var obj = JSON.parse(json.data);
				console.log(obj);
				var str="";
				for (var i = 0; i < obj.length; i++) {
					$("#daynumberofactivegardens"+i).html(obj[i].num);
				}
			}else{
				ischool.layout.error(json.errorMessage,2000);
			}
	        
	    },{type:"post"});
	}
	function getMonthnumberofactivegardens(){
		var b=$("#date1").val();
//		b=b.replace(" 至 ","|");
		$.ajaxSeentao($.getRootPath()+"/dataStatistics/getMonthnumberofactivegardens.rest", "{\"time\":\""+b+"\"}",function(json){
			if(json.code===1){
				ischool.layout.hide();
				var obj = JSON.parse(json.data);
				console.log(obj);
				var str="";
				for (var i = 0; i < obj.length; i++) {
					$("#monthnumberofactivegardens"+i).html(obj[i].num);
				}
			}else{
				ischool.layout.error(json.errorMessage,2000);
			}
	        
	    },{type:"post"});
	}

	function getInstallnumbyteacher(){
		var b=$("#date1").val();
//		b=b.replace(" 至 ","|");
		$.ajaxSeentao($.getRootPath()+"/dataStatistics/getInstallnumbyteacher.rest", "{\"time\":\""+b+"\"}",function(json){
			if(json.code===1){
				ischool.layout.hide();
				var obj = JSON.parse(json.data);
				console.log(obj);
				var str="";
				for (var i = 0; i < obj.length; i++) {
					$("#installnumbyteacher"+i).html(obj[i].num);
				}
			}else{
				ischool.layout.error(json.errorMessage,2000);
			}
	        
	    },{type:"post"});
	}
	function getInstallnumbyfamily(){
		var b=$("#date1").val();
//		b=b.replace(" 至 ","|");
		$.ajaxSeentao($.getRootPath()+"/dataStatistics/getInstallnumbyfamily.rest", "{\"time\":\""+b+"\"}",function(json){
			if(json.code===1){
				ischool.layout.hide();
				var obj = JSON.parse(json.data);
				console.log(obj);
				var str="";
				for (var i = 0; i < obj.length; i++) {
					$("#installnumbyfamily"+i).html(obj[i].num);
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
			//$("#date1").attr('placeholder','请选择一个日期！')
//			ischool.layout.error("请选择一个日期！",2000);
			window.location.href=$.getRootPath()+'/webpage/pages/datastatistics/dailybycounty.html';
		}else{
			getCounty();

		}
	});
	

		
	
	
	$("#daochu").click(function(){   

		var b=$("#date1").val();
		if(''===b){
			ischool.layout.alert("警告","必须选择时间！");
			return;
		}
//		b=b.replace(" 至 ","|");
		var dataList = $("#dataList").children("tr");

		var dataArray = [];
		
		for(var i=0;i<dataList.length;i++) {
			var trHtml = dataList.eq(i).find('td');
			var cityArray = {};
			cityArray['区县'] = trHtml.eq(0).text();
			cityArray['当日教师新增'] = trHtml.eq(1).text();
			cityArray['教师用户总数'] = trHtml.eq(2).text();
			cityArray['参与返还话费的教师人数'] = trHtml.eq(3).text();
			cityArray['返还话费教师人数占比'] =" ";
			cityArray['当日家长新增'] = trHtml.eq(4).text();
			cityArray['家长用户总数'] = trHtml.eq(5).text();
			cityArray['套餐收费家长总数'] = trHtml.eq(6).text();
			cityArray['收费家长使用app用户数'] = trHtml.eq(7).text();
			cityArray['收费家长使用APP占比'] = " ";
			cityArray['教师日活跃度'] = trHtml.eq(8).text();
			cityArray['日活跃教师占比'] = " ";
			cityArray['家长日活跃度'] = trHtml.eq(9).text();
			cityArray['日活跃家长占比'] = " ";
			cityArray['教师月活跃度'] = trHtml.eq(10).text();
			cityArray['月活跃教师占比'] = " ";
			cityArray['家长月活跃度'] = trHtml.eq(11).text();
			cityArray['月活跃家长占比'] =" ";
			cityArray['和校园园所数'] = trHtml.eq(12).text();
			cityArray['当日活跃园所数'] = trHtml.eq(13).text();
			cityArray['当日活跃园所数占比'] = " ";
			cityArray['当月活跃园所数'] = trHtml.eq(14).text();
			cityArray['参与返费教师app安装率'] = " ";
			cityArray['家长app安装率'] = " ";
			cityArray['参与返费教师app安装人数'] = trHtml.eq(15).text();
			cityArray['家长app安装人数'] = trHtml.eq(16).text();
			dataArray.push(cityArray);
		}
			$.ajaxSeentao($.getRootPath()+"/dataStatistics/exportDataSouceForCount.rest", JSON.stringify(dataArray),function(json){
				if(json.code===1){
					ischool.layout.hide();
					var a = document.createElement('a');
					a.href= "../../.."+json.data;
					a.download = "区县数据统计.xlsx";
					a.click();
					a=null;
					
				}else{
					ischool.layout.error(json.errorMessage,2000);
					
				}
		        
		    },{type:"post"});
			
		});
	
});

