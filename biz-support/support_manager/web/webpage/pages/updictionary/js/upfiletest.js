$(function(){
	var fileList;
	$(document).on({ 
        dragleave:function(e){    //拖离 
            e.preventDefault(); 
        }, 
        drop:function(e){  //拖后放 
            e.preventDefault(); 
        }, 
        dragenter:function(e){    //拖进 
            e.preventDefault(); 
        }, 
        dragover:function(e){    //拖来拖去 
            e.preventDefault(); 
        } 
    }); 
	 var box = document.getElementById('drop_area'); //拖拽区域 
	    box.addEventListener("drop",function(e){ 
	        e.preventDefault(); //取消默认浏览器拖拽效果 
	        fileList = e.dataTransfer.files; //获取文件对象 
	        //检测是否是拖拽文件到页面的操作 
	        if(fileList.length == 0){ 
	            return false; 
	        } 
	        //检测文件是不是图片 
//	        if(fileList[0].type.indexOf('image') === -1){ 
//	            alert("您拖的不是图片！"); 
//	            return false; 
//	        } 
	         
	        //拖拉图片到浏览器，可以实现预览功能 
//	        var img = window.webkitURL.createObjectURL(fileList[0]);
	        var str="";
	        for(var i=0;i<fileList.length;i++){
	        	 var filename = fileList[i].name; //图片名称 
	 	        var filesize = Math.floor((fileList[i].size)/1024);  
	 	       console.log(fileList[i]);
	 	       
	 	         str += "<p>第"+(i+1)+"个文件名称："+filename+"&nbsp大小："+filesize+"KB&nbsp&nbsp&nbsp<span id='isNot"+i+"'></span></p>"; 
	        }
	        
	        
	       
	        $("#preview").html(str); 
	         
	        //上传 
//	        xhr = new XMLHttpRequest(); 
//	        xhr.open("post", "upload.php", true); 
//	        xhr.setRequestHeader("X-Requested-With", "XMLHttpRequest"); 
//	         
//	        var fd = new FormData(); 
//	        fd.append('mypic', fileList[0]); 
//	             
//	        xhr.send(fd); 
	    },false); 
	    
	$("#upFile").click(function(){
		if(fileList.length == 0){ 
            return false; 
        }
		currentIndex=0;
		toServer();
		
		
	});
	var currentIndex=0;
	function toServer(){
		if(currentIndex>=fileList.length){
			return;
		}
		var filename = fileList[currentIndex].name; 
		var formData = new FormData();
		
		formData.append("file",fileList[currentIndex]);
		formData.append("name",filename);
		$.ajax({ 
			url : $.getRootPath()+"/upLoad/upLoadFile.rest", 
			type : 'POST', 
			data : formData, 
			// 告诉jQuery不要去处理发送的数据
			processData : false, 
			// 告诉jQuery不要去设置Content-Type请求头
			contentType : false,
			beforeSend:function(){
			console.log("正在进行，请稍候");
			$("#isNot"+currentIndex).text("正在进行，请稍候");
			$("#isNot"+currentIndex).css("color","red");
			},
			success : function(responseStr) { 
				
				if(responseStr.code===1){
				console.log("成功"+$("#isNot"+currentIndex));
				
				$("#isNot"+currentIndex).text("上传成功")
				}else{
				console.log("失败");
				$("#isNot"+currentIndex).text("失败,失败原因："+responseStr.errorMessage);
				
				}
				currentIndex++
				toServer();
			}, 
			error : function(responseStr) { 
			console.log("error");
			} 
			});
	}
})