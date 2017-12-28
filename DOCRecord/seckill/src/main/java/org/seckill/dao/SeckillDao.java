package org.seckill.dao;

import org.seckill.entity.SeckillBean;

import java.util.Date;
import java.util.List;

/**
 * create by lishengbo on 2017-12-28 10:51
 */
public interface SeckillDao {
    /**
     * 减库存
     * @param seckillId
     * @param killTime
     * @return 影响几条数据
     */
    int reduceNumber (long seckillId, Date killTime);
    /**
     * 根据id查询秒杀对象
     * @param seckilled
     * @return
     */
    SeckillBean queryById(long seckilled);
    /**
     * 根据偏移量查询秒杀商品列表
     * @param offset
     * @param limit
     * @return
     */
    List<SeckillBean> queryAll(int offset,int limit);



}
