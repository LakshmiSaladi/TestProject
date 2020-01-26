package test;
import java.sql.*;
public class DBConnection {
private static  Connection con;
private DBConnection() {}
static {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:xe:1521","system","manager");
	}catch(ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	
}
public static Connection getCon() {
	return con;
}
}
