package pers.li.model.create.model_prototype;

/**
 * 原型模式：Cloneable接口是个空接口
 *
 * 浅复制：将一个对象复制后，基本数据类型的变量都会重新创建，而引用类型，指向的还是原对象所指向的。
 *
 * 深复制：将一个对象复制后，不论是基本数据类型还有引用类型，都是重新创建的。简单来说，
 *
 * 就是深复制进行了完全彻底的复制，而浅复制不彻底。
 *
 * 实现深复制，需要采用流的形式读入当前对象的二进制输入，再写出二进制数据对应的对象。
 *
 */
public class Prototype_basic implements Cloneable {
      
        public Object clone() throws CloneNotSupportedException {
            Prototype_basic proto = (Prototype_basic) super.clone();
            return proto;  
        }  
    }  
