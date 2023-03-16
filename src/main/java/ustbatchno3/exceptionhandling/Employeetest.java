package ustbatchno3.exceptionhandling;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import ustbatchno3.exceptionhandling.InvalidPhoneNumberException;

public class Employeetest {
	 static final String DB_URL = "jdbc:mysql://localhost/db";
	   static final String USER = "root";
	   static final String PASS = "pass@word1";

	    public static void main(String[] args) throws InvalidEmailException,InvalidEmpidException, ClassNotFoundException, SQLException{
	        Scanner scanner = new Scanner(System.in);
//	        Connection conn = null;
//	        PreparedStatement stmt = null;
	        
	        // Prompt the user to enter a name
	        System.out.print("Enter name: ");
	        String name = scanner.nextLine();
	        
	        // Prompt the user to enter a phone number
	        System.out.print("Enter phone number: ");
	        String phoneNumber = scanner.nextLine();
	        System.out.println("Enter email id");
	        String email = scanner.nextLine();
	        System.out.println("Enter employee id");
	        String empid = scanner.nextLine();
	        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	                Statement stmt = conn.createStatement();) {
//	        	Class.forName("com.mysql.jdbc.Driver");
//	            conn = DriverManager.getConnection(DB_URL, USER, PASS);
	            // Create a new User object with the input values
	            Employee user = new Employee(phoneNumber,email,empid,name,"Kottayam",200000);
//	            String sql = "CREATE TABLE Employee " +
//	                    "(id VARCHAR(25), " +
//	                    " name VARCHAR(25), " +
//	                    " phone VARCHAR(25), " + 
//	                    " gmail VARCHAR(25)) " ; 
////	                    " PRIMARY KEY ( id ))";
//	            stmt.executeUpdate(sql);
//	            System.out.println("Created table in given database..."); 
	            

	            String sql1 ="INSERT INTO Employee(id,name,phone,gmail) VALUES (?,?,?,?);";
	            PreparedStatement stmt1 = conn.prepareStatement(sql1); 
	              stmt1.setString(1, user.getEmp_id());
	             stmt1.setString(2,user.getEmp_name());
	             stmt1.setString(3,user.getPhone_no());
	             stmt1.setString(4,user.getEmail_id());
	            stmt1.executeUpdate();
	            System.out.println("Inserted values into table");

	         

	            
	            // Print the user object
	            System.out.println("User object created: " + user.toString());
	        } catch (InvalidPhoneNumberException e) {
	            // Handle the invalid phone number exception
	            System.out.println("Error: " + e.getMessage());
	        } catch( IllegalArgumentException e)
	        
	        {
	        	System.out.println("Error:enter valid name");
	        }
	        catch(InvalidEmailException e)
	        {
	        	System.out.println("Error:"+e.getMessage());

	        }catch(InvalidEmpidException e)
	        {
	        	System.out.println("Error"+e.getMessage());
	        }catch (SQLException se) {
	            se.printStackTrace();
	        } catch (Exception e) {
	            e.printStackTrace();}

	        
	    }
}
	



