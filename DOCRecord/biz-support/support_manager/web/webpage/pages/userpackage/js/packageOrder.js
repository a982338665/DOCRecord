var schoolList={};
var packageList={};
var ob;
var grade=['一','二','三','四','五','六'];
var ishs=false;
$(function(){
	$("#main-nav").load($.getRootPath()+"/webpage/pages/left/left.html",function(){
		$("header").load($.getRootPath()+"/webpage/pages/top/header.html",function(){
			$("#tcglzk").addClass("in");
			$("#tcgl").addClass("active");
			$("#tcdg").addClass("active");			
		});

	});
	$.ajaxSeentao($.getRootPath()+"/packagemgr/packagemgrlist.rest",function(json){
		ischool.layout.hide();

		packageList=json;
		var tc ='<option value="0">请选择</option>';
		for (var int = 0; int < json.length; int++) {
			
			
			tc += '<option value="'+json[int].packageCode+'">'+json[int].packageName+'</option>';
			
		}

		$("#packageX").html(tc);
		

	});
	
	$("#packageX").change(function(){
		var packageX=$("#packageX").val();
		var packageU=getPackageById(packageX);
		var hasTerm = packageU.hasTerm;
		if(hasTerm==0){
			$("#pTime").hide();
			
		}else{
			$("#pTime").show();
		}
	});
	
	$.ajaxSeentao($.getRootPath()+"/area/getAllCity.rest",function(json){
		
		if(json.code===1){
			ischool.layout.hide();
			var obj = JSON.parse(json.data);
	
			var strn='<option value="0">请选择</option>';
			for (var int = 0; int < obj.length; int++) {
				
				strn +='<option value="'+obj[int].cCode+'">'+obj[int].cName+'</option>';
			}
			
			$("#ds").html(strn);
		}else{
			ischool.layout.error(json.errorMessage,2000);
		}

	});
	
	$("#ds").change(function(){
		var dscode=$("#ds").val();
		$.ajaxSeentao($.getRootPath()+"/area/getAllqx.rest",dscode,function(json){
			
			if(json.code===1){
				ischool.layout.hide();
				var obj = JSON.parse(json.data);
		
				var strn='<option value="0">请选择</option>';
				for (var int = 0; int < obj.length; int++) {
					
					strn +='<option value="'+obj[int].cCode+'">'+obj[int].cName+'</option>';
				}
				
				$("#qx").html(strn);
			}else{
				ischool.layout.error(json.errorMessage,2000);
			}

		});
	});
	$("#qx").change(function(){
		var dscode=$("#qx").val();
		$.ajaxSeentao($.getRootPath()+"/school/getSchoolByArea.rest",dscode,function(json){
			
			if(json.code===1){
				ischool.layout.hide();
				var obj = JSON.parse(json.data);
				schoolList=obj;
				var strn='<option value="0">请选择</option>';
				for (var int = 0; int < obj.length; int++) {
					
					strn +='<option value="'+obj[int].cSid+'">'+obj[int].cName+'</option>';
				}
				
				$("#school").html(strn);
			}else{
				ischool.layout.error(json.errorMessage,2000);
			}
			
		});
	});
	$("#school").change(function(){
		var id=$("#school").val();
		var schoolBean=getSchoolById(id);
		console.log(schoolBean);
		var strn='<option value="0">请选择</option>';
		if(schoolBean.cIskindergarten===1){
			strn +='<option value="-1">幼儿园</option>';
		}
		if(schoolBean.cIsprimary===1){
			strn +='<option value="1">小学</option>';
		}
		if(schoolBean.cIsjunior===1){
			strn +='<option value="2">初中</option>';
		}
		if(schoolBean.cSenior===1){
			strn +='<option value="3">高中</option>';
		}
		
		$("#schoolStage").html(strn);

	});
	$("#schoolStage").change(function(){
		var id=$("#school").val();
		var schoolBean=getSchoolById(id);
		var schoolStage=$("#schoolStage").val();
		
		var strn='<option value="0">请选择</option>';
		if(schoolStage==='-1'){
			strn +='<option value="-3">小班</option>';
			strn +='<option value="-2">中班</option>';
			strn +='<option value="-1">大班</option>';
		}else if(schoolStage==='1'){
			var i=0;
			if(schoolBean.cSchoolca==="633"){
				i=6;
			}else{
				i=5;
			}
			for (var int = 0; int < i; int++) {
				strn +='<option value="'+(int+1)+'">'+grade[int]+'年级</option>';
			}
		}else if(schoolStage==='2'){
			var i=0,n=0;
			if(schoolBean.cSchoolca==="633"){
				i=3,n=6;
			}else{
				i=4,n=5;
			}
			for (var int = 0; int < i; int++) {
				strn +='<option value="'+(int+1+n)+'">初中'+grade[int]+'年级</option>';
			}
		}else if(schoolStage==='3'){
			
			for (var int = 0; int < 3; int++) {
				strn +='<option value="'+(int+1+9)+'">高中'+grade[int]+'年级</option>';
			}
		}
		
		
		$("#gradenum").html(strn);
		
	});
	$("#gradenum").change(function(){
		var strn='<option value="0">请选择</option>';
		var schoolId=$("#school").val();
		var gradenum=$("#gradenum").val();
		var json1={};
		json1["schoolId"]=schoolId;
		json1["gradenum"]=gradenum;
		var sj = $.jsonToString(json1);
		$.ajaxSeentao($.getRootPath()+"/school/getClassById.rest",sj,function(json){
			
			if(json.code===1){
				ischool.layout.hide();
				var obj = JSON.parse(json.data);
				console.log(obj);
				var strn='<option value="0">请选择</option>';
				for (var int = 0; int < obj.length; int++) {
					
					strn +='<option value="'+obj[int].cClassid+'">'+obj[int].cClassname+'</option>';
				}
				
				$("#class").html(strn);
			}else{
				ischool.layout.error(json.errorMessage,2000);
			}
			
		});
		
	});
	$("#class").change(function(){
		
		var clazz=$("#class").val();
		
		
		$.ajaxSeentao($.getRootPath()+"/orderpackage/gxgetOrderPackage.rest",clazz,function(json){
			
			if(json.code===1){
				ischool.layout.hide();
				var obj = JSON.parse(json.data);
				console.log(obj);
				tcsj(obj);
				
			}else{
				ischool.layout.error(json.errorMessage,2000);
			}
			
		});
		
	});
	$("#cstc").click(function(){
		var ii=$("#inputText1").val();
		
		
		$.ajaxSeentao($.getRootPath()+"/orderpackage/gxgetOrderPackage.rest",ii,function(json){
			
			if(json.code===1){
				ischool.layout.hide();
				var obj = JSON.parse(json.data);
				console.log(obj);
				tcsj(obj);
				
			}else{
				ischool.layout.error(json.errorMessage,2000);
			}
			
		});

		
	});
	
	$("#pldg").click(function(){
		var s=$("tbody").searchFormatSeentao();
//		console.log(s);
		if(!s.idMobile){
			ischool.layout.error("请选择学生后再批量订购套餐！");
			return;
		}
		if(ishs){
			

		}else{
			ishs=true;
			$("#pldg").attr("data-toggle","modal");
			$("#pldg").attr("href","#details");

			
		}
		
		
	});
	
	$("#pltd1").click(function(){
		var s=$("tbody").searchFormatSeentao();
//		console.log(s);
		if(!s.idMobile){
			ischool.layout.error("请选择学生后再批量退订套餐！");
			return;
		}
		tuiding(s);
		
	});
	$("#sub").click(function(){
		var s;
		if(ob){
			s=ob;
		}else{
			s=$("tbody").searchFormatSeentao();
		}
		
		
		dinggou(s)

		
		
	});
});
function tcsj(obj){
	var str=""
		for (var int = 0; int < obj.length; int++) {
			var sex = obj[int].sex;
			if(sex===0){
				sex='女';
			}else if(sex===1){
				sex='男';
			}
			
			var c_expirydate = obj[int].c_expirydate;
			if(c_expirydate===0){
				c_expirydate='无限期';
			}else if(!c_expirydate){
				c_expirydate='';
			}
			var c_packagescode = obj[int].C_packagescode;
			if(!c_packagescode){
				c_packagescode='';
			}
			str +=	"<tr>"+
					"<td><input value="+obj[int].c_sid+"|"+obj[int].c_mobile+" type=\"checkbox\" name=\"idMobile\"/></td>"+
					"<td>"+obj[int].name+"</td>"+
					"<td>"+sex+"</td>"+
					"<td>学生</td>"+
					"<td>"+obj[int].c_mobile+"</td>"+
					"<td>"+c_packagescode+"</td>"+
					"<td>"+c_expirydate+"</td>"+
					"<td>"+
					"<a class=\"btn btn-success\" onclick=\"grdg(this)\" data-toggle='modal' href='#details' role='button' title=\"变更套餐\">"+
					"<i class=\"icon-exchange\"></i>"+
					"</a>"+
					"<a class=\"btn btn-success\" onclick=\"tuiding(this)\" title=\"退订套餐\">"+
					"<span class=\"\">退</span>"+
					"</a>"+
					"</td>"+
					"</tr>"
		}
		$("tbody").html(str);
}
function getSchoolById(id){
	
	for (var int = 0; int < schoolList.length; int++) {
		var sid = schoolList[int].cSid;
		if(sid==id){
			return schoolList[int];
		}
	}

}
function getPackageById(id){
	
	for (var int = 0; int < packageList.length; int++) {
		var sid = packageList[int].packageCode;
		if(sid==id){
			return packageList[int];
		}
	}
	
}
function gd(){
	ishs=false;
	$("#pldg").removeAttr("data-toggle");
	$("#pldg").removeAttr("href");
}
function tuiding(s){
	
	
	ischool.layout.confirm("退订确认","您确定要退订所选用户的套餐吗？",function(){
		var   gettype=Object.prototype.toString
		
		var sj=(gettype.call(s)=="[object Object]")?s.idMobile:$(s).parent().parent().find("input").val();
		$.ajaxSeentao($.getRootPath()+"/orderpackage/gxOrderPackage.rest",sj,function(json){
			
			if(json.code===1){

//				var obj = json.data;
//				console.log(obj);
				ischool.layout.success("退订成功",0);
				
			}else{
				ischool.layout.error(json.errorMessage,2000);
			}
			
		});

	})
}
function dinggou(s){
	
	
	ischool.layout.confirm("订购确认","您确定要为所选用户的订购此套餐吗？",function(){
		var   gettype=Object.prototype.toString
		
		var sj=(gettype.call(s)=="[object Object]")?s.idMobile:$(s).parent().parent().find("input").val();
		
		var packageX=$("#packageX").val();
		var packageX=$("#packageX").val();
		var packageU=getPackageById(packageX);
		var hasTerm = packageU.hasTerm;
		var time = $("#time1").val();
		if(hasTerm==0){
			time='0';
			
		}
		ob=null;
		sj=sj+":"+packageX+";"+time;
		$.ajaxSeentao($.getRootPath()+"/orderpackage/gxOrderPackage.rest",sj,function(json){
			
			if(json.code===1){
				var obj = json.data;
				if(!obj){
					obj='订购成功';
				}

				ischool.layout.success(obj,0);
				$("#xxx1").click();
				
			}else{
				ischool.layout.error(json.errorMessage,2000);
			}
			
		});
		
	})
}
function grdg(s){
	ob=s;
}