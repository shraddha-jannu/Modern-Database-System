import java.util.*;
import java.sql.*;
import java.net.*;  
import java.io.*;  
public class Client{
	public static void main(String args[]) throws Exception{
		//client server connectivity
		Socket s=new Socket("localhost",3333);  
		DataInputStream din=new DataInputStream(s.getInputStream());  
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
		  
		// receiving data from server
		String str2 = din.readUTF();
		System.out.print("\n"+str2);
		  
		dout.close();  
		s.close();  
	}
}
