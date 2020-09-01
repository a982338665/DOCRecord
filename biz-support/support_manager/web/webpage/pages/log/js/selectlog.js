$(function(){


	$("#main-nav").load($.DEFINE_URL.HTML_LeftINDEX,function(){
		$("header").load($.DEFINE_URL.HTML_HeaderINDEX,function(){
			$("#yhxxgl").addClass("in");
			// $("#yhglxt").addClass("active");
			// $("#xtrzcx").addClass("active");
		});

	});
	// getUserLog("");
	// $("#cx").click(function(){
	// 	var userName=$("#inputText1").val();
    //
	// 	if(!userName || ''==userName){
	// 		ischool.layout.error("用户名不能为空",2000);
	// 		return;
	// 	}
	// 	getUserLog(userName);
	// });
});




// function getUserLog(userName){
// 	$.ajaxSeentao($.getRootPath()+"/audit/getUserAudit.rest",userName,function(json){
// 		if(json.code===1){
// 			ischool.layout.hide();
// 			var obj = JSON.parse(json.data);
// 			var time="";
// 			var value="";
// 			console.log(obj);
// 			var strn;
// 			for(var i=0;i<obj.length;i++){
// 				value=obj[i].operationContent;
// 				value=value.length>8?(value.substring(0,8)+"..."):value;
// 				time=timeCon2(obj[i].operationTime);
// 				strn += "<tr>" +
// 						"<td>"+obj[i].userName+"</td>" +
// 						"<td>"+obj[i].operationType+"</td>" +
// 						"<td>"+time+"</td>" +
// 						"<td title='"+obj[i].operationContent+"'>"+value+"</td>" +
// 						"</tr>"
// 			}
// 			$("tbody").html(strn);
// 		}else{
// 			ischool.layout.error(json.errorMessage,2000);
// 		}
// 	});
// }