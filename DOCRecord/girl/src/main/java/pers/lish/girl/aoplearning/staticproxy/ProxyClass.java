package pers.lish.girl.aoplearning.staticproxy;

/**
 * create by lishengbo on 2017-12-22 15:53
 * 代理实现类----需要引用真实实现类
 */
public class ProxyClass implements Subject {


    private  RealClass realClass;

    /**
     * 引用真实实现类
     * @param realClass
     */
    public  ProxyClass ( RealClass realClass){
        this.realClass=realClass;
    }

    @Override
    public void request() {
        //引用开始前做事
        System.out.println("代理前执行----------------");
        try {
            realClass.request();
        } catch (Exception e) {
            System.out.println("错误：-----"+e.getMessage());
            System.out.println("代理类不能改变实际的逻辑执行，所以异常要抛出");
            throw e;
        } finally {
            System.out.println("代理后执行----------------");
        }
    }

    @Override
    public void hello() {
//引用开始前做事
        System.out.println("代理前执行----------------");
        try {
            realClass.hello();
        } catch (Exception e) {
            System.out.println("错误：-----"+e.getMessage());
            System.out.println("代理类不能改变实际的逻辑执行，所以异常要抛出");
            throw e;
        } finally {
            System.out.println("代理后执行----------------");
        }
    }
}
