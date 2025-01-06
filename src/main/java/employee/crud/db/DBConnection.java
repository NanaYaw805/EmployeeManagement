package employee.crud.db;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

//creating the JDBC connection class

public class DBConnection {
	public static final String jURL = "jdbc:mysql://localhost:3306/employee_db";
	public static final String jUser = "root";
	public static final String jPassword = "    ";
	
	
	public static Connection getConnected() {
		
		System.out.println("start connection");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connectionObject = (Connection) DriverManager.getConnection(jURL,jUser,jPassword);
			
			if(connectionObject != null) {
				System.out.println("connection is not null");
				return connectionObject;
			}
			else {
				System.out.println("Connection is null");
				return null;
			}
		}
		
		catch(Exception e) {
			System.out.println("There is a connection issue");
			e.printStackTrace();
			return null;
		}
		
		
		
	}
	
	public static Connection connection = getConnected();
	
	public static void main(String[] args) {
		System.out.println(DBConnection.connection);
	}
	

}
