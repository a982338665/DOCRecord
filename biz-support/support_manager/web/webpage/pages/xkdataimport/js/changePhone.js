

$(function(){
	$("#main-nav").load($.getRootPath()+"/webpage/pages/left/left.html",function(){
		$("header").load($.getRootPath()+"/webpage/pages/top/header.html",function(){
			$("#yhxxglzk").addClass("in");
			$("#yhxxgl").addClass("active");
			$("#drxxjs").addClass("active");			
		});

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

    $("#sub").click(function(){
        var oldPhone=$("#oldPhone").val();
        var phone=$("#phone").val();
        if(oldPhone && oldPhone!=''
            &&phone!=''&&phone.length==11&&phone){
            var s=$("#fun").searchFormatSeentao();
            var sj = $.jsonToString(s);

            $.ajaxSeentao($.getRootPath()+"/xkUser/changePhone.rest",sj,function(json){

                if(json.code===1){

					// alert(json.data);
                    ischool.layout.success(json.data,$.getRootPath()+'/webpage/pages/xkdataimport/changePhone.html');

                }else{
                    ischool.layout.error(json.errorMessage,2000);
                }

            });
        }else{
            ischool.layout.error("缺少必要字段或填写内容不正确",2000);
        }

    });
	function downloadFile(url,fileName){
		var a = document.createElement('a');
		a.href= url;
		a.download = fileName;
		a.click();
		a=null;
	}
});
