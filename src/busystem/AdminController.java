package busystem;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		this.addCityListener();
		this.addBusListener();
	}

	private void addBusListener() {
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

	private void addCityListener() {
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
