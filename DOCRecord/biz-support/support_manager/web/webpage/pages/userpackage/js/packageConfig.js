$(function(){
	$("#main-nav").load($.getRootPath()+"/webpage/pages/left/left.html",function(){
		$("header").load($.getRootPath()+"/webpage/pages/top/header.html",function(){
			$("#tcglzk").addClass("in");
			$("#tcgl").addClass("active");
			$("#tcpzgl").addClass("active");			
		});

	});
	
	$("#newPackage").click(function(){
		window.location.href="packageEidt.html";
		
	});
	$.ajaxSeentao($.getRootPath()+"/packagemgr/packagemgrlist.rest",function(json){
			ischool.layout.hide();
			console.log(json);
			var tc ='';
			for (var int = 0; int < json.length; int++) {
				var packageDesc = json[int].packageDesc;
				var packageType = json[int].packageType;
				
				if(!packageDesc){
					packageDesc="";
				}
				var packageTypeN='';
				if(packageType===1){
					packageTypeN='普通套餐';
				}else if(packageType===2){
					packageTypeN='体验套餐';
				}
				
				tc += '<tr>'+
				'<td>'+json[int].packageCode+'</td>'+
				'<td>'+json[int].packageName+'</td>'+
				'<td>'+packageTypeN+'</td>'+
				'<td>'+json[int].packagePrice+'</td>'+
				'<td>'+packageDesc+'</td>'+
				'<td>'+
				'<a onclick=\'getTcById("'+
				json[int].packageId+'")\' class="btn btn-success" data-toggle="modal" href="#details" role="button" title="查看详情">'+
				'<i class="icon-align-left"></i>'+
				'</a>'+
				'<a class="btn btn-success" href="'+
				$.getRootPath()+'/webpage/pages/userpackage/packageEidt.html?packageId='+
				json[int].packageId+'" title="编辑">'+
				'<i class="icon-edit"></i>'+
				'</a>'+
				'<a onclick=\'removeTc("'+
				json[int].packageId+'","'+json[int].packageCode + '")\' class="btn btn-danger"  title="删除">'+
				'<i class="icon-remove"></i>'+
				'</a>'+
				'</td>'+
				'</tr>';
			}
			
//			console.log(tc);

			$("tbody").html(tc);
			

	});
	
})
function getTcById(id){
//	console.log(id);
	$.ajaxSeentao($.getRootPath()+"/packagemgr/packagemgrfunctionlist.rest ",'{"packageId":"'+id+'"}' ,function(json){
		if(json.code===1){
			ischool.layout.hide();
			var obj = JSON.parse(json.data);

//			
//			console.log(obj);
//			
			$("#packageName").text(obj.packageName);
			$("#packagePrice").text(obj.packagePrice);
			$("#packageDesc").text(obj.packageDesc);
			$("#validation_select").val(obj.hasTerm);
			
			var fun = obj.moFunctionBeans;
//			console.log(fun);
			var funct='';
			for (var i = 0; i < fun.length; i++) {
				funct+='<p>'+fun[i].functionName+'</p>';
			}
			$("#fun").html(funct);
		}else{
			ischool.layout.error(json.errorMessage,2000);
		}
	});
}
function removeTc(id,code){
	//console.log(id+'');
	ischool.layout.confirm("删除确认","您确实要删除套餐编码为：【" + code +"】的套餐吗？",function(){
		$.ajaxSeentao($.getRootPath()+"/packagemgr/packagemgrdel.rest?packageId="+id,function(json){
			if(json.code===1){
				ischool.layout.success("删除成功");
				location.reload(true);
			}else{
				ischool.layout.error(json.errorMessage,2000);
			}
		},{"type":"get","async":true});
	},id)
	
}

