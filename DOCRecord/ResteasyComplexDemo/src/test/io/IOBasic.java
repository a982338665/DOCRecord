package test.io;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * io流分类：
 * 	--1.输入输出角度：
 * 		--1.输入流
 * 		--2.输出流
 * 	--2.数据角度：
 * 		--1.字符流：文本，能读懂的，如文章，Java文件
 * 		--2.字节流：二进制数据，文本打开读不懂，如图片，mp3
 * @author lishengbo
 * @Time   2017年12月10日下午11:03:53
 *
 */
public class IOBasic {

	/**
	 * FIle类：
	 * 1.java.io包下的，继承Object，实现Serializable和Comparable<File>接口
	 */
	private static String file;
	
	public static void main(String[] args) throws IOException {
		//文件对象的创建--位置指定
		File file=new File("C:\\Users\\ASUS'\\Desktop\\iotest\\one.txt");
		File file2=new File("C:/Users/ASUS'/Desktop/iotest/one.txt");
		System.out.println("-----------------------------------------");
		//第一个参数文件路径，第二个文件名称
		File file3=new File("C:/Users/ASUS'/Desktop/iotest/","one.txt");
		System.out.println("-----------------------------------------");
		//java中文件和文件夹都抽象为File类，故可以先创建一个文件夹的对象
		File fileDir=new File("C:/Users/ASUS'/Desktop/iotest/");
		File file4=new File(fileDir,"one.txt");
		System.out.println("-----------------------------------------");
		System.err.println("=================创建文件==========================");
		//创建真实文件--绝对路径 TODO /**创建文件时，路径文件夹必须存在*/
		File file5=new File("C:/Users/ASUS'/Desktop/iotest/one.txt");
		//此处抛出流异常--加入两个人对同一个文件进行操作就会报异常
		//此创建方法，若该文件已存在，则创建失败，文件不存在时，才会创建是否成功
		boolean createNewFile = file5.createNewFile();
		System.out.println("文件是否创建成功："+createNewFile);
		System.out.println("--------------------------");
		//创建文件--相对路径:不指定路径时就创建在当前工程目录下
		///ResteasyComplexDemo/one.txt
		File file6=new File("one.txt");
		System.out.println(file6);
		boolean createNewFileA = file6.createNewFile();
		System.out.println("文件是否创建成功："+createNewFileA);
		System.out.println("--------------------------");
		//根据相对路径可以将文件创建在该项目src目录下
		File file7=new File("src/one.txt");
		boolean createNewFileB = file7.createNewFile();
		System.out.println("文件是否创建成功："+createNewFileB);
		System.err.println("===================创建文件夹========================");
		//创建文件夹：单级目录 ，父目录必须存在 TODO
		File filedir=new File("创建单级目录");
		boolean mkdir = filedir.mkdir();
		System.out.println("文件夹是否创建成功："+mkdir);
		System.out.println("--------------------------");
		//创建多级目录，---加s
		File filedir2=new File("创建多级目录/测试");
		boolean mkdir2 = filedir2.mkdirs();
		System.out.println("文件夹是否创建成功："+mkdir2);
		System.err.println("====================删除文件=======================");
		//文件的删除--若果有人在使用就会删除失败/指定的该文件不存在，均会返回失败
		boolean delete = file6.delete();
		System.out.println("文件删除是否成功："+delete);
		System.err.println("====================删除文件夹=======================");
		//文件夹中若有文件，则不能删除该文件夹，所以要先删除文件
		//程序删除的文件不会进入回收站，无法找回
		File filedir22=new File("c");
		boolean mkdir22 = filedir22.mkdir();
		System.out.println("文件夹是否创建成功："+mkdir22);
		boolean delete2 = filedir22.delete();
		System.out.println("文件删除是否成功："+delete2);
		System.err.println("====================文件重命名=======================");
		File file123=new File("a.txt");
		file123.createNewFile();
		File rename=new File("b.txt");
		System.out.println("a.txt重命名为b.txt是否成功："+file123.renameTo(rename));
		System.err.println("====================判断+++==========================");
		//是否文件，是否目录，是否存在,是否可读，是否可写，是否隐藏，是否绝对路径名等
		File file24=new File("C:/Users/ASUS'/Desktop/iotest/one.txt");
		if(!file24.exists()){
			file24.createNewFile();
		}
		System.out.println("是否存在："+file24.exists());
		System.out.println("是否为文件："+file24.isFile());
		System.out.println("是否为目录："+file24.isDirectory());
		System.out.println("是否为绝对路径："+file24.isAbsolute());
		System.out.println("是否为可读："+file24.canRead());
		System.out.println("是否为可写："+file24.canWrite());
		System.out.println("是否为隐藏："+file24.isHidden());
		System.out.println("是否为可执行："+file24.canExecute());
		System.err.println("====================文件的获取功能=========================");
		//获取文件绝对路径
		File file9=new File("src/one.txt");
		String absolutePath = file9.getAbsolutePath();
		System.out.println("文件的绝对路径："+absolutePath);
		String path = file9.getPath();
		System.out.println("文件的相对路径："+path);
		System.out.println("文件的名称："+file9.getName());
		//1kb=1024b,1b=1byte,1m=1024kb
		System.out.println("文件的大小："+file9.length());//字节为单位 
		//可换算为具体时间
		System.out.println("文件的最后修改时间："+file9.lastModified());//毫秒为单位
		long lasttime=file9.lastModified();
		Date date=new Date(lasttime);
		SimpleDateFormat sdf=new SimpleDateFormat();
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dd=sdf.format(date);
		System.out.println("文件的最后修改时间："+dd);//毫秒为单位
		System.out.println("文件的最后修改时间："+sdf2.format(date));//毫秒为单位

	}
}
