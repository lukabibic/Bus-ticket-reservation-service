package busystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnect {
	
	public static Connection getDbConnection() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/busystem?user=busystem&password=busystem&serverTimezone=CET");
        return conn;
    }
}
