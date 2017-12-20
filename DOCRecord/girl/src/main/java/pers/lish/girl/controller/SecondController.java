package pers.lish.girl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pers.lish.girl.properties.GirlProperties;

/**
 * create by lishengbo on 2017-12-18
 * Controller注解使用：
 * Controller注解，使用时返回值为页面，需要模板：
 * 1.pom文件中加入模板
 * 2.接口返回时，只返回名称
 * 注意：此种方式不推荐使用，因为使用模板会影响性能，并且如今大多都已使用前后台分离的形式开发（接口-json）
 */
@Controller
//@RequestMapping("/he")
public class SecondController {

    @Value("${cupSize}")
    private String  cupSize;
    @Value("${age}")
    private String age ;
    @Value("${sex}")
    private String sex;
    @Value("${content}")
    private String content;

    @Autowired
    private GirlProperties gril;

    @RequestMapping(value = "/controller",method = RequestMethod.GET)
    public String say(){
//        System.out.print("asdfasdfasdf");
        return "index";
    }
}

