package org.seckill.service.impl;

import org.seckill.dao.SeckillDao;
import org.seckill.dao.SuccessKillDao;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.SeckillBean;
import org.seckill.entity.SuccessKilledBean;
import org.seckill.enums.SeckillStateEnum;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * create by lishengbo on 2018-01-02 13:19
 * @Component注解：当无法区分是@service/@Dao/@Controller其中的哪个注解时，使用此组件注解
 */
@Service
public class SeckillServiceImpl implements SeckillService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    //注入service依赖
    @Autowired //等同于@Resource、@Inject
    private SeckillDao seckillDao;
    @Autowired
    private SuccessKillDao successKillDao;
    /**
     * md5盐值字符串，用于混淆md5
     */
    private final String slat = "asdfafgagah(*&(*)__))KHKJ@#￥￥@￥*";

    public List<SeckillBean> getSeckillList() {
        return seckillDao.queryAll(0, 4);
    }

    public SeckillBean getById(long seckillId) {
        return seckillDao.queryById(seckillId);
    }

    public Exposer exportSeckillUrl(long seckillId) {
        SeckillBean seckillBean = seckillDao.queryById(seckillId);
        if (seckillBean == null) {
            return new Exposer(false, seckillId);
        }
        Date startTime = seckillBean.getStartTime();
        Date endTime = seckillBean.getEndTime();
        Date now = new Date();
        if (now.getTime() < startTime.getTime() || now.getTime() > endTime.getTime()) {
            return new Exposer(false, seckillId, now.getTime(), startTime.getTime(), endTime.getTime());
        }
        //转化指定字符串的过程，不可逆
        String md5 = getMd5(seckillId);//TODO
        return new Exposer(true, md5, seckillId);
    }

    /**
     * 用于生成md5
     *
     * @param seckillId
     * @return
     */
    private String getMd5(long seckillId) {
        String base = seckillId + "/" + slat;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }

    @Transactional
    /**
     * 使用注解控制事务方法的有点：
     * 1.开发团队达成一致约定，明确标注事务方法的编程风格
     * 2.保证事务方法的执行时间尽可能短，不要穿插其他网络操作（HTTP协议、cache、redis等请求或者剥离到事务之外）
     * 3.不是所有的方法都需要事务，如只有一条修改操作，只读操作不需要事务控制
     */
    public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5) throws SeckillException, RepeatKillException, SeckillCloseException {
        if (md5 == null || !md5.equals(getMd5(seckillId))) {
            throw new SeckillException("seckill data rewrite");
        }
        //执行秒杀逻辑，减库存+记录购买行为
        Date nowTime = new Date();
        //减库存
        try {
            int reduceNumber = seckillDao.reduceNumber(seckillId, nowTime);
            if (reduceNumber <= 0) {
                //没有更新到记录，秒杀结束
                throw new SeckillCloseException("seckill is closed");
            } else {
                //记录购买行为
                int i = successKillDao.insertSuccesskilled(seckillId, userPhone);
                //唯一：seckillId,userrPhone
                if (i <= 0) {
                    //重复秒杀
                    throw new RepeatKillException("seckill repeated");
                } else {
                    //秒杀成功
                    SuccessKilledBean successKilledBean = successKillDao.queryByIdWhitSeckill(seckillId, userPhone);
                    return new SeckillExecution(seckillId, SeckillStateEnum.SUCCESS, successKilledBean);
                }
            }
        } catch (SeckillCloseException e) {
            throw e;
        } catch (RepeatKillException e) {
            throw e;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            //所有编译期异常转换为运行期异常,spring申明式事务会进行事务回滚
            throw new SeckillException("seckill inner error:" + e.getMessage());
        }
    }
}
