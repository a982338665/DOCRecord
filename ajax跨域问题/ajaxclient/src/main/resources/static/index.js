// $(function(){
//
//     var get1url="http://localhost:8080/test/get1";
//
//
//     function get1() {
//         $.getJSON(get1url).then(function (result) {
//             console.log(result);
//         });
//     };
//
//
//
//
//
// });


/**
 * 方法写在$(function(){})中与写在外面的区别：----
 * @type {string}
 */
//请求发送至被调用方的nginx代理服务器，跨域解决在nginx代理服务器上
// var get1url="http://b.com:8888/test/get1";
// var postJson1url="http://b.com:8888/test/postJson";
// var getCookieUrl="http://b.com:8888/test/getCookie";
// var getHeaderUrl="http://b.com:8888/test/getHeader";


//请求直接发送至被调用方的应用服务器：------
var get1url="http://ajaxserver/get1";
var postJson1url="http://ajaxserver/postJson";
var getCookieUrl="http://ajaxserver/getCookie";
var getHeaderUrl="http://ajaxserver/getHeader";

//调用方隐藏跨域：------
// var get1url="http://localhost:8080/test/get1";
// var postJson1url="http://localhost:8080/test/postJson";
// var getCookieUrl="http://localhost:8080/test/getCookie";
// var getHeaderUrl="http://localhost:8080/test/getHeader";

function get1() {
    $.getJSON(get1url).then(function (result) {
        console.log(result);
    });
};

/**
 * 使用jsonp解决ajax跨域问题：
 * 1.普通方法中type为xhr
 * 2.jsonp为script类型，浏览器不做校验，所以可以访问
 * ------
 * 1.普通响应类型：application/json;charset=UTF-8
 * 2.jsonp响应类型：	application/javascript，返回js脚本
 * ------
 * jsonp弊端：
 * 1.服务器需改动
 * 2.仅支持Get请求（原理动态创建script，使用后销毁），无法满足实际需求
 * 3.发送的不是XHR请求
 */
function jsonp() {
    $.ajax({
        url:get1url,
        dataType:"jsonp",
        //与后台对应
        // jsonp:"callback2",
        //添加缓存
        // cache:true,
        success:function (json) {
            result=json;
            console.log(result);
        }
    });
    
}

function postJson() {
    $.ajax({
        url:postJson1url,
        type:"post",
        contentType:"application/json;charset=utf-8",
        data:JSON.stringify({name:"xiaofengqing"}),
        success:function (json) {
            result=json;
            console.log(result);
        }
    });
}
function getCookie() {
    $.ajax({
        url:getCookieUrl,
        type:"get",
        //此参数表示发送ajax请求时要带上cookie
        xhrFields:{
            withCredentials:true
        },
        success:function (json) {
            result=json;
            console.log(result);
        }
    });
}function getSelfDifine() {
    $.ajax({
        url:getHeaderUrl,
        type:"get",
        //两处自定义头添加位置----
        headers:{
            "x-header1":"AAA"
        },
        beforeSend:function (xhr) {
          xhr.setRequestHeader("x-header2","BBB")
        },
        success:function (json) {
            result=json;
            console.log(result);
        }
    });
}