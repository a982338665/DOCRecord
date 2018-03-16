$(function () {


    var verCodeURl = $.DEFINE_URL.verCodeURl;
    var API_loginURL=$.DEFINE_URL.API_loginURL;
    var API_UserCookie=$.DEFINE_URL.API_UserCookie;
    var HTML_FirstINDEX=$.DEFINE_URL.HTML_FirstINDEX;

    /**
     *  验证登录cookie信息回显
     */
    // console.log($.cookie("OVTuDyQvKYiaZ7nnY11pNw=="))
    $.ajax({
        type:'get',
        url:API_UserCookie,
        // data:$("#myform").serialize(),
        dataType:'json',
        success:function(data){
            // console.log(data);
            if(data.code==1){
                console.log();
                $("#userName").val(data.data.userName);
                $("#userPass").val(data.data.userPass);
                $("#remember_me1").prop("checked", true);
            }
        }
    });


    //验证码========================================、区分浏览器
    // alert($.getRootPath());
    $("#img_id").attr("src", verCodeURl);

    $("#img_id").click(function () {
        // var target = document.getElementById('img_id');
        // var setImg = function(){
        //
        //     target.src = verCode;
        // };
        //
        // setImg();
        // $.ajaxIO("get",verCode,"#img_id");
        // $("#img_id").removeAttrs("src");
        // $("#img_id").attr("src", verCode);
        location.reload();

    });


        /*var xmlhttp;
        xmlhttp = new XMLHttpRequest();
        xmlhttp.open("GET", verCode, true);
        xmlhttp.responseType = "blob";
        xmlhttp.onload = function () {
            console.log(this);
            if (this.status == 200) {
                var blob = this.response;
                var img= $("#img_id");
                // var img = document.createElement("img");
                img.onload = function (e) {
                    window.URL.revokeObjectURL(img.src);
                };
                $("#img_id").attr("src", verCode);
                // img.src = window.URL.createObjectURL(blob);
                // document.body.appendChild(img);
            }
        }
        xmlhttp.send();*/
    // });
    // $("#img_id").click(function () {
    //
    //     $.ajaxIO("get",verCode,"#img_id");
    //     /*var xmlhttp;
    //     xmlhttp = new XMLHttpRequest();
    //     xmlhttp.open("GET", verCode, true);
    //     xmlhttp.responseType = "blob";
    //     xmlhttp.onload = function () {
    //         console.log(this);
    //         if (this.status == 200) {
    //             var blob = this.response;
    //             var img= $("#img_id");
    //             // var img = document.createElement("img");
    //             img.onload = function (e) {
    //                 window.URL.revokeObjectURL(img.src);
    //             };
    //             $("#img_id").attr("src", verCode);
    //             // img.src = window.URL.createObjectURL(blob);
    //             // document.body.appendChild(img);
    //         }
    //     }
    //     xmlhttp.send();*/
    // });

    //验证cookies-------------------------=======
    // var cusername = $.cookie('userName1');
    // var cuserpass = $.cookie("userPass1");

    // if (null != cusername) {
    //     $("#remember_me1").prop("checked", true);
    //     $("#userName").val(cusername);
    //     $("#userPass").val(cuserpass);
    //
    // }
    $("#get").click(function () {
        var userName = $("#userName").val();
        var userPass = $("#userPass").val();
        if ('' === userName || '' === userPass) {
            ischool.layout.error("用户名密码不能为空", 2000);
            return;
        }

        var loginjson = {};
        loginjson = $("#user").searchFormatSeentao();
        console.log($.jsonToString(loginjson));

        $.ajaxSeentao(API_loginURL, $.jsonToString(loginjson), function (json) {
            if (json.code == '1') {
                console.log(json)
                ischool.layout.success("登录成功", HTML_FirstINDEX);
            } else {
                ischool.layout.error(json.errorMessage, 2000);
                $.ajaxIO("get",verCodeURl,"#img_id");

            }
            console.log(json);
        }, {type: "post"});

    });

    document.onkeydown = function (event_e) {
        if (window.event)
            event_e = window.event;
        var int_keycode = event_e.charCode || event_e.keyCode;
        if (int_keycode == 13) {
            $('#get').click();
        }
    }


})

