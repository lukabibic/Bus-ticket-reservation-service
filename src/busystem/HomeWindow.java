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

public class HomeWindow extends JFrame{

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
	JTextField logUserTextBox;
	JPasswordField logPassField;
	public JButton loginBtn;
	private JLabel regUserLabel;
	private JLabel regPassLabel;
	private JLabel regEmailLabel;
	private JTextField regUserTextBox;
	private JPasswordField regPassField;
	private JTextField regEmailTextBox;
	public JButton registerBtn;
	public String username;
	
	/**
	 * Create the frame.
	 */
	public HomeWindow() {
		setTitle("Bus Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 849, 554);
		setResizable(false);
		
		//definiranje komponenti
		
		//MAIN PANEL
		mainPanel = new JPanel();
		mainPanel.setBackground(Color.DARK_GRAY);
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		signUpBtn =new JButton("SIGN UP");
		signUpBtn.setForeground(Color.WHITE);
		signUpBtn.setOpaque(false);
		signUpBtn.setBackground(SystemColor.textHighlight);
		signUpBtn.setBorder(new LineBorder(SystemColor.textHighlight, 2));
		signUpBtn.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		signUpBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regform.setVisible(true);
				logform.setVisible(false);
				signUpBtn.setOpaque(true);
				signInBtn.setOpaque(false);
				signInBtn.setBorder(new LineBorder(SystemColor.textHighlight, 2));
				
			}
		});
		signUpBtn.setBounds(651, 25, 142, 37);
		mainPanel.add(signUpBtn);
		
		signInBtn = new JButton("SIGN IN");
		signInBtn.setBorder(null);
		signInBtn.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		signInBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logform.setVisible(true);
				regform.setVisible(false);
				signInBtn.setOpaque(true);
				signUpBtn.setOpaque(false);
				signUpBtn.setBorder(new LineBorder(SystemColor.textHighlight, 2));
				
			}
		});
		signInBtn.setForeground(Color.WHITE);
		signInBtn.setBackground(SystemColor.textHighlight);
		signInBtn.setBounds(437, 25, 142, 37);
		mainPanel.add(signInBtn);
		
		//BUS PIC PANEL
		busPicPanel = new JPanel();
		busPicPanel.setBackground(Color.BLACK);
		busPicPanel.setBounds(0, 0, 357, 526);
		mainPanel.add(busPicPanel);
		
		busPicLabel = new JLabel("");
		busPicLabel.setBounds(0, 0, 357, 526);
			Image image = new ImageIcon(HomeWindow.class.getResource("/images/buspic.png")).getImage();
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
		logPassLabel.setBounds(93, 217, 156, 25);
		logform.add(logPassLabel);
		
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
		logPassField.setBounds(90, 252, 276, 34);
		logform.add(logPassField);
		
		loginBtn = new JButton("LOGIN");
		loginBtn.setForeground(Color.WHITE);
		loginBtn.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		loginBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		loginBtn.setBackground(SystemColor.textHighlight);
		loginBtn.setBorder(new LineBorder(new Color(0, 120, 215), 2));
		loginBtn.setBounds(142, 323, 167, 34);
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
		regUserLabel.setBounds(93, 53, 156, 25);
		regform.add(regUserLabel);
		
		regPassLabel = new JLabel("PASSWORD");
		regPassLabel.setForeground(Color.WHITE);
		regPassLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		regPassLabel.setBounds(93, 146, 156, 25);
		regform.add(regPassLabel);
		
		regUserTextBox = new JTextField();
		regUserTextBox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		regUserTextBox.setCaretColor(Color.WHITE);
		regUserTextBox.setForeground(Color.WHITE);
		regUserTextBox.setBorder(new LineBorder(SystemColor.textHighlight, 2));
		regUserTextBox.setOpaque(false);
		regUserTextBox.setBounds(90, 88, 276, 34);
		regform.add(regUserTextBox);
		regUserTextBox.setColumns(10);
		
		
		regPassField = new JPasswordField();
		regPassField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		regPassField.setCaretColor(Color.WHITE);
		regPassField.setForeground(Color.WHITE);
		regPassField.setOpaque(false);
		regPassField.setBorder(new LineBorder(SystemColor.textHighlight, 2));
		regPassField.setBounds(90, 181, 276, 34);
		regform.add(regPassField);
		
		regEmailLabel = new JLabel("E-MAIL");
		regEmailLabel.setForeground(Color.WHITE);
		regEmailLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		regEmailLabel.setBounds(93, 236, 156, 25);
		regform.add(regEmailLabel);
		
		regEmailTextBox = new JTextField();
		regEmailTextBox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		regEmailTextBox.setCaretColor(Color.WHITE);
		regEmailTextBox.setOpaque(false);
		regEmailTextBox.setForeground(Color.WHITE);
		regEmailTextBox.setColumns(10);
		regEmailTextBox.setBorder(new LineBorder(SystemColor.textHighlight, 2));
		regEmailTextBox.setBounds(90, 271, 276, 34);
		regform.add(regEmailTextBox);
		
		registerBtn = new JButton("REGISTER");	
		registerBtn.setBackground(SystemColor.textHighlight);
		registerBtn.setBorder(new LineBorder(SystemColor.textHighlight, 2));
		registerBtn.setForeground(Color.WHITE);
		registerBtn.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		registerBtn.setBounds(140, 334, 167, 34);
		regform.add(registerBtn);
		
	}
}
