package busystem;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeMap;

import javax.swing.border.LineBorder;

import busystem.models.*;

public class AdminController {
	private User admin; 
	private TreeMap<Integer, City> allCities;
	private TreeMap<Integer, City> allBuses;
	private TreeMap<Integer, Line> allLines;
	private TreeMap<Integer, Trip> allTrips;
	private TreeMap<Integer, Ticket> allTickets;
	private AdminGUI adminView;

	public AdminController(User user, MainController mainController) {
		this.admin = user;
		//dohvati sve iz baze...

		adminView = new AdminGUI();
		adminView.setVisible(true);
		this.addLogoutListener(mainController);
		this.addCityFormListener();
		this.addBusFormListener();
		this.addNewBusListener();
		this.addNewCityListener();
	}

	private void addNewBusListener() {
		this.adminView.AddBusButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent argo0) {			
				try {
					//Pretvaranje imena busa u odgovarajuce
					String nameofbus = adminView.ModelBusAddTextBox.getText();
					nameofbus = nameofbus.substring(0,1).toUpperCase() + nameofbus.substring(1).toLowerCase();
					
					//Dodavanje busa
					PreparedStatement preparedStmt;
					preparedStmt = DBconnect.conn.prepareStatement("INSERT INTO bus (model, seats) "
							+ "VALUES (?,?)");
					preparedStmt.setString(1,nameofbus);
					preparedStmt.setString(2,adminView.SeatsBusAddTextBox.getText());
					preparedStmt.execute();
					
					//Ocisti text boxove
					adminView.ModelBusAddTextBox.setText("");
					adminView.SeatsBusAddTextBox.setText("");
					System.out.println("Bus created sucessfully");
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	private void addNewCityListener() {
		this.adminView.AddCityButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent argo0) {
				try {
					//Pretvaranje imena grada u odgovarajuce
					String nameofcity = adminView.NameCityAddTextBox.getText();
					nameofcity = nameofcity.substring(0,1).toUpperCase() + nameofcity.substring(1).toLowerCase();
					
					//Provjera dali postoji grad sa istim imenom ili postanskim brojem
					PreparedStatement preparedStmt1 = DBconnect.conn.prepareStatement("SELECT * from city WHERE name = ? OR area_number = ?");
			        preparedStmt1.setString(1, nameofcity);
			        preparedStmt1.setString(2, adminView.AddressCityAddTextBox.getText());
			        ResultSet existing_city = preparedStmt1.executeQuery();
			        if (existing_city.next() != false) {
			            throw new IllegalArgumentException("City with that name or address already exist!");
			        }
			        
			        //Ako ne postoji ubaci ga u bazu
					PreparedStatement preparedStmt2 = DBconnect.conn.prepareStatement("INSERT INTO city (name, area_number) "
							+ "VALUES (?,?)");
					preparedStmt2.setString(1,nameofcity);
					preparedStmt2.setString(2,adminView.AddressCityAddTextBox.getText());
					preparedStmt2.execute();
					
					//Ocisti text boxove
					adminView.NameCityAddTextBox.setText("");
					adminView.AddressCityAddTextBox.setText("");
					System.out.println("City created sucessfully");
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	private void addBusFormListener() {
		this.adminView.AdminBusButt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent argo0) {
				adminView.AdminBusPanel.setVisible(true);
				adminView.AdminCityPanel.setVisible(false);
				adminView.AdminBusButt.setOpaque(true);
				adminView.AdminCityButt.setOpaque(false);
				adminView.AdminCityButt.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			}
		});
	}

	private void addCityFormListener() {
		this.adminView.AdminCityButt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent argo0) {
				adminView.AdminBusPanel.setVisible(false);
				adminView.AdminCityPanel.setVisible(true);
				adminView.AdminBusButt.setOpaque(false);
				adminView.AdminCityButt.setOpaque(true);
				adminView.AdminBusButt.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			}
		});
	}

	//ovo povezat sa logout button
	private void addLogoutListener(MainController mainController) {
		//kad se korisnik logouta ugasi userGUI i ponovo upali login controller koji pali loginGUI
		this.adminView.btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adminView.setVisible(false);
				mainController.adminController = null; 
				mainController.loginController = new LoginController(mainController);
			}
		});
	}
}
