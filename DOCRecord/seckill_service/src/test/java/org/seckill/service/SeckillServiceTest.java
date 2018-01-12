package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * create by lishengbo on 2018-01-10 16:58
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring_web/spring-dao.xml", "classpath:spring_web/spring-service.xml"})
public class SeckillServiceTest {

    @Resource
    private SeckillService seckillService;

    @Test
    public void getSeckillList() throws Exception {
        seckillService.getSeckillList();
    }

    @Test
    public void isShowDetail() throws Exception {
    }

    @Test
    public void excute() throws Exception {
    }

}