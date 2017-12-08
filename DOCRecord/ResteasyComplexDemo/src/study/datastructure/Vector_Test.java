package study.datastructure;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 向量--实现了一个动态数组。和ArrayList和相似，但是两者是不同的:
 * 		--1.Vector是同步访问的。
		--2.Vector包含了许多传统的方法，这些方法不属于集合框架
		--3.Vector主要用在事先不知道数组的大小，或者只是需要一个可以改变大小的数组的情况
     使用Vector类最主要的好处就是在创建对象的时候不必给对象指定大小，它的大小会根据需要动态的变化。
  *************************************
  *Vector类支持4种构造方法。
		--第一种构造方法创建一个默认的向量，默认大小为10：
		--Vector()
		--第二种构造方法创建指定大小的向量。
		--Vector(int size)
		--第三种构造方法创建指定大小的向量，并且增量用incr指定. 增量表示向量每次增加的元素数目。
		--Vector(int size,int incr)
		--第四种构造方法创建一个包含集合c元素的向量：
		--Vector(Collection c)
 * @author lishengbo
 * @Time 2017年12月8日下午4:47:03
 */
public class Vector_Test {
	   public static void main(String args[]) {
	      // initial size is 3, increment is 2
		  int size=3;
		  int inc=2;
	      Vector v = new Vector(size, inc);
	      System.out.println("创建容量为"+size+"的数组，当容量不够时，每次加"+inc+"2");
	      System.out.println("返回此向量中的组件数: " + v.size());
	      System.out.println("返回此向量的当前容量:" +v.capacity());
	      v.addElement(new Integer(1));
	      System.out.println("addElement将指定的组件添加到此向量的末尾，将其大小增加 1变为：|"+v.size()+"此时当前向量容量为："+v.capacity());
	      v.addElement(new Integer(2));
	      System.out.println("addElement将指定的组件添加到此向量的末尾，将其大小增加 1变为：|"+v.size()+"此时当前向量容量为："+v.capacity());
	      v.addElement(new Integer(3));
	      System.out.println("addElement将指定的组件添加到此向量的末尾，将其大小增加 1变为：|"+v.size()+"此时当前向量容量为："+v.capacity());
	      v.addElement(new Integer(4));
	      System.out.println("addElement将指定的组件添加到此向量的末尾，将其大小增加 1变为：|"+v.size()+"此时当前向量容量为："+v.capacity());
	      v.addElement(new Double(5.45));
	      System.out.println("addElement将指定的组件添加到此向量的末尾，将其大小增加 1变为：|"+v.size()+"此时当前向量容量为："+v.capacity());
	      v.addElement(new Double(6.08));
	      v.addElement(new Integer(7));
	      System.out.println("addElement将指定的组件添加到此向量的末尾，将其大小增加 1变为：|"+v.size()+"此时当前向量容量为："+v.capacity());
	      v.addElement(new Float(9.4));
	      v.addElement(new Integer(10));
	      System.out.println("截止目前为止插入的第一个元素："+(Integer)v.firstElement());
	      System.out.println("截止目前为止插入的最后一个元素：" +(Integer)v.lastElement());
	      if(v.contains(new Integer(3)))
	         System.out.println("如果此向量contains包含指定的元素，则返回 true。");
	      // enumerate the elements in the vector.
	      Enumeration vEnum = v.elements();
	      System.out.println("\nElements in vector:");
	      while(vEnum.hasMoreElements())
	         System.out.print(vEnum.nextElement() + " ");
	      System.out.println();
	   }
}
