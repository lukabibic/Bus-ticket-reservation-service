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
	JButton AdminLineButt;
	JLabel label_busTextBox0 = new JLabel("New label");
	JLabel label_busTextBox1 = new JLabel("New label");
	JLabel label_busTextBox2 = new JLabel("New label");
	JLabel label_busTextBox3 = new JLabel("New label");
	JLabel label_CityTextBox0 = new JLabel("New label");
	JLabel label_CityTextBox1 = new JLabel("New label");
	JLabel label_CityTextBox2 = new JLabel("New label");
	JLabel label_CityTextBox3 = new JLabel("New label");
	private JLabel label_busTextBox0_2;
	private JLabel label_busTextBox0_1;
	JLabel AddNewBusLabel;
	JLabel AddNewCityLabel;
	JLabel UpdateOrDeleteMessageCityBox;
	JLabel UpdateOrDeleteMessageBusBox;
	
	JPanel AdminLinePanel;
	private JPanel AddLinePanel;
	private JPanel UpdateLinePanel;
	private JLabel StartLineLabel;
	private JLabel DestinationLineLabel;
	JButton AddLineButton;
	JButton DeleteLineButt1;
	JButton DeleteLineButt2;
	JButton DeleteLineButt3;
	JButton DeleteLineButt4;
	JButton LoadPreviousLineButt;
	JButton LoadNextLineButt;
	JLabel label_lineTextBox0;
	JLabel label_lineTextBox1;
	JLabel label_lineTextBox2;
	JLabel label_lineTextBox3;
	JComboBox<String> AddStartComboBox;
	JComboBox<String> AddDestinationComboBox;
	private JLabel label_lineTextBoxID;
	JTextField StartLineTextBox1;
	JTextField StartLineTextBox2;
	JTextField StartLineTextBox3;
	JTextField StartLineTextBox4;
	JTextField DestinationLineTextBox1;
	JTextField DestinationLineTextBox2;
	JTextField DestinationLineTextBox3;
	JTextField DestinationLineTextBox4;
	JLabel AddNewLineLabel;
	JLabel UpdateOrDeleteMessageLineBox;
	
	JButton AdminTripButt;
	JPanel AdminTripPanel;
	private JPanel AddTripPanel;
	private JPanel UpdateTripPanel;
	private JLabel DepartureLabel;
	private JLabel DurationLabel;
	private JLabel BusTripLabel;
	private JLabel LineTripLabel;
	JLabel AddNewTripLabel;
	JComboBox<String> AddLineTripComboBox;
	JComboBox<String> AddBusTripComboBox;
	JTextField AddDepartureTimeTrip;
	JTextField AddDurationTimeTrip;
	JButton AddTripButton;
	JTextField TripLineTextBox1;
	JTextField TripLineTextBox2;
	JTextField TripLineTextBox3;
	JTextField TripLineTextBox4;
	JTextField TripBusTextBox1;
	JTextField TripBusTextBox2;
	JTextField TripBusTextBox3;
	JTextField TripBusTextBox4;
	JTextField TripDepartureTextBox1;
	JTextField TripDepartureTextBox2;
	JTextField TripDepartureTextBox3;
	JTextField TripDepartureTextBox4;
	JTextField TripDurationTextBox1;
	JTextField TripDurationTextBox2;
	JTextField TripDurationTextBox3;
	JTextField TripDurationTextBox4;
	JLabel UpdateOrDeleteMessageTripBox;
	private JLabel label_tripTextBoxID;
	JLabel label_tripTextBox0;
	JLabel label_tripTextBox1;
	JLabel label_tripTextBox2;
	JLabel label_tripTextBox3;
	JButton LoadPreviousTripButt;
	JButton LoadNextTripButt;
	JButton DeleteTripButt1;
	JButton DeleteTripButt2;
	JButton DeleteTripButt3;
	JButton DeleteTripButt4;
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
			
			AdminLineButt = new JButton("LINE");
			AdminLineButt.setOpaque(false);
			AdminLineButt.setBackground(SystemColor.textHighlight);
			AdminLineButt.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			AdminLineButt.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
			AdminLineButt.setForeground(Color.WHITE);
			AdminLineButt.setBounds(217, 0, 109, 40);
			AdminNavbarPanel.add(AdminLineButt);
			
			AdminTripButt = new JButton("TRIP");
			AdminTripButt.setOpaque(false);
			AdminTripButt.setForeground(Color.WHITE);
			AdminTripButt.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
			AdminTripButt.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			AdminTripButt.setBackground(SystemColor.textHighlight);
			AdminTripButt.setBounds(326, 0, 109, 40);
			AdminNavbarPanel.add(AdminTripButt);
			
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
			NameCityTextBox1.setOpaque(false);
			NameCityTextBox1.setForeground(Color.WHITE);
			NameCityTextBox1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			NameCityTextBox1.setColumns(10);
			NameCityTextBox1.setCaretColor(Color.WHITE);
			NameCityTextBox1.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			NameCityTextBox1.setBounds(69, 51, 265, 32);
			UpdateCityPanel.add(NameCityTextBox1);
			
			NameCityTextBox2 = new JTextField();
			NameCityTextBox2.setOpaque(false);
			NameCityTextBox2.setForeground(Color.WHITE);
			NameCityTextBox2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			NameCityTextBox2.setColumns(10);
			NameCityTextBox2.setCaretColor(Color.WHITE);
			NameCityTextBox2.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			NameCityTextBox2.setBounds(69, 116, 265, 32);
			UpdateCityPanel.add(NameCityTextBox2);
			
			NameCityTextBox3 = new JTextField();
			NameCityTextBox3.setOpaque(false);
			NameCityTextBox3.setForeground(Color.WHITE);
			NameCityTextBox3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			NameCityTextBox3.setColumns(10);
			NameCityTextBox3.setCaretColor(Color.WHITE);
			NameCityTextBox3.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			NameCityTextBox3.setBounds(69, 184, 265, 32);
			UpdateCityPanel.add(NameCityTextBox3);
			
			NameCityTextBox4 = new JTextField();
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
			AddressCityTextBox1.setColumns(10);
			AddressCityTextBox1.setCaretColor(Color.WHITE);
			AddressCityTextBox1.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			AddressCityTextBox1.setBounds(412, 51, 265, 32);
			UpdateCityPanel.add(AddressCityTextBox1);
			
			AddressCityTextBox2 = new JTextField();
			AddressCityTextBox2.setOpaque(false);
			AddressCityTextBox2.setForeground(Color.WHITE);
			AddressCityTextBox2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			AddressCityTextBox2.setColumns(10);
			AddressCityTextBox2.setCaretColor(Color.WHITE);
			AddressCityTextBox2.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			AddressCityTextBox2.setBounds(412, 116, 265, 32);
			UpdateCityPanel.add(AddressCityTextBox2);
			
			AddressCityTextBox3 = new JTextField();
			AddressCityTextBox3.setOpaque(false);
			AddressCityTextBox3.setForeground(Color.WHITE);
			AddressCityTextBox3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			AddressCityTextBox3.setColumns(10);
			AddressCityTextBox3.setCaretColor(Color.WHITE);
			AddressCityTextBox3.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			AddressCityTextBox3.setBounds(412, 184, 265, 32);
			UpdateCityPanel.add(AddressCityTextBox3);
			
			AddressCityTextBox4 = new JTextField();
			AddressCityTextBox4.setOpaque(false);
			AddressCityTextBox4.setForeground(Color.WHITE);
			AddressCityTextBox4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
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
			label_CityTextBox0.setForeground(Color.LIGHT_GRAY);
			
			
			label_CityTextBox0.setBounds(13, 61, 46, 14);
			UpdateCityPanel.add(label_CityTextBox0);
			label_CityTextBox1.setForeground(Color.LIGHT_GRAY);
			
			
			label_CityTextBox1.setBounds(13, 126, 46, 14);
			UpdateCityPanel.add(label_CityTextBox1);
			label_CityTextBox2.setForeground(Color.LIGHT_GRAY);
			
			
			label_CityTextBox2.setBounds(13, 194, 46, 14);
			UpdateCityPanel.add(label_CityTextBox2);
			label_CityTextBox3.setForeground(Color.LIGHT_GRAY);
			
			
			label_CityTextBox3.setBounds(13, 259, 46, 14);
			UpdateCityPanel.add(label_CityTextBox3);
			
			label_busTextBox0_2 = new JLabel("ID");
			label_busTextBox0_2.setForeground(Color.LIGHT_GRAY);
			label_busTextBox0_2.setBounds(10, 36, 46, 14);
			UpdateCityPanel.add(label_busTextBox0_2);
			
			UpdateOrDeleteMessageCityBox = new JLabel("");
			UpdateOrDeleteMessageCityBox.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 13));
			UpdateOrDeleteMessageCityBox.setBounds(608, 326, 303, 20);
			UpdateCityPanel.add(UpdateOrDeleteMessageCityBox);
			
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
			
			AddNewCityLabel = new JLabel("");
			AddNewCityLabel.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 13));
			AddNewCityLabel.setBounds(825, 70, 214, 20);
			AddCityPanel.add(AddNewCityLabel);
			
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
			UpdateBusPanel.setBounds(0, 100, 1069, 416);
			AdminBusPanel.add(UpdateBusPanel);
			
			ModelBusTextBox1 = new JTextField();
			ModelBusTextBox1.setOpaque(false);
			ModelBusTextBox1.setForeground(Color.WHITE);
			ModelBusTextBox1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			ModelBusTextBox1.setColumns(10);
			ModelBusTextBox1.setCaretColor(Color.WHITE);
			ModelBusTextBox1.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			ModelBusTextBox1.setBounds(69, 51, 265, 32);
			UpdateBusPanel.add(ModelBusTextBox1);
			
			ModelBusTextBox2 = new JTextField();
			ModelBusTextBox2.setOpaque(false);
			ModelBusTextBox2.setForeground(Color.WHITE);
			ModelBusTextBox2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			ModelBusTextBox2.setColumns(10);
			ModelBusTextBox2.setCaretColor(Color.WHITE);
			ModelBusTextBox2.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			ModelBusTextBox2.setBounds(69, 116, 265, 32);
			UpdateBusPanel.add(ModelBusTextBox2);
			
			ModelBusTextBox3 = new JTextField();
			ModelBusTextBox3.setOpaque(false);
			ModelBusTextBox3.setForeground(Color.WHITE);
			ModelBusTextBox3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			ModelBusTextBox3.setColumns(10);
			ModelBusTextBox3.setCaretColor(Color.WHITE);
			ModelBusTextBox3.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			ModelBusTextBox3.setBounds(69, 184, 265, 32);
			UpdateBusPanel.add(ModelBusTextBox3);
			
			ModelBusTextBox4 = new JTextField();
			ModelBusTextBox4.setOpaque(false);
			ModelBusTextBox4.setForeground(Color.WHITE);
			ModelBusTextBox4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			ModelBusTextBox4.setColumns(10);
			ModelBusTextBox4.setCaretColor(Color.WHITE);
			ModelBusTextBox4.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			ModelBusTextBox4.setBounds(69, 249, 265, 32);
			UpdateBusPanel.add(ModelBusTextBox4);
			
			SeatsBusTextBox1 = new JTextField();
			SeatsBusTextBox1.setOpaque(false);
			SeatsBusTextBox1.setForeground(Color.WHITE);
			SeatsBusTextBox1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			SeatsBusTextBox1.setColumns(10);
			SeatsBusTextBox1.setCaretColor(Color.WHITE);
			SeatsBusTextBox1.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			SeatsBusTextBox1.setBounds(412, 51, 265, 32);
			UpdateBusPanel.add(SeatsBusTextBox1);
			
			SeatsBusTextBox2 = new JTextField();
			SeatsBusTextBox2.setOpaque(false);
			SeatsBusTextBox2.setForeground(Color.WHITE);
			SeatsBusTextBox2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			SeatsBusTextBox2.setColumns(10);
			SeatsBusTextBox2.setCaretColor(Color.WHITE);
			SeatsBusTextBox2.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			SeatsBusTextBox2.setBounds(412, 116, 265, 32);
			UpdateBusPanel.add(SeatsBusTextBox2);
			
			SeatsBusTextBox3 = new JTextField();
			SeatsBusTextBox3.setOpaque(false);
			SeatsBusTextBox3.setForeground(Color.WHITE);
			SeatsBusTextBox3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			SeatsBusTextBox3.setColumns(10);
			SeatsBusTextBox3.setCaretColor(Color.WHITE);
			SeatsBusTextBox3.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			SeatsBusTextBox3.setBounds(412, 184, 265, 32);
			UpdateBusPanel.add(SeatsBusTextBox3);
			
			SeatsBusTextBox4 = new JTextField();
			SeatsBusTextBox4.setOpaque(false);
			SeatsBusTextBox4.setForeground(Color.WHITE);
			SeatsBusTextBox4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
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
			label_busTextBox0.setForeground(Color.LIGHT_GRAY);
			
			
			label_busTextBox0.setBounds(13, 61, 46, 14);
			UpdateBusPanel.add(label_busTextBox0);
			label_busTextBox1.setForeground(Color.LIGHT_GRAY);
			
			
			label_busTextBox1.setBounds(13, 126, 46, 14);
			UpdateBusPanel.add(label_busTextBox1);
			label_busTextBox2.setForeground(Color.LIGHT_GRAY);
			
			
			label_busTextBox2.setBounds(13, 194, 46, 14);
			UpdateBusPanel.add(label_busTextBox2);
			label_busTextBox3.setForeground(Color.LIGHT_GRAY);
			
			
			label_busTextBox3.setBounds(13, 259, 46, 14);
			UpdateBusPanel.add(label_busTextBox3);
			
			label_busTextBox0_1 = new JLabel("ID");
			label_busTextBox0_1.setForeground(Color.LIGHT_GRAY);
			label_busTextBox0_1.setBounds(10, 36, 46, 14);
			UpdateBusPanel.add(label_busTextBox0_1);
			
			UpdateOrDeleteMessageBusBox = new JLabel("");
			UpdateOrDeleteMessageBusBox.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 13));
			UpdateOrDeleteMessageBusBox.setBounds(608, 326, 307, 20);
			UpdateBusPanel.add(UpdateOrDeleteMessageBusBox);
			
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
			
			AddNewBusLabel = new JLabel("");
			AddNewBusLabel.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 13));
			AddNewBusLabel.setBounds(750, 70, 294, 20);
			AddBusPanel.add(AddNewBusLabel);
			
			//ADMIN LINE PANEL
			AdminLinePanel = new JPanel();
			AdminLinePanel.setBorder(new MatteBorder(4, 1, 1, 1, (Color) Color.WHITE));
			AdminLinePanel.setBackground(Color.DARK_GRAY);
			AdminOperationPanel.add(AdminLinePanel, "name_1637114207011100");
			AdminLinePanel.setLayout(null);
			
			//ADD LINE PANEL
			AddLinePanel = new JPanel();
			AddLinePanel.setLayout(null);
			AddLinePanel.setBackground(Color.DARK_GRAY);
			AddLinePanel.setBounds(0, 5, 1069, 94);
			AdminLinePanel.add(AddLinePanel);
			
			StartLineLabel = new JLabel("START:");
			StartLineLabel.setForeground(Color.WHITE);
			StartLineLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
			StartLineLabel.setBounds(49, 29, 94, 32);
			AddLinePanel.add(StartLineLabel);
			
			DestinationLineLabel = new JLabel("DESTINATION:");
			DestinationLineLabel.setForeground(Color.WHITE);
			DestinationLineLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
			DestinationLineLabel.setBounds(423, 29, 154, 32);
			AddLinePanel.add(DestinationLineLabel);
			
			AddLineButton = new JButton("ADD");
			AddLineButton.setForeground(Color.BLACK);
			AddLineButton.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
			AddLineButton.setBorder(null);
			AddLineButton.setBackground(Color.LIGHT_GRAY);
			AddLineButton.setBounds(890, 31, 101, 32);
			AddLinePanel.add(AddLineButton);
			
			AddStartComboBox = new JComboBox<String>();
			AddStartComboBox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			AddStartComboBox.setOpaque(false);
			AddStartComboBox.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			AddStartComboBox.setBounds(152, 30, 199, 32);
			AddLinePanel.add(AddStartComboBox);
			
			AddDestinationComboBox = new JComboBox<String>();
			AddDestinationComboBox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			AddDestinationComboBox.setOpaque(false);
			AddDestinationComboBox.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			AddDestinationComboBox.setBounds(587, 32, 199, 32);
			AddLinePanel.add(AddDestinationComboBox);
			
			AddNewLineLabel = new JLabel("");
			AddNewLineLabel.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 13));
			AddNewLineLabel.setBounds(750, 70, 294, 20);
			AddLinePanel.add(AddNewLineLabel);
			
			//UPDATE LINE PANEL
			UpdateLinePanel = new JPanel();
			UpdateLinePanel.setLayout(null);
			UpdateLinePanel.setBorder(new MatteBorder(4, 1, 1, 1, (Color) Color.WHITE));
			UpdateLinePanel.setBackground(Color.DARK_GRAY);
			UpdateLinePanel.setBounds(0, 100, 1069, 416);
			AdminLinePanel.add(UpdateLinePanel);
			
			DeleteLineButt1 = new JButton("DELETE");
			DeleteLineButt1.setForeground(Color.WHITE);
			DeleteLineButt1.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
			DeleteLineButt1.setBorder(null);
			DeleteLineButt1.setBackground(Color.RED);
			DeleteLineButt1.setBounds(800, 51, 101, 32);
			UpdateLinePanel.add(DeleteLineButt1);
			
			DeleteLineButt2 = new JButton("DELETE");
			DeleteLineButt2.setForeground(Color.WHITE);
			DeleteLineButt2.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
			DeleteLineButt2.setBorder(null);
			DeleteLineButt2.setBackground(Color.RED);
			DeleteLineButt2.setBounds(800, 116, 101, 32);
			UpdateLinePanel.add(DeleteLineButt2);
			
			DeleteLineButt3 = new JButton("DELETE");
			DeleteLineButt3.setForeground(Color.WHITE);
			DeleteLineButt3.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
			DeleteLineButt3.setBorder(null);
			DeleteLineButt3.setBackground(Color.RED);
			DeleteLineButt3.setBounds(800, 184, 101, 32);
			UpdateLinePanel.add(DeleteLineButt3);
			
			DeleteLineButt4 = new JButton("DELETE");
			DeleteLineButt4.setForeground(Color.WHITE);
			DeleteLineButt4.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
			DeleteLineButt4.setBorder(null);
			DeleteLineButt4.setBackground(Color.RED);
			DeleteLineButt4.setBounds(800, 249, 101, 32);
			UpdateLinePanel.add(DeleteLineButt4);
			
			LoadPreviousLineButt = new JButton("<");
			LoadPreviousLineButt.setForeground(Color.BLACK);
			LoadPreviousLineButt.setFont(new Font("Bookman Old Style", Font.BOLD, 32));
			LoadPreviousLineButt.setBorder(null);
			LoadPreviousLineButt.setBackground(Color.LIGHT_GRAY);
			LoadPreviousLineButt.setBounds(284, 326, 50, 32);
			UpdateLinePanel.add(LoadPreviousLineButt);
			
			LoadNextLineButt = new JButton(">");
			LoadNextLineButt.setForeground(Color.BLACK);
			LoadNextLineButt.setFont(new Font("Bookman Old Style", Font.BOLD, 32));
			LoadNextLineButt.setBorder(null);
			LoadNextLineButt.setBackground(Color.LIGHT_GRAY);
			LoadNextLineButt.setBounds(412, 326, 50, 32);
			UpdateLinePanel.add(LoadNextLineButt);
			
			label_lineTextBox0 = new JLabel("New label");
			label_lineTextBox0.setForeground(Color.LIGHT_GRAY);
			label_lineTextBox0.setBounds(13, 61, 46, 14);
			UpdateLinePanel.add(label_lineTextBox0);
			
			label_lineTextBox1 = new JLabel("New label");
			label_lineTextBox1.setForeground(Color.LIGHT_GRAY);
			label_lineTextBox1.setBounds(13, 126, 46, 14);
			UpdateLinePanel.add(label_lineTextBox1);
			
			label_lineTextBox2 = new JLabel("New label");
			label_lineTextBox2.setForeground(Color.LIGHT_GRAY);
			label_lineTextBox2.setBounds(13, 194, 46, 14);
			UpdateLinePanel.add(label_lineTextBox2);
			
			label_lineTextBox3 = new JLabel("New label");
			label_lineTextBox3.setForeground(Color.LIGHT_GRAY);
			label_lineTextBox3.setBounds(13, 259, 46, 14);
			UpdateLinePanel.add(label_lineTextBox3);
			
			label_lineTextBoxID = new JLabel("ID");
			label_lineTextBoxID.setForeground(Color.LIGHT_GRAY);
			label_lineTextBoxID.setBounds(10, 36, 46, 14);
			UpdateLinePanel.add(label_lineTextBoxID);
			
			StartLineTextBox1 = new JTextField();
			StartLineTextBox1.setEditable(false);
			StartLineTextBox1.setOpaque(false);
			StartLineTextBox1.setForeground(Color.WHITE);
			StartLineTextBox1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			StartLineTextBox1.setColumns(10);
			StartLineTextBox1.setCaretColor(Color.WHITE);
			StartLineTextBox1.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			StartLineTextBox1.setBounds(69, 51, 265, 32);
			UpdateLinePanel.add(StartLineTextBox1);
			
			StartLineTextBox2 = new JTextField();
			StartLineTextBox2.setEditable(false);
			StartLineTextBox2.setOpaque(false);
			StartLineTextBox2.setForeground(Color.WHITE);
			StartLineTextBox2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			StartLineTextBox2.setColumns(10);
			StartLineTextBox2.setCaretColor(Color.WHITE);
			StartLineTextBox2.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			StartLineTextBox2.setBounds(69, 116, 265, 32);
			UpdateLinePanel.add(StartLineTextBox2);
			
			StartLineTextBox3 = new JTextField();
			StartLineTextBox3.setOpaque(false);
			StartLineTextBox3.setForeground(Color.WHITE);
			StartLineTextBox3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			StartLineTextBox3.setEditable(false);
			StartLineTextBox3.setColumns(10);
			StartLineTextBox3.setCaretColor(Color.WHITE);
			StartLineTextBox3.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			StartLineTextBox3.setBounds(69, 184, 265, 32);
			UpdateLinePanel.add(StartLineTextBox3);
			
			StartLineTextBox4 = new JTextField();
			StartLineTextBox4.setOpaque(false);
			StartLineTextBox4.setForeground(Color.WHITE);
			StartLineTextBox4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			StartLineTextBox4.setEditable(false);
			StartLineTextBox4.setColumns(10);
			StartLineTextBox4.setCaretColor(Color.WHITE);
			StartLineTextBox4.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			StartLineTextBox4.setBounds(69, 249, 265, 32);
			UpdateLinePanel.add(StartLineTextBox4);
			
			DestinationLineTextBox1 = new JTextField();
			DestinationLineTextBox1.setOpaque(false);
			DestinationLineTextBox1.setForeground(Color.WHITE);
			DestinationLineTextBox1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			DestinationLineTextBox1.setEditable(false);
			DestinationLineTextBox1.setColumns(10);
			DestinationLineTextBox1.setCaretColor(Color.WHITE);
			DestinationLineTextBox1.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			DestinationLineTextBox1.setBounds(412, 51, 265, 32);
			UpdateLinePanel.add(DestinationLineTextBox1);
			
			DestinationLineTextBox2 = new JTextField();
			DestinationLineTextBox2.setOpaque(false);
			DestinationLineTextBox2.setForeground(Color.WHITE);
			DestinationLineTextBox2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			DestinationLineTextBox2.setEditable(false);
			DestinationLineTextBox2.setColumns(10);
			DestinationLineTextBox2.setCaretColor(Color.WHITE);
			DestinationLineTextBox2.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			DestinationLineTextBox2.setBounds(412, 116, 265, 32);
			UpdateLinePanel.add(DestinationLineTextBox2);
			
			DestinationLineTextBox3 = new JTextField();
			DestinationLineTextBox3.setOpaque(false);
			DestinationLineTextBox3.setForeground(Color.WHITE);
			DestinationLineTextBox3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			DestinationLineTextBox3.setEditable(false);
			DestinationLineTextBox3.setColumns(10);
			DestinationLineTextBox3.setCaretColor(Color.WHITE);
			DestinationLineTextBox3.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			DestinationLineTextBox3.setBounds(412, 184, 265, 32);
			UpdateLinePanel.add(DestinationLineTextBox3);
			
			DestinationLineTextBox4 = new JTextField();
			DestinationLineTextBox4.setOpaque(false);
			DestinationLineTextBox4.setForeground(Color.WHITE);
			DestinationLineTextBox4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			DestinationLineTextBox4.setEditable(false);
			DestinationLineTextBox4.setColumns(10);
			DestinationLineTextBox4.setCaretColor(Color.WHITE);
			DestinationLineTextBox4.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			DestinationLineTextBox4.setBounds(412, 249, 265, 32);
			UpdateLinePanel.add(DestinationLineTextBox4);
			
			UpdateOrDeleteMessageLineBox = new JLabel("");
			UpdateOrDeleteMessageLineBox.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 13));
			UpdateOrDeleteMessageLineBox.setBounds(608, 326, 307, 20);
			UpdateLinePanel.add(UpdateOrDeleteMessageLineBox);
			
			AdminTripPanel = new JPanel();
			AdminTripPanel.setLayout(null);
			AdminTripPanel.setBorder(new MatteBorder(4, 1, 1, 1, (Color) Color.WHITE));
			AdminTripPanel.setBackground(Color.DARK_GRAY);
			AdminOperationPanel.add(AdminTripPanel, "name_1803128349213600");
			
			AddTripPanel = new JPanel();
			AddTripPanel.setLayout(null);
			AddTripPanel.setBackground(Color.DARK_GRAY);
			AddTripPanel.setBounds(0, 5, 1069, 144);
			AdminTripPanel.add(AddTripPanel);
			
			LineTripLabel = new JLabel("LINE:");
			LineTripLabel.setForeground(Color.WHITE);
			LineTripLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
			LineTripLabel.setBounds(81, 29, 73, 32);
			AddTripPanel.add(LineTripLabel);
			
			BusTripLabel = new JLabel("BUS:");
			BusTripLabel.setForeground(Color.WHITE);
			BusTripLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
			BusTripLabel.setBounds(514, 29, 63, 32);
			AddTripPanel.add(BusTripLabel);
			
			AddTripButton = new JButton("ADD");
			AddTripButton.setForeground(Color.BLACK);
			AddTripButton.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
			AddTripButton.setBorder(null);
			AddTripButton.setBackground(Color.LIGHT_GRAY);
			AddTripButton.setBounds(891, 58, 101, 32);
			AddTripPanel.add(AddTripButton);
			
			AddLineTripComboBox = new JComboBox<String>();
			AddLineTripComboBox.setOpaque(false);
			AddLineTripComboBox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			AddLineTripComboBox.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			AddLineTripComboBox.setBounds(164, 30, 199, 32);
			AddTripPanel.add(AddLineTripComboBox);
			
			AddBusTripComboBox = new JComboBox<String>();
			AddBusTripComboBox.setOpaque(false);
			AddBusTripComboBox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			AddBusTripComboBox.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			AddBusTripComboBox.setBounds(587, 32, 199, 32);
			AddTripPanel.add(AddBusTripComboBox);
			
			AddNewTripLabel = new JLabel("");
			AddNewTripLabel.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 13));
			AddNewTripLabel.setBounds(689, 120, 370, 20);
			AddTripPanel.add(AddNewTripLabel);
			
			AddDepartureTimeTrip = new JTextField();
			AddDepartureTimeTrip.setOpaque(false);
			AddDepartureTimeTrip.setForeground(Color.WHITE);
			AddDepartureTimeTrip.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			AddDepartureTimeTrip.setColumns(10);
			AddDepartureTimeTrip.setCaretColor(Color.WHITE);
			AddDepartureTimeTrip.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			AddDepartureTimeTrip.setBounds(164, 82, 199, 32);
			AddTripPanel.add(AddDepartureTimeTrip);
			
			AddDurationTimeTrip = new JTextField();
			AddDurationTimeTrip.setOpaque(false);
			AddDurationTimeTrip.setForeground(Color.WHITE);
			AddDurationTimeTrip.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			AddDurationTimeTrip.setColumns(10);
			AddDurationTimeTrip.setCaretColor(Color.WHITE);
			AddDurationTimeTrip.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			AddDurationTimeTrip.setBounds(587, 82, 199, 32);
			AddTripPanel.add(AddDurationTimeTrip);
			
			DepartureLabel = new JLabel("DEPARTURE:");
			DepartureLabel.setForeground(Color.WHITE);
			DepartureLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
			DepartureLabel.setBounds(21, 81, 133, 32);
			AddTripPanel.add(DepartureLabel);
			
			DurationLabel = new JLabel("DURATION:");
			DurationLabel.setForeground(Color.WHITE);
			DurationLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
			DurationLabel.setBounds(466, 82, 111, 32);
			AddTripPanel.add(DurationLabel);
			
			UpdateTripPanel = new JPanel();
			UpdateTripPanel.setLayout(null);
			UpdateTripPanel.setBorder(new MatteBorder(4, 1, 1, 1, (Color) Color.WHITE));
			UpdateTripPanel.setBackground(Color.DARK_GRAY);
			UpdateTripPanel.setBounds(0, 149, 1069, 367);
			AdminTripPanel.add(UpdateTripPanel);
			
			DeleteTripButt1 = new JButton("DELETE");
			DeleteTripButt1.setForeground(Color.WHITE);
			DeleteTripButt1.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
			DeleteTripButt1.setBorder(null);
			DeleteTripButt1.setBackground(Color.RED);
			DeleteTripButt1.setBounds(892, 51, 101, 32);
			UpdateTripPanel.add(DeleteTripButt1);
			
			DeleteTripButt2 = new JButton("DELETE");
			DeleteTripButt2.setForeground(Color.WHITE);
			DeleteTripButt2.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
			DeleteTripButt2.setBorder(null);
			DeleteTripButt2.setBackground(Color.RED);
			DeleteTripButt2.setBounds(892, 116, 101, 32);
			UpdateTripPanel.add(DeleteTripButt2);
			
			DeleteTripButt3 = new JButton("DELETE");
			DeleteTripButt3.setForeground(Color.WHITE);
			DeleteTripButt3.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
			DeleteTripButt3.setBorder(null);
			DeleteTripButt3.setBackground(Color.RED);
			DeleteTripButt3.setBounds(892, 184, 101, 32);
			UpdateTripPanel.add(DeleteTripButt3);
			
			DeleteTripButt4 = new JButton("DELETE");
			DeleteTripButt4.setForeground(Color.WHITE);
			DeleteTripButt4.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
			DeleteTripButt4.setBorder(null);
			DeleteTripButt4.setBackground(Color.RED);
			DeleteTripButt4.setBounds(892, 249, 101, 32);
			UpdateTripPanel.add(DeleteTripButt4);
			
			LoadPreviousTripButt = new JButton("<");
			LoadPreviousTripButt.setForeground(Color.BLACK);
			LoadPreviousTripButt.setFont(new Font("Bookman Old Style", Font.BOLD, 32));
			LoadPreviousTripButt.setBorder(null);
			LoadPreviousTripButt.setBackground(Color.LIGHT_GRAY);
			LoadPreviousTripButt.setBounds(284, 326, 50, 32);
			UpdateTripPanel.add(LoadPreviousTripButt);
			
			LoadNextTripButt = new JButton(">");
			LoadNextTripButt.setForeground(Color.BLACK);
			LoadNextTripButt.setFont(new Font("Bookman Old Style", Font.BOLD, 32));
			LoadNextTripButt.setBorder(null);
			LoadNextTripButt.setBackground(Color.LIGHT_GRAY);
			LoadNextTripButt.setBounds(412, 326, 50, 32);
			UpdateTripPanel.add(LoadNextTripButt);
			
			label_tripTextBox0 = new JLabel("New label");
			label_tripTextBox0.setForeground(Color.LIGHT_GRAY);
			label_tripTextBox0.setBounds(13, 61, 46, 14);
			UpdateTripPanel.add(label_tripTextBox0);
			
			label_tripTextBox1 = new JLabel("New label");
			label_tripTextBox1.setForeground(Color.LIGHT_GRAY);
			label_tripTextBox1.setBounds(13, 126, 46, 14);
			UpdateTripPanel.add(label_tripTextBox1);
			
			label_tripTextBox2 = new JLabel("New label");
			label_tripTextBox2.setForeground(Color.LIGHT_GRAY);
			label_tripTextBox2.setBounds(13, 194, 46, 14);
			UpdateTripPanel.add(label_tripTextBox2);
			
			label_tripTextBox3 = new JLabel("New label");
			label_tripTextBox3.setForeground(Color.LIGHT_GRAY);
			label_tripTextBox3.setBounds(13, 259, 46, 14);
			UpdateTripPanel.add(label_tripTextBox3);
			
			label_tripTextBoxID = new JLabel("ID");
			label_tripTextBoxID.setForeground(Color.LIGHT_GRAY);
			label_tripTextBoxID.setBounds(10, 36, 46, 14);
			UpdateTripPanel.add(label_tripTextBoxID);
			
			TripLineTextBox1 = new JTextField();
			TripLineTextBox1.setOpaque(false);
			TripLineTextBox1.setForeground(Color.WHITE);
			TripLineTextBox1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			TripLineTextBox1.setEditable(false);
			TripLineTextBox1.setColumns(10);
			TripLineTextBox1.setCaretColor(Color.WHITE);
			TripLineTextBox1.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			TripLineTextBox1.setBounds(69, 51, 220, 32);
			UpdateTripPanel.add(TripLineTextBox1);
			
			TripLineTextBox2 = new JTextField();
			TripLineTextBox2.setOpaque(false);
			TripLineTextBox2.setForeground(Color.WHITE);
			TripLineTextBox2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			TripLineTextBox2.setEditable(false);
			TripLineTextBox2.setColumns(10);
			TripLineTextBox2.setCaretColor(Color.WHITE);
			TripLineTextBox2.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			TripLineTextBox2.setBounds(69, 116, 220, 32);
			UpdateTripPanel.add(TripLineTextBox2);
			
			TripLineTextBox3 = new JTextField();
			TripLineTextBox3.setOpaque(false);
			TripLineTextBox3.setForeground(Color.WHITE);
			TripLineTextBox3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			TripLineTextBox3.setEditable(false);
			TripLineTextBox3.setColumns(10);
			TripLineTextBox3.setCaretColor(Color.WHITE);
			TripLineTextBox3.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			TripLineTextBox3.setBounds(69, 184, 220, 32);
			UpdateTripPanel.add(TripLineTextBox3);
			
			TripLineTextBox4 = new JTextField();
			TripLineTextBox4.setOpaque(false);
			TripLineTextBox4.setForeground(Color.WHITE);
			TripLineTextBox4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			TripLineTextBox4.setEditable(false);
			TripLineTextBox4.setColumns(10);
			TripLineTextBox4.setCaretColor(Color.WHITE);
			TripLineTextBox4.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			TripLineTextBox4.setBounds(69, 249, 220, 32);
			UpdateTripPanel.add(TripLineTextBox4);
			
			TripBusTextBox1 = new JTextField();
			TripBusTextBox1.setOpaque(false);
			TripBusTextBox1.setForeground(Color.WHITE);
			TripBusTextBox1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			TripBusTextBox1.setEditable(false);
			TripBusTextBox1.setColumns(10);
			TripBusTextBox1.setCaretColor(Color.WHITE);
			TripBusTextBox1.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			TripBusTextBox1.setBounds(344, 51, 177, 32);
			UpdateTripPanel.add(TripBusTextBox1);
			
			TripBusTextBox2 = new JTextField();
			TripBusTextBox2.setOpaque(false);
			TripBusTextBox2.setForeground(Color.WHITE);
			TripBusTextBox2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			TripBusTextBox2.setEditable(false);
			TripBusTextBox2.setColumns(10);
			TripBusTextBox2.setCaretColor(Color.WHITE);
			TripBusTextBox2.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			TripBusTextBox2.setBounds(344, 116, 177, 32);
			UpdateTripPanel.add(TripBusTextBox2);
			
			TripBusTextBox3 = new JTextField();
			TripBusTextBox3.setOpaque(false);
			TripBusTextBox3.setForeground(Color.WHITE);
			TripBusTextBox3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			TripBusTextBox3.setEditable(false);
			TripBusTextBox3.setColumns(10);
			TripBusTextBox3.setCaretColor(Color.WHITE);
			TripBusTextBox3.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			TripBusTextBox3.setBounds(344, 184, 177, 32);
			UpdateTripPanel.add(TripBusTextBox3);
			
			TripBusTextBox4 = new JTextField();
			TripBusTextBox4.setOpaque(false);
			TripBusTextBox4.setForeground(Color.WHITE);
			TripBusTextBox4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			TripBusTextBox4.setEditable(false);
			TripBusTextBox4.setColumns(10);
			TripBusTextBox4.setCaretColor(Color.WHITE);
			TripBusTextBox4.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			TripBusTextBox4.setBounds(344, 249, 177, 32);
			UpdateTripPanel.add(TripBusTextBox4);
			
			UpdateOrDeleteMessageTripBox = new JLabel("");
			UpdateOrDeleteMessageTripBox.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 13));
			UpdateOrDeleteMessageTripBox.setBounds(608, 326, 307, 20);
			UpdateTripPanel.add(UpdateOrDeleteMessageTripBox);
			
			TripDepartureTextBox1 = new JTextField();
			TripDepartureTextBox1.setOpaque(false);
			TripDepartureTextBox1.setForeground(Color.WHITE);
			TripDepartureTextBox1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			TripDepartureTextBox1.setEditable(false);
			TripDepartureTextBox1.setColumns(10);
			TripDepartureTextBox1.setCaretColor(Color.WHITE);
			TripDepartureTextBox1.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			TripDepartureTextBox1.setBounds(575, 51, 101, 32);
			UpdateTripPanel.add(TripDepartureTextBox1);
			
			TripDepartureTextBox2 = new JTextField();
			TripDepartureTextBox2.setOpaque(false);
			TripDepartureTextBox2.setForeground(Color.WHITE);
			TripDepartureTextBox2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			TripDepartureTextBox2.setEditable(false);
			TripDepartureTextBox2.setColumns(10);
			TripDepartureTextBox2.setCaretColor(Color.WHITE);
			TripDepartureTextBox2.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			TripDepartureTextBox2.setBounds(575, 116, 101, 32);
			UpdateTripPanel.add(TripDepartureTextBox2);
			
			TripDepartureTextBox3 = new JTextField();
			TripDepartureTextBox3.setOpaque(false);
			TripDepartureTextBox3.setForeground(Color.WHITE);
			TripDepartureTextBox3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			TripDepartureTextBox3.setEditable(false);
			TripDepartureTextBox3.setColumns(10);
			TripDepartureTextBox3.setCaretColor(Color.WHITE);
			TripDepartureTextBox3.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			TripDepartureTextBox3.setBounds(575, 184, 101, 32);
			UpdateTripPanel.add(TripDepartureTextBox3);
			
			TripDepartureTextBox4 = new JTextField();
			TripDepartureTextBox4.setOpaque(false);
			TripDepartureTextBox4.setForeground(Color.WHITE);
			TripDepartureTextBox4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			TripDepartureTextBox4.setEditable(false);
			TripDepartureTextBox4.setColumns(10);
			TripDepartureTextBox4.setCaretColor(Color.WHITE);
			TripDepartureTextBox4.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			TripDepartureTextBox4.setBounds(575, 249, 101, 32);
			UpdateTripPanel.add(TripDepartureTextBox4);
			
			TripDurationTextBox1 = new JTextField();
			TripDurationTextBox1.setOpaque(false);
			TripDurationTextBox1.setForeground(Color.WHITE);
			TripDurationTextBox1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			TripDurationTextBox1.setEditable(false);
			TripDurationTextBox1.setColumns(10);
			TripDurationTextBox1.setCaretColor(Color.WHITE);
			TripDurationTextBox1.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			TripDurationTextBox1.setBounds(732, 51, 101, 32);
			UpdateTripPanel.add(TripDurationTextBox1);
			
			TripDurationTextBox2 = new JTextField();
			TripDurationTextBox2.setOpaque(false);
			TripDurationTextBox2.setForeground(Color.WHITE);
			TripDurationTextBox2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			TripDurationTextBox2.setEditable(false);
			TripDurationTextBox2.setColumns(10);
			TripDurationTextBox2.setCaretColor(Color.WHITE);
			TripDurationTextBox2.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			TripDurationTextBox2.setBounds(732, 116, 101, 32);
			UpdateTripPanel.add(TripDurationTextBox2);
			
			TripDurationTextBox3 = new JTextField();
			TripDurationTextBox3.setOpaque(false);
			TripDurationTextBox3.setForeground(Color.WHITE);
			TripDurationTextBox3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			TripDurationTextBox3.setEditable(false);
			TripDurationTextBox3.setColumns(10);
			TripDurationTextBox3.setCaretColor(Color.WHITE);
			TripDurationTextBox3.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			TripDurationTextBox3.setBounds(732, 184, 101, 32);
			UpdateTripPanel.add(TripDurationTextBox3);
			
			TripDurationTextBox4 = new JTextField();
			TripDurationTextBox4.setOpaque(false);
			TripDurationTextBox4.setForeground(Color.WHITE);
			TripDurationTextBox4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			TripDurationTextBox4.setEditable(false);
			TripDurationTextBox4.setColumns(10);
			TripDurationTextBox4.setCaretColor(Color.WHITE);
			TripDurationTextBox4.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			TripDurationTextBox4.setBounds(732, 249, 101, 32);
			UpdateTripPanel.add(TripDurationTextBox4);
			
	}
}
