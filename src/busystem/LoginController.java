package busystem;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.border.LineBorder;

import busystem.models.User;

public class LoginController {
	private LoginGUI loginView;
	private User user;
	public LoginController(MainController mainController) {
		// TODO Auto-generated constructor stub
		loginView = new LoginGUI();
		loginView.setVisible(true);
		this.addLoginListener(mainController);
		this.addRegisterListener(mainController);
		
		//aktiviraj ostale listenere za loginGUI...
		this.AddcallRegisterOnEnterListener();
		this.addCallSignInOnEnterListener();
		loginView.getRootPane().setDefaultButton(loginView.loginBtn); //pozvat login na enter
	}
	
	private void addLoginListener(MainController mainController) {
		this.loginView.loginBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//prvo stvori usera, provjere itd...
				try {
					user = new User(loginView.logUserTextBox.getText(), loginView.logPassField.getText());
					//ovisno o useru pokreni novi kontroler koji onda pokrece i novi GUI
					if (user.isAdmin()) {
						mainController.adminController = new AdminController(user, mainController);
					} else {
						mainController.userController = new UserController(user, mainController);
					}
					//gasi loginGUI
					loginView.setVisible(false);
					mainController.loginController = null;
				} catch (SQLException e1) {
					System.out.println("Error with database!");
				}
				catch(IllegalArgumentException e2) {
					loginView.logErrLabel.setText(e2.getMessage());
					loginView.logErrLabel.setVisible(true);
				}
			
			}
		}); 
	}
	
	private void addRegisterListener(MainController mainController) {
		this.loginView.registerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					user = new User(loginView.regUserTextBox.getText(), loginView.regFirstNameTextBox.getText(),
							loginView.regLastNameTextBox.getText(),loginView.regPassField.getText(),
							loginView.regEmailTextBox.getText());
					
					loginView.setVisible(false);
					mainController.loginController = null;
					mainController.userController = new UserController(user, mainController);
				} 
				catch (SQLException e1) {
					System.out.println("Error with database!");
				}
				catch(IllegalArgumentException e2) {
					if(e2.getMessage() == "Invalid username!" || e2.getMessage() == "Username is already taken!") {
						loginView.regUserErrLabel.setText(e2.getMessage());
						loginView.regUserErrLabel.setVisible(true);
						loginView.regEmailErrLabel.setVisible(false);
					}
					else {
						loginView.regEmailErrLabel.setText(e2.getMessage());
						loginView.regEmailErrLabel.setVisible(true);
						loginView.regUserErrLabel.setVisible(false);
					}
				}
			}
		});
	}
	
	public void addCallSignInOnEnterListener() {
			this.loginView.signInBtn.addActionListener(new ActionListener() { //event listener prebacen ovdje kako bi se mijenjao defaultButton za enter
				@Override
				public void actionPerformed(ActionEvent e) {
					loginView.logform.setVisible(true);
					loginView.regform.setVisible(false);
					loginView.signInBtn.setOpaque(true);
					loginView.signUpBtn.setOpaque(false);
					loginView.signUpBtn.setBorder(new LineBorder(SystemColor.textHighlight, 2));		
					loginView.getRootPane().setDefaultButton(loginView.loginBtn); //pozvat login na enter
				}
			});
	}

	
	
	public void AddcallRegisterOnEnterListener() {
		this.loginView.signUpBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loginView.regform.setVisible(true);
				loginView.logform.setVisible(false);
				loginView.signUpBtn.setOpaque(true);
				loginView.signInBtn.setOpaque(false);
				loginView.signInBtn.setBorder(new LineBorder(SystemColor.textHighlight, 2));
				loginView.getRootPane().setDefaultButton(loginView.registerBtn); //pozvat register na enter
			}
		});
	}

	/*public void signinBtn(LoginGUI sucelje) {
		sucelje.loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					korisnik = new User(sucelje.logUserTextBox.getText(),sucelje.logPassField.getText());
					if(korisnik.isAdmin()) {
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
	}*/

	/*public void registerBtn(LoginGUI sucelje) {
		//Implementacija buttona -> bolje da bude u GUI kontroleru
				sucelje.registerBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							korisnik = new User(sucelje.regUserTextBox.getText(), sucelje.regFirstNameTextBox.getText(),sucelje.regLastNameTextBox.getText(),sucelje.regPassField.getText(),sucelje.regEmailTextBox.getText());
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
	}*/
	
}
