package busystem;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import busystem.models.*;

public class AdminController {
	private User admin; 
	private TreeMap<Integer, City> allCities;
	private TreeMap<Integer, Bus> allBuses;
	private TreeMap<Integer, Line> allLines;
	private TreeMap<Integer, Trip> allTrips;
	private TreeMap<Integer, Ticket> allTickets;
	private AdminGUI adminView;
	
	int i = 0;

	public AdminController(User user, MainController mainController) {
		this.admin = user;
		//dohvati sve iz baze...
		try {
			this.allCities = City.getAll();
			this.allBuses = Bus.getAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		adminView = new AdminGUI();
		adminView.setVisible(true);
		
		this.listCity();
		this.listBus();
		
		this.addLogoutListener(mainController);
		
		this.addCityFormListener();
		this.addBusFormListener();
		
		this.addNewBusListener();
		this.addNewCityListener();
		
		this.addPreviousBtnListenerCity();
		this.addNextBtnListenerCity();
	}

	private void addNextBtnListenerCity() {
		adminView.LoadNextCityButt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(i + 4 < allCities.size()) {
					i = i + 4;
					listCity();
				}
			}
		});
	}

	private void addPreviousBtnListenerCity() {
adminView.LoadPreviousCityButt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(i - 4 > -1) {
					i = i - 4;
					listCity();
				}
			}
		});
	}

	private void listBus() {
		
	}

	private void listCity() {
			JTextField[] textboxofcities = {adminView.NameCityTextBox1,adminView.NameCityTextBox2,
				adminView.NameCityTextBox3,adminView.NameCityTextBox4};
			JTextField[] textboxofaddress = {
					adminView.AddressCityTextBox1, adminView.AddressCityTextBox2,
					adminView.AddressCityTextBox3, adminView.AddressCityTextBox4};
			
			for (int i = 0; i < textboxofcities.length; i++) { // DA SE CLEAREAJU SVAKI PUT KAD SE POZOVE
				textboxofcities[i].setText("");
				textboxofaddress[i].setText("");
			}
			ArrayList<City> allCityNames = new ArrayList<City>();
			for (Entry<Integer, City> entry : allCities.entrySet()) {
			    City value = entry.getValue();
			    
			    allCityNames.add(value);
			}
			int j = 0;
			int counter = i;
			//System.out.println(allCityNames.get(5));
			while(true) {
				if(j == 4) break; //DA ISPUSUJE SAMO 4 PO 4
				textboxofcities[j].setText(allCityNames.get(counter).getName());
				textboxofaddress[j].setText(allCityNames.get(counter).getAreaNumber().toString());
				counter++;
				if(counter > allCities.size() - 1) { //KAD PREKORACI DA VRATI COUNTER I BREAKA
					counter = allCities.size() - 1;
					break;
				}
				j++;
			}
	}
	
	private void addNewBusListener() {
		this.adminView.AddBusButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent argo0) {	
				//Pretvaranje imena busa u odgovarajuce i dohvacanje broja sjedala
				String nameofbus = adminView.ModelBusAddTextBox.getText();
				nameofbus = nameofbus.substring(0,1).toUpperCase() + nameofbus.substring(1).toLowerCase();
				Integer numberofseats = Integer.parseInt(adminView.SeatsBusAddTextBox.getText());
				
				//Upis novog busa
				try {
					Bus newbus = new Bus(nameofbus,numberofseats);
					allBuses.put(newbus.getID(), newbus);
					
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//Ocisti text boxove
				adminView.ModelBusAddTextBox.setText("");
				adminView.SeatsBusAddTextBox.setText("");	
			}
		});
	}
	
	private void addNewCityListener() {
		this.adminView.AddCityButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent argo0) {
				//Pretvaranje imena grada u odgovarajuce i dohvacanje postanskog broja
				String nameofcity = adminView.NameCityAddTextBox.getText();
				nameofcity = nameofcity.substring(0,1).toUpperCase() + nameofcity.substring(1).toLowerCase();
				Integer areanumber = Integer.parseInt(adminView.AddressCityAddTextBox.getText());
				
				//Upis novog grada
				try {
					City newcity = new City(nameofcity, areanumber);
					allCities.put(newcity.getID(),newcity);
					
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//Ocisti text boxove
				adminView.NameCityAddTextBox.setText("");
				adminView.AddressCityAddTextBox.setText("");
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
