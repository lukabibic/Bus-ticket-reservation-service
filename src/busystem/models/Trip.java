package busystem.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.TreeMap;

import busystem.DBconnect;

import java.beans.PropertyChangeListener;

public class Trip {

    private Integer ID;
    private Line line; //defines start and destination city
    private Bus bus;
    private Time departureTime;
    private Time tripDuration;

    //Map of all currently existing lines
    //lineID maps to a Line object with given ID
    private static TreeMap<Integer, Line> allLines;
    
    //Map of all currently existing buses
    //busID maps to a Bus object with given ID
    private static TreeMap<Integer, Bus> allBuses;

    public static void setLineCollection(TreeMap<Integer, Line> allLines) {
        Trip.allLines = allLines;
    }

    public static void setBusCollection(TreeMap<Integer, Bus> allBuses) {
        Trip.allBuses = allBuses;
    }

    public Trip(Bus bus, Line line, Time departureTime, Time tripDuration) throws IllegalArgumentException, SQLException {
        
        this.ID = this.create(bus, line, departureTime, tripDuration);
        this.line = line;
        this.bus = bus;
        this.departureTime = departureTime;
        this.tripDuration = tripDuration;
    }

    private Trip(int ID, Bus bus, Line line, Time departureTime, Time tripDuration) {
        //constructor used in getAll()
        this.ID = ID;
        this.line = line;
        this.bus = bus;
        this.departureTime = departureTime;
        this.tripDuration = tripDuration;
    }

    public Integer getID() {
        return this.ID;
    }

    public Bus getBus() {
        return this.bus;
    }

    public String toString() {
        return line + "bus: " + bus + "\n" + "Departure: " + departureTime + " Trip duration: " + tripDuration;
    }

    public void deleteFromDB() throws SQLException {
        PreparedStatement preparedStmt = DBconnect.conn.prepareStatement("DELETE from trip WHERE id = ?");
        preparedStmt.setInt(1, this.ID);
        preparedStmt.execute();
        System.out.println("Trip deleted");
    }

    public void setLine(Line newLine) throws IllegalArgumentException, SQLException {
        //check if line exist
        PreparedStatement preparedStmt = DBconnect.conn.prepareStatement("SELECT * from line WHERE id = ?");
        preparedStmt.setInt(1, newLine.getID());
        ResultSet existingLine = preparedStmt.executeQuery();
        if (!existingLine.next()) {
            throw new IllegalArgumentException("ERROR: New line does not exist");
        }

        //update in db
        preparedStmt = DBconnect.conn.prepareStatement("UPDATE trip SET line_id = ? WHERE id = ?");
        preparedStmt.setInt(1, newLine.getID());
        preparedStmt.setInt(2, this.ID);
        preparedStmt.execute();
        
        //update local
        this.line = newLine;
        System.out.println("Trip line updated");
    }

    public void setBus(Bus newBus) throws IllegalArgumentException, SQLException {
        //check if bus exist
        PreparedStatement preparedStmt = DBconnect.conn.prepareStatement("SELECT * from bus WHERE id = ?");
        preparedStmt.setInt(1, newBus.getID());
        ResultSet existingBus = preparedStmt.executeQuery();
        if (!existingBus.next()) {
            throw new IllegalArgumentException("ERROR: New bus does not exist");
        }

        //update in db
        preparedStmt = DBconnect.conn.prepareStatement("UPDATE trip SET bus_id = ? WHERE id = ?");
        preparedStmt.setInt(1, newBus.getID());
        preparedStmt.setInt(2, this.ID);
        preparedStmt.execute();
        
        //update local
        this.bus = newBus;
        System.out.println("Trip bus updated");
    }

    public void setDepartureTime(Time newDepartureTime) throws IllegalArgumentException, SQLException {
        //update in db
        PreparedStatement preparedStmt = DBconnect.conn.prepareStatement("UPDATE trip SET departure_time = ? WHERE id = ?");
        preparedStmt.setTime(1, newDepartureTime);
        preparedStmt.setInt(2, this.ID);
        preparedStmt.execute();
        
        //update local
        this.departureTime = newDepartureTime;
        System.out.println("Trip departure time updated");
    }

    public void setTripDuration(Time newTripDuration) throws IllegalArgumentException, SQLException {
        //update in db
        PreparedStatement preparedStmt = DBconnect.conn.prepareStatement("UPDATE trip SET trip_duration = ? WHERE id = ?");
        preparedStmt.setTime(1, newTripDuration);
        preparedStmt.setInt(2, this.ID);
        preparedStmt.execute();
        
        //update local
        this.tripDuration = newTripDuration;
        System.out.println("Trip duration updated");
    }

    private Integer create(Bus bus, Line line, Time departureTime, Time tripDuration) throws IllegalArgumentException, SQLException {
        //create trip in database and return ID of generated 

        //TODO: check if bus and line exist, time format

        String query = "INSERT into trip (bus_id, line_id, departure_time, trip_duration)" + " VALUES (?, ?, ?, ?)";
        
        PreparedStatement preparedStmt = DBconnect.conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStmt.setInt(1, bus.getID());
        preparedStmt.setInt(2, line.getID());
        preparedStmt.setTime(3, departureTime);
        preparedStmt.setTime(4, tripDuration);
        preparedStmt.execute();

        ResultSet generatedID = preparedStmt.getGeneratedKeys();
        generatedID.next();
        int tripID = generatedID.getInt(1);
        System.out.println("Trip created sucessfully");
        return tripID;
    }

    public static TreeMap<Integer, Trip> getAll() throws SQLException {
        //return a collection of all Trips found in database
        //tripID maps to Trip object with given ID
        TreeMap<Integer, Trip> trips = new TreeMap<Integer, Trip>();

        PreparedStatement preparedStmt = DBconnect.conn.prepareStatement("SELECT * from trip");
        ResultSet result = preparedStmt.executeQuery();
        while (result.next()) {
            int busID = result.getInt("bus_id");
            int lineID = result.getInt("line_id");
            Bus bus = allBuses.get(busID);
            Line line = allLines.get(lineID);
            Time departureTime = result.getTime("departure_time");
            Time tripDuration = result.getTime("trip_duration");
            Trip trip = new Trip(result.getInt("id"), bus, line, departureTime, tripDuration);
            trips.put(result.getInt("id"), trip);
        }

        return trips;
    }
}