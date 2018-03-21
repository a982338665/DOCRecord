package pers.li.model.action.model_chain.basic;

/**
 * 每个对象持有对下一个对象的引用，这样就会形成一条链
 */
public class Test {
  
    public static void main(String[] args) {  
        MyHandler h1 = new MyHandler("h1");  
        MyHandler h2 = new MyHandler("h2");  
        MyHandler h3 = new MyHandler("h3");  
  
        h1.setHandler(h2);  
        h2.setHandler(h3);  
  
        h1.operator();  
    }  
} 