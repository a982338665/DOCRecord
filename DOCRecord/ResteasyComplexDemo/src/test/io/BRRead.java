package test.io;
//使用 BufferedReader 在控制台读取字符

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

public class BRRead {

	@Test
	/**
	 * 控制台读取：System.in
	 * @throws IOException
	 */
	public void vsdfs() throws IOException {
		char c;
		// 使用 System.in 创建 BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("输入字符, 按下 'q' 键退出。");
		// 读取字符
		do {
			c = (char) br.read();// 读一个字符
			/*
			 * 输入字符, 按下 'q' 键退出。 runoob----控制台输入内容 r---------字符读取内容 u n o o b
			 */
			System.err.println(br.readLine());// 读一行
			/*
			 * 输入字符, 按下 'q' 键退出。 runoob-----控制台输入内容 runoob-----行读取内容
			 */
			System.out.println(c);
		} while (c != 'q');
	}

	@Test
	/** 演示 System.out.write() */
	public void mfdfgd() {
		int b = 65;
		// b = 'A';
		System.out.println(b);
		System.out.write(b);// 会把数字转为字母
		System.out.write('\n');

	}

	@Test
	/** 字节数组输入流 :ByteArrayInputStream
	 * 字节数组输入流在内存中创建一个字节数组缓冲区，从输入流读取的数据保存在该字节数组缓冲区中。创建字节数组输入流对象
	 * */
	public void sfds() throws IOException {
		ByteArrayOutputStream bOutput = new ByteArrayOutputStream(12);

		while (bOutput.size() != 10) {
			// 获取用户输入值
			bOutput.write(System.in.read());
		}

		byte b[] = bOutput.toByteArray();
		System.out.println("Print the content");
		for (int x = 0; x < b.length; x++) {
			// 打印字符
			System.out.print((char) b[x] + "   ");
		}
		System.out.println("   ");
		int c;
		ByteArrayInputStream bInput = new ByteArrayInputStream(b);
		/*
		 * ByteArrayInputStream bArray = new ByteArrayInputStream(byte []a, int
		 * off, off表示第一个读取的字节 int len) len表示读取字节的长度
		 */
		System.out.println("Converting characters to Upper case ");
		for (int y = 0; y < 1; y++) {
			while ((c = bInput.read()) != -1) {
				System.out.println(Character.toUpperCase((char) c));
			}
			bInput.reset();
		}
	}

	@Test
	/** 字节数组输入流 :DataInputStream
	 * 数据输入流允许应用程序以与机器无关方式从底层输入流中读取基本 Java 数据类型
	 * 从文本文件test.txt中读取5行，并转换成大写字母，最后保存在另一个文件test1.txt
	 * */
	public void sfdasdas() throws IOException {
		DataInputStream d = new DataInputStream(new FileInputStream("C:\\Users\\cjh\\Desktop\\test.txt"));

		DataOutputStream out = new DataOutputStream(new FileOutputStream(
				"C:\\Users\\cjh\\Desktop\\test1.txt"));

		String count;
		while ((count = d.readLine()) != null) {
			String u = new String (count.toUpperCase().getBytes("ISO8859-1"),"utf-8");
			System.out.println(u);
			out.writeBytes(u + "  ,");
		}
		d.close();
		out.close();
	}

}