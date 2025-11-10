package StudenrCRUDOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PSExecution {
	static String url = "jdbc:postgresql://localhost:5432/student_app?user=postgres&password=Vishnu@2525";
	static String driver = "org.postgresql.Driver";

	// Fetch the data by ID
	public static void FetchByID(int sid) {
		String query = "select * from student where sid = ?";

		try (Connection connection = DriverManager.getConnection(url);
				PreparedStatement pStatement = connection.prepareStatement(query)) {
			
			
			pStatement.setInt(1, sid);
			
			ResultSet rSet = pStatement.executeQuery();
			

			System.out.println("==============Student Data==============");
			while (rSet.next()) {
				System.out.println("SID: " + rSet.getInt(1));
				System.out.println("Name: " + rSet.getString(2));
				System.out.println("Email: " + rSet.getString(3));
				System.out.println("Phone: " + rSet.getLong(4));
				System.out.println("Standard: " + rSet.getInt(5));
				System.out.println("Address: " + rSet.getString(6));
				System.out.println("========================================");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Fetch All the data
	public static void Fetch() {
		String query = "select * from student";

		try (Connection connection = DriverManager.getConnection(url);
				Statement statement = connection.createStatement();
				ResultSet rSet = statement.executeQuery(query)) {

			System.out.println("================Student Data==============");

			while (rSet.next()) {
				System.out.println("SID: " + rSet.getInt(1));
				System.out.println("Name: " + rSet.getString(2));
				System.out.println("Email: " + rSet.getString(3));
				System.out.println("Phone: " + rSet.getLong(4));
				System.out.println("Standard: " + rSet.getInt(5));
				System.out.println("Address: " + rSet.getString(6));
				System.out.println("==========================================");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Insert method

	public static void InsertPS(int sid, String name, String email, long phone, int std, String address) {

		String query = "insert into student values(?, ?, ?, ?, ?, ?)";

		try (Connection connection = DriverManager.getConnection(url);
				PreparedStatement pStatement = connection.prepareStatement(query)) {

			pStatement.setInt(1, sid);
			pStatement.setString(2, name);
			pStatement.setString(3, email);
			pStatement.setLong(4, phone);
			pStatement.setInt(5, std);
			pStatement.setString(6, address);

			int row = pStatement.executeUpdate();
			if (row > 0) {
				System.out.println(row + " rows Inserted");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Update method
	public static void UpdatePS(int sid, String column, Object newValue) {
		String query = "UPDATE student SET " + column + " = ? WHERE sid = ?";

		try (Connection connection = DriverManager.getConnection(url);
				PreparedStatement pStatement = connection.prepareStatement(query)) {

			pStatement.setObject(1, newValue);
			pStatement.setInt(2, sid);

			int row = pStatement.executeUpdate();
			if (row > 0) {
				System.out.println(row + " Row Updated");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Delete method
	public static void DeletePS(int sid) {
		String query = "delete from student where sid = ?";

		try (Connection connection = DriverManager.getConnection(url);
				PreparedStatement pStatement = connection.prepareStatement(query)) {

			pStatement.setInt(1, sid);

			int row = pStatement.executeUpdate();
			if (row > 0) {
				System.out.println(row + " Rows Deleted");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("Which Operation you want to perform \n 1. Insert Data(1) \n 2. Update Data(2) \n 3. Delete Data(3) \n 4. Fetch Data By SID(4) \n 5. Fetch All Data(5) \n 6. Exit Application(6)");
		Scanner s = new Scanner(System.in);
		System.out.println("Enter your choice: ");
		int choice = s.nextInt();
		s.nextLine();

		switch (choice) {
		case 1: {
			System.out.println("Insert the Data as follows");

			System.out.println("Enter the id: ");
			int sid = s.nextInt();
			s.nextLine();

			System.out.println("Enter the name: ");
			String name = s.nextLine();

			System.out.println("Enter the email: ");
			String email = s.nextLine();

			System.out.println("Enter the phone: ");
			long phone = s.nextLong();
			s.nextLine();

			System.out.println("Enter the Standard: ");
			int std = s.nextInt();
			s.nextLine();

			System.out.println("Enter the Address: ");
			String address = s.nextLine();

			InsertPS(sid, name, email, phone, std, address);
		}

			break;

		case 2: {
			System.out.println("Update the data as follows");
			System.out.println("Enter the Student Id to update: ");
			int sid = s.nextInt();
			s.nextLine();

			System.out.println(
					"Which data you have to update \n1. Name \n2. Email \n3. Phone \n4. Standard \n5. Address \n6. Exit");
			int UpdateChoice = s.nextInt();
			s.nextLine();
			switch (UpdateChoice) {
			case 1: {
				System.out.print("Enter new name: ");
				String name = s.nextLine();
				UpdatePS(sid, "name", name);

			}
				break;
			case 2: {
				System.out.print("Enter new email: ");
				String email = s.nextLine();
				UpdatePS(sid, "email", email);

			}
				break;
			case 3: {
				System.out.print("Enter new phone: ");
				long phone = s.nextLong();
				UpdatePS(sid, "phone", phone);
			}
				break;
			case 4: {
				System.out.print("Enter new standard (integer): ");
				int std = s.nextInt();
				s.nextLine();
				UpdatePS(sid, "std", std);
			}
				break;
			case 5: {
				System.out.print("Enter new address: ");
				String address = s.nextLine();
				UpdatePS(sid, "address", address);

			}
				break;
			case 6:
				System.out.println("Returning to main menu...");
				break;
			default:
				System.out.println("Invalid update choice!");
				break;
			}
		}
			break;

		case 3: {
			System.out.println("Delete the data as follows");
			System.out.println("Enter the Student Id to Delete: ");
			int sid = s.nextInt();
			DeletePS(sid);
		}

			break;

		case 4: {
			System.out.println("Enter the Student Id to Fetch the data: ");
			int sid = s.nextInt();
			FetchByID(sid);
		}
			break;

		case 5: {
			System.out.println("Fetching All the data...");
			Fetch();
		}
			break;

		case 6: {
			System.out.println("Thankyou!!");
		}
			break;

		default:
			System.out.println("Only type 1 to 4 choices");
			break;
		}
		s.close();

	}

}
