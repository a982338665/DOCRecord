package pers.lish.classloader.classloader;

/**
 * create by lishengbo on 2017-12-21 11:42
 */
public class Config {
    private String name;

    private static boolean flag;
    static {
        flag = false;
        System.out.println("flag 的值为：" + flag);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
