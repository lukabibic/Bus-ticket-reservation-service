package busystem;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
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
	ArrayList<Line> allLineList = new ArrayList<Line>();
	ArrayList<Trip> allTripList = new ArrayList<Trip>();
	private AdminGUI adminView;
	
	int cityCounter = 0;
	int busCounter = 0;
	int lineCounter = 0;
	int tripCounter = 0;
	
	public AdminController(User user, MainController mainController) {
		this.admin = user;
		//dohvati sve iz baze...
		try {
			this.allCities = City.getAll();
			this.allBuses = Bus.getAll();
			Line.setCityCollection(allCities);
			this.allLines = Line.getAll();
			Trip.setBusCollection(allBuses);
			Trip.setLineCollection(allLines);
			this.allTrips = Trip.getAll();
			
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
		if(allLines.size() > 0) {
		this.listLines();
		}
		if(allTrips.size() > 0) {
		this.listTrips();
		}
		
		//logout button listener
		this.addLogoutListener(mainController);
		
		//listener za otvaranje formi
		this.addCityFormListener();
		this.addBusFormListener();
		this.addLineFormListener();
		this.addTripFormListener();
		
		//listener za dodavanje novih
		this.addNewBusListener();
		this.addNewCityListener();
		this.addNewLineListener();
		this.addNewTripListener();
		
		//listener za gumbe lijevo desno
		this.addPreviousBtnListenerCity();
		this.addNextBtnListenerCity();
		
		this.addPreviousBtnListenerBus();
		this.addNextBtnListenerBus();
		
		this.addNextBtnListenerLine();
		this.addPreviousBtnListenerLine();
		
		this.addNextBtnListenerTrip();
		this.addPreviousBtnListenerTrip();
		
		this.addAllEditBusListeners();
		this.addAllEditCityListeners();
		
		this.addAllDeleteBusListeners();
		this.addAllDeleteCityListeners();
		this.addAllDeleteLineListeners();
		this.addAllDeleteTripListeners();
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
	
	private void LineCollectionToList() {
		allLineList.clear();
		for (Entry<Integer, Line> entry : allLines.entrySet()) {
		    Line value = entry.getValue();
		    
		    allLineList.add(value);
		}
	}
	
	private void TripCollectionToList() {
		allTripList.clear();
		for (Entry<Integer, Trip> entry : allTrips.entrySet()) {
		    Trip value = entry.getValue();
		    
		    allTripList.add(value);
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

	private void addAllDeleteLineListeners() {
		// TODO Auto-generated method stub
		adminView.DeleteLineButt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int id = Integer.parseInt(adminView.label_lineTextBox0.getText());
				Line line = allLines.get(id);
				
				try {
					line.deleteFromDB();
					allLines.remove(id);
					printAddUpdateDeleteBusMsg("Line deleted from database!", adminView.UpdateOrDeleteMessageLineBox, true);
					listLines();
				} catch (SQLException e1) {
					printAddUpdateDeleteBusMsg("Line can't be deleted!",adminView.UpdateOrDeleteMessageLineBox, false);
				}
			}
		});
		
		adminView.DeleteLineButt2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int id = Integer.parseInt(adminView.label_lineTextBox1.getText());
				Line line = allLines.get(id);
				
				try {
					line.deleteFromDB();
					allLines.remove(id);
					printAddUpdateDeleteBusMsg("Line deleted from database!", adminView.UpdateOrDeleteMessageLineBox, true);
					listLines();
				} catch (SQLException e1) {
					printAddUpdateDeleteBusMsg("Line can't be deleted!",adminView.UpdateOrDeleteMessageLineBox, false);
				}
			}
		});
		
		adminView.DeleteLineButt3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int id = Integer.parseInt(adminView.label_lineTextBox2.getText());
				Line line = allLines.get(id);
				
				try {
					line.deleteFromDB();
					allLines.remove(id);
					printAddUpdateDeleteBusMsg("Line deleted from database!", adminView.UpdateOrDeleteMessageLineBox, true);
					listLines();
				} catch (SQLException e1) {
					printAddUpdateDeleteBusMsg("Line can't be deleted!",adminView.UpdateOrDeleteMessageLineBox, false);
				}
			}
		});
		
		adminView.DeleteLineButt4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int id = Integer.parseInt(adminView.label_lineTextBox3.getText());
				Line line = allLines.get(id);
				
				try {
					line.deleteFromDB();
					allLines.remove(id);
					printAddUpdateDeleteBusMsg("Line deleted from database!", adminView.UpdateOrDeleteMessageLineBox, true);
					listLines();
				} catch (SQLException e1) {
					printAddUpdateDeleteBusMsg("Line can't be deleted!",adminView.UpdateOrDeleteMessageLineBox, false);
				}
			}
		});
	}
	
	private void addNextBtnListenerLine() {
		adminView.LoadNextLineButt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(lineCounter + 4 < allLines.size()) { //dont go too far mayne
					lineCounter = lineCounter + 4;
					listLines();
				}
			}
		});
	}
	
	private void addPreviousBtnListenerLine() {
		adminView.LoadPreviousLineButt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(lineCounter - 4 > -1 ) { //dont go too far mayne
					lineCounter = lineCounter - 4;
					listLines();
				}
			}
		});
	}
	
	private void addAllDeleteTripListeners() {
		// TODO Auto-generated method stub
		adminView.DeleteTripButt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int id = Integer.parseInt(adminView.label_tripTextBox0.getText());
				Trip trip = allTrips.get(id);
				
				try {
					trip.deleteFromDB();
					allTrips.remove(id);
					printAddUpdateDeleteBusMsg("Trip deleted from database!", adminView.UpdateOrDeleteMessageTripBox, true);
					listTrips();
				} catch (SQLException e1) {
					printAddUpdateDeleteBusMsg("Trip can't be deleted!",adminView.UpdateOrDeleteMessageTripBox, false);
				}
			}
		});
		
		adminView.DeleteTripButt2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int id = Integer.parseInt(adminView.label_tripTextBox1.getText());
				Trip trip = allTrips.get(id);
				
				try {
					trip.deleteFromDB();
					allTrips.remove(id);
					printAddUpdateDeleteBusMsg("Trip deleted from database!", adminView.UpdateOrDeleteMessageTripBox, true);
					listTrips();
				} catch (SQLException e1) {
					printAddUpdateDeleteBusMsg("Trip can't be deleted!",adminView.UpdateOrDeleteMessageTripBox, false);
				}
			}
		});
		
		adminView.DeleteTripButt3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int id = Integer.parseInt(adminView.label_tripTextBox2.getText());
				Trip trip = allTrips.get(id);
				
				try {
					trip.deleteFromDB();
					allTrips.remove(id);
					printAddUpdateDeleteBusMsg("Trip deleted from database!", adminView.UpdateOrDeleteMessageTripBox, true);
					listTrips();
				} catch (SQLException e1) {
					printAddUpdateDeleteBusMsg("Trip can't be deleted!",adminView.UpdateOrDeleteMessageTripBox, false);
				}
			}
		});
		
		adminView.DeleteTripButt4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int id = Integer.parseInt(adminView.label_tripTextBox3.getText());
				Trip trip = allTrips.get(id);
				
				try {
					trip.deleteFromDB();
					allTrips.remove(id);
					printAddUpdateDeleteBusMsg("Trip deleted from database!", adminView.UpdateOrDeleteMessageTripBox, true);
					listTrips();
				} catch (SQLException e1) {
					printAddUpdateDeleteBusMsg("Trip can't be deleted!",adminView.UpdateOrDeleteMessageTripBox, false);
				}
			}
		});
	}
	
	private void addNextBtnListenerTrip() {
		adminView.LoadNextTripButt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tripCounter + 4 < allTrips.size()) { //dont go too far mayne
					tripCounter = tripCounter + 4;
					listTrips();
				}
			}
		});
	}
	
	private void addPreviousBtnListenerTrip() {
		adminView.LoadPreviousTripButt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tripCounter - 4 > -1 ) { //dont go too far mayne
					tripCounter = tripCounter - 4;
					listTrips();
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
	
	private void listLines() {
		JTextField[] starttextboxoflines = {adminView.StartLineTextBox1,adminView.StartLineTextBox2,
			adminView.StartLineTextBox3,adminView.StartLineTextBox4};
		JTextField[] destinationtextboxoflines = {
				adminView.DestinationLineTextBox1, adminView.DestinationLineTextBox2,
				adminView.DestinationLineTextBox3, adminView.DestinationLineTextBox4};
		JLabel[] linesIdLabels = {                             
				adminView.label_lineTextBox0, adminView.label_lineTextBox1,
				adminView.label_lineTextBox2, adminView.label_lineTextBox3};
		
		for (int i = 0; i < starttextboxoflines.length; i++) { // DA SE CLEAREAJU SVAKI PUT KAD SE POZOVE
			starttextboxoflines[i].setText("");
			destinationtextboxoflines[i].setText("");
			linesIdLabels[i].setText("");
		}
		
		LineCollectionToList();
		
		int j = 0;
		int counter = lineCounter;
		
		while(true) {
			if(j == 4) break; //DA ISPUSUJE SAMO 4 PO 4
			starttextboxoflines[j].setText(allLineList.get(counter).getStart().getName());
			destinationtextboxoflines[j].setText(allLineList.get(counter).getDestination().getName());
			linesIdLabels[j].setText(allLineList.get(counter).getID().toString());
			counter++;
			if(counter > allLines.size() - 1) { //KAD PREKORACI DA VRATI COUNTER I BREAKA
				counter = allLines.size() - 1;
				break;
			}
			j++;
		}
}
	private void listTrips() {
		JTextField[] triptextboxoflines = {adminView.TripLineTextBox1,adminView.TripLineTextBox2,
			adminView.TripLineTextBox3,adminView.TripLineTextBox4};
		JTextField[] triptextboxofbuses = {
				adminView.TripBusTextBox1, adminView.TripBusTextBox2,
				adminView.TripBusTextBox3, adminView.TripBusTextBox4};
		JTextField[] tripdeparturetextbox = {
				adminView.TripDepartureTextBox1, adminView.TripDepartureTextBox2,
				adminView.TripDepartureTextBox3, adminView.TripDepartureTextBox4};
		JTextField[] tripdurationtextbox = {
				adminView.TripDurationTextBox1, adminView.TripDurationTextBox2,
				adminView.TripDurationTextBox3, adminView.TripDurationTextBox4};
		
		JLabel[] tripIdLabels = {                             
				adminView.label_tripTextBox0, adminView.label_tripTextBox1,
				adminView.label_tripTextBox2, adminView.label_tripTextBox3};
		
		
		for (int i = 0; i < triptextboxoflines.length; i++) { // DA SE CLEAREAJU SVAKI PUT KAD SE POZOVE
			triptextboxoflines[i].setText("");
			triptextboxofbuses[i].setText("");
			tripdeparturetextbox[i].setText("");
			tripdurationtextbox[i].setText("");
			tripIdLabels[i].setText("");
		}
		
		TripCollectionToList();
		
		int j = 0;
		int counter = tripCounter;
		
		while(true) {
			if(j == 4) break; //DA ISPUSUJE SAMO 4 PO 4
			triptextboxoflines[j].setText(allTripList.get(counter).getLine().toString());
			triptextboxofbuses[j].setText(allTripList.get(counter).getBus().toString());
			tripdeparturetextbox[j].setText(allTripList.get(counter).getDeparturetime().toString());
			tripdurationtextbox[j].setText(allTripList.get(counter).getDurationtime().toString());
			tripIdLabels[j].setText(allTripList.get(counter).getID().toString());
			
			counter++;
			if(counter > allTrips.size() - 1) { //KAD PREKORACI DA VRATI COUNTER I BREAKA
				counter = allTrips.size() - 1;
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
				try {
					Line newLine;
					newLine = new Line(start,destination);
					allLines.put(newLine.getID(), newLine);
					printAddUpdateDeleteBusMsg("New line added!", adminView.AddNewLineLabel, true);
					listLines();
				} catch (IllegalArgumentException | SQLException e) {
					//Nebi trebalo biti Argument Exceptiona jer je nemoguce odabrat grad koji ne postoji ako se bira iz dropdowna.
					e.printStackTrace();
				}
				
			}
		});
	}
	
	private void addNewTripListener() {
		this.adminView.AddTripButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent argo0) {
				
				//Povuci odabranu liniju
				Line line = allLineList.get(adminView.AddLineTripComboBox.getSelectedIndex());
				
				//Povuci odabranu bus
				Bus bus = allBusNames.get(adminView.AddBusTripComboBox.getSelectedIndex());
				
				//Kreiranje tripa i dodavanje u kolekciju
				try {
					
					//Pretvori u Time vremena 
					if(adminView.AddDepartureTimeTrip.getText().matches("([01]?[0-9]|2[0-3]):[0-5][0-9]")
					   && adminView.AddDurationTimeTrip.getText().matches("([01]?[0-9]|2[0-3]):[0-5][0-9]")) {
						//Povuci departure time i duration time u polje stringa i pretvori u brojeve
						String[] departuretime = adminView.AddDepartureTimeTrip.getText().split(":");
						String[] durationtime = adminView.AddDurationTimeTrip.getText().split(":");
						
						int departureHours = Integer.parseInt(departuretime[0]);
						int departureMins = Integer.parseInt(departuretime[1]);
						
						int durationHours = Integer.parseInt(durationtime[0]);
						int durationMins = Integer.parseInt(durationtime[1]);
						
						
						//Pretvaranje u milisekunde zbog konstruktora Time -> prima vrijeme u milisekundama -> prelose
						int durationMiliSec = durationHours*60*60*1000 + durationMins*60*1000;
						int departureMiliSec = departureHours*60*60*1000 + departureMins*60*1000;
						
						
						Time duration = new Time(durationMiliSec-3600000); //treba oduzet 1 sat jer se inace u bazi doda 1 sat viska
						Time departure = new Time(departureMiliSec-3600000); // zasto je to tako? neznam
						
						//Kreiranje novog tripa i dodavanje u kolekciju
						Trip newTrip;
						newTrip = new Trip(bus, line, departure, duration);
						allTrips.put(newTrip.getID(), newTrip);
						printAddUpdateDeleteBusMsg("New trip added!", adminView.AddNewTripLabel, true);
						listTrips();
						
					}
					else {
						throw new IllegalArgumentException("Wrong type of time! Hint: HH:MM!");
					}
				} catch (IllegalArgumentException e) {
					printAddUpdateDeleteBusMsg(e.getMessage(),adminView.AddNewTripLabel, false);
				}
				catch(SQLException e1) {
					e1.printStackTrace();
				}
				
				//Ocisti text boxove
				adminView.AddDepartureTimeTrip.setText("");
				adminView.AddDurationTimeTrip.setText("");
			}
		});
	}
	
    
	private void addBusFormListener() {
		this.adminView.AdminBusButt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent argo0) {
				adminView.AdminCityPanel.setVisible(false);
				adminView.AdminLinePanel.setVisible(false);
				adminView.AdminTripPanel.setVisible(false);
				adminView.AdminBusPanel.setVisible(true);
				
				adminView.AdminBusButt.setOpaque(true);
				adminView.AdminTripButt.setOpaque(false);
				adminView.AdminCityButt.setOpaque(false);
				adminView.AdminLineButt.setOpaque(false);
				
				adminView.AdminCityButt.setBorder(new LineBorder(SystemColor.textHighlight, 2));
				adminView.AdminLineButt.setBorder(new LineBorder(SystemColor.textHighlight, 2));
				adminView.AdminTripButt.setBorder(new LineBorder(SystemColor.textHighlight, 2));
				
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
				adminView.AdminTripPanel.setVisible(false);
				adminView.AdminCityPanel.setVisible(true);
				
				adminView.AdminCityButt.setOpaque(true);
				adminView.AdminTripButt.setOpaque(false);
				adminView.AdminBusButt.setOpaque(false);
				adminView.AdminLineButt.setOpaque(false);
				
				adminView.AdminBusButt.setBorder(new LineBorder(SystemColor.textHighlight, 2));
				adminView.AdminLineButt.setBorder(new LineBorder(SystemColor.textHighlight, 2));
				adminView.AdminTripButt.setBorder(new LineBorder(SystemColor.textHighlight, 2));
				
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
				adminView.AdminTripPanel.setVisible(false);
				adminView.AdminLinePanel.setVisible(true);
				
				adminView.AdminLineButt.setOpaque(true);
				adminView.AdminTripButt.setOpaque(false);
				adminView.AdminBusButt.setOpaque(false);
				adminView.AdminCityButt.setOpaque(false);
				
				//popunjavanje dropdown menija postojecim gradovima
				CityCollectionToList();
				listLines();
				
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
				adminView.AdminTripButt.setBorder(new LineBorder(SystemColor.textHighlight, 2));
				
				adminView.AddNewLineLabel.setText("");
				adminView.UpdateOrDeleteMessageLineBox.setText("");
			}
		});
	}
	
	private void addTripFormListener() {
		this.adminView.AdminTripButt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent argo0) {
				adminView.AdminBusPanel.setVisible(false);
				adminView.AdminCityPanel.setVisible(false);
				adminView.AdminLinePanel.setVisible(false);
				adminView.AdminTripPanel.setVisible(true);
				
				adminView.AdminTripButt.setOpaque(true);
				adminView.AdminLineButt.setOpaque(false);
				adminView.AdminBusButt.setOpaque(false);
				adminView.AdminCityButt.setOpaque(false);
				
				//popunjavanje dropdown menija postojecim gradovima
				TripCollectionToList();
				listTrips();
				
				//Ocisti dropdowne
				adminView.AddLineTripComboBox.removeAllItems();
				adminView.AddBusTripComboBox.removeAllItems();
				
				//Popuni dropdowne svim imenima linija i buseva
				for(int i=0;i<allLineList.size();i++) {
				    adminView.AddLineTripComboBox.addItem(allLineList.get(i).toString());
				}
				
				for(int i=0;i<allBusNames.size();i++) {
					adminView.AddBusTripComboBox.addItem(allBusNames.get(i).toString());
				}
				
				adminView.AdminBusButt.setBorder(new LineBorder(SystemColor.textHighlight, 2));
				adminView.AdminCityButt.setBorder(new LineBorder(SystemColor.textHighlight, 2));
				adminView.AdminLineButt.setBorder(new LineBorder(SystemColor.textHighlight, 2));
				
				printAddUpdateDeleteBusMsg("HINT: Departure and duration must be: HH:MM type", adminView.AddNewTripLabel, true);
				adminView.UpdateOrDeleteMessageTripBox.setText("");
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
