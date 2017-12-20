package pers.lish.girl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.lish.girl.domain.Girl;
import pers.lish.girl.enums.ResultEnum;
import pers.lish.girl.exception.GirlException;
import pers.lish.girl.reponsitory.GirlReponsitory;

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

    /**
     * 用于统一异常处理测试
     * @param id
     * @throws Exception
     */
    public void getAge(Integer id) throws Exception{
        Girl one = girlReponsitory.findOne(id);
        Integer age =one.getAge();
        if(age<18){
//            throw  new Exception( "未成年"+"ooo");
//            throw  new GirlException( 101,"未成年"+"ooo");
            throw  new GirlException(ResultEnum.FAIL);
        }else{
//            throw  new Exception("恭喜已成年"+"ooo");
//            throw  new GirlException(100,"恭喜已成年"+"ooo");
            throw  new GirlException(ResultEnum.SUCCESS);
        }
    }

    /**
     * 用于service单元测试：
     * 快速测试方法：
     * 右键方法名--go to --Test--选中跳转
     * @param id
     * @return
     */
    public Girl findone(Integer id ){
        Girl one = girlReponsitory.findOne(id);
        return one;
    }
    public Girl findone2(Integer id ){
        Girl one = girlReponsitory.findOne(id);
        return one;
    }
}
