package staticServer;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class staticServer {

	private static File WEB_ROOT=new File("");
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;
		   int port = 800;
		   try {
		     serverSocket =  new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
		   }
		   catch (IOException e) {
		     e.printStackTrace();
		     System.exit(1);
		   }
		   
		  Socket socket = serverSocket.accept();
		  InputStream input = socket.getInputStream();
		  OutputStream output = socket.getOutputStream();
		  
		  Request request = new Request(input);
		  request.parse();
		   
		  Response response = new Response(output);
		  response.setRequest(request);
		  response.sendStaticResource();
		   
		  socket.close();
	}
	public static File getWEB_ROOT() {
		return WEB_ROOT;
	}
	public static void setWEB_ROOT(File wEB_ROOT) {
		WEB_ROOT = wEB_ROOT;
	}
}
