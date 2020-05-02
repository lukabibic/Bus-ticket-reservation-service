package busystem.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.TreeMap;
import java.beans.PropertyChangeListener;

public class Line {
    private Integer lineID;
    private City start;
    private City destination;

    //Map of all currently existing cities
    //cityID maps to a City object with given ID
    private static TreeMap<Integer, City> allCities;

    public static void setCityCollection(TreeMap<Integer, City> allCities) {
        Line.allCities = allCities;
    }

    private static Connection getDbConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost/busystem?user=busystem&password=busystem");
    }

    public Line(City start, City destination) throws IllegalArgumentException, SQLException {
        this.create(start, destination);
        //find ID of new line and set attributes
        Connection conn = Line.getDbConnection();
        PreparedStatement preparedStmt = conn.prepareStatement("SELECT id from line WHERE start_id = ? and destination_id = ?");
        preparedStmt.setInt(1, start.getID());
        preparedStmt.setInt(2, destination.getID());
        ResultSet lineID = preparedStmt.executeQuery();
        lineID.next();
        this.lineID = lineID.getInt("id");
        this.start = start;
        this.destination = destination;
    }

    private Line(int ID, City start, City destination) {
        //constructor used in getAll()
        this.lineID = ID;
        this.start = start;
        this.destination = destination;
    }

    private void create(City start, City destination) throws SQLException {
        Connection conn = Line.getDbConnection();

        //check if cities exist
        PreparedStatement preparedStmt = conn.prepareStatement("SELECT * from city WHERE id = ?");
        preparedStmt.setInt(1, start.getID());
        ResultSet existing_city = preparedStmt.executeQuery();
        if (!existing_city.next()) {
            throw new IllegalArgumentException("ERROR: Start city does not exist");
        }
        preparedStmt = conn.prepareStatement("SELECT * from city WHERE id = ?");
        preparedStmt.setInt(1, destination.getID());
        existing_city = preparedStmt.executeQuery();
        if (!existing_city.next()) {
            throw new IllegalArgumentException("ERROR: Destination city does not exist");
        }

        String query = "INSERT into line (start_id, destination_id)" + " VALUES (?, ?)";
        preparedStmt = conn.prepareStatement(query);
        preparedStmt.setInt(1, start.getID());
        preparedStmt.setInt(2, destination.getID());
        preparedStmt.execute();

        System.out.println("Line created successfuly");
    }

    public static TreeMap<Integer, Line> getAll() throws SQLException {
        //return a collection of all Lines found in database
        //lineID maps to Line object with given ID
        TreeMap<Integer, Line> lines = new TreeMap<Integer, Line>();

        Connection conn = Line.getDbConnection();

        PreparedStatement preparedStmt = conn.prepareStatement("SELECT * from line");
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