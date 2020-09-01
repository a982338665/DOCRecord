package pers.lish.classloader.factory;

/**
 * create by lishengbo on 2017-12-21 11:03
 * x抽象工厂模式
 * 告诉那个工厂要什么车
 */
public class HardFactory {
    public static void main(String[] args) {
//        FactoryBMW320 factoryBMW320 = new FactoryBMW320();
//        BMW320 bmw320 = factoryBMW320.createBMW();
//
//        FactoryBMW523 factoryBMW523 = new FactoryBMW523();
//        BMW523 bmw523 = factoryBMW523.createBMW();
    }
}
/**********产品类*********************************/

abstract class BMWw {
    public BMWw(){

    }
}
 class BMW320qw extends BMW {
    public BMW320qw() {
        System.out.println("制造-->BMW320");
    }
}
 class BMW523qw extends BMW{
    public BMW523qw(){
        System.out.println("制造-->BMW523");
    }
 /**********创建工厂类********************************/
 interface FactoryBMW {
     BMW createBMW();
 }
  class FactoryBMW320 implements FactoryBMW{
         @Override
         public BMW320qw createBMW() {
             return new BMW320qw();
         }

     }
 class FactoryBMW523 implements FactoryBMW {
         @Override
         public BMW523qw createBMW() {

             return new BMW523qw();
         }
     }
   class Managerfactory{


    }
 }