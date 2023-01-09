import java.util.*;
import java.sql.*;
import java.net.*;  
import java.io.*;  
public class Server{
	public static void main(String args[]){
		try{
			//jdbc connectivity
			Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/College","root","root");   
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from Student");  
			String str="Roll no"+"\tName"+"\tAddress"+"\t\tMobile"+"\t\tDept id"+"\tCourse"+"\n";
			while(rs.next())  {
				str += rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+
				"\t\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\n";
			}
			//System.out.print(str);
			//System.out.println(rs.getString(1)+"  "+rs.getString(2));  
			
			//client server connectivity
			ServerSocket ss=new ServerSocket(3333);  
			System.out.println("Server Activated"); 
			Socket s=ss.accept();  
			 
			//transfering data to client
			DataInputStream din=new DataInputStream(s.getInputStream());  
			DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
			System.out.println("Sending data to client");
			dout.writeUTF(str);  
			din.close();  
			s.close();  
			ss.close();  
			
			con.close(); 
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
