package busystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnect {
	
	public static Connection conn;
	
	public static void openDbConnection() throws SQLException {
		conn = DriverManager.getConnection("jdbc:mysql://localhost/busystem?user=busystem&password=busystem&serverTimezone=CET");
    }
}
