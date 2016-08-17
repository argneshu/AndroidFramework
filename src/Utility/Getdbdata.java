package Utility;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Getdbdata {
	public static String dbDriver = "com.mysql.jdbc.Driver";
	public static String dbURL = "45.56.112.183:3306";
	public static String dbName = "accounts";
	public static String userName = "accounts";
	public static String password = "accounts";
	static java.sql.Connection con = null;
	static java.sql.Statement stmt = null;

	public static void connectDB() throws ClassNotFoundException, SQLException {
		try {
			Class.forName(dbDriver);

			con = DriverManager.getConnection("jdbc:mysql://" + dbURL + "/" + dbName, userName, password);

			stmt = con.createStatement();
		} catch (Exception e) {
			e.toString();
			throw (e);
		}
	}

	public static void connectDB(String DBUrl, String tName, String uName, String psword)
			throws ClassNotFoundException, SQLException {
		try {
			Class.forName(dbDriver);

			con = DriverManager.getConnection("jdbc:mysql://" + DBUrl + "/" + tName, uName, psword);

			stmt = con.createStatement();
			System.out.println("Connected to DB");
		} catch (Exception e) {
			System.out.println(e.toString());
			throw e;
		}
	}

	public static String executeQuery(String query) throws Exception {
		String outPut = "";
		try {
			java.sql.ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				outPut = outPut + " " + rs.getString(1);
			}
		} catch (Exception e) {
			//System.out.println(e);
			throw (e);
		}
		return outPut;
	}

	public static void updateQuery(String query) throws Exception {
		try {
			java.sql.PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.executeUpdate();
		} catch (Exception e) {
			//System.out.println(e);
			throw e;
		}
	}

	public static void closeDBConnection() throws ClassNotFoundException, SQLException {
		try {
			con.close();
		} catch (Exception e) {
			//System.out.println(e.toString());
		}
	}

}
