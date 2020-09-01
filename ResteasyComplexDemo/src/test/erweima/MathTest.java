package test.erweima;

import java.util.Formatter;
import java.util.Vector;

public class MathTest {

	public static void main(String[] args) {
		//ceil()：将小数部分一律向整数部分进位。
		//如：

		Math.ceil(12.2);//返回13.0
		Math.ceil(12.7);//返回13.0
		Math.ceil(12.0);// 返回12.0
		System.out.println(Math.ceil(12.2));
		System.out.println(Math.ceil(12.7));
		System.out.println(Math.ceil(12.0));
		//floor()：一律舍去，仅保留整数。
		//如：
		System.out.println("--------------------------");

		Math.floor(12.2);// 返回12.0
		Math.floor(12.7);//返回12.0
		Math.floor(12.0);//返回12.0
		System.out.println(Math.floor(12.2));
		System.out.println(Math.floor(12.7));
		System.out.println(Math.floor(12.0));
		//round()：进行四舍五入
		//如：
		System.out.println("--------------------------");

		Math.round(12.2);// 返回12
		Math.round(12.7);//返回13
		Math.round(12.0);//返回12
		System.out.println(Math.round(12.2));
		System.out.println(Math.round(12.7));
		System.out.println(Math.round(12.0));
	}
	
	
}
