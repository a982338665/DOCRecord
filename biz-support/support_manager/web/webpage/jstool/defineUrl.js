var ischool = {};
+function($){
    /**
     * //获取当前项目根路径
     *
     * @return {TypeName}
     */
    var getRootPath_= function getRootPath(){
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




    $.DEFINE_URL={

        //根路径：域名+项目名
        rootUrl:getRootPath_(),
        //获取验证码路径
        verCodeURl:getRootPath_() + "/VerifyCode/VerifyCode",
        //登录地址
        API_loginURL:getRootPath_() + "/login/login.rest",
        //cookie验证
        API_UserCookie:getRootPath_()+"/verify/SelectCookie.rest",
        //首页展示
        HTML_FirstINDEX:getRootPath_()+"/webpage/pages/log/selectlog.html",
        HTML_LeftINDEX:getRootPath_()+"/webpage/pages/left/left.html",
        HTML_HeaderINDEX:getRootPath_()+"/webpage/pages/top/header.html",




    }

}(jQuery);
