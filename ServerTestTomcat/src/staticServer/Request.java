package staticServer;

import java.io.IOException;
import java.io.InputStream;

public class Request {

	private InputStream input;

	private static String uri="";
	public Request(InputStream input) {
		super();
		this.input = input;
	}
	 public void parse() {
		    // Read a set of characters from the socket
		    StringBuffer request = new StringBuffer(2048);
		    int i;
		    byte[] buffer = new byte[2048];
		    try {
		      i = input.read(buffer);
		    }
		    catch (IOException e) {
		      e.printStackTrace();
		      i = -1;
		    }
		    for (int j=0; j<i; j++) {
		      request.append((char) buffer[j]);
		    }
		    System.out.print(request.toString());
		  String  uri = parseUri(request.toString());
		  }
	 private String parseUri(String requestString) {
		  int index1, index2;
		  index1 = requestString.indexOf(' ');
		  if (index1 != -1) {
		    index2 = requestString.indexOf(' ', index1 + 1);
		    if (index2 > index1)
		      return requestString.substring(index1 + 1, index2);
		  }
		  return null;
		}
	public static String getUri() {
		return uri;
	}
	public static void setUri(String uri) {
		Request.uri = uri;
	}
}
