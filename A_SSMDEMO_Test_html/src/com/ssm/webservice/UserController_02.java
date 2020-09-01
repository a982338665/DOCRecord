package com.ssm.webservice;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.service.sysservice.UserService;
import com.ssm.util.GetRealIp;


@Controller
@RequestMapping("/hello2")
public class UserController_02 {

	private static Logger logger = Logger.getLogger(UserController_02.class);  
    @Autowired
    private UserService userService;

    @RequestMapping(value="/findage")
    public String find(HttpServletRequest request)
    {
    	logger.error(GetRealIp.getIpAddr(request));
        String age=userService.findAge("1");
        logger.error("serch:"+age);
        logger.debug("serch:"+age);
//        System.out.println(age);//如果实验成功，在控制台会打印年龄25
        return "index";
    }
    
    @RequestMapping(value="/logcheck")
    public String logcheck(HttpServletRequest request){
    	String user=request.getParameter("userName");
    	String pwd=request.getParameter("userPass");
    	if(user.equals("123")&&pwd.equals("qaz")){
    		System.out.println(user+"|"+pwd);
    		 return "log";
    	}else if(user.equals("1")&&pwd.equals("1")){
    		 return "htmllog";
    	}else{
    		 return "error";
    	}
    }
}
