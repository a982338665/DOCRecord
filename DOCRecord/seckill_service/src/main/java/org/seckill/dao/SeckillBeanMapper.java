package org.seckill.dao;

import org.seckill.entity.SeckillBean;

public interface SeckillBeanMapper {
    int deleteByPrimaryKey(Long seckillId);

    int insert(SeckillBean record);

    int insertSelective(SeckillBean record);

    SeckillBean selectByPrimaryKey(Long seckillId);

    int updateByPrimaryKeySelective(SeckillBean record);

    int updateByPrimaryKey(SeckillBean record);
}