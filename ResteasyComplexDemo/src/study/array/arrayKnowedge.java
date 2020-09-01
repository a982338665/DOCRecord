package study.array;

import java.util.Arrays;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

/**
 * 数组介绍：
 * 	--1.引用数据类型：定义数组仅是定义了一个指针，而未指向实际内容
 * 	--2.初始化数组后（int [] arr=new Int[]{1,2,3}）,在内存中所占空间才会被固定-数组长度不可变
 * 	--3.此时，数组元素若被清空，空间依然存在且长度不变
 * 	--4.分类：
 * 		--1.静态初始化：int [] a={1,2,3}    --自己初始化值，系统分配长度
 * 		--2.动态初始化：int [] b=new int [5]--自己指定长度，系统分配初始化值
 * ---------------------------------
 * 二维数组：
 * 	--1.实际为一维数组，其各个元素又为一维数组，故称二维数组（数组的元素又为数组--多维数组）
 * @author lishengbo
 * @Time   2017年12月10日下午8:02:12
 *
 */
public class arrayKnowedge {

	public static void main(String[] args) {
		int[][] a=new int [3][];//a数组长度为3，每个元素仍为数组，但是可以自定义数组长度，如下
		System.out.println("初始化数组时就已经获得内存地址："+a.toString());
		//外部数组定义长度----
		a[0]=new int[2];
		a[1]=new int[3];
		a[2]=new int[1];
		//内部数组定义值-----
		a[0][0]=1;
		a[0][1]=2;
		a[1][0]=3;
		a[1][1]=4;
		a[1][2]=5;
		a[2][0]=6;
		System.out.println(a.toString());
		for (int[] is : a) {
			for (int i : is) {
				System.out.print(i);
			}
			System.err.println(is);
		}
		int [] s={1,3,5,6,2,6,5,6};
		Arrays.sort(s);//数组排序--升序，可重复
		System.out.println("sort:"+s.toString());
		for (int i : s) {
			System.err.print(i+"	");
		}
	}
}
