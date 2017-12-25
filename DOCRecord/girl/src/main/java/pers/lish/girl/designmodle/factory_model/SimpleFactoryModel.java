package pers.lish.girl.designmodle.factory_model;

/**
 * create by lishengbo on 2017-12-25 15:22
 * 简单工厂模式：--静态工厂模式
 * 开闭原则（对扩展开放；对修改封闭）---可拓展，不修改
 * 车 ----工厂 -----客户
 * 客户向工厂告知自已需要什么车，工厂封装创建细节，返回车给客户
 */
public class SimpleFactoryModel {
    public static void main(String[] args) {
        Factory factory=new Factory();
        factory.getKind("自行车");
    }
}
/**
 * 生产工厂：对外提供自行车/汽车的服务
 */
class Factory{
    public  Object getKind(String kind){
        switch (kind){
            case "自行车":
                return new getBicycle();
            case "汽车":
                return new getBicycle();
            default:
                break;
        }
        return null;
    }

}
/**
 * 生产自行车=============
 */
 class  getBicycle{
    public getBicycle(){
        System.out.println("自行车生产----");
    }
}
/**
 * 生产汽车=============
 */
 class  getCar{
    public getCar(){
        System.out.println("汽车生产----");
    }
}