package pers.lish.girl.aspect;

/**
 * create by lishengbo on 2017-12-22 12:17
 */
public class CurrentHolder {
    private static final ThreadLocal<String> holeder=new ThreadLocal<>();

    public static String get(){
        return holeder.get()==null?"unknow":holeder.get();
    }
    public  static  void  set(String user){
        holeder.set(user);
    }
}
