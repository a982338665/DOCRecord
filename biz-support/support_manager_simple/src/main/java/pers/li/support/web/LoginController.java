package pers.li.support.web;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.li.support.common.DefineCode;
import pers.li.support.common.DefineMould;
import pers.li.support.common.ResultBean;
import pers.li.support.service.LoginService;

import java.util.HashMap;
import java.util.Map;

/**
 * create by lishengbo on 2018-01-02 17:42
 */
@Controller//放入Spring容器
@RequestMapping("/login")
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LoginService loginService;


    //ajax  json  开启秒杀
    @RequestMapping(value = "/login",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"}
    )
    @ResponseBody
    public ResultBean<Map> exposer(@RequestBody Map map) {
        String ysBean = new Gson().toJson(map);
        String msg = DefineMould.login + "THREADID = " + Thread.currentThread().getId()+".|登录|login|" +ysBean;
        logger.debug("开始验证具体协议",msg);
        Map<String, String> mapp = new HashMap<String, String>();
        ResultBean<Map> result;
        try {
            mapp = loginService.login(map);
            result = new ResultBean<Map>(DefineCode.CODE_SUCCESS,mapp);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result = new ResultBean<Map>(DefineCode.CODE_TRY_CATCH_ERROR,e.getMessage());
    }
        return result;
    }


}
