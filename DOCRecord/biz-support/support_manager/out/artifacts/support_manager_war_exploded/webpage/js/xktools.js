var ischool = {};
+function($){
	/**
	AJAX 封装
	$.ajaxSeentao("/user/addUsser", {},function(json){},{type:"get",async:false})
	ajaxSeentao   -->  ajaxSeentao
	*/
	ischool.layout =
    {
        ccallback: (function () { }),
        init: function (opts)
        {
            if (typeof opts.title == "undefined") opts.title = "消息提示";
            if (typeof opts.content == "undefined") opts.content = "";
            if (typeof opts.width != "number") opts.width = "500";
            if (typeof opts.height != "number") opts.height = "580";
            if (typeof opts.callback != "function") opts.callback = (function () { });
            if (typeof opts.cancelcallback != "function") opts.cancelcallback = (function () { });
            if (typeof opts.surebuttonname == "undefined") opts.surebuttonname = "确定";
            if (typeof opts.isshowbutton == "undefined") opts.isshowbutton =true;

            ischool.layout.ccallback = opts.cancelcallback; 
            var html = "<div style=\" \" id=\"globallayoutbg\"></div><div id=\"globallayout\"  style='width:" + opts.width + "px'>" +
                  "<div class='globallayout_title'><span title='关闭'  id='globallayout_close'>X</span><h1 id='globallayout_title'>" + opts.title + "</h1></div>" +
                  "<div id='globallayout_infocontent'><div class='globallayout_content' id='globallayout_infocontent_content' style='max-height: "+opts.height+"px; overflow-y: auto'>" + opts.content + "</div>";
            //if (opts.isshowbutton) {
                html = html + "<div class='globallayout_footer'><button type=\"button\" class=\"btn\"  id=\"globallayoutcancelbtn\">取消</button><button type=\"button\" class=\"btn btn-success\" id='globallayoutsavebtn'>" + opts.surebuttonname + "</button></div>";
           // }
            html = html + " </div>";
                  html=html+ "<div id='globallayout_infomessage'><div class='globallayout_content ajax'></div>";
                  html = html + "<div class='globallayout_footer'><button type=\"button\" class=\"btn btn-default\" onclick=\"ischool.layout.hide()\">取消</button><button type=\"button\" class=\"btn btn-success\" id='globallayoutalertsurebutton'>确定</button></div>";
                  html = html + " </div>";
            //console.log(html);
            if (!document.getElementById("globallayout"))
            {
                $("body").append(html);
            }
            else
            {
                $("#globallayout_title").html(opts.title);
                $("#globallayout_infocontent_content").html(opts.content);
            }
            $("#globallayout").width( opts.width );
            if(opts.isshowbutton)
            {
                $("#globallayout_infocontent").find(".globallayout_footer").show();
                $("#globallayoutsavebtn").show();
                $("#globallayoutsavebtn").html(opts.surebuttonname);
            }
            else
            {$("#globallayout_infocontent").find(".globallayout_footer").hide();}

            $("#globallayout_infomessage").css("display", "none");
            $("#globallayout_infocontent").css("display", "block");
            $("#globallayout_close").css("display", "block");
           
            $("#globallayoutbg").height($(document).height());
              var top = ( ( 
                  $(window).height() -$("#globallayout").height())/2 + $(document).scrollTop());
              if (top < 0)
                  top = 10;
            $("#globallayout").css("top", top + "px");

            $("#globallayout").css("left", ($(document).width() / 2 - $("#globallayout").width() / 2) + "px");
            $("#globallayoutbg").fadeIn("slow");
            $("#globallayout").fadeIn("slow");
            $("#globallayout_close").unbind();
            $("#globallayout_close").bind("click", function () { opts.cancelcallback(); ischool.layout.hide(); });
            $("#globallayoutcancelbtn").unbind();
            $("#globallayoutcancelbtn").bind("click", function () { opts.cancelcallback(); ischool.layout.hide(); });
            $("#globallayoutsavebtn").unbind();
            $("#globallayoutsavebtn").bind("click", function () { opts.callback(); });
            $("#globallayoutalertsurebutton").unbind();
            $("#globallayoutalertsurebutton").bind("click", function () { ischool.layout.hide()});
        },
        messageinit: function (title)
        {
            if (!document.getElementById("globallayout")) {
                if (typeof title == "undefined") title = "消息提示";
                ischool.layout.init({ title: title });
            }
            else {
                $("#globallayout").width(500);
            }
            $("#globallayout_title").html(title);
            $("#globallayoutbg").height($(document).height());
            var top = (($(window).height() - $("#globallayout").height()) / 2 + $(document).scrollTop());
            if (top < 0)
                top = 10;
            $("#globallayout").css("top", top + "px");
            $("#globallayout").css("left", ($(document).width() / 2 - $("#globallayout").width() / 2) + "px");

            $("#globallayout").fadeIn("slow");
            $("#globallayoutbg").fadeIn("slow");
            $("#globallayout_close").css("display", "none");
            $("#globallayout_infomessage").css("display", "block");
            $("#globallayout_infomessage").find(".globallayout_footer").css("display", "block");
            $("#globallayout_infocontent").css("display", "none");
            $("#globallayout_infomessage").find(".globallayout_content").removeClass("ajax");
            $("#globallayout_infomessage").find(".globallayout_content").removeClass("error");
            $("#globallayout_infomessage").find(".globallayout_content").removeClass("ok");
            $("#globallayout_infomessage").find(".globallayout_content").removeClass("info");
            $("#globallayout_infomessage").find(".globallayout_footer").find("button").eq(0).css("display", "none");

        },
        loadding: function (message)
        {
            if (typeof message == "undefined") message = "加载数据中。。。";
            ischool.layout.messageinit("消息提示");

            $("#globallayout_infomessage").find(".globallayout_content").addClass("ajax");
            $("#globallayout_infomessage").find(".globallayout_content").html("" + message);
            $("#globallayout_infomessage").find(".globallayout_footer").css("display", "none");
        },
        success: function (message, url)
        {
            if (typeof message == "undefined") message = "操作成功";
            ischool.layout.messageinit("消息提示");
            $("#globallayout_infomessage").find(".globallayout_content").addClass("ok");
            $("#globallayout_infomessage").find(".globallayout_content").html("" + message);
            $("#globallayoutalertsurebutton").unbind();
            $("#globallayoutalertsurebutton").bind("click", function () { ischool.layout.hide() });
            url = url || 2000;
            if (typeof url=="number")
                setTimeout(ischool.layout.hide, url);
            else
                location.href = url;
        },
        error: function (message, autodisplay)
        {
            if (typeof message == "undefined") message = "操作异常";
            ischool.layout.messageinit("消息提示");
      
            $("#globallayout_infomessage").find(".globallayout_content").addClass("error");
            $("#globallayout_infomessage").find(".globallayout_content").html("" + message);
            $("#globallayoutalertsurebutton").unbind();
            $("#globallayoutalertsurebutton").bind("click", function () {  ischool.layout.hide() });
            if (typeof autodisplay == "number") {
                //autodisplay = 5000;
                setTimeout(ischool.layout.hide, autodisplay);
            }
        },
        alert: function (title, message, callback,autodisplay)
        {
            if (typeof message == "undefined") message = "";
            ischool.layout.messageinit(title);
            $("#globallayout_infomessage").find(".globallayout_content").addClass("info");
            $("#globallayout_infomessage").find(".globallayout_content").html(message);
            //$("#globallayout_infomessage").find(".globallayout_footer").find("button").eq(0).css("display", "");
            $("#globallayoutalertsurebutton").unbind();
            if (typeof callback != "function") callback = (function () { ischool.layout.hide(); });
            $("#globallayoutalertsurebutton").bind("click", function () { ischool.layout.hide(); callback(); });
            if (typeof autodisplay == "number") {
                //autodisplay = 5000;
                setTimeout(ischool.layout.hide, autodisplay);
            }
        },
        confirm: function (title, message, callback) {
            if (typeof message == "undefined") message = "";
            if (typeof title == "function") title='提示';
            if (typeof message == "function") message='';
            ischool.layout.messageinit(title);
            $("#globallayout_infomessage").find(".globallayout_content").addClass("info");
            $("#globallayout_infomessage").find(".globallayout_content").html(message);
            $("#globallayout_infomessage").find(".globallayout_footer").find("button").eq(0).css("display", "");
            $("#globallayoutalertsurebutton").unbind();
            if (typeof callback != "function") callback = (function () { ischool.layout.hide();});
            $("#globallayoutalertsurebutton").bind("click", function () { ischool.layout.hide(); callback();});
        },
        hide: function ()
        {
            $("#globallayout").fadeOut("slow");
            $("#globallayoutbg").fadeOut("slow");
            
        }
    }
	$.ajaxSeentao = function(url,parameter,callback,config){
		if(!url) return;

		var async = (config&&config.async===false)?false:true,
			timeoutID,loadingID;
		if($.isFunction(parameter)){
			callback =parameter;
			config =callback;
		}
		if(!config||config.mask!==false){
//			loadingID = $.showLoadingIcon();
			ischool.layout.loadding("加载中...");
		}
		$.ajax({
			type: (config&&config.type)||"post",
			async:async,
			url: url,
			data:parameter||{},
//			dataType: "json",
			contentType:"application/json",
			success: function(data) {
				if(!config||config.mask!==false){
//					$.clearLoadingIcon(loadingID);
//					ischool.layout.hide();
				}
				if($.isFunction(callback)){
					callback(data);
				}
			},
			error:function(XMLHttpRequest, textStatus, errorThrown){
				$.clearLoadingIcon(loadingID);
			}
		});

	}
	$.jsonToString = function(jsonObj){
		var jStr = "{";
	    for(var item in jsonObj){
	        jStr += "\""+item+"\":\""+jsonObj[item]+"\",";
	    }
	    var s=jStr.substring(0,jStr.length-1);
	    
	    s += "}";
	    return s;
	}
	/**
	 * //获取当前项目根路径
	 * @return {TypeName} 
	 */
	$.getRootPath= function getRootPath(){    
			//获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp    
			var curWwwPath=window.document.location.href;    
			//获取主机地址之后的目录，如： uimcardprj/share/meun.jsp    
			var pathName=window.document.location.pathname;    
			var pos=curWwwPath.indexOf(pathName);    
			//获取主机地址，如： http://localhost:8083    
			var localhostPaht=curWwwPath.substring(0,pos);    
			//获取带"/"的项目名，如：/uimcardprj    
			var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);    
			return(localhostPaht+projectName);
	}




	
}(jQuery);
