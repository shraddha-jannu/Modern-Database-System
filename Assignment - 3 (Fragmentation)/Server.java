import java.io.*;
import java.net.*;
import java.sql.*;
public class Server{
	public static void main(String args[]){
		try{  
			//creating db connection
			Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/College","root","root");   
			Statement stmt=con.createStatement(); 
			
			//client 1
			//horizontal frag1
			ResultSet hf1=stmt.executeQuery("select * from StudInfo LIMIT 5");  
			String horiFrag1="ID"+"\tName"+"\tDept"+"\tClass"+"\tRollno"+"\tGender"+"\tContact"+"\t\tAddress"+"\tEmail"+"\n";
			while(hf1.next())  {
				horiFrag1 += hf1.getString(1)+"\t"+hf1.getString(2)+"\t"+hf1.getString(3)+
				"\t"+hf1.getString(4)+"\t"+hf1.getString(5)+"\t"+hf1.getString(6)+"\t"+hf1.getString(7)+
				"\t"+hf1.getString(8)+"\t"+hf1.getString(9)+"\n";
			}
			
			//vertical frag1
			ResultSet vf1=stmt.executeQuery("select id,name,dept,class,rollno,gender from StudInfo");  
			String verFrag1 = "ID\tName\tDept\tClass\tRollno\tGender\n";
			while(vf1.next()){
				verFrag1 += vf1.getString(1)+"\t"+vf1.getString(2)+"\t"+vf1.getString(3)+
				"\t"+vf1.getString(4)+"\t"+vf1.getString(5)+"\t"+vf1.getString(6)+"\n";
			}
			
			//socket connection
			ServerSocket ss=new ServerSocket(6666);  
			Socket s=ss.accept();//establishes connection   
			
			//transfering hori and verti fragment1 data to client1			
			DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
			System.out.println("Sending horizontal and vertical fragment1 data to client1\n\n");
			dout.writeUTF(horiFrag1);  
			dout.writeUTF(verFrag1);  
			s.close();  
			ss.close();  
			
			//client 2
			ResultSet hf2=stmt.executeQuery("select * from StudInfo LIMIT 5,10");  
			String horiFrag2="ID"+"\tName"+"\tDept"+"\tClass"+"\tRollno"+"\tGender"+"\tContact"+"\t\tAddress"+"\tEmail"+"\n";
			while(hf2.next())  {
				horiFrag2 += hf2.getString(1)+"\t"+hf2.getString(2)+"\t"+hf2.getString(3)+
				"\t"+hf2.getString(4)+"\t"+hf2.getString(5)+"\t"+hf2.getString(6)+
				"\t"+hf2.getString(7)+"\t"+hf2.getString(8)+"\t"+hf2.getString(9)+"\n";
			}
			
			//vertical frag2
			ResultSet vf2=stmt.executeQuery("select id,contact,addr,email from StudInfo");  
			String verFrag2 = "ID\tContact\tAddress\tEmail\n";
			while(vf2.next()){
				verFrag2 += vf2.getString(1)+"\t"+vf2.getString(2)+"\t"+vf2.getString(3)+
				"\t"+vf2.getString(4)+"\n";
			}

			ServerSocket ss1 = new ServerSocket(3333);
			Socket s1 = ss1.accept();
			
			//sending horizontal and vertical fragment2 to client2
			DataOutputStream dout1=new DataOutputStream(s1.getOutputStream());  
			System.out.println("Sending horizontal and vertical fragment2 data to client2");
			dout1.writeUTF(horiFrag2);
			dout1.writeUTF(verFrag2);			
			s1.close();  
			ss1.close();  			
		}
		catch(Exception e){
			System.out.println(e);
		}  
	}
}
