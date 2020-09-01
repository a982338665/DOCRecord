package test.httpclient;

import java.net.*;
import java.io.*;
public class URLConnDemo
{
   public static void main(String [] args)
   {
      try
      {
         URL url = new URL("http://www.runoob.com");
         URLConnection urlConnection = url.openConnection();
         HttpURLConnection connection = null;
         /**
          * boolean result = object instanceof class
		  * 如果 object 是 class或者是它的子类的一个实例，则 instanceof 运算符返回 true。
		  * 如果 object 不是指定类的一个实例，或者 object 是 null，则返回 false。
          */
         if(urlConnection instanceof HttpURLConnection)
         {
            connection = (HttpURLConnection) urlConnection;
         }
         else
         {
            System.out.println("请输入 URL 地址");
            return;
         }
         BufferedReader in = new BufferedReader(
         new InputStreamReader(connection.getInputStream()));
         String urlString = "";
         String current;
         while((current = in.readLine()) != null)
         {
        	 current.getBytes("utf-8");
        	 System.out.println(new String(current.getBytes("GBK"),"utf-8"));
//            urlString += current;
         }
         System.out.println(urlString);
      }catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}