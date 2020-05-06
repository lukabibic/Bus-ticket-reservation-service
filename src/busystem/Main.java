package busystem;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.border.LineBorder;

import busystem.models.*;

public class Main {

	public static void main(String[] args) {
		GUI_LoginInterface sucelje = new GUI_LoginInterface();
		sucelje.setVisible(true);
		sucelje.getRootPane().setDefaultButton(sucelje.loginBtn); //pozvat login na enter
		
			//Povezivanje na bazu
			try {
				DBconnect.openDbConnection();
			} catch (SQLException e1) {
				e1.printStackTrace(); //izbaci gresku ako se nemoze povezat na bazu
			}
			
			sucelje.signInBtn.addActionListener(new ActionListener() { //event listener prebacen ovdje kako bi se mijenjao defaultButton za enter
				public void actionPerformed(ActionEvent e) {
					sucelje.logform.setVisible(true);
					sucelje.regform.setVisible(false);
					sucelje.signInBtn.setOpaque(true);
					sucelje.signUpBtn.setOpaque(false);
					sucelje.signUpBtn.setBorder(new LineBorder(SystemColor.textHighlight, 2));		
					sucelje.getRootPane().setDefaultButton(sucelje.loginBtn); //pozvat login na enter
				}
			});
			
			sucelje.signUpBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					sucelje.regform.setVisible(true);
					sucelje.logform.setVisible(false);
					sucelje.signUpBtn.setOpaque(true);
					sucelje.signInBtn.setOpaque(false);
					sucelje.signInBtn.setBorder(new LineBorder(SystemColor.textHighlight, 2));
					sucelje.getRootPane().setDefaultButton(sucelje.registerBtn); //pozvat register na enter
				}
			});
			
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
						if(korisnik.getUsername().contentEquals("admin")) {
							AdminGUI adminScreen = new AdminGUI();
							adminScreen.setVisible(true);
							sucelje.setVisible(false);
						}
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
		}
	}

