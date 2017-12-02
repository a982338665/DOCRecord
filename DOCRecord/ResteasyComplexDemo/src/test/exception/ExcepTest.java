package test.exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class ExcepTest {
	
	/*public static void main(String args[]){
	      try{
	         int a[] = new int[2];
	         System.out.println("Access element three :" + a[3]);
	      }catch(ArrayIndexOutOfBoundsException e){
	         System.out.println("Exception thrown  :" + e);
	      }catch(Exception e){
		         System.out.println("Exception thrown 2 :" + e);
		      }
	      System.out.println("Out of the block");
	   }*/
	@Test
	public void sdsa(){
		System.out.println("li");
	}
	
	@Test
	public void sd2sa(){
		try{
		    //待捕获代码
			int s=1%0;
		}catch(Exception e){
		    System.out.println("catch is begin");
		    return ;
		}finally{
		     System.out.println("finally is begin");
		}
	}
	
	
	@Test
	public void sd22sa(){
		try{
		    //待捕获代码
			int s=1%0;
		}catch(Exception e){
		    System.out.println("catch is begin");
		    return ;
		}finally{
		     System.out.println("finally is begin");
//		     return  2;//若有返回值，会取2，finally总执行
		}
	}
		/**
		 * 异常:
		 * finally不一定被执行，，例如 catch 块中有退出系统的语句 System.exit(-1); finally就不会被执行
		 *
		 */
		@Test
		public void sd223sa(){
			  
	        //检查异常1.打开文件
	        FileReader fr=null;
	        try {
	            fr=new FileReader("d:\\aa.text");
	            // 在出现异常的地方，下面的代码的就不执行
	            System.out.println("aaa");
	        } catch (Exception e) {
	            System.out.println("进入catch");
	            // 文档读取异常
	            //System.exit(-1);
	            System.out.println("message="+e.getLocalizedMessage()+"|||"+e.getMessage());  //没有报哪一行出错
	            e.printStackTrace();   // 打印出错异常还出现可以报出错先异常的行
	        }
	        // 这个语句块不管发生没有发生异常，都会执行
	        // 一般来说，把需要关闭的资源，文件，连接，内存等
	        finally
	        {
	            System.out.println("进入finally");
	            if(fr!=null);
	            {
	                try {
	                    fr.close();
	                } catch (Exception e) {
	                    // TODO: handle exception
	                    e.printStackTrace();
	                }
	            }
	        }
	        System.out.println("OK");
	    }
			
	
}