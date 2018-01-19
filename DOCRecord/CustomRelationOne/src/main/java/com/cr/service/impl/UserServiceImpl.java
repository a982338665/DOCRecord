package com.cr.service.impl;

import com.cr.dao.LoginUserBeanDao;
import com.cr.entity.LoginUserBean;
import com.cr.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * create by lishengbo on 2018-01-02 13:19
 *
 * @Component注解：当无法区分是@service/@Dao/@Controller其中的哪个注解时，使用此组件注解
 */
@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    //注入service依赖
    @Autowired //等同于@Resource、@Inject
    private LoginUserBeanDao seckillDao;


    public LoginUserBean login(Map<String, String> map) {

        return seckillDao.login(map);
    }
}
