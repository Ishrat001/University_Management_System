package university_management_system;

import java.sql.*;	
	
public class DatabaseConnection {
		
		Connection c;
		Statement s;	
		
		DatabaseConnection(){
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				c = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitymanagementsystem","root","ishrat10#");
				s = c.createStatement();
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		


}
