package test.erweima;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
//使用org.apache.tools.zip这个就不会中文乱码 来自于ant.jar 
  
//使用java.util.zip原生ZipOutputStream与ZipEntry会中文乱码  
//import java.util.zip.ZipEntry;  
//import java.util.zip.ZipFile;  
   
public class TestUnzip   
{  
    static String zipPath = "C:/Users/cjh/Desktop/test.zip";//需要解压的压缩文件  
    static String outPath = "C:/Users/cjh/Desktop/";//解压完成后保存路径,记得"\\"结尾哈  
      
    public static void main(String args[]) throws Exception  
    {  
        ZipFile zipFile = new ZipFile(zipPath);//压缩文件的实列,并设置编码  
        //获取压缩文中的所以项  
        for(Enumeration<ZipEntry> enumeration = (Enumeration<ZipEntry>) zipFile.entries();enumeration.hasMoreElements();)  
        {  
            ZipEntry zipEntry = enumeration.nextElement();//获取元素  
            System.out.println("解压到的条目 ： " + zipEntry.getName());
            //排除空文件夹  
            if(!zipEntry.getName().endsWith(File.separator))  
            {  
//                System.out.println("正在解压文件:"+zipEntry.getName());//打印输出信息  
                OutputStream os = new FileOutputStream(outPath+zipEntry.getName());//创建解压后的文件  
                BufferedOutputStream bos = new BufferedOutputStream(os);//带缓的写出流  
                InputStream is = zipFile.getInputStream(zipEntry);//读取元素  
                BufferedInputStream bis = new BufferedInputStream(is);//读取流的缓存流  
                CheckedInputStream cos = new CheckedInputStream(bis, new CRC32());//检查读取流，采用CRC32算法，保证文件的一致性  
                byte [] b = new byte[1024];//字节数组，每次读取1024个字节  
                //循环读取压缩文件的值  
                while(cos.read(b)!=-1)  
                {  
                    bos.write(b);//写入到新文件  
                }  
                cos.close();  
                bis.close();  
                is.close();  
                bos.close();  
                os.close();  
            }  
            else  
            {  
                //如果为空文件夹，则创建该文件夹  
                new File(outPath+zipEntry.getName()).mkdirs();  
            }  
        }  
        System.out.println("解压完成");  
        zipFile.close();  
    }  
}  
