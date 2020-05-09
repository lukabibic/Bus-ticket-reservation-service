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

import javax.swing.JButton;
import javax.swing.JLabel;
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
	
	int cityCounter = 0;
	int busCounter = 0;

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
		
		//listanje 
		this.listCity();
		this.listBus();
		
		//logout button listener
		this.addLogoutListener(mainController);
		
		//listener za otvaranje formi
		this.addCityFormListener();
		this.addBusFormListener();
		
		//listener za dodavanje novih
		this.addNewBusListener();
		this.addNewCityListener();
		
		//listener za gumbe lijevo desno
		this.addPreviousBtnListenerCity();
		this.addNextBtnListenerCity();
		
		this.addPreviousBtnListenerBus();
		this.addNextBtnListenerBus();

		
	}
	
	private void addNextBtnListenerBus() {
		adminView.LoadNextBusButt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(busCounter + 4 < allBuses.size()) { //dont go too far mayne
					busCounter = busCounter + 4;
					listBus();
				}
			}
		});
	}

	private void addPreviousBtnListenerBus() {
		adminView.LoadPreviousBusButt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(busCounter - 4 > -1) { //dont go too far mayne
					busCounter = busCounter - 4;
					listBus();
				}
			}
		});
	}

	private void addNextBtnListenerCity() {
		adminView.LoadNextCityButt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(cityCounter + 4 < allCities.size()) { //dont go too far mayne
					cityCounter = cityCounter + 4;
					listCity();
				}
			}
		});
	}

	private void addPreviousBtnListenerCity() {
adminView.LoadPreviousCityButt.addActionListener(new ActionListener() {
			
			@Override 
			public void actionPerformed(ActionEvent e) { //dont go too far mayne
				if(cityCounter - 4 > -1) {
					cityCounter = cityCounter - 4;
					listCity();
				}
			}
		});
	}

	private void listBus() {
			JTextField[] textboxofBuses = {adminView.ModelBusTextBox1,adminView.ModelBusTextBox2,
				adminView.ModelBusTextBox3,adminView.ModelBusTextBox4};
			JTextField[] textboxofSeats = {
					adminView.SeatsBusTextBox1, adminView.SeatsBusTextBox2,
					adminView.SeatsBusTextBox3, adminView.SeatsBusTextBox4};
			JLabel[] busIdLabels = {adminView.label_busTextBox0, adminView.label_busTextBox1,
					adminView.label_busTextBox2, adminView.label_busTextBox3};
			
			for (int i = 0; i < textboxofBuses.length; i++) { // DA SE CLEAREAJU SVAKI PUT KAD SE POZOVE
				textboxofBuses[i].setText("");
				textboxofSeats[i].setText("");
				busIdLabels[i].setText("");
			}
			ArrayList<Bus> allBusNames = new ArrayList<Bus>();
			for (Entry<Integer, Bus> entry : allBuses.entrySet()) {
			    Bus value = entry.getValue();
			    
			    allBusNames.add(value);
			}
			int j = 0;
			int counter = busCounter;
			
			
			while(true) {
				if(j == 4) break; //DA ISPUSUJE SAMO 4 PO 4
				textboxofBuses[j].setText(allBusNames.get(counter).getModel());
				textboxofSeats[j].setText(allBusNames.get(counter).getSeats().toString());
				busIdLabels[j].setText(allBusNames.get(counter).getID().toString());
				counter++;
				if(counter > allBuses.size() - 1) { //KAD PREKORACI DA VRATI COUNTER I BREAKA
					counter = allBuses.size() - 1;
					break;
				}
				j++;
			}
	}

	private void listCity() {
			JTextField[] textboxofcities = {adminView.NameCityTextBox1,adminView.NameCityTextBox2,
				adminView.NameCityTextBox3,adminView.NameCityTextBox4};
			JTextField[] textboxofaddress = {
					adminView.AddressCityTextBox1, adminView.AddressCityTextBox2,
					adminView.AddressCityTextBox3, adminView.AddressCityTextBox4};
			JLabel[] cityIdLabels = {                             
					adminView.label_CityTextBox0, adminView.label_CityTextBox1,
					adminView.label_CityTextBox2, adminView.label_CityTextBox3
			};
			
			for (int i = 0; i < textboxofcities.length; i++) { // DA SE CLEAREAJU SVAKI PUT KAD SE POZOVE
				textboxofcities[i].setText("");
				textboxofaddress[i].setText("");
				cityIdLabels[i].setText("");
			}
			ArrayList<City> allCityNames = new ArrayList<City>();
			for (Entry<Integer, City> entry : allCities.entrySet()) {
			    City value = entry.getValue();
			    
			    allCityNames.add(value);
			}
			int j = 0;
			int counter = cityCounter;
			
			while(true) {
				if(j == 4) break; //DA ISPUSUJE SAMO 4 PO 4
				textboxofcities[j].setText(allCityNames.get(counter).getName());
				textboxofaddress[j].setText(allCityNames.get(counter).getAreaNumber().toString());
				cityIdLabels[j].setText(allCityNames.get(counter).getID().toString());
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
