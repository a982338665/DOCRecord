package study;

import org.junit.Test;

/**
 * 总得来说对于一个final变量，如果是基本数据类型的变量，则其数值一旦在初始化之后便不能更改；
 * 如果是引用类型的变量，则在对其初始化之后便不能再让其指向另一个对象。
 * @author lishengbo
 * @Time 2017年12月8日下午2:37:21
 */
public class finalTest {
	/**
	 * final修饰的引用数据类型变量，引用地址不会改变，但是值是可变的
	 */
	@Test 
    public  void fghsh() {  
        final StringBuilder sb = new StringBuilder("haha");  
        //同一对象的hashCode值相同  
        System.out.println("sb中的内容是："+sb);  
        System.out.println(sb+"的哈希编码是:"+sb.hashCode());  
        sb.append("我变了");  
        System.out.println("sb中的内容是："+sb);  
        System.out.println(sb+"的哈希编码是:"+sb.hashCode());  
        System.out.println("-----------------哈希值-------------------");  
        finalTest test = new finalTest();  
        System.out.println(test.hashCode());  
        System.out.println(Integer.toHexString(test.hashCode()));  
        System.out.println(test.getClass()+"@"+Integer.toHexString(test.hashCode()));  
        System.out.println(test.getClass().getName()+"@"+Integer.toHexString(test.hashCode()));  
        //在API中这么定义toString()等同于 getClass().getName() + '@' + Integer.toHexString(hashCode())  
        //返回值是 a string representation of the object.  
        System.out.println(test.toString());  
    }  
	/**
	 * final修饰基本数据类型的变量，不能够重新赋值，即初始化之后不能改变：
	 * 栈是运行时的单位，而堆是存储的单位。 
	 * 实际上基本数据类型在栈空间里存储，而引用数据类型数据存在于堆中，引用的地址存在于栈中
	 */
	@Test 
	public  void fghshsss() {  
		final int sb =15;  
		System.out.println("final基础数据类型：初始值"+sb);
//		sb=sb+5;//报错
	}  
}
