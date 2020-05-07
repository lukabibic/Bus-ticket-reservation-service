package busystem.models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Pattern;

import busystem.DBconnect;

import java.util.regex.Matcher;

public class User {
    
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private Integer ID;
    private Boolean adminPrivileges;

    public User(String username, String firstName, String lastName, String password, String email) throws SQLException {
        this.create(username, firstName, lastName, password, email);
            //login if user was successfuly created
        this.login(username, password);
    }

    public User(String username, String password) throws SQLException {
        //TODO: handle failure (when login returns false)
        this.login(username, password);
    }

    public String getUsername() {
        return this.username;
    }

    public Integer getID() {
        return this.ID;
    }

    public String getName() {
        return this.firstName + this.lastName;
    }

    public String toString() {
        return this.getName();
    }

    public String getEmail() {
        return this.email;
    }

    public Boolean isAdmin() {
        return this.adminPrivileges;
    }

    public void create(String username, String firstName, String lastName, String password, String email) throws IllegalArgumentException, SQLException {

        
        //validate username
        String validUsernamePattern = "^[a-zA-Z0-9_.]{4,64}$";
        if (username.matches(validUsernamePattern) == false) {
            throw new IllegalArgumentException("Invalid username!");
        }
        //validate email
        Pattern pattern = Pattern.compile("^.+@.+\\..+$");
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches() == false) {
            throw new IllegalArgumentException("Invalid email!");
        }
       
        //check if username is taken
        PreparedStatement preparedStmt = DBconnect.conn.prepareStatement("SELECT * from user WHERE username = ?");
        preparedStmt.setString(1, username);
        ResultSet existing_user = preparedStmt.executeQuery();
        if (existing_user.next() != false) {
            throw new IllegalArgumentException("Username is already taken!");
        }
        //check if email is taken
        preparedStmt = DBconnect.conn.prepareStatement("SELECT * from user WHERE email = ?");
        preparedStmt.setString(1, email);
        ResultSet existing_email = preparedStmt.executeQuery();
        if (existing_email.next() != false) {
            throw new IllegalArgumentException("Email is already taken!");
        }

        String query = "INSERT into user (username, first_name, last_name, password, email)"
        + " VALUES (?, ?, ?, ?, ?)";
        preparedStmt = DBconnect.conn.prepareStatement(query);
        preparedStmt.setString(1, username);
        preparedStmt.setString(2, firstName);
        preparedStmt.setString(3, lastName);
        preparedStmt.setString(4, password); //TODO hash password before db insert
        preparedStmt.setString(5, email);

        // execute sql statement
        preparedStmt.execute();

        System.out.println("User created sucessfully");

    }

    public void login(String username, String password) throws IllegalArgumentException, SQLException {

        //TODO hash password before query
        String query = "SELECT * FROM user WHERE username = ? AND password = ?";
        PreparedStatement preparedStmt = DBconnect.conn.prepareStatement(query);
        preparedStmt.setString(1, username);
        preparedStmt.setString(2, password);
        // execute the preparedstatement
        ResultSet res = preparedStmt.executeQuery();
        
        if (res.next()) { //user exits and password was correct
            this.ID = res.getInt("id");
            this.username = res.getString("username");
            this.firstName = res.getString("first_name");
            this.lastName = res.getString("last_name");
            this.email = res.getString("email");
            this.adminPrivileges = res.getBoolean("is_admin");
        } else {
            throw new IllegalArgumentException("Wrong username or password!");
        }
 
        System.out.println("Login sucessfull");
    }
}
