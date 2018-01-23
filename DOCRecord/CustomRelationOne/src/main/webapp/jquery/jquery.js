//
//
// //初始化js----------------------
// $(document).ready(function(){});
// $( function(){});
// //-----------------------------
// //js文件和内嵌的js代码一般不建议放在<head>标签中，而应该放在内容主体的结束标签</body>
// //让浏览器先加载页面内容，然后再加载并解析执行js代码。这样可以让网速较慢的用户能够更快地看到页面的展示内容,提高用户体验。
// $(function () {
//
// });
// //选择器------------------------
// $("#uid");              // 选取id属性为"uid"的单个元素
// $("p");                 // 选取所有的p元素
// $(".test");             // 选择所有带有CSS类名"test"的元素
// $("[name=books]");      // 选择所有name属性为"books"的元素
//
// // 多个选择器以空格或指定符号隔开，将匹配与前者具有指定关系的最后一个选择器所表示的元素
// $("#uid span"); // 选择id为"uid"的元素的所有后代span元素
// $("p > span"); // 选择p元素的所有子代span元素
// $("div + p"); // 选择div元素后面紧邻的同辈p元素
// $("div p span"); // 选择div元素的所有后代p元素的后代span元素
//
//
// // 多个选择器之间没有空格，将匹配同时满足这些选择器条件的元素
// $("p#uid"); // 选择id属性为"uid"的p元素
// $("div.foo"); // 选择所有带有CSS类名"foo"的div元素
// $(".foo.bar"); // 选择所有同时带有CSS类名"foo"和"bar"的元素
// $("input[name=books][id]"); // 选择所有name属性为"books"并且具备id属性的元素
//
// // 此外,为了更加便于使用，jQuery还定制了特有的选择器：
//
// // jQuery特有的选择器，当然也可以和其他选择器任意组合使用
// $(":checkbox"); // 选取所有的checkbox元素
// $(":text"); // 选取所有type为text的input元素
// $(":password"); // 选取所有type为password的input元素
// $(":checked"); // 选取所有选中的radio、checkbox、option元素
// $(":selected"); // 选取所有选中的option元素
// $(":input"); // 选取所有的表单控件元素(所有input、textarea、select、button元素)
//
// // 以下方法都返回一个新的jQuery对象，他们包含筛选到的元素
// $("ul li").eq(1); // 选取ul li中匹配的索引顺序为1的元素(也就是第2个li元素)
// $("ul li").first(); // 选取ul li中匹配的第一个元素
// $("ul li").last(); // 选取ul li中匹配的最后一个元素
// $("ul li").slice(1, 4); // 选取第2 ~ 4个元素
// $("ul li").filter(":even"); // 选取ul li中所有奇数顺序的元素
// $("div").find("p"); // 选取所有div元素的所有后代p元素
// $("div").children(); // 选取所有div元素的所有子代元素
// $("div").children("p"); // 选取所有div元素的所有子代p元素
// $("span").parent(); // 选取所有span元素的父元素
// $("span").parent(".foo.bar"); // 选取所有span元素的带有CSS类名"foo"和"bar"的父元素
// $("#uid").prev(); // 选取id为uid的元素之前紧邻的同辈元素
// $("#uid").next(); // 选取id为uid的元素之后紧邻的同辈元素
//
// //------------------------------
// // selector 表示具体的选择器
//
// $("selector").val(); // 获取第一个匹配元素的value值(一般用于表单控件)
// $("selector").val("Hello"); // 设置所有匹配元素的value值为"Hello"
//
// $("selector").html(); // 获取第一个匹配元素的innerHTML值
// $("selector").html("Hello"); // 设置所有匹配元素的innerHTML值为"Hello"
//
// $("selector").text(); // 获取第一个匹配元素的innerText值(jQuery已进行兼容处理)
// $("selector").text("Hello"); // 设置所有匹配元素的innerText值为"Hello"
//
// $("selector").attr("class"); // 获取第一个匹配元素class属性
// $("selector").attr("class", "code"); // 设置所有匹配元素的class属性为"code"
// $("selector").removeAttr("class"); // 移除所有匹配元素的class属性
//
// $("selector").prop("checked"); // 获取第一个匹配元素的checked属性值
// $("selector").prop("checked", true); // 设置所有匹配元素的checked属性值为true(意即选中所有匹配的复选框或单选框)
// $("selector").removeProp("className"); // 移除所有匹配元素的className属性
// --------------------------------
// // 以下$A均表示当前jQuery对象，$B可以是选择器字符串、html字符串、DOM元素、jQuery对象
// $A.before( $B ); // 在$A之前插入$B
// $A.after( $B ); // 在$A之后插入$B
//
// $A.insertBefore( $B ); // 将$A插入到$B之前的位置
// $A.insertAfter( $B ); // 将$A插入到$B之后的位置
//
// $A.append( $B ); // 在$A内部的末尾位置追加$B
// $A.appendTo( $B ); // 将$A追加到$B内部的末尾位置
//
// $A.prepend( $B ); // 在$A内部的开头位置追加$B
// $A.prependTo( $B ); // 将$A追加到$B内部的开头位置
//
// $A.replaceAll( $B ); // 用$A替换$B
// $A.replaceWith( $B ); // 用$B替换$A
//
// $A.wrap( $B ); // 在$A的外侧包裹$B
// $A.unwrap( ); // 只移除$A的父元素的标签
// $A.wrapAll( $B ); // 在整个$A的外侧用单个$B将其包裹起来
// $A.wrapInner( $B ); // 在$A的内侧包裹$B
//
// $A.empty(); // 清空$A的所有内容
// $A.remove(); // 删除$A及其绑定的事件、附加数据等
// $A.detach(); // 删除$A，但保留其绑定的事件、附加数据等
//
// $A.clone(); // 克隆一个$A
// --------------------------------
//
//
//     $("selector").show(); // 显示隐藏的元素，默认不带过渡动画效果
// $("selector").show( 400 ); // 显示隐藏的元素，带有400毫秒的过渡动画效果
// $("selector").show( "fast" ); // 显示隐藏的元素，带有200毫秒的过渡动画效果
// $("selector").show( "slow" ); // 显示隐藏的元素，带有600毫秒的过渡动画效果
//
// $("selector").hide(); // 隐藏显示的元素，其用法与show()相同
// $("selector").toggle(); // 切换显示/隐藏元素(如果显示就隐藏，隐藏就显示)，其用法与show()类似
//
// /* 下面的slide*、fade*系列方法与上面的show()、hide()、toggle()等方法作用相同，
//  * 用法也类似，只是带有不同的动画效果
//  */
//
// $("selector").slideDown(); // 显示隐藏的元素，带有向下滑动的过渡动画效果
// $("selector").slideUp(); // 隐藏显示的元素，带有向上滑动的过渡动画效果
// $("selector").slideToggle(); // 切换显示/隐藏的元素，带有向上/下滑动的过渡动画效果
//
// $("selector").fadeIn(); // 显示隐藏的元素，带有淡入的过渡动画效果
// $("selector").fadeOut(); // 隐藏显示的元素，带有淡出的过渡动画效果
// $("selector").fadeToggle(); // 隐藏显示的元素，带有淡出的过渡动画效果
//
//
// $.ajax({
//     url: "ajax.php?action=add",
//     type: "post",
//     data: "username=hello&password=123456", // 附加的请求数据，也可以为对象格式
//     dataType: "json",
//     success: function(data){
//         // 这是Ajax请求成功后执行的回调函数
//         // 因为dataType为json，如果服务器返回的是JSON格式数据，jQuery会将其转为对应的JS对象
//
//         // 假设data为{ msg: "Ajax请求成功", uid: 2 }
//         alert( data.msg );
//     }
// });
//
// // 以GET方式发送Ajax请求
// $.get("ajax.php", { username: "hello", password: "123456" }, function(data){
//     // 这是Ajax请求成功后执行的回调函数，就是上面$.ajax中的success选项
// });
//
// // 以POST方式发送Ajax请求
// $.post("ajax.php", { username: "hello", password: "123456" }, function(data){
//     // 这是Ajax请求成功后执行的回调函数，就是上面$.ajax中的success选项
// });
// ----------------------------------------
//
// // 去除字符串两端的空白字符
// var str1 = $.trim( "  abc d  " ); // "abc d"
// var str2 = $.trim( null ); // ""
// // 判断是否是数组
// var isArray1 = $.isArray( [] ); // true
// var isArray2 = $.isArray( new Array() ); // true
// // 判断是否是函数
// var result1 = $.isFunction( function(){} ); // true
// var result2 = $.isFunction( new Function() ); // true
// // 检索数组中是否存在指定值，并返回其第一次出现的索引
// var index1 = $.inArray( 2, [ 1, 3, 5, 2, 0 ] ); // 3
// var index2 = $.inArray( 3, [ 2 ] ); // -1 (不存在返回-1)
// // 将JSON字符串转为对应的JS对象
// var jsonObj = $.parseJSON( '{ "name": "CodePlayer", "age": 18 }' );
// var jsonArray = $.parseJSON( '[ 12, "CodePlayer", true ]' );
//
// ------------------------------------------
// // $.each()用于遍历数组元素或对象属性
// var array = [ 12, "jQuery", true ];
// $.each( array, function(i, value){
//     // i 表示当前迭代元素的索引或对象的属性名称
//     // value 表示当前迭代的数组元素或对象的属性值
//     // this 与  value 相同
//     alert( i + " = " + value );
//
//     // 如果函数return false，将终止遍历
// });
//
// // $.map()用于遍历数组元素或对象属性，并将每次执行遍历函数的返回值封装为数组返回
// var obj = { name: "jQuery", age: 20, isAdmin: true };
// var resultArray = $.map( obj, function(value, i){ // 注意参数顺序与each()不同
//     // value 表示当前迭代的数组元素或对象的属性值
//     // i 表示当前迭代元素的索引或对象的属性名称
//     // this 指向全局对象(window)
//
//     if( typeof value === "number"){
//         return null; // 如果函数返回null或undefined，则不会添加到结果数组中
//     }else{
//         return value;
//     }
// } );
// // resultArray 为 [ "jQuery", true ]
//
//
// //$.grep()用于遍历数组元素，并根据函数的返回值(true/false)来过滤数组元素
// var array2 = [ "Hello", 12, "jQuery", true ];
// var resultArray2 = $.grep( array2, function(value, i){ // 注意参数顺序与each()不同
//     // value 表示当前迭代的数组元素
//     // i 表示当前迭代元素的索引
//     // this 指向全局对象(window)
//
//     return i % 2 == 0; // 保留返回值不为false的元素
// } );
// // resultArray2 为 [ "Hello", "jQuery" ];
// -------------------------------------------
//     // 遍历所有的p元素，并执行对应的函数
//     // $("p").each(function(i, element){
//     //     // i 表示当前迭代元素的索引
//     //     // element 表示当前迭代的DOM元素
//     //     this === element
//     // });
//
//
// // 返回包含所有匹配元素value值的数组
// $(":checkbox:checked").map(function(i, element){
//     // i 表示当前迭代元素的索引
//     // element 表示当前迭代的DOM元素
//     // this === element
//     return this.value;
// });
// -------------------------------------------
// var p = $("p"); // 返回一个包含所有p元素的jQuery对象
// p[0]; // 第1个p元素
// p[0].id ; // 返回第1个p元素的id
// p[1]; // 第2个p元素
// p[2]; // 第3个p元素
// p.length; // p元素的个数
//
// // 此外，jQuery还给我们提供了一个get()方法，用于获取对应索引的DOM元素。
//
// var p = $("p"); // 返回一个包含所有p元素的jQuery对象
// p.get(0); // 第1个p元素
// p.get(1); // 第2个p元素
// p.get(2); // 第3个p元素
// p.get( ); // 不传入任何参数，将以数组形式返回包含的所有p元素
// -------------------------------------------
// 异步请求方式：

// $.ajax({
//     url : 'your url',
//     data:{name:value},
//     cache : false,
//     async : true,
//     type : "POST",
//     dataType : 'json/xml/html',
//     success : function (result){
//         do something....
//     }
// });
//
// 同步请求方式：
//
// $.ajax({
//     url : 'your url',
//     data:{name:value},
//     cache : false,
//     async : false,
//     type : "POST",
//     dataType : 'json/xml/html',
//     success : function (result){
//         do something....
//     }
// });
// ----------------------------------------------------
// jsp
// <div class="dlzc-nr">
//     <input id="username" type="text" placeholder="输入账号" />
//     <input id="password" type="password" placeholder="输入登录密码" />
//     <div class="dlzc-nr01 clearfix">
//     <div class="jzmm clearfix">
//     <input id="rememberMe" type="checkbox" onclick="remember();" />
//     <p>记住密码</p>
//     </div>
//     <div class="ljzc">
//     <p><a href="#">忘记密码？</a></p>
// </div>
// </div>
// <div class="dlan">
//     <a id="login-bt" href="javascript:;">登录</a>
//     </div>
//     <div class="myzh">
//     <p>没有账号，立即<a href="${ctx }/sso/forwardRegister">去注册</a></p>
// </div>
// </div>
//
//
// js
//
// function remember() {
//     var remFlag = $("#rememberMe").is(':checked');
//     if (remFlag == true) {
//         // cookie存用户名和密码,回显的是真实的用户名和密码,存在安全问题.
//         var conFlag = confirm("记录密码功能不宜在公共场所(如网吧等)使用,以防密码泄露.您确定要使用此功能吗?");
//         if (conFlag) { // 确认标志
//
//         } else {
//             $("#rememberMe").removeAttr('checked');
//         }
//     } else {
//         $("#rememberMe").removeAttr('checked');
//     }
// }
//
// // 记住密码功能
// $(document).ready(function() {
//     var username = getCookie("username");
//     var password = getCookie("password");
//     var rememberMe = getCookie("rememberMe");
//     if (rememberMe == 1) {
//         $("#username").val(username);
//         $("#password").val(password);
//         $("#rememberMe").attr("checked", true);
//     }
// });
//
// // 获取cookie
// function getCookie(cname) {
//     var name = cname + "=";
//     var ca = document.cookie.split(';');
//     for (var i = 0; i < ca.length; i++) {
//         var c = ca[i];
//         while (c.charAt(0) == ' ')
//             c = c.substring(1);
//         if (c.indexOf(name) != -1)
//             return c.substring(name.length, c.length);
//     }
//     return "";
// }
//
// $(function() {
//     // 点击登录按钮
//     $('#login-bt').click(function() {
//         login();
//     });
//     // 回车事件
//     $('#username, #password').keypress(function(event) {
//         if (13 == event.keyCode) {
//             login();
//         }
//     });
// });
// // 登录
// function login() {
//     $.ajax({
//         url : '/sso/login',
//         type : 'POST',
//         data : {
//             username : $('#username').val(),
//             password : encrypt($('#password').val()),
//             rememberMe : $('#rememberMe').is(':checked')
//             /*
//              * , backurl: BACK_URL
//              */
//         },
//         beforeSend : function() {
//             if ($('#username').val() == "") {
//                 alert("用户名不允许为空");
//                 $('#username').focus();
//                 return false;
//             }
//             if ($('#password').val() == "") {
//                 alert("密码不允许为空");
//                 $('#password').focus();
//                 return false;
//             }
//         },
//         success : function(data) {
//             var result = JSON.parse(data);
//             if (result.code == 200) {
//                 location.href = "/";
//             } else {
//                 alert(result.result);
//             }
//         },
//         error : function(error) {
//             console.log(error);
//         }
//     });
// }
//
// function encrypt(data) {
//     var key = CryptoJS.enc.Latin1.parse('sklhdflsjfsdgdeg');
//     var iv = CryptoJS.enc.Latin1.parse('cfbsdfgsdfxccvd1');
//     return CryptoJS.AES.encrypt(data, key, {
//         iv : iv,
//         mode : CryptoJS.mode.CBC,
//         padding : CryptoJS.pad.Pkcs7
//     }).toString();
// }
//
//
//
//
// action
// /**
//  * 用户登录
//  *
//  * @param request
//  * @param response
//  * @return
//  * @throws JsonProcessingException
//  */
// @RequestMapping(value = { "/login" }, method = RequestMethod.POST)
// 	@ResponseBody
// public String login(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
//     Map<String, String> resultMap = new HashMap<String, String>();
//     String username = request.getParameter("username");
//     String password = request.getParameter("password");
//     String rememberMe = request.getParameter("rememberMe");
//     if (StringUtils.isBlank(username)) {
//         resultMap.put("code", Constants.REQUEST_INVALID_USERNAME);
//         resultMap.put("result", "登录账号不能为空");
//         return jsonMapper.writeValueAsString(resultMap);
//     }
//     if (StringUtils.isBlank(password)) {
//         resultMap.put("code", Constants.REQUEST_INVALID_PASSWORD);
//         resultMap.put("result", "登录密码不能为空");
//         return jsonMapper.writeValueAsString(resultMap);
//     }
//     try {
//         password = AESUtil.decrypt(password);
//         UserInfo userInfo = userService.getUserInfoByLgnName(username);
//         if (null == userInfo) {
//             resultMap.put("code", Constants.REQUEST_INVALID_USERNAMEPWS);
//             resultMap.put("result", "用户名或密码错误");
//             return jsonMapper.writeValueAsString(resultMap);
//         }
//         String pwd = userInfo.getPwd();
//         String salt = userInfo.getSalt();
//         if (!pwd.equals(MD5Util.MD5(password + salt))) {
//             resultMap.put("code", Constants.REQUEST_INVALID_USERNAMEPWS);
//             resultMap.put("result", "用户名或密码错误");
//             return jsonMapper.writeValueAsString(resultMap);
//         }
//         HttpSession session = request.getSession();
//         session.setAttribute("userInfo", userInfo);
//         List<Map<String, String>> roleList = userService.getUserRoleByUserId(userInfo.getUserId());
//         session.setAttribute("role", roleList);
//         if ("true".equals(rememberMe)) {
//             CookieUtil.setCookie(response, "username", username, 30 * 24 * 60 * 60);
//             CookieUtil.setCookie(response, "password", password, 30 * 24 * 60 * 60);
//             CookieUtil.setCookie(response, "rememberMe", "1", 30 * 24 * 60 * 60);
//         } else {
//             CookieUtil.removeCookie(response, "username");
//             CookieUtil.removeCookie(response, "password");
//             CookieUtil.removeCookie(response, "rememberMe");
//         }
//
//         UcenterLoginLogBean loginLogBean = new UcenterLoginLogBean();
//         loginLogBean.setUserId(userInfo.getUserId());
//         loginLogBean.setLoginIp(IpUtils.getRequestRealIp(request));
//         loginLogBean.setUserOper(1);
//         userService.saveLoginLogInfo(loginLogBean);
//
//         resultMap.put("code", Constants.REQUEST_SUCCESS);
//         resultMap.put("result", "登录成功");
//         return jsonMapper.writeValueAsString(resultMap);
//     } catch (Exception e) {
//         e.printStackTrace();
//         resultMap.put("code", Constants.REQUEST_INVALID_DATABASEERROR);
//         resultMap.put("result", "数据查询异常");
//         return jsonMapper.writeValueAsString(resultMap);
//     }
// }