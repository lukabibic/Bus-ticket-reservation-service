package busystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TreeMap;
import busystem.models.*;

public class UserController {
	private User user;
	private TreeMap<Integer, Trip> allTrips;
	private ArrayList<Ticket> usersTickets;
	private UserGUI userView;

	public UserController(User user, MainController mainController) {
		this.user = user;

		//dohvati trips, tickets iz baze..

		userView = new UserGUI();
		userView.setVisible(true);
		this.addLogoutListener(mainController);
		//aktiviraj ostale listenere... 
		 
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

	//ostali listeneri...
}
