package pers.lish.girl.aoplearning.staticproxy;

/**
 * create by lishengbo on 2017-12-22 15:52
 * 真实实现类
 */
public class RealClass implements  Subject {
    @Override
    public void request() {
        System.out.println("真实业务逻辑----");
    }

    @Override
    public void hello() {
        System.out.println("hello=======----");
    }
}
