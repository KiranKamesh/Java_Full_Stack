package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	static Connection con;
	
	public static Connection getDbConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","root");
			System.out.println("Success");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
