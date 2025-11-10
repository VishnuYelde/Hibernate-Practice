package StudenrCRUDOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {
	// Students CRUD operations
	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5432/student_app";
		String username = "postgres";
		String password = "Vishnu@2525";
		String driver = "org.postgresql.Driver";
		
		
		try {
			// step 1 : Load the driver
			Class.forName(driver);
			System.out.println("Driver loaded");
			
			// step 2 : Create a connection
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection created");
			
			// step 3 : Create a Statement
			Statement stm = con.createStatement();
			
			String query = "update student set name = 'abhi', email = 'abhi@gmail.com' where sid = 2"; 
			System.out.println("Statement created");
			
			// step 4 : Execute the query
			stm.execute(query);
			System.out.println("Query Executed");
			
			// step 5 : close connection
			con.close();
			System.out.println("Connection closed");
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
