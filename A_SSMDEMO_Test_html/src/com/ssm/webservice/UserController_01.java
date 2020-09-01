package com.ssm.webservice;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.service.sysservice.UserService;


@Controller
public class UserController_01 {

	private static Logger logger = Logger.getLogger(UserController_01.class);  
    @Autowired
    private UserService userService;

    @RequestMapping(value="/hello.do")
    public String find(HttpServletRequest request)
    {
        String age=userService.findAge("1");
        List<Map<String,String>> map=userService.getAllUserInfo();
        System.out.println(map.toString()+age);//如果实验成功，在控制台会打印年龄25
        logger.error(map.toString());
        logger.debug(map.toString());

        return "index";
    }
}
