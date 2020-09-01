package pers.li.model.structure.model_facade;

/**
 * 外观模式：降低了类类之间的耦合度
 *
 * 有了Computer类，他们之间的关系被放在了Computer类里，这样就起到了解耦的作用，这，就是外观模式！
 */
public class User {
      
        public static void main(String[] args) {  
            Computer computer = new Computer();  
            computer.startup();  
            computer.shutdown();  
        }  
    }  
