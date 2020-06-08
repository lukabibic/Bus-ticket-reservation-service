package busystem;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.border.LineBorder;

import busystem.models.*;

public class Main {

	public static void main(String[] args) {
		
		//Otvaramo konekciju na bazu
		try {
			DBconnect.openDbConnection();
		} catch (SQLException e1) {
			e1.printStackTrace(); //izbaci gresku ako se nemoze povezat na bazu
		}	
		//Kreiramo glavni main controller koji poziva ostale
		MainController controller = new MainController();
	}
}

