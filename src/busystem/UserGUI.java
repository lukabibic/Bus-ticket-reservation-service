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

public class UserGUI extends JFrame{
	
	private JPanel mainPanel;
	private JPanel UserNavbarPanel;
	private JPanel UserOperationPanel;
	JPanel UserTicketPanel;
	private JPanel SearchTicketPanel;
	private JPanel ListTicketPanel;
	JButton UserTicketButt;
	private JLabel TicketStartCityLabel;
	private JLabel TicketDestinationCityLabel;
	JButton SearchTripButton;
	JTextField TripLineTextBox1;
	JTextField TripLineTextBox2;
	JTextField TripLineTextBox3;
	JTextField TripLineTextBox4;
	JTextField TripBusTextBox1;
	JTextField TripBusTextBox2;
	JTextField TripBusTextBox3;
	JTextField TripBusTextBox4;
	JButton ReserveTicketButt1;
	JButton ReserveTicketButt2;
	JButton ReserveTicketButt3;
	JButton ReserveTicketButt4;
	JButton LoadPreviousTripButt;
	JButton LoadNextTripButt;
	JButton btnLogout;
	JTextField ChooseDateTicketTextBox;
	JTextField TripEmptySeatsTextBox1;
	JTextField TripDepartureTimeTextBox1;
	JTextField TripEmptySeatsTextBox2;
	JTextField TripEmptySeatsTextBox3;
	JTextField TripEmptySeatsTextBox4;
	JTextField TripDurationTimeTextBox1;
	JTextField TripDepartureTimeTextBox2;
	JTextField TripDepartureTimeTextBox3;
	JTextField TripDepartureTimeTextBox4;
	JTextField TripDurationTimeTextBox2;
	JTextField TripDurationTimeTextBox3;
	JTextField TripDurationTimeTextBox4;
	JComboBox<String> NumberOfTicketComboBox1;
	JComboBox<String> NumberOfTicketComboBox2;
	JComboBox<String> NumberOfTicketComboBox3;
	JComboBox<String> NumberOfTicketComboBox4;
	private JLabel TripLineLabel;
	private JLabel TripBusLabel;
	private JLabel TripFreeSeatsLabel;
	private JLabel TripDepartureLabel;
	private JLabel TripDurationLabel;
	private JLabel TicketQuantityLabel;
	JPanel UserReservedTicketPanel;
	private JPanel ReservedTicketPanel;
	JTextField ReservedTripLineTextBox1;
	JTextField ReservedTripLineTextBox2;
	JTextField ReservedTripLineTextBox3;
	JTextField ReservedTripLineTextBox4;
	JTextField ReservedTripBusTextBox1;
	JTextField ReservedTripBusTextBox2;
	JTextField ReservedTripBusTextBox3;
	JTextField ReservedTripBusTextBox4;
	JButton ReservedTicketDeleteButt1;
	JButton ReservedTicketDeleteButt2;
	JButton ReservedTicketDeleteButt3;
	JButton ReservedTicketDeleteButt4;
	JButton LoadPreviousReservedTicketButt;
	JButton LoadNextReservedTicketButt;
	JTextField ReservedTripDepartureTimeTextBox1;
	JTextField ReservedTripDurationTimeTextBox1;
	JTextField ReservedTripDepartureTimeTextBox2;
	JTextField ReservedTripDepartureTimeTextBox3;
	JTextField ReservedTripDepartureTimeTextBox4;
	JTextField ReservedTripDurationTimeTextBox2;
	JTextField ReservedTripDurationTimeTextBox3;
	JTextField ReservedTripDurationTimeTextBox4;
	private JLabel ReservedTripLineLabel;
	private JLabel ReservedTripBusLabel;
	private JLabel ReservedTripDepartureLabel;
	private JLabel ReservedTripDurationLabel;
	JTextField ReservedDateTextBox1;
	JTextField ReservedDateTextBox2;
	JTextField ReservedDateTextBox3;
	JTextField ReservedDateTextBox4;
	private JLabel ReservedTripDateLabel;
	JLabel SearchTripLabel;
	private JLabel TicketDateLabel;
	JComboBox<String> ChooseDestinationCityTicketComboBox;
	JComboBox<String> ChooseStartCityTicketComboBox;
	JButton UserProfileButt;
	JLabel ReservedTripLabel;
	private JLabel ReservedTicketLabel;
	JLabel TripReservationLabel;
	
	/**
	 * Create the frame.
	 */
	
	public UserGUI() {
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
			
			//USER NAVBAR PANEL
			UserNavbarPanel = new JPanel();
			UserNavbarPanel.setBackground(Color.DARK_GRAY);
			UserNavbarPanel.setBounds(0, 0, 1069, 40);
			mainPanel.add(UserNavbarPanel);
			UserNavbarPanel.setLayout(null);
			
			UserTicketButt = new JButton("TICKET");
			UserTicketButt.setBorder(null);
			UserTicketButt.setForeground(Color.WHITE);
			UserTicketButt.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
			UserTicketButt.setBackground(SystemColor.textHighlight);
			UserTicketButt.setBounds(0, 0, 132, 40);
			UserNavbarPanel.add(UserTicketButt);
			
			btnLogout = new JButton("LOGOUT");
			btnLogout.setForeground(Color.WHITE);
			btnLogout.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
			btnLogout.setBorder(null);
			btnLogout.setBackground(SystemColor.textHighlight);
			btnLogout.setBounds(960, 0, 109, 40);
			UserNavbarPanel.add(btnLogout);
			
			UserProfileButt = new JButton("");
			UserProfileButt.setForeground(Color.WHITE);
			UserProfileButt.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
			UserProfileButt.setBorder(null);
			UserProfileButt.setBackground(SystemColor.textHighlight);
			UserProfileButt.setBounds(763, 0, 197, 40);
			UserNavbarPanel.add(UserProfileButt);
			
			//USER OPERATION PANEL
			UserOperationPanel = new JPanel();
			UserOperationPanel.setBackground(Color.WHITE);
			UserOperationPanel.setBounds(0, 40, 1069, 516);
			mainPanel.add(UserOperationPanel);
			UserOperationPanel.setLayout(new CardLayout(0, 0));
			
			//USER TICKET PANEL
			UserTicketPanel = new JPanel();
			UserTicketPanel.setBackground(Color.DARK_GRAY);
			UserTicketPanel.setBorder(new MatteBorder(4, 1, 1, 1, (Color) Color.WHITE));
			UserOperationPanel.add(UserTicketPanel, "name_1748811070515400");
			UserTicketPanel.setLayout(null);
			
			//LIST TICKET PANEL
			ListTicketPanel = new JPanel();
			ListTicketPanel.setBorder(new MatteBorder(4, 1, 1, 1, (Color) Color.WHITE));
			ListTicketPanel.setBackground(Color.DARK_GRAY);
			ListTicketPanel.setBounds(0, 100, 1069, 416);
			UserTicketPanel.add(ListTicketPanel);
			ListTicketPanel.setLayout(null);
			
			TripLineTextBox1 = new JTextField();
			TripLineTextBox1.setEditable(false);
			TripLineTextBox1.setFocusable(false);
			TripLineTextBox1.setOpaque(false);
			TripLineTextBox1.setForeground(Color.WHITE);
			TripLineTextBox1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			TripLineTextBox1.setColumns(10);
			TripLineTextBox1.setCaretColor(Color.WHITE);
			TripLineTextBox1.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			TripLineTextBox1.setBounds(69, 51, 210, 32);
			ListTicketPanel.add(TripLineTextBox1);
			
			TripLineTextBox2 = new JTextField();
			TripLineTextBox2.setEditable(false);
			TripLineTextBox2.setFocusable(false);
			TripLineTextBox2.setOpaque(false);
			TripLineTextBox2.setForeground(Color.WHITE);
			TripLineTextBox2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			TripLineTextBox2.setColumns(10);
			TripLineTextBox2.setCaretColor(Color.WHITE);
			TripLineTextBox2.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			TripLineTextBox2.setBounds(69, 116, 210, 32);
			ListTicketPanel.add(TripLineTextBox2);
			
			TripLineTextBox3 = new JTextField();
			TripLineTextBox3.setEditable(false);
			TripLineTextBox3.setFocusable(false);
			TripLineTextBox3.setOpaque(false);
			TripLineTextBox3.setForeground(Color.WHITE);
			TripLineTextBox3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			TripLineTextBox3.setColumns(10);
			TripLineTextBox3.setCaretColor(Color.WHITE);
			TripLineTextBox3.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			TripLineTextBox3.setBounds(69, 184, 210, 32);
			ListTicketPanel.add(TripLineTextBox3);
			
			TripLineTextBox4 = new JTextField();
			TripLineTextBox4.setEditable(false);
			TripLineTextBox4.setFocusable(false);
			TripLineTextBox4.setOpaque(false);
			TripLineTextBox4.setForeground(Color.WHITE);
			TripLineTextBox4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			TripLineTextBox4.setColumns(10);
			TripLineTextBox4.setCaretColor(Color.WHITE);
			TripLineTextBox4.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			TripLineTextBox4.setBounds(69, 249, 210, 32);
			ListTicketPanel.add(TripLineTextBox4);
			
			TripBusTextBox1 = new JTextField();
			TripBusTextBox1.setEditable(false);
			TripBusTextBox1.setOpaque(false);
			TripBusTextBox1.setForeground(Color.WHITE);
			TripBusTextBox1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			TripBusTextBox1.setFocusable(false);
			TripBusTextBox1.setColumns(10);
			TripBusTextBox1.setCaretColor(Color.WHITE);
			TripBusTextBox1.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			TripBusTextBox1.setBounds(306, 51, 150, 32);
			ListTicketPanel.add(TripBusTextBox1);
			
			TripBusTextBox2 = new JTextField();
			TripBusTextBox2.setEditable(false);
			TripBusTextBox2.setOpaque(false);
			TripBusTextBox2.setForeground(Color.WHITE);
			TripBusTextBox2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			TripBusTextBox2.setFocusable(false);
			TripBusTextBox2.setColumns(10);
			TripBusTextBox2.setCaretColor(Color.WHITE);
			TripBusTextBox2.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			TripBusTextBox2.setBounds(306, 116, 150, 32);
			ListTicketPanel.add(TripBusTextBox2);
			
			TripBusTextBox3 = new JTextField();
			TripBusTextBox3.setEditable(false);
			TripBusTextBox3.setOpaque(false);
			TripBusTextBox3.setForeground(Color.WHITE);
			TripBusTextBox3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			TripBusTextBox3.setFocusable(false);
			TripBusTextBox3.setColumns(10);
			TripBusTextBox3.setCaretColor(Color.WHITE);
			TripBusTextBox3.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			TripBusTextBox3.setBounds(306, 184, 150, 32);
			ListTicketPanel.add(TripBusTextBox3);
			
			TripBusTextBox4 = new JTextField();
			TripBusTextBox4.setEditable(false);
			TripBusTextBox4.setOpaque(false);
			TripBusTextBox4.setForeground(Color.WHITE);
			TripBusTextBox4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			TripBusTextBox4.setFocusable(false);
			TripBusTextBox4.setColumns(10);
			TripBusTextBox4.setCaretColor(Color.WHITE);
			TripBusTextBox4.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			TripBusTextBox4.setBounds(306, 249, 150, 32);
			ListTicketPanel.add(TripBusTextBox4);
			
			ReserveTicketButt1 = new JButton("RESERVE");
			ReserveTicketButt1.setForeground(Color.BLACK);
			ReserveTicketButt1.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
			ReserveTicketButt1.setBorder(null);
			ReserveTicketButt1.setBackground(Color.LIGHT_GRAY);
			ReserveTicketButt1.setBounds(917, 50, 101, 32);
			ListTicketPanel.add(ReserveTicketButt1);
			
			ReserveTicketButt2 = new JButton("RESERVE");
			ReserveTicketButt2.setForeground(Color.BLACK);
			ReserveTicketButt2.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
			ReserveTicketButt2.setBorder(null);
			ReserveTicketButt2.setBackground(Color.LIGHT_GRAY);
			ReserveTicketButt2.setBounds(917, 115, 101, 32);
			ListTicketPanel.add(ReserveTicketButt2);
			
			ReserveTicketButt3 = new JButton("RESERVE");
			ReserveTicketButt3.setForeground(Color.BLACK);
			ReserveTicketButt3.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
			ReserveTicketButt3.setBorder(null);
			ReserveTicketButt3.setBackground(Color.LIGHT_GRAY);
			ReserveTicketButt3.setBounds(917, 183, 101, 32);
			ListTicketPanel.add(ReserveTicketButt3);
			
			ReserveTicketButt4 = new JButton("RESERVE");
			ReserveTicketButt4.setForeground(Color.BLACK);
			ReserveTicketButt4.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
			ReserveTicketButt4.setBorder(null);
			ReserveTicketButt4.setBackground(Color.LIGHT_GRAY);
			ReserveTicketButt4.setBounds(917, 248, 101, 32);
			ListTicketPanel.add(ReserveTicketButt4);
			
			LoadPreviousTripButt = new JButton("<");
			LoadPreviousTripButt.setForeground(Color.BLACK);
			LoadPreviousTripButt.setFont(new Font("Bookman Old Style", Font.BOLD, 32));
			LoadPreviousTripButt.setBorder(null);
			LoadPreviousTripButt.setBackground(Color.LIGHT_GRAY);
			LoadPreviousTripButt.setBounds(406, 326, 50, 32);
			ListTicketPanel.add(LoadPreviousTripButt);
			
			LoadNextTripButt = new JButton(">");
			LoadNextTripButt.setForeground(Color.BLACK);
			LoadNextTripButt.setFont(new Font("Bookman Old Style", Font.BOLD, 32));
			LoadNextTripButt.setBorder(null);
			LoadNextTripButt.setBackground(Color.LIGHT_GRAY);
			LoadNextTripButt.setBounds(549, 326, 50, 32);
			ListTicketPanel.add(LoadNextTripButt);
			
			TripEmptySeatsTextBox1 = new JTextField();
			TripEmptySeatsTextBox1.setOpaque(false);
			TripEmptySeatsTextBox1.setForeground(Color.WHITE);
			TripEmptySeatsTextBox1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			TripEmptySeatsTextBox1.setFocusable(false);
			TripEmptySeatsTextBox1.setEditable(false);
			TripEmptySeatsTextBox1.setColumns(10);
			TripEmptySeatsTextBox1.setCaretColor(Color.WHITE);
			TripEmptySeatsTextBox1.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			TripEmptySeatsTextBox1.setBounds(481, 51, 40, 32);
			ListTicketPanel.add(TripEmptySeatsTextBox1);
			
			TripDepartureTimeTextBox1 = new JTextField();
			TripDepartureTimeTextBox1.setOpaque(false);
			TripDepartureTimeTextBox1.setForeground(Color.WHITE);
			TripDepartureTimeTextBox1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			TripDepartureTimeTextBox1.setFocusable(false);
			TripDepartureTimeTextBox1.setEditable(false);
			TripDepartureTimeTextBox1.setColumns(10);
			TripDepartureTimeTextBox1.setCaretColor(Color.WHITE);
			TripDepartureTimeTextBox1.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			TripDepartureTimeTextBox1.setBounds(549, 51, 101, 32);
			ListTicketPanel.add(TripDepartureTimeTextBox1);
			
			TripEmptySeatsTextBox2 = new JTextField();
			TripEmptySeatsTextBox2.setOpaque(false);
			TripEmptySeatsTextBox2.setForeground(Color.WHITE);
			TripEmptySeatsTextBox2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			TripEmptySeatsTextBox2.setFocusable(false);
			TripEmptySeatsTextBox2.setEditable(false);
			TripEmptySeatsTextBox2.setColumns(10);
			TripEmptySeatsTextBox2.setCaretColor(Color.WHITE);
			TripEmptySeatsTextBox2.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			TripEmptySeatsTextBox2.setBounds(481, 116, 40, 32);
			ListTicketPanel.add(TripEmptySeatsTextBox2);
			
			TripEmptySeatsTextBox3 = new JTextField();
			TripEmptySeatsTextBox3.setOpaque(false);
			TripEmptySeatsTextBox3.setForeground(Color.WHITE);
			TripEmptySeatsTextBox3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			TripEmptySeatsTextBox3.setFocusable(false);
			TripEmptySeatsTextBox3.setEditable(false);
			TripEmptySeatsTextBox3.setColumns(10);
			TripEmptySeatsTextBox3.setCaretColor(Color.WHITE);
			TripEmptySeatsTextBox3.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			TripEmptySeatsTextBox3.setBounds(481, 184, 40, 32);
			ListTicketPanel.add(TripEmptySeatsTextBox3);
			
			TripEmptySeatsTextBox4 = new JTextField();
			TripEmptySeatsTextBox4.setOpaque(false);
			TripEmptySeatsTextBox4.setForeground(Color.WHITE);
			TripEmptySeatsTextBox4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			TripEmptySeatsTextBox4.setFocusable(false);
			TripEmptySeatsTextBox4.setEditable(false);
			TripEmptySeatsTextBox4.setColumns(10);
			TripEmptySeatsTextBox4.setCaretColor(Color.WHITE);
			TripEmptySeatsTextBox4.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			TripEmptySeatsTextBox4.setBounds(481, 249, 40, 32);
			ListTicketPanel.add(TripEmptySeatsTextBox4);
			
			TripDurationTimeTextBox1 = new JTextField();
			TripDurationTimeTextBox1.setOpaque(false);
			TripDurationTimeTextBox1.setForeground(Color.WHITE);
			TripDurationTimeTextBox1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			TripDurationTimeTextBox1.setFocusable(false);
			TripDurationTimeTextBox1.setEditable(false);
			TripDurationTimeTextBox1.setColumns(10);
			TripDurationTimeTextBox1.setCaretColor(Color.WHITE);
			TripDurationTimeTextBox1.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			TripDurationTimeTextBox1.setBounds(679, 51, 101, 32);
			ListTicketPanel.add(TripDurationTimeTextBox1);
			
			TripDepartureTimeTextBox2 = new JTextField();
			TripDepartureTimeTextBox2.setOpaque(false);
			TripDepartureTimeTextBox2.setForeground(Color.WHITE);
			TripDepartureTimeTextBox2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			TripDepartureTimeTextBox2.setFocusable(false);
			TripDepartureTimeTextBox2.setEditable(false);
			TripDepartureTimeTextBox2.setColumns(10);
			TripDepartureTimeTextBox2.setCaretColor(Color.WHITE);
			TripDepartureTimeTextBox2.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			TripDepartureTimeTextBox2.setBounds(549, 116, 101, 32);
			ListTicketPanel.add(TripDepartureTimeTextBox2);
			
			TripDepartureTimeTextBox3 = new JTextField();
			TripDepartureTimeTextBox3.setOpaque(false);
			TripDepartureTimeTextBox3.setForeground(Color.WHITE);
			TripDepartureTimeTextBox3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			TripDepartureTimeTextBox3.setFocusable(false);
			TripDepartureTimeTextBox3.setEditable(false);
			TripDepartureTimeTextBox3.setColumns(10);
			TripDepartureTimeTextBox3.setCaretColor(Color.WHITE);
			TripDepartureTimeTextBox3.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			TripDepartureTimeTextBox3.setBounds(549, 184, 101, 32);
			ListTicketPanel.add(TripDepartureTimeTextBox3);
			
			TripDepartureTimeTextBox4 = new JTextField();
			TripDepartureTimeTextBox4.setOpaque(false);
			TripDepartureTimeTextBox4.setForeground(Color.WHITE);
			TripDepartureTimeTextBox4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			TripDepartureTimeTextBox4.setFocusable(false);
			TripDepartureTimeTextBox4.setEditable(false);
			TripDepartureTimeTextBox4.setColumns(10);
			TripDepartureTimeTextBox4.setCaretColor(Color.WHITE);
			TripDepartureTimeTextBox4.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			TripDepartureTimeTextBox4.setBounds(549, 249, 101, 32);
			ListTicketPanel.add(TripDepartureTimeTextBox4);
			
			TripDurationTimeTextBox2 = new JTextField();
			TripDurationTimeTextBox2.setOpaque(false);
			TripDurationTimeTextBox2.setForeground(Color.WHITE);
			TripDurationTimeTextBox2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			TripDurationTimeTextBox2.setFocusable(false);
			TripDurationTimeTextBox2.setEditable(false);
			TripDurationTimeTextBox2.setColumns(10);
			TripDurationTimeTextBox2.setCaretColor(Color.WHITE);
			TripDurationTimeTextBox2.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			TripDurationTimeTextBox2.setBounds(679, 116, 101, 32);
			ListTicketPanel.add(TripDurationTimeTextBox2);
			
			TripDurationTimeTextBox3 = new JTextField();
			TripDurationTimeTextBox3.setOpaque(false);
			TripDurationTimeTextBox3.setForeground(Color.WHITE);
			TripDurationTimeTextBox3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			TripDurationTimeTextBox3.setFocusable(false);
			TripDurationTimeTextBox3.setEditable(false);
			TripDurationTimeTextBox3.setColumns(10);
			TripDurationTimeTextBox3.setCaretColor(Color.WHITE);
			TripDurationTimeTextBox3.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			TripDurationTimeTextBox3.setBounds(679, 184, 101, 32);
			ListTicketPanel.add(TripDurationTimeTextBox3);
			
			TripDurationTimeTextBox4 = new JTextField();
			TripDurationTimeTextBox4.setOpaque(false);
			TripDurationTimeTextBox4.setForeground(Color.WHITE);
			TripDurationTimeTextBox4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			TripDurationTimeTextBox4.setFocusable(false);
			TripDurationTimeTextBox4.setEditable(false);
			TripDurationTimeTextBox4.setColumns(10);
			TripDurationTimeTextBox4.setCaretColor(Color.WHITE);
			TripDurationTimeTextBox4.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			TripDurationTimeTextBox4.setBounds(679, 249, 101, 32);
			ListTicketPanel.add(TripDurationTimeTextBox4);
			
			NumberOfTicketComboBox1 = new JComboBox<String>();
			NumberOfTicketComboBox1.setOpaque(false);
			NumberOfTicketComboBox1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			NumberOfTicketComboBox1.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			NumberOfTicketComboBox1.setBounds(814, 51, 59, 32);
			ListTicketPanel.add(NumberOfTicketComboBox1);
			
			NumberOfTicketComboBox2 = new JComboBox<String>();
			NumberOfTicketComboBox2.setOpaque(false);
			NumberOfTicketComboBox2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			NumberOfTicketComboBox2.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			NumberOfTicketComboBox2.setBounds(814, 116, 59, 32);
			ListTicketPanel.add(NumberOfTicketComboBox2);
			
			NumberOfTicketComboBox3 = new JComboBox<String>();
			NumberOfTicketComboBox3.setOpaque(false);
			NumberOfTicketComboBox3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			NumberOfTicketComboBox3.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			NumberOfTicketComboBox3.setBounds(814, 184, 59, 32);
			ListTicketPanel.add(NumberOfTicketComboBox3);
			
			NumberOfTicketComboBox4 = new JComboBox<String>();
			NumberOfTicketComboBox4.setOpaque(false);
			NumberOfTicketComboBox4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			NumberOfTicketComboBox4.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			NumberOfTicketComboBox4.setBounds(814, 249, 59, 32);
			ListTicketPanel.add(NumberOfTicketComboBox4);
			
			TripLineLabel = new JLabel("TRIP LINE");
			TripLineLabel.setForeground(Color.WHITE);
			TripLineLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
			TripLineLabel.setBounds(117, 10, 107, 32);
			ListTicketPanel.add(TripLineLabel);
			
			TripBusLabel = new JLabel("TRIP BUS");
			TripBusLabel.setForeground(Color.WHITE);
			TripBusLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
			TripBusLabel.setBounds(334, 10, 92, 32);
			ListTicketPanel.add(TripBusLabel);
			
			TripFreeSeatsLabel = new JLabel("FREE");
			TripFreeSeatsLabel.setForeground(Color.WHITE);
			TripFreeSeatsLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
			TripFreeSeatsLabel.setBounds(475, 9, 59, 32);
			ListTicketPanel.add(TripFreeSeatsLabel);
			
			TripDepartureLabel = new JLabel("DEPARTURE");
			TripDepartureLabel.setForeground(Color.WHITE);
			TripDepartureLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
			TripDepartureLabel.setBounds(542, 9, 122, 32);
			ListTicketPanel.add(TripDepartureLabel);
			
			TripDurationLabel = new JLabel("DURATION");
			TripDurationLabel.setForeground(Color.WHITE);
			TripDurationLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
			TripDurationLabel.setBounds(679, 10, 107, 32);
			ListTicketPanel.add(TripDurationLabel);
			
			TicketQuantityLabel = new JLabel("QUANTITY");
			TicketQuantityLabel.setForeground(Color.WHITE);
			TicketQuantityLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
			TicketQuantityLabel.setBounds(796, 10, 107, 32);
			ListTicketPanel.add(TicketQuantityLabel);
			
			TripReservationLabel = new JLabel("");
			TripReservationLabel.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 13));
			TripReservationLabel.setBounds(648, 314, 370, 20);
			ListTicketPanel.add(TripReservationLabel);
			
			//SEARCH TRIP PANEL
			SearchTicketPanel = new JPanel();
			SearchTicketPanel.setBackground(Color.DARK_GRAY);
			SearchTicketPanel.setBounds(0, 5, 1069, 94);
			UserTicketPanel.add(SearchTicketPanel);
			SearchTicketPanel.setLayout(null);
			
			TicketStartCityLabel = new JLabel("START:");
			TicketStartCityLabel.setForeground(Color.WHITE);
			TicketStartCityLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
			TicketStartCityLabel.setBounds(22, 29, 73, 32);
			SearchTicketPanel.add(TicketStartCityLabel);
			
			TicketDestinationCityLabel = new JLabel("DESTINATION:");
			TicketDestinationCityLabel.setForeground(Color.WHITE);
			TicketDestinationCityLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
			TicketDestinationCityLabel.setBounds(288, 29, 143, 32);
			SearchTicketPanel.add(TicketDestinationCityLabel);
			
			SearchTripButton = new JButton("SEARCH");
			SearchTripButton.setForeground(Color.BLACK);
			SearchTripButton.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
			SearchTripButton.setBorder(null);
			SearchTripButton.setBackground(Color.LIGHT_GRAY);
			SearchTripButton.setBounds(924, 29, 101, 32);
			SearchTicketPanel.add(SearchTripButton);
			
			ChooseStartCityTicketComboBox = new JComboBox<String>();
			ChooseStartCityTicketComboBox.setOpaque(false);
			ChooseStartCityTicketComboBox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			ChooseStartCityTicketComboBox.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			ChooseStartCityTicketComboBox.setBounds(105, 29, 159, 32);
			SearchTicketPanel.add(ChooseStartCityTicketComboBox);
			
			ChooseDestinationCityTicketComboBox = new JComboBox<String>();
			ChooseDestinationCityTicketComboBox.setOpaque(false);
			ChooseDestinationCityTicketComboBox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			ChooseDestinationCityTicketComboBox.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			ChooseDestinationCityTicketComboBox.setBounds(441, 29, 159, 32);
			SearchTicketPanel.add(ChooseDestinationCityTicketComboBox);
			
			TicketDateLabel = new JLabel("DATE:");
			TicketDateLabel.setForeground(Color.WHITE);
			TicketDateLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
			TicketDateLabel.setBounds(623, 29, 65, 32);
			SearchTicketPanel.add(TicketDateLabel);
			
			ChooseDateTicketTextBox = new JTextField();
			ChooseDateTicketTextBox.setOpaque(false);
			ChooseDateTicketTextBox.setForeground(Color.WHITE);
			ChooseDateTicketTextBox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			ChooseDateTicketTextBox.setColumns(10);
			ChooseDateTicketTextBox.setCaretColor(Color.WHITE);
			ChooseDateTicketTextBox.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			ChooseDateTicketTextBox.setBounds(698, 29, 159, 32);
			SearchTicketPanel.add(ChooseDateTicketTextBox);
			
			SearchTripLabel = new JLabel("");
			SearchTripLabel.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 13));
			SearchTripLabel.setBounds(655, 71, 370, 20);
			SearchTicketPanel.add(SearchTripLabel);
			
			//USER RESERVED TICKET PANEL
			
			UserReservedTicketPanel = new JPanel();
			UserReservedTicketPanel.setLayout(null);
			UserReservedTicketPanel.setBorder(new MatteBorder(4, 1, 1, 1, (Color) Color.WHITE));
			UserReservedTicketPanel.setBackground(Color.DARK_GRAY);
			UserOperationPanel.add(UserReservedTicketPanel, "name_1912699886840600");
			
			ReservedTicketPanel = new JPanel();
			ReservedTicketPanel.setLayout(null);
			ReservedTicketPanel.setBorder(new MatteBorder(4, 1, 1, 1, (Color) Color.WHITE));
			ReservedTicketPanel.setBackground(Color.DARK_GRAY);
			ReservedTicketPanel.setBounds(0, 0, 1069, 516);
			UserReservedTicketPanel.add(ReservedTicketPanel);
			
			ReservedTripLineTextBox1 = new JTextField();
			ReservedTripLineTextBox1.setEditable(false);
			ReservedTripLineTextBox1.setOpaque(false);
			ReservedTripLineTextBox1.setForeground(Color.WHITE);
			ReservedTripLineTextBox1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			ReservedTripLineTextBox1.setFocusable(false);
			ReservedTripLineTextBox1.setColumns(10);
			ReservedTripLineTextBox1.setCaretColor(Color.WHITE);
			ReservedTripLineTextBox1.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			ReservedTripLineTextBox1.setBounds(36, 145, 210, 32);
			ReservedTicketPanel.add(ReservedTripLineTextBox1);
			
			ReservedTripLineTextBox2 = new JTextField();
			ReservedTripLineTextBox2.setOpaque(false);
			ReservedTripLineTextBox2.setForeground(Color.WHITE);
			ReservedTripLineTextBox2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			ReservedTripLineTextBox2.setFocusable(false);
			ReservedTripLineTextBox2.setEditable(false);
			ReservedTripLineTextBox2.setColumns(10);
			ReservedTripLineTextBox2.setCaretColor(Color.WHITE);
			ReservedTripLineTextBox2.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			ReservedTripLineTextBox2.setBounds(36, 210, 210, 32);
			ReservedTicketPanel.add(ReservedTripLineTextBox2);
			
			ReservedTripLineTextBox3 = new JTextField();
			ReservedTripLineTextBox3.setOpaque(false);
			ReservedTripLineTextBox3.setForeground(Color.WHITE);
			ReservedTripLineTextBox3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			ReservedTripLineTextBox3.setFocusable(false);
			ReservedTripLineTextBox3.setEditable(false);
			ReservedTripLineTextBox3.setColumns(10);
			ReservedTripLineTextBox3.setCaretColor(Color.WHITE);
			ReservedTripLineTextBox3.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			ReservedTripLineTextBox3.setBounds(36, 275, 210, 32);
			ReservedTicketPanel.add(ReservedTripLineTextBox3);
			
			ReservedTripLineTextBox4 = new JTextField();
			ReservedTripLineTextBox4.setOpaque(false);
			ReservedTripLineTextBox4.setForeground(Color.WHITE);
			ReservedTripLineTextBox4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			ReservedTripLineTextBox4.setFocusable(false);
			ReservedTripLineTextBox4.setEditable(false);
			ReservedTripLineTextBox4.setColumns(10);
			ReservedTripLineTextBox4.setCaretColor(Color.WHITE);
			ReservedTripLineTextBox4.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			ReservedTripLineTextBox4.setBounds(36, 340, 210, 32);
			ReservedTicketPanel.add(ReservedTripLineTextBox4);
			
			ReservedTripBusTextBox1 = new JTextField();
			ReservedTripBusTextBox1.setOpaque(false);
			ReservedTripBusTextBox1.setForeground(Color.WHITE);
			ReservedTripBusTextBox1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			ReservedTripBusTextBox1.setFocusable(false);
			ReservedTripBusTextBox1.setEditable(false);
			ReservedTripBusTextBox1.setColumns(10);
			ReservedTripBusTextBox1.setCaretColor(Color.WHITE);
			ReservedTripBusTextBox1.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			ReservedTripBusTextBox1.setBounds(280, 145, 150, 32);
			ReservedTicketPanel.add(ReservedTripBusTextBox1);
			
			ReservedTripBusTextBox2 = new JTextField();
			ReservedTripBusTextBox2.setOpaque(false);
			ReservedTripBusTextBox2.setForeground(Color.WHITE);
			ReservedTripBusTextBox2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			ReservedTripBusTextBox2.setFocusable(false);
			ReservedTripBusTextBox2.setEditable(false);
			ReservedTripBusTextBox2.setColumns(10);
			ReservedTripBusTextBox2.setCaretColor(Color.WHITE);
			ReservedTripBusTextBox2.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			ReservedTripBusTextBox2.setBounds(280, 210, 150, 32);
			ReservedTicketPanel.add(ReservedTripBusTextBox2);
			
			ReservedTripBusTextBox3 = new JTextField();
			ReservedTripBusTextBox3.setOpaque(false);
			ReservedTripBusTextBox3.setForeground(Color.WHITE);
			ReservedTripBusTextBox3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			ReservedTripBusTextBox3.setFocusable(false);
			ReservedTripBusTextBox3.setEditable(false);
			ReservedTripBusTextBox3.setColumns(10);
			ReservedTripBusTextBox3.setCaretColor(Color.WHITE);
			ReservedTripBusTextBox3.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			ReservedTripBusTextBox3.setBounds(280, 275, 150, 32);
			ReservedTicketPanel.add(ReservedTripBusTextBox3);
			
			ReservedTripBusTextBox4 = new JTextField();
			ReservedTripBusTextBox4.setOpaque(false);
			ReservedTripBusTextBox4.setForeground(Color.WHITE);
			ReservedTripBusTextBox4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			ReservedTripBusTextBox4.setFocusable(false);
			ReservedTripBusTextBox4.setEditable(false);
			ReservedTripBusTextBox4.setColumns(10);
			ReservedTripBusTextBox4.setCaretColor(Color.WHITE);
			ReservedTripBusTextBox4.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			ReservedTripBusTextBox4.setBounds(280, 340, 150, 32);
			ReservedTicketPanel.add(ReservedTripBusTextBox4);
			
			ReservedTicketDeleteButt1 = new JButton("DELETE");
			ReservedTicketDeleteButt1.setForeground(Color.WHITE);
			ReservedTicketDeleteButt1.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
			ReservedTicketDeleteButt1.setBorder(null);
			ReservedTicketDeleteButt1.setBackground(Color.RED);
			ReservedTicketDeleteButt1.setBounds(911, 144, 101, 32);
			ReservedTicketPanel.add(ReservedTicketDeleteButt1);
			
			ReservedTicketDeleteButt2 = new JButton("DELETE");
			ReservedTicketDeleteButt2.setForeground(Color.WHITE);
			ReservedTicketDeleteButt2.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
			ReservedTicketDeleteButt2.setBorder(null);
			ReservedTicketDeleteButt2.setBackground(Color.RED);
			ReservedTicketDeleteButt2.setBounds(911, 209, 101, 32);
			ReservedTicketPanel.add(ReservedTicketDeleteButt2);
			
			ReservedTicketDeleteButt3 = new JButton("DELETE");
			ReservedTicketDeleteButt3.setForeground(Color.WHITE);
			ReservedTicketDeleteButt3.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
			ReservedTicketDeleteButt3.setBorder(null);
			ReservedTicketDeleteButt3.setBackground(Color.RED);
			ReservedTicketDeleteButt3.setBounds(911, 274, 101, 32);
			ReservedTicketPanel.add(ReservedTicketDeleteButt3);
			
			ReservedTicketDeleteButt4 = new JButton("DELETE");
			ReservedTicketDeleteButt4.setForeground(Color.WHITE);
			ReservedTicketDeleteButt4.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
			ReservedTicketDeleteButt4.setBorder(null);
			ReservedTicketDeleteButt4.setBackground(Color.RED);
			ReservedTicketDeleteButt4.setBounds(911, 339, 101, 32);
			ReservedTicketPanel.add(ReservedTicketDeleteButt4);
			
			LoadPreviousReservedTicketButt = new JButton("<");
			LoadPreviousReservedTicketButt.setForeground(Color.BLACK);
			LoadPreviousReservedTicketButt.setFont(new Font("Bookman Old Style", Font.BOLD, 32));
			LoadPreviousReservedTicketButt.setBorder(null);
			LoadPreviousReservedTicketButt.setBackground(Color.LIGHT_GRAY);
			LoadPreviousReservedTicketButt.setBounds(410, 416, 50, 32);
			ReservedTicketPanel.add(LoadPreviousReservedTicketButt);
			
			LoadNextReservedTicketButt = new JButton(">");
			LoadNextReservedTicketButt.setForeground(Color.BLACK);
			LoadNextReservedTicketButt.setFont(new Font("Bookman Old Style", Font.BOLD, 32));
			LoadNextReservedTicketButt.setBorder(null);
			LoadNextReservedTicketButt.setBackground(Color.LIGHT_GRAY);
			LoadNextReservedTicketButt.setBounds(560, 416, 50, 32);
			ReservedTicketPanel.add(LoadNextReservedTicketButt);
			
			ReservedTripDepartureTimeTextBox1 = new JTextField();
			ReservedTripDepartureTimeTextBox1.setOpaque(false);
			ReservedTripDepartureTimeTextBox1.setForeground(Color.WHITE);
			ReservedTripDepartureTimeTextBox1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			ReservedTripDepartureTimeTextBox1.setFocusable(false);
			ReservedTripDepartureTimeTextBox1.setEditable(false);
			ReservedTripDepartureTimeTextBox1.setColumns(10);
			ReservedTripDepartureTimeTextBox1.setCaretColor(Color.WHITE);
			ReservedTripDepartureTimeTextBox1.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			ReservedTripDepartureTimeTextBox1.setBounds(459, 145, 101, 32);
			ReservedTicketPanel.add(ReservedTripDepartureTimeTextBox1);
			
			ReservedTripDurationTimeTextBox1 = new JTextField();
			ReservedTripDurationTimeTextBox1.setOpaque(false);
			ReservedTripDurationTimeTextBox1.setForeground(Color.WHITE);
			ReservedTripDurationTimeTextBox1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			ReservedTripDurationTimeTextBox1.setFocusable(false);
			ReservedTripDurationTimeTextBox1.setEditable(false);
			ReservedTripDurationTimeTextBox1.setColumns(10);
			ReservedTripDurationTimeTextBox1.setCaretColor(Color.WHITE);
			ReservedTripDurationTimeTextBox1.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			ReservedTripDurationTimeTextBox1.setBounds(594, 145, 101, 32);
			ReservedTicketPanel.add(ReservedTripDurationTimeTextBox1);
			
			ReservedTripDepartureTimeTextBox2 = new JTextField();
			ReservedTripDepartureTimeTextBox2.setOpaque(false);
			ReservedTripDepartureTimeTextBox2.setForeground(Color.WHITE);
			ReservedTripDepartureTimeTextBox2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			ReservedTripDepartureTimeTextBox2.setFocusable(false);
			ReservedTripDepartureTimeTextBox2.setEditable(false);
			ReservedTripDepartureTimeTextBox2.setColumns(10);
			ReservedTripDepartureTimeTextBox2.setCaretColor(Color.WHITE);
			ReservedTripDepartureTimeTextBox2.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			ReservedTripDepartureTimeTextBox2.setBounds(459, 210, 101, 32);
			ReservedTicketPanel.add(ReservedTripDepartureTimeTextBox2);
			
			ReservedTripDepartureTimeTextBox3 = new JTextField();
			ReservedTripDepartureTimeTextBox3.setOpaque(false);
			ReservedTripDepartureTimeTextBox3.setForeground(Color.WHITE);
			ReservedTripDepartureTimeTextBox3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			ReservedTripDepartureTimeTextBox3.setFocusable(false);
			ReservedTripDepartureTimeTextBox3.setEditable(false);
			ReservedTripDepartureTimeTextBox3.setColumns(10);
			ReservedTripDepartureTimeTextBox3.setCaretColor(Color.WHITE);
			ReservedTripDepartureTimeTextBox3.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			ReservedTripDepartureTimeTextBox3.setBounds(459, 275, 101, 32);
			ReservedTicketPanel.add(ReservedTripDepartureTimeTextBox3);
			
			ReservedTripDepartureTimeTextBox4 = new JTextField();
			ReservedTripDepartureTimeTextBox4.setOpaque(false);
			ReservedTripDepartureTimeTextBox4.setForeground(Color.WHITE);
			ReservedTripDepartureTimeTextBox4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			ReservedTripDepartureTimeTextBox4.setFocusable(false);
			ReservedTripDepartureTimeTextBox4.setEditable(false);
			ReservedTripDepartureTimeTextBox4.setColumns(10);
			ReservedTripDepartureTimeTextBox4.setCaretColor(Color.WHITE);
			ReservedTripDepartureTimeTextBox4.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			ReservedTripDepartureTimeTextBox4.setBounds(459, 340, 101, 32);
			ReservedTicketPanel.add(ReservedTripDepartureTimeTextBox4);
			
			ReservedTripDurationTimeTextBox2 = new JTextField();
			ReservedTripDurationTimeTextBox2.setOpaque(false);
			ReservedTripDurationTimeTextBox2.setForeground(Color.WHITE);
			ReservedTripDurationTimeTextBox2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			ReservedTripDurationTimeTextBox2.setFocusable(false);
			ReservedTripDurationTimeTextBox2.setEditable(false);
			ReservedTripDurationTimeTextBox2.setColumns(10);
			ReservedTripDurationTimeTextBox2.setCaretColor(Color.WHITE);
			ReservedTripDurationTimeTextBox2.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			ReservedTripDurationTimeTextBox2.setBounds(594, 210, 101, 32);
			ReservedTicketPanel.add(ReservedTripDurationTimeTextBox2);
			
			ReservedTripDurationTimeTextBox3 = new JTextField();
			ReservedTripDurationTimeTextBox3.setOpaque(false);
			ReservedTripDurationTimeTextBox3.setForeground(Color.WHITE);
			ReservedTripDurationTimeTextBox3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			ReservedTripDurationTimeTextBox3.setFocusable(false);
			ReservedTripDurationTimeTextBox3.setEditable(false);
			ReservedTripDurationTimeTextBox3.setColumns(10);
			ReservedTripDurationTimeTextBox3.setCaretColor(Color.WHITE);
			ReservedTripDurationTimeTextBox3.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			ReservedTripDurationTimeTextBox3.setBounds(594, 275, 101, 32);
			ReservedTicketPanel.add(ReservedTripDurationTimeTextBox3);
			
			ReservedTripDurationTimeTextBox4 = new JTextField();
			ReservedTripDurationTimeTextBox4.setOpaque(false);
			ReservedTripDurationTimeTextBox4.setForeground(Color.WHITE);
			ReservedTripDurationTimeTextBox4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			ReservedTripDurationTimeTextBox4.setFocusable(false);
			ReservedTripDurationTimeTextBox4.setEditable(false);
			ReservedTripDurationTimeTextBox4.setColumns(10);
			ReservedTripDurationTimeTextBox4.setCaretColor(Color.WHITE);
			ReservedTripDurationTimeTextBox4.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			ReservedTripDurationTimeTextBox4.setBounds(594, 340, 101, 32);
			ReservedTicketPanel.add(ReservedTripDurationTimeTextBox4);
			
			ReservedTripLineLabel = new JLabel("TRIP LINE");
			ReservedTripLineLabel.setForeground(Color.WHITE);
			ReservedTripLineLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
			ReservedTripLineLabel.setBounds(95, 78, 107, 32);
			ReservedTicketPanel.add(ReservedTripLineLabel);
			
			ReservedTripBusLabel = new JLabel("TRIP BUS");
			ReservedTripBusLabel.setForeground(Color.WHITE);
			ReservedTripBusLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
			ReservedTripBusLabel.setBounds(309, 78, 92, 32);
			ReservedTicketPanel.add(ReservedTripBusLabel);
			
			ReservedTripDepartureLabel = new JLabel("DEPARTURE");
			ReservedTripDepartureLabel.setForeground(Color.WHITE);
			ReservedTripDepartureLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
			ReservedTripDepartureLabel.setBounds(448, 78, 122, 32);
			ReservedTicketPanel.add(ReservedTripDepartureLabel);
			
			ReservedTripDurationLabel = new JLabel("DURATION");
			ReservedTripDurationLabel.setForeground(Color.WHITE);
			ReservedTripDurationLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
			ReservedTripDurationLabel.setBounds(594, 78, 107, 32);
			ReservedTicketPanel.add(ReservedTripDurationLabel);
			
			ReservedDateTextBox1 = new JTextField();
			ReservedDateTextBox1.setEditable(false);
			ReservedDateTextBox1.setOpaque(false);
			ReservedDateTextBox1.setForeground(Color.WHITE);
			ReservedDateTextBox1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			ReservedDateTextBox1.setColumns(10);
			ReservedDateTextBox1.setCaretColor(Color.WHITE);
			ReservedDateTextBox1.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			ReservedDateTextBox1.setBounds(725, 145, 122, 32);
			ReservedTicketPanel.add(ReservedDateTextBox1);
			
			ReservedDateTextBox2 = new JTextField();
			ReservedDateTextBox2.setEditable(false);
			ReservedDateTextBox2.setOpaque(false);
			ReservedDateTextBox2.setForeground(Color.WHITE);
			ReservedDateTextBox2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			ReservedDateTextBox2.setColumns(10);
			ReservedDateTextBox2.setCaretColor(Color.WHITE);
			ReservedDateTextBox2.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			ReservedDateTextBox2.setBounds(725, 210, 122, 32);
			ReservedTicketPanel.add(ReservedDateTextBox2);
			
			ReservedDateTextBox3 = new JTextField();
			ReservedDateTextBox3.setEditable(false);
			ReservedDateTextBox3.setOpaque(false);
			ReservedDateTextBox3.setForeground(Color.WHITE);
			ReservedDateTextBox3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			ReservedDateTextBox3.setColumns(10);
			ReservedDateTextBox3.setCaretColor(Color.WHITE);
			ReservedDateTextBox3.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			ReservedDateTextBox3.setBounds(725, 275, 122, 32);
			ReservedTicketPanel.add(ReservedDateTextBox3);
			
			ReservedDateTextBox4 = new JTextField();
			ReservedDateTextBox4.setEditable(false);
			ReservedDateTextBox4.setOpaque(false);
			ReservedDateTextBox4.setForeground(Color.WHITE);
			ReservedDateTextBox4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
			ReservedDateTextBox4.setColumns(10);
			ReservedDateTextBox4.setCaretColor(Color.WHITE);
			ReservedDateTextBox4.setBorder(new LineBorder(SystemColor.textHighlight, 2));
			ReservedDateTextBox4.setBounds(725, 340, 122, 32);
			ReservedTicketPanel.add(ReservedDateTextBox4);
			
			ReservedTripDateLabel = new JLabel("DATE");
			ReservedTripDateLabel.setForeground(Color.WHITE);
			ReservedTripDateLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
			ReservedTripDateLabel.setBounds(754, 78, 59, 32);
			ReservedTicketPanel.add(ReservedTripDateLabel);
			
			ReservedTripLabel = new JLabel("");
			ReservedTripLabel.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 13));
			ReservedTripLabel.setBounds(674, 396, 370, 20);
			ReservedTicketPanel.add(ReservedTripLabel);
			
			ReservedTicketLabel = new JLabel("YOUR RESERVED TICKET LIST:");
			ReservedTicketLabel.setForeground(Color.WHITE);
			ReservedTicketLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
			ReservedTicketLabel.setBounds(36, 23, 317, 32);
			ReservedTicketPanel.add(ReservedTicketLabel);
			
	}
}
