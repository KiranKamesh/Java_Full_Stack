package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCOperations {
	static Connection conn = null;
	static Statement stmt = null;
	static PreparedStatement ptsmt = null;
	static ResultSet rs = null;
	static Scanner sc = new Scanner(System.in);

	public JDBCOperations() {
		conn = DbConnection.getDbConnection();
	}

	public void createDataBase() {
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate("create database jdbcexample");
			System.out.println("database created successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void useDatabase() {
		try {
			stmt = conn.createStatement();
			stmt.execute("use jdbcexample");
			System.out.println("using jdbcexample database");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createTable() {
		try {
			stmt = conn.createStatement();
			String sql = "create table moviedetails" + "(movieid INTEGER, " + " moviename VARCHAR(255), "
					+ " movielanguage VARCHAR(255), " + " movietype varchar(255), " + " movierating INTEGER)";
			stmt.executeUpdate(sql);
			System.out.println("table moviedetails is created");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertMovieDetails() {
		try {

			String sql = "insert into moviedetails " + "values(?,?,?,?,?)";
			ptsmt = conn.prepareStatement(sql);
			System.out.println("Enter the movie details....");
			System.out.println("Enter the movie id");
			int mid = sc.nextInt();
			ptsmt.setInt(1, mid);
			System.out.println("Enter the movie name...");
			sc.nextLine();
			String mname = sc.nextLine();
			ptsmt.setString(2, mname);
			System.out.println("Enter the movie language");
			sc.nextLine();
			String mlang = sc.nextLine();
			ptsmt.setString(3, mlang);
			System.out.println("Enter the movie type");

			String mtype = sc.nextLine();
			ptsmt.setString(4, mtype);
			System.out.println("Enter the movie rating");
			int mrating = sc.nextInt();
			ptsmt.setInt(5, mrating);

			int i = ptsmt.executeUpdate();

			if (i != 0) {
				System.out.println("Inserted successfully");
			} else {
				System.out.println("Not inserted successfully");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void updateMovie() {
		try {

			String updateStmt = "update moviedetails set moviename = ? where movieid = ?";
			ptsmt = conn.prepareStatement(updateStmt);
			// read the values and set the values to the ?
			System.out.println("Enter the movie details to update");
			System.out.println("enter movie name to update...");
			String mname = sc.nextLine();
			ptsmt.setString(1, mname);
			System.out.println("enter supervisior id to update...");
			int mid = sc.nextInt();
			ptsmt.setInt(2, mid);
			int i = ptsmt.executeUpdate();
			if (i != 0) {
				System.out.println("updated successfully");
			} else {
				System.out.println("Not updated as supervisior with id = " + mid + " not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deleteMovie() {
		try {

			String deleteStmt = "delete from moviedetails where movieid = ?";
			ptsmt = conn.prepareStatement(deleteStmt);
			// read the values and set the values to the ?
			System.out.println("Enter the movie details to delete");
			System.out.println("enter movie id to update...");
			int mid = sc.nextInt();
			ptsmt.setInt(1, mid);
			int i = ptsmt.executeUpdate();
			if (i != 0) {
				System.out.println("deleted successfully");
			} else {
				System.out.println("Not deleted as supervisior with id = " + mid + " not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void selectAllMovies() {
		try {

			String selectStmt = "select * from moviedetails";
			ptsmt = conn.prepareStatement(selectStmt);
			ResultSet rs = ptsmt.executeQuery();
			System.out.println("movie details are .........");
			System.out.println(
					"=======================================================================================================================================================================================================");
			System.out.println("movieid" + "\t" + "moviename" + "\t" + "movielanguage" + "\t"
					+ "movietype"+"\t"+"movierating");
			System.out.println(
					"=======================================================================================================================================================================================================");

			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t\t" + rs.getString(2) + "\t\t" + rs.getString(3)
						+ "\t\t" + rs.getString(4)+ "\t\t"+ rs.getInt(5));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void jdbcMenu() {
		char ch ='y';
		while(ch == 'y') {
			System.out.println("Enter the choice of JDBC operation");
			System.out.println("insert: to insert the movie details");
			System.out.println("update: to update the movie details");
			System.out.println("delete: to delete the movie details");
			System.out.println("show: to show all the movie details");
			
			sc.nextLine();
			String choice = sc.nextLine();
			
			switch(choice) {
			case "insert":
				insertMovieDetails();
				break;
			case "update":
				updateMovie();
				break;
			case "delete":
				deleteMovie();
				break;
			case "show":
				selectAllMovies();
				break;
			default:
				System.out.println("No cases found");
				break;
			}
			System.out.println("do you want to continue");
			ch = sc.nextLine().charAt(0);
		}
		
		
	}

}
