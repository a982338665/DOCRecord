package pers.lish.classloader.factory;

/**
 * create by lishengbo on 2017-12-21 10:57
 * 简单工厂模式：--静态工厂模式
 * 开闭原则（对扩展开放；对修改封闭）---可拓展，不修改
 * 车 ----工厂 -----客户
 * 客户向工厂告知自已需要什么车，工厂封装创建细节，返回车给客户
 *
 */
public class SimpleFactory {
    public static void main(String[] args) {
        Factory factory = new Factory();
        BMW bmw320 = factory.createBMW(320);
        BMW bmw523 = factory.createBMW(523);
    }
}
/**********产品类*********************************/
abstract  class BMW {
    public BMW(){

    }
}
class BMW3201 extends BMW {
    public BMW3201() {
        System.out.println("制造-->BMW320");
    }
}
class BMW5232 extends BMW{
    public BMW5232(){
        System.out.println("制造-->BMW523");
    }
}
/*********工厂类*********************************/
 class Factory {
    public BMW createBMW(int type) {
        switch (type) {
            case 320:
                return new BMW3201();
            case 523:
                return new BMW5232();
            default:
                break;
        }
        return null;
    }
}