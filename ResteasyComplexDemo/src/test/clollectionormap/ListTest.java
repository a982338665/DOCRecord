package test.clollectionormap;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ListTest {
	    //主方法
	    public static void main(String [] args){
	    	ListTest dl = new ListTest();
//	        List<String> lis = new Vector<String>();
	        //dl.test1(lis);
	        dl.testMethod1();
	    }
	     
	    public void testMethod1(){
	        List lis = new ArrayList();
	        //也可以这样声明，但是一般不这样，声明的时候一般声明为list,然后根据实际来new ArrayList和Vector;
	        //ArrayList lis = new ArrayList();
	        lis.add("我");
	        lis.add("ok");
	        lis.add(null);
	        lis.add(null);//list可以加入null值,而且可以重复加元素
	        System.out.println(lis.toString());
	        System.out.println("加入null后的长度  = " + lis.size());
	        System.out.println("get个null值 =  " + lis.get(3));
	        }
}
