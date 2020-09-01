package pers.li.model.structure.model_adapter;

/**
 * 1.使用继承：source中的method1方法覆盖掉接口中的method1----------类实现
 */
public class Adapter extends Source implements Targetable {
      
        @Override  
        public void method2() {  
            System.out.println("this is the targetable method!");  
        }


    }
