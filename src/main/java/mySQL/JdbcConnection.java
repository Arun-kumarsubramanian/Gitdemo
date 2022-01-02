package mySQL;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class JdbcConnection {

	public static void main(String[] args) throws SQLException {
		String host = "localhost";
		String port ="3306";
		Connection con = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/qadbt", "root", "V!r@t123#");
		Statement s=con.createStatement();
		ResultSet rs = s.executeQuery("select * from Employeeinfo where location = 'chicago'");
		if(rs.next()){
			System.out.println(rs.getString("name"));
			System.out.println(rs.getInt("age"));
			}

	}

}
