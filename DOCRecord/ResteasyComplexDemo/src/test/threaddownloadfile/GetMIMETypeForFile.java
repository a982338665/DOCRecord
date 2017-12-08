package test.threaddownloadfile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.activation.MimetypesFileTypeMap;

public class GetMIMETypeForFile {
	  public static void main(String args[]) throws IOException {  
		    File f = new File("ggg/gumby.tml");  
		    System.out.println("Mime Type of " + f.getName() + " is--------- " +   
		                         new MimetypesFileTypeMap().getContentType(f));  
		    // expected output :   
		    // "Mime Type of gumby.gif is image/gif"  
		   System.out.println( new MimetypesFileTypeMap().getContentType("ggg/gumby.pdf"));;
		   
		   String type = null;  
		   Path path = Paths.get("ggg/gumby.pdf");  
		  System.out.println(Files.probeContentType(path)); ;
		    
		    
		    
		    
		  }  
}
