package pers.li.support.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pers.li.support.common.DefineMould;
import pers.li.support.service.LoginService;

import java.util.Map;

/**
 * create by lishengbo on 2018-03-12 14:21
 */
@Service
public class LoginServiceImpl implements LoginService{


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public Map<String, String> login(Map map) {
        String msg = DefineMould.login_service + "THREADID = " + Thread.currentThread().getId()+".|登录|login|" +map;
        logger.debug("开始验证具体协议",msg);



        return null;
    }
}
