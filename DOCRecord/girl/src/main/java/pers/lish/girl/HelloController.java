package pers.lish.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by lishengbo on 2017-12-18
 */
@RestController
public class HelloController {

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

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String say(){
        return "Hello world!";
    }

    @RequestMapping(value = "/yml",method = RequestMethod.GET)
    public String say2(){
        return cupSize+age+"|"+sex+"-----    "+content;
    }
    @RequestMapping(value = "/yml_object",method = RequestMethod.GET)
    public String say3(){
        return gril.toString();
    }

}
