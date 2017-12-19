package pers.lish.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * create by lishengbo on 2017-12-19 17:37
 */
@Service
public class GirlService {

    /**
     * 数据库设置cupSize长度为1，
     * 以下一个可插入，一个不可插入
     * 示例模仿事务：都插入或都不插入
     */
    @Autowired
    private GirlReponsitory girlReponsitory;

    /**
     * 事务注解，若有报错此方法下所有事务均会回滚
     */
    @Transactional
    public void insert2(){
        try {
            Girl a=new Girl();
            a.setCupSize(1+"");
            a.setAge(23);
            girlReponsitory.save(a);
            Girl b=new Girl();
            b.setCupSize(10+"");
            b.setAge(23);
            girlReponsitory.save(b);
        } catch (Exception e) {
        }
    }
}
