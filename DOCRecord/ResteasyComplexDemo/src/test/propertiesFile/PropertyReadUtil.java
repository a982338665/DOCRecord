package test.propertiesFile;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class PropertyReadUtil {
	private static ResourceBundle rb;  
    private static BufferedInputStream inputStream;  
    static {   
        String proFilePath = System.getProperty("user.dir") +"\\config\\resourceBundle.properties";  
        System.out.println(proFilePath);
        try {  
            inputStream = new BufferedInputStream(new FileInputStream(proFilePath));  
            rb = new PropertyResourceBundle(inputStream);  
            inputStream.close();  
        } catch (FileNotFoundException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
    } 
public static void main(String[] args) {
	  String proFilePath = System.getProperty("user.dir") +"\\config\\resourceBundle.properties";  
      System.out.println(proFilePath);
}
    
    
}
