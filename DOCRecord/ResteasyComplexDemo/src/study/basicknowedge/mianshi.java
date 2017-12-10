package study.basicknowedge;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import org.junit.Test;

/**
 * 面试题--及基础知识集合
 * @author lishengbo
 * @Time   2017年12月10日上午11:18:37
 *
 */
public class mianshi {

	/**
	 * JDK--开发环境—java程序编译器（javac命令）
	 * Jre--运行环境-核心API及JVM
	 * java运行机制：
	 * 源文件--jdk编译器（.class文件）--不同平台的JVM--针对不同平台解释成特定机器码
	 * --每个平台都有不同的JVM，提供相同的接口给平台
	 * 编译型语言：每到一个平台都需要使用其自身的编译器重新编译--效率高可移植性低，跨平台难
	 * 解释型语言：每次执行都要重新编译--效率低，不能脱离解释器，跨平台容易
	 * 
	 */
	public  static String JVM;
	/**
	 * JDK安装及环境配置：（bin目录里的javac和java命令均是使用java语言编写的）
	 * java_home:(jdk安装路径)：D:/java/JDK1.8
	 * path:%java_home%/bin
	 * classPath:%java_home%/lib/tools.jar(实际是tools.jar/suntools/javac下的Main类)
	 */
	public  static String JDKInstall;
	/**
	 * 注释：
	 * 单行：//
	 * 多行：
	 * 文档：生成帮助文档时的注释--类，方法，全局变量，成员变量
	 * 
	 */
	public  static String commentaries;
	/**
	 * 基本数据类型：
	 * byte,short,int,long--整数
	 * char    			  --字符
	 * float,double		  --浮点
	 * boolean			  --布尔
	 * 
	 */
	public  static String dataType;
	/**
	 * 包装类的作用：
	 * string转int--》Integer.parseInt();
	 */
	public  static String IntegerParse;
	
	/**
	 * 字符串常量池--面试
	 * String不可变，所以可被共享
	 * @Time 2017年12月10日上午11:46:58
	 *
	 */
	@Test
	public void sdsd(){
		/*常量池(constant pool)指的是在编译期被确定，并被保存在已编译的.class文件中的一些数据。
		 *它包括了关于类、方法、接口等中的常量，也包括字符串常量。 */
		String s="123";
		String s2="1243";
		String s3="1243";
		String s4="12"+"43";
		/*用new String() 创建的字符串不是常量，不能在编译期就确定，运行时产生，所以new String()
		 *创建的字符串不放入常量池中，它们有自己的地址空间。 */
		String s5="12"+new String("43");
		System.out.println("s2的值赋值给s："+(s=s2));
		System.out.println("此时s的值为："+s+"  s2的值为"+s2);
		System.out.println(s==s2);
		System.out.println("-----------------");
		System.out.println(s2==s3);
		System.out.println(s4==s3);
		System.out.println(s4==s5);
	}
	/**
	 * Math测试
	 * @Time 2017年12月10日下午12:07:13
	 *
	 */
	@Test
	public void sdsds(){
		double sqrt = Math.sqrt(250);//250的平方根
		System.out.println(sqrt);
		double pow = Math.pow(3, 2);//3的2次方
		System.out.println(pow);
		double random = Math.random();//大于0小于1的浮点数
		System.out.println(random);
		Integer random2 =(int) (Math.random()*10+1);//1-10
		System.out.println(random2);
		System.out.println(new Random().nextInt(10)+1);//1-10

	}
	/**
	 * 逻辑运算符：&&和&的区别--||与|的区别：
	 * &对每个条件都要判断
	 * &&若前一个条件为false，则后一个条件不在进行判断
	 * 短路或者不短路
	 * @Time 2017年12月10日下午12:07:13
	 *
	 */
	@Test
	public void sdsds2(){
		int a=5;
		int b=10;
		if(a==6&&b++>9){//短路
			System.out.println("&&:a="+a+";b="+b);
		}
		if(a==5&b++>9){//不短路
			System.out.println("&:a="+a+";b="+b);
		}
	}
	/**
	 *三目运算符：求三数字最大值
	 */
	@Test
	public void sdsds3(){
		String s=5>3?"dayu":"xiaoyu";
		System.out.println(s);
		int a,b,c;
		a=3;
		b=9;
		c=7;
		int max=a>b&&a>c?a:b>a&&b>c?b:c;
		System.err.println(max);
	}
	/**
	 *流程控制-之switchCase
	 */
	@Test
	public void sdsds4(){
		System.out.println("switch支持的類型有byte，short，int，char，Strng，枚举");
		System.out.println("字符类型示例-------------------");
		char c='A';//字符类型为单引号
		switch (c) {
		case 'B':
			System.out.println("B");
			break;
		case 'A':
			System.out.println("A");
			break;
		case 'C':
			System.out.println("C");
			break;
		default:
			break;
		}
		System.out.println("字符串类型示例-----------------------");
		String d="C";//字符串类型为双引号
		switch (d) {
		case "A":
			System.out.println("B");
			break;//break必须写，如果没有，则匹配到A的时候会继续执行，但是不匹配，因此匹配之后的全部打印
		case "B":
			System.out.println("A");
			break;
		case "C":
			System.out.println("C");
//			break;
		default:
			System.out.println("default");
			break;
		}
	}
	/**
	 *流程控制-之for循环
	 * @throws InterruptedException 
	 */
	@Test
	public void sdsds41() throws InterruptedException{
		System.out.println("死循环测试开始---------------");
		int count=0;
		for (;;) {//
			if(count==5){
				break;
			}
			Thread.sleep(1000);
			System.out.println("死循环次数："+count);
			count++;
		}
		System.out.println("---------------");
		for (;count< 10;) {
			count++;
			System.out.println("条件语句："+count);
		}
		System.out.println("正常for:-----------------");
		for (int i = 0,j=1,h=2//初始化条件--可为多个
			; i<10&&j<11;//执行循环体的循环条件
				i++,j++) //循环的迭代语句--最后执行
		{
			System.out.println("i+"+i+"|j+"+j);
		}
	}
	/**
	 *流程控制-之while循环,dowhile循环：
	 *while先判断条件后执行，dowhile先执行后判断条件（至少执行一次）
	 * @throws InterruptedException 
	 */
	@Test
	public void sdsds421() {
		int count=0;
		while(count<10){//条件为真时执行循环体
			System.out.println("count:"+count);
			count++;//迭代语句
		}
		System.out.println("---------");
		do {
			System.out.println("先执行一次，在判断条件---");
			count--;
		} while (count<0);
		System.out.println("循环结束===");
	}
	/**
	 * 99乘法表
	 */
	@Test
	public void sdsds42() {
		for (int i = 1; i <=9; i++) {//控制行数
			for (int j = 1; j <=i; j++) {//控制列数
				System.out.print(i+"*"+j+"="+(i*j)+"\t");
			}
			System.out.println("	");
		}
		for (int i = 1; i <=5; i++) {//控制行数
			for (int j = 10;j>=0; j--) {//控制列数
				if(j>i){
					System.out.print("");
				}else{
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
	/**
	 * break；return；continue；outer的使用方法：
	 * outer break用法等同于outer continue
	 */
	@Test
	public void sdsds4212() {
		System.err.println("跳出当前循环-----------------");
		for (int i = 0; i <5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.println("i="+i);
				if(j==2){
					System.out.println("i="+i+"|"+"j="+j);
					/**跳出当前循环体*/
					break;
				}
			}
		}
		System.err.println("跳出指定外部循环-----------------");
		outer:
		for (int i = 0; i <5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.println("i="+i);
				if(j==2){
					System.out.println("i="+i+"|"+"j="+j);
					break outer;
				}
			}
		}
		System.err.println("continue:不跳出循坏，但是忽略本次循环剩下的语句---");
		for (int i = 0; i <3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.println("i="+i);
				if(j==2){
					System.out.println("i="+i+"|"+"j="+j);
					continue;
				}
				System.out.println("continue时忽略不执行");
			}
		}
		String string = "return:表示结束此方法------------";
		System.err.println(string);
		for (int i = 0; i <5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.println("i="+i);
				if(j==2){
					System.out.println("i="+i+"|"+"j="+j);
					return;
				}
			}
		}
		System.err.println("方法已结束，此处不会执行-----");
	}
	/**
	 * 按字节截取字符串：汉字的unicode编码为负数
	 * String--按字符截取，字符支持汉字，不会截取出半个字
	 * 按字节----可能会有半个字（此例子，若有半个字，省去）
	 * @throws UnsupportedEncodingException 
	 * @Time 2017年12月10日下午8:28:49
	 *
	 */
	@Test
	public void dsdfsf() throws UnsupportedEncodingException{
		String zijie="我爱abc和你";
		splitString(zijie,8);
		byte[] bytes = zijie.getBytes("utf-8");
//		System.out.println(bytes.length);
		int count=0;
		int bytecount=8;
		for (int i = 0; i < bytecount; i++) {
			if(bytes[i]<0){
				count++;
			}
		}
		String s=null;
		//如果count成对出现说明，没有截取到半个汉字----
		if(count%2==0){
			 s=new String(bytes, 0,bytecount);
		}else{
			 s=new String(bytes, 0, bytecount-1);
		}
		System.out.println(s);
	}
	
	public static void splitString(String str ,int len){  
        if(null == str){  
            System.out.println("The string is null");  
            return;  
        }  
        int byteNum = 0 ;  //用来计算字符串中汉字的个数
        byte[] bt = str.getBytes();  
        byteNum = bt.length;  
        if(len > byteNum){  
            len = byteNum;  
        }  
      //如果count成对出现说明，没有截取到半个汉字----
        if(bt[len]<0){  
            str = new String(bt,0,--len);  
            System.out.println(str);  
        }  
        else{  
            str = new String(bt,0,len);  
            System.out.println(str);  
        }  
    }  
}
