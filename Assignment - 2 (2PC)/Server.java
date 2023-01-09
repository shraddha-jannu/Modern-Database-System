import java.io.*;
import java.net.*;
import java.sql.*;
public class Server{
	public static void main(String args[]) throws Exception{
		
		//creating db connection
		Class.forName("com.mysql.cj.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank","root","root");   
		Statement stmt=con.createStatement();
		/*ResultSet rs=stmt.executeQuery("select * from cust");  
		String str="C_id"+"\tAcc no"+"\tAmount"+"\n";
		while(rs.next())  {
			str += rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\n";
		}
		System.out.print(str);*/
		
		//clien1
		ServerSocket ss1=new ServerSocket(3333);  
		Socket s1=ss1.accept();  
		DataInputStream din1=new DataInputStream(s1.getInputStream());  
		DataOutputStream dout1=new DataOutputStream(s1.getOutputStream());  
		BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));  
		
		//client 2
		ServerSocket ss2=new ServerSocket(6666);  
		Socket s2=ss2.accept();  
		DataInputStream din2=new DataInputStream(s2.getInputStream());  
		DataOutputStream dout2=new DataOutputStream(s2.getOutputStream());  
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
		
		//client 3
		ServerSocket ss3=new ServerSocket(9999);  
		Socket s3=ss3.accept();  
		DataInputStream din3=new DataInputStream(s3.getInputStream());  
		DataOutputStream dout3=new DataOutputStream(s3.getOutputStream());  
		  
		String client1="",str2="",client2="",client3="";  
		while(!client1.equals("stop") && !client2.equals("stop")){  
			client1=din1.readUTF();  
			System.out.println("client1 says: "+client1); 
			
			client2 = din2.readUTF();
			System.out.println("client2 says: "+client2); 
			
			client3 = din3.readUTF();
			System.out.println("client3 says: "+client3); 
			
			if(client1.equalsIgnoreCase("readyt") && client2.equalsIgnoreCase("readyt") && client3.equalsIgnoreCase("readyt")){
				String sql ="UPDATE cust " + "SET amount = amount+500";  
				stmt.executeUpdate(sql);
				System.out.println("Table updated");
			}
			str2=br.readLine();  
			dout1.writeUTF(str2);  
			dout1.flush(); 
			
			dout2.writeUTF(str2);  
			dout2.flush();  

			dout3.writeUTF(str2);  
			dout3.flush();  
		}  
		din1.close();  
		s1.close();  
		ss1.close();
		
		din2.close();  
		s2.close();  
		ss2.close();
		
		din3.close();  
		s3.close();  
		ss3.close();
	}
}