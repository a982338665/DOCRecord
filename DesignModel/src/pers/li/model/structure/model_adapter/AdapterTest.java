package pers.li.model.structure.model_adapter;

/**
 * 1.类的适配器模式：当希望将一个类转换成满足另一个新接口的类时，可以使用类的适配器模式，创建一个新类，
 *      继承原有的类，实现新的接口即可。
 * 2.对象的适配器模式：当希望将一个对象转换成满足另一个新接口的对象时，可以创建一个Wrapper类，
 *      持有原类的一个实例，在Wrapper类的方法中，调用实例的方法就行。
 * 3.接口的适配器模式：当不希望实现一个接口中所有的方法时，可以创建一个抽象类Wrapper，实现所有方法，
 *      我们写别的类的时候，继承抽象类即可。
 */
public class AdapterTest {

    public static void main(String[] args) {
        /**
         * 使用继承达到适配器模式
         */
        Targetable target = new Adapter();
        target.method1();
        target.method2();


        /**
         * 使用对象持有，达成是配置模式
         */
        Source source = new Source();
        Targetable target2 = new Wrapper(source);
        target.method1();
        target.method2();

        /**
         * 接口适配器模式测试---抽象接口(API项目多平台使用-利用的就是此中适配器模式)
         */
        Targetable target3=new SourceSub1();
        target3.method1();
        target3.method2();
        Targetable target4=new SourceSub2();
        target4.method1();
        target4.method2();



    }


}
