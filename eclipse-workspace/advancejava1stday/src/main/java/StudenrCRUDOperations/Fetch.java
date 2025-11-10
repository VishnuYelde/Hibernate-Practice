package StudenrCRUDOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Fetch {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/student_app";
		String username = "postgres";
		String password = "Vishnu@2525";
		String driver = "org.postgresql.Driver";
		
		try {
			Class.forName(driver);
			System.out.println("Driver loaded");
		
		
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection created");
		
			Statement stm = con.createStatement();
			System.out.println("Statement created");
		
			String query = "select * from student";
//			String query = "select * from student where sid = 1";
		
			ResultSet rs = stm.executeQuery(query);
			
			System.out.println("=============Students Data===========");
			while(rs.next()) {
				
				// to reduce code use direct fetching
				System.out.println("Sid   : "+rs.getInt(1));
				System.out.println("Name  : "+rs.getString(2));
				System.out.println("Email : "+rs.getString(3));
				System.out.println("Phone : "+rs.getLong(4));
				
				System.out.println("===========================");
				
			}
			
			con.close();
			System.out.println("Connection closed");
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
