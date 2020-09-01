package pers.li.model.create.model_single;

/**
 * create by lishengbo on 2017-12-26 11:39
 * 单例对象能保证在一个JVM中，该对象只有一个实例存在
 * 懒汉式
 */
public class SingleModel_lazy {

    private SingleModel_lazy() {

    }

    private static SingleModel_lazy singleModel_lazy = null;

    /**
     * synchronized关键字锁住的是这个对象，这样的用法，在性能上会有所下降，
     * 因为每次调用getInstance()，都要对对象上锁，
     * 事实上，只有在第一次创建对象的时候需要加锁，之后就不需要了，所以，这个地方需要改进。如下
     *
     * @return public synchronized static SingleModel_lazy getInstance(){
     * if(singleModel_lazy==null){
     * singleModel_lazy=new SingleModel_lazy();
     * }
     * return singleModel_lazy;
     * }
     *************************************************************
     * 将synchronized关键字加在了内部，也就是说当调用的时候是不需要加锁的，
     * 只有在instance为null，并创建对象的时候才需要加锁，
     * 性能有一定的提升。但是，这样的情况，还是有可能有问题的
     *
     *
     *
     *
     *
     *
     *
     */
    public static SingleModel_lazy getInstance() {
        if (singleModel_lazy == null) {
            synchronized (singleModel_lazy) {
                if (singleModel_lazy == null) {
                    singleModel_lazy = new SingleModel_lazy();
                }
            }
        }
        return singleModel_lazy;
    }

    /* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */
    public Object readResolve() {
        return singleModel_lazy;
    }
}
