$(function(){
	
	$("#main-nav").load($.getRootPath()+"/webpage/pages/left/left.html",function(){
		$("header").load($.getRootPath()+"/webpage/pages/top/header.html",function(){
			$("#yhglzk").addClass("in");
			$("#yhglxt").addClass("active");
			$("#ptyhgl").addClass("active");
		});

	});
	
	$("#getUsers").click(function(){
		var name=$("#inputText1").val();
		if(''==name){
			ischool.layout.alert("警告","请输入查询内容！");
			return;
		}
		$.ajaxSeentao($.getRootPath()+"/user/getUsers.rest", name,function(json){
			if(json.code===1){
				ischool.layout.hide();
				var obj = JSON.parse(json.data);
				console.log(obj);
				var strn;
				for(var i=0;i<obj.length;i++){
					strn += "<tr>" +
							"<td>"+obj[i].full_name+"</td>" +
							"<td>"+obj[i].login_name+"</td>" +
							"<td><a data-id='"+obj[i].id+"' class='btn' href='#' onclick=\"$(this).attr('href','updateuser.html?id='+$(this).data('id'))\">用户设置</a>" +
							"<a onclick=\"removeUser($(this).data('id'))\" data-id='"+obj[i].id+"' class='btn' href='#'>删除用户</a></td>" +
							"</tr>"
				}
				$("tbody").html(strn);
			}else{
				ischool.layout.error(json.errorMessage,2000);
			}
		});
	});
	
});
function removeUser(id){
	console.log(id+'');
	$.ajaxSeentao($.getRootPath()+"/user/removeUser.rest",id+'',function(json){
		if(json.code===1){
			ischool.layout.success("删除成功");
		}else{
			ischool.layout.error(json.errorMessage,2000);
		}
	});
}
