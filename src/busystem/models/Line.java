package busystem.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.TreeMap;

import busystem.DBconnect;

import java.beans.PropertyChangeListener;

public class Line {
    private Integer ID;
    private City start;
    private City destination;

    //Map of all currently existing cities
    //cityID maps to a City object with given ID
    private static TreeMap<Integer, City> allCities;

    public static void setCityCollection(TreeMap<Integer, City> allCities) {
        Line.allCities = allCities;
    }

    public Line(City start, City destination) throws IllegalArgumentException, SQLException {
        
        this.ID = this.create(start, destination);
        this.start = start;
        this.destination = destination;
    }

    private Line(int ID, City start, City destination) {
        //constructor used in getAll()
        this.ID = ID;
        this.start = start;
        this.destination = destination;
    }

    public Integer getID() {
        return this.ID;
    }

    public String toString() {
        return this.start + "-" + this.destination;
    }

    //create line in database and return ID of new line
    private Integer create(City start, City destination) throws SQLException {


        //check if cities exist
        PreparedStatement preparedStmt = DBconnect.conn.prepareStatement("SELECT * from city WHERE id = ?");
        preparedStmt.setInt(1, start.getID());
        ResultSet existing_city = preparedStmt.executeQuery();
        if (!existing_city.next()) {
            throw new IllegalArgumentException("ERROR: Start city does not exist");
        }
        preparedStmt = DBconnect.conn.prepareStatement("SELECT * from city WHERE id = ?");
        preparedStmt.setInt(1, destination.getID());
        existing_city = preparedStmt.executeQuery();
        if (!existing_city.next()) {
            throw new IllegalArgumentException("ERROR: Destination city does not exist");
        }

        String query = "INSERT into line (start_id, destination_id)" + " VALUES (?, ?)";
        preparedStmt = DBconnect.conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStmt.setInt(1, start.getID());
        preparedStmt.setInt(2, destination.getID());
        preparedStmt.execute();

        ResultSet generatedID = preparedStmt.getGeneratedKeys();
        generatedID.next();
        int lineID = generatedID.getInt(1);
        System.out.println("Line created successfuly");
        return lineID;
    }

    public static TreeMap<Integer, Line> getAll() throws SQLException {
        //return a collection of all Lines found in database
        //lineID maps to Line object with given ID
        TreeMap<Integer, Line> lines = new TreeMap<Integer, Line>();

        PreparedStatement preparedStmt = DBconnect.conn.prepareStatement("SELECT * from line");
        ResultSet result = preparedStmt.executeQuery();
        while (result.next()) {
            int startCityID = result.getInt("start_id");
            int destinationCityID = result.getInt("destination_id");
            City start = allCities.get(startCityID);
            City destination = allCities.get(destinationCityID);
            Line line = new Line(result.getInt("id"), start, destination);
            lines.put(result.getInt("id"), line);
        }

        return lines;
    }
}