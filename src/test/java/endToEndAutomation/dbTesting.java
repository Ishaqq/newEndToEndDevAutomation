package endToEndAutomation;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.testng.annotations.Test;
import resources.base;

public class dbTesting extends base {
	
	@Test
	public void checkingDB() throws IOException, SQLException {
		String host="localhost";
		String port= "3306";
		Connection con=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/qadbt", "root", "");
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery("SELECT * FROM `employee-info`");
		while(rs.next()) {
		rs.getString("name");
		System.out.println(rs.getString("name"));
		System.out.println(rs.getString("id"));
		System.out.println(rs.getString("location"));
		}
	}
	
}
