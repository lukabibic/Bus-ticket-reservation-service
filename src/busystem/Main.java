package busystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import busystem.models.*;

public class Main {

	public static void main(String[] args) {
		GUI_LoginInterface sucelje = new GUI_LoginInterface();
		sucelje.setVisible(true);
		
		//Povezivanje na bazu
		try {
			DBconnect.openDbConnection();
		} catch (SQLException e1) {
			e1.printStackTrace(); //izbaci gresku ako se nemoze povezat na bazu
		}
		
		//Implementacija buttona -> bolje da bude u GUI kontroleru
		sucelje.registerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					User korisnik = new User(sucelje.regUserTextBox.getText(), sucelje.regFirstNameTextBox.getText(),sucelje.regLastNameTextBox.getText(),sucelje.regPassField.getText(),sucelje.regEmailTextBox.getText());
				} 
				catch (SQLException e1) {
					System.out.println("Error with database!");
				}
				catch(IllegalArgumentException e2) {
					if(e2.getMessage() == "Invalid username!" || e2.getMessage() == "Username is already taken!") {
						sucelje.regUserErrLabel.setText(e2.getMessage());
						sucelje.regUserErrLabel.setVisible(true);
						sucelje.regEmailErrLabel.setVisible(false);
					}
					else {
						sucelje.regEmailErrLabel.setText(e2.getMessage());
						sucelje.regEmailErrLabel.setVisible(true);
						sucelje.regUserErrLabel.setVisible(false);
					}
				}
			}
		});
		
		sucelje.loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					User korisnik = new User(sucelje.logUserTextBox.getText(),sucelje.logPassField.getText());
				} 
				catch (SQLException e1) {
					System.out.println("Error with database!");
				}
				catch(IllegalArgumentException e2) {
					sucelje.logErrLabel.setText(e2.getMessage());
					sucelje.logErrLabel.setVisible(true);
				}
				
			}
		});
		
		try {
			User korisnik = new User("kuku", "Mario", "Maricevic", "mario", "mario@gmail.com");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
