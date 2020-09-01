package pers.lish.classloader.classloader;

/**
 * create by lishengbo on 2017-12-21 11:41
 */
public class ClassLoaderDemo1 {

    public static void main(String [] args) {
        try {
            ClassLoader system = ClassLoader.getSystemClassLoader();
            Class<Config> cls = null;
            System.out.println("----------方法1----------");
            cls = (Class<Config>) Class.forName("pers.lish.classloader.classloader.Config");

            System.out.println("----------方法2----------");
            cls = (Class<Config>) Class.forName("pers.lish.classloader.classloader.Config", false, system);

            System.out.println("----------方法3----------");
            cls = (Class<Config>) Class.forName("pers.lish.classloader.classloader.Config", true, system);

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /*我们发现方法3没有输出flag的值，这是为什么呢？
    原因是类加载过程中的缓存机制，由于方法1已经加载了该类，因此方法3不会再次加载该类，
    所以没有输出flag值，为了测试缓存的问题，我们将方法1与方法3的位置互换，程序的执行结果如下，
    可以看到方法3加载了该类，并且输出去了flag值，而方法1没有输出flag值。
    我们每次修改完代码都需要重启JVM来执行新的代码也是由类加载的缓存机制造成的*/
}