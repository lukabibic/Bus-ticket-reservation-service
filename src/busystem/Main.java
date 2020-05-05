package busystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import busystem.models.*;

public class Main {

	public static void main(String[] args) {
		GUI_LoginInterface sucelje = new GUI_LoginInterface();
		HomeWindow mainHomeWindow = new HomeWindow();
		
		sucelje.setVisible(true);
		
		sucelje.registerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//validation(); //provjera validacije
			}
		});
		
		sucelje.loginBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				boolean thrown = false;
				try {
					User korisnikUser = new User(sucelje.logUserTextBox.getText(), sucelje.logPassField.getText());
					sucelje.hide();
					
				}
				//Change printStackTrace to something more specific
				
				
				catch (IllegalArgumentException i1) {
					i1.printStackTrace();
					thrown = true;
				}
				
				catch (RuntimeException r1) {
					// TODO: handle exception
					r1.printStackTrace();
					thrown = true;
				}
				
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					thrown = true;
				}
				System.out.println("thrown = " + thrown);
				if(!thrown) {
					mainHomeWindow.show();
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
