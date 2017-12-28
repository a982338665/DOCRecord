package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SeckillBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * create by lishengbo on 2017-12-28 14:56
 * 配置Spring junit整合，junit启动时要加载spring ioc容器
 * spring-test、junit依赖
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class SeckillDaoTest {
    /**
     *注入Dao实现类依赖
     */
    @Resource
    private SeckillDao seckillDao;

    @Test
    public void reduceNumber() throws Exception {
        long id=1000L;
        System.out.println(id);
    }

    @Test
    public void queryById() throws Exception {
        long id=1000L;
        SeckillBean seckillBean = seckillDao.queryById(id);
        System.out.println(seckillBean.toString());

    }

    @Test
    public void queryAll() throws Exception {

    }

}