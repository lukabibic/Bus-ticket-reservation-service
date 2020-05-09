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

public class City {

    private Integer ID;
    private String name;
    private Integer areaNumber;

    public City(String cityName, Integer areaNumber) throws IllegalArgumentException, SQLException {

        this.ID = this.create(cityName, areaNumber);
        this.name = cityName;
        this.areaNumber = areaNumber;
    }

    private City(Integer ID, String cityName, Integer areaNumber) {
        //this constructor is used only in getAll() static method
        this.ID = ID;
        this.name = cityName;
        this.areaNumber = areaNumber;
    }

    public Integer getID() {
        return this.ID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) throws IllegalArgumentException, SQLException {
        //validate city name
        String validCityNamePattern = "^[a-zA-Z_. ]{4,64}$";
        if (newName.matches(validCityNamePattern) == false || newName.length() == 0) {
            throw new IllegalArgumentException("Error: Invalid city name");
        }

        //update in db
        PreparedStatement preparedStmt = DBconnect.conn.prepareStatement("UPDATE city SET name = ? WHERE id = ?");
        preparedStmt.setString(1, newName);
        preparedStmt.setInt(2, this.ID);
        preparedStmt.execute();
        System.out.println("City name updated successfully");
        
        //update local
        this.name = newName;
    }

    public Integer getAreaNumber() {
        return this.areaNumber;
    }

    public void setAreaNumber(Integer newAreaNumber) throws IllegalArgumentException, SQLException {
        //check if area number is taken
        PreparedStatement preparedStmt = DBconnect.conn.prepareStatement("SELECT * from city WHERE area_number = ?");
        preparedStmt.setInt(1, newAreaNumber);
        ResultSet existing_city = preparedStmt.executeQuery();
        if (existing_city.next() != false) {
            throw new IllegalArgumentException("Error: City area number is taken");
        }

        //update in db
        preparedStmt = DBconnect.conn.prepareStatement("UPDATE city SET area_number = ? WHERE id = ?");
        preparedStmt.setInt(1, newAreaNumber);
        preparedStmt.setInt(2, this.ID);
        preparedStmt.execute();
        System.out.println("City area number updated successfully");
        
        //update local
        this.areaNumber = newAreaNumber;
    }

    public void deleteFromDB() throws SQLException {
        PreparedStatement preparedStmt = DBconnect.conn.prepareStatement("DELETE from city WHERE id = ?");
        preparedStmt.setInt(1, this.ID);
        preparedStmt.execute();
        System.out.println("City deleted from database");
    }

    public String toString() {
        return this.name;
    }


    public Integer create(String cityName, Integer areaNumber) throws IllegalArgumentException, SQLException {
       
        //validate city name
        String validCityNamePattern = "^[a-zA-Z_. ]{4,64}$";
        if (cityName.matches(validCityNamePattern) == false || cityName.length() == 0) {
            throw new IllegalArgumentException("Error: Invalid city name");
        }

        //check if area number is taken
        PreparedStatement preparedStmt = DBconnect.conn.prepareStatement("SELECT * from city WHERE area_number = ?");
        preparedStmt.setInt(1, areaNumber);
        ResultSet existing_city = preparedStmt.executeQuery();
        if (existing_city.next() != false) {
            throw new IllegalArgumentException("Error: City area number is taken");
        }

        String query = "INSERT into city (name, area_number)" + " VALUES (?, ?)";
        preparedStmt = DBconnect.conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStmt.setString(1, cityName);
        preparedStmt.setInt(2, areaNumber);
        preparedStmt.execute();

        ResultSet generatedID = preparedStmt.getGeneratedKeys();
        generatedID.next();
        int cityID = generatedID.getInt(1);
        System.out.println("City created successfuly");
        return cityID;
    }

    public static TreeMap<Integer, City> getAll() throws SQLException {
        //return a Map of all existing cities
        //cityID maps to object with given ID
        TreeMap<Integer, City> cities = new TreeMap<Integer, City>();

        PreparedStatement preparedStmt = DBconnect.conn.prepareStatement("SELECT * from city");
        ResultSet result = preparedStmt.executeQuery();
        while (result.next()) {
            int cityID = result.getInt("id");
            City city = new City(result.getInt("id"), result.getString("name"), result.getInt("area_number"));
            cities.put(cityID, city);
        }
        return cities;
    }
}