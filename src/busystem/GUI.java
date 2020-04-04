package busystem;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI extends JFrame implements ActionListener{

	private JPanel mainPanel;
	private JButton signUpBtn;
	private JButton signInBtn;
	private JPanel busPicPanel;
	private JLabel busPicLabel;
	private JPanel login_regpanel;
	private JPanel logform;
	private JPanel regform;
	private JLabel logUserLabel;
	private JLabel logPassLabel;
	private JTextField logUserTextBox;
	private JPasswordField logPassField;
	private JButton loginBtn;
	private JLabel regUserLabel;
	private JLabel regPassLabel;
	private JLabel regEmailLabel;
	private JTextField regUserTextBox;
	private JPasswordField regPassField;
	private JPasswordField regEmailTextBox;
	private JButton registerBtn;
	
	/**
	 * Create the frame.
	 */
	public GUI() {
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
		
		signUpBtn = new JButton("SIGN UP");
		signUpBtn.setBounds(650, 26, 106, 21);
		mainPanel.add(signUpBtn);
		
		signInBtn = new JButton("SIGN IN");
		signInBtn.setForeground(Color.WHITE);
		signInBtn.setBackground(Color.BLUE);
		signInBtn.setBounds(536, 26, 85, 21);
		mainPanel.add(signInBtn);
		
		//BUS PIC PANEL
		busPicPanel = new JPanel();
		busPicPanel.setBounds(0, 0, 357, 516);
		mainPanel.add(busPicPanel);
		
		busPicLabel = new JLabel("");
		busPicLabel.setBounds(100, 100, 347, 503);
	        ImageIcon img= new ImageIcon("images/buspic.png");
	        Image newImg = img.getImage();
	        Image scaledImage = newImg.getScaledInstance(busPicLabel.getWidth(), busPicLabel.getHeight(), Image.SCALE_SMOOTH);
	        busPicLabel.setIcon(new ImageIcon(scaledImage));
	        
		busPicPanel.add(busPicLabel);
		
		//LOGIN_REG PANEL
		login_regpanel = new JPanel();
		login_regpanel.setBounds(356, 86, 489, 430);
		mainPanel.add(login_regpanel);
		login_regpanel.setLayout(new CardLayout(0, 0));
		
		//LOG FORM
		logform = new JPanel();
		login_regpanel.add(logform, "name_36087380006400");
		logform.setLayout(null);
		
		logUserLabel = new JLabel("USERNAME");
		logUserLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		logUserLabel.setBounds(93, 99, 156, 25);
		logform.add(logUserLabel);
		
		logPassLabel = new JLabel("PASSWORD");
		logPassLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		logPassLabel.setBounds(93, 217, 156, 25);
		logform.add(logPassLabel);
		
		logUserTextBox = new JTextField();
		logUserTextBox.setBounds(90, 130, 276, 34);
		logform.add(logUserTextBox);
		logUserTextBox.setColumns(10);
		
		logPassField = new JPasswordField();
		logPassField.setBounds(90, 252, 276, 34);
		logform.add(logPassField);
		
		loginBtn = new JButton("LOGIN");
		loginBtn.setBounds(142, 323, 167, 34);
		logform.add(loginBtn);
		
		//REG FORM
		regform = new JPanel();
		login_regpanel.add(regform, "name_36117726541300");
		regform.setLayout(null);
		
		regUserLabel = new JLabel("USERNAME");
		regUserLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		regUserLabel.setBounds(93, 53, 156, 25);
		regform.add(regUserLabel);
		
		regPassLabel = new JLabel("PASSWORD");
		regPassLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		regPassLabel.setBounds(93, 146, 156, 25);
		regform.add(regPassLabel);
		
		regUserTextBox = new JTextField();
		regUserTextBox.setBounds(90, 88, 276, 34);
		regform.add(regUserTextBox);
		regUserTextBox.setColumns(10);
		
		regPassField = new JPasswordField();
		regPassField.setBounds(90, 181, 276, 34);
		regform.add(regPassField);
		
		regEmailLabel = new JLabel("E-MAIL");
		regEmailLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		regEmailLabel.setBounds(93, 236, 156, 25);
		regform.add(regEmailLabel);
		
		regEmailTextBox = new JPasswordField();
		regEmailTextBox.setBounds(90, 271, 276, 34);
		regform.add(regEmailTextBox);
		
		registerBtn = new JButton("REGISTER");
		registerBtn.setBounds(140, 334, 167, 34);
		regform.add(registerBtn);
		
		//dodavanje ActionListenera na buttone
		
		
	}
	
	//Ovdje idu implementacije buttona
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		GUI sucelje = new GUI();
		sucelje.setVisible(true);
	}
}
