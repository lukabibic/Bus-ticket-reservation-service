package busystem.models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class User {
    
    private String username;
    private String firstName;
    private String lastName;
    private Integer ID;

    public User() {
    }

    private Connection getDbConnection() {

        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/busystem?user=busystem&password=busystem");
            return conn;
        }    // handle any errors
        catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return conn;
    }

    public boolean create(String username, String firstName, String lastName, String password, String email) {

        Connection conn = this.getDbConnection();
        
        //validate username
        String validUsernamePattern = "^[a-zA-Z0-9_.]{4,64}$";
        if (username.matches(validUsernamePattern) == false) {
            System.out.println("Invalid username");
            return false;
        }

        //validate email
        Pattern pattern = Pattern.compile("^.+@.+\\..+$");
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches() == false) {
            System.out.println("Invalid email");
            return false;
        }

        try {
            //check if username is taken
            PreparedStatement preparedStmt = conn.prepareStatement("SELECT * from user WHERE username = ?");
            preparedStmt.setString(1, username);
            ResultSet existing_user = preparedStmt.executeQuery();
            if (existing_user.next() != false) {
                System.out.println("ERROR: username is taken");
                return false;
            }

            //check if email is taken
            preparedStmt = conn.prepareStatement("SELECT * from user WHERE email = ?");
            preparedStmt.setString(1, email);
            ResultSet existing_email = preparedStmt.executeQuery();
            if (existing_email.next() != false) {
                System.out.println("ERROR: email is taken");
                return false;
            }

            String query = "INSERT into user (username, first_name, last_name, password, email)"
            + " VALUES (?, ?, ?, ?, ?)";
            preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, username);
            preparedStmt.setString(2, firstName);
            preparedStmt.setString(3, lastName);
            preparedStmt.setString(4, password); //TODO hash password before db insert
            preparedStmt.setString(5, email);

            // execute the preparedstatement
            preparedStmt.execute();

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        System.out.println("User created sucessfully");
        return true;
    }

    public boolean login(String username, String password) {

        Connection conn = this.getDbConnection();
        
        try {
            //TODO hash password before query
            String query = "SELECT * FROM user WHERE username = ? AND password = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, username);
            preparedStmt.setString(2, password);
            // execute the preparedstatement
            ResultSet res = preparedStmt.executeQuery();
            
            if (res.next()) { //user exits and password was correct
                this.ID = res.getInt("id");
                this.username = res.getString("username");
                this.firstName = res.getString("first_name");
                this.lastName = res.getString("last_name");
            } else {
                System.out.println("Login failed");
                return false;
            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        System.out.println("Login sucessfull");
        return true;
    }
}