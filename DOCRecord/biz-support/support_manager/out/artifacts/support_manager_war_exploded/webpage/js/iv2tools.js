/**
 * Created with JetBrains WebStorm. User: 吕欣 Date: 15-8-6 Time: 上午9:35
 * 10.12.1.10
 */
var ischool = {};
+function($){
    var isPad = (/(.*\bandroid\b.*)|((.*\bios\b.*))/ig).test(navigator.userAgent);
    
    if(typeof String.prototype.trim==="undefined"){
        String.prototype.trim = function(){
            return this.replace(/(^\s+)|(\s+$)/ig,"");
        }
    }

    // 获取屏幕PPI DPI
    $.getScreenDPI = function(){
       var tempDiv,
           _DPI;
        if(window.screen.deviceXDPI) {return  + window.screen.deviceXDPI};
        tempDiv = document.createElement("div")
        tempDiv.style.width = "1in";
        tempDiv.style.visibility = "hidden";
        tempDiv.style.position = "absolute";
        document.querySelector("body").appendChild(tempDiv);
        _DPI =tempDiv.offsetWidth;
        tempDiv.parentNode.removeChild(tempDiv);
        return  +_DPI;
    }

    // 把URL ?后面的参数序列化成对象
    $.parseUrlSearch = function(searchStr){
    	return JSON.parse("{"+(decodeURIComponent(searchStr||location.search)).replace(/([\?,&])([^\?,&]*)=([^\?,&]*)/ig,function(v,v1,v2,v3){return ",\""+v2+"\":\""+v3+"\""}).slice(1)+"}");
    }
    // 获取URL ?后面的参数
    $.getUrlSearch = function(key){
        return  $.parseUrlSearch()[key]||"";
    }
    // 日期格式化
    $.parseDate = function(_date,_format){
		var date,
			year,
			valueList;
		if(_date&&!isNaN(_date)){
			date= new Date(parseInt(_date,10));
		}else if(_date){
			if(/^(\d+)-(\d+)-(\d+)$/.test(_date.toString().trim())){
                 // 传入的不是毫秒数 兼容性待完善。。。
				// date = new Date();
			}
			date= new Date(parseInt(_date,10));
		}else{return "";}
		
		if(date.getFullYear&&(year = date.getFullYear())){
			valueList={
				"y":year,
				"m":(date.getMonth()|0)+1,
				"d":date.getDate(),
				"h":date.getHours(),
				"i":date.getMinutes(),
				"s":date.getSeconds()
			}
			if(_format){
				return _format.replace(/([y,m,d,h,i,s])/ig,function(v,v1){
					return valueList[v1.toLowerCase()]
				})
			}else{
				return year+"-"+((date.getMonth()|0)+1)+"-"+date.getDate()
			}
		}else{
			return "";
		}
	}


	// 文本框光标操作 获取光标
    $.fn.getTextPosition = function(){
    	var result = 0,
    		rng,obj; 
    	obj = this.get(0)||null;
    	if(!obj) return null;
    	if(typeof obj.value!=="undefined"&&obj.value.length===0){
    		return 0;
    	}
        if(obj.selectionStart){  
            result = obj.selectionStart 
        }else{ // IE
        	if(obj.tagName == "textarea"){ 
        	// TEXTAREA
            rng = event.srcElement.createTextRange(); 
            rng.moveToPoint(event.x,event.y); 
       	 }else{ // Text
            rng = document.selection.createRange(); 
        } 
            rng.moveStart("character",-event.srcElement.value.length); 
            result = rng.text.length; 
        } 
        return result; 
    }

	// 文本框光标操作 设置光标
    $.fn.setTextPosition = function(pos){
    	var _obj = this[0]||null,
    		_range;
    	if(!_obj){return;}
    	if(typeof _obj.value!=="undefined"&&_obj.value.length===0){
    		_obj.focus(); 
    	}
    	if(_obj.setSelectionRange){ 
			_obj.focus(); 
			_obj.setSelectionRange(pos,pos); 
		}else if (_obj.createTextRange){
	 		range = _obj.createTextRange(); 
	 		range.collapse(true); 
	 		range.moveEnd('character', pos);
	 		range.moveStart('character', pos); 
	  		range.select(); 
		}
		return this; 
    }


	/**
	 * AJAX 封装 $.ajaxSeentao("/user/addUsser",
	 * {},function(json){},{type:"get",async:false}) ajaxSeentao --> ajaxSeentao
	 */
    // 显示加载中 动画
// $.showLoadingIcon = function(){
// var global, //arguments.callee,
// timeTarg = +new Date();
// try{
// global = window.top.$;
// }catch(e){
// global = $;
// }
// global.progressList = global.progressList||{};
// global.progressList[timeTarg] = true;
// if(!global.mask){
// global("body").prepend((global.mask=global('<div class="st_loadMask"><div
// class="loader" ><div class="loader-inner
// ball-beat"><div></div><div></div><div></div></div></div>')));
// }
// return timeTarg;
// }
// //清除加载中 动画
// $.clearLoadingIcon = function(timeTarg){
// var global;// $.showLoadingIcon;
// try{
// global = window.top.$;
// }catch(e){
// global = $;
// }
// if(global.mask){
// if(global.progressList[timeTarg]){
// delete global.progressList[timeTarg];
// }
// if(Object.getOwnPropertyNames(global.progressList).length==0){
// global.mask.remove();
// global.mask = null;
// }
// }
// }
    
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
            // if (opts.isshowbutton) {
                html = html + "<div class='globallayout_footer'><button type=\"button\" class=\"btn\"  id=\"globallayoutcancelbtn\">取消</button><button type=\"button\" class=\"btn btn-success\" id='globallayoutsavebtn'>" + opts.surebuttonname + "</button></div>";
           // }
            html = html + " </div>";
                  html=html+ "<div id='globallayout_infomessage'><div class='globallayout_content ajax'></div>";
                  html = html + "<div class='globallayout_footer'><button type=\"button\" class=\"btn btn-default\" onclick=\"ischool.layout.hide()\">取消</button><button type=\"button\" class=\"btn btn-success\" id='globallayoutalertsurebutton'>确定</button></div>";
                  html = html + " </div>";
            // console.log(html);
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
                // autodisplay = 5000;
                setTimeout(ischool.layout.hide, autodisplay);
            }
        },
        alert: function (title, message, callback,autodisplay)
        {
            if (typeof message == "undefined") message = "";
            ischool.layout.messageinit(title);
            $("#globallayout_infomessage").find(".globallayout_content").addClass("info");
            $("#globallayout_infomessage").find(".globallayout_content").html(message);
            // $("#globallayout_infomessage").find(".globallayout_footer").find("button").eq(0).css("display",
			// "");
            $("#globallayoutalertsurebutton").unbind();
            if (typeof callback != "function") callback = (function () { ischool.layout.hide(); });
            $("#globallayoutalertsurebutton").bind("click", function () { ischool.layout.hide(); callback(); });
            if (typeof autodisplay == "number") {
                // autodisplay = 5000;
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
        confirm: function (title, message, callback,data) {
            if (typeof message == "undefined") message = "";
            if (typeof title == "function") title='提示';
            if (typeof message == "function") message='';
            ischool.layout.messageinit(title);
            $("#globallayout_infomessage").find(".globallayout_content").addClass("info");
            $("#globallayout_infomessage").find(".globallayout_content").html(message);
            $("#globallayout_infomessage").find(".globallayout_footer").find("button").eq(0).css("display", "");
            $("#globallayoutalertsurebutton").unbind();
            if (typeof callback != "function") callback = (function () { ischool.layout.hide();});
            $("#globallayoutalertsurebutton").bind("click", function () { ischool.layout.hide(); callback(data);});
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
			config =callback;
			callback =parameter;
			
		}
		if(!config||config.mask!==false){
// loadingID = $.showLoadingIcon();
			ischool.layout.loadding("加载中...");
		}
		$.ajax({
			type: (config&&config.type)||"post",
			async:async,
			url: url,
			data:parameter||{},
// dataType: "json",
			contentType:"application/json",
			success: function(data) {
				if(!config||config.mask!==false){
// $.clearLoadingIcon(loadingID);
// ischool.layout.hide();
				}
				if($.isFunction(callback)){
					callback(data);
				}
			},
			error:function(XMLHttpRequest, textStatus, errorThrown){
				ischool.layout.hide();
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
	 * 
	 * @return {TypeName}
	 */
	$.getRootPath= function getRootPath(){    
			// 获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
			var curWwwPath=window.document.location.href;    
			// 获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
			var pathName=window.document.location.pathname;    
			var pos=curWwwPath.indexOf(pathName);    
			// 获取主机地址，如： http://localhost:8083
			var localhostPaht=curWwwPath.substring(0,pos);    
			// 获取带"/"的项目名，如：/uimcardprj
			var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);    
			return(localhostPaht+projectName);
		}
	$.formatParSeentao = function(par,obj){
		var ret = {};
        var i ,len ,key,tempObj;
		if(!par) return {};
		if(typeof par==="string"||typeof par==="number") 
		{
			ret["flag"]=par;
			if(obj){
				for( key  in  obj){
                    key = key.replace(/-/ig,"%25%32%64");
					ret[key]=obj[key];
				}
			}
			return ret
		}
        if(Object.prototype.toString.call(par)==="[object Array]"){
           for(i=0,len =par.length;i<len;i++ ){
               for(key in par[i]){
                   key = key.replace(/-/ig,"%25%32%64");
                   ret["listMap["+i+"].inMap."+key]=par[i][key];
               }
           }
            return  ret;
        }
		for( key  in  par){
            key = key.replace(/-/ig,"%25%32%64");
			ret[key]=par[key];
		}
		return ret;
	}

	$.parseJsonSeentao = function(data){
		return data
	};
	$.ajaxUtil = function(url,parameter,callback,config){
		if(!url) return;
		$.ajax({
			type: (config&&config.type)||"post",
			async:(config&&config.async)||true,
			url: url,
			data:parameter||{},
			success: function(data) {
				/*
				 * if(!json.success){
				 * 
				 * }else{ }
				 */
				callback(data[0].outMap);		
			},
			error:function(XMLHttpRequest, textStatus, errorThrown){
				var r=message&&message.showMessage("","系统繁忙，请稍后！",true);
			}
		});
		
	}
			
	/**
	 * 表格加载数据 封装 示例： html:<table id="test"><tbody></tbody></table> js:
	 * $("#test").loadData({ url:"../user/selectAllUser",
	 * fields:["code","name","sex"], pageSize:20, parameter:json }); 参数说明：
	 * url:加载数据的url,必填。 fields:[] 填充表格的key,根据后台反回的json确定，数组的顺序即为表格的列顺序。此项必填。
	 * pageSize:20 选填。分页大小。不填默认5条数据。 parameter:{} 选填，自定义参数，将作为jquery ajax参数对象。
	 */
     $.fn.loadData=function(config){
		var $table =this.eq(0);
		if(!config||!$table.is('table')||!config.fields||!config.url) return ;
		var fields =config.fields,pageSize = config.pageSize||5;
		var para = config.parameter||{};
		para["pageIndex"]=1;
		para["pageSize"]=1;
		$.ajaxSeentao (config.url,para,function(data){
			var json = data[0].outMap;
			laypage({
				cont: 'tb-page-bar',
				curr:1,
				pages:Math.ceil(json.count/pageSize),
				jump: function(e,first){
					para["pageIndex"]=e.curr;
					para["pageSize"]=pageSize;
					$.ajaxSeentao (config.url,para,function(data){
						var json = data[0].outMap;
						var table = $table.find("tbody").html(""),_html=[],str,jsonLen,fieldLen;	
						for(var i= 0,jsonLen =json.data.length;i<jsonLen;i++ ){
							str =" <tr class='text-c tb-container-data'><input type='hidden' value='"+json.data[i].id+"' /><td class='selectItem'><span class='checkboxSeentao'> <input type='checkbox' class='' name='' id=''/></span></td>";
							for(var j= 0,fieldLen =fields.length ;j<fieldLen;j++){
								str+="<td>"+(json.data[i][fields[j]]||"")+"</td>";
							}
							str+="</tr>";
							_html.push(str);
						}
						table.html(_html.join(""));
						$.checkboxSeentao({});
						$.radioBoxSeentao({});
					})
				}
			});
		})
		return this;
	}	
	
	
	/**
	 * 加载数据 封装 示例： js: $.loadData({ url:"../user/selectAllUser",
	 * callback:function(){}, pageSize:20, laypageCon："", parameter:json });
	 * 参数说明： url:加载数据的url,必填。 callback:自定义回调函数，拼接数据 pageSize:20
	 * 选填。分页大小。不填默认5条数据。 parameter:{} 选填，自定义参数，将作为jquery ajax参数对象。
	 */
	 $.loadData=function(config){
        if(!config||!config.url) return ;
        var pageSize = config.pageSize||10;
        var para = $.formatParSeentao(config.parameter||{});
        // count
        laypage({
            cont: config.laypageCon||'tb-page-bar',
            curr:1,
            pages:1,
            jump:function(e,first){
              para["pageIndex"]=e.curr;
              para["pageSize"]=pageSize;
              $.ajaxSeentao (config.url,para,function(data){
                  	var count = data.count;
                  	laypage.refershPage(Math.ceil(count/pageSize)||1,e);
                  	if($.isFunction(config.callback)){
                        config.callback.call(null,data,e);
                  	}
                  	if($.isFunction(e.once)){
                  			e.once.call(null,data,e);
                  			delete e.once;	
                  	}
                })
            }
        });
    }

    // 分页跳转
    $.laypageDrump = function(id,page,callback){
    	var contemp,context,config;
    	if(typeof window.laypage!=="function"&& typeof window.laypage!=="object"){
    		console.log("ERROR laypage NOT FOUND!");
    		return;
    	}
    	if(!id||!page)  return;
    	if(contemp = laypage.contextTemp[id]){
    		context =contemp.context;
    		config = contemp.config;
    		if($.isFunction(callback)){
    			config.once = callback;
    		}
			if(0<+page&&+page<=config.pages){
				config.curr =page;
				context.render();
			}
    	}
    }
	
	/**
	 * 表单序列化 结果格式 {data[0].inMap.key:value,......} key是name vaue是值 示例：
	 * $("form").formatSeentao() 注: 如果 $("form")
	 * 
	 * formatSeentao--->formatSeentao
	 */
	$.fn.formatSeentao=function(){
		// var $form =this.eq(0),obj={},formname =$form.attr("id")||"",_index =
		// _index?_index:0;
		// if(!$form .is('form')) return ;
		// $form.find("input,textarea,select").each(function(index,dom){
		// var $dom = $(dom),name = $dom.attr("name")||"undefinedName",value="";
		// if($dom.attr("type")==="checkbox"){
		// if(typeof obj["listMap["+_index+"].inMap."+name]==="undefined")
		// obj["listMap["+_index+"].inMap."+name]="";
		// if(dom.checked){
		// var preValue = obj["listMap["+_index+"].inMap."+name];
		// obj["listMap["+_index+"].inMap."+name]=preValue?preValue+","+$dom.attr("value"):$dom.attr("value");
		// }
		// }else if($dom.attr("type")==="radio"){
		// if(typeof obj["listMap["+_index+"].inMap."+name]==="undefined")
		// obj["listMap["+_index+"].inMap."+name]="";
		// if(dom.checked){
		// obj["listMap["+_index+"].inMap."+name] = $dom.attr("value");
		// }
		// }else if($dom.data("type")==="select"){
		// obj["listMap["+_index+"].inMap."+name] = $dom.sval()||"";
		// }else{
		// obj["listMap["+_index+"].inMap."+name] = $dom.val()||"";
		// }
		// });
		var obj={};
		this.each(function(_index,dom){
			var _form = $(dom),
				_formname =_form.attr("id")||""
			_form.find("input,textarea,select").each(function(index,dom){
				var  $dom = $(dom),name = $dom.attr("name")||"undefinedName",value="";
				if($dom.attr("type")==="checkbox"){
					if(typeof obj[name]==="undefined")  obj[name]="";
					if(dom.checked){
						var preValue = obj[name];
						obj[name]=preValue?preValue+","+$dom.attr("value"):$dom.attr("value");
					}
				}else if($dom.attr("type")==="radio"){
					if(typeof obj[name]==="undefined")  obj[name]="";
					if(dom.checked){
						obj[name] = $dom.attr("value");
					}
				}else if($dom.data("type")==="select"){
					obj[name] = $dom.sval()||"";
				}else{
					obj[name] = $dom.val()||"";
				}
		 	});
		 	obj["flag"]=_formname;

		})
		return obj;
		// console.log(JSON.stringify(obj))
	}
	
	/**
	 * 表单填充 参数 url 数据id
	 */
	$.fn.fillForm=function(url,id,callback,ajaxConfig){
		var $form =this.eq(0);
		if(!$form .is('form')||!id||!url)  return ;
		var par = $.formatParSeentao(id);
		$.ajaxSeentao(url,par,function(data){
			var json = data[0].outMap.data;
			// if(jsonArr.length===0) return;
			// json = jsonArr[0];
			$form.find("input,textarea,select").each(function(index,dom){
				var $dom =$(dom),name = $dom.attr("name"),type=  $dom.attr("type"),value;
				if(type==="checkbox"||type==="radio"){
					value = $dom.attr("value");
					if(value&&json[name]&&json[name].indexOf(value)>-1){
						// dom.checked=true;
						$dom.click();
					}
				}else if(json[name]&&json[name]!=="null"){
					$dom.val(json[name]);	
				};
				
			});// each
			callback(data);
		},ajaxConfig||{});// ajax
		return this;
	}
	

	
	/**
	 * 表单重置
	 * 
	 * formResetSeentao--->formResetSeentao
	 */
	$.fn.formResetSeentao=function(){
		// var $form =this.eq(0);
		// if(!$form .is('form')) return ;
		// $form.find("input[type=radio],input[type=checkbox]").each(function(index,dom){
		// $(dom).checked(false);
		// });
		// $form.get(0).reset();
		this.each(function(index,dom){
			var _form = $(dom);
			dom.reset&&dom.reset();
			_form.find("input").each(function(index,dom){
				var _dom = $(dom)
				if(_dom.data("type")=="select"){
					_dom.data("value","");
                    _dom.val("");
				}
				if(_dom.attr("type")==="radio"||_dom.attr("type")==="checkbox"){
					_dom.checked(false);
				}
			})
		})
		return this;
	}
	
	
	
	/**
	 * 表单提交
	 * $(form).submitSeentao("../user/addUser",function(data){alert("添加成功！")})
	 * 
	 * submitSeentao --->submitSeentao
	 */
	$.fn.submitSeentao=function(url,callback,parameter,ajaxConfig){
		var $form =this.eq(0),par,r;
		if(!url) return ;
		par = this.formatSeentao();
		if(parameter){
			for(var pro in parameter){
				par[pro]=parameter[pro];
			}
		}
		$.ajaxSeentao(url,par,function(data){
		   if($.isFunction(callback)) {
		   		callback(data);
		   }
			if(data.success&&data.message){
				
					$.showMessage({
						title:"提示",
						message:data.message,
						icon:"success"
					})
					// r=message&&message.showMessage("",data[0].outMap.message,true,false,true,style||"");
				
			}else{
				if(data.message){
					$.showMessage({
						title:"提示",
						message:data.message,
						icon:"error"
					})
					// r=message&&message.showMessage("",data[0].outMap.message,true,false,true,style||"");
				}
			}
		},ajaxConfig||{});
		return this;
	}
		
	/**
	 * 单据 表单填充 参数 url 数据id
	 */
    $.fillFormBill=function(url,par,callback,ajaxConfig){
        // var par=$.formatParSeentao(par);
        // var par = {"listMap[0].flag":id}
        $.ajaxSeentao(url,par,function(data){
            var i,json,obj,name;
            for(i =0,len = data.length;i<len;i++){
                obj = data[i];
                name = obj.flag||"";
                if(name.indexOf("form")<0) continue;
                json = obj.outMap.data||{};
                $("form[id="+name+"]").find("input,textarea,select").each(function(index,dom){
                var $dom =$(dom),name = $dom.attr("name"),type=  $dom.attr("type"),value,color,charLength;
                if(type==="checkbox"||type==="radio"){
                    value = $dom.attr("value");
                    if(value&&json[name]&&json[name].indexOf(value)>-1){
                        // dom.checked=true;
                        $dom.click();
                    }
                }else if(json[name]){
                	value =(json[name])+"";
                	if($dom.data("type")==="select"){
                		 $dom.sval(value);
                		 return; 
                	}
                	if(value.indexOf("^&")>-1){
                		var split = value.split("^&");
                		value = split[0];
                		color = split[1];
                		$dom.attr("data-color",color).css("color",color);
                	}else{
                		$dom.attr("data-color","black").css("color","black");	
                	}
					charLength = $dom.attr("charlength");
					if(charLength = parseInt(charLength)){
						if(value.length>=charLength){
							$dom.attr("title",value);
						}else{
							$dom.attr("title","");
						}	
					}
                    $dom.val(value);   
                }; 
             });// each
            }
            callback(data);
        },ajaxConfig||{});// ajax
    }
	/**
	 * 单据表单提交 $(form).submitSeentao("../user/addUser",function(data)
	 * {alert("添加成功！")},{}) submitSeentao --->submitSeentao
	 */
    
   $.fn.submitSeentaoBill=function(url,callback,extPar,ajaxConfig){
   		var 
   			par  =this.formatSeentaoBill(true),
   			key;
   		if(extPar){
   			for(key in extPar){
   				par[key] = extPar[key];
   			}
   		}
   		
        $.ajaxSeentao(url,par,function(data){
            if($.isFunction(callback))  callback(data);
        },ajaxConfig||{});
        return this;
   }
   
   $.fn.formatSeentaoBill=function(){
		var obj={};
		this.each(function(_index,dom){
			var formname =$(dom).attr("id")||"",
				isNullform = true,
				tempObj={},
				key;
			$(dom).find("input,textarea,select").each(function(index,dom){
				var $dom = $(dom),
					name = $dom.attr("name")||"undefinedName",
					value="",domVal;
				// 单据 特殊判断
				if(name==="invoice")  name = $dom.attr("id")||"undefinedName";
				if($dom.attr("type")==="checkbox"){
					if(typeof tempObj["listMap["+_index+"].inMap."+name]==="undefined")  tempObj["listMap["+_index+"].inMap."+name]="";
					if(dom.checked){
					    isNullform=false;
						var preValue = tempObj["listMap["+_index+"].inMap."+name];
						tempObj["listMap["+_index+"].inMap."+name]=preValue?preValue+","+$dom.attr("value"):$dom.attr("value");
					}
				}else if($dom.attr("type")==="radio"){
					if(typeof tempObj["listMap["+_index+"].inMap."+name]==="undefined")  tempObj["listMap["+_index+"].inMap."+name]="";
					if(dom.checked){
					    isNullform=false;
						tempObj["listMap["+_index+"].inMap."+name] = $dom.attr("value");
					}
				}else if($dom.data("type")==="select"){
					if($dom.attr("type")!=="hidden"&&$dom.sval()){
			    		isNullform=false;
			    	}
			    	domVal =$dom.sval()||""; 
			    	if($dom.attr("data-color")==="red"){
						domVal = domVal+"^&red";
			    	}
					tempObj["listMap["+_index+"].inMap."+name] =domVal ;
				}else{
			    	if($dom.attr("type")!=="hidden"&&$dom.val()){
			    		isNullform=false;
			    	}
			    	domVal =$dom.val()||""; 
			    	if($dom.attr("data-color")==="red"){
						domVal = domVal+"^&red";
			    	}
					tempObj["listMap["+_index+"].inMap."+name] =domVal ;
				}
			});

			/*
			 * else if($dom.data("type")==="select"){
			 * obj["listMap["+_index+"].inMap."+name] = $dom.sval()||""; }else{
			 * obj["listMap["+_index+"].inMap."+name] = $dom.val()||""; }
			 * 
			 */
			if($(dom).find("input[name=id]").val()){
				isNullform=false;
			}
			if(!isNullform||formname.indexOf("form")<0) {
				for(key in tempObj){
					obj[key] = tempObj[key];
				}
				obj["listMap["+_index+"].flag"] = formname;
			}
		})
		console.log(JSON.stringify(obj))
		return obj;
		
	}
	
	/**
	 * 查询字段 序列化 $(container).searchFormatSeentao(); container:包含查询表单的父元素。
	 * 
	 * 
	 * searchFormatSeentao---->searchFormatSeentao
	 */
	$.fn.searchFormatSeentao=function(){
		var obj={};
		this.eq(0).find("input,select,textarea").each(function(index,dom){
			var  $dom = $(dom),name  = $dom.attr("name")||"undefinedName",value="";
			
			// 单据特殊判断
			if(name==="invoice")  name = $dom.attr("id")||"undefinedName";
			
			if($dom.attr("type")==="checkbox"){
				if(dom.checked){
					var preValue = obj[name];
					obj[name]=preValue?preValue+","+$dom.attr("value"):$dom.attr("value");
				}
			}else if($dom.attr("type")==="radio"){
				if(dom.checked){
					obj[name] = $dom.attr("value");
				}
			}else if($dom.val()!=""){
				obj[name] = $dom.val();
			}		
		});
		return  obj;
	}
    
   
    
	/**
	 * 收藏
	 */
	$.addFavorite=function (name,site){
		try{window.external.addFavorite(site,name);}
		catch(e){
			try{window.sidebar.addPanel(name,site,"");}
				catch(e){
					var r=message&&message.showMessage("","加入收藏失败，请使用Ctrl+D进行添加",true);
				}
		}
	}
	
	/**
	 * 表格多选
	 */
	$.selectTable = function(config){
		if(!config.target) return;
		var sTable={
			table:$(config.target),   // table元素的jquery对象
			fields:config.fields||null,
			selectedRowCount:0,       // 选中的行数
			selectedRow:{},            // 选中的行 {0:trobj1,1:trobj2 ..... }
			getData:function(r,c){
			var $tr,$td;
			if(typeof r==="number"||!isNaN(parseInt(r))){
				$tr = this.table.find("tbody tr").eq(r);
			}else if(typeof r==="string"||typeof r==="object"){
				$tr  = $(r);
			}
			$td = $tr?$tr.find("td").eq(c):null;
			return $td?$td.text():"";
			},
			refrash:function(){
				this.selectedRowCount=0;
				this.selectedRow={};	
			}
		},selModel;
		var selectModel ={
			default:function(){        
				$(config.target).bind("click",function(e){
					var index,row,jTr,dTr,jCheckbox;
					if(e.target.parentNode.nodeName.toUpperCase()==="TR"&&e.target.nodeName.toUpperCase()==="TD"){
						dTr = e.target.parentNode;
						$(dTr).find("input[type=checkbox]").checkBoxTriggerSeentao();
					}	
					else if(e.target.nodeName.toUpperCase()==="INPUT"){
						jCheckbox = $(e.target);
						dTr = $(e.target).parents().filter("tr").get();	
					}else{
						return;
					}	
					jTr =$(dTr);
					index = $(this).find("tbody tr").index(jTr);
					if(!sTable.selectedRow[index]){
						sTable.selectedRowCount++;
						row=sTable.selectedRow[index] =dTr;
						jTr.addClass("table-selected")
					}else{
						delete sTable.selectedRow[index];
						row=null;
						sTable.selectedRowCount--;
						jTr.removeClass("table-selected");
					}
					if($.isFunction(config.rowSelectHandler)){
						config.rowSelectHandler.call(dTr,index,row,this)
					}
				});
			}, 
			single:function(){
				var slide;
				$(config.target).bind("mousedown",function(e){	
					var index,row,jTr,dTr;
					if(e.target.parentNode.nodeName.toUpperCase()==="TR"&&e.target.nodeName.toUpperCase()==="TD"){
						$(this).find("tr input[type=checkbox]").checkBoxTriggerSeentao(false);
						dTr = e.target.parentNode
						$(dTr).find("input[type=checkbox]").checkBoxTriggerSeentao(true);
					}else if(e.target.nodeName.toUpperCase()==="INPUT"){
						jTr = $(e.target).parents().filter("tr");
						index = $(this).find("tbody tr").index(jTr);
						if(sTable.selectedRow[index]){
							delete  sTable.selectedRow[index];
							jTr.removeClass("table-selected")
							sTable.selectedRowCount--;
						}else{
							sTable.selectedRowCount++;
							jTr.addClass("table-selected")
							sTable.selectedRow[index] = 	jTr.get(0);	
						}	
						return;
					}else{
						return;
					}
					jTr =$(dTr);
					index = $(this).find("tbody tr").index(jTr);
					sTable.selectedRowCount=1;
					sTable.selectedRow={};
					$(this).find("tr").removeClass("table-selected");				
					row=sTable.selectedRow[index]=dTr;
					$(sTable.selectedRow[index]).addClass("table-selected");	
					if($.isFunction(config.rowSelectHandler)){
						config.rowSelectHandler.call(dTr,index,row,this)
					}
				});
			
				$(document).bind("mousedown",function(e){
					slide =e.target.parentNode;					
				});
				$(document).bind("mouseup",function(e){
					slide=null;
				});
				$(document).bind("mousemove",function(e){
					// e.preventDefault();
				});
				$(config.target).bind("mouseout",function(e){
					var jTr,index,dTr,jCheckbox;
					if(!slide||slide==e.target.parentNode) return;
					if(e.target.parentNode.nodeName.toUpperCase()==="TR"&&e.target.nodeName.toUpperCase()==="TD"){
						dTr = e.target.parentNode;
						jCheckbox = $(dTr).find("input[type=checkbox]");
					}else if(e.target.nodeName.toUpperCase()==="INPUT"){
						jCheckbox = $(e.target);
						dTr = $(e.target).parents().filter("tr").get();
					}else{
						return;
					}
					jTr =$(dTr);
					index = $(this).find("tbody tr").index(jTr);
					if(sTable.selectedRow[index]){
						$(sTable.selectedRow[index]).removeClass("table-selected");
						sTable.selectedRowCount--;
						jCheckbox.checkBoxTriggerSeentao(false);
						delete sTable.selectedRow[index];
					}else{
						sTable.selectedRow[index] = dTr;
						sTable.selectedRowCount++;
						jCheckbox.checkBoxTriggerSeentao(true);
						$(sTable.selectedRow[index]).addClass("table-selected");
					}
				});
			}
		}
		selModel = config.selectModel||"default"; 
		selectModel[selModel].call();
		return  sTable;
	}

	
	/**
	 * 复选框 checkboxSeentao-->checkboxSeentao
	 * 
	 */
	$.checkboxSeentao = function(obj){
		var checkboxlist = $(".iv2Checkbox");
		checkboxlist.each(function(index,domElement){
			var $this = $(domElement),$checkbox,activeCls,disableCls;
			activeCls =obj.active||"iv2CheckboxActive";
			disableCls =obj.disable||"iv2CheckboxDisable";
			if(domElement.nodeName.toUpperCase()==="SPAN"){
				if(($checkbox=$this.find("input[type=checkbox]")).length!=0){
					$this.addClass(disableCls);
					$checkbox.bind("change",function(e){
							if(e.target.checked){
								$this.removeClass(disableCls).addClass(activeCls);
							}else{
								$this.removeClass(activeCls).addClass(disableCls);
							}
					});
				}
			}
		})
	}
	
	
	$.fn.checkBoxTriggerSeentao = function(state,obj){
		var  checked  ,activeCls,disableCls;
		if(this.parent().attr("class").indexOf("iv2Checkbox")<0) return;
		activeCls =(obj&&obj.active)||"iv2CheckboxActive";
		disableCls =(obj&&obj.disable)||"iv2CheckboxDisable";
		this.each(function(index,dom){
			// checked = state||!dom.checked;
			checked =  typeof state==="undefined"?!dom.checked:state;
			dom.checked = checked;
			if(checked){
				$(dom).parent().removeClass(disableCls).addClass(activeCls);
			}else{
				$(dom).parent().removeClass(activeCls).addClass(disableCls);
			}
		})
	}

	/**
	 * 单选框 iv2RadioBox---> radioBoxSeentao
	 */
	$.radioBoxSeentao = function(obj){
		var checkboxlist = $(".iv2Radiobox");
		checkboxlist.each(function(index,domElement){
			var $this = $(domElement),$radio,activeCls,disableCls;
			activeCls =obj.active||"iv2RadioboxActive";
			disableCls =obj.active||"iv2RadioboxDisable";
			if(domElement.nodeName.toUpperCase()==="SPAN"){
				if(($radio=$this.find("input[type=radio]")).length!=0){
					$this.addClass(disableCls);
					$radio.bind("change",function(e){
						var name = $(this).attr("name")
						checkboxlist.find("input[type=radio][name="+name+"]").parent().removeClass(activeCls).addClass(disableCls);
						if(e.target.checked){
							$this.removeClass(disableCls).addClass(activeCls);
						}
				})
				}
			}
		})
	}

	// 新 下拉框
	$.fn.sval = function(val){
		if(typeof val==="undefined"){
			return this.data("value");
		}else if(typeof val==="object"){
            this.each(function(index,dom){
                $(dom).val(val.text).data("value",val.value);
            });
            return;
        }
		val = val+"";
		this.each(function(index,dom){
			var _this= $(dom),
				value="",
				text="",
				valList,
				textList,
				tempVal,
				tempText;
			if(val.indexOf(",")>-1&&dom.multiple){
				valList = val.split(",");
				for(var i =0,len=valList.length;i<len;i++){
					if(tempText = dom.combo.find("li[value="+valList[i]+"] span").html()){
						text = text===""?tempText:text+","+tempText;
						value = value===""?valList[i]:value+","+valList[i];
					}
				}
				_this.val(text);
			    _this.data("value",val);
			}else if(val.indexOf(",")<0){
				if(dom.combo){
					text = dom.combo.find("li[value="+val+"] span").html();
					if(text){
						_this.val(text);
						_this.data("value",val);
					}else{
						_this.val("");
						_this.data("value","");
					}
				}
			}
		})

	}

	$.fn.clearData = function(){
		this.each(function(index,dom){
            $(dom).val("").data("value","");
			if(dom.combo){
				dom.combo.find("ul").html("");// .css("height",100);
			}
		});
	}
    $.fn.refreshData=function(list){
    	this.each(function(index,dom){
    		var _this = $(dom),_html,i,len,_icon;
    		if(dom.combo){
    			_icon = dom.multiple?"&#xf02a8;":"";
				_html=[];
				for(i= 0,len =list.length;i<len;i++ ){
					_html.push("<li data-stype='selectItem' value=\""+list[i].value+"\"><i class='iconfont'>"+_icon+"</i><span>"+list[i].text+"</span></li>");
				}
				dom.combo.find("ul").html($(_html.join("")));
    		}
    	});
    }
	// 批量加载下拉框
	// [{falg:"",inpMap:{},outMap:{data:[{},{}]}},{falg:"",inpMap:{},outMap:{data:[{},{}]}},{falg:"",inpMap:{},outMap:{data:[{},{}]}}]
	$.initCombobox=function(config){
		if(!config||!config.url){
			console.log("一次性加载Combobox必须有URL ---->   $.initCombobox({url:'/loadcombo'})");
			return;
		}
		$.ajaxSeentao(config.url,config.data||{},function(json){
			var i,len,inputTag;
			for(i=0,len =json.length;i<len;i++){
				inputTag = json[i].flag;
				$("input[combo="+inputTag+"]").each(function(ind,dom){
					var _this= $(dom),con,comCfg={};
					if(_this.attr("multiple")){
						comCfg.multiple = true;
					}
					if(_this.attr("enableInput")){
						comCfg.input = true;
					}
					comCfg.localData = json[i].outMap.data;
					comCfg.callback = config.callback||null;
					_this.comboboxSeentao(comCfg);
				})
			}
		});

	}
	// combobox new
	$.fn.comboboxSeentao = function(config){
		var _comboItem=$('<ul>加载中....</ul>'),
			_self = this,
			_jsonData,
			_dataCache=[],
			_comboCont=$("<div class='iv2Combo-cont'><div class=\"iv2ComboDefaultN\"></div><div class='button-cont'><a class='confirmbtn'>确定</a></div></div>"),
			_comboBox = _comboCont.children(".iv2ComboDefaultN"),
			_confirmBtn = _comboCont.children(".button-cont"),
			mValue=[],mText=[],_icon="";
		if(config.multiple){
			_confirmBtn.css("display","block");
			_icon="&#xf02a8;"
		}
		function searchList(value,_target){
			var ret =[],reg = new RegExp(value);
			$('<div>'+_target.dataCahe.join("")+'</div>').find("li").each(function(index,dom){
				if(reg.test($(dom).html())){
					ret.push(dom.outerHTML);
				}
			});
			if(ret.length===0){
				_comboItem.html((_target.dataCahe||[]).join(""));
			}else{
				_comboItem.html($(ret.join("")));
			}
		}

		function initDate(data,_comboItem,_dataCache,_self){
			var _html=[],
                _valueField =config.valueField||"value" ,
                _textField = config.textField||"text";
			for(var i= 0,len =data.length;i<len;i++ ){
				_html.push("<li data-stype='selectItem' value=\""+data[i][_valueField]+"\"><i class='iconfont'>"+_icon+"</i><span>"+data[i][_textField]+"</span></li>");
			}
			_self.each(function(index,dom){
				var _this=$(dom);
                dom.dataCahe = _html;
				if(_this.data("type")==="select"&&dom.combo){
					dom.combo.find("ul").html($(_html.join("")));
				}	
			})
			_comboItem.html($(_html.join("")));
		}

		if(config.autoHide){
			_comboCont.bind("mouseleave",function(e){
				_comboCont.css("display","none");
			});
		}
		if(config.multiple){
			_comboItem.click(function(e){
				var _this = $(e.target),value="",text="",_li,_index;
				if(_this.is("i,span")){
					_li = _this.parent();	
				}else if(_this.is("li")){
					_li = _this;	
				}
				if(_li){
					text = _li.children("span").html();
					value = _li.attr("value");
					if((_index=mValue.indexOf(value))>-1){
						mValue.splice(_index,1);
						mText.splice(_index,1);
						_li.children("i").html("&#xf02a8;");
					}else{
						mValue.push(value);
						mText.push(text);
						_li.children("i").html("&#xf02a7;");
					}
				}

			});

			_confirmBtn.unbind("click");
			_confirmBtn.bind("click",function(e){
				_comboCont.target&&_comboCont.target.val(mText.join(",")).data("value",mValue.join(","));
				_comboCont.target.focus();
				_comboCont.target.data("nocheck","");
				_comboCont.target.blur();
				_comboCont.css("display","none");
				mValue=[];
				mText=[];

				if($.isFunction(config.callback)){
					config.callback.call(null,_comboCont.target);
				}
			});
		}else{
			_comboItem.click(function(e){
				var _this = $(e.target),value="",text="";
				if(_this.is("i,span")){
					text = _this.parent().children("span").html();
					value = _this.parent().attr("value")	
				}else if(_this.is("li")){
					text = _this.children("span").html();
					value = _this.attr("value")
				}
				_comboCont.target&&_comboCont.target.val(text).data("value",value);
				_comboCont.target.focus();
				_comboCont.target.data("nocheck","");
				_comboCont.target.blur();
				_comboCont.css("display","none");

				if($.isFunction(config.callback)){
					config.callback.call(null,_comboCont.target);
				}	
			})
		}
		
		

		var newTag = false;
		this.each(function(index,dom){
			var _this =$(dom); 
			if(_this.data("type")==="select"&&dom.combo){
				return;
			}
			_this.unbind("click");
			_this.unbind("keyup");
			_this.unbind("blur");
			newTag=true;
			dom.combo = _comboCont;
			dom.multiple = config.multiple;
			if(!config.input){
				$(dom).attr("readonly","true"); 
			}else{
				$(dom).bind("keyup",function(e){
					searchList($(dom).val(),dom);
				})
			}
			_this.bind("click",function(e){
				var _this= $(this),
					height = _this.outerHeight(),
					left = _this.offset().left,
					top = _this.offset().top,
					containerWidth=parseInt(_comboCont.css("border-width"))||1,
					width = _this.outerWidth()-2*containerWidth;
					_this.data("nocheck","1");
					mValue=[];
					mText=[];
					_this.data("value","");

				// disable
				if(_this.attr("disable")){
					return;
				}
                $(".iv2Combo-cont").css("display","none");
				_comboCont.css({
					display:"block"
				});
                if(_this.parents().filter(function(i,v){return $(v).css("position")==="fixed"?true:false}).length>0){
                    // 有fixed定位
                    _comboCont.css("position","fixed");
                    height-=$(window).scrollTop();
                }else{
                    _comboCont.css("position","absolute");
                }
				setTimeout(function(){
					_comboCont.css({
					width:width>120?width:120,
					left:left+"px",
					top:height+top+"px"
				});
				},20);
				

				if(config.multiple){
					_comboCont.find("li i").html("&#xf02a8;");
				}else{
					_comboCont.find("li i").html("");
				}
				// _comboCont.removeClass("combox-hide").addClass("combox-show");
				_comboCont.target=$(this);
				_comboCont.data("target",$(this));
			}).data("type","select");

			_this.bind("blur",function(e){
				if(!$(this).data("value")&&!$(this).attr("disabled")!="undefined"){
					$(this).val("");
				}
			});
		}).css("cursor","pointer");
	

		if(newTag){
			_comboBox.append(_comboItem);
			_comboCont.appendTo("body");
		}


		if(config.localData){
			initDate(config.localData,_comboItem,_dataCache,_self);
			if(config.defaultValue){
				_self.sval(config.defaultValue);
			}
			_jsonData=config.localData;
		}else if(config.url){
			$.ajaxSeentao(config.url,config.data||{},function(json){
				initDate(json[0].outMap.data,_comboItem,_dataCache,_self);
				if(config.defaultValue){
					_self.sval(config.defaultValue);
				}
				_jsonData =json[0].outMap.data;
			},{async:config.async});
		}
		
		if(!arguments.callee.inited){
			// 只绑定一次
			$(document).bind("click",function(e){
				if($(e.target).data("type")!=="select"&&$(e.target).attr("data-stype")!=="selectItem"&&$(e.target).parent().attr("data-stype")!=="selectItem"){
					$(".iv2Combo-cont").each(function(i,dom){
						if($(dom).css("display")==="block"){
							$(dom).data("target").data("nocheck","");
							$(dom).data("target").blur();
							$(dom).css("display","none");
						}
					});	

					// .css({
					// display:"none"
					// })
					$("input").data("nocheck","");
					mValue=[];
					mText=[];	
				}
			});
			arguments.callee.inited=true;
		}
		return this;
	}
     // 级联下拉框
    $.fn.comboboxJL=function(config){
            this.each(function(index,dom){
                var
                    _input = $(dom),
                    _self = this,
                    _comboCont=$("<div class='iv2Combo-cont'><div class=\"iv2ComboDefaultN\"><ul>加载中....</ul></div><div class='button-cont'><a class='confirmbtn'>确定</a></div></div>"),
                    _comboBox = _comboCont.children(".iv2ComboDefaultN");
                    _comboCont.appendTo($("body"));
                    _comboCont.data("target",_input);
                    _comboBox.click(function(e){
                    var _target = $(e.target),_item;
                    if(_target.is("i,span")){
                        _item =_target.parent();
                    }else if(_target.is("li")){
                        _item =  _target;
                    }
                    if(_item){
                        _input.val(_item.children("span").html());
                        _input.data("value",_item.attr("value"));
                        _comboCont.css("display","none");
                        _input.data("nocheck","");
                        _input.blur();
                        if($.isFunction(config.callback)){
                            config.callback.call(null,_input);
                        }
                    }
                });

                _comboCont.bind("mouseleave",function(){
                     _comboCont.css("display","none");
                });
                if(!dom.inited){
                    _input.data({
                        "type":"select",
                        "combobox":_comboCont,
                        "config":config
                    }).click(function(e){
                            var
                                _this = $(this),
                                _comboItem =   _comboCont.find("ul"),
                                height = _this.outerHeight(),
                                left = _this.offset().left,
                                top = _this.offset().top,
                                containerWidth=parseInt(_comboCont.css("border-width"))||1,
                                width = _this.outerWidth()-2*containerWidth,
                                config =_this.data("config"),
                                key;
                            var parLi= (_this.attr("data-par")||"").split(","),
                                keyLi = (_this.attr("data-key")||"").split(","),
                                i,
                                len,
                                para = {},
                                error=false;
                            for(i=0,len =parLi.length;i<len;i++ ){
                                if(parLi[i]&&!$("#"+parLi[i]).sval()){
                                    error=true;
                                    break;
                                }
                                para[keyLi[i]||parLi[i]] = $("#"+parLi[i]).sval();
                            }
                            _this.data("nocheck","1");
                            $(".iv2Combo-cont").css("display","none");
                            _comboCont.css("display","block");

                            if(_this.parents().filter(function(i,v){return $(v).css("position")==="fixed"?true:false}).length>0){
                                // 有fixed定位
                                _comboCont.css("position","fixed");
                                height-=$(window).scrollTop();
                            }else{
                                _comboCont.css("position","absolute");
                            }
                            _comboCont.css({
                                width:width>120?width:120,
                                left:left+"px",
                                top:height+top+"px"
                            });
                            if(error){
                                if(config.message){
                                    $.showMessage({
                                        title:"提示",
                                        message:"请选择"+($('#'+parLi[i]).attr("data-alt")||parLi[i])+"！"
                                    })
                                }else{
                                    _comboItem.html("请选择"+($('#'+parLi[i]).attr("data-alt")||parLi[i])+"！");
                                }
                               return;
                            }

                            if(config.par){
                                for(key in config.par){
                                    para[key] = config.par[key];
                                }
                            }
                            $.ajaxSeentao(_this.attr("data-url")||"", $.formatParSeentao(para),function(data){
                                var _html=[],
                                    json =data.data// data&&data[0]&&data[0].outMap&&data,
                                    i,
                                    len;
                                for(i= 0,len =json.length;i<len;i++ ){
                                    _html.push("<li data-stype='selectItem' value=\""+json[i][config.valueField]+"\"><i class='iconfont'></i><span>"+json[i][config.textField]+"</span></li>");
                                }
                                _comboItem.html(_html.join(""));
                            });
                        });
                    dom.inited =true;
                }else{
                    _input.data("config",config);
                }
            });

        if(!arguments.callee.inited){
            // 只绑定一次
            $(document).bind("click",function(e){
                if($(e.target).data("type")!=="select"&&$(e.target).attr("data-stype")!=="selectItem"&&$(e.target).parent().attr("data-stype")!=="selectItem"){
                    $(".iv2Combo-cont").each(function(i,dom){
                        if($(dom).css("display")==="block"){
                            $(dom).data("target").data("nocheck","");
                            $(dom).data("target").blur();
                            $(dom).css("display","none");
                        }
                    });
                }
            });
            arguments.callee.inited=true;
        }
    }
	/**
	 * 可编辑树 （未完） 用法: var tree = $("div.sttree").sttree({ url:"", //加载树的URL
	 * mergeUrl:"", //合并节点的URL getLeafDataURL:"", //确定节点下是否有数据的URL delteUrl:"",
	 * //删除节点的URL addNodeUrl:"", //添加节点的URL dragable:true,
	 * confirmStyle:"confirm_baudTree", messageStyle:"message_baudTree",
	 * selectCallback:function(nodeText,node){ },
	 * expandCallback:function(nodeText,node){ } })
	 * 
	 * 
	 * 返回的对象 tree 有如下方法： {
	 * 
	 *  } config.getLeafDataURL
	 */
	$.fn.sttree = function(config){
		var container = this.eq(0),
			moveInfo={},
			selectedNode=null,
			tempNode=null,
			timeout = null,
			golbal = arguments.callee;
		if(this.length===0) return;
		container.unbind("click");
		// container.unbind("click");
		container.unbind("mousedown");
		container.unbind("mouseup");
		container.unbind("mousemove");
		container.unbind("mouseleave");

		container.bind("click",function(e){
			var $target  = $(e.target),target = e.target,className=$target.attr("class")||"",type=e.target.nodeName.toUpperCase();
			if(className.indexOf("switch")>-1){
				// 展开按钮
				expandNode($target);
				if(config.autoExpand !==false){
					$target.siblings("ul").find("span.switchOff").each(function(index,dom){
						expandNode($(dom));
					});
				}
			}
			if(($target.parent().attr("class")||"").indexOf("node")>-1){
				// 点击节点
				if(selectedNode){
					selectedNode.removeClass("nodeSelect");
				}
				selectedNode=$target.parent().addClass("nodeSelect");
				if($.isFunction(config.selectCallback)){
					config.selectCallback.call(this,selectedNode.children("span.text").html(),$target.parent());
				}
			}
			// if(config.autoExpand){
			// $target.siblings("ul").find("span.switchOff").each(function(index,dom){
			// $(dom).click();
			// });
			// }
		});
			
		if(config.dragable){
			container.bind("mousedown",mouseDown);
			container.bind("mouseup",mouseup);
			container.bind("mousemove",mousemove);
			container.bind("mouseleave",mouseleave);

			// container.mouseup(mouseup);
			// container.mousemove(mousemove);
			// container.mouseleave(mouseleave);
			container.get(0).ontouchstart = mouseDown;
			container.get(0).ontouchmove = mousemove;
			container.get(0).ontouchend = mouseup;
		}
		
		function expandNode($target){
			if($target.attr("expand")==="true"){
				$target.attr("expand","false");
				$target.removeClass("switchOn").addClass("switchOff");
				$target.parent().children("ul").removeClass("show").addClass("close");
			}else{
				$target.attr("expand","true");
				$target.removeClass("switchOff").addClass("switchOn");
				$target.parent().children("ul").removeClass("close").addClass("show");
			}
			if($.isFunction(config.expandCallback)){
				config.expandCallback.call(this,$target.siblings("a").children("span.text").html(),$target.parent().children("a"));
			}
		}


		function mouseDown(e){
			var $target  = $(e.target),target = e.target,
			className=$target.attr("class"),
			type=e.target.nodeName.toUpperCase(),
			pageX,pageY,width,height;
			clearTimeout(timeout);
			timeout = setTimeout(function(){
				// 长按 500ms 进入拖拽模式
				if(($target.parent().attr("class")||"").indexOf("node")>-1){
					moveInfo={};
					moveInfo.moveStart = true;
					moveInfo.srcNode = $target.parent();
					if(!tempNode){
						tempNode = $("<span class='tempNode hui-swing'>"+$target.parent().find("span.text").html()+"</span>");
						tempNode.css("left",e.pageX+15+"px");
						tempNode.css("top",e.pageY+"px");
						$("body").append(tempNode);
					}
				}
			},500)
			e.preventDefault();
		}
		function mouseup(e){
			var $target  = $(e.target),
			target = e.target,className=$target.attr("class"),
			$selectNode = $target.parent(),srcType,destType,flag;
			clearTimeout(timeout);
			if(!moveInfo.moveStart) return;
			moveInfo.moveStart = false;
			moveInfo.desNode = $selectNode;
			if(tempNode){
				tempNode.remove();
				tempNode=null;
			}
			// e.preventDefault();
			// 验证节点 合法性
			if(!moveInfo.srcNode||($selectNode.attr("class")||"").indexOf("node")<0||$selectNode.get(0)==moveInfo.srcNode.get(0)) {
				moveInfo={};
				return ;	
			}
			// 通过验证 替换节点
			srcType = moveInfo.srcNode.parent().children("span.switchOff,span.switchOn").length>0?"floder":"leaf";
			destType = $selectNode.parent().children("span.switchOff,span.switchOn").length>0?"floder":"leaf";
			if(destType ==="floder"){
				if(srcType==="floder"){
					// 文件夹到文件夹
					message.showConfirm({
						msg:"请选择操作类型！",
						mask:true,
						style:config.confirmStyle||"message_cfmbox_tree",
						buttons:[
						{style:"okbtn",name:"合并"}, 
						{style:"okbtn",name:"拖入"},
						{style:"cancelbtn",name:"取消"}
						],
						callback:function(ok){
							switch(ok){
								case "合并":mergeNode(moveInfo.srcNode.parent(), moveInfo.desNode.parent());
										$.ajaxSeentao(config.mergeUrl||"",$.formatParSeentao("1",{pId:$selectNode.parent().attr("id"),id:moveInfo.srcNode.parent().attr("id")}),function(data){})
										refreshDeep();
										break;
								case "拖入":insertNode(moveInfo.srcNode.parent(), moveInfo.desNode.parent());
										$.ajaxSeentao(config.mergeUrl||"",$.formatParSeentao("2",{pId:$selectNode.parent().attr("id"),id:moveInfo.srcNode.parent().attr("id")}),function(data){})
										refreshDeep();
										break;
							}	
							// this._confirmBox.style.display="none";
							// this._confirmBox.remove();
							// this._confirmBox=null;
							// this.clearMask();
						}
					});
					
				}else{
					// 叶子到文件夹
					message.showConfirm({
						msg:"确定拖入吗？",
						mask:true,
						style:config.confirmStyle||"message_cfmbox_tree",
						callback:function(ok){
							if(ok){
								insertNode(moveInfo.srcNode.parent(), moveInfo.desNode.parent());
								$.ajaxSeentao(config.mergeUrl||"",$.formatParSeentao("2",{pId:$selectNode.parent().attr("id"),id:moveInfo.srcNode.parent().attr("id")}),function(data){})
							}
						}
					});
				}
			}else{
				if(srcType ==="floder"){
					// 文件夹到叶子 同步请求 叶子是否包含数据
					$.ajaxSeentao(config.getLeafDataURL||"",$.formatParSeentao($selectNode.parent().attr("id")),function(data){
						var json = $.parseJsonSeentao(data)
						flag =  json.data.length===0?false:true;
					},{type:"get",async:false});
					if(flag===true){
						message.showMessage("","操作不合法!",true);
						return;
					}else{
						message.showConfirm({
							msg:"请选择操作类型！",
							mask:true,
							style:config.confirmStyle||"message_cfmbox_tree",
							buttons:[
							{style:"okbtn",name:"合并"}, 
							{style:"okbtn",name:"拖入"},
							{style:"cancelbtn",name:"取消"}
							],
							callback:function(ok){
								switch(ok){
									case "合并":mergeNode(moveInfo.srcNode.parent(), moveInfo.desNode.parent());
											$.ajaxSeentao(config.mergeUrl||"",$.formatParSeentao("1",{pId:$selectNode.parent().attr("id"),id:moveInfo.srcNode.parent().attr("id")}),function(data){})
											refreshDeep();
											break;
									case "拖入":insertNode(moveInfo.srcNode.parent(), moveInfo.desNode.parent());
											$.ajaxSeentao(config.mergeUrl||"",$.formatParSeentao("2",{pId:$selectNode.parent().attr("id"),id:moveInfo.srcNode.parent().attr("id")}),function(data){})
											refreshDeep();
											break;
								}
								// this._confirmBox.style.display="none";
								// this._confirmBox.remove();
							     // this._confirmBox=null;
								// this.clearMask();
							}
						});
					}
				}else{
					// 叶子 -->叶子
					// 同步请求 叶子是否包含数据
					$.ajaxSeentao(config.getLeafDataURL||"",$.formatParSeentao($selectNode.parent().attr("id")),function(data){
						var json = $.parseJsonSeentao(data)
						flag =  json.data.length===0?false:true;
						},{type:"get",async:false})
					if(flag===true){
						message.showConfirm({
							msg:"包含数据，是否合并？",
							mask:true,
							style:config.confirmStyle||"message_cfmbox_tree",
							callback:function(ok){
								if(ok){
									// 合并叶子
									moveInfo.srcNode.parent().remove();
									$.ajaxSeentao(config.mergeUrl||"",$.formatParSeentao("1",{pId:$selectNode.parent().attr("id"),id:moveInfo.srcNode.parent().attr("id")}),function(data){})
									refreshDeep();
								}
							}
						});
					}else{
						message.showConfirm({
							msg:"节点不包含数据，是否拖入？",
							mask:true,
							style:config.confirmStyle||"message_cfmbox_tree",
							buttons:[
							{style:"okbtn",name:"拖入"},
							{style:"okbtn",name:"合并"},
							{style:"cancelbtn",name:"取消"}
							],
							callback:function(ok){
								switch(ok){
									case "拖入":insertNode(moveInfo.srcNode.parent(), moveInfo.desNode.parent());
									$.ajaxSeentao(config.mergeUrl||"",$.formatParSeentao("2",{pId:$selectNode.parent().attr("id"),id:moveInfo.srcNode.parent().attr("id")}),function(data){})
									refreshDeep();
									break;
									case "合并":
									moveInfo.srcNode.parent().remove();
									$.ajaxSeentao(config.mergeUrl||"",$.formatParSeentao("1",{pId:$selectNode.parent().attr("id"),id:moveInfo.srcNode.parent().attr("id")}),function(data){})
									refreshDeep();
									break;
								}
								// this._confirmBox.style.display="none";
								// this._confirmBox.remove();
							     // this._confirmBox=null;
								// this.clearMask();
							}
						});
					}
				}
			}
		}
		function mousemove(e){
		    var  pageX,pageY,width,height;
			if(!moveInfo.moveStart) return;
			if(tempNode){
				tempNode.css("left",e.pageX+15+"px");
				tempNode.css("top",e.pageY+"px");
			}
			e.preventDefault();
		}
		function mouseleave(e){
			clearTimeout(timeout);
			moveInfo.moveStart = false;
			if(tempNode){
				tempNode.remove();
				tempNode=null;
			}
			e.preventDefault();
		}
		
	
		// container.get(0).ontouchstart = mouseDown;

		// 加子节点
		function  insertNode(srcNode,destNode){
			var  ul,ulcls,tempDesc=destNode,srcParent=srcNode.parent().parent();
			expandIcon = destNode.children("span.icon");
			srcExpandIcon = srcNode.children("span.icon");
			if(expandIcon.attr("expand")==="true") {
					ulcls = "show";
				}else{
					ulcls ="close";
				}
			if(destNode.children("ul").length===0){
				 ul = $("<ul class='"+ulcls+"'></ul>");
				 destNode.append(ul);
				 destNode = ul;
			}else{
				 destNode = destNode.children("ul");
			}
			var srcPre = srcNode.prev();
			destNode.append(srcNode);
			changeIcon(srcNode,tempDesc,srcPre,srcParent);

		}
		// 文件夹合并
		function  mergeNode(srcNode,destNode){
			// alert("合并")
			var  ul,ulcls,srcClild,tempDesc=destNode,srcParent=srcNode.parent().parent();;
			
			expandIcon = destNode.children("span.icon");
			srcExpandIcon = srcNode.children("span.icon");

			if(expandIcon.attr("expand")==="true") {
					ulcls = "show";
				}else{
					ulcls ="close";
				}
			if(destNode.children("ul").length===0){
				 ul = $("<ul class='"+ulcls+"'></ul>");
				 destNode.append(ul);
				 destNode = ul;
			}else{
				 destNode = destNode.children("ul");
			}
			srcNode.children("ul").children("li").each(function(index,dom){		
				destNode.append($(dom));	
			});
			var srcPre = srcNode.prev();
			srcNode.remove();
			changeIcon(srcNode,tempDesc,srcPre,srcParent);			
		}
		
		function  changeIcon(srcNode,destNode,srcPre,srcParent){
			// 修改 竖线和图标
			var iconSpan,expandIcon,srcExpandIcon;
			expandIcon = destNode.children("span.icon");
			srcExpandIcon = srcParent.children("span.icon");
			
			if((expandIcon.attr("class")||"").indexOf("switch")<0){
				expandIcon.removeClass("leaf-m").removeClass("leaf-l").addClass("switchOff");
			}	
				
			// if(srcParent.clildren("ul").length>0){
				// srcExpandIconexpandIcon.removeClass("leaf-m").removeClass("leaf-l").addClass("switchOff");
			// }else{
				// srcExpandIconexpandIcon.removeClass("switchOff").removeClass("switchOn").addClass("leaf-l");
			// }
			
			if(destNode.parent().next().length===0){
				destNode.removeClass("line");
			}else{
				destNode.addClass("line");
			}
			
			if(srcPre.length>0){
				if(srcPre.children("span.switchOff,span.switchOn").length>0){
					if(srcPre.next().length>0){
						srcPre.children("ul").addClass("line");
					}else{
						srcPre.children("ul").removeClass("line");
					}
				}else{
					iconSpan = srcPre.children("span.icon,span.leaf-m,span.leaf-l");
					if(srcPre.next().length===0){
						iconSpan.removeClass("leaf-m").addClass("leaf-l");
					}else{iconSpan.removeClass("leaf-l").addClass("leaf-m");}
				}
			}
			
			if(srcNode.children("span.switchOff,span.switchOn").length>0){
				// 文件夹
				if(srcNode.next().length===0){
					srcNode.children("ul").removeClass("line");
				}else{srcNode.children("ul").add("line");}
			}else{
				// 叶子
				iconSpan = srcNode.children("span.icon,span.leaf-m,span.leaf-l");
				if(srcNode.next().length===0){
					iconSpan.removeClass("leaf-m").addClass("leaf-l");
				}else{iconSpan.removeClass("leaf-l").addClass("leaf-m");}
			}
			
			if(srcNode.prev().children("span.switchOff,span.switchOn").length>0){
				srcNode.prev().children("ul").addClass("line");
			}else{
				srcNode.prev().children("span.leaf-m,span.leaf-l").removeClass("leaf-l").addClass("leaf-m");
			}	
		}
		function loadData(data){
			// container
			var  root = $("<ul><li id='0' deep='0'><span class='icon switchOn' expand='true'></span><a class='node' type='folder'><span class='text'>全部</span></a><ul id='root' class='show'><ul></li></ul>")		
			var  tree =root.find("#root"); 
			var i,len,node,$node,switchCls,
				name,id,pId,pNode,deep,
				sortCode,extrData,
				extrDataKey = config.extrDataKey||"key_undefined";
			container.append(root);
			for(i=0,len=data.length;i<len;i++){
				node = data[i];
				name = node.name;
				id=node["sortupId"]||node._id;
				pId = node.pId;
				deep = node.node;
				sortCode =node.sortCode||""; 
				extrData = node[extrDataKey]||"";
				// switchCls = i===len-1?"leaf-l":"leaf-m";
				$node = $("<li id='"+id+"' extrData='"+extrData+"' deep='"+deep+"'  sortCode='"+sortCode+"'><span class='icon leaf-m' expand='false'></span><a class='node' type='leaf' ><span class='text' title='"+name+"'>"+name+"</span></a></li>");
				if(pId){
					pNode = tree.find("#"+pId);
					pNode.children("span.icon").removeClass("leaf-m").removeClass("leaf-l").addClass("switchOff");
					if(pNode.children("ul").length===0){
						pNode.append($("<ul class='close'></ul>").append($node));
					}else{
						pNode.children("ul").append($node)
					}
					
				}else{
					tree.append($node);
				}
			}
			
		}
		
		// config.delteUrl
		function deleteNode(node){
		   var flag;
		   if(!this.isTreeNode(node)) return;
	       if(this.isParent(node)){
               message.showMessageN({
                    title:"提示",
                    msg:"无法删除父级节点！",
                    style:config.messageStyle||"",
                    animation:"hui-swing",
                    mask:true
               });
               return;
	       }
	       if(config.getLeafDataURL){
	          // 同步请求 叶子是否包含数据
              $.ajaxSeentao(config.getLeafDataURL||"",$.formatParSeentao($selectNode.parent().attr("id")),function(data){
                var json = $.parseJsonSeentao(data)
                flag =  json.data.length===0?false:true;
              },{type:"get",async:false})
              if(flag===true){
                    // 包含数据
                     message.showMessageN({
                        title:"提示",
                        msg:"节点包含数据！无法删除！",
                        style:config.messageStyle||"",
                        animation:"hui-swing",
                        mask:true
                    });
                   return;
              }
	       }
	       
	        // 删除节点
	        message.showConfirm({
                msg:"确定删除吗？",
                mask:true,
                style:config.confirmStyle||"",
                callback:function(ok){
                if(ok){
                    $.ajaxSeentao(config.delteUrl,$.formatParSeentao(node.parent().attr("id")),function(data){
                        var json = $.parseJsonSeentao(data)            
                        node.parent().remove();
                        selectedNode=null;
                        // refreshDeep();
                        message.showMessage("提示",json.message,true,false,true,config.messageStyle);
                    })
                  }
                }               
           });
	        return this;
		}
		// 添加节点
		function addNode(form){
			var seleNode =this.getSelectNode();
        	var nDeep = this.getAddCod(seleNode),
        		sId = this.getNodeId(seleNode),
        		sDepNum = this.getDeep(seleNode),
                newID;
        	if(sDepNum>=config.maxDeep){
        		message.showMessageN({
                        title:"提示",
                        msg:"已达到最大层级，不能添加下一级！",
                        style:config.messageStyle||"",
                        animation:"hui-swing",
                        mask:true
                    });
        		return;
        	}
        	if(sId==="0") sId ="";
        	// 提交请求
        	// parent,node;
			// par=form.formatSeentao();
			form.submitSeentao(config.addNodeUrl,function(data){
				// 添加
				var name="",
					id="",
					newNode;
				if(data){
					name  = data.name;
					id  = data._id;
				}
                newID = id;
				newNode = $("<li id='"+id+"' deep='"+nDeep+"'><span class='icon leaf-m' expand='false'></span><a class='node' type='leaf' ><span class='text'>"+name+"</span></a></li>");
				insertNode(newNode,seleNode.parent());
			},{pId:sId,node:nDeep},{async:false});
			return newID;
		}



		function  refreshDeep(){
			$.ajaxSeentao(config.url,config.queryPar||{},function(data){
				var json  = $.parseJsonSeentao(data);
				for(var i =0,len =json.length;i<len;i++ ){
					node = json[i];				
					id=node._id;
					deep = node.node;	
					$("#id").attr("deep",deep);
				}
			})	
		}
		if(config.localData){
			loadData(config.localData)
		}else if(config.url){
			$.ajaxSeentao(config.url,config.queryPar||{},function(data){
				loadData(data)
			})
		}
		


		var data =[{"id":"4","pId":"","name":"c","node":"01"},
		{"id":"E3TZFNTYFHN4FHJ3CXL_CQ","pId":"","name":"java","node":"02"},
		{"id":"5","pId":"4","name":"c++","node":"0101"},
		{"id":"FH9-EXF6FHF2FHH0C3V8FQ","pId":"E3TZFNTYFHN4FHJ3CXL_CQ","name":"e","node":"0201"},
		{"id":"FHN0DNZ8FHX4FNN-ENT8GA","pId":"4","name":"ccccc","node":"0102"},
		{"id":"2","pId":"FH9-EXF6FHF2FHH0C3V8FQ","name":"php","node":"020101"},
		{"id":"CNR2GHZ2FHX2FNLXE39XCQ","pId":"FHN0DNZ8FHX4FNN-ENT8GA","name":"12121212","node":"010201"},
		{"id":"ENF8ENJ5FHN2CYB7GHD1DW","pId":"FHN0DNZ8FHX4FNN-ENT8GA","name":"22222","node":"010202"},
		{"id":"FHZYDNN1FHT1DHP5E3L3DW","pId":"FHN0DNZ8FHX4FNN-ENT8GA","name":"接收方","node":"010203"},
		{"id":"EN93C3H_FHP4DH94D3R7CG","pId":"ENF8ENJ5FHN2CYB7GHD1DW","name":"11111111111111111","node":"01020201"},
		{"id":"ENH8DXV6FH54EXH1CXZ1GA","pId":"ENF8ENJ5FHN2CYB7GHD1DW","name":"456456465","node":"01020202"},
		{"id":"GHN5DXD1FHL4EHD8FHR2EA","pId":"FHZYDNN1FHT1DHP5E3L3DW","name":"123333","node":"01020301"}]
	   
		data=[{"sortupId":"FHH7DHNXFH14DXZ_DXZXFW","pId":"","name":"1","node":"01","sortCode":"01"},{"sortupId":"D3N_CND5FHZ2DHJ6CX1_EQ","pId":"","name":"进料后勤","node":"01","sortCode":"01"},{"sortupId":"FXD7CNH_FHF2CXD0CN91FG","pId":"D3N_CND5FHZ2DHJ6CX1_EQ","name":"1","node":"0101","sortCode":"0101"},{"sortupId":"DNH1DHP3FIB3E3P_E3D_FW","pId":"FHH7DHNXFH14DXZ_DXZXFW","name":"11","node":"0101","sortCode":"0101"},{"sortupId":"E3T0EH10FHL1CXP9C3J0EG","pId":"DNH1DHP3FIB3E3P_E3D_FW","name":"111","node":"010101","sortCode":"010101"},{"sortupId":"DNDXFXL0FHD3FXL5FNT9FQ","pId":"FXD7CNH_FHF2CXD0CN91FG","name":"11","node":"010101","sortCode":"010101"},{"sortupId":"FN92DHFZFHR1FXV0ENR_CQ","pId":"DNDXFXL0FHD3FXL5FNT9FQ","name":"111","node":"01010101","sortCode":"01010101"},{"sortupId":"DXH_CXQAFHD3CXT9E3IACW","pId":"FN92DHFZFHR1FXV0ENR_CQ","name":"rrr","node":"0101010101","sortCode":"0101010101"},{"sortupId":"EXKADXL4FHL2E3H5EIB5FG","pId":"D3N_CND5FHZ2DHJ6CX1_EQ","name":"2","node":"0102","sortCode":"0101"},{"sortupId":"E356C3L5FH13EHJ_FH17EW","pId":"D3N_CND5FHZ2DHJ6CX1_EQ","name":"123","node":"0103","sortCode":"0103"},{"sortupId":"DHF6DNR4FHX2CND9DOB4CQ","pId":"","name":"22222","node":"02","sortCode":"02"},{"sortupId":"EXAAF4B3FHZ2FNPXCN11EA","pId":"","name":"研究","node":"02","sortCode":"02"},{"sortupId":"F395DND7FH12EXD5DHF0FW","pId":"","name":"2","node":"02","sortCode":"02"},{"sortupId":"DH50CXFYFHT1DX10DXV4DA","pId":"F395DND7FH12EXD5DHF0FW","name":"22","node":"0201","sortCode":"0201"},{"sortupId":"DHH2CXZ3FHZ1FXH1FH9_EW","pId":"DH50CXFYFHT1DX10DXV4DA","name":"222","node":"020101","sortCode":"020101"},{"sortupId":"EHF7CNT3FHH4D3T_DNR2EQ","pId":"","name":"3","node":"03","sortCode":"02"},{"sortupId":"F3F8FHL_FHD2DXT1EYCACG","pId":"","name":"发货后勤","node":"03","sortCode":"03"},{"sortupId":"F3R1FXP6FHD2DNH4ENH_CQ","pId":"","name":"4","node":"04","sortCode":"04"},{"sortupId":"DHHZE3D0FHF1FHJ9FNL6DA","pId":"","name":"销售","node":"04","sortCode":"04"},{"sortupId":"CXZXFHFZFHD3DHJXGHH_FQ","pId":"","name":"5","node":"05","sortCode":"04"},{"sortupId":"F3D3CN15FIB2DN18CXD9FG","pId":"","name":"服务","node":"05","sortCode":"05"},{"sortupId":"C3UADH18FHT4CYB2DHN3CG","pId":"","name":"6","node":"06","sortCode":"04"},{"sortupId":"D3LZFNT_FHZ1CX1_FNV0FQ","pId":"","name":"采购与物料管理","node":"06","sortCode":"06"},{"sortupId":"EXR8FXJ4FHV1DHHXE3X_DW","pId":"","name":"7","node":"07","sortCode":"04"},{"sortupId":"ENL_FNRXFHV2CNMAF3Z6FW","pId":"","name":"8","node":"08","sortCode":"04"},{"sortupId":"CXH3ENR_FHN4DND7D319EW","pId":"","name":"人力资源管理","node":"08","sortCode":"08"},{"sortupId":"E390DNT4FHR1CXZ6GH5_DA","pId":"","name":"9","node":"09","sortCode":"04"},{"sortupId":"FHDXDHPZFHD2DH53EXV9DW","pId":"","name":"企业基础制度","node":"09","sortCode":"09"},{"sortupId":"DND_ENJ2FH91EHH2FXTYDW","pId":"","name":"生产作业","node":"1","sortCode":"1"},{"sortupId":"DN99EXV1FIB1C4B4EHN_FW","pId":"","name":"测试数据","node":"10","sortCode":"10"},{"sortupId":"DXD1FXNZFHX2C3XXEHZ7GA","pId":"","name":"生产作业","node":"10","sortCode":"10"},{"sortupId":"E4B9EHF9FHT2D3L_DX16FG","pId":"DN99EXV1FIB1C4B4EHN_FW","name":"测试项目1","node":"1001","sortCode":"1001"},{"sortupId":"DNP1CXR2FH51DX5XEHEACG","pId":"E4B9EHF9FHT2D3L_DX16FG","name":"测试项目11","node":"100101","sortCode":"100101"},{"sortupId":"FHL8EXN3FHV4DN98DIB6FQ","pId":"CXH3ENR_FHN4DND7D319EW","name":"11111111","node":"101","sortCode":"101"},{"sortupId":"ENH1D317FHN2FN19FN16FW","pId":"DND_ENJ2FH91EHH2FXTYDW","name":"1111111","node":"101","sortCode":"101"}];
	    // loadData(data);
		
		return {
			getParentNodes:function(node,ignoreRoot){
				var ret =[];
				if(this.isTreeNode(node)){
					node.parent().parents(".sttree li").each(function(index,dom){
						var _dom = $(dom);
						if(ignoreRoot&&_dom.attr("deep")=="0"){
							return;
						}
						ret.push(_dom.children("a.node"));
					})
				}
				return ret;
			},
			getParentNode:function(node){
				return this.isTreeNode(node)?node.parent().parent().siblings("a.node"):null;
			},
			getExtrData:function(node){
				// extrData
				return (this.isTreeNode(node)&&node.parent().attr("extrData"))||null;
			},
			nodeText:function(node,text){
				if(!this.isTreeNode(node)) return;
				if(typeof text==="undefined"){
					return node.children("span").html();
				}else{
					node.children("span").html(text);
					return this;
				}
			},
			addNode:addNode,
			selectNode:function(node,fireEvents){
				if(!this.isTreeNode(node)) return;
				if(selectedNode){
					selectedNode.removeClass("nodeSelect");
				}
				selectedNode=node.addClass("nodeSelect");
				if(fireEvents!==false&&$.isFunction(config.selectCallback)){
					config.selectCallback.call(this,selectedNode.children("span.text").html(),node);
				}
				return this;
			},
			selectNodeById:function(id,fireEvents){
				var node = this.getNodeById(id);
				this.selectNode(node,fireEvents);
				return this;
			},
			getSelectNode:function(){
				return selectedNode||null;
			},
			getAddCod:function(node){
				var nDeep,subDeep,sDeep;
				if(!this.isTreeNode(node)) return null;
				sDeep =this.getNodeDeep(node);
              	childNodes = this.getChildNodes(node);
              	if(childNodes.length===0){
					nDeep="01";
              	}else{
              		subDeep = this.getNodeDeep(childNodes[childNodes.length-1]);
              		subDeep = subDeep.slice(subDeep.length-2);
              		// console.log(subDeep)
              		nDeep =parseInt(subDeep)+1;
              		if(nDeep<10) nDeep = "0"+nDeep;
              	}
              	nDeep = sDeep==="0"?nDeep:sDeep+nDeep;
              	return nDeep;
			},
			isParent:function(node){
				if(!this.isTreeNode(node)) return false;
				return  node.parent().children("ul").children("li").length>0?true:false;	
			},
			isRootNode:function(node){
				if(this.isTreeNode(node)&&node.parent().attr("deep")==="0") return true;
				return false;
			},
			getNodeId:function(node){
				return (this.isTreeNode(node)&&node.parent().attr("id"))||null;
			},
			getSortCode:function(node){
				return (this.isTreeNode(node)&&node.parent().attr("sortCode"))||null;
			},
			// 这个获取的是deep属性 是node字段，排序用
			getNodeDeep:function(node){
				return (this.isTreeNode(node)&&node.parent().attr("deep"))||null;	
			},
			// 这个获取的是当前节点的深度
			getDeep:function(node){
				var deep = this.getNodeDeep(node);
				if(deep){
					if(deep==="0"){
						return 0;
					}else{
						return deep.length/2;
					}
				}
				return null;
			},
			getChildNodes:function(node){
				var ret =[];
				if(this.isTreeNode(node)){
					node.siblings("ul").children("li").each(function(index,dom){
						ret.push($(dom).children("a.node"));
					})
				}
				return ret;
			},
			isTreeNode:function(ele){
				if(ele&&ele.attr&&(ele.attr("class")||"").indexOf("node")>-1&&ele.children("span.text").length>0){
					return true;
				}
				return false;
			},
			getNodeById:function(id){
				var res = container.find("li[id="+id+"]").children("a.node");
				return res.length>0?res:null;
			},
			deleteNode:deleteNode,
			reload:function(){
				container.html("");
				if(config.localData){
					loadData(config.localData)
				}else if(config.url){
					$.ajaxSeentao(config.url,config.queryPar||{},function(data){
						loadData(data);
					})
				}
				return this;
			}
			
		}
	}// end sttree
	/**
	 * 拖拽 效果
	 * 
	 * 被拖拽的元素 加一个 class : drag 拖拽的放置容器加一个 class : drop
	 * 
	 * 关闭按钮（被拖拽元素取消图标）加一个class :drag-clsbtn 拖拽结束的 确定按钮 加一个class:drag-confirmbtn
	 * 对被拖拽的元素的父元素调用dragableSeentao()
	 * 
	 * 如果不允许重复拖拽，在呗拖拽元素上家dataId属性，这个属性的值应该能唯一标识被托拽元素
	 * 
	 * 注:如果拖拽操作特殊，不是简单的往有“drop” class的元素里添加拖拽元素，可以不添加任何class
	 * “drop”。通过endCallback 回调来自行处理。
	 */
	 $.fn.dragableSeentao = function(config){
	 	  var $container = this.eq(0),$doc = $(document),
	 	  timeout=null,startFlag,button,dragElement,dropElement,
	 	  container = $container.get(0),isPad = (/(.*\bandroid\b.*)|((.*\bios\b.*))/ig).test(navigator.userAgent);
	 	  // <a class="mic-icon-drag iconfont drag-clsbtn">&#xf0155;</a>
	 	  // $container.find(".drag").prepend($("<a class='iconfont
			// drag-clsbtn'>&#xf0155;</a>"));
	 	  $container.mouseout(function(){
              clearTimeout(timeout);
	 	  });
	 	  function dragStart(e){
	 	      var $target = $(e.target),clsName = $target.attr("class")||"",
	 	          pageX,pageY,width,height;
// clearTimeout(timeout);
// timeout = setTimeout(function(){
// startFlag = true;
// $container.find(".drag").addClass("ring_repeat");
// $(".drop").eq(0).find(".drag-clsbtn").css({display:"inline",visibility:"visible"});
//	 	         
// },500);
	 	      if(clsName.split(/\s+/).indexOf("drag")>-1){ 
	 	         startFlag=true;
	 	         dragElement=$target.clone().addClass("dragTemp");
	 	         pageX = e.pageX;pageY =e.pageY;
	 	         if(e.touches&&e.touches[0]){
	 	             width = dragElement.width();
                     height = dragElement.height();
                     // pageX = e.touches[0].pageX-Math.ceil(width/2);
                     // pageY = e.touches[0].pageY-Math.ceil(height/2);
                     pageX = e.touches[0].pageX+Math.ceil(width/4);
                     pageY = e.touches[0].pageY+Math.ceil(height/4);
                
	 	         }
	 	         
	 	         $("body").append(dragElement);
                    dragElement.css({
	 	                 position:"absolute",
	 	                 left:pageX+5+"px",
	 	                 top:pageY+5+"px",
	 	             });
	 	             dragElement.find(".drag-clsbtn").css({display:"inline",visibility:"visible"});
	 	             $("body").css("cursor","move");
	 	             
	 	        if($.isFunction(config.startCallback)){
                     config.startCallback.call(null,$container);
                  }
	 	      } 
	 	  }
	 	  function dragMove(e){
	 	     var pageX,pageY,width,height;
	 	     if(dragElement){
                 pageX = e.pageX;pageY =e.pageY;
                 if(e.touches&&e.touches[0]){
                     if(e.touches.length!==1){
                        dragElement.remove();
                        dragElement=null;
                        dropElement=null;
                        return;
                     }
                     width = dragElement.width();
                     height = dragElement.height();
                     // pageX = e.touches[0].pageX-Math.ceil(width/2);
                     // pageY = e.touches[0].pageY-Math.ceil(height/2);
                     pageX = e.touches[0].pageX+Math.ceil(width/4);
                     pageY = e.touches[0].pageY+Math.ceil(height/4);
                 }
	 	         dragElement.removeClass("ring_repeat").css({
                    left:pageX+"px",
                    top:pageY+"px"
                 });
	 	     }
	 	  }
	 	  function dragStop(e){
	 	     var $target = $(e.target),clsName = ($target.attr("class")||"").split(/\s+/),
                 dataId,success=false;
             // console.log($target.attr("class")||"")
             // if(clsName.indexOf("drop")>-1){dropElement = $target}
	 	     clearTimeout(timeout);
	 	     if(dragElement&&startFlag&&dropElement){           
                 dataId = dragElement.attr("dataId");
                 if(dropElement.find(".drag[dataId="+dataId+"]").length>0){
                     dragElement.remove();
                     dragElement=null;
                     e.preventDefault();
					 $("body").css("cursor","default");
                     return;
                 }
	 	         dragElement.css({
                    position:"relative",
                    left:"0px",
                    top:"0px"
                 });
                 dragElement.removeClass("dragTemp");
	 	         dropElement.append(dragElement);
	 	         success=true;
	 	     }else if(dragElement){
	 	         dragElement.remove();
	 	     }
	 	     if($.isFunction(config.endCallback)){
                    config.endCallback.call(null,$target,dragElement,dropElement,success);
             }
	 	     dragElement=null;
	 	     dropElement=null;
	 	     $("body").css("cursor","default");
	 	  }
	      
	      $container.mousedown(dragStart);
	      $doc.mouseup(dragStop);
	      $doc.mousemove(dragMove);
	      
          container.ontouch = document.ontouch=function(e){
             e.preventDefault();   
          }
          
          container.ontouchstart = dragStart;
          container.ontouchend = dragStop;
          container.ontouchmove = dragMove;
           
          $doc.mouseover(function(e){
               var $target = $(e.target),
               clsName = ($target.attr("class")||"").split(/\s+/),
               dropEle=null,parents =$target.parents().filter(".dropArea") ;
               
// parClsName = ($target.parent().attr("class")||"").split(/\s+/);
// if(clsName.indexOf("drop")>-1){
// dropElement = $target;
// return;
// }
// if(parClsName.indexOf("drop")>-1){
// dropElement = $target.parent();
// return;
// }
                if(clsName.indexOf("dropArea")>-1){
                      dropEle = $target.find(".drop");
                }else if(parents.length>0){
                    dropEle = parents.find(".drop");       
                }
               dropElement = dropEle?(dropEle.length>0?dropEle:null):null;   
          })
          
          $doc.mouseout(function(e){
            dropElement = null
          })
          
          $doc.mousedown(function(e){
                var tag = e.target.nodeName.toUpperCase();
                if(["INPUT","TEXTAREA","SELECT"].indexOf(tag)<0){
                  e.preventDefault();
                }
          })
           $doc.mousemove(function(e){
                e.preventDefault();
          })
           
           
          $doc.click(function(e){
            var $target = $(e.target),clsName = ($target.attr("class")||"").split(/\s+/);
            if(clsName.indexOf("drag-clsbtn")>-1){
                if($.isFunction(config.cancelCallback)){
                    config.cancelCallback.call(null,$target.parent());
                }
                $target.parent().remove();
            }else if(clsName.indexOf("drag-confirmbtn")>-1){
                startFlag = false;
                $doc.find(".drag-clsbtn").css({display:"inline",visibility:"hidden"});
                $container.find(".drag").removeClass("ring_repeat");
                if($.isFunction(config.confirmCallback)){
                    config.confirmCallback.call(null);
                }
            }
          });
          return this;
	 }

     $.fn.src = function(src){
       this.each(function(index,iframe){
           var $iframe= $(iframe),inited = $iframe.attr("inited"),height,frameWin;
           if(!$iframe.is("iframe")) return;
            $iframe.hide();
            $iframe.attr("src",src); 
            $iframe.show("slow");
       })
    }
    
    
    // step_warpd
    $.setStepText=function(arr){
        var topWin = window.top,
            $stepWarp =topWin.$(".step_warp ul li a p");
            $stepWarp.each(function(index,dom){
                $(dom).html(arr[index]||"");
            })
    }
    
    $.nextStep=function(){
        var topWin = window.top,
            $stepWarp =topWin.$(".step_warp"), 
            currStep=$stepWarp.find("ul").attr("class"),
            stepNum = $stepWarp.find("ul li").length;
            currStep =parseInt(currStep.match(/^.*(\d+)$/i)[1],10)||1;
            // console.log(JSON.stringify(currStep.match(/^.*(\d+)$/i)));
            if(currStep<stepNum){
               $stepWarp.find("ul").attr("class","step_0"+(currStep+1))         
            }
    }
    
    $.preStep = function(){
        var topWin = window.top,
            $stepWarp =topWin.$(".step_warp"), 
            currStep=$stepWarp.find("ul").attr("class"),
            stepNum = $stepWarp.find("ul li").length;
            currStep =parseInt(currStep.match(/^.*(\d+)$/i)[1],10)||1;
            // console.log(JSON.stringify(currStep.match(/^.*(\d+)$/i)));
            if(currStep>1){
               $stepWarp.find("ul").attr("class","step_0"+(currStep-1))         
            }
    };
    




    // 鼠标滚动 支持
    (function (factory) {
    if ( typeof define === 'function' && define.amd ) {
        define(['jquery'], factory);
    } else if (typeof exports === 'object') {
        module.exports = factory;
    } else {
        // Browser globals
        factory(jQuery);
    }
	}(function ($) {

    var toFix  = ['wheel', 'mousewheel', 'DOMMouseScroll', 'MozMousePixelScroll'],
        toBind = ( 'onwheel' in document || document.documentMode >= 9 ) ?
                    ['wheel'] : ['mousewheel', 'DomMouseScroll', 'MozMousePixelScroll'],
        slice  = Array.prototype.slice,
        nullLowestDeltaTimeout, lowestDelta;

    if ( $.event.fixHooks ) {
        for ( var i = toFix.length; i; ) {
            $.event.fixHooks[ toFix[--i] ] = $.event.mouseHooks;
        }
    }

    var special = $.event.special.mousewheel = {
        version: '3.1.9',

        setup: function() {
            if ( this.addEventListener ) {
                for ( var i = toBind.length; i; ) {
                    this.addEventListener( toBind[--i], handler, false );
                }
            } else {
                this.onmousewheel = handler;
            }
            // Store the line height and page height for this particular element
            $.data(this, 'mousewheel-line-height', special.getLineHeight(this));
            $.data(this, 'mousewheel-page-height', special.getPageHeight(this));
        },

        teardown: function() {
            if ( this.removeEventListener ) {
                for ( var i = toBind.length; i; ) {
                    this.removeEventListener( toBind[--i], handler, false );
                }
            } else {
                this.onmousewheel = null;
            }
        },

        getLineHeight: function(elem) {
            return parseInt($(elem)['offsetParent' in $.fn ? 'offsetParent' : 'parent']().css('fontSize'), 10);
        },

        getPageHeight: function(elem) {
            return $(elem).height();
        },

        settings: {
            adjustOldDeltas: true
        }
    };

    $.fn.extend({
        mousewheel: function(fn) {
            return fn ? this.bind('mousewheel', fn) : this.trigger('mousewheel');
        },
        unmousewheel: function(fn) {
            return this.unbind('mousewheel', fn);
        }
    });


    function handler(event) {
        var orgEvent   = event || window.event,
            args       = slice.call(arguments, 1),
            delta      = 0,
            deltaX     = 0,
            deltaY     = 0,
            absDelta   = 0;
        event = $.event.fix(orgEvent);
        event.type = 'mousewheel';

        // Old school scrollwheel delta
        if ( 'detail'      in orgEvent ) { deltaY = orgEvent.detail * -1;      }
        if ( 'wheelDelta'  in orgEvent ) { deltaY = orgEvent.wheelDelta;       }
        if ( 'wheelDeltaY' in orgEvent ) { deltaY = orgEvent.wheelDeltaY;      }
        if ( 'wheelDeltaX' in orgEvent ) { deltaX = orgEvent.wheelDeltaX * -1; }

        // Firefox < 17 horizontal scrolling related to DOMMouseScroll event
        if ( 'axis' in orgEvent && orgEvent.axis === orgEvent.HORIZONTAL_AXIS ) {
            deltaX = deltaY * -1;
            deltaY = 0;
        }

		delta = deltaY === 0 ? deltaX : deltaY;

        if ( 'deltaY' in orgEvent ) {
            deltaY = orgEvent.deltaY * -1;
            delta  = deltaY;
        }
        if ( 'deltaX' in orgEvent ) {
            deltaX = orgEvent.deltaX;
            if ( deltaY === 0 ) { delta  = deltaX * -1; }
        }

        // No change actually happened, no reason to go any further
        if ( deltaY === 0 && deltaX === 0 ) { return; }

        // Need to convert lines and pages to pixels if we aren't already in
		// pixels
        // There are three delta modes:
        // * deltaMode 0 is by pixels, nothing to do
        // * deltaMode 1 is by lines
        // * deltaMode 2 is by pages
        if ( orgEvent.deltaMode === 1 ) {
            var lineHeight = $.data(this, 'mousewheel-line-height');
            delta  *= lineHeight;
            deltaY *= lineHeight;
            deltaX *= lineHeight;
        } else if ( orgEvent.deltaMode === 2 ) {
            var pageHeight = $.data(this, 'mousewheel-page-height');
            delta  *= pageHeight;
            deltaY *= pageHeight;
            deltaX *= pageHeight;
        }

        // Store lowest absolute delta to normalize the delta values
        absDelta = Math.max( Math.abs(deltaY), Math.abs(deltaX) );

        if ( !lowestDelta || absDelta < lowestDelta ) {
            lowestDelta = absDelta;

            // Adjust older deltas if necessary
            if ( shouldAdjustOldDeltas(orgEvent, absDelta) ) {
                lowestDelta /= 40;
            }
        }

        // Adjust older deltas if necessary
        if ( shouldAdjustOldDeltas(orgEvent, absDelta) ) {
            // Divide all the things by 40!
            delta  /= 40;
            deltaX /= 40;
            deltaY /= 40;
        }

        // Get a whole, normalized value for the deltas
        delta  = Math[ delta  >= 1 ? 'floor' : 'ceil' ](delta  / lowestDelta);
        deltaX = Math[ deltaX >= 1 ? 'floor' : 'ceil' ](deltaX / lowestDelta);
        deltaY = Math[ deltaY >= 1 ? 'floor' : 'ceil' ](deltaY / lowestDelta);

        // Add information to the event object
        event.deltaX = deltaX;
        event.deltaY = deltaY;
        event.deltaFactor = lowestDelta;
        event.deltaMode = 0;

        // Add event and delta to the front of the arguments
        args.unshift(event, delta, deltaX, deltaY);

    	if (nullLowestDeltaTimeout) { clearTimeout(nullLowestDeltaTimeout); }
        nullLowestDeltaTimeout = setTimeout(nullLowestDelta, 200);

        return ($.event.dispatch || $.event.handle).apply(this, args);
    }

    function nullLowestDelta() {
        lowestDelta = null;
    }

    function shouldAdjustOldDeltas(orgEvent, absDelta) {
    	return special.settings.adjustOldDeltas && orgEvent.type === 'mousewheel' && absDelta % 120 === 0;
    }

	}));




	/**
	 * 表单验证
	 * 
	 * 默认的datatype： e n 等
	 * 
	 * 
	 * 自定义datatype格式 { "SZ2":function(inputVal,inputObj){},
	 * "自定义":function(inputVal,inputObj){} }
	 * 
	 * 函数返回true表示验证通过 返回字符串为提示信息！
	 * 
	 */
	$.fn.validFormSeentao = function(config){
		var global = arguments.callee;
		if(typeof $.fn.Validform !=="function"&&typeof $.fn.Validform !=="object"){
			console.log("请引用表单验证JS!");
			return;		
		}
		this.each(function(index,dom){
			var _form = $(dom);
			if(!_form.is("form")) return;
			_form.Validform({
				datatype:config.datatype||{},
				tiptype:function(msg,target){
                	var tipBox,
                		left,
                		top,
                		width,
                		height,
                		timeTag=global.msgId?global.msgId:1,
                		_parent;
                	if(target.type ===3){
                    	if(target.obj.attr("msgid")){
							$("div.validFormMsg[msgid="+target.obj.attr("msgid")+"]").remove();	
                   	 	}   
						target.obj.addClass("validFormErr");
                    	target.obj.attr("msgid",timeTag);
                    	global.msgId = timeTag+1;
	                    tipBox = $("<div class='validFormMsg hui-ring' msgid='"+timeTag+"'>"+msg+"</div>")
	                    tipBox.css("width",msg.length*13+10<35?35:msg.length*13+10);
	                    

	                    left = target.obj.offset().left;
                    	width = target.obj.width();
                    	top = target.obj.offset().top;

                    	if(target.obj.parents("div.stscroll-content").length>0){
                    		_parent = target.obj.parents("div.stscroll-content");
                    		// left = target.obj
                    		top = top+_parent.parent().scrollTop();
                    	}else{
                    		_parent=$("body");
                    	}

                        if(target.obj.parents().filter(function(i,v){return $(v).css("position")==="fixed"?true:false}).length>0){
                            // 有fixed定位
                            tipBox.css("position","fixed");
                            top-=$(window).scrollTop();
                        }else{
                            tipBox.css("position","absolute");
                        }
                    	tipBox.appendTo(_parent).css({
                        	left:left+width*1/2,
                        	top:top-tipBox.height(),
                        	zIndex:9999
                    	});


                        setTimeout(function(){
                            tipBox.remove();
                            target.obj.attr("msgid",null);
                            target.obj.removeClass("validFormErr Validform_error");
                        },2000);

               		}else{
                		var curTimeTag = target.obj.attr("msgid");
                		$("div.validFormMsg[msgid="+curTimeTag+"]").remove();
                		target.obj.attr("msgid",null);
                		target.obj.removeClass("validFormErr");
               		}
            	}
			});
		});
		return this;
	}
	
	$.clearValidMsg = function(obj){
		var msgID ;
		if(typeof obj ==="string"){
			obj = $("#"+obj);
		}else if(typeof obj==="object"){
			obj= $(obj)
		}
		if(obj){
			msgID = obj.attr("msgid");
			$("div.validFormMsg[msgid="+msgID+"]").remove();
			$("input[datatype][msgid="+msgID+"],select[datatype][msgid="+msgID+"]").each(function(index,dom){
				$(dom).removeClass("validFormErr Validform_error")
			})

		}else{
			$("div.validFormMsg").remove();
			$("input[datatype],select[datatype]").each(function(index,dom){
				$(dom).removeClass("validFormErr Validform_error")
			})
		}
		
	}


	$.fn.validCheckSeentao = function(){
		if(typeof $.fn.Validform !=="function"&&typeof $.fn.Validform !=="object"){
			console.log("请引用表单验证JS!");
			return;		
		}
		var form =  this.eq(0);
		if(!form.is("form")) return;
		return form.Validform().check();
	}


	// 自定义 单选 复选 赋值
	$.fn.checked = function(flag){
		this.each(function(index,dom){
			var _dom = $(dom),
				type =_dom.attr("type"),
				_parent =_dom.parent(),
				_icon;
			if((_parent.attr("class")||"").indexOf("stCheckBox")<0) return; 	
			_icon =_dom.siblings().filter("i.iconfont"); 
			if(type==="checkbox"){
				_dom.prop("checked",flag);
				if(flag){
					_icon.html("&#xf00b2;");
					// _parent.addClass("hui-flipin01").removeClass("hui-flipin02");
				}else{
					_icon.html("");
					// _parent.addClass("hui-flipin02").removeClass("hui-flipin01");
				}
			}else if(type==="radio"){
				_dom.prop("checked",flag);
				var name  = _dom.attr("name");
				$("input[type=radio][name="+name+"]").each(function(index,dom){
					var _dom = $(dom);
					var _icon = _dom.siblings().filter("i.iconfont");
					if(_dom.prop("checked")){
						_icon.css({
						}).html("&#xf018e;");
					}else{
						_icon.css({
						}).html("");
					}
					_icon.removeClass("hui-flipin01");
				});
				_icon.addClass("hui-flipin01");
			}
		});
		return this;
	}
	// 选择框 置灰
	$.fn.checkDisable=function(){




	}


	// 自定义 复选
	// 如果数据是动态加载的 需要重新调用$.initCheckBox();
	$.initCheckBox=function(){
        $("input.checkboxSeentao").each(function(index,dom){
			var _dom = $(dom),
        	height,
        	width,
        	left,
        	top,
        	color,
        	margin,
        	_class,
        	_checkbox,
        	iconCode,
        	icon_class,
        	_clone;
        	// if((_dom.parent().attr("class")||"").indexOf("stCheckBox")>-1)
			// return;
        	width = _dom.width();
        	height = _dom.height();
        	left = _dom.offset().left;
        	top = _dom.offset().top;
        	margin = _dom.css("margin");
        	color = _dom.css("color");
        	_class =_dom.attr("class");
        	if(_dom.prop("checked")){
        		iconCode = "&#xf00b2;";
        	}else{
        		iconCode = "";
        	}
        	_clone = _dom.clone().css({
				width:width,
				height:height,
				margin:0
        	}).attr("class","");
        	if(_dom.attr("disabled")){
        		icon_class="stinputIcondisable";
        	}
        	_dom.after($("<span class='"+_class+" stCheckBox'></span>").append($("<i class='iconfont stinputIcon "+icon_class+"'>"+iconCode+"</i>").css({
				width:width,
				height:height,
				lineHeight:height+"px",
				fontSize:width*3/5+"px",
				color:color,
				border:"2px solid "+color
			})).append(_clone)).remove();

			_clone.click(function(e){
				var _this =$(this),_icon =_this.siblings().filter("i.iconfont"); 
				// &#xf00b2;
				if(_this.prop("checked")){
					_icon.css({
						// color:"white",
						// background:color
					}).html("&#xf00b2;");
					// _this.parent().addClass("hui-flipin01").removeClass("hui-flipin02");
				}else{
					_icon.css({
						// color:color,
						// background:"white"
					}).html("");
					// _this.parent().addClass("hui-flipin02").removeClass("hui-flipin01");
				}
			})
        });
		return this;
	}


	// 自定义 单选
	// 如果数据是动态加载的 需要重新调用$.initRadiobox();
	$.initRadiobox=function(){
		$("input.radioBoxSeentao").each(function(index,dom){
			var _dom = $(dom),
        	height,
        	width,
        	left,
        	top,
        	color,
        	margin,
        	_class,
        	_checkbox,
        	iconCode,
        	_clone;
        	// if((_dom.parent().attr("class")||"").indexOf("stCheckBox")>-1)
			// return;
        	width = _dom.width();
        	height = _dom.height();
        	left = _dom.offset().left;
        	top = _dom.offset().top;
        	margin = _dom.css("margin");
        	color = _dom.css("color");
        	_class =_dom.attr("class");
        	if(_dom.prop("checked")){
        		iconCode = "&#xf00b2;";
        	}else{
        		iconCode = "";
        	}
        	_clone = _dom.clone().css({
				width:width,
				height:height,
				margin:0
        	}).attr("class","");
        	_dom.after($("<span class='"+_class+" stCheckBox'></span>").append($("<i class='iconfont stinputIcon'>"+iconCode+"</i>").css({
				width:width,
				height:height,
				lineHeight:height+"px",
				fontSize:width*3/5+"px",
				color:color,
				display:"inline-block",
				border:"2px solid "+color,
				borderRadius:"50%",
			})).append(_clone)).remove();
			_clone.change(function(e){
				var name  = $(this).attr("name");
				$("input[type=radio][name="+name+"]").each(function(index,dom){
					var _dom = $(dom);
					var _icon = _dom.siblings().filter("i.iconfont");
					if(_dom.prop("checked")){
						_icon.css({
						}).html("&#xf018e;");
					}else{
						_icon.css({
						}).html("");
					}
					// _icon.removeClass("hui-flipin01");
				});
				// $(this).siblings().filter("i.iconfont").addClass("hui-flipin01");
			})
				
        });
		return this;
	}


	// 弹窗选日历
	$.showDatePicker = function(config){
		var month = {
			"1":"January",
			"2":"February",
			"3":"March",
			"4":"April",
			"5":"May",
			"6":"June",
			"7":"July",
			"8":"August",
			"9":"September",
			"10":"October",
			"11":"November",
			"12":"December"
		};
		var week = {
			"0":"Sun",
			"1":"Mon",
			"2":"Tue",
			"3":"Wed",
			"4":"Thu",
			"5":"Fir",
			"6":"Sat"
		};
		var datCache = {},
			yearList = [],
			curr=0,
            noData=false,
			_datePicker=$('<div class="iv2_datepicker"></div>'),singleSelect = config.singleSelect,retArr = []; 
		function loadDateCache(data,yearList,datCache){
			var i,len,dateArr,arrCls;
			for(i=0,len=data.length;i<len;i++){
				dateArr = data[i].split("-");
				if(yearList.indexOf(dateArr[0])<0){
					yearList.push(dateArr[0]);
				}
				if(!datCache[dateArr[0]]){
					datCache[dateArr[0]] = {};
				}
				if(!datCache[dateArr[0]][dateArr[1]]){
					datCache[dateArr[0]][dateArr[1]] = [];
				}
				datCache[dateArr[0]][dateArr[1]].push(dateArr[2]);
			}
			yearList.sort(function(a,b){return a-b;});
			arrCls=yearList.length>1?"":"arow_disable";
			_datePicker.append($('<div class="datepicker_title">虚拟日历</div><div class="datepicker_year"><a class="iconfont arrow arrow_left arow_disable" id="year_pre">&#xf0112;</a><span class="year_text">'+(yearList[0]||"")+'</span><a id="year_next" class="iconfont arrow arrow_right '+arrCls+'">&#xf0114;</a></div><div class="datepicker_monthcont stScroll"></div><div class="datepicker_btn"><a class="cencelbtn">取消</a><a class="okbtn">确认</a></div>'));
		}

		function render(monthObj,year){
			if(!monthObj) return;
			var key,dayList,context = _datePicker.find(".datepicker_monthcont"),
				_html=[],
				index=1,
				arrowCls,
				i,len,dateObj,dateText,selectCls;
			_html.push('<ul class="monthlist">');
			for( key in monthObj){
				dayList= monthObj[key];
				// 排序
				dayList.sort(function(a,b){return a-b;})
				arrowCls = dayList.length<7?"arow_disable":"";
				_html.push('<li><div class="month color_'+index+'"><div class="month_text_zh">'+key+'月</div><div class="month_text_en">'+month[key]+'</div></div><div class="daycon"><a expand="false" class="expand_icon iconfont '+arrowCls+'">&#xf0170;</a><div class="daylist cl">');
				for(i=0,len =dayList.length;i<len;i++){
					dateText = year+"-"+key+"-"+dayList[i];
					dateObj = new Date(year,(key|0)-1,dayList[i]);
					selectCls=retArr.indexOf(dateText)>-1?"daySelected":"";
					_html.push('<div class="day_ret '+selectCls+'" data-date = "'+year+"-"+key+"-"+dayList[i]+'"><div class="week">'+week[dateObj.getDay()]+'</div><div class="day">'+dayList[i]+'</div></div>');
				}
				_html.push("</div></div></li>");
				index=(index)%4+1;
			}
			_html.push('</ul>')
			context.html(_html.join(""));
		}
		function setYearArrow(curr){
			// _datePicker
			var pre = _datePicker.find(".arrow_left"),
				next = _datePicker.find(".arrow_right");
			if(curr<=0){
				curr = 0;
				pre.addClass("arow_disable")
			}else{
				pre.removeClass("arow_disable")
			}
			if(curr>=yearList.length-1){
				curr = yearList.length-1;
				next.addClass("arow_disable")
			}else{
				next.removeClass("arow_disable")
			}
		}
		if(config.localData){
            if(config.localData.length===0){
                noData = true;
            }else{
                loadDateCache(config.localData,yearList,datCache);
                render(datCache[yearList[0]],yearList[0]);

            }

		}else if(typeof config.url==="string"){
			$.ajaxSeentao(config.url,config.par||{},function(data){
                if(!data||data.length===0){
                    noData = true;
                    return;
                }
				loadDateCache(data,yearList,datCache);
				render(datCache[yearList[0]],yearList[0]);

			},{async:false})
		}
		
		if(_datePicker){
			// 日期选择
			_datePicker.delegate(".day_ret","click",function(e){
				// daySelected
				var _this=$(this),pos,date;
				if(singleSelect !=true ){
					_this.toggleClass("daySelected");
					date = _this.attr("data-date");
					if(_this.is(".daySelected")){
						if(retArr.indexOf(date)<0){
							retArr.push(date);			
						}
					}else{
						if((pos = retArr.indexOf(date))>-1){
							// 删除已选日期
							retArr.splice(pos,1);
						}
					}
				}else{
					_datePicker.find(".day_ret").removeClass("daySelected");
					_this.addClass("daySelected");
					retArr=[_this.attr("data-date")];	 	
				}
			});
			// 上一年按钮
			_datePicker.delegate(".arrow_left","click",function(e){
				var _this = $(this);
				if(_this.is(".arow_disable")){
					return;
				}
				curr--;
				_this.siblings(".year_text").html(yearList[curr]);
				render(datCache[yearList[curr]],yearList[curr]);
				setYearArrow(curr);
			});
			// 下一年按钮
			_datePicker.delegate(".arrow_right","click",function(e){
				var _this = $(this);
				if(_this.is(".arow_disable")){
					return;
				}
				curr++;
				if(curr<=yearList.length-1){
					_this.siblings(".year_text").html(yearList[curr]);
					render(datCache[yearList[curr]],yearList[curr]);
				}
				setYearArrow(curr);
			});

			// 展开箭头
			_datePicker.delegate(".expand_icon","click",function(e){
				var _this = $(this),height,expand;
				if(e.target.className&&e.target.className.indexOf("arow_disable")>-1){
					return;
				}
				expand = _this.attr("expand");
				if(expand==="false"){
					_this.parent().css("height",_this.next().outerHeight());
					_this.html("&#xf016f;");
					_this.attr("expand","true");
				}else{
					_this.parent().css("height","66px");
					_this.html("&#xf0170;");
					_this.attr("expand","false");
				}
       			
				
			});

			// 确定按钮
			_datePicker.delegate(".okbtn","click",function(e){
				// retArr
				if($.isFunction(config.callback)){
					config.callback.call(null,retArr)
				}
				window.message&&message.clearMask();
				_datePicker.remove();
			});

			// 取消按钮
			_datePicker.delegate(".cencelbtn","click",function(e){
				window.message&&message.clearMask();
				_datePicker.remove();
			});
		}
			
		var winHeight = $(window).height(),_datePickerTop=0;
		if(winHeight>523){
			_datePickerTop = Math.ceil((winHeight-523)/2);
		}
        if(noData){
            $.showMessage({
                title:"提示",
                message:"请先维护虚拟日历!"
            });
             return;
        }else{
            _datePicker.appendTo($("body")).css("top",_datePickerTop);
        }
		if(config.showMask){
			window.message&&message.showMask();
		}
		// console.log(JSON.stringify(datCache));
	}


	// 虚拟日历插件
	$.fn.virtualDate = function(config){
		var global = arguments.callee;
		var _datePicker,
			dataCache={},
			yearList=[],
			_month,
			_year,monList,currYear=0,currMonth= 0,noData = false;

		_datePicker=$('<div class="virtualDate vd-hide"><div class="vd-header"><div class="vd-icon iconfont">&#xf02e3;</div><a class="iconfont btn vd-year-pre">&#xf0292;</a><input type="text" class="vd-year"><a class="iconfont btn vd-year-next">&#xf02af;</a><span>年</span><a class="iconfont btn vd-month-pre">&#xf0292;</a><input type="text" class="vd-month"><a class="iconfont btn vd-month-next">&#xf02af;</a><span>月</span></div><div class="vd-content"><ul class="vd-daylist-head cl"><li>日</li><li>一</li><li>二</li><li>三</li><li>四</li><li>五</li><li>六</li></ul><ul class="vd-daylist cl"></ul></div><div class="vd-footer"></div></div>');
		_month = _datePicker.find(".vd-month");
		_year = _datePicker.find(".vd-year");
		function loadDateCache(data,yearList,dataCache){
			var i,len,dateArr,arrCls;
			for(i=0,len=data.length;i<len;i++){
				dateArr = data[i].split("-");
				if(yearList.indexOf(dateArr[0])<0){
					yearList.push(dateArr[0]);
				}
				if(!dataCache[dateArr[0]]){
					dataCache[dateArr[0]] = {};
				}
				if(!dataCache[dateArr[0]][dateArr[1]]){
					dataCache[dateArr[0]][dateArr[1]] = [];
				}
				dataCache[dateArr[0]][dateArr[1]].push(dateArr[2]);
			}
			yearList.sort(function(a,b){return a-b;});
		}

		function render(year,month){
			var dateObj,
				i,
				stWeek,
				day,
				maxDay,
				_html=[],
				dayStyle;
			_year.val(year);
			_month.val(month);
			dateObj = new Date(year,(month|0)-1,1);
			stWeek = +dateObj.getDay();
			stWeek = stWeek===0?7:stWeek;
			maxDay = +(new Date(year,month,0)).getDate();
			for(i = 0;i<42;i++){
				day = (i-stWeek<0||i-stWeek+1>maxDay)?"":i-stWeek+1;
				if(dataCache[year][month].indexOf(day+"")>-1){
					dayStyle = "active";
				}else{
					dayStyle = day==""?"":"disable";
				}
				_html.push("<li class='"+dayStyle+"' data-day='"+year+"-"+month+"-"+day+"'>"+day+"</li>");
			}
			_datePicker.find(".vd-daylist").html(_html.join(""));
		}

		if(config.localData){
            if(config.localData.length===0){
                noData=true;
            } else{
                loadDateCache(config.localData,yearList,dataCache);
                monList= Object.getOwnPropertyNames(dataCache[yearList[0]]);
                monList.sort(function(a,b){return a-b;});
                render(yearList[currYear],monList[currMonth]);
            }
		}else if(typeof config.url==="string"){
			$.ajaxSeentao(config.url,config.par||{},function(data){
                if(!data||data.length===0){
                    noData=true;
                    return;
                }
				loadDateCache(data,yearList,dataCache);
				monList= Object.getOwnPropertyNames(dataCache[yearList[0]]);
				monList.sort(function(a,b){return a-b;});
				render(yearList[currYear],monList[currMonth]);
			},{async:false})
		}

		// 事件绑定
		_month.blur(function(e){
			var _this = $(e.target),
				_val = _this.val(),
				year = _year.val(),
				monList;
				monList= Object.getOwnPropertyNames(dataCache[year]);
			if((currMonth=monList.indexOf(_val))<0){
				_val = monList[0];
				currMonth=0;
			}
			render(year,_val);
		});

		_year.blur(function(e){
			var _this = $(e.target),
				_val = _this.val(),
				month = _month.val(),
				monList;
			if((currYear=yearList.indexOf(_val))<0){
				_val = yearList[0];
				currYear=0;
			}
			monList= Object.getOwnPropertyNames(dataCache[_val]);
			if((currMonth=monList.indexOf(month))<0){
				month =monList[0];
				currMonth=0; 
			}
			render(_val,month);
		});

		_datePicker.bind("mousemove",function(e){
			if(e.target.nodeName.toUpperCase()!=="INPUT"){
				e.preventDefault();
				e.stopPropagation();
			}
		});
		_datePicker.bind("mousedown",function(e){
			if($(e.target).is("li.active,a.iconfont")){
				e.preventDefault();
				e.stopPropagation();
			}
		});
		_datePicker.find(".vd-year-pre").click(function(e){
			var monList;
			if(currYear===0){return;}
			currYear = (currYear-1)%yearList.length;
			monList= Object.getOwnPropertyNames(dataCache[yearList[currYear]]);
			render(yearList[currYear],monList[0]);
		});

		_datePicker.find(".vd-year-next").click(function(e){
			currYear = (currYear+1)%yearList.length;
			monList= Object.getOwnPropertyNames(dataCache[yearList[currYear]]);
			render(yearList[currYear],monList[0]);
		});

		_datePicker.find(".vd-month-pre").click(function(e){
			var monList;
			if(currMonth===0){return;}
			monList= Object.getOwnPropertyNames(dataCache[yearList[currYear]]);
			currMonth = (currMonth-1)%monList.length;
			render(yearList[currYear],monList[currMonth]);
		});

		_datePicker.find(".vd-month-next").click(function(e){
			var monList;
			monList= Object.getOwnPropertyNames(dataCache[yearList[currYear]]);
			currMonth = (currMonth+1)%monList.length;
			render(yearList[currYear],monList[currMonth]);
		});

		_datePicker.find(".vd-daylist").click(function(e){
			var _this;
			if((_this=$(e.target)).is("li.active")){
				if(_datePicker.target){
                    if(config.message){
                        $.showConfirm({
                           title:"提示",
                           message:config.message,
                           callback:function(ok){
                               _datePicker.target.val(_this.attr("data-day"));
                               _datePicker.target.data("nocheck","");
                               _datePicker.target.blur();
                               config.confirmCallback(ok);
                            }
                        });
                    }else{
                        _datePicker.target.val(_this.attr("data-day"));
                        _datePicker.target.data("nocheck","");
                        _datePicker.target.blur();
                        if($.isFunction(config.callback)){
                            _passed = config.callback.call(null);
                        }
                    }
				}
				_datePicker.removeClass("vd-show").addClass("vd-hide");
			}
		});

		_datePicker.appendTo("body");
		this.each(function(index,dom){
			$(dom).click(function(e){
				var _this= $(this),
					height = _this.outerHeight(),
					left =_this.offset().left,
					top =_this.offset().top;
                if(noData){
                    $.showMessage({
                        title:"提示",
                        message:"请先维护虚拟日历!"
                    })
                    return;
                }
                if(_this.parents().filter(function(i,v){return $(v).css("position")==="fixed"?true:false}).length>0){
                    // 有fixed定位
                    _datePicker.css("position","fixed");
                    height-=$(window).scrollTop();
                }else{
                    _datePicker.css("position","absolute");
                }
				_datePicker.css({
					left:left+"px",
					top:height+top+"px"
				})
				_datePicker.removeClass("vd-hide").addClass("vd-show");
				_datePicker.target=$(this);
				$(this).data("nocheck","1");
			})
		});
		if(!global.inited){
			$(document).bind("click",function(e){
				if(!$(e.target).is("input,.virtualDate *,.virtualDate")){
					$(".virtualDate").removeClass("vd-show").addClass("vd-hide");
				}
			});
			global.inited=true;
		}
		return this;
	}


	HTMLElement.prototype.WdatePicker = function(){
		var global = arguments.callee,
			dateObj;
		global.self = $(this);
		if(!global.datePicker){
			global.datePicker=$('<div class="stDatepicker vd-hide"><div class="vd-header"><div class="vd-icon iconfont">&#xf02e3;</div><a class="iconfont btn vd-year-pre">&#xf0292;</a><input type="text" class="vd-year"><a class="iconfont btn vd-year-next">&#xf02af;</a><span>年</span><a class="iconfont btn vd-month-pre">&#xf0292;</a><input type="text" class="vd-month"><a class="iconfont btn vd-month-next">&#xf02af;</a><span>月</span></div><div class="vd-content"><ul class="vd-daylist-head cl"><li style="color:red">日</li><li>一</li><li>二</li><li>三</li><li>四</li><li>五</li><li style="color:red">六</li></ul><ul class="vd-daylist cl"></ul></div><div class="vd-footer"></div></div>')
							  .appendTo("body");
			global.datePicker.bind("mousemove",function(e){
				if(e.target.nodeName.toUpperCase()!=="INPUT"){
					e.preventDefault();
					e.stopPropagation();
				}
			});
			global.datePicker.bind("mousedown",function(e){
				if($(e.target).is("li.active,a.iconfont")){
					e.preventDefault();
					e.stopPropagation();
				}
			});
			
			global.datePicker.find(".vd-icon").click(function(e){
				var date = new Date();
				global.self.val(date.getFullYear()+"-"+(~~date.getMonth()+1)+"-"+date.getDate());
				global.datePicker.removeClass("vd-show").addClass("vd-hide");
				global.self.data("nocheck","");
				global.self.blur();
				// render();
			});

			global.datePicker.find(".vd-year").blur(function(e){
				if(!/^\d{4}$/.test($(this).val())){
					$(this).val((new Date()).getFullYear());
				}
				render();
			});
			global.datePicker.find(".vd-month").blur(function(e){
				var val =$(this).val(); 
				if(isNaN(val)||val<1||val>12){
					$(this).val("1");
				}
				render();
			});
			global.datePicker.find(".vd-year-pre").click(function(e){
				var _year = $(this).siblings(".vd-year");
				_year.val(((_year.val()|0)-1));
				render();
			});
			global.datePicker.find(".vd-year-next").click(function(e){
				var _year = $(this).siblings(".vd-year");
				_year.val(((_year.val()|0)+1));
				render();
			});
			global.datePicker.find(".vd-month-pre").click(function(e){
				var _month = $(this).siblings(".vd-month"),
					_year = $(this).siblings(".vd-year");
				if(_month.val()=="1"){
					_year.val(_year.val()-1)
				}
				_month.val((_month.val()|0)-1>0?(_month.val()|0)-1:12);
				render();
			});
			global.datePicker.find(".vd-month-next").click(function(e){
				var _month = $(this).siblings(".vd-month"),
					_year = $(this).siblings(".vd-year");
				if(_month.val()=="12"){
					_year.val((_year.val()|0)+1)
				}
				_month.val(((_month.val()|0)%12+1));
				render();

			});
			global.datePicker.find(".vd-daylist").click(function(e){
				var _this;
				if((_this=$(e.target)).is("li.active")){
					global.self.val(_this.attr("data-day"));
					global.datePicker.removeClass("vd-show").addClass("vd-hide");
					global.self.data("nocheck","");
					global.self.blur();
				}
			});

			$(document).bind("click",function(e){
				if(!$(e.target).is("input,.stDatepicker *,.stDatepicker")){
					global.datePicker.removeClass("vd-show").addClass("vd-hide");
				}
			});
		}

		function render(year,month){
			var dateObj,
				i,
				stWeek,
				day,
				maxDay,
				pre_maxDay,
				_html=[],
				dayStyle;
			year =year||global.datePicker.find(".vd-year").val();
			month = month||global.datePicker.find(".vd-month").val();
			dateObj = new Date(year,(month|0)-1,1);
			stWeek = +dateObj.getDay();
			stWeek = stWeek===0?7:stWeek;
			maxDay = +(new Date(year,month,0)).getDate();
			pre_maxDay = +(new Date(year,month-1,0)).getDate();
			for(i = 0;i<42;i++){
				dayStyle ="active";
				day = (i-stWeek<0||i-stWeek+1>maxDay)?"":i-stWeek+1;
				if(!day){
					day = i-stWeek<0?pre_maxDay+i-stWeek+1:1+i-stWeek-maxDay;
					dayStyle = "disbled"
				}
				_html.push("<li class='"+dayStyle+"' data-day='"+year+"-"+month+"-"+day+"'>"+day+"</li>");
			}
			global.datePicker.find(".vd-daylist").html(_html.join(""));
		}

		if(/^\d{4}-\d{1,2}-\d{1,2}&/.test($(this).val())){

		}
		dateObj = new Date();
		global.datePicker.find(".vd-year").val(dateObj.getFullYear());
		global.datePicker.find(".vd-month").val(~~dateObj.getMonth()+1);
		render();
		setTimeout(function(){
			var height = global.self.outerHeight(),
				left =global.self.offset().left,
				top =global.self.offset().top;

            if(global.self.parents().filter(function(i,v){return $(v).css("position")==="fixed"?true:false}).length>0){
                // 有fixed定位
                global.datePicker.css("position","fixed");
                height-=$(window).scrollTop();
            }else{
                global.datePicker.css("position","absolute");
            }
			global.datePicker.css({
					left:left+"px",
					top:height+top+"px"
				}).removeClass("vd-hide").addClass("vd-show");
		},20);
		$(this).data("nocheck","1");
		// alert(this.getAttribute("datatype"))
	}

// window.WdatePicker = function(){
// HTMLElement.prototype.WdatePicker.call();
// }

	// 上传文件
	$.uploadFile = function(config){
		// if(!config.url){return;}
		var _uploadContainer = $('<div class="upload-wp"><div class="upload-header"><a class="iconfont clobtn">&#xf00b3;</a>文件上传</div><div class="upload-process"><a class="select-file"><input type="file" multiple="true" id="upload_files" /><i class="iconfont icon">&#xf00c8;</i>选择文件</a><span class="select-tips">'+(config.par.softName||"")+(config.par.softName?">":"")+(config.par.resourceTypeName||"")+'</span><ul class="process-list"></ul></div><div class="upload-button"><a class="confirm-btn"> 确定 </a></div></div> ');				
		var _processList = _uploadContainer.find(".process-list")
		//
		_uploadContainer.find("#upload_files").change(function(){
			// 选择文件开始上传
			var files = this.files,
				file,
				i,len,
				xhrList=[],
				curXhr,
				formData,
				key,
				_progress,
				_tipsCont = _uploadContainer.find(".select-tips"),
				_fileType;
			_tipsCont.html((config.par.softName||"")+(config.par.softName?">":"")+(config.par.resourceTypeName||""));
			for(i=0,len =files.length;i<len;i++){
				file = files[i];
				_fileType = file.name.slice(file.name.lastIndexOf(".")+1);
				// console.log(Math.floor(file.size/1024));
				if(config.par&&config.par.resourceParams){
					config.par.resourceParams.fileType = _fileType;
				}
				if(config.maxFileSize&&file.size&&file.size>config.maxFileSize){
					_tipsCont.html("<font style='color:red;'>文件大小超出限制！请重新选择。(大小："+Math.floor(config.maxFileSize/1024)+"KB 以下！)</font>");
					return;
				}
				if(config.fileType&&config.fileType.indexOf(_fileType)<0){
					_tipsCont.html("<font style='color:red;'>文件类型超出限制！请重新选择。(文件后缀："+config.fileType.join(",")+" ！)</font>");
					return;
				}
				
				formData = new FormData();
				// if(config.par){
				// for(key in config.par){
				// formData.append(key,config.par[key])
				// }
				// }
				formData.append("file",file);
				// XHR 对 象 列 表
				xhrList.push((curXhr = new XMLHttpRequest()));

				_progress = $('<li ><div class="process-cont"><div class="file-info">'+(file.name||"")+'</div><div class="process-bar" data-index ="'+(xhrList.length-1)+'"><a class="iconfont cancel-upload">取消</a><div class="process-value" ><div class="process-icon">....</div></div></div></div></li>');
					
				curXhr.upload.addEventListener("progress", (function(_progress){
					return function(e){
						var process_value =_progress.find(".process-value"),
						process_text = _progress.find(".process-icon"); 
   						if (e.lengthComputable) {
          					var percentComplete = Math.round(e.loaded * 100 / e.total);
          					process_text.html(percentComplete+"%");
          					process_value.css("width",percentComplete+"%");
        				}
       					else {
          					process_text.html("....");
       					}
					}
				}(_progress)), false);
        		curXhr.addEventListener("load", (function(_progress){
        			return function(e){
        				var process_cancel =_progress.find(".cancel-upload"),
							process_text = _progress.find(".process-icon");
						process_cancel.html("&#xf00b2;").addClass("cancel-disable").removeClass("cancel-upload");
						process_text.hide(2000);
						if(typeof config.callback ==="function"){
							config.callback.call(null,_progress.find(".file-info").html())
						}
        			}

        		}(_progress)), false);

        		_progress.find(".cancel-upload").click((function(_xhrList){
        			return function(){
        				var _this =$(this),
        					parent = _this.parent(),
							process_index = _this.parent().attr("data-index");
						if(_this.is(".cancel-disable")){
							return;
						}
						if(_xhrList[process_index]){
							_xhrList[process_index].abort();
						}
						_this.html("&#xf00b3;").addClass("cancel-disable").removeClass("cancel-upload").css("color","#f16666");
						
						parent.find(".process-value").css("background","#A5A5A5");
						parent.find(".process-icon").html("已取消");
						
						// parent();
						// alert(process_index);

        			}
        		}(xhrList)));

        		curXhr.addEventListener("readystatechange", (function(_progress){
        			return function(){
      // var json,
      // process_cancel,
      // process_text;
						// if((curXhr.status>=200&&curXhr.status<300)||(curXhr.status=="304")){
      // if(curXhr.readystate =="4"){
      // json = JSON.parse(curXhr.responseText);
      // if(json.success){
      // //上传成功
      // process_cancel =_progress.find(".cancel-upload"),
						// process_text = _progress.find(".process-icon");
						// process_cancel.html("&#xf00b2;").addClass("cancel-disable").removeClass("cancel-upload");
						// process_text.hide(2000);
						// if(typeof config.callback ==="function"){
						// config.callback.call(null,_progress.find(".file-info").html())
						// }
      // }
      // }
      // }
        			}
        		}(_progress)), false);
        		curXhr.open("POST",config.url+'?data='+JSON.stringify(config.par));
       			_processList.append(_progress);
       			curXhr.send(formData);
			}
		});
		_uploadContainer.find(".confirm-btn").click(function(){
			// 确定
			message&&message.clearMask();
			_uploadContainer.remove();
			if(typeof config.closeCallback==="function"){
				config.closeCallback.call(null);
			}
		});
		_uploadContainer.find(".clobtn").click(function(){
			// 确定
			message&&message.clearMask();
			_uploadContainer.remove();
			if(typeof config.closeCallback==="function"){
				config.closeCallback.call(null);
			}
		});
	
		var winHeight = $(window).height(),Top=0;
		if(winHeight>523){
			Top = Math.ceil((winHeight-523)/2);
		}
		_uploadContainer.appendTo($("body")).css("top",Top);
		window.message&&message.showMask();
	}


	// stScroll
	$.initScroll=function(){
		var SCROLL_SPEED = 50,
			dragStart;
		$(".stScroll").each(function(index,dom){
			var _target = $(dom),
				_content,
				_wrap,
				p_height,
				p_width,
				c_height,
				c_width,
				_window = $(window),
				_scrollBar,_scrollBtn;
			_wrap = $('<div class="stscroll-wrap"><div class="stscroll-content"></div></div>')
			_content=_wrap.children(".stscroll-content");
			_scrollBar =$('<div class="stscroll-bar"><div class="scroll-btn"></div></div>');
			_scrollBtn = _scrollBar.find(".scroll-btn");
			_target.css({
				overflow:"hidden",
				padding:0
			});
			if(_target.css("position")==="static"){
				_target.css("position","relative");
			}
			_target.children().each(function(ind,dom){
				_content.append($(dom));
			});
			_target.append(_wrap);
			if(_target.is("body")){
				_target.css("height",_window.height());
				_target.data("ph",_window.height());
				_target.data("ch",_content.height());
			}
			
			// _wrap.append(_content);
			p_height = _target.height();
			p_width = _target.width();
			c_height = _content.height();
			c_width = _content.width();
			if(c_height>p_height){
				_scrollBar.css({
					height:p_height
				});
				_scrollBtn.css({
					height:Math.round((p_height*p_height)/c_height)
				})
				_target.append(_scrollBar);
			}
			// console.log(p_height+"-"+p_width+"-"+c_height+"-"+c_width);
			_target.bind("mousewheel",function(e){
				// e.deltaY 下 -1 上 1 SCROLL_SPEED
				var _scDes = SCROLL_SPEED,
					_curScrollTop = _wrap.scrollTop(),
					pH =p_height ,cH=c_height;
				// _scrollBar.css("top",_curScrollTop)
				if(e.deltaY>0){
					_scDes = -_scDes;
				}
				if($(this).is("body")){
					pH =+$(this).data("ph");
					cH =+$(this).data("ch");
				}
				_wrap.scrollTop(_curScrollTop+_scDes);
				_scrollBtn.css("top",Math.round(_wrap.scrollTop()*(pH/cH)));
				e.preventDefault();
				e.stopPropagation();
			});

			_scrollBar.bind("mouseover",function(e){
				// $(this).removeClass("opacity_0");
				e.preventDefault();
				e.stopPropagation();
			})

			_scrollBar.bind("mouseout",function(e){
				// $(this).addClass("opacity_0");
				e.preventDefault();
				e.stopPropagation();
			})

			/* 拉滚动条 滚动 */
			var _dy;
			_scrollBtn.bind("mousemove",function(e){
				var x,y,_curScrollTop,_des,barTop,btnTop;
				if(dragStart){
					x = e.pageX;
					y=e.pageY;
					barTop  = _scrollBar.offset().top
					btnTop =_scrollBtn.offset().top;

					// if(){

					// }
					_scrollBtn.css("top",Math.abs(barTop)+y-_dy)

				}
				e.preventDefault();
				e.stopPropagation();
			})

			_scrollBtn.bind("mousedown",function(e){
				dragStart = true;
				_dy = e.pageY - _scrollBtn.offset().top;
				e.preventDefault();
				e.stopPropagation();
			})

	
			// _scrollBtn.bind("mouseout",function(e){
			// dragStart =false;
			// e.preventDefault();
			// e.stopPropagation();
			// })

		});

		if(!arguments.callee.inited){
			$(document).bind("mouseup",function(e){
				dragStart = false;
				// e.preventDefault();
				// e.stopPropagation();
			});

			arguments.callee.inited=true;
		}
	}
	

	// 提示弹窗
	$.maskCache=[];
	$.showMessage = function(config){
		var 
			global = arguments.callee,
			_context = window.top.document ? window.top.document : window.document,
			_win = $('<div class="st-alert" style="z-index:20001;"><div class="stal-header"><span class="stal-title"></span><span class="stal-clsIcon iconfont">&#xf00b3;</span></div><div class="stal-content"><span class="stal-message-icon iconfont"></span><span class="stal-message"></span></div></div>'),
			_mask = $('<div class="st-mask" style="z-index:20000;"></div>');
		var icon = {
				alert:"&#xf00b7;",
				success:"&#xf0156;",
				error:"&#xf0155;"
			},
			color={
				alert:"#ff7200",
				success:"green",
				error:"#ff7200"
			}	

		$.maskCache.push(_mask);
		_mask.prependTo($(_context).find("body"));	
		_win.find(".stal-title").html(config.title||"");
		_win.find(".stal-message-icon").html(icon[config.icon]||"&#xf00b7;").css("color",color[config.icon]||"#ff7200");
		_win.find(".stal-message").html(config.msg||(config.message||""));
		_win.data("mask_index",$.maskCache.length-1);
		_win.find(".stal-clsIcon").click(function(e){
			var w = $(this).parent().parent();
			var index =w.data("mask_index");
			$.maskCache[index]&&$.maskCache[index].remove();
			delete $.maskCache[index];
			if($.isFunction(config.callback)){
				config.callback.call(null)		
			}
			w.remove();
		})
		if(config.timeout&&!isNaN(config.timeout)){
			setTimeout(function(){
				_win.find(".stal-clsIcon").click();
			},config.timeout)
		}
		
		_win.appendTo($(_context).find("body"));
		setTimeout(function(){
			_win.css({
				width:550,
				height:180
			});
		},20);
	}
	$.showConfirm = function(config){
		var 
			global = arguments.callee,
			_context = window.top.document ? window.top.document : window.document,
			
			_win =$('<div class="st-confirm st-dragable" style="z-index:20001;"><div class="stal-header"><span class="stal-title"></span><span class="stal-clsIcon iconfont">&#xf00b3;</span></div><div class="stal-content"><span class="stal-message-icon iconfont">&#xf0031;</span><span class="stal-message"></span></div><div class="stal-buttons"><a class="stal-cancelbtn">否</a><a class="stal-okbtn">是</a></div></div>'),
			_mask = $('<div class="st-mask" style="z-index:20000;"></div>');

		$.maskCache.push(_mask);
		_mask.prependTo($(_context).find("body"));	
		_win.find(".stal-title").html(config.title||"");
		_win.find(".stal-message").html(config.msg||(config.message||""));
		_win.data("mask_index",$.maskCache.length-1);
		_win.find(".stal-clsIcon").click(function(e){
			var w = $(this).parent().parent();
			var index =w.data("mask_index");
			$.maskCache[index]&&$.maskCache[index].remove();
			delete $.maskCache[index];
			w.remove();
		});

		_win.find(".stal-okbtn").click(function(e){
			if($.isFunction(config.callback)){
				config.callback.call(null,true)		
			}
			_win.find(".stal-clsIcon").click();
		})

		_win.find(".stal-cancelbtn").click(function(e){
			if($.isFunction(config.callback)){
				config.callback.call(null,false)		
			}
			_win.find(".stal-clsIcon").click();
		})

		_win.appendTo($(_context).find("body"));
		setTimeout(function(){
			_win.css({
				width:550,
				height:240
			});
		},20);

	}
	$.showConfirm2 = function(config){
		var 
			global = arguments.callee,
			i,len,
			_context = window.top.document ? window.top.document : window.document,
			
			_win =$('<div class="st-choose  st-dragable" style="z-index:20001;"><div class="stal-header"><span class="stal-title"></span><span class="stal-clsIcon iconfont">&#xf00b3;</span></div><div class="stal-content"><span class="stal-message-icon iconfont">&#xf0031;</span><span class="stal-message"></span></div><div class="stal-buttons"><a class="stal-cancelbtn">否</a><a class="stal-okbtn">是</a></div></div>'),
			_mask = $('<div class="st-mask" style="z-index:20000;"></div>');

		$.maskCache.push(_mask);
		_mask.prependTo($(_context).find("body"));	
		_win.find(".stal-title").html(config.title||"");
		_win.find(".stal-message").html(config.msg||(config.message||""));
		_win.data("mask_index",$.maskCache.length-1);

		if(config.buttons){
			for(i=0,len =config.buttons.length;i<len;i++){
				_win.find(".stal-buttons a").eq(i)&&_win.find(".stal-buttons a").eq(i).html(config.buttons[i])
			}	
		}
		
		_win.find(".stal-clsIcon").click(function(e){
			var w = $(this).parent().parent();
			var index =w.data("mask_index");
			$.maskCache[index]&&$.maskCache[index].remove();
			delete $.maskCache[index];
			w.remove();
		});

		_win.find(".stal-okbtn").click(function(e){
			if($.isFunction(config.callback)){
				config.callback.call(null,$(this).html())		
			}
			_win.find(".stal-clsIcon").click();
		});

		_win.find(".stal-cancelbtn").click(function(e){
			if($.isFunction(config.callback)){
				config.callback.call(null,$(this).html())		
			}
			_win.find(".stal-clsIcon").click();
		});

    // _win.find(".stal-closbtn").click(function(e){
    // if($.isFunction(config.callback)){
    // config.callback.call(null,$(this).html())
    // }
    // _win.find(".stal-clsIcon").click();
    // });


		_win.appendTo($(_context).find("body"));
		setTimeout(function(){
			_win.css({
				width:550,
				height:240
			});
		},20);


	}

	$.showMask = function(native){
		var 
			_context = window.top.document ? window.top : window,
			_mask = $('<div class="st-mask"></div>'),
			global = _context.$.showMask;
        _context = native? window:_context;
		if(!global.mask){
			_mask.prependTo(_context.$("body"));
			global.mask = _mask;
		}
			
	}
	$.clearMask=function(native){
		var 
			_context = window.top.document ? window.top : window,
			global = _context.$.showMask;
        _context = native? window:_context;
		if(global&&global.mask){
			global.mask.remove();
			global.mask=null;
		}

	}
	// 兼容老版本
	window.message = {
		enableDrag:function(){},
		disableDrag:function(){},
		showMessageN:function(config){
			$.showMessage(config||{});
		},
		showMask:function(){$.showMask()},
		clearMask:function(){$.clearMask()},
		showMessage:function(){
			var config={};
			if(typeof arguments[0]==="object"){
				$.showMessage(arguments[0]||{});
			}else{
				config.title = arguments[0]||"";
				config.message = arguments[1]||"";
				config.mask = arguments[2]||"";
				config.timeout = arguments[3]||"";
				config.dragable = arguments[4]||"";
				config.style = arguments[5]||"";
				config.animation = arguments[6]||"";
				$.showMessage(config);
			}
		},
		showConfirm:function(config){
			if(config.buttons&&typeof config.buttons[0]==="object"){
				config.buttons = $.map(config.buttons,function(v){
					return v.name;
				});
				$.showConfirm2(config);
			}else{
				$.showConfirm(config);
			}
			
		}
	}


	// 弹窗 mac效果
	function scale(s1, s2, p1, p2, type, callback,canvas) {
		var dist1 = Math.abs(p1 - s1);
		var dist2 = Math.abs(p2 - s2);
		var d1, d2, _p1, _p2, speed1, y, speed2;
		if(dist1 === 0 || dist2 === 0) {
			dist1 = 1;
			dist2 = 1;
		}
		// speed1 = 30;
		// speed2 = 30;
		speed1 = (canvas.height/10)|0;
		speed2 = (canvas.height/10)|0;
		if(type === "zoomout") {
			d1 = (p1 >= s1 && p1 < speed1) ? 0 : p1 < s1 ? -speed1 : speed1;
			d2 = p2 < s2 ? -speed1 * dist2 / dist1 : speed1 * dist2 / dist1;
			_p1 = s1;
			_p2 = s2;
			y = 0;
			var t = setInterval(function () {
				if(_p2 - _p1 <= p2 - p1) {
					clearInterval(t);
					var timer = setInterval(function () {
						if(y > canvas.height) {
							clearInterval(timer);
							callback && callback();
						}
						clearRect(y, speed2, type,canvas);
						y += speed2;
						speed2 += 1;
					}, 17);
				}
				draw(s1, s2, _p1, _p2,canvas);
				_p1 += d1;
				_p2 += d2;
				if((d1 < 0 && _p1 <= p1) || (d1 > 0 && _p1 >= p1)) {
					_p1 = p1;
				}
				if((d2 < 0 && _p2 <= p2) || (d2 > 0 && _p2 >= p2)) {
					_p2 = p2;
				}
			}, 17);
		} else if(type === "zoomin") {
			d1 = (p1 >= s1 && p1 < speed1) ? 0 : p1 < s1 ? speed1 : -speed1;
			d2 = p2 < s2 ? speed1 * dist2 / dist1 : -speed1 * dist2 / dist1;
			_p1 = p1;
			_p2 = p2;
			y = canvas.height;
			var timer = setInterval(function () {
				if(y <= 0) {
					clearInterval(timer);
					var t = setInterval(function () {
						if(_p2 - _p1 >= s2 - s1) {
							clearInterval(t);
							callback && callback();
						}
						draw(s1, s2, _p1, _p2,canvas);
						_p1 += d1;
						_p2 += d2;
					}, 17);
				}
				draw(s1, s2, _p1, _p2,canvas);
				clearRect(y, speed2, type,canvas);
				y -= speed2;
				// speed2 += 1;
			}, 17);
		}
	}

	function draw(s1, s2, p1, p2,canvas) {
		var ctx = canvas.getContext("2d");
		ctx.clearRect(0, 0, canvas.width, canvas.height);
		ctx.beginPath();
		ctx.moveTo(s1, 0);
		ctx.bezierCurveTo(s1, canvas.height * 0.2, p1, canvas.height * 0.6, p1, canvas.height);
		ctx.lineTo(p2, canvas.height);
		ctx.bezierCurveTo(p2, canvas.height * 0.6, s2, canvas.height * 0.2, s2, 0);
		ctx.lineTo(s1, 0);
		ctx.fillStyle = canvas.color;// "rgba(227, 9, 32, .2)";
		ctx.fill();
	}

	function clearRect(y, speed, type,canvas) {
		var ctx =  canvas.getContext("2d");
		if(type === "zoomout") {
			ctx.clearRect(0, y, canvas.width, speed);
		} else if(type === "zoomin") {
			ctx.clearRect(0, 0, canvas.width, y);
		}
	}



	// 苹果 弹窗效果
	$.fn.macShow = function(color,_bodyScroll){
		var _dialog = this,
			_canvas,s1,s2,p1,p2,
			_context = window.top;		
		if((_canvas=_context.$("canvas.seentaoDialog")).length===0){
			_context.$("body").prepend(_canvas=_context.$("<canvas class='seentaoDialog' style='position:absolute;height:100%;width:100%;bottom:0px;z-Index:-1'></canvas>"));
		}
		_dialog.css("visibility","hidden");
		_dialog.css("display","block");
		
		_canvas.css({
			zIndex:20000,
			visibility:"visible",
			top:_dialog.offset().top,
			height:_context.$(window).height()-_dialog.offset().top+_context.$(window).scrollTop()
		})
		
		_canvas[0].height = _canvas.height();
		_canvas[0].width =_canvas.width(); 
		_canvas[0].color =color||"rgba(227, 9, 32, .2)";
		s1 = Math.floor(_dialog.offset().left);
		s2 = Math.floor(s1 + _dialog.width());
		p1 = 0;
		p2 = 0;
		scale(s1, s2, p1, p2, "zoomin", function () {
			_dialog.css("visibility","visible");
			_canvas.css({
				visibility:"hidden"
			});
            if(!_bodyScroll){
                // $("body").css("overflow","hidden");
            }
			// $.showMask();
		},_canvas[0]);
	}
	$.fn.macClose = function(color){
		var _dialog = this,
			_canvas,s1,s2,p1,p2,
			_context = window.top;		
		if((_canvas=_context.$("canvas.seentaoDialog")).length===0){
			_context.$("body").prepend(_canvas=_context.$("<canvas class='seentaoDialog' style='position:absolute;height:100%;width:100%;bottom:0px;z-Index:-1'></canvas>"));
		}
		_canvas.css({
			visibility:"visible",
			zIndex:20000,
			top:_dialog.offset().top,
			height:_context.$(window).height()-_dialog.offset().top+_context.$(window).scrollTop()
		})
		_canvas[0].height = _canvas.height();
		_canvas[0].width =_canvas.width(); 
		_canvas[0].color =color||"rgba(227, 9, 32, .2)";
		s1 = Math.floor(_dialog.offset().left);
		s2 = Math.floor(s1 + _dialog.width());
		p1 = 0;
		p2 = 0;
		_dialog.css("visibility","hidden");
		_dialog.css("display","none");
		scale(s1, s2, p1, p2, "zoomout", function () {
			_canvas.css({
				visibility:"hidden"
			});
            // $("body").css("overflow","auto")
			// $.clearMask();
		},_canvas[0]);		
	}
	
	
// /**
// * 元素拖动效果
// * 不是 fixed 或 absolute 定位的会转成 absolute定位！！！！注意样式
// * */
// $.fn.dragable = function(){
// var global = arguments.callee,_desX,_desY,dragElement;
// this.each(function(index,dom){
// var _target = $(dom);
// if(["fixed","absolute"].indexOf(_target.css("position"))<0){
// _target.data("drag_position",_target.css("position")).css("position","absolute");
// }
// _target.data("dragable","enable");
// })
// if(!global.init){
// //事件代理 避免多次绑定
// $(document).mousedown(function(e){
// var
// _this = $(e.target),
// _dragElement = _this.parents().andSelf().filter(function(){
// var _this= $(this),_top,_left;
// if((_this.attr("class")||"").indexOf("st-dragable")>-1||_this.data("dragable")){
// _desX = e.pageX - _this.offset().left;
// _desY = e.pageY - _this.offset().top;
// if(_this.css("position")=="fixed"){
// _top = _this.offset().top - $(window).scrollTop();
// _left = _this.offset().left - $(window).scrollLeft();
// } else{
// _top = _this.offset().top;
// _left = _this.offset().left;
// }
// _this.css({margin:0}).css({top:_top,left:_left});
// return true;
// }
// return false;
// }).eq(0);
// if(_dragElement.length!=0){
// dragElement =_dragElement.css("cursor","move");
// }
// })
// $(document).mousemove(function(e){
// var _x,_y,_elementX,_elementY,newX,newY,_position, _marginLeft,_marginTop;
// if(dragElement){
// _y = e.pageY; _x = e.pageX;_position = dragElement.css("position");
// if(_position==="fixed"){
// newX =_x-_desX - $(window).scrollLeft();
// newY = _y-_desY-$(window).scrollTop();
// newY = newY<0?0:newY;
// newY = newY>
// $(window).height()-dragElement.height()?$(window).height()-dragElement.height():newY;
// }else{
// newX =_x-_desX;
// newY = _y-_desY;
// }
// newX = newX<0?0:newX;
// newX =
// newX>$(window).width()-dragElement.width()?$(window).width()-dragElement.width():newX;
// dragElement.css({left:newX,top:newY});
// e.preventDefault();
// }
// })
// $(document).mouseleave(function(){
// if(dragElement){
// dragElement.css("cursor","default");
// dragElement =null;
// }
// })
// $(document).mouseup(function(e){
// if(dragElement){
// dragElement.css("cursor","default");
// dragElement =null;
// }
// })
// global.init = true;
// }
// }

    /**
	 * 禁用拖动效果 定位(position)还原为以前的方式
	 */
// $.fn.dragDisable = function(){
// this.each(function(index,dom){
// var _target = $(dom),_pos;
// if(_pos = _target.data("drag_position")){
// _target.css("position",_pos);
// }
// _target.data("dragable",null);
// })
// }


   /**
	 * 表格水平滚动 {leftBtn:"",rightBtn:"",container:"",scrollTb:""}
	 */
// $.scrollTable = function(config){
// var
// _left = $(config.leftBtn||""),
// _right = $(config.rightBtn||""),
// _container =$(config.container||""),
// _scrollTb = $(config.scrollTb||""),
// _parWidth = _container.width(),
// _scrollSpeed = config.scrollSpeed||30,
// _scrollStart,_mouseDelay;
//
// _left.click(function(){
// var width =_scrollTb.width(),
// left = _container.scrollLeft(),
// nLeft =left- _scrollSpeed;
// nLeft = nLeft<0?0:nLeft;
// _container.scrollLeft(nLeft)
// })
// //长按500毫秒 自动滚
// _left.mousedown(function(e){
// clearTimeout(_mouseDelay);
// _mouseDelay = setTimeout(function(){
// _scrollStart = setInterval(function(){
// _left.click();
// },80)
// },500)
// })
// _left.mouseup(function(){
// clearTimeout(_mouseDelay);
// clearInterval(_scrollStart);
// });
// _right.click(function(){
// var width =_scrollTb.width(),
// left = _container.scrollLeft(),
// borderWidth =_container.css("border-width"),
// nLeft =left+_scrollSpeed,
// containerWidth = _container.width() -
// (2*parseInt(_container.css("border-width")));
//
// nLeft = nLeft+containerWidth>width?width-containerWidth:nLeft;
// nLeft = nLeft<0?0:nLeft;
// _container.scrollLeft(nLeft)
// });
// //长按500毫秒 自动滚
// _right.mousedown(function(e){
// clearTimeout(_mouseDelay);
// _mouseDelay = setTimeout(function(){
// _scrollStart = setInterval(function(){
// _right.click();
// },80)
// },500)
// })
// _right.mouseup(function(){
// clearTimeout(_mouseDelay);
// clearInterval(_scrollStart);
// });
// }



// $(function(){
// $.initCheckBox();
// $.initRadiobox();
// $("").dragable();
// $(".st_fixed").each(function(index,dom){
// $(dom).data({
// "offsetTop": $(dom).offset().top,
// "position": $(dom).css("position"),
// "top":$(dom).css("top")
// });
// });
// if($(".st_fixed").length>0){
// var tieoutId="";
// $(window).bind("scroll",function(){
// clearTimeout(tieoutId);
// tieoutId = setTimeout(function(){
// var _scrollTop =$(window).scrollTop();
// $(".st_fixed").each(function(index,dom){
// var _this = $(dom),
// _offsetTop =_this.data("offsetTop"),
// _scrollDes = _this.attr("scrollDes")||0,
// _top = _this.attr("top")||0;
// if((_scrollDes&&_scrollTop>_scrollDes)||(_offsetTop-_scrollTop<0)){
// if(! _this.data("startScroll")){
// _this.data("startScroll",_scrollTop).css({
// position:"fixed"
// }).animate({top:(+_top)},500,"linear");
// }
// }else{
// _this.data("startScroll",null).css({
// position:_this.data("position"),
// top:_this.data("top")
// });
// }
// })
// },200)
// });
// }
// })

}(jQuery)

/**
 * Get the value of a cookie with the given name.
 * 
 * @example $.cookie('the_cookie');
 * @desc Get the value of a cookie.
 * 
 * @param String
 *            name The name of the cookie.
 * @return The value of the cookie.
 * @type String
 * 
 * @name $.cookie
 * @cat Plugins/Cookie
 * @author Klaus Hartl/klaus.hartl@stilbuero.de
 */
jQuery.cookie = function(name, value, options) {
    if (typeof value != 'undefined') { // name and value given, set cookie
        options = options || {};
        if (value === null) {
            value = '';
            options = $.extend({}, options); // clone object since it's
												// unexpected behavior if the
												// expired property were changed
            options.expires = -1;
        }
        var expires = '';
        if (options.expires && (typeof options.expires == 'number' || options.expires.toUTCString)) {
            var date;
            if (typeof options.expires == 'number') {
                date = new Date();
                date.setTime(date.getTime() + (options.expires * 24 * 60 * 60 * 1000));
            } else {
                date = options.expires;
            }
            expires = '; expires=' + date.toUTCString(); // use expires
															// attribute,
															// max-age is not
															// supported by IE
        }
        // NOTE Needed to parenthesize options.path and options.domain
        // in the following expressions, otherwise they evaluate to undefined
        // in the packed version for some reason...
        var path = options.path ? '; path=' + (options.path) : '';
        var domain = options.domain ? '; domain=' + (options.domain) : '';
        var secure = options.secure ? '; secure' : '';
        document.cookie = [name, '=', encodeURIComponent(value), expires, path, domain, secure].join('');
    } else { // only name given, get cookie
        var cookieValue = null;
        if (document.cookie && document.cookie != '') {
            var cookies = document.cookie.split(';');
            for (var i = 0; i < cookies.length; i++) {
                var cookie = jQuery.trim(cookies[i]);
                // Does this cookie string begin with the name we want?
                if (cookie.substring(0, name.length + 1) == (name + '=')) {
                    cookieValue = decodeURIComponent(cookie.substring(name.length + 1));
                    break;
                }
            }
        }
        return cookieValue;
    }
}
// 格式化
function timeCon2(obj){
	if(obj==""||obj==undefined){
		return false;
	}else{
		var timeHtml = "";
		var time = obj;
		time = time.split(' ');
		var year = time[2]// 年
		var day = time[1].replace(',','');// 日
		var wen = time[3];// 时分秒
		var non = time[4];// 上午or下午
		var month = ""// 月
		if(non=="AM"){
			non = "上午";
		}else if(non=="PM"){
			non = "下午"
		}
		if(time[0]=='Jan'){// 一月
			month = "1";
		}else if(time[0]=='Feb'){// 二月
			month = "2";
		}else if(time[0]=='Mar'){// 三月
			month = "3";
		}else if(time[0]=='Apr'){// 四月
			month = "4";
		}else if(time[0]=='May'){// 五月
			month = "5";
		}else if(time[0]=='Jun'){// 六月
			month = "6";
		}else if(time[0]=='Jul'){// 七月
			month = "7";
		}else if(time[0]=='Aug'){// 八月
			month = "8";
		}else if(time[0]=='Sep'){// 九月
			month = "9";
		}else if(time[0]=='Oct'){// 十月
			month = "10";
		}else if(time[0]=='Nov'){// 十一月
			month = "11";
		}else if(time[0]=='Dec'){// 十二月
			month = "12";
		}
		
		timeHtml+=year+'年'+month+'月'+day+'日'+non+' '+wen;
		return timeHtml;
	}
}