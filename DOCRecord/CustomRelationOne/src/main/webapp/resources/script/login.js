$(function () {
    //存放主要交互逻辑
    //javascript模块化
    var httpurl={
        login:'/User/login'



    }

    var jumpurl={


    }




    $('#userName').attr('value','lishengbo');
    $('#userPass').attr('value','qazwsx123');

    // alert($('#online').val());

    $('#login').click(function () {
        var userName=$('#userName').val();
        var userPass=$('#userPass').val();
        var isRemand=$('#online').val();
        if(!login.validateUserName(userName)){
            $('#errorshow').html('用户名不合法:请输入5-20个以字母开头,包含数字的字串');
            return;
        }
        if(!login.validateUserPass(userPass)){
            $('#errorshow').html('密码不合法:仅支持输入6-20个字母、数字、下划线');
            return;
        }

        var loginjson = {};
        loginjson = $("#loginform").searchFormatSeentao();
        console.log($.jsonToString(loginjson));

        window.location.href='../webapp/resources/login.html';



        /*$.ajax({
            type : 'post',
            url : url.login,
            //设置contentType类型为json
            contentType : 'application/json;charset=utf-8',
            //json数据
            data :$.jsonToString(loginjson),
            //请求成功后的回调函数+
            success : function(data) {
                var result = JSON.parse(data);
                // if(result.code == "200") {
                //     var dataList = eval(result.result);
                //     var collectionActivitieslistStr = "";
                //     for(var i = 0;i<dataList.length;i++) {
                //         collectionActivitieslistStr += '<div class="release01 clearfix"><div class="release01-zf"><a href="forwardDetail?articleId='+dataList[i].activityId+'"><img src="'+dataList[i].imagePath+'"/></a></div>';
                //         collectionActivitieslistStr += '<div class="release01-yr"><div class="release01-yrbt clearfix"><a href="forwardDetail?articleId='+dataList[i].activityId+'"><h2>'+dataList[i].title+'</h2></a><span>'+dataList[i].createTime+'</span>';
                //         collectionActivitieslistStr += '</div>'+dataList[i].description+'<a href="forwardDetail?articleId='+dataList[i].activityId+'">详情 >></a></div></div>';
                //     }
                //     total = result.total;
                //     if(pageNo == '1') {
                //         //initPageContent();
                //     }
                //     $('#collectionActivitieslist').html(collectionActivitieslistStr);
                // } else {
                //     total = 0;
                // }


            }
        });*/




    });

    var login = {
        //封装秒杀相关ajax的url
        URL: {
            //或者可以写为 nowq:function () {return '/seckill/time/now';}
            login: '/seckill/time/now',
            exposer: function (seckillId) {
                return '/seckill/' + seckillId + '/exposer/';
            },
            execution: function (seckillId, md5) {
                return '/seckill/' + seckillId + '/' + md5 + '/execution';
            }

        },
        //验证手机号
        validatePhone: function (phone) {
            //存在、长度为11、电话全为数字
            if (phone && phone.length == 11 && !isNaN(phone)) {
                return true;
            } else {
                return false;
            }
        },
        //时间判断方法抽取
        countDown: function (seckillId, nowTime, startTime, endTime) {
            var seckillBox = $('#seckill-box');
            //时间判断
            if (nowTime > endTime) {
                //秒杀结束
                seckillBox.html('秒杀结束');
            } else if (nowTime < startTime) {
                //秒杀为开始，计时逻辑，jquery的countDown插件,计时事件绑定
                var killTime = new Date(startTime + 1000);
                seckillBox.countdown(killTime, function (event) {
                    var format = event.strftime('秒杀倒计时: %D天 %H时 %M分 %S秒');
                    seckillBox.html(format);
                    //时间完成后回调事件
                }).on('finish.countdown', function () {
                    //获取秒杀地址，控制实现逻辑，执行秒杀
                    //秒杀id + 节点（放秒杀按钮进去）
                    seckill.handlerSeckill(seckillId, seckillBox);
                });
            } else {
                //秒杀开始
                seckill.handlerSeckill(seckillId, seckillBox);
            }
        },
        //处理秒杀逻辑
        handlerSeckill: function (seckillId, node) {
            //先隐藏节点
            node.hide().html('<button class="btn btn-primary btn-lg" id="killBtn">开始秒杀</button>');
            $.post(seckill.URL.exposer(seckillId), {}, function (result) {
                //在回调函数中执行交互
                if (result && result['success']) {
                    var exposer = result['data'];
                    if (exposer['exposed']) {
                        //开启秒杀
                        //获取秒杀地址
                        var md5 = exposer['md5'];
                        var killUrl = seckill.URL.execution(seckillId, md5);
                        console.log("killUrl:" + killUrl);
                        //绑定一次点击事件，防止用户连续点击
                        $('#killBtn').one('click', function () {
                            //执行秒杀请求操作
                            //1.禁用按钮
                            $(this).addClass('disabled');
                            //2.发送秒杀请求
                            $.post(killUrl, {}, function (result) {
                                if (result && result['success']) {
                                    var killResult = result['data'];
                                    var state = killResult['state'];
                                    var stateInfo = killResult['stateInfo'];
                                    //显示秒杀结果
                                    node.html('<span class="label label-success">' + stateInfo + '</span>');
                                }
                            })
                        });
                        //展示隐藏的节点
                        node.show();
                    } else {
                        //未开启秒杀,由客户端和服务器造成的时间差异导致秒杀并未准时开始，从而需要再次验证倒计时
                        var now = exposer['now'];
                        var start = exposer['start'];
                        var end = exposer['end'];
                        seckill.countDown(seckillId, now, start, end);
                    }
                } else {
                    console.log('result:' + result);
                }
            });


        },
        //校验登录名：只能输入5-20个以字母开头、可带数字、“_”、“.”的字串
        validateUserName: function isUserName(s) {
            var patrn = /^[a-zA-Z]{1}([a-zA-Z0-9]|[._]){4,19}$/;
            //typeof 返回的是字符串,有六种可能:"number" "String" "boolean" "object" "function" "undefined"
            if (!patrn.exec(s)||typeof(s)=="undefined") return false
            return true
        },
        //校验密码：只能输入6-20个字母、数字、下划线
        validateUserPass: function isUserPass(s) {
            var patrn = /^(\w){6,20}$/;
            if (!patrn.exec(s)||typeof(s)=="undefined") return false
            return true
        },
        //登录js
        login: {
            init: function (params) {
                //规划交互流程
                //在cookies中查找用户名密码
                var userName = $.cookie('userName');
                var userPass = $.cookie('userPass');
                if (userName != null) {
                    $("#userName").attr('value',userName);
                    $("#online").attr('checked',true);
                }

                if (userPass!= null) {
                    $("#userName").attr('value',userName);
                }


                //验证手机号
                //如果没登录，绑定phone
                /*  if (!seckill.validatePhone(killPhone)) {
                      //控制输出
                      var killPhoneModal = $('#killPhoneModal');
                      //modal传参为json
                      killPhoneModal.modal({
                          show: true,//显示弹出层
                          backdrop: 'static',//禁止位置关闭，不允许鼠标关闭弹窗
                          keyboard: false //关闭键盘事件
                      });
                      $('#killPhoneBtn').click(function () {
                          var inputPhone = $('#killPhoneKey').val();
                          console.log(inputPhone);//TODO 调试需要
                          //若验证通过
                          if (seckill.validatePhone(inputPhone)) {
                              //电话写入cookie,有效期7天，仅在/seckill路径下有效
                              $.cookie('killPhone', inputPhone, {expires: 7, path: '/seckill'});
                              //刷新页面
                              window.location.reload();
                          } else {//手机号仍有问题,先隐藏后填充内容最后在显示,300毫秒动态显示
                              //此处的提示信息可抽为一个提示字典
                              $('#killPhoneMessage').hide().html(' <label class="label label-danger">手机号错误:</label>').show(300);
                          }
                      });
                  }*/
                //已经登录
                //计时交互：当前时间统一取服务器时间|访问路径，参数，回调函数,结果参数
                /*var startTime = params['startTime'];
                var endTime = params['endTime'];
                var seckillId = params['seckillId'];
                $.get(seckill.URL.now, {}, function (result) {
                    if (result && result['success']) {
                        var nowTime = result['data'];
                        //时间判断，计时交互
                        seckill.countDown(seckillId, nowTime, startTime, endTime);
                    } else {
                        console.log('result:' + result);
                    }
                });*/
            }
        }
    }



});