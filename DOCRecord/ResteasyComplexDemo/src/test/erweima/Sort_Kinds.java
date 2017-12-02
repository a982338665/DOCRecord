package test.erweima;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sort_Kinds {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws InterruptedException {
		System.out.println();   
		System.out.println(" =================直接插入排序:若其中有相同值，则全部保留");
		/** 插入排序之  直接插入排序************************************ **/
		//在要排序的一组数中，假设前面(n-1)[n>=2] 个数已经是排 好顺序的，现在要把第n 
		//个数插到前面的有序数中，使得这 n个数也是排好顺序的。如此反复循环，直到全部排好顺序。 
//		 int a []={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51,4,5};
		 int a []={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51,4,5};
		 int temp=0;   
		 for(int i=1;i<a.length;i++){   
			 int j=i-1; //获取该数值（首位）前一位数值的索引值0 对应数值为  49 
			 temp=a[i]; //创建临时值（次位）便与交换后赋值     ---------    38
			 for(;j>=0&&temp<a[j];j--){  //首位索引值>=0并且  首位值>次位值时： 
				 a[j+1]=a[j]; 			 //开始赋值次位值==首位值   即//将大于temp的值整体后移一个单位   
			 }   
			 a[j+1]=temp;				 //将首位值赋值为临时变量==次位值   
		 }
		 //顺序排列-------------------------------------
		 for(int i=0;i<a.length;i++){   
			   System.err.print(a[i]+" ");   
		  	}  
		  System.err.println(":-------------");   
		 
		 //倒序排列--------------------------------------
		 int [] ff= new int [a.length] ;
		 for (int i = 0; i < a.length; i++) {
			ff[i]=a[a.length-1-i];
		}
		 for(int i=0;i<a.length;i++){   
			   System.out.print(ff[i]+" ");   
		  	}  
		  System.err.println(":-------------");   
		/** 插入排序之  直接插入排序************************************ **/
		  System.out.println();   
		  System.out.println(" =================collection自带排序功能:若其中有相同值，则全部保留");
		/** collection自带排序功能 ************************************ **/
		 Integer b []={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};		
		 int c []={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
		 //若aslist里的值为包装类数组则可以直接转换为list进行排序
		 //若为基础数据类型数组则需要先将其转换为包装类数组在进行排序
		 Integer d []= new Integer[c.length];
		 for (int i = 0; i < c.length; i++) {
			d[i]=c[i];
		}
 		 List lsit= Arrays.asList(b);
 		 List lsit2= Arrays.asList(d);

// 		List lsit1= Arrays.asList( (int [] )lsit.get(0));
		 Collections.sort(lsit);
		 Collections.sort(lsit2);
		 for (Object object : lsit) {
				System.err.print(object.toString()+" ");
			}
		 Thread.sleep(50);
		 System.err.println(":-------------");   
		 for (Object object : lsit2) {
				System.out.print(object.toString()+" ");
			}
		/** collection自带排序功能 ************************************ **/
		 

	}
}
