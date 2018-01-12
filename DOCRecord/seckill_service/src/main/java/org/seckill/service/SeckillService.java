package org.seckill.service;

import org.seckill.entity.SeckillBean;

import java.util.List;
import java.util.Map;

/**
 * create by lishengbo on 2018-01-10 16:34
 *
 * 业务分析：
 * 1.列表查询秒杀
 * 2.查询单个秒杀任务详情
 * 3.内部判断是否展示秒杀详情页面
 * 4.开始执行秒杀
 *
 */
public interface SeckillService {

    /**
     * 查询秒杀列表
     * @return
     */
    List<SeckillBean> getSeckillList();

    /**
     * 判断是否展示详情页
     * @return
     */
    Map<String,String> isShowDetail(long seckillId);

    /**
     * 执行秒杀
     * @return
     */
    Map<String,String> excute(long seckillId, long userPhone, String md5);




}
