package busystem;

import java.awt.Color;
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
	ArrayList<Bus> allBusNames = new ArrayList<Bus>();
	ArrayList<City> allCityNames = new ArrayList<City>();
	private AdminGUI adminView;
	
	int cityCounter = 0;
	int busCounter = 0;

	public AdminController(User user, MainController mainController) {
		this.admin = user;
		//dohvati sve iz baze...
		try {
			this.allCities = City.getAll();
			this.allBuses = Bus.getAll();
			Line.setCityCollection(allCities);
			this.allLines = Line.getAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		adminView = new AdminGUI();
		adminView.setVisible(true);
		
		//listanje
		if(allCities.size() > 0) {
		this.listCity();
		}
		if(allBuses.size() > 0) {
		this.listBus();
		}
		//logout button listener
		this.addLogoutListener(mainController);
		
		//listener za otvaranje formi
		this.addCityFormListener();
		this.addBusFormListener();
		this.addLineFormListener();
		
		//listener za dodavanje novih
		this.addNewBusListener();
		this.addNewCityListener();
		this.addNewLineListener();
		
		//listener za gumbe lijevo desno
		this.addPreviousBtnListenerCity();
		this.addNextBtnListenerCity();
		
		this.addPreviousBtnListenerBus();
		this.addNextBtnListenerBus();

		this.addAllEditBusListeners();
		this.addAllEditCityListeners();
		
		this.addAllDeleteBusListeners();
		this.addAllDeleteCityListeners();
	}
	
	private void BusCollectionToList() {
		allBusNames.clear();
		for (Entry<Integer, Bus> entry : allBuses.entrySet()) {
		    Bus value = entry.getValue();
		    
		    allBusNames.add(value);
		}
	}
	
	private void CityCollectionToList() {
		allCityNames.clear();
		for (Entry<Integer, City> entry : allCities.entrySet()) {
		    City value = entry.getValue();
		    
		    allCityNames.add(value);
		}
	}
	
	private void printAddUpdateDeleteBusMsg(String msg, JLabel label, boolean success) {
		if(success) {
			label.setForeground(Color.GREEN);
		}
		else {
			label.setForeground(Color.RED);
		}
		label.setText(msg);
	}
	
	private void addAllDeleteCityListeners() {
		// TODO Auto-generated method stub
		adminView.DeleteCityButt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int id = Integer.parseInt(adminView.label_CityTextBox0.getText());
				City city = allCities.get(id);
				
				try {
					city.deleteFromDB();
					allCities.remove(id);
					printAddUpdateDeleteBusMsg("City deleted from database!", adminView.UpdateOrDeleteMessageCityBox, true);
					listCity();
				} catch (SQLException e1) {
					printAddUpdateDeleteBusMsg("City can't be deleted!",adminView.UpdateOrDeleteMessageCityBox, false);
				}
			}
		});
		
		adminView.DeleteCityButt2.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						int id = Integer.parseInt(adminView.label_CityTextBox1.getText());
						City city = allCities.get(id);
						
						try {
							city.deleteFromDB();
							allCities.remove(id);
							printAddUpdateDeleteBusMsg("City deleted from database!", adminView.UpdateOrDeleteMessageCityBox, true);
							listCity();
						} catch (SQLException e1) {
							printAddUpdateDeleteBusMsg("City can't be deleted!",adminView.UpdateOrDeleteMessageCityBox, false);
						}
					}
				});
		
		adminView.DeleteCityButt3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int id = Integer.parseInt(adminView.label_CityTextBox2.getText());
				City city = allCities.get(id);
				
				try {
					city.deleteFromDB();
					allCities.remove(id);
					printAddUpdateDeleteBusMsg("City deleted from database!", adminView.UpdateOrDeleteMessageCityBox, true);
					listCity();
				} catch (SQLException e1) {
					printAddUpdateDeleteBusMsg("City can't be deleted!",adminView.UpdateOrDeleteMessageCityBox, false);
				}
			}
		});
		
		adminView.DeleteCityButt4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int id = Integer.parseInt(adminView.label_CityTextBox3.getText());
				City city = allCities.get(id);
				
				try {
					city.deleteFromDB();
					allCities.remove(id);
					printAddUpdateDeleteBusMsg("City deleted from database!", adminView.UpdateOrDeleteMessageCityBox, true);
					listCity();
				} catch (SQLException e1) {
					printAddUpdateDeleteBusMsg("City can't be deleted!",adminView.UpdateOrDeleteMessageCityBox, false);
				}
			}
		});
	}

	private void addAllDeleteBusListeners() {
		// TODO Auto-generated method stub
		adminView.DeleteBusButt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int id = Integer.parseInt(adminView.label_busTextBox0.getText());
				Bus bus = allBuses.get(id);
				
				try {
					bus.deleteFromDB();
					allBuses.remove(id);
					printAddUpdateDeleteBusMsg("Bus deleted from database!", adminView.UpdateOrDeleteMessageBusBox, true);
					listBus();
				} catch (SQLException e1) {
					printAddUpdateDeleteBusMsg("Bus can't be deleted!",adminView.UpdateOrDeleteMessageBusBox, false);
				}
			}
		});
		adminView.DeleteBusButt2.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int id = Integer.parseInt(adminView.label_busTextBox1.getText());
				Bus bus = allBuses.get(id);
				
				try {
					bus.deleteFromDB();
					allBuses.remove(id);
					printAddUpdateDeleteBusMsg("Bus deleted from database!", adminView.UpdateOrDeleteMessageBusBox, true);
					listBus();
				} catch (SQLException e1) {
					printAddUpdateDeleteBusMsg("Bus can't be deleted!",adminView.UpdateOrDeleteMessageBusBox, false);
				}
			}
		});
		adminView.DeleteBusButt3.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int id = Integer.parseInt(adminView.label_busTextBox2.getText());
				Bus bus = allBuses.get(id);
				
				try {
					bus.deleteFromDB();
					allBuses.remove(id);
					printAddUpdateDeleteBusMsg("Bus deleted from database!", adminView.UpdateOrDeleteMessageBusBox, true);
					listBus();
				} catch (SQLException e1) {
					printAddUpdateDeleteBusMsg("Bus can't be deleted!",adminView.UpdateOrDeleteMessageBusBox, false);
				}
			}
		});
		adminView.DeleteBusButt4.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int id = Integer.parseInt(adminView.label_busTextBox3.getText());
				Bus bus = allBuses.get(id);
				
				try {
					bus.deleteFromDB();
					allBuses.remove(id);
					printAddUpdateDeleteBusMsg("Bus deleted from database!", adminView.UpdateOrDeleteMessageBusBox, true);
					listBus();
				} catch (SQLException e1) {
					printAddUpdateDeleteBusMsg("Bus can't be deleted!",adminView.UpdateOrDeleteMessageBusBox, false);
				}
			}
		});
	}

	private void addAllEditCityListeners() {
		// TODO Auto-generated method stub
		adminView.EditCityButt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int id = Integer.parseInt(adminView.label_CityTextBox0.getText());
				City city = allCities.get(id);
				try {
					//Pretvaranje imena grada u odgovarajuce i dohvacanje postanskog broja
					String newnameofcity = adminView.NameCityTextBox1.getText();
					if(!newnameofcity.isEmpty()) {  //Ako upisano ime grada nije prazno, pretvori u odgovarajuce
						newnameofcity = newnameofcity.substring(0,1).toUpperCase() + newnameofcity.substring(1).toLowerCase();
					}
					Integer newareanumber = Integer.parseInt(adminView.AddressCityTextBox1.getText());
					
					if(!city.getName().equals(newnameofcity)) {
						city.setName(newnameofcity);
						printAddUpdateDeleteBusMsg("City information updated", adminView.UpdateOrDeleteMessageCityBox, true);
					}
					if(!city.getAreaNumber().equals(newareanumber)) {
						city.setAreaNumber(newareanumber);
						printAddUpdateDeleteBusMsg("City information updated", adminView.UpdateOrDeleteMessageCityBox, true);
					}
					
					listCity();
				} catch (NumberFormatException e1) {
					printAddUpdateDeleteBusMsg("Address must be number!", adminView.UpdateOrDeleteMessageCityBox, false);
				} catch (IllegalArgumentException e1) {
					printAddUpdateDeleteBusMsg(e1.getMessage(), adminView.UpdateOrDeleteMessageCityBox, false);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		adminView.EditCityButt2.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						int id = Integer.parseInt(adminView.label_CityTextBox1.getText());
						City city = allCities.get(id);
						try {
							//Pretvaranje imena grada u odgovarajuce i dohvacanje postanskog broja
							String newnameofcity = adminView.NameCityTextBox2.getText();
							if(!newnameofcity.isEmpty()) {  //Ako upisano ime grada nije prazno, pretvori u odgovarajuce
								newnameofcity = newnameofcity.substring(0,1).toUpperCase() + newnameofcity.substring(1).toLowerCase();
							}
							Integer newareanumber = Integer.parseInt(adminView.AddressCityTextBox2.getText());
							
							if(!city.getName().equals(newnameofcity)) {
								city.setName(newnameofcity);
								printAddUpdateDeleteBusMsg("City information updated", adminView.UpdateOrDeleteMessageCityBox, true);
							}
							if(!city.getAreaNumber().equals(newareanumber)) {
								city.setAreaNumber(newareanumber);
								printAddUpdateDeleteBusMsg("City information updated", adminView.UpdateOrDeleteMessageCityBox, true);
							}
							
							listCity();
						} catch (NumberFormatException e1) {
							printAddUpdateDeleteBusMsg("Address must be number!", adminView.UpdateOrDeleteMessageCityBox, false);
						} catch (IllegalArgumentException e1) {
							printAddUpdateDeleteBusMsg(e1.getMessage(), adminView.UpdateOrDeleteMessageCityBox, false);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
		
		adminView.EditCityButt3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int id = Integer.parseInt(adminView.label_CityTextBox2.getText());
				City city = allCities.get(id);
				try {
					//Pretvaranje imena grada u odgovarajuce i dohvacanje postanskog broja
					String newnameofcity = adminView.NameCityTextBox3.getText();
					if(!newnameofcity.isEmpty()) {  //Ako upisano ime grada nije prazno, pretvori u odgovarajuce
						newnameofcity = newnameofcity.substring(0,1).toUpperCase() + newnameofcity.substring(1).toLowerCase();
					}
					Integer newareanumber = Integer.parseInt(adminView.AddressCityTextBox3.getText());
					
					if(!city.getName().equals(newnameofcity)) {
						city.setName(newnameofcity);
						printAddUpdateDeleteBusMsg("City information updated", adminView.UpdateOrDeleteMessageCityBox, true);
					}
					if(!city.getAreaNumber().equals(newareanumber)) {
						city.setAreaNumber(newareanumber);
						printAddUpdateDeleteBusMsg("City information updated", adminView.UpdateOrDeleteMessageCityBox, true);
					}
					
					listCity();
				} catch (NumberFormatException e1) {
					printAddUpdateDeleteBusMsg("Address must be number!", adminView.UpdateOrDeleteMessageCityBox, false);
				} catch (IllegalArgumentException e1) {
					printAddUpdateDeleteBusMsg(e1.getMessage(), adminView.UpdateOrDeleteMessageCityBox, false);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		adminView.EditCityButt4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int id = Integer.parseInt(adminView.label_CityTextBox3.getText());
				City city = allCities.get(id);
				try {
					//Pretvaranje imena grada u odgovarajuce i dohvacanje postanskog broja
					String newnameofcity = adminView.NameCityTextBox4.getText();
					if(!newnameofcity.isEmpty()) {  //Ako upisano ime grada nije prazno, pretvori u odgovarajuce
						newnameofcity = newnameofcity.substring(0,1).toUpperCase() + newnameofcity.substring(1).toLowerCase();
					}
					Integer newareanumber = Integer.parseInt(adminView.AddressCityTextBox4.getText());
					
					if(!city.getName().equals(newnameofcity)) {
						city.setName(newnameofcity);
						printAddUpdateDeleteBusMsg("City information updated", adminView.UpdateOrDeleteMessageCityBox, true);
					}
					if(!city.getAreaNumber().equals(newareanumber)) {
						city.setAreaNumber(newareanumber);
						printAddUpdateDeleteBusMsg("City information updated", adminView.UpdateOrDeleteMessageCityBox, true);
					}
					listCity();
				} catch (NumberFormatException e1) {
					printAddUpdateDeleteBusMsg("Address must be number!", adminView.UpdateOrDeleteMessageCityBox, false);
				} catch (IllegalArgumentException e1) {
					printAddUpdateDeleteBusMsg(e1.getMessage(), adminView.UpdateOrDeleteMessageCityBox, false);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

	private void addAllEditBusListeners() {
		// TODO Auto-generated method stub
		adminView.EditBusButt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int id = Integer.parseInt(adminView.label_busTextBox0.getText());
				Bus bus = allBuses.get(id);
				try {
					//Pretvaranje imena grada u odgovarajuce i dohvacanje postanskog broja
					String newmodelofbus = adminView.ModelBusTextBox1.getText();
					if(!newmodelofbus.isEmpty()) {  //Ako upisano ime modela nije prazno, pretvori u odgovarajuce
						newmodelofbus = newmodelofbus.substring(0,1).toUpperCase() + newmodelofbus.substring(1).toLowerCase();
					}
					Integer newnumberofseats = Integer.parseInt(adminView.SeatsBusTextBox1.getText());
					
					if(!bus.getModel().equals(newmodelofbus)){
						bus.setModel(newmodelofbus);
						printAddUpdateDeleteBusMsg("Bus information updated", adminView.UpdateOrDeleteMessageBusBox, true);
					}
					if(!bus.getSeats().equals(newnumberofseats)) {
						bus.setSeats(newnumberofseats);
						printAddUpdateDeleteBusMsg("Bus information updated", adminView.UpdateOrDeleteMessageBusBox, true);
					}
					
					listBus();
				} catch (NumberFormatException e1) {
					printAddUpdateDeleteBusMsg("Seats must be number!", adminView.UpdateOrDeleteMessageBusBox, false);
				} catch (IllegalArgumentException e1) {
					printAddUpdateDeleteBusMsg(e1.getMessage(), adminView.UpdateOrDeleteMessageBusBox, false);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		adminView.EditBusButt2.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						int id = Integer.parseInt(adminView.label_busTextBox1.getText());
						Bus bus = allBuses.get(id);
						try {
							//Pretvaranje imena grada u odgovarajuce i dohvacanje postanskog broja
							String newmodelofbus = adminView.ModelBusTextBox1.getText();
							if(!newmodelofbus.isEmpty()) {  //Ako upisano ime modela nije prazno, pretvori u odgovarajuce
								newmodelofbus = newmodelofbus.substring(0,1).toUpperCase() + newmodelofbus.substring(1).toLowerCase();
							}
							Integer newnumberofseats = Integer.parseInt(adminView.SeatsBusTextBox1.getText());
							
							if(!bus.getModel().equals(newmodelofbus)){
								bus.setModel(newmodelofbus);
								printAddUpdateDeleteBusMsg("Bus information updated", adminView.UpdateOrDeleteMessageBusBox, true);
							}
							if(!bus.getSeats().equals(newnumberofseats)) {
								bus.setSeats(newnumberofseats);
								printAddUpdateDeleteBusMsg("Bus information updated", adminView.UpdateOrDeleteMessageBusBox, true);
							}
							
							listBus();
						} catch (NumberFormatException e1) {
							printAddUpdateDeleteBusMsg("Seats must be number!", adminView.UpdateOrDeleteMessageBusBox, false);
						} catch (IllegalArgumentException e1) {
							printAddUpdateDeleteBusMsg(e1.getMessage(), adminView.UpdateOrDeleteMessageBusBox, false);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
		
		adminView.EditBusButt3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int id = Integer.parseInt(adminView.label_busTextBox2.getText());
				Bus bus = allBuses.get(id);
				try {
					//Pretvaranje imena grada u odgovarajuce i dohvacanje postanskog broja
					String newmodelofbus = adminView.ModelBusTextBox1.getText();
					if(!newmodelofbus.isEmpty()) {  //Ako upisano ime modela nije prazno, pretvori u odgovarajuce
						newmodelofbus = newmodelofbus.substring(0,1).toUpperCase() + newmodelofbus.substring(1).toLowerCase();
					}
					Integer newnumberofseats = Integer.parseInt(adminView.SeatsBusTextBox1.getText());
					
					if(!bus.getModel().equals(newmodelofbus)){
						bus.setModel(newmodelofbus);
						printAddUpdateDeleteBusMsg("Bus information updated", adminView.UpdateOrDeleteMessageBusBox, true);
					}
					if(!bus.getSeats().equals(newnumberofseats)) {
						bus.setSeats(newnumberofseats);
						printAddUpdateDeleteBusMsg("Bus information updated", adminView.UpdateOrDeleteMessageBusBox, true);
					}
					
					listBus();
				} catch (NumberFormatException e1) {
					printAddUpdateDeleteBusMsg("Seats must be number!", adminView.UpdateOrDeleteMessageBusBox, false);
				} catch (IllegalArgumentException e1) {
					printAddUpdateDeleteBusMsg(e1.getMessage(), adminView.UpdateOrDeleteMessageBusBox, false);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		adminView.EditBusButt4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int id = Integer.parseInt(adminView.label_busTextBox3.getText());
				Bus bus = allBuses.get(id);
				try {
					//Pretvaranje imena grada u odgovarajuce i dohvacanje postanskog broja
					String newmodelofbus = adminView.ModelBusTextBox1.getText();
					if(!newmodelofbus.isEmpty()) {  //Ako upisano ime modela nije prazno, pretvori u odgovarajuce
						newmodelofbus = newmodelofbus.substring(0,1).toUpperCase() + newmodelofbus.substring(1).toLowerCase();
					}
					Integer newnumberofseats = Integer.parseInt(adminView.SeatsBusTextBox1.getText());
					
					if(!bus.getModel().equals(newmodelofbus)){
						bus.setModel(newmodelofbus);
						printAddUpdateDeleteBusMsg("Bus information updated", adminView.UpdateOrDeleteMessageBusBox, true);
					}
					if(!bus.getSeats().equals(newnumberofseats)) {
						bus.setSeats(newnumberofseats);
						printAddUpdateDeleteBusMsg("Bus information updated", adminView.UpdateOrDeleteMessageBusBox, true);
					}
					
					listBus();
				} catch (NumberFormatException e1) {
					printAddUpdateDeleteBusMsg("Seats must be number!", adminView.UpdateOrDeleteMessageBusBox, false);
				} catch (IllegalArgumentException e1) {
					printAddUpdateDeleteBusMsg(e1.getMessage(), adminView.UpdateOrDeleteMessageBusBox, false);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
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
			
			BusCollectionToList();
			
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
			
			CityCollectionToList();
			
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
				if(!nameofbus.isEmpty()) {
					nameofbus = nameofbus.substring(0,1).toUpperCase() + nameofbus.substring(1).toLowerCase();
				}
				
				//Upis novog busa
				try {
					Integer numberofseats = Integer.parseInt(adminView.SeatsBusAddTextBox.getText());
					Bus newbus = new Bus(nameofbus,numberofseats);
					allBuses.put(newbus.getID(), newbus);
					
					printAddUpdateDeleteBusMsg("New bus added!", adminView.AddNewBusLabel, true);
					listBus();
				} catch (NumberFormatException e) {
					printAddUpdateDeleteBusMsg("Seats must be number!", adminView.AddNewBusLabel, false);
				}catch (IllegalArgumentException e) {
					printAddUpdateDeleteBusMsg(e.getMessage(), adminView.AddNewBusLabel, false);
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
				if(!nameofcity.isEmpty()) {
					nameofcity = nameofcity.substring(0,1).toUpperCase() + nameofcity.substring(1).toLowerCase();
				}
			
				//Upis novog grada
				try {
					Integer areanumber = Integer.parseInt(adminView.AddressCityAddTextBox.getText());
					City newcity = new City(nameofcity, areanumber);
					allCities.put(newcity.getID(),newcity);
					printAddUpdateDeleteBusMsg("New city added!", adminView.AddNewCityLabel, true);
					listCity();
				} catch (NumberFormatException e) {
					printAddUpdateDeleteBusMsg("Address must be number!", adminView.AddNewCityLabel, false);
				}catch (IllegalArgumentException e) {
					printAddUpdateDeleteBusMsg(e.getMessage(), adminView.AddNewCityLabel, false);
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
	
	private void addNewLineListener() {
		this.adminView.AddLineButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent argo0) {
				
				//Povuci grad Start
				City start = allCityNames.get(adminView.AddStartComboBox.getSelectedIndex());
				
				//Povuci grad Destination
				City destination = allCityNames.get(adminView.AddDestinationComboBox.getSelectedIndex());
				
				//Kreiranje liniju i dodaj u kolekciju
				Line newLine;
				try {
					newLine = new Line(start,destination);
					allLines.put(newLine.getID(), newLine);
					//listLines();
				} catch (IllegalArgumentException | SQLException e) {
					//Nebi trebalo biti Argument Exceptiona jer je nemoguce odabrat grad koji ne postoji ako se bira iz dropdowna.
					e.printStackTrace();
				}
				
			}
		});
	}
	
	private void addBusFormListener() {
		this.adminView.AdminBusButt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent argo0) {
				adminView.AdminCityPanel.setVisible(false);
				adminView.AdminLinePanel.setVisible(false);
				adminView.AdminBusPanel.setVisible(true);
				
				adminView.AdminBusButt.setOpaque(true);
				adminView.AdminCityButt.setOpaque(false);
				adminView.AdminLineButt.setOpaque(false);
				
				adminView.AdminCityButt.setBorder(new LineBorder(SystemColor.textHighlight, 2));
				adminView.AdminLineButt.setBorder(new LineBorder(SystemColor.textHighlight, 2));
				
				adminView.AddNewCityLabel.setText("");
				adminView.UpdateOrDeleteMessageCityBox.setText("");
				listBus();
			}
		});
	}

	private void addCityFormListener() {
		this.adminView.AdminCityButt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent argo0) {
				adminView.AdminBusPanel.setVisible(false);
				adminView.AdminLinePanel.setVisible(false);
				adminView.AdminCityPanel.setVisible(true);
				
				adminView.AdminCityButt.setOpaque(true);
				adminView.AdminBusButt.setOpaque(false);
				adminView.AdminLineButt.setOpaque(false);
				
				adminView.AdminBusButt.setBorder(new LineBorder(SystemColor.textHighlight, 2));
				adminView.AdminLineButt.setBorder(new LineBorder(SystemColor.textHighlight, 2));
				
				adminView.AddNewBusLabel.setText("");
				adminView.UpdateOrDeleteMessageBusBox.setText("");
				listCity();
			}
		});
	}
	
	private void addLineFormListener() {
		this.adminView.AdminLineButt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent argo0) {
				adminView.AdminBusPanel.setVisible(false);
				adminView.AdminCityPanel.setVisible(false);
				adminView.AdminLinePanel.setVisible(true);
				
				adminView.AdminLineButt.setOpaque(true);
				adminView.AdminBusButt.setOpaque(false);
				adminView.AdminCityButt.setOpaque(false);
				
				//popunjavanje dropdown menija postojecim gradovima
				CityCollectionToList();
				
				//Ocisti dropdown -> u slucaju dodavanja grada, brisanja
				adminView.AddStartComboBox.removeAllItems();
				adminView.AddDestinationComboBox.removeAllItems();
				
				//Popuni dropdowne svim imenima gradova
				for(int i=0;i<allCityNames.size();i++) {
					adminView.AddStartComboBox.addItem(allCityNames.get(i).getName());
				    adminView.AddDestinationComboBox.addItem(allCityNames.get(i).getName());
				}
				
				adminView.AdminBusButt.setBorder(new LineBorder(SystemColor.textHighlight, 2));
				adminView.AdminCityButt.setBorder(new LineBorder(SystemColor.textHighlight, 2));
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
