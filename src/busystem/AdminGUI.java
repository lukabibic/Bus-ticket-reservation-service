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
	private JTextField NameAddTextBox;
	private JTextField AddressAddTextBox;
	private JTextField NameTextBox1;
	private JTextField NameTextBox2;
	private JTextField NameTextBox3;
	private JTextField NameTextBox4;
	private JTextField AddressTextBox1;
	private JTextField AddressTextBox2;
	private JTextField AddressTextBox3;
	private JTextField AddressTextBox4;
	private JButton DeleteButt2;
	private JButton DeleteButt3;
	private JButton DeleteButt4;
	private JButton LoadPreviousButt;
	private JButton LoadNextButt;
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
			
			JPanel UpdatePanel = new JPanel();
			UpdatePanel.setBorder(new MatteBorder(4, 1, 1, 1, (Color) Color.WHITE));
			UpdatePanel.setBackground(Color.DARK_GRAY);
			UpdatePanel.setBounds(0, 100, 1069, 416);
			AdminCityPanel.add(UpdatePanel);
			UpdatePanel.setLayout(null);
			
			NameTextBox1 = new JTextField();
			NameTextBox1.setFocusable(false);
			NameTextBox1.setOpaque(false);
			NameTextBox1.setForeground(Color.WHITE);
			NameTextBox1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			NameTextBox1.setColumns(10);
			NameTextBox1.setCaretColor(Color.WHITE);
			NameTextBox1.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			NameTextBox1.setBounds(69, 51, 265, 32);
			UpdatePanel.add(NameTextBox1);
			
			NameTextBox2 = new JTextField();
			NameTextBox2.setFocusable(false);
			NameTextBox2.setOpaque(false);
			NameTextBox2.setForeground(Color.WHITE);
			NameTextBox2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			NameTextBox2.setColumns(10);
			NameTextBox2.setCaretColor(Color.WHITE);
			NameTextBox2.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			NameTextBox2.setBounds(69, 116, 265, 32);
			UpdatePanel.add(NameTextBox2);
			
			NameTextBox3 = new JTextField();
			NameTextBox3.setFocusable(false);
			NameTextBox3.setOpaque(false);
			NameTextBox3.setForeground(Color.WHITE);
			NameTextBox3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			NameTextBox3.setColumns(10);
			NameTextBox3.setCaretColor(Color.WHITE);
			NameTextBox3.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			NameTextBox3.setBounds(69, 184, 265, 32);
			UpdatePanel.add(NameTextBox3);
			
			NameTextBox4 = new JTextField();
			NameTextBox4.setFocusable(false);
			NameTextBox4.setOpaque(false);
			NameTextBox4.setForeground(Color.WHITE);
			NameTextBox4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			NameTextBox4.setColumns(10);
			NameTextBox4.setCaretColor(Color.WHITE);
			NameTextBox4.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			NameTextBox4.setBounds(69, 249, 265, 32);
			UpdatePanel.add(NameTextBox4);
			
			AddressTextBox1 = new JTextField();
			AddressTextBox1.setOpaque(false);
			AddressTextBox1.setForeground(Color.WHITE);
			AddressTextBox1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			AddressTextBox1.setFocusable(false);
			AddressTextBox1.setColumns(10);
			AddressTextBox1.setCaretColor(Color.WHITE);
			AddressTextBox1.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			AddressTextBox1.setBounds(412, 51, 265, 32);
			UpdatePanel.add(AddressTextBox1);
			
			AddressTextBox2 = new JTextField();
			AddressTextBox2.setOpaque(false);
			AddressTextBox2.setForeground(Color.WHITE);
			AddressTextBox2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			AddressTextBox2.setFocusable(false);
			AddressTextBox2.setColumns(10);
			AddressTextBox2.setCaretColor(Color.WHITE);
			AddressTextBox2.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			AddressTextBox2.setBounds(412, 116, 265, 32);
			UpdatePanel.add(AddressTextBox2);
			
			AddressTextBox3 = new JTextField();
			AddressTextBox3.setOpaque(false);
			AddressTextBox3.setForeground(Color.WHITE);
			AddressTextBox3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			AddressTextBox3.setFocusable(false);
			AddressTextBox3.setColumns(10);
			AddressTextBox3.setCaretColor(Color.WHITE);
			AddressTextBox3.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			AddressTextBox3.setBounds(412, 184, 265, 32);
			UpdatePanel.add(AddressTextBox3);
			
			AddressTextBox4 = new JTextField();
			AddressTextBox4.setOpaque(false);
			AddressTextBox4.setForeground(Color.WHITE);
			AddressTextBox4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			AddressTextBox4.setFocusable(false);
			AddressTextBox4.setColumns(10);
			AddressTextBox4.setCaretColor(Color.WHITE);
			AddressTextBox4.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			AddressTextBox4.setBounds(412, 249, 265, 32);
			UpdatePanel.add(AddressTextBox4);
			
			JButton EditButt1 = new JButton("EDIT");
			EditButt1.setForeground(Color.BLACK);
			EditButt1.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
			EditButt1.setBorder(null);
			EditButt1.setBackground(Color.LIGHT_GRAY);
			EditButt1.setBounds(756, 51, 101, 32);
			UpdatePanel.add(EditButt1);
			
			JButton EditButt2 = new JButton("EDIT");
			EditButt2.setForeground(Color.BLACK);
			EditButt2.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
			EditButt2.setBorder(null);
			EditButt2.setBackground(Color.LIGHT_GRAY);
			EditButt2.setBounds(756, 116, 101, 32);
			UpdatePanel.add(EditButt2);
			
			JButton EditButt3 = new JButton("EDIT");
			EditButt3.setForeground(Color.BLACK);
			EditButt3.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
			EditButt3.setBorder(null);
			EditButt3.setBackground(Color.LIGHT_GRAY);
			EditButt3.setBounds(756, 184, 101, 32);
			UpdatePanel.add(EditButt3);
			
			JButton EditButt4 = new JButton("EDIT");
			EditButt4.setForeground(Color.BLACK);
			EditButt4.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
			EditButt4.setBorder(null);
			EditButt4.setBackground(Color.LIGHT_GRAY);
			EditButt4.setBounds(756, 249, 101, 32);
			UpdatePanel.add(EditButt4);
			
			JButton DeleteButt1 = new JButton("DELETE");
			DeleteButt1.setForeground(Color.WHITE);
			DeleteButt1.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
			DeleteButt1.setBorder(null);
			DeleteButt1.setBackground(Color.RED);
			DeleteButt1.setBounds(919, 51, 101, 32);
			UpdatePanel.add(DeleteButt1);
			
			DeleteButt2 = new JButton("DELETE");
			DeleteButt2.setForeground(Color.WHITE);
			DeleteButt2.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
			DeleteButt2.setBorder(null);
			DeleteButt2.setBackground(Color.RED);
			DeleteButt2.setBounds(919, 116, 101, 32);
			UpdatePanel.add(DeleteButt2);
			
			DeleteButt3 = new JButton("DELETE");
			DeleteButt3.setForeground(Color.WHITE);
			DeleteButt3.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
			DeleteButt3.setBorder(null);
			DeleteButt3.setBackground(Color.RED);
			DeleteButt3.setBounds(919, 184, 101, 32);
			UpdatePanel.add(DeleteButt3);
			
			DeleteButt4 = new JButton("DELETE");
			DeleteButt4.setForeground(Color.WHITE);
			DeleteButt4.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
			DeleteButt4.setBorder(null);
			DeleteButt4.setBackground(Color.RED);
			DeleteButt4.setBounds(919, 249, 101, 32);
			UpdatePanel.add(DeleteButt4);
			
			LoadPreviousButt = new JButton("<");
			LoadPreviousButt.setForeground(Color.BLACK);
			LoadPreviousButt.setFont(new Font("Bookman Old Style", Font.BOLD, 32));
			LoadPreviousButt.setBorder(null);
			LoadPreviousButt.setBackground(Color.LIGHT_GRAY);
			LoadPreviousButt.setBounds(284, 326, 50, 32);
			UpdatePanel.add(LoadPreviousButt);
			
			LoadNextButt = new JButton(">");
			LoadNextButt.setForeground(Color.BLACK);
			LoadNextButt.setFont(new Font("Bookman Old Style", Font.BOLD, 32));
			LoadNextButt.setBorder(null);
			LoadNextButt.setBackground(Color.LIGHT_GRAY);
			LoadNextButt.setBounds(412, 326, 50, 32);
			UpdatePanel.add(LoadNextButt);
			
			JPanel AddPanel = new JPanel();
			AddPanel.setBackground(Color.DARK_GRAY);
			AddPanel.setBounds(0, 5, 1069, 94);
			AdminCityPanel.add(AddPanel);
			AddPanel.setLayout(null);
			
			JLabel NameLabel = new JLabel("NAME: ");
			NameLabel.setForeground(Color.WHITE);
			NameLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
			NameLabel.setBounds(63, 29, 80, 32);
			AddPanel.add(NameLabel);
			
			NameAddTextBox = new JTextField();
			NameAddTextBox.setForeground(Color.WHITE);
			NameAddTextBox.setCaretColor(Color.WHITE);
			NameAddTextBox.setBorder(new LineBorder(new Color(0, 120, 215), 2));
			NameAddTextBox.setOpaque(false);
			NameAddTextBox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			NameAddTextBox.setBounds(152, 30, 199, 32);
			AddPanel.add(NameAddTextBox);
			NameAddTextBox.setColumns(10);
			
			JLabel AddressLabel = new JLabel("ADDRESS:");
			AddressLabel.setForeground(Color.WHITE);
			AddressLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
			AddressLabel.setBounds(465, 29, 101, 32);
			AddPanel.add(AddressLabel);
			
			AddressAddTextBox = new JTextField();
			AddressAddTextBox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			AddressAddTextBox.setForeground(Color.WHITE);
			AddressAddTextBox.setOpaque(false);
			AddressAddTextBox.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			AddressAddTextBox.setCaretColor(Color.WHITE);
			AddressAddTextBox.setBounds(587, 32, 199, 31);
			AddPanel.add(AddressAddTextBox);
			AddressAddTextBox.setColumns(10);
			
			JButton AddCityButton = new JButton("ADD");
			AddCityButton.setForeground(Color.BLACK);
			AddCityButton.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
			AddCityButton.setBorder(null);
			AddCityButton.setBackground(Color.LIGHT_GRAY);
			AddCityButton.setBounds(890, 31, 101, 32);
			AddPanel.add(AddCityButton);
			
			AdminBusPanel = new JPanel();
			AdminBusPanel.setBackground(Color.DARK_GRAY);
			AdminBusPanel.setBorder(new MatteBorder(4, 1, 1, 1, (Color) Color.WHITE));
			AdminOperationPanel.add(AdminBusPanel, "name_1749794365626700");
			
			
			
	
	}
}
