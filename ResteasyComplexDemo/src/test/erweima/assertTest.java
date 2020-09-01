package test.erweima;

public class assertTest {

	public static void main(String[] args) {
		
		/*
		 //断言测试
		 boolean flag=-1>1;  
		 assert flag:"flag is false";  
		*/
		//==ceshi
		String s="1 2 3";
		String s2="1 2 "+new String("3");
		String s3="1 2 "+"3";
		System.out.println("先new后赋值给对象: "+(s==s2));//+"false"
		System.out.println("拿常量后赋值给对象:"+(s==s3));//+"true"

	
	}
}
