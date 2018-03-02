package com.example.ajaxkuayu;

import org.springframework.web.bind.annotation.*;

/**
 * create by lishengbo on 2018-02-27 14:12
 */
@RestController
@RequestMapping("/test")

//@CrossOrigin
//此注解便可解决跨域问题--如果报错：切换为jdk1.8，
public class TestController {

    @GetMapping("/get1")
    private ResultBean get1(){
        System.out.println("TestController.get1()");
        /**
         * 快速创建ResultBean：鼠标移动到最前面+alt+enter
         */
        return new ResultBean("get1 ok");
    }

    @PostMapping("/postJson")
    public ResultBean postjson(@RequestBody UserBean user){
        System.out.println("TestController.postJson");
        return new ResultBean("postJson:"+user.getName());
    }

    @GetMapping("/getCookie")
    public ResultBean getCookie(@CookieValue(value="cookie1")String cookie1){
        System.out.println("TestController.getCookie");
        return new ResultBean("getCookie="+cookie1);
    }
    @GetMapping("/getHeader")
    public ResultBean getHeader(@RequestHeader(value="x-header1")String header1,
                                @RequestHeader(value="x-header2")String header2){
        System.out.println("TestController.getHeader()");
        return new ResultBean("getHeader="+header1+"||"+header2);
    }
}
