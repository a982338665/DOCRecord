$(function(){
	
	$("#main-nav").load($.getRootPath()+"/webpage/pages/left/left.html",function(){
		$("header").load($.getRootPath()+"/webpage/pages/top/header.html",function(){
			$("#yhxxglzk").addClass("in");
			$("#yhxxgl").addClass("active");
			$("#rjxxgl").addClass("active");
		});

	});
	
	$("#getUsers").click(function(){
		var name=$("#inputText1").val();
		if(''==name){
			ischool.layout.alert("警告","请输入查询内容！");
			return;
		}
		$.ajaxSeentao($.getRootPath()+"/teachMber/getBasicTeachr.rest", name,function(json){
			if(json.code===1){
				ischool.layout.hide();
				var obj = JSON.parse(json.data);
				console.log(obj);
				var strn;
				for(var i=0;i<obj.length;i++){
					strn += "<tr>" +
							"<td>"+obj[i].loginName+"</td>" +
							"<td>"+obj[i].iinumber+"</td>" +
							"<td>"+obj[i].teacherName+"</td>" +
							"<td>"+obj[i].mobile+"</td>" +
							"<td>"+obj[i].roleName+"</td>" +
							"<td>"+obj[i].schoolName+"</td>" +
							"<td><a data-teacherid='"+obj[i].teacherId+
							"' data-schoolid='"+obj[i].schoolId+
							"' data-teachername='"+obj[i].teacherName+
							"' class='btn' href='#' " +
							"onclick=\"$(this).attr('href','addTeach.html?teacherId='+$(this).data('teacherid')" +
							"+'&schoolId='+$(this).data('schoolid')" +
							"+'&teacherName='+$(this).data('teachername')" +
							")\">" +
							"任教信息</a>" +
							"</tr>"
				} 
				$("tbody").html(strn);
			}else{
				ischool.layout.error(json.errorMessage,2000);
			}
		});
	});
	
});

