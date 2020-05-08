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

public class LoginGUI extends JFrame{

	private JPanel mainPanel;
	JButton signUpBtn;
	JButton signInBtn;
	private JPanel busPicPanel;
	private JLabel busPicLabel;
	private JPanel login_regpanel;
	 JPanel logform;
	 JPanel regform;
	private JLabel logUserLabel;
	private JLabel logPassLabel;
	JTextField logUserTextBox;
	JPasswordField logPassField;
	public JButton loginBtn;
	private JLabel regUserLabel;
	private JLabel regPassLabel;
	private JLabel regEmailLabel;
	JTextField regUserTextBox;
	JPasswordField regPassField;
	JTextField regEmailTextBox;
	public JButton registerBtn;
	public String username;
	JLabel logErrLabel;
	JLabel regUserErrLabel;
	JLabel regEmailErrLabel;
	private JLabel regFirstNameLabel;
	private JLabel regLastNameLabel;
	JTextField regFirstNameTextBox;
	JTextField regLastNameTextBox;
	
	/**
	 * Create the frame.
	 */
	public LoginGUI() {
		setTitle("Bus Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 849, 554);
		setResizable(false);
		
		//definiranje komponenti
		
		//MAIN PANEL
		mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		//BUS PIC PANEL
		busPicPanel = new JPanel();
		busPicPanel.setBackground(Color.BLACK);
		busPicPanel.setBounds(0, 0, 357, 526);
		mainPanel.add(busPicPanel);
		
		busPicLabel = new JLabel("");
		busPicLabel.setBounds(0, 0, 357, 526);
			Image image = new ImageIcon(LoginGUI.class.getResource("/images/buspic.png")).getImage();
	        Image scaledImage = image.getScaledInstance(busPicLabel.getWidth(), busPicLabel.getHeight(), Image.SCALE_SMOOTH);
	        busPicPanel.setLayout(null);
	        busPicLabel.setIcon(new ImageIcon(scaledImage));
	        
		busPicPanel.add(busPicLabel);
		
		//LOGIN_REG PANEL
		login_regpanel = new JPanel();
		login_regpanel.setBounds(356, 86, 489, 440);
		mainPanel.add(login_regpanel);
		login_regpanel.setLayout(new CardLayout(0, 0));
		
		//LOG FORM
		logform = new JPanel();
		logform.setBorder(new MatteBorder(4, 0, 0, 0, (Color) Color.WHITE));
		logform.setBackground(Color.DARK_GRAY);
		login_regpanel.add(logform, "name_36087380006400");
		logform.setLayout(null);
		
		logUserLabel = new JLabel("USERNAME");
		logUserLabel.setForeground(Color.WHITE);
		logUserLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		logUserLabel.setBounds(93, 99, 156, 25);
		logform.add(logUserLabel);
		
		logPassLabel = new JLabel("PASSWORD");
		logPassLabel.setForeground(Color.WHITE);
		logPassLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		logPassLabel.setBounds(93, 193, 156, 25);
		logform.add(logPassLabel);
		
		logErrLabel = new JLabel("");
		logErrLabel.setForeground(Color.RED);
		logErrLabel.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 13));
		logErrLabel.setBounds(93, 272, 273, 19);
		logErrLabel.setVisible(false);
		logform.add(logErrLabel);
		
		logUserTextBox = new JTextField();
		logUserTextBox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		logUserTextBox.setCaretColor(Color.WHITE);
		logUserTextBox.setForeground(Color.WHITE);
		logUserTextBox.setOpaque(false);
		logUserTextBox.setBorder(new LineBorder(new Color(0, 120, 215), 2));
		logUserTextBox.setBounds(90, 130, 276, 34);
		logform.add(logUserTextBox);
		logUserTextBox.setColumns(10);
		
		logPassField = new JPasswordField();
		logPassField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		logPassField.setCaretColor(Color.WHITE);
		logPassField.setForeground(Color.WHITE);
		logPassField.setOpaque(false);
		logPassField.setBorder(new LineBorder(SystemColor.textHighlight, 2));
		logPassField.setBounds(90, 228, 276, 34);
		logform.add(logPassField);
		
		loginBtn = new JButton("LOGIN");
		loginBtn.setForeground(Color.WHITE);
		loginBtn.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		loginBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		loginBtn.setBackground(SystemColor.textHighlight);
		loginBtn.setBorder(new LineBorder(new Color(0, 120, 215), 2));
		loginBtn.setBounds(143, 311, 167, 34);
		logform.add(loginBtn);
		
		//REG FORM
		regform = new JPanel();
		regform.setBorder(new MatteBorder(4, 0, 0, 0, (Color) new Color(255, 255, 255)));
		regform.setBackground(Color.DARK_GRAY);
		login_regpanel.add(regform, "name_36117726541300");
		regform.setLayout(null);
		
		regUserLabel = new JLabel("USERNAME");
		regUserLabel.setForeground(Color.WHITE);
		regUserLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		regUserLabel.setBounds(34, 147, 156, 25);
		regform.add(regUserLabel);
		
		regPassLabel = new JLabel("PASSWORD");
		regPassLabel.setForeground(Color.WHITE);
		regPassLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		regPassLabel.setBounds(281, 147, 156, 25);
		regform.add(regPassLabel);
		
		regFirstNameLabel = new JLabel("FIRST NAME");
		regFirstNameLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		regFirstNameLabel.setForeground(Color.WHITE);
		regFirstNameLabel.setBounds(34, 34, 156, 25);
		regform.add(regFirstNameLabel);
		
		regLastNameLabel = new JLabel("LAST NAME");
		regLastNameLabel.setForeground(Color.WHITE);
		regLastNameLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		regLastNameLabel.setBounds(281, 33, 156, 25);
		regform.add(regLastNameLabel);
		
		regUserTextBox = new JTextField();
		regUserTextBox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		regUserTextBox.setCaretColor(Color.WHITE);
		regUserTextBox.setForeground(Color.WHITE);
		regUserTextBox.setBorder(new LineBorder(SystemColor.textHighlight, 2));
		regUserTextBox.setOpaque(false);
		regUserTextBox.setBounds(27, 182, 187, 34);
		regform.add(regUserTextBox);
		regUserTextBox.setColumns(10);
		
		regUserErrLabel = new JLabel("");
		regUserErrLabel.setForeground(Color.RED);
		regUserErrLabel.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 13));
		regUserErrLabel.setBounds(35, 226, 214, 19);
		regUserErrLabel.setVisible(false);
		regform.add(regUserErrLabel);
		
		
		regPassField = new JPasswordField();
		regPassField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		regPassField.setCaretColor(Color.WHITE);
		regPassField.setForeground(Color.WHITE);
		regPassField.setOpaque(false);
		regPassField.setBorder(new LineBorder(SystemColor.textHighlight, 2));
		regPassField.setBounds(276, 182, 187, 34);
		regform.add(regPassField);
		
		regEmailLabel = new JLabel("E-MAIL");
		regEmailLabel.setForeground(Color.WHITE);
		regEmailLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		regEmailLabel.setBounds(119, 255, 156, 25);
		regform.add(regEmailLabel);
		
		regEmailErrLabel = new JLabel("");
		regEmailErrLabel.setForeground(Color.RED);
		regEmailErrLabel.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 13));
		regEmailErrLabel.setBounds(119, 332, 253, 19);
		regEmailErrLabel.setVisible(false);
		regform.add(regEmailErrLabel);
		
		regEmailTextBox = new JTextField();
		regEmailTextBox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		regEmailTextBox.setCaretColor(Color.WHITE);
		regEmailTextBox.setOpaque(false);
		regEmailTextBox.setForeground(Color.WHITE);
		regEmailTextBox.setColumns(10);
		regEmailTextBox.setBorder(new LineBorder(SystemColor.textHighlight, 2));
		regEmailTextBox.setBounds(110, 288, 276, 34);
		regform.add(regEmailTextBox);
		
		registerBtn = new JButton("REGISTER");	
		registerBtn.setBackground(SystemColor.textHighlight);
		registerBtn.setBorder(new LineBorder(SystemColor.textHighlight, 2));
		registerBtn.setForeground(Color.WHITE);
		registerBtn.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		registerBtn.setBounds(142, 369, 167, 34);
		regform.add(registerBtn);
		
		regFirstNameTextBox = new JTextField();
		regFirstNameTextBox.setOpaque(false);
		regFirstNameTextBox.setForeground(Color.WHITE);
		regFirstNameTextBox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		regFirstNameTextBox.setCaretColor(Color.WHITE);
		regFirstNameTextBox.setBorder(new LineBorder(SystemColor.textHighlight, 2));
		regFirstNameTextBox.setBounds(27, 70, 187, 34);
		regform.add(regFirstNameTextBox);
		regFirstNameTextBox.setColumns(10);
		
		regLastNameTextBox = new JTextField();
		regLastNameTextBox.setOpaque(false);
		regLastNameTextBox.setForeground(Color.WHITE);
		regLastNameTextBox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		regLastNameTextBox.setCaretColor(Color.WHITE);
		regLastNameTextBox.setBorder(new LineBorder(SystemColor.textHighlight, 2));
		regLastNameTextBox.setBounds(276, 70, 187, 34);
		regform.add(regLastNameTextBox);
		regLastNameTextBox.setColumns(10);
		
		//Form_Butt_panel
		
		JPanel Form_butt_panel = new JPanel();
		Form_butt_panel.setBackground(Color.DARK_GRAY);
		Form_butt_panel.setBounds(356, 0, 489, 87);
		mainPanel.add(Form_butt_panel);
		Form_butt_panel.setLayout(null);
		
		signInBtn = new JButton("SIGN IN");
		signInBtn.setBounds(56, 24, 142, 37);
		Form_butt_panel.add(signInBtn);
		signInBtn.setBorder(null);
		signInBtn.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		
		signInBtn.setForeground(Color.WHITE);
		signInBtn.setBackground(SystemColor.textHighlight);
		
		signUpBtn =new JButton("SIGN UP");
		signUpBtn.setBounds(298, 24, 142, 37);
		Form_butt_panel.add(signUpBtn);
		signUpBtn.setForeground(Color.WHITE);
		signUpBtn.setOpaque(false);
		signUpBtn.setBackground(SystemColor.textHighlight);
		signUpBtn.setBorder(new LineBorder(SystemColor.textHighlight, 2));
		signUpBtn.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
	}
}
