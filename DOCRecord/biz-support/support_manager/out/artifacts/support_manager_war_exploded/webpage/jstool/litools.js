var ischool = {};
+function($){
	/**
	AJAX 封装
	$.ajaxSeentao("/user/addUsser", {},function(json){},{type:"get",async:false})
	ajaxSeentao   -->  ajaxSeentao
	*/


    /**
     * 二进制流处理ajax--接收
     * method --- 请求方式
     * url    --- 请求路径
     * idname --- 要在页面上展示的img 的id 如：var img= $("#img_id");
     * 若idname=="" 则追加
     */

    $.ajaxIO=function (method,url,idname) {
        var xmlhttp;
        xmlhttp = new XMLHttpRequest();
        xmlhttp.open(method, url, true);
        xmlhttp.responseType = "blob";
        xmlhttp.onload = function () {
            console.log(this);
            if (this.status == 200) {
                var blob = this.response;
                var img= $(idname);
                // var img = document.createElement("img");
                img.onload = function (e) {
                    window.URL.revokeObjectURL(img.src);
                };
                $(idname).attr("src", url);
                // img.src = window.URL.createObjectURL(blob);
                // document.body.appendChild(img);
            }
        }
        xmlhttp.send();
    }

    /**
     * ajax--二进制文件下载---
     * type为文件类型
     */
    $.ajaxFileDown=function (url,method,type) {
        // var url = 'download/?filename=aaa.txt';
        var xhr = new XMLHttpRequest();
        xhr.open(method, url, true);    // 也可以使用POST方式，根据接口
        xhr.responseType = "blob";  // 返回类型blob
        // 定义请求完成的处理函数，请求前也可以增加加载框/禁用下载按钮逻辑
        xhr.onload = function () {
            // 请求完成
            if (this.status === 200) {
                // 返回200
                var blob = this.response;
                var reader = new FileReader();
                reader.readAsDataURL(blob);  // 转换为base64，可以直接放入a表情href
                reader.onload = function (e) {
                    // 转换完成，创建一个a标签用于下载
                    var a = document.createElement('a');
                    a.download = 'data.'+type;
                    a.href = e.target.result;
                    $("body").append(a);  // 修复firefox中无法触发click
                    a.click();
                    $(a).remove();
                }
            }
        };
        // 发送ajax请求
        xhr.send()
    }



}(jQuery);
