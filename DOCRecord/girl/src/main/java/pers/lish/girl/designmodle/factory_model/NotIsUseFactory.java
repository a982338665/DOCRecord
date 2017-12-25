package pers.lish.girl.designmodle.factory_model;

/**
 * 未使用工厂模式：直接由消费者提需求，自己创建产品
 * create by lishengbo on 2017-12-25 15:20
 */
public class NotIsUseFactory {
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
