$(function(){
	$("#main-nav").load($.getRootPath()+"/webpage/pages/left/left.html",function(){
		$("header").load($.getRootPath()+"/webpage/pages/top/header.html",function(){
			$("#tcglzk").addClass("in");
			$("#tcgl").addClass("active");
			$("#pzgngl").addClass("active");			
		});

	});
	$.ajaxSeentao($.getRootPath()+"/packagemgr/functionmgrlist.rest",function(json){

			ischool.layout.hide();

			var strn;
			for(var i=0;i<json.length;i++){
				var platform = json[i].platform;
				var platformName='';
				if(platform===1){
					platformName='手机端';
				}else if(platform===2){
					platformName='电脑端';
				}
				var functionDesc = json[i].functionDesc;
				if(!functionDesc){
					functionDesc='';
				}
				strn += "<tr>" +
						"<td>"+platformName+"</td>" +
						/*"<td>"+json[i].moduleName+"</td>" +*/
						"<td>"+json[i].functionName+"</td>" +
						"<td>"+functionDesc+"</td>" +
						"<td>"+
						"<a onclick='getTcById(\""+
				json[i].functionId+"\")\' class=\"btn btn-success\" data-toggle='modal' href='#details' role='button' title=\"查看详情\">" +
						"<i class=\"icon-align-left\"></i></a>" +
						"<a class=\"btn btn-success\" href=\""+
						$.getRootPath()+'/webpage/pages/userpackage/functionEidt.html?functionId='+
						json[i].functionId+
						"\" title=\"编辑\">" +
						"<i class=\"icon-edit\"></i></a>"+"</tr>"
			}
			$("tbody").html(strn);

	});
	
})
function getTcById(id){
//	console.log(id);
	$.ajaxSeentao($.getRootPath()+"/packagemgr/functionmgrview.rest ",'{"functionId":"'+id+'"}' ,function(json){
		if(json.code===1){
			ischool.layout.hide();
			var obj = JSON.parse(json.data);

//			
//			console.log(obj);
			var platform = obj.platform;
			var platformName='';
			if(platform===1){
				platformName='手机端';
			}else if(platform===2){
				platformName='电脑端';
			}
			var functionDesc = obj.functionDesc;
			if(!functionDesc){
				functionDesc='';
			}
			var functionDetail = obj.functionDetail;
			if(!functionDetail){
				functionDetail='';
			}
			$("#functionName").text(obj.functionName);
			$("#platformName").text(platformName);
			$("#functionDesc").text(functionDesc);
			$("#functionDetail").text(functionDetail);

		}else{
			ischool.layout.error(json.errorMessage,2000);
		}
	});
}
