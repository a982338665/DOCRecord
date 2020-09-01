package test.mailtest;

import java.io.File;

public class html {

	public static String content(){
		String path=System.getProperty("user.dir")+File.separator+"src"
				+File.separator+"test"+File.separator+"mailtest"+File.separator+"html.txt";
//		String path=html.class.getClass().getResource("/").getPath() ;
		System.out.println(path);
		String readTxtFile = ReadFileUtil.readTxtFile2(path); 
		return readTxtFile;
		
	}
	public static void main(String[] args) {
		String path=System.getProperty("user.dir")+File.separator+"src"
				+File.separator+"test"+File.separator+"mailtest"+File.separator+"html.txt";
//		String path=html.class.getClass().getResource("/").getPath() ;
//		String path=html.class.getClass().getResource("/").getPath() ;
		System.out.println(path);
		String readTxtFile = ReadFileUtil.readTxtFile2(path); 
		System.out.println(readTxtFile);
	}
}
