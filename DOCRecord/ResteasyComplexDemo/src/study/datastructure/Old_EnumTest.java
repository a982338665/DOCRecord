package study.datastructure;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Enumeration:
 * 此为传统接口，现已被迭代器所替代，
 * Vector和Properties这些传统类所定义的方法中还会有此使用
 * 枚举（The Enumeration）接口定义了从数据结构中取回连续元素的方式。 
 * @author lishengbo
 * @Time 2017年12月8日下午4:33:19
 */
public class Old_EnumTest {


	   public static void main(String args[]) {
	      Enumeration<String> days;
	      Vector<String> dayNames = new Vector<String>();
	      dayNames.add("Sunday");
	      dayNames.add("Monday");
	      dayNames.add("Tuesday");
	      dayNames.add("Wednesday");
	      dayNames.add("Thursday");
	      dayNames.add("Friday");
	      dayNames.add("Saturday");
	      days = dayNames.elements();
	      System.out.println(days.toString());
	      while (days.hasMoreElements()){
	         System.out.println(days.nextElement()); 
	      }
	   }
}
