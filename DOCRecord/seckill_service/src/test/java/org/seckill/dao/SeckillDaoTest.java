package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SeckillBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * create by lishengbo on 2018-01-10 16:19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring_web/spring-dao.xml")
public class SeckillDaoTest {
    /**
     *注入Dao实现类依赖
     */
    @Resource
    private SeckillDao seckillDao;
    @Test
    public void queryById() throws Exception {
        long id=1000L;
        SeckillBean seckillBean = seckillDao.queryById(id);
        System.out.println(seckillBean.toString());
    }

}