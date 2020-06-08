package busystem;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Map.Entry;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import busystem.models.*;

public class UserController {
	private User user;
	private TreeMap<Integer, City> allCities;
	private TreeMap<Integer, Bus> allBuses;
	private TreeMap<Integer, Line> allLines;
	private TreeMap<Integer, Trip> allTrips;
	
	ArrayList<Trip> allTripList = new ArrayList<Trip>();
	ArrayList<Ticket> allTickets = new ArrayList<Ticket>();;
	ArrayList<City> allCityNames = new ArrayList<City>();;
	
	private UserGUI userView;
	
	int tripCounter = 0;
	int ticketCounter = 0;
	
	public UserController(User user, MainController mainController) {
		this.user = user;
		
		//dohvati trips, tickets iz baze..
		try {
			this.allCities = City.getAll();
			this.allBuses = Bus.getAll();
			Line.setCityCollection(allCities);
			this.allLines = Line.getAll();
			Trip.setBusCollection(allBuses);
			Trip.setLineCollection(allLines);
			this.allTrips = Trip.getAll();
			Ticket.setTripCollection(allTrips);
			this.allTickets = Ticket.getUsersTickets(this.user);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		userView = new UserGUI();
		userView.setVisible(true);
		
		//postavi username logiranog korisnika u button
		userView.UserProfileButt.setText(this.user.getUsername());
		
		//popuni Quantity combo boxeve
		String[] numberofticket = {"1","2","3"};
		for(int i = 0; i < numberofticket.length; i++) {
			userView.NumberOfTicketComboBox1.addItem(numberofticket[i]);
			userView.NumberOfTicketComboBox2.addItem(numberofticket[i]);
			userView.NumberOfTicketComboBox3.addItem(numberofticket[i]);
			userView.NumberOfTicketComboBox4.addItem(numberofticket[i]);
		}
		
		//Popuni dropdowne gradova na Ticket panelu
		//Popuni dropdowne svim imenima gradova
		CityCollectionToList();
		for(int i=0;i<allCityNames.size();i++) {
			userView.ChooseStartCityTicketComboBox.addItem(allCityNames.get(i).getName());
		    userView.ChooseDestinationCityTicketComboBox.addItem(allCityNames.get(i).getName());
		}
		
		//Ispisi poruku na Ticket tab
		printMsg("HINT: Date must be: DD.MM.YY type", userView.SearchTripLabel, true);
		
		//logout listener
		this.addLogoutListener(mainController);
		
		//listeneri za navbar
		this.addBuyTicketFormListener();
		this.addUserTicketFormListener();
		
		//listener za Search button
		this.addSearchTripButtListener();
		
		//listener za Reserve buttone
		this.addReserveTicketButtListener();
		
		//listener za Delete buttone
		this.addDeleteTicketButtListener();
		
		//listeneri za next i previous buttone
		this.addNextBtnListenerTrip();
		this.addPreviousBtnListenerTrip();
		this.addNextBtnListenerTickets();
		this.addPreviousBtnListenerTickets();
		
	}
	
	private void CityCollectionToList() {
		allCityNames.clear();
		for (Entry<Integer, City> entry : allCities.entrySet()) {
		    City value = entry.getValue();
		    
		    allCityNames.add(value);
		}
	}
	
	private void MakeTripList(City startcity, City destinationcity) {
		//Povuci tripove koji sadrze odabrani pocetni i konacni grad iz kolekcije i upisi u listu tripova za ispis
		allTripList.clear();
		for (Entry<Integer, Trip> entry : allTrips.entrySet()) {
	    Trip value = entry.getValue();
	    
	    if(value.getLine().getStart() == startcity && value.getLine().getDestination() == destinationcity) {
		    allTripList.add(value);
	    }
		}
	}
	
	private void printMsg(String msg, JLabel label, boolean success) {
		if(success) {
			label.setForeground(Color.GREEN);
		}
		else {
			label.setForeground(Color.RED);
		}
		label.setText(msg);
	}
	
	private boolean checkDateType() {
		if(userView.ChooseDateTicketTextBox.getText().matches("[0-3]?[0-9].[0-3]?[0-9].[0-9]{4}.")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private void listTrips() {
		
		JTextField[] triplinenametextbox = {userView.TripLineTextBox1,userView.TripLineTextBox2,
				userView.TripLineTextBox3,userView.TripLineTextBox4};
		JTextField[] tripbusmodeltextbox = {userView.TripBusTextBox1,userView.TripBusTextBox2,
				userView.TripBusTextBox3,userView.TripBusTextBox4};
		JTextField[] tripdepartiontextbox = {userView.TripDepartureTimeTextBox1,userView.TripDepartureTimeTextBox2,
				userView.TripDepartureTimeTextBox3,userView.TripDepartureTimeTextBox4};
		JTextField[] tripdurationtextbox = {userView.TripDurationTimeTextBox1,userView.TripDurationTimeTextBox2,
				userView.TripDurationTimeTextBox3,userView.TripDurationTimeTextBox4};
		
		for (int i = 0; i < triplinenametextbox.length; i++) { // DA SE CLEAREAJU SVAKI PUT KAD SE POZOVE
			triplinenametextbox[i].setText("");
			tripbusmodeltextbox[i].setText("");
			tripdepartiontextbox[i].setText("");
			tripdurationtextbox[i].setText("");
		}
		
		if(allTripList.size() == 0) { //Ako ne postoji niti jedan trip sa odabranim gradovima izadi
			printMsg("There is no trip with selected cities!", userView.SearchTripLabel, false);
			return;
		}
		else {
			int j = 0;
			int counter = tripCounter;
			
			while(true) {
				if(j == 4) break; //DA ISPUSUJE SAMO 4 PO 4
				triplinenametextbox[j].setText(allTripList.get(counter).getLine().toString());
				tripbusmodeltextbox[j].setText(allTripList.get(counter).getBus().toString());
				tripdepartiontextbox[j].setText(allTripList.get(counter).getDeparturetime().toString());
				tripdurationtextbox[j].setText(allTripList.get(counter).getDurationtime().toString());
				
				counter++;
				if(counter > allTripList.size() - 1) { //KAD PREKORACI DA VRATI COUNTER I BREAKA
					counter = allTripList.size() - 1;
					break;
				}
				j++;
				}
		}
	}
	
	private void listUserTicket() {
		
		JTextField[] reservedtriplinenametextbox = {userView.ReservedTripLineTextBox1,userView.ReservedTripLineTextBox2,
				userView.ReservedTripLineTextBox3,userView.ReservedTripLineTextBox4};
		JTextField[] reservedtripbusmodeltextbox = {userView.ReservedTripBusTextBox1,userView.ReservedTripBusTextBox2,
				userView.ReservedTripBusTextBox3,userView.ReservedTripBusTextBox4};
		JTextField[] reservedtripdepartiontextbox = {userView.ReservedTripDepartureTimeTextBox1,userView.ReservedTripDepartureTimeTextBox2,
				userView.ReservedTripDepartureTimeTextBox3,userView.ReservedTripDepartureTimeTextBox4};
		JTextField[] reservedtripdurationtextbox = {userView.ReservedTripDurationTimeTextBox1,userView.ReservedTripDurationTimeTextBox2,
				userView.ReservedTripDurationTimeTextBox3,userView.ReservedTripDurationTimeTextBox4};
		JTextField[] reservedtripdatetextbox = {userView.ReservedDateTextBox1, userView.ReservedDateTextBox2,
				userView.ReservedDateTextBox3,userView.ReservedDateTextBox4};
		
		for (int i = 0; i < reservedtriplinenametextbox.length; i++) { // DA SE CLEAREAJU SVAKI PUT KAD SE POZOVE
			reservedtriplinenametextbox[i].setText("");
			reservedtripbusmodeltextbox[i].setText("");
			reservedtripdepartiontextbox[i].setText("");
			reservedtripdurationtextbox[i].setText("");
			reservedtripdatetextbox[i].setText("");
		}
		
		int j = 0;
		int counter = ticketCounter;
		
		while(true) {
			if(j == 4) break; //DA ISPUSUJE SAMO 4 PO 4
			reservedtriplinenametextbox[j].setText(allTickets.get(counter).getTrip().getLine().toString());
			reservedtripbusmodeltextbox[j].setText(allTickets.get(counter).getTrip().getBus().toString());
			reservedtripdepartiontextbox[j].setText(allTickets.get(counter).getTrip().getDeparturetime().toString());
			reservedtripdurationtextbox[j].setText(allTickets.get(counter).getTrip().getDurationtime().toString());
			reservedtripdatetextbox[j].setText(allTickets.get(counter).getDateFormat());
			counter++;
			if(counter > allTickets.size() - 1) { //KAD PREKORACI DA VRATI COUNTER I BREAKA
				counter = allTickets.size() - 1;
				break;
			}
			j++;
			}
	}
	
	
	private void addBuyTicketFormListener() {
		userView.UserProfileButt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//mijenjanje vidljivosti panela
				userView.UserReservedTicketPanel.setVisible(true);
				userView.UserTicketPanel.setVisible(false);
				
				userView.UserProfileButt.setOpaque(true);
				userView.UserTicketButt.setOpaque(false);
				
				//popunjavanje GUI-ja sa rezerviranim kartama korisnika
				listUserTicket();
				
				//Resetiraj labele za ispis poruka
				userView.ReservedTripLabel.setText("");
				
			}
		});
	}
	
	private void addUserTicketFormListener() {
		userView.UserTicketButt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//mijenjanje vidljivosti panela
				userView.UserTicketPanel.setVisible(true);
				userView.UserReservedTicketPanel.setVisible(false);
				
				userView.UserTicketButt.setOpaque(true);
				userView.UserProfileButt.setOpaque(false);
				
				//kreiranje liste gradova i tripova iz njihovih kolekcija
				CityCollectionToList();
				
				//Ocisti dropdown -> kada se mijenjaju paneli
				userView.ChooseStartCityTicketComboBox.removeAllItems();
				userView.ChooseDestinationCityTicketComboBox.removeAllItems();
				
				//Popuni dropdowne svim imenima gradova
				for(int i=0;i<allCityNames.size();i++) {
					userView.ChooseStartCityTicketComboBox.addItem(allCityNames.get(i).getName());
				    userView.ChooseDestinationCityTicketComboBox.addItem(allCityNames.get(i).getName());
				}
				
				//Resetiraj labele  i text boxove za ispis
				JTextField[] triplinenametextbox = {userView.TripLineTextBox1,userView.TripLineTextBox2,
						userView.TripLineTextBox3,userView.TripLineTextBox4};
				JTextField[] tripbusmodeltextbox = {userView.TripBusTextBox1,userView.TripBusTextBox2,
						userView.TripBusTextBox3,userView.TripBusTextBox4};
				JTextField[] tripdepartiontextbox = {userView.TripDepartureTimeTextBox1,userView.TripDepartureTimeTextBox2,
						userView.TripDepartureTimeTextBox3,userView.TripDepartureTimeTextBox4};
				JTextField[] tripdurationtextbox = {userView.TripDurationTimeTextBox1,userView.TripDurationTimeTextBox2,
						userView.TripDurationTimeTextBox3,userView.TripDurationTimeTextBox4};
				
				for (int i = 0; i < triplinenametextbox.length; i++) { // DA SE CLEAREAJU SVAKI PUT KAD SE POZOVE
					triplinenametextbox[i].setText("");
					tripbusmodeltextbox[i].setText("");
					tripdepartiontextbox[i].setText("");
					tripdurationtextbox[i].setText("");
				}
				
				userView.NumberOfTicketComboBox1.setSelectedIndex(0);
				userView.NumberOfTicketComboBox2.setSelectedIndex(0);
				userView.NumberOfTicketComboBox3.setSelectedIndex(0);
				userView.NumberOfTicketComboBox4.setSelectedIndex(0);
				
				printMsg("HINT: Date must be: DD.MM.YY type", userView.SearchTripLabel, true);
				userView.TripReservationLabel.setText("");
				userView.ChooseDateTicketTextBox.setText("");
			}
		});
	}
	
	private void addSearchTripButtListener() {
		userView.SearchTripButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Pocetni grad
				 City startcity = allCityNames.get(userView.ChooseStartCityTicketComboBox.getSelectedIndex());
				//Zavrsni grad
				 City destinationcity = allCityNames.get(userView.ChooseDestinationCityTicketComboBox.getSelectedIndex());
				 //Izlistaj tripove sa odabranim gradovima
				 MakeTripList(startcity,destinationcity);
				 //Ispisi na GUI
				 listTrips();
			}
		});
	}
	
	private void addReserveTicketButtListener() {
		
		userView.ReserveTicketButt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
				 if(checkDateType()) {
					//Dohvati datum,trip i broj karata
					 String[] dateString = userView.ChooseDateTicketTextBox.getText().split("[.]");
					 Date tripdate = Date.valueOf(dateString[2] + "-" + dateString[1] + "-" + dateString[0]);
					 int quantity = Integer.parseInt((String) userView.NumberOfTicketComboBox1.getSelectedItem());
					 Trip trip = allTripList.get(tripCounter);
					 
					 for(int i = 0; i < quantity; i++) {
						 Ticket newticket = new Ticket(trip, user, tripdate);
						 allTickets.add(newticket);
					 }
					 
					 printMsg("Ticket reserved!", userView.SearchTripLabel, true);
				 }
				 else {
					 throw new IllegalArgumentException("Wrong type of Date! Hint: DD.MM.YY. !");
				 }
				}
				catch (IllegalArgumentException e1) {
					printMsg(e1.getMessage(), userView.SearchTripLabel, false);
				}  catch (SQLException e1) {
					e1.printStackTrace();
				}  catch (Exception e1) {
					printMsg(e1.getMessage(), userView.TripReservationLabel, false);
				}
			}
		});
		
		userView.ReserveTicketButt2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					 if(checkDateType()) {
						 //Dohvati datum,trip i broj karata
						 String[] dateString = userView.ChooseDateTicketTextBox.getText().split("[.]");
						 Date tripdate = Date.valueOf(dateString[2] + "-" + dateString[1] + "-" + dateString[0]);
						 int quantity = Integer.parseInt((String) userView.NumberOfTicketComboBox2.getSelectedItem());
						 Trip trip = allTripList.get(tripCounter + 1);
						 
						 for(int i = 0; i < quantity; i++) {
							 Ticket newticket = new Ticket(trip, user, tripdate);
							 allTickets.add(newticket);
						 }
						 
						 printMsg("Ticket reserved!", userView.SearchTripLabel, true);
					 }
					 else {
						 throw new IllegalArgumentException("Wrong type of Date! Hint: DD.MM.YY. !");
					 }
				}
				catch (IllegalArgumentException e1) {
					printMsg(e1.getMessage(), userView.SearchTripLabel, false);
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					printMsg(e1.getMessage(), userView.TripReservationLabel, false);
				}
			}
		});

		userView.ReserveTicketButt3.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					 if(checkDateType()) {
						//Dohvati datum,trip i broj karata
						 String[] dateString = userView.ChooseDateTicketTextBox.getText().split("[.]");
						 Date tripdate = Date.valueOf(dateString[2] + "-" + dateString[1] + "-" + dateString[0]);
						 int quantity = Integer.parseInt((String) userView.NumberOfTicketComboBox3.getSelectedItem());
						 Trip trip = allTripList.get(tripCounter + 2);
						 
						 for(int i = 0; i < quantity; i++) {
							 Ticket newticket = new Ticket(trip, user, tripdate);
							 allTickets.add(newticket);
						 }
						 
						 printMsg("Ticket reserved!", userView.SearchTripLabel, true);
					 }
					 else {
						 throw new IllegalArgumentException("Wrong type of Date! Hint: DD.MM.YY. !");
					 }
				}
				catch (IllegalArgumentException e1) {
					printMsg(e1.getMessage(), userView.SearchTripLabel, false);
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					printMsg(e1.getMessage(), userView.TripReservationLabel, false);
				}
			}
		});

		userView.ReserveTicketButt4.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					 if(checkDateType()) {
						//Dohvati datum,trip i broj karata
						 String[] dateString = userView.ChooseDateTicketTextBox.getText().split("[.]");
						 Date tripdate = Date.valueOf(dateString[2] + "-" + dateString[1] + "-" + dateString[0]);
						 int quantity = Integer.parseInt((String) userView.NumberOfTicketComboBox4.getSelectedItem());
						 Trip trip = allTripList.get(tripCounter + 3);
						 
						 for(int i = 0; i < quantity; i++) {
							 Ticket newticket = new Ticket(trip, user, tripdate);
							 allTickets.add(newticket);
						 }
						 
						 printMsg("Ticket reserved!", userView.SearchTripLabel, true);
					 }
					 else {
						 throw new IllegalArgumentException("Wrong type of Date! Hint: DD.MM.YY. !");
					 }
				}
				catch (IllegalArgumentException e1) {
					printMsg(e1.getMessage(), userView.SearchTripLabel, false);
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					printMsg(e1.getMessage(), userView.TripReservationLabel, false);
				}
			}
		});
	}
	
	private void addNextBtnListenerTrip() {
		userView.LoadNextTripButt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tripCounter + 4 < allTripList.size()) { 
					tripCounter = tripCounter + 4;
					listTrips();
				}
			}
		});
	}
	
	private void addPreviousBtnListenerTrip() {
		userView.LoadPreviousTripButt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tripCounter - 4 > -1) { 
					tripCounter = tripCounter - 4;
					listTrips();
				}
			}
		});
	}
	
	private void addDeleteTicketButtListener() {
		userView.ReservedTicketDeleteButt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//dohvati kartu
				 int id = ticketCounter;
				 Ticket ticket = allTickets.get(id);
				 //Izbrisi iz baze
				 try {
						ticket.deleteFromDB();
						allTickets.remove(id);
						printMsg("Ticket deleted from database!", userView.ReservedTripLabel, true);
						listUserTicket();
						
					} catch (SQLException e1) {
						printMsg("Ticket can't be deleted!",userView.ReservedTripLabel, false);
					}
			}
		});
		
		userView.ReservedTicketDeleteButt2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//dohvati kartu
				 int id = ticketCounter + 1;
				 Ticket ticket = allTickets.get(id);
				 //Izbrisi iz baze
				 try {
						ticket.deleteFromDB();
						allTickets.remove(id);
						printMsg("Ticket deleted from database!", userView.ReservedTripLabel, true);
						listUserTicket();
						
					} catch (SQLException e1) {
						printMsg("Ticket can't be deleted!",userView.ReservedTripLabel, false);
					}
			}
		});
		
		userView.ReservedTicketDeleteButt3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//dohvati kartu
				 int id = ticketCounter + 2;
				 Ticket ticket = allTickets.get(id);
				 //Izbrisi iz baze
				 try {
						ticket.deleteFromDB();
						allTickets.remove(id);
						printMsg("Ticket deleted from database!", userView.ReservedTripLabel, true);
						listUserTicket();
						
					} catch (SQLException e1) {
						printMsg("Ticket can't be deleted!",userView.ReservedTripLabel, false);
					}
			}
		});
		
		userView.ReservedTicketDeleteButt4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//dohvati kartu
				 int id = ticketCounter + 3;
				 Ticket ticket = allTickets.get(id);
				 //Izbrisi iz baze
				 try {
						ticket.deleteFromDB();
						allTickets.remove(id);
						printMsg("Ticket deleted from database!", userView.ReservedTripLabel, true);
						listUserTicket();
						
					} catch (SQLException e1) {
						printMsg("Ticket can't be deleted!",userView.ReservedTripLabel, false);
					}
			}
		});
	}
	
	private void addNextBtnListenerTickets() {
		userView.LoadNextReservedTicketButt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(ticketCounter + 4 < allTickets.size()) { 
					ticketCounter = ticketCounter + 4;
					listUserTicket();
				}
			}
		});
	}
	
	private void addPreviousBtnListenerTickets() {
		userView.LoadPreviousReservedTicketButt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(ticketCounter - 4 > -1) { 
					ticketCounter = ticketCounter - 4;
					listUserTicket();
				}
			}
		});
	}
	
	//ovo povezat sa logout button
	private void addLogoutListener(MainController mainController) {
		//kad se korisnik logouta ugasi userGUI i ponovo upali login controller koji pali loginGUI
		userView.btnLogout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				userView.setVisible(false);
				mainController.userController = null; 
				mainController.loginController = new LoginController(mainController);
			}
		});
	}
}
