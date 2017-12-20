package pers.lish.girl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import pers.lish.girl.properties.GirlProperties;

/**
 * create by lishengbo on 2017-12-18
 * RestController注解的使用及properties文件属性读取
 */
@RestController
@RequestMapping("/rest")
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

    /**
     * 基本访问（单路径）
     * @return
     */
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String say(){
        System.out.print("hello");
        return "Hello world!";
    }

    /**
     * yml属性文件读取
     * @return
     */
    @RequestMapping(value = "/yml",method = RequestMethod.GET)
    public String say2(){
        return cupSize+age+"|"+sex+"-----    "+content;
    }
    /**
     * yml属性文件封装对象读取
     * @return
     */
    @RequestMapping(value = "/yml_object",method = RequestMethod.GET)
    public String say3(){
        return gril.toString();
    }

    /**
     * 支持多路径访问：
     * get页面访问
     * post访问：--http工具
     * 若不写提交方式，则都支持，但是为了安全期间，要写出来
     * @return
     */
    @RequestMapping(value ={ "/one","two"},method = RequestMethod.GET)
    public String say4(){
        return gril.toString();
    }

    /**
     * 路径测试：PathVariable--id在前，也可在后
     * http://localhost:8088/girl/rest/one/25
     * 如value ="/{id}/one"
     * 在局部变量接受时，将其映射到访问路径中显示
     * @return
     */
    @RequestMapping(value ="/one/{id}",method = RequestMethod.GET)
    public String say5(@PathVariable("id")Integer id ){
        return "id:"+id;
    }
    /**
     * 路径测试：RequestParam
     * 如：http://localhost:8088/girl/rest/one1?id=111    --myid:111
     * 如：http://localhost:8088/girl/rest/one1?id=       --myid:null
     * 如：http://localhost:8088/girl/rest/one1           --报错
     * 在局部变量接受时，将其映射到访问路径中显示
     * @return
     */
    @RequestMapping(value ="/one1",method = RequestMethod.GET)
    public String say6(@RequestParam("id")Integer myid ){
        return "myid:"+myid;
    }
    /**
     * 路径测试：RequestParam--- 默认值给定
     * 如value="id",required =false,defaultValue = "0"
     * http://localhost:8088/girl/rest/one2?id=      --为null时，值为0
     * http://localhost:8088/girl/rest/one2          --不传默认为0
     * http://localhost:8088/girl/rest/one2?id=111
     * @return
     */
    @RequestMapping(value ="/one2",method = RequestMethod.GET)
    public String say7(@RequestParam(value="id",required =false,defaultValue = "0")Integer myid ){
        return "myid:"+myid;
    }
    /**
     * 组合路径测试：GetMapping("/path")=@RequestMapping(value ="/path",method = RequestMethod.GET)
     */
//    @RequestMapping(value ="/one2",method = RequestMethod.GET)
    @GetMapping("/one3")
    public String say73(@RequestParam(value="id",required =false,defaultValue = "0")Integer myid ){
        return "myid:"+myid;
    }

}
