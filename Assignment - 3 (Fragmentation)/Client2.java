import java.io.*;  
import java.net.*;  
public class Client2 {	
	public static void main(String[] args) {  
		try{      
			Socket s=new Socket("localhost",3333);  
			DataInputStream din=new DataInputStream(s.getInputStream()); 
			  
			// receiving data from server
			String str = din.readUTF();
			String str1 = din.readUTF();
			System.out.print("\nHorizontal fragment2 is:\n"+str);   
			System.out.print("\nVertical fragment2 is:\n"+str1);   
			s.close();  
		}
		catch(Exception e){
			System.out.println(e);
		}  
	}  
}  