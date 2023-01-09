package MDS;
import java.util.*;
import java.sql.*;
public class Assign1 {
    //customer table
    static void customerTable(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank","root","root");   
            System.out.println("Connection established");  
            
            Statement stmt=con.createStatement(); 
            Scanner sc = new Scanner(System.in);
            

            while(true){
                System.out.println("1. Insert \t2. Delete \t3. Update \t4. Display \t5. Exit");
                System.out.print("Enter operation to be perform :");
                int op = sc.nextInt();
                switch(op){
                    case 1 : System.out.println("Enter customer ID, name, address, branch ID and contact no. :");
                             String id = sc.next();
                             String name = sc.next();
                             String add = sc.next();
                             String branch_id = sc.next();
                             String contact = sc.next();
    
                             //storing values in table
                             String sql = "insert into Customer"+"(C_id, C_name, C_addr, C_branch_id, C_contact)"+
                                            " values(?, ?, ?, ?, ?)";
                             
                             PreparedStatement pstmt = con.prepareStatement(sql);
                             pstmt.setString(1, id);
                             pstmt.setString(2, name);
                             pstmt.setString(3, add);
                             pstmt.setString(4, branch_id);
                             pstmt.setString(5, contact);
                             pstmt.executeUpdate();
                             
                             System.out.println("\nRecord inserted successfully..!!");
                            break;
    
                    case 2 : System.out.println("Enter customer id to delete :");
                             String record = sc.next();
    
                             String sqlDel = "delete from Customer where C_id=?";
                             pstmt = con.prepareStatement(sqlDel);
                             pstmt.setString(1, record);
                             pstmt.executeUpdate();
                             System.out.println("Record deleted.!!");
                             break;
                            
                    case 3 : System.out.print("Enter ID of record for updation :");
                             String updateID = sc.next();
                             
                             System.out.print("Enter new name for customer :");
                             String updateName = sc.next();
                             String sqlUpdate = "update Customer set C_name=? where C_id = ?";
                             pstmt = con.prepareStatement(sqlUpdate);
                             pstmt.setString(1, updateName);
                             pstmt.setString(2, updateID);
                             
                             pstmt.executeUpdate();
                             System.out.println("Record updated successfully!!");
                             break;
    
                    case 4 : ResultSet rs=stmt.executeQuery("select * from Customer"); 
                            System.out.println("\n_____________________________________________________________________\n\nID\t Name\t\t Address\t Branch ID\t Contact No."); 
                            System.out.println("______________________________________________________________________\n");
                            while(rs.next())  
                            System.out.println(rs.getString(1)+
                            "\t"+rs.getString(2)+
                            "\t\t"+rs.getString(3)+
                            "\t\t  "+rs.getString(4)+
                            "\t\t"+rs.getString(5));
    
                            System.out.println("\n");
                            break;
                    case 5 : System.exit(1);
                }   
            }    
        } 
        
        catch (Exception e) {
            System.out.println(e);
        }    
    }

    //branch table
    static void branchTable(){
        try {
                Class.forName("com.mysql.cj.jdbc.Driver");  
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank","root","root");   
                System.out.println("Connection established");  
                
                Statement stmt=con.createStatement(); 
                Scanner sc = new Scanner(System.in);
                
    
                while(true){
                    System.out.println("1. Insert \t2. Delete \t3. Update \t4. Display \t5. Exit");
                    System.out.print("Enter operation to be perform :");
                    int op = sc.nextInt();
                    switch(op){
                        case 1 : System.out.println("Enter Branch ID, name, address :");
                                 String bid = sc.next();
                                 String bname = sc.next();
                                 String badd = sc.next();
                                 
                                 //storing values in table
                                 String sql = "insert into Branch"+"(B_id, B_name, B_addr)"+
                                                " values(?, ?, ?)";
                                 
                                 PreparedStatement pstmt = con.prepareStatement(sql);
                                 pstmt.setString(1, bid);
                                 pstmt.setString(2, bname);
                                 pstmt.setString(3, badd);
                                 pstmt.executeUpdate();
                                 
                                 System.out.println("\nRecord inserted successfully..!!");
                                 break;
        
                        case 2 : System.out.println("Enter branch id to delete :");
                                 String record = sc.next();
        
                                 String sqlDel = "delete from Branch where B_id=?";
                                 pstmt = con.prepareStatement(sqlDel);
                                 pstmt.setString(1, record);
                                 pstmt.executeUpdate();
                                 System.out.println("Record deleted.!!");
                                 break;
                                
                        case 3 : System.out.print("Enter ID of record for updation :");
                                 String updateID = sc.next();
                                 
                                 System.out.print("Enter new name for customer :");
                                 String updateName = sc.next();
                                 String sqlUpdate = "update Branch set B_name=? where B_id = ?";
                                 pstmt = con.prepareStatement(sqlUpdate);
                                 pstmt.setString(1, updateName);
                                 pstmt.setString(2, updateID);
                                 
                                 pstmt.executeUpdate();
                                 System.out.println("Record updated successfully!!");
                                 break;
        
                        case 4 : ResultSet rs=stmt.executeQuery("select * from Branch"); 
                                System.out.println("\n_____________________________________________________________________\n\nID\t Branch Name\t\t Address"); 
                                System.out.println("______________________________________________________________________\n");
                                while(rs.next())  
                                System.out.println(rs.getString(1)+
                                "\t\t"+rs.getString(2)+
                                "\t\t"+rs.getString(3));
        
                                System.out.println("\n");
                                break;
                        case 5 : System.exit(1);
                    }   
                }      
        } 
        
        catch (Exception e) {
            System.out.println(e);
        }
    }

    //account table
    static void accountTable(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank","root","root");   
                System.out.println("Connection established");  
                
                Statement stmt=con.createStatement(); 
                Scanner sc = new Scanner(System.in);
                
    
                while(true){
                    System.out.println("1. Insert \t2. Delete \t3. Update \t4. Display \t5. Exit");
                    System.out.print("Enter operation to be perform :");
                    int op = sc.nextInt();
                    switch(op){
                        case 1 : System.out.println("Enter account num,customer ID, branch ID, amount :");
                                 String num = sc.next();
                                 String cid = sc.next();
                                 String bid = sc.next();
                                 String amount = sc.next();
                                 
                                 //storing values in table
                                 String sql = "insert into Account"+"(Account_no, C_id, B_id,Amount)"+
                                                " values(?, ?, ?, ?)";
                                 
                                 PreparedStatement pstmt = con.prepareStatement(sql);
                                 pstmt.setString(1, num);
                                 pstmt.setString(2, cid);
                                 pstmt.setString(3, bid);
                                 pstmt.setString(4, amount);
                                 pstmt.executeUpdate();
                                 
                                 System.out.println("\nRecord inserted successfully..!!");
                                 break;
        
                        case 2 : System.out.println("Enter customer id to delete :");
                                 String record = sc.next();
        
                                 String sqlDel = "delete from Account where C_id=?";
                                 pstmt = con.prepareStatement(sqlDel);
                                 pstmt.setString(1, record);
                                 pstmt.executeUpdate();
                                 System.out.println("Record deleted.!!");
                                 break;
                                
                        case 3 : System.out.print("Enter customer ID of record for updation :");
                                 String updateID = sc.next();
                                 
                                 System.out.print("Enter amount for customer :");
                                 String updateName = sc.next();
                                 String sqlUpdate = "update Account set Amount=? where C_id = ?";
                                 pstmt = con.prepareStatement(sqlUpdate);
                                 pstmt.setString(1, updateName);
                                 pstmt.setString(2, updateID);
                                 
                                 pstmt.executeUpdate();
                                 System.out.println("Record updated successfully!!");
                                 break;
        
                        case 4 : ResultSet rs=stmt.executeQuery("select * from Account"); 
                                System.out.println("\n_____________________________________________________________________\n\nAcc no.\t Customer ID\t\t Branch ID\tAmount"); 
                                System.out.println("______________________________________________________________________\n");
                                while(rs.next())  
                                System.out.println(rs.getString(1)+
                                "\t\t"+rs.getString(2)+
                                "\t\t"+rs.getString(3)+
                                "\t"+rs.getString(4));
        
                                System.out.println("\n");
                                break;
                        case 5 : System.exit(1);
                    }   
                }      
        } 
        
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        System.out.println("\n\n1. Customer Table \n2. Branch table \n3. Account Table \n4. Exit\n\n");
        System.out.print("Enter Table number :");
        Scanner sc = new Scanner(System.in);
        int ch = sc.nextInt();

        switch(ch){
            case 1 : customerTable();
                     break;
            case 2 : branchTable();
                     break;
            case 3 : accountTable();;
                     break;
            case 4 : System.exit(1);
                     break;
            default : System.out.println("invalid choice");
        }
    }
}
