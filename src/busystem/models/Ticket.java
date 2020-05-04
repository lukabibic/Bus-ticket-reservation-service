package busystem.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.util.TreeMap;
import java.util.ArrayList;

public class Ticket {

    private Integer ID;
    private Trip trip; 
    private User user;
    private Date tripDate;

    //Map of all currently existing lines
    //lineID maps to a Line object with given ID
    private static TreeMap<Integer, Trip> allTrips;

    public static void setTripCollection(TreeMap<Integer, Trip> allTrips) {
        Ticket.allTrips = allTrips;
    }

    private static Connection getDbConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost/busystem?user=busystem&password=busystem");
    }
    
    public Ticket(Trip trip, User user, Date tripDate) throws Exception, SQLException {
        //exception is thrown if ticket is not available
        this.ID = this.create(trip, user, tripDate);
        this.trip = trip;
        this.user = user;
        this.tripDate = tripDate;
    }

    private Ticket(int ID, Trip trip, User user, Date tripDate) {
        //constructor used in getAll()
        this.ID = ID;
        this.trip = trip;
        this.user = user;
        this.tripDate = tripDate;
    }

    public Integer getID() {
        return this.ID;
    }

    public String toString() {
        return this.trip + "\n" + this.tripDate + "\n" + this.user;
    }

    private Integer create(Trip trip, User user, Date tripDate) throws Exception, SQLException {
        //create ticket in database and return ID of generated ticket

        Connection conn = Ticket.getDbConnection();

        //check if any tickets are left for trip on selected date
        PreparedStatement preparedStmt = conn.prepareStatement("SELECT count(*) AS count from ticket WHERE trip_id = ? AND trip_date = ?");
        preparedStmt.setInt(1, trip.getID());
        preparedStmt.setDate(2, tripDate);
        ResultSet result = preparedStmt.executeQuery();
        result.next();
        int numberOfTickets = result.getInt("count");
        if (numberOfTickets == trip.getBus().getSeats()) {
            throw new Exception("Error: cannot create ticket because no seats are left");
        }

        String query = "INSERT into ticket (trip_id, user_id, trip_date) VALUES (?, ?, ?)";
        preparedStmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStmt.setInt(1, trip.getID());
        preparedStmt.setInt(2, user.getID());
        preparedStmt.setDate(3, tripDate);
        preparedStmt.execute();

        ResultSet generatedID = preparedStmt.getGeneratedKeys();
        generatedID.next();
        int ticketID = generatedID.getInt(1);
        System.out.println("Ticket created sucessfully");
        return ticketID;
    }

    public static ArrayList<Ticket> getUsersTickets(User user) throws SQLException {
        //return a collection of all tickets owned by given user
        ArrayList<Ticket> usersTickets = new ArrayList<Ticket>();

        Connection conn = Ticket.getDbConnection();

        PreparedStatement preparedStmt = conn.prepareStatement("SELECT * FROM ticket WHERE user_id = ?");
        preparedStmt.setInt(1, user.getID());
        ResultSet result = preparedStmt.executeQuery();
        while (result.next()) {
            int tripID = result.getInt("trip_id");
            Trip trip = allTrips.get(tripID);
            Date tripDate = result.getDate("trip_date");
            Ticket ticket = new Ticket(result.getInt("id"),trip, user, tripDate);
            usersTickets.add(ticket);
        }

        return usersTickets;
    }
}