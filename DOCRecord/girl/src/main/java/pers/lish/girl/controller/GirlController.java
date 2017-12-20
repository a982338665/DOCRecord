package pers.lish.girl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pers.lish.girl.domain.Girl;
import pers.lish.girl.domain.ResultBean;
import pers.lish.girl.reponsitory.GirlReponsitory;
import pers.lish.girl.service.GirlService;
import pers.lish.girl.utils.ResultUtil;

import javax.validation.Valid;
import java.util.List;

/**
 * create by lishengbo on 2017-12-19 16:40
 */
@RestController
public class GirlController {
    @Autowired
    private GirlReponsitory girlreponsitory;
    @Autowired
    private GirlService girlService;

    /**
     * 查询女生列表
     * @return
     */
    @GetMapping("/ppp")
    public List<Girl> girlList(){
        return girlreponsitory.findAll();
    }
    /**
     * 新增女生列表
     * http://localhost:8088/girl/ppp2?age=18&cupSize=33
     * @return
     */
    @PostMapping ("/ppp2")
    public Girl savegirl(@RequestParam("cupSize")  Integer size,@RequestParam("age") Integer age){
        Girl girl=new Girl();
        girl.setAge(age);
        girl.setCupSize(size+"");
        girlreponsitory.save(girl);
        return girl;
    }
    /**
     * 新增女生列表2:实体类接收参数--自定义映射
     * http://localhost:8088/girl/ppp2?age=18&cupSize=33
     * @return
     */
    @PostMapping ("/pppp")
    public Girl savegir3( Girl girl){
        System.out.print(girl);
//        girl.setAge(age);
//        girl.setCupSize(size+"");
        girlreponsitory.save(girl);
        return girl;
    }
    /**
     * 新增女生列表3:实体类接收参数--自定义映射--表单验证@Valid
     * http://localhost:8088/girl/ppp2?age=18&cupSize=33
     * param:BindingResult,用来返回表单验证的结果
     * @return
     */
    @PostMapping ("/pppp2")
    public /*Girl*//*Object*/ResultBean savegir4(@Valid Girl girl, BindingResult bindingResult){
        /*如果表单验证出错则打印错误信息并返回null*/
        if(bindingResult.hasErrors()){
            System.out.print(bindingResult.getFieldError().getDefaultMessage());
//            return bindingResult.getFieldError().getDefaultMessage();
            return ResultUtil.error( bindingResult.getFieldError().getDefaultMessage());
        }
        System.out.print(girl);
        Girl save = girlreponsitory.save(girl);
//        return girl;
        return ResultUtil.success(save);
    }
    /**
     * 查询一个女生
     * http://localhost:8088/girl/ppp3/3
     * @return
     */
    @PostMapping ("/ppp3/{id}")
    public Girl getgirl(@PathVariable("id")  Integer id){
        Girl one = girlreponsitory.findOne(id);
        return one;
    }
    /**
     * 更新一个女生
     * 使用put请求时，Content Type不能使用form-data，要使用/x-www-form-urlencoded
     * 此为http固定协议格式
     * http://localhost:8088/girl/ppp4/4?age=8&cupSize=29
     * @return
     */
    @PutMapping ("/ppp4/{id}")
    public Girl getgirl(@PathVariable("id")  Integer id,@RequestParam("cupSize")  Integer size,@RequestParam("age") Integer age){
        Girl girl=new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(size+"");
        Girl save = girlreponsitory.save(girl);
        return save;
    }
    /**
     * 删除一个女生
     * http://localhost:8088/girl/ppp5/3
     * @return
     */
    @DeleteMapping ("/ppp5/{id}")
    public void getgirl2(@PathVariable("id")  Integer id){
        girlreponsitory.delete(id);
    }
    /**
     * 通过年龄查询女生列表
     * http://localhost:8088/girl/ppp5/3
     * @return
     */
    @PostMapping ("/ppp6/{age}")
    public String getgir4(@PathVariable("age")  Integer age){
        List<Girl> byAge = girlreponsitory.getByAge(age);
        for (Girl s:byAge) {
            System.out.print(s);
        }
        return byAge.toString();
    }
    /**
     * 事务测试
     * http://localhost:8088/girl/ppp5/3
     * @return
     */
    @PostMapping ("/ppp7")
    public String getgir4(){
        try {
            girlService.insert2();
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return "0";
    }
    /**
     * 统一异常处理：查询年龄并判断，业务逻辑写在service
     * http://localhost:8088/girl/pppu?id=6
     * 此种写法默认为？带参数
     * 用于单元测试方法-----------------------
     * @return
     */
    @GetMapping ("/pppu")
    public String getgirw4(Integer id ) throws  Exception {
//        int s=4/0;
        girlService.getAge(id);
        return null;
    }
}
