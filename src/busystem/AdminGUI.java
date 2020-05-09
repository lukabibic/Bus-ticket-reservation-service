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
	JPanel AdminCityPanel;
	private JPanel AddCityPanel;
	private JPanel UpdateCityPanel;
	JButton AdminCityButt;
	JButton AdminBusButt;
	private JLabel NameCityLabel;
	private JLabel AddressCityLabel;
	JTextField NameCityAddTextBox;
	JTextField AddressCityAddTextBox;
	JButton AddCityButton;
	JTextField NameCityTextBox1;
	JTextField NameCityTextBox2;
	JTextField NameCityTextBox3;
	JTextField NameCityTextBox4;
	JTextField AddressCityTextBox1;
	JTextField AddressCityTextBox2;
	JTextField AddressCityTextBox3;
	JTextField AddressCityTextBox4;
	JButton DeleteCityButt1;
	JButton DeleteCityButt2;
	JButton DeleteCityButt3;
	JButton DeleteCityButt4;
	JButton EditCityButt1;
	JButton EditCityButt2;
	JButton EditCityButt3;
	JButton EditCityButt4;
	JButton LoadPreviousCityButt;
	JButton LoadNextCityButt;
	JPanel AdminBusPanel;
	private JPanel UpdateBusPanel;
	JTextField ModelBusTextBox1;
	JTextField ModelBusTextBox2;
	JTextField ModelBusTextBox3;
	JTextField ModelBusTextBox4;
	JTextField SeatsBusTextBox1;
	JTextField SeatsBusTextBox2;
	JTextField SeatsBusTextBox3;
	JTextField SeatsBusTextBox4;
	JButton EditBusButt1;
	JButton EditBusButt2;
	JButton EditBusButt3;
	JButton EditBusButt4;
	JButton DeleteBusButt1;
	JButton DeleteBusButt2;
	JButton DeleteBusButt3;
	JButton DeleteBusButt4;
	JButton LoadPreviousBusButt;
	JButton LoadNextBusButt;
	private JPanel AddBusPanel;
	private JLabel ModelBusLabel;
	JTextField ModelBusAddTextBox;
	private JLabel SeatsBusLabel;
	JTextField SeatsBusAddTextBox;
	JButton AddBusButton;
	JButton btnLogout;
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
			
			AdminBusButt = new JButton("BUS");
			AdminBusButt.setOpaque(false);
			AdminBusButt.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			AdminBusButt.setForeground(Color.WHITE);
			AdminBusButt.setBackground(SystemColor.textHighlight);
			AdminBusButt.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
			AdminBusButt.setBounds(108, 0, 109, 40);
			AdminNavbarPanel.add(AdminBusButt);
			
			btnLogout = new JButton("LOGOUT");
			btnLogout.setForeground(Color.WHITE);
			btnLogout.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
			btnLogout.setBorder(null);
			btnLogout.setBackground(SystemColor.textHighlight);
			btnLogout.setBounds(960, 0, 109, 40);
			AdminNavbarPanel.add(btnLogout);
			
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
			
			//UPDATE CITY PANEL
			UpdateCityPanel = new JPanel();
			UpdateCityPanel.setBorder(new MatteBorder(4, 1, 1, 1, (Color) Color.WHITE));
			UpdateCityPanel.setBackground(Color.DARK_GRAY);
			UpdateCityPanel.setBounds(0, 100, 1069, 416);
			AdminCityPanel.add(UpdateCityPanel);
			UpdateCityPanel.setLayout(null);
			
			NameCityTextBox1 = new JTextField();
			NameCityTextBox1.setFocusable(false);
			NameCityTextBox1.setOpaque(false);
			NameCityTextBox1.setForeground(Color.WHITE);
			NameCityTextBox1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			NameCityTextBox1.setColumns(10);
			NameCityTextBox1.setCaretColor(Color.WHITE);
			NameCityTextBox1.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			NameCityTextBox1.setBounds(69, 51, 265, 32);
			UpdateCityPanel.add(NameCityTextBox1);
			
			NameCityTextBox2 = new JTextField();
			NameCityTextBox2.setFocusable(false);
			NameCityTextBox2.setOpaque(false);
			NameCityTextBox2.setForeground(Color.WHITE);
			NameCityTextBox2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			NameCityTextBox2.setColumns(10);
			NameCityTextBox2.setCaretColor(Color.WHITE);
			NameCityTextBox2.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			NameCityTextBox2.setBounds(69, 116, 265, 32);
			UpdateCityPanel.add(NameCityTextBox2);
			
			NameCityTextBox3 = new JTextField();
			NameCityTextBox3.setFocusable(false);
			NameCityTextBox3.setOpaque(false);
			NameCityTextBox3.setForeground(Color.WHITE);
			NameCityTextBox3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			NameCityTextBox3.setColumns(10);
			NameCityTextBox3.setCaretColor(Color.WHITE);
			NameCityTextBox3.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			NameCityTextBox3.setBounds(69, 184, 265, 32);
			UpdateCityPanel.add(NameCityTextBox3);
			
			NameCityTextBox4 = new JTextField();
			NameCityTextBox4.setFocusable(false);
			NameCityTextBox4.setOpaque(false);
			NameCityTextBox4.setForeground(Color.WHITE);
			NameCityTextBox4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			NameCityTextBox4.setColumns(10);
			NameCityTextBox4.setCaretColor(Color.WHITE);
			NameCityTextBox4.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			NameCityTextBox4.setBounds(69, 249, 265, 32);
			UpdateCityPanel.add(NameCityTextBox4);
			
			AddressCityTextBox1 = new JTextField();
			AddressCityTextBox1.setOpaque(false);
			AddressCityTextBox1.setForeground(Color.WHITE);
			AddressCityTextBox1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			AddressCityTextBox1.setFocusable(false);
			AddressCityTextBox1.setColumns(10);
			AddressCityTextBox1.setCaretColor(Color.WHITE);
			AddressCityTextBox1.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			AddressCityTextBox1.setBounds(412, 51, 265, 32);
			UpdateCityPanel.add(AddressCityTextBox1);
			
			AddressCityTextBox2 = new JTextField();
			AddressCityTextBox2.setOpaque(false);
			AddressCityTextBox2.setForeground(Color.WHITE);
			AddressCityTextBox2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			AddressCityTextBox2.setFocusable(false);
			AddressCityTextBox2.setColumns(10);
			AddressCityTextBox2.setCaretColor(Color.WHITE);
			AddressCityTextBox2.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			AddressCityTextBox2.setBounds(412, 116, 265, 32);
			UpdateCityPanel.add(AddressCityTextBox2);
			
			AddressCityTextBox3 = new JTextField();
			AddressCityTextBox3.setOpaque(false);
			AddressCityTextBox3.setForeground(Color.WHITE);
			AddressCityTextBox3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			AddressCityTextBox3.setFocusable(false);
			AddressCityTextBox3.setColumns(10);
			AddressCityTextBox3.setCaretColor(Color.WHITE);
			AddressCityTextBox3.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			AddressCityTextBox3.setBounds(412, 184, 265, 32);
			UpdateCityPanel.add(AddressCityTextBox3);
			
			AddressCityTextBox4 = new JTextField();
			AddressCityTextBox4.setOpaque(false);
			AddressCityTextBox4.setForeground(Color.WHITE);
			AddressCityTextBox4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			AddressCityTextBox4.setFocusable(false);
			AddressCityTextBox4.setColumns(10);
			AddressCityTextBox4.setCaretColor(Color.WHITE);
			AddressCityTextBox4.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			AddressCityTextBox4.setBounds(412, 249, 265, 32);
			UpdateCityPanel.add(AddressCityTextBox4);
			
			EditCityButt1 = new JButton("EDIT");
			EditCityButt1.setForeground(Color.BLACK);
			EditCityButt1.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
			EditCityButt1.setBorder(null);
			EditCityButt1.setBackground(Color.LIGHT_GRAY);
			EditCityButt1.setBounds(756, 51, 101, 32);
			UpdateCityPanel.add(EditCityButt1);
			
			EditCityButt2 = new JButton("EDIT");
			EditCityButt2.setForeground(Color.BLACK);
			EditCityButt2.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
			EditCityButt2.setBorder(null);
			EditCityButt2.setBackground(Color.LIGHT_GRAY);
			EditCityButt2.setBounds(756, 116, 101, 32);
			UpdateCityPanel.add(EditCityButt2);
			
			EditCityButt3 = new JButton("EDIT");
			EditCityButt3.setForeground(Color.BLACK);
			EditCityButt3.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
			EditCityButt3.setBorder(null);
			EditCityButt3.setBackground(Color.LIGHT_GRAY);
			EditCityButt3.setBounds(756, 184, 101, 32);
			UpdateCityPanel.add(EditCityButt3);
			
			EditCityButt4 = new JButton("EDIT");
			EditCityButt4.setForeground(Color.BLACK);
			EditCityButt4.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
			EditCityButt4.setBorder(null);
			EditCityButt4.setBackground(Color.LIGHT_GRAY);
			EditCityButt4.setBounds(756, 249, 101, 32);
			UpdateCityPanel.add(EditCityButt4);
			
			DeleteCityButt1 = new JButton("DELETE");
			DeleteCityButt1.setForeground(Color.WHITE);
			DeleteCityButt1.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
			DeleteCityButt1.setBorder(null);
			DeleteCityButt1.setBackground(Color.RED);
			DeleteCityButt1.setBounds(919, 51, 101, 32);
			UpdateCityPanel.add(DeleteCityButt1);
			
			DeleteCityButt2 = new JButton("DELETE");
			DeleteCityButt2.setForeground(Color.WHITE);
			DeleteCityButt2.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
			DeleteCityButt2.setBorder(null);
			DeleteCityButt2.setBackground(Color.RED);
			DeleteCityButt2.setBounds(919, 116, 101, 32);
			UpdateCityPanel.add(DeleteCityButt2);
			
			DeleteCityButt3 = new JButton("DELETE");
			DeleteCityButt3.setForeground(Color.WHITE);
			DeleteCityButt3.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
			DeleteCityButt3.setBorder(null);
			DeleteCityButt3.setBackground(Color.RED);
			DeleteCityButt3.setBounds(919, 184, 101, 32);
			UpdateCityPanel.add(DeleteCityButt3);
			
			DeleteCityButt4 = new JButton("DELETE");
			DeleteCityButt4.setForeground(Color.WHITE);
			DeleteCityButt4.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
			DeleteCityButt4.setBorder(null);
			DeleteCityButt4.setBackground(Color.RED);
			DeleteCityButt4.setBounds(919, 249, 101, 32);
			UpdateCityPanel.add(DeleteCityButt4);
			
			LoadPreviousCityButt = new JButton("<");
			LoadPreviousCityButt.setForeground(Color.BLACK);
			LoadPreviousCityButt.setFont(new Font("Bookman Old Style", Font.BOLD, 32));
			LoadPreviousCityButt.setBorder(null);
			LoadPreviousCityButt.setBackground(Color.LIGHT_GRAY);
			LoadPreviousCityButt.setBounds(284, 326, 50, 32);
			UpdateCityPanel.add(LoadPreviousCityButt);
			
			LoadNextCityButt = new JButton(">");
			LoadNextCityButt.setForeground(Color.BLACK);
			LoadNextCityButt.setFont(new Font("Bookman Old Style", Font.BOLD, 32));
			LoadNextCityButt.setBorder(null);
			LoadNextCityButt.setBackground(Color.LIGHT_GRAY);
			LoadNextCityButt.setBounds(412, 326, 50, 32);
			UpdateCityPanel.add(LoadNextCityButt);
			
			JLabel label_CityTextBox0 = new JLabel("New label");
			label_CityTextBox0.setBounds(13, 61, 46, 14);
			UpdateCityPanel.add(label_CityTextBox0);
			
			JLabel label_CityTextBox1 = new JLabel("New label");
			label_CityTextBox1.setBounds(13, 126, 46, 14);
			UpdateCityPanel.add(label_CityTextBox1);
			
			JLabel label_CityTextBox2 = new JLabel("New label");
			label_CityTextBox2.setBounds(13, 194, 46, 14);
			UpdateCityPanel.add(label_CityTextBox2);
			
			JLabel label_CityTextBox3 = new JLabel("New label");
			label_CityTextBox3.setBounds(13, 259, 46, 14);
			UpdateCityPanel.add(label_CityTextBox3);
			
			//ADD CITY PANEL
			AddCityPanel = new JPanel();
			AddCityPanel.setBackground(Color.DARK_GRAY);
			AddCityPanel.setBounds(0, 5, 1069, 94);
			AdminCityPanel.add(AddCityPanel);
			AddCityPanel.setLayout(null);
			
			NameCityLabel = new JLabel("NAME: ");
			NameCityLabel.setForeground(Color.WHITE);
			NameCityLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
			NameCityLabel.setBounds(63, 29, 80, 32);
			AddCityPanel.add(NameCityLabel);
			
			NameCityAddTextBox = new JTextField();
			NameCityAddTextBox.setForeground(Color.WHITE);
			NameCityAddTextBox.setCaretColor(Color.WHITE);
			NameCityAddTextBox.setBorder(new LineBorder(new Color(0, 120, 215), 2));
			NameCityAddTextBox.setOpaque(false);
			NameCityAddTextBox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			NameCityAddTextBox.setBounds(152, 30, 199, 32);
			AddCityPanel.add(NameCityAddTextBox);
			NameCityAddTextBox.setColumns(10);
			
			AddressCityLabel = new JLabel("ADDRESS:");
			AddressCityLabel.setForeground(Color.WHITE);
			AddressCityLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
			AddressCityLabel.setBounds(465, 29, 101, 32);
			AddCityPanel.add(AddressCityLabel);
			
			AddressCityAddTextBox = new JTextField();
			AddressCityAddTextBox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			AddressCityAddTextBox.setForeground(Color.WHITE);
			AddressCityAddTextBox.setOpaque(false);
			AddressCityAddTextBox.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			AddressCityAddTextBox.setCaretColor(Color.WHITE);
			AddressCityAddTextBox.setBounds(587, 32, 199, 31);
			AddCityPanel.add(AddressCityAddTextBox);
			AddressCityAddTextBox.setColumns(10);
			
			AddCityButton = new JButton("ADD");
			AddCityButton.setForeground(Color.BLACK);
			AddCityButton.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
			AddCityButton.setBorder(null);
			AddCityButton.setBackground(Color.LIGHT_GRAY);
			AddCityButton.setBounds(890, 31, 101, 32);
			AddCityPanel.add(AddCityButton);
			
			//ADMIN BUS PANEL
			AdminBusPanel = new JPanel();
			AdminBusPanel.setLayout(null);
			AdminBusPanel.setBorder(new MatteBorder(4, 1, 1, 1, (Color) Color.WHITE));
			AdminBusPanel.setBackground(Color.DARK_GRAY);
			AdminOperationPanel.add(AdminBusPanel, "name_1834056920021700");
			
			//UPDATE BUS PANEL
			UpdateBusPanel = new JPanel();
			UpdateBusPanel.setLayout(null);
			UpdateBusPanel.setBorder(new MatteBorder(4, 1, 1, 1, (Color) Color.WHITE));
			UpdateBusPanel.setBackground(Color.DARK_GRAY);
			UpdateBusPanel.setBounds(0, 89, 1069, 416);
			AdminBusPanel.add(UpdateBusPanel);
			
			ModelBusTextBox1 = new JTextField();
			ModelBusTextBox1.setOpaque(false);
			ModelBusTextBox1.setForeground(Color.WHITE);
			ModelBusTextBox1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			ModelBusTextBox1.setFocusable(false);
			ModelBusTextBox1.setColumns(10);
			ModelBusTextBox1.setCaretColor(Color.WHITE);
			ModelBusTextBox1.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			ModelBusTextBox1.setBounds(69, 51, 265, 32);
			UpdateBusPanel.add(ModelBusTextBox1);
			
			ModelBusTextBox2 = new JTextField();
			ModelBusTextBox2.setOpaque(false);
			ModelBusTextBox2.setForeground(Color.WHITE);
			ModelBusTextBox2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			ModelBusTextBox2.setFocusable(false);
			ModelBusTextBox2.setColumns(10);
			ModelBusTextBox2.setCaretColor(Color.WHITE);
			ModelBusTextBox2.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			ModelBusTextBox2.setBounds(69, 116, 265, 32);
			UpdateBusPanel.add(ModelBusTextBox2);
			
			ModelBusTextBox3 = new JTextField();
			ModelBusTextBox3.setOpaque(false);
			ModelBusTextBox3.setForeground(Color.WHITE);
			ModelBusTextBox3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			ModelBusTextBox3.setFocusable(false);
			ModelBusTextBox3.setColumns(10);
			ModelBusTextBox3.setCaretColor(Color.WHITE);
			ModelBusTextBox3.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			ModelBusTextBox3.setBounds(69, 184, 265, 32);
			UpdateBusPanel.add(ModelBusTextBox3);
			
			ModelBusTextBox4 = new JTextField();
			ModelBusTextBox4.setOpaque(false);
			ModelBusTextBox4.setForeground(Color.WHITE);
			ModelBusTextBox4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			ModelBusTextBox4.setFocusable(false);
			ModelBusTextBox4.setColumns(10);
			ModelBusTextBox4.setCaretColor(Color.WHITE);
			ModelBusTextBox4.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			ModelBusTextBox4.setBounds(69, 249, 265, 32);
			UpdateBusPanel.add(ModelBusTextBox4);
			
			SeatsBusTextBox1 = new JTextField();
			SeatsBusTextBox1.setOpaque(false);
			SeatsBusTextBox1.setForeground(Color.WHITE);
			SeatsBusTextBox1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			SeatsBusTextBox1.setFocusable(false);
			SeatsBusTextBox1.setColumns(10);
			SeatsBusTextBox1.setCaretColor(Color.WHITE);
			SeatsBusTextBox1.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			SeatsBusTextBox1.setBounds(412, 51, 265, 32);
			UpdateBusPanel.add(SeatsBusTextBox1);
			
			SeatsBusTextBox2 = new JTextField();
			SeatsBusTextBox2.setOpaque(false);
			SeatsBusTextBox2.setForeground(Color.WHITE);
			SeatsBusTextBox2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			SeatsBusTextBox2.setFocusable(false);
			SeatsBusTextBox2.setColumns(10);
			SeatsBusTextBox2.setCaretColor(Color.WHITE);
			SeatsBusTextBox2.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			SeatsBusTextBox2.setBounds(412, 116, 265, 32);
			UpdateBusPanel.add(SeatsBusTextBox2);
			
			SeatsBusTextBox3 = new JTextField();
			SeatsBusTextBox3.setOpaque(false);
			SeatsBusTextBox3.setForeground(Color.WHITE);
			SeatsBusTextBox3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			SeatsBusTextBox3.setFocusable(false);
			SeatsBusTextBox3.setColumns(10);
			SeatsBusTextBox3.setCaretColor(Color.WHITE);
			SeatsBusTextBox3.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			SeatsBusTextBox3.setBounds(412, 184, 265, 32);
			UpdateBusPanel.add(SeatsBusTextBox3);
			
			SeatsBusTextBox4 = new JTextField();
			SeatsBusTextBox4.setOpaque(false);
			SeatsBusTextBox4.setForeground(Color.WHITE);
			SeatsBusTextBox4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			SeatsBusTextBox4.setFocusable(false);
			SeatsBusTextBox4.setColumns(10);
			SeatsBusTextBox4.setCaretColor(Color.WHITE);
			SeatsBusTextBox4.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			SeatsBusTextBox4.setBounds(412, 249, 265, 32);
			UpdateBusPanel.add(SeatsBusTextBox4);
			
			EditBusButt1 = new JButton("EDIT");
			EditBusButt1.setForeground(Color.BLACK);
			EditBusButt1.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
			EditBusButt1.setBorder(null);
			EditBusButt1.setBackground(Color.LIGHT_GRAY);
			EditBusButt1.setBounds(756, 50, 101, 32);
			UpdateBusPanel.add(EditBusButt1);
			
			EditBusButt2 = new JButton("EDIT");
			EditBusButt2.setForeground(Color.BLACK);
			EditBusButt2.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
			EditBusButt2.setBorder(null);
			EditBusButt2.setBackground(Color.LIGHT_GRAY);
			EditBusButt2.setBounds(756, 116, 101, 32);
			UpdateBusPanel.add(EditBusButt2);
			
			EditBusButt3 = new JButton("EDIT");
			EditBusButt3.setForeground(Color.BLACK);
			EditBusButt3.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
			EditBusButt3.setBorder(null);
			EditBusButt3.setBackground(Color.LIGHT_GRAY);
			EditBusButt3.setBounds(756, 184, 101, 32);
			UpdateBusPanel.add(EditBusButt3);
			
			EditBusButt4 = new JButton("EDIT");
			EditBusButt4.setForeground(Color.BLACK);
			EditBusButt4.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
			EditBusButt4.setBorder(null);
			EditBusButt4.setBackground(Color.LIGHT_GRAY);
			EditBusButt4.setBounds(756, 249, 101, 32);
			UpdateBusPanel.add(EditBusButt4);
			
			DeleteBusButt1 = new JButton("DELETE");
			DeleteBusButt1.setForeground(Color.WHITE);
			DeleteBusButt1.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
			DeleteBusButt1.setBorder(null);
			DeleteBusButt1.setBackground(Color.RED);
			DeleteBusButt1.setBounds(919, 51, 101, 32);
			UpdateBusPanel.add(DeleteBusButt1);
			
			DeleteBusButt2 = new JButton("DELETE");
			DeleteBusButt2.setForeground(Color.WHITE);
			DeleteBusButt2.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
			DeleteBusButt2.setBorder(null);
			DeleteBusButt2.setBackground(Color.RED);
			DeleteBusButt2.setBounds(919, 116, 101, 32);
			UpdateBusPanel.add(DeleteBusButt2);
			
			DeleteBusButt3 = new JButton("DELETE");
			DeleteBusButt3.setForeground(Color.WHITE);
			DeleteBusButt3.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
			DeleteBusButt3.setBorder(null);
			DeleteBusButt3.setBackground(Color.RED);
			DeleteBusButt3.setBounds(919, 184, 101, 32);
			UpdateBusPanel.add(DeleteBusButt3);
			
			DeleteBusButt4 = new JButton("DELETE");
			DeleteBusButt4.setForeground(Color.WHITE);
			DeleteBusButt4.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
			DeleteBusButt4.setBorder(null);
			DeleteBusButt4.setBackground(Color.RED);
			DeleteBusButt4.setBounds(919, 249, 101, 32);
			UpdateBusPanel.add(DeleteBusButt4);
			
			LoadPreviousBusButt = new JButton("<");
			LoadPreviousBusButt.setForeground(Color.BLACK);
			LoadPreviousBusButt.setFont(new Font("Bookman Old Style", Font.BOLD, 32));
			LoadPreviousBusButt.setBorder(null);
			LoadPreviousBusButt.setBackground(Color.LIGHT_GRAY);
			LoadPreviousBusButt.setBounds(284, 326, 50, 32);
			UpdateBusPanel.add(LoadPreviousBusButt);
			
			LoadNextBusButt = new JButton(">");
			LoadNextBusButt.setForeground(Color.BLACK);
			LoadNextBusButt.setFont(new Font("Bookman Old Style", Font.BOLD, 32));
			LoadNextBusButt.setBorder(null);
			LoadNextBusButt.setBackground(Color.LIGHT_GRAY);
			LoadNextBusButt.setBounds(412, 326, 50, 32);
			UpdateBusPanel.add(LoadNextBusButt);
			
			JLabel label_busTextBox0 = new JLabel("New label");
			label_busTextBox0.setBounds(13, 61, 46, 14);
			UpdateBusPanel.add(label_busTextBox0);
			
			JLabel label_busTextBox1 = new JLabel("New label");
			label_busTextBox1.setBounds(13, 126, 46, 14);
			UpdateBusPanel.add(label_busTextBox1);
			
			JLabel label_busTextBox2 = new JLabel("New label");
			label_busTextBox2.setBounds(13, 194, 46, 14);
			UpdateBusPanel.add(label_busTextBox2);
			
			JLabel label_busTextBox3 = new JLabel("New label");
			label_busTextBox3.setBounds(13, 259, 46, 14);
			UpdateBusPanel.add(label_busTextBox3);
			
			//ADD BUS PANEL
			AddBusPanel = new JPanel();
			AddBusPanel.setLayout(null);
			AddBusPanel.setBackground(Color.DARK_GRAY);
			AddBusPanel.setBounds(0, 5, 1069, 94);
			AdminBusPanel.add(AddBusPanel);
			
			ModelBusLabel = new JLabel("MODEL: ");
			ModelBusLabel.setForeground(Color.WHITE);
			ModelBusLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
			ModelBusLabel.setBounds(49, 29, 94, 32);
			AddBusPanel.add(ModelBusLabel);
			
			ModelBusAddTextBox = new JTextField();
			ModelBusAddTextBox.setOpaque(false);
			ModelBusAddTextBox.setForeground(Color.WHITE);
			ModelBusAddTextBox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			ModelBusAddTextBox.setColumns(10);
			ModelBusAddTextBox.setCaretColor(Color.WHITE);
			ModelBusAddTextBox.setBorder(new LineBorder(new Color(0, 120, 215), 2));
			ModelBusAddTextBox.setBounds(152, 30, 199, 32);
			AddBusPanel.add(ModelBusAddTextBox);
			
			SeatsBusLabel = new JLabel("SEATS:");
			SeatsBusLabel.setForeground(Color.WHITE);
			SeatsBusLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
			SeatsBusLabel.setBounds(489, 29, 88, 32);
			AddBusPanel.add(SeatsBusLabel);
			
			SeatsBusAddTextBox = new JTextField();
			SeatsBusAddTextBox.setOpaque(false);
			SeatsBusAddTextBox.setForeground(Color.WHITE);
			SeatsBusAddTextBox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			SeatsBusAddTextBox.setColumns(10);
			SeatsBusAddTextBox.setCaretColor(Color.WHITE);
			SeatsBusAddTextBox.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			SeatsBusAddTextBox.setBounds(587, 32, 199, 31);
			AddBusPanel.add(SeatsBusAddTextBox);
			
			AddBusButton = new JButton("ADD");
			AddBusButton.setForeground(Color.BLACK);
			AddBusButton.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
			AddBusButton.setBorder(null);
			AddBusButton.setBackground(Color.LIGHT_GRAY);
			AddBusButton.setBounds(890, 31, 101, 32);
			AddBusPanel.add(AddBusButton);
			
	}
}
