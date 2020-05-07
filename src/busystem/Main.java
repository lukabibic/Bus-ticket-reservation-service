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
		ControllerClass controller = new ControllerClass();
		
		sucelje.setVisible(true);
		sucelje.getRootPane().setDefaultButton(sucelje.loginBtn); //pozvat login na enter
		
		//Povezivanje na bazu
		try {
			DBconnect.openDbConnection();
		} catch (SQLException e1) {
			e1.printStackTrace(); //izbaci gresku ako se nemoze povezat na bazu
		}
		
		//ENTER BUTTON DA POZIVA LOGIN/REGISTER
		controller.callSignInOnEnter(sucelje);
		controller.callRegisterOnEnter(sucelje);	
		
		//LISTENER ZA LOGIN/REGISTER
		controller.signinBtn(sucelje);
		controller.registerBtn(sucelje);
		
	}
}

