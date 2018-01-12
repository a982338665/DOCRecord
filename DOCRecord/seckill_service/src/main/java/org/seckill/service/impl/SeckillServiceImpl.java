package org.seckill.service.impl;

import org.seckill.dao.SeckillDao;
import org.seckill.entity.SeckillBean;
import org.seckill.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * create by lishengbo on 2018-01-10 16:45
 */
@Service
public class SeckillServiceImpl implements SeckillService {

    @Autowired
    private SeckillDao seckillDao;

    public List<SeckillBean> getSeckillList() {
        List<SeckillBean> seckillBeans = seckillDao.queryAll(0, 4);
        return seckillBeans;
    }

    public Map<String, String> isShowDetail(long seckillId) {

        SeckillBean seckillBean = seckillDao.queryById(seckillId);


        return null;
    }

    public Map<String, String> excute(long seckillId, long userPhone, String md5) {
        return null;
    }

}
