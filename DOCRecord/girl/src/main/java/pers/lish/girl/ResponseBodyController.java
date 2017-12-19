package pers.lish.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * create by lishengbo on 2017-12-18
 * Controller注解使用：
 * Controller和ResponseBody联合使用=注解RestController
 */
@Controller
@ResponseBody
public class ResponseBodyController {
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

    @RequestMapping(value = "/controller2",method = RequestMethod.GET)
    public String say(){
//        System.out.print("asdfasdfasdf");
        return "index";
    }
}

