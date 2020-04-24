import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

import com.mysql.jdbc.Driver;

public class MySQL {
	
	final static String dbUser = "dbuser";
	final static String dbPasswd = "dbpassword";
	final static String dbHost = "192.168.1.123";

	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://"+dbHost+":3306/RocketEngines",dbUser,dbPasswd);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Engines where designer=\"SpaceX\"");
			System.out.println("Getting all rocket engines designed by SpaceX: ");
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}
			con.close();
		}
		catch(SQLException e) {
			System.out.println("This exception occurred: " + e);
		}
	}
}
