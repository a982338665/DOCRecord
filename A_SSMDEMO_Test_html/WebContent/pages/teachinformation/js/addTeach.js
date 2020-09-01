$(function(){
	var gradeIds='';
	$("#main-nav").load($.getRootPath()+"/webpage/pages/left/left.html",function(){
		$("header").load($.getRootPath()+"/webpage/pages/top/header.html",function(){
			$("#yhxxglzk").addClass("in");
			$("#yhxxgl").addClass("active");
			$("#rjxxgl").addClass("active");
		});

	});
	$.ajaxSeentao($.getRootPath()+"/teachMber/getKcodeInform.rest",function(json){
		if(json.code===1){
			ischool.layout.hide();
			
			var obj = JSON.parse(json.data);
			console.log(obj);
			var str="<option value='-0'>选择科目</option>";
			for(var i=0 ; i<obj.length;i++){
				str+= "<option value='"+obj[i].t_code+"'>"+obj[i].xk_name+"</option>";
			}
			$("#kemu").html(str);
		}else{
			ischool.layout.error(json.errorMessage,2000);
		}
		
	});
	$.ajaxSeentao($.getRootPath()+"/teachMber/getSchoolStage.rest",$.getUrlSearch("schoolId"),function(json){
		
			if(json.code===1){
				ischool.layout.hide();
				
				var obj = JSON.parse(json.data);
				console.log(obj);
				var str="<option value='-0'>选择学段</option>";
				for(var i=0 ; i<obj.length;i++){
					str+= "<option value='"+obj[i].xk_code+"'>"+obj[i].xk_name+"</option>";
				}
				$("#xueduan").html(str);
			}else{
				ischool.layout.error(json.errorMessage,2000);
			}
		
	});
	
	$("#xueduan").change(function(){
		var xueduan=$("#xueduan").val();
		if(xueduan=="0"){
			return;
		}else{
			var json={};
			json["schoolId"]=$.getUrlSearch("schoolId");
			json["xueduan"]=xueduan;
			var string=JSON.stringify(json);
			console.log(string+'');
			$.ajaxSeentao($.getRootPath()+"/teachMber/getSchoolgrade.rest",string,function(json){
				
				if(json.code===1){
					ischool.layout.hide();
					
					var obj = JSON.parse(json.data);
					console.log(obj);
					var str="<option value='-0'>选择年级</option>";
					for(var i=0 ; i<obj.length;i++){
						str+= "<option value='"+obj[i].C_GRADENUM+"'>"+obj[i].C_GRADENAME+"</option>";
					}
					$("#glass").html(str);
				}else{
					ischool.layout.error(json.errorMessage,2000);
				}
				
			});
		}
		
	});
	$("#glass").change(function(){
		var gradeId=$("#glass").val();
		if(gradeId=="-0"){
			return;
		}else{
			var json={};
			json["schoolId"]=$.getUrlSearch("schoolId");
			json["xueduan"]=$("#xueduan").val();
			json["gradeId"]=gradeId;
			var string = JSON.stringify(json);
			console.log(string+'');
			$.ajaxSeentao($.getRootPath()+"/teachMber/getSchoolClass.rest",string,function(json){
				
					if(json.code===1){
						ischool.layout.hide();
						
						var obj = JSON.parse(json.data);
						console.log(obj);
						gradeIds=obj[0].C_GRADEID;
						var str="<option value='0'>选择班级</option>";
						for(var i=0 ; i<obj.length;i++){
							str+= "<option value='"+obj[i].C_CLASSID+"'>"+obj[i].C_CLASSNAME+"</option>";
						}
						$("#clazz").html(str);
					}else{
						ischool.layout.error(json.errorMessage,2000);
					}
				
			});
		}
	});
	
	$("#tianjia").click(function(){
		
		
		
		var gradeId=gradeIds;
		var select = document.getElementById("glass");
		var index=select.selectedIndex;
		var options = select.options;
		var gradeName = options[index].text;
		
		var classId=$("#clazz").val();
		var tCode=$("#kemu").val();
		var schoolId=$.getUrlSearch("schoolId");
		var teacherId=$.getUrlSearch("teacherId");
		var teacherName=$.getUrlSearch("teacherName");
		
		if(gradeId=='-0' || classId=='0' || tCode=='-0'){
			ischool.layout.alert("警告","必须选择学段、年级、班级、科目");
		}
		var json={};
		json["gradeId"]=gradeId;
		json["gradeName"]=gradeName;
		json["classId"]=classId;
		json["tCode"]=tCode;
		json["schoolId"]=schoolId;
		json["teacherId"]=teacherId;
		json["teacherName"]=teacherName;
		
		var string=JSON.stringify(json);
		console.log(string+'');
		
		$.ajaxSeentao($.getRootPath()+"/teachMber/addTeachMber.rest",string,function(json){
			if(json.code===1){
				ischool.layout.success("添加成功！");
				window.location.reload();
			}else{
				ischool.layout.error(json.errorMessage,2000);
			}
		});
	});
	
	
	
	
	$("#teacherName").text($.getUrlSearch("teacherName")+"教师");
	
		$.ajaxSeentao($.getRootPath()+"/teachMber/getTeachMber.rest", $.getUrlSearch("teacherId"),function(json){
			if(json.code===1){
				ischool.layout.hide();
				var obj = JSON.parse(json.data);
				console.log(obj);
				var strn;
				for(var i=0;i<obj.length;i++){
					strn += "<tr>" +
							"<td>"+obj[i].gradeName+"</td>" +
							"<td>"+obj[i].className+"</td>" +
							"<td>"+obj[i].kcname+"</td>" +
							"<td>"+obj[i].c_versionId+"</td>" +
							
							"<td> <a " +
							"data-teachermberid='"+obj[i].teacherMberId+"' " +
							"data-classid='"+obj[i].classId+"' " +
									"class='btn' href='#' " +
							"onclick=\"removeUser(this)\">" +
							"删除</a>" +
							"</tr>"
				} 
				$("tbody").html(strn);
			}else{
				ischool.layout.error(json.errorMessage,2000);
			}
		});
	});

	
function removeUser(thzs){
	var teacherMberId=$(thzs).data("teachermberid");
	var classId=$(thzs).data("classid");
	console.log(teacherMberId+'');
	var json={};
	json["teacherMberId"]=teacherMberId;
	json["classId"]=classId;
	json["teacherId"]=$.getUrlSearch("teacherId");
	var string=JSON.stringify(json);
	console.log(string+'');
	$.ajaxSeentao($.getRootPath()+"/teachMber/deleteteachMber.rest",string,function(json){
		if(json.code===1){
			ischool.layout.success("删除成功");
			window.location.reload();
		}else{
			ischool.layout.error(json.errorMessage,2000);
		}
	});
}
