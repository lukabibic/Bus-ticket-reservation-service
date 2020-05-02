package busystem.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.TreeMap;
import java.beans.PropertyChangeListener;

public class City {
    private String name;
    private Integer areaNumber;
    private Integer cityID;

    public City(String cityName, Integer areaNumber) throws SQLException {
        //TODO: throw exception if city doesn't exist?
        if (this.create(cityName, areaNumber)) {
            //set attributes if creation was successful
            this.setByAreaNumber(areaNumber);
        }
    }

    private City(Integer ID, String cityName, Integer areaNumber) {
        //this constructor is used only in getAll() static method
        this.cityID = ID;
        this.name = cityName;
        this.areaNumber = areaNumber;
    }

    public Integer getID() {
        return this.cityID;
    }

    public String getName() {
        return this.name;
    }

    public Integer getAreaNumber() {
        return this.areaNumber;
    }

    private static Connection getDbConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost/busystem?user=busystem&password=busystem");
    }

    private void setByAreaNumber(int areaNumber) throws SQLException {

        Connection conn = City.getDbConnection();
        PreparedStatement preparedStmt = conn.prepareStatement("SELECT * from city WHERE area_number = ?");
        preparedStmt.setInt(1, areaNumber);
        ResultSet city = preparedStmt.executeQuery();
        if (city.next()) {
            this.cityID = city.getInt("id");
            this.name = city.getString("name");
            this.areaNumber = city.getInt("area_number");
        }
    }

    public boolean create(String cityName, Integer areaNumber) throws SQLException {

        Connection conn = this.getDbConnection();
        
        //validate city name
        String validCityNamePattern = "^[a-zA-Z_.]{4,64}$";
        if (cityName.matches(validCityNamePattern) == false) {
            System.out.println("Invalid city name");
            return false;
        }

        //check if area number is taken
        PreparedStatement preparedStmt = conn.prepareStatement("SELECT * from city WHERE area_number = ?");
        preparedStmt.setInt(1, areaNumber);
        ResultSet existing_city = preparedStmt.executeQuery();
        if (existing_city.next() != false) {
            System.out.println("ERROR: City area number is taken");
            return false;
        }

        String query = "INSERT into city (name, area_number)" + " VALUES (?, ?)";
        preparedStmt = conn.prepareStatement(query);
        preparedStmt.setString(1, cityName);
        preparedStmt.setInt(2, areaNumber);

        preparedStmt.execute();
        System.out.println("City created sucessfully");
        return true;
    }

    public static TreeMap<Integer, City> getAll() throws SQLException {
        //return a Map of all existing cities
        //cityID maps to object with given ID
        TreeMap<Integer, City> cities = new TreeMap<Integer, City>();
        Connection conn = City.getDbConnection();

        PreparedStatement preparedStmt = conn.prepareStatement("SELECT * from city");
        ResultSet result = preparedStmt.executeQuery();
        while (result.next()) {
            int cityID = result.getInt("id");
            City city = new City(result.getInt("id"), result.getString("name"), result.getInt("area_number"));
            cities.put(cityID, city);
        }
        return cities;
    }
}