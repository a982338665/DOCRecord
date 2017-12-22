package pers.lish.girl.aoplearning.staticproxy;

/**
 * create by lishengbo on 2017-12-22 16:02
 */
public class ClientTest {
    public static void main(String[] args) {
        //代理实现类，委托给真实实现类去操作
        Subject subject=new ProxyClass(new RealClass());
        subject.request();
    }
}
