package pers.lish.classloader.factory;

/**
 * 直接满足用户需求，自己创建产品
 * create by lishengbo on 2017-12-21 10:55
 */
public class BaseFactory {
    public static void main(String[] args) {
        /***用户自己创建产品***/
        BMW320 bmw320 = new BMW320();
        BMW523 bmw523 = new BMW523();
    }
}
 class BMW320 {
    public BMW320(){
        System.out.println("制造-->BMW320");
    }
}

 class BMW523 {
    public BMW523(){
        System.out.println("制造-->BMW523");
    }
}