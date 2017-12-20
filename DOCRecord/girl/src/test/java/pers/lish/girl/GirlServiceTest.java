package pers.lish.girl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.lish.girl.domain.Girl;
import pers.lish.girl.service.GirlService;

/**
 * create by lishengbo on 2017-12-20 15:16
 */
@RunWith(SpringRunner.class)//底层junit单元测试
@SpringBootTest             //表示将启动整个工程
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    /**
     * service 测试--右键run
     */
    @Test
    public void findong(){
        Girl findone = girlService.findone(4);
        Assert.assertEquals(new Integer(12),findone.getAge());
    }
}
