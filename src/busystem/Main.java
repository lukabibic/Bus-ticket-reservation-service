package busystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import busystem.models.*;

public class Main {

	public static void main(String[] args) {
		GUI_LoginInterface sucelje = new GUI_LoginInterface();
		sucelje.setVisible(true);
		
		sucelje.registerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//validation(); //provjera validacije
			}
		});
		
		sucelje.loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ToBeImplemented
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
