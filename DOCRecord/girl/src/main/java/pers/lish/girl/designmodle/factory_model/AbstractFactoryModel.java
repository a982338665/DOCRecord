package pers.lish.girl.designmodle.factory_model;

/**
 * create by lishengbo on 2017-12-25 15:49
 * 抽象工厂模式：
 */
public class AbstractFactoryModel {
    public static void main(String[] args) {
        AbstractFactory abstractFactory=new buyAnimal();
        AbstractFactory abstractFactory2=new buyFood();
        abstractFactory.buyThing("哈士奇");
        abstractFactory2.buyThing("面包");

    }

}

/**
 * 抽象工厂定义：---
 */
abstract class AbstractFactory{
    abstract Object buyThing(String thing);
}

/**
 * 宠物实体工厂
 */
class buyAnimal extends AbstractFactory{
    @Override
    Object buyThing(String thing) {
        switch (thing){
            case "泰迪":
                return new TaiDI();
            case "哈士奇":
                return new HaShiQi();
        }
        return  null;
    }
}/**
 * 食物实体工厂
 */
class buyFood extends AbstractFactory{
    @Override
    Object buyThing(String thing) {
        switch (thing){
            case "面包":
                return new MianBao();
            case "牛奶":
                return new Milk();
        }
        return  null;
    }
}
/***********产品定义**********************/
class MianBao{
    public MianBao() {System.out.println("面包----");
    }
}
class Milk{
    public Milk() {System.out.println("牛奶----");
    }
}
class TaiDI{
    public TaiDI() {System.out.println("泰迪----");
    }
}
class HaShiQi{
    public HaShiQi() {System.out.println("哈士奇----");
    }
}
