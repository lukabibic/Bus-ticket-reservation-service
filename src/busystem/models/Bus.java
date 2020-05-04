package busystem.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.TreeMap;
import java.beans.PropertyChangeListener;

public class Bus {
    private Integer ID;
    private String model;
    private Integer seats;

    private static Connection getDbConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost/busystem?user=busystem&password=busystem");
    }

    public Bus(String model, Integer seats) throws IllegalArgumentException, SQLException {
        this.ID = this.create(model, seats);
        this.model = model;
        this.seats = seats;
    }

    private Bus(Integer ID, String model, Integer seats) {
        //this constructor is used only in getAll()
        this.ID = ID;
        this.model = model;
        this.seats = seats;
    }

    public Integer getID() {
        return this.ID;
    }

    public String getModel() {
        return this.model;
    }

    public Integer getSeats() {
        return this.seats;
    }

    public String toString() {
        return this.model + this.seats + " seats";
    }

    private int create(String model, Integer seats) throws IllegalArgumentException, SQLException {
        //create new bus in database and return generated ID
        Connection conn = Bus.getDbConnection();
        
        if (seats < 0) {
            throw new IllegalArgumentException("Error: number of seats must be non-negative");
        }

        String query = "INSERT into bus (model, seats)" + " VALUES (?, ?)";
        PreparedStatement preparedStmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStmt.setString(1, model);
        preparedStmt.setInt(2, seats);
        preparedStmt.execute();

        ResultSet generatedID = preparedStmt.getGeneratedKeys();
        generatedID.next();
        int busID = generatedID.getInt(1);
        System.out.println("Bus created sucessfully");
        return busID;
    }

    public static TreeMap<Integer, Bus> getAll() throws SQLException {
        //return a Map of all existing cities
        //cityID maps to object with given ID
        TreeMap<Integer, Bus> buses = new TreeMap<Integer, Bus>();
        Connection conn = Bus.getDbConnection();

        PreparedStatement preparedStmt = conn.prepareStatement("SELECT * from bus");
        ResultSet result = preparedStmt.executeQuery();
        while (result.next()) {
            int busID = result.getInt("id");
            Bus bus = new Bus(result.getInt("id"), result.getString("model"), result.getInt("seats"));
            buses.put(busID, bus);
        }
        return buses;
    }
}