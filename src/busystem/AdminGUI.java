package busystem;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import busystem.models.*;

public class AdminGUI extends JFrame{
	
	private JPanel mainPanel;
	private JPanel AdminNavbarPanel;
	private JPanel AdminOperationPanel;
	private JPanel AdminCityPanel;
	private JButton AdminCityButt;
	private JButton btnNewButton;
	private JPanel AdminBusPanel;
	/**
	 * Create the frame.
	 */
	
	public AdminGUI() {
			setTitle("Bus Management System");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 1073, 584);
			setResizable(false);
			
			//definiranje komponenti
			
			//MAIN PANEL
			mainPanel = new JPanel();
			mainPanel.setBackground(Color.WHITE);
			mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(mainPanel);
			mainPanel.setLayout(null);
			
			//ADMIN NAVBAR PANEL
			AdminNavbarPanel = new JPanel();
			AdminNavbarPanel.setBackground(Color.DARK_GRAY);
			AdminNavbarPanel.setBounds(0, 0, 1069, 40);
			mainPanel.add(AdminNavbarPanel);
			AdminNavbarPanel.setLayout(null);
			
			AdminCityButt = new JButton("CITY");
			AdminCityButt.setBorder(null);
			AdminCityButt.setForeground(Color.WHITE);
			AdminCityButt.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
			AdminCityButt.setBackground(SystemColor.textHighlight);
			AdminCityButt.setBounds(0, 0, 109, 40);
			AdminNavbarPanel.add(AdminCityButt);
			
			btnNewButton = new JButton("BUS");
			btnNewButton.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton.setBackground(SystemColor.textHighlight);
			btnNewButton.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
			btnNewButton.setBounds(108, 0, 109, 40);
			AdminNavbarPanel.add(btnNewButton);
			
			//ADMIN OPERATION PANEL
			AdminOperationPanel = new JPanel();
			AdminOperationPanel.setBackground(Color.WHITE);
			AdminOperationPanel.setBounds(0, 40, 1069, 516);
			mainPanel.add(AdminOperationPanel);
			AdminOperationPanel.setLayout(new CardLayout(0, 0));
			
			//ADMIN CITY PANEL
			AdminCityPanel = new JPanel();
			AdminCityPanel.setBackground(Color.DARK_GRAY);
			AdminCityPanel.setBorder(new MatteBorder(4, 1, 1, 1, (Color) Color.WHITE));
			AdminOperationPanel.add(AdminCityPanel, "name_1748811070515400");
			AdminCityPanel.setLayout(null);
			
			AdminBusPanel = new JPanel();
			AdminBusPanel.setBackground(Color.DARK_GRAY);
			AdminBusPanel.setBorder(new MatteBorder(4, 1, 1, 1, (Color) Color.WHITE));
			AdminOperationPanel.add(AdminBusPanel, "name_1749794365626700");
			
			
			
	
	}
}
