package dashBoards;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class EnrollmentForm {
	
	Image imageLogo;
	Image iconImage;
	
	public EnrollmentForm() {
		
		imageLogo = new ImageIcon(getClass().getResource("/images/yobhelBanner.jpg")).getImage();
		iconImage = new ImageIcon(getClass().getResource("/images/yobhel_logo.jpg")).getImage();
		
		JFrame frame = new JFrame("Enrollment Form");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout(0, 0));
		frame.setIconImage(iconImage);
		frame.setBounds(100, 100, 832, 580);
		frame.setResizable(false);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(new Color(255, 255, 255));
		centerPanel.setLayout(new BorderLayout(0, 0));
		frame.add(centerPanel, BorderLayout.CENTER);
		
		JPanel westPanel = new JPanel();
		westPanel.setBackground(new Color(255, 255, 255));
		westPanel.setPreferredSize(new Dimension(30, 0));
		centerPanel.add(westPanel, BorderLayout.WEST);
		
		JPanel northPanel = new JPanel();
		northPanel.setBackground(new Color(255, 255, 255));
		northPanel.setPreferredSize(new Dimension(0, 30));
		centerPanel.add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(null);
		
		JPanel eastPanel = new JPanel();
		eastPanel.setBackground(new Color(255, 255, 255));
		eastPanel.setPreferredSize(new Dimension(30, 0));
		centerPanel.add(eastPanel, BorderLayout.EAST);
		
		JPanel southPanel = new JPanel();
		southPanel.setBackground(new Color(255, 255, 255));
		southPanel.setPreferredSize(new Dimension(0, 30));
		centerPanel.add(southPanel, BorderLayout.SOUTH);
		
		JLabel titleLabel = new JLabel("📝 Enrollment Form");
		titleLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		titleLabel.setBounds(10, 3, 200, 25);
		northPanel.add(titleLabel);
		
		JPanel mainForm = new JPanel();
		mainForm.setBorder(new LineBorder(new Color(48, 46, 127), 5, true));
		mainForm.setBackground(new Color(255, 255, 255));
		centerPanel.add(mainForm, BorderLayout.CENTER);
		mainForm.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Student Information");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(10, 11, 176, 21);
		mainForm.add(lblNewLabel_1);
		
		JPanel linePanel = new JPanel() {
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
	        g.drawLine(0, 0, 700, 0);
	    }
	};
		linePanel.setOpaque(false);
		linePanel.setBounds(10, 35, 700, 2); 
		mainForm.add(linePanel);
		
		//Last Name
		JLabel lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lastNameLabel.setBounds(10, 46, 90, 14);
		mainForm.add(lastNameLabel);
		JTextField lastname = new JTextField();
		lastname.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lastname.setBounds(10, 61, 222, 30);
		mainForm.add(lastname);
		lastname.setColumns(10);
		
		//First Name
		JLabel firstNameLabel = new JLabel("First Name");
		firstNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		firstNameLabel.setBounds(252, 46, 90, 14);
		mainForm.add(firstNameLabel);
		JTextField firstName = new JTextField();
		firstName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		firstName.setColumns(10);
		firstName.setBounds(252, 61, 222, 30);
		mainForm.add(firstName);
		
		//Middle Name
		JLabel middleNameLabel = new JLabel("Middle Name");
		middleNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		middleNameLabel.setBounds(493, 46, 90, 14);
		mainForm.add(middleNameLabel);
		JTextField middleName = new JTextField();
		middleName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		middleName.setColumns(10);
		middleName.setBounds(493, 61, 222, 30);
		mainForm.add(middleName);
		
		//Phone Number
		JLabel phoneNumberLabel = new JLabel("Phone Number");
		phoneNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		phoneNumberLabel.setBounds(10, 167, 90, 14);
		mainForm.add(phoneNumberLabel);
		JTextField phoneNumber = new JTextField();
		phoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		phoneNumber.setColumns(10);
		phoneNumber.setBounds(10, 181, 201, 30);
		mainForm.add(phoneNumber);
		
		//Gender
		String[] Gender = {"Male", "Female"};
		JComboBox comboBox = new JComboBox(Gender);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setBounds(10, 116, 101, 30);
		mainForm.add(comboBox);
		JLabel genderLabel = new JLabel("Gender");
		genderLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		genderLabel.setBounds(10, 102, 90, 14);
		mainForm.add(genderLabel);
		
		//Address
		JLabel addressLabel = new JLabel("Address (House No., Street, Barangay, City/Municipality, Province)");
		addressLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		addressLabel.setBounds(281, 102, 321, 14);
		mainForm.add(addressLabel);
		JTextField address = new JTextField();
		address.setFont(new Font("Tahoma", Font.PLAIN, 13));
		address.setColumns(10);
		address.setBounds(281, 116, 321, 30);
		mainForm.add(address);
		
		//Birthdate
		JLabel birthdateLabel = new JLabel("Birthdate (MM/DD/YYYY)");
		birthdateLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		birthdateLabel.setBounds(132, 102, 121, 14);
		mainForm.add(birthdateLabel);
		JTextField birthdate = new JTextField();
		birthdate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		birthdate.setColumns(10);
		birthdate.setBounds(132, 116, 127, 30);
		mainForm.add(birthdate);
		
		//LRN
		JLabel LRN_label = new JLabel("LRN (Learner Reference Number)");
		LRN_label.setFont(new Font("Tahoma", Font.PLAIN, 10));
		LRN_label.setBounds(235, 167, 176, 14);
		mainForm.add(LRN_label);
		JTextField LRN = new JTextField();
		LRN.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LRN.setColumns(10);
		LRN.setBounds(235, 181, 201, 30);
		mainForm.add(LRN);
		
		//Strand
		JLabel strandLabel = new JLabel("Strand You Want to Enroll in");
		strandLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		strandLabel.setBounds(472, 167, 144, 14);
		mainForm.add(strandLabel);
		String[] strands = {"ABM", "STEM", "HUMSS" , "GAS" , "IA" , "ICT"};
		JComboBox comboBox_1 = new JComboBox(strands);
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox_1.setBounds(472, 185, 130, 25);
		mainForm.add(comboBox_1);
		
		JLabel enrollmentReqLabel = new JLabel("Enrollment Requirements");
		enrollmentReqLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		enrollmentReqLabel.setBounds(10, 237, 222, 21);
		mainForm.add(enrollmentReqLabel);
		
		//Form137
		JLabel form137Label = new JLabel("Form 137");
		form137Label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		form137Label.setBounds(21, 269, 90, 14);
		mainForm.add(form137Label);
		JButton form137 = new JButton("Choose a file");
		form137.setFocusable(false);
		form137.setFont(new Font("Tahoma", Font.PLAIN, 10));
		form137.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		form137.setBounds(22, 290, 95, 23);
		mainForm.add(form137);
		JLabel form137File = new JLabel("New label");
		form137File.setBorder(new LineBorder(new Color(0, 0, 0)));
		form137File.setHorizontalAlignment(SwingConstants.CENTER);
		form137File.setBounds(117, 290, 101, 23);
		mainForm.add(form137File);
		
		//Birth Certificate
		JLabel birthCertLabel = new JLabel("Birth Certificate");
		birthCertLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		birthCertLabel.setBounds(22, 331, 121, 14);
		mainForm.add(birthCertLabel);
		JButton birthCertButton = new JButton("Choose a file");
		birthCertButton.setFocusable(false);
		birthCertButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		birthCertButton.setBounds(23, 352, 95, 23);
		mainForm.add(birthCertButton);
		JLabel birthCertFile = new JLabel("New label");
		birthCertFile.setHorizontalAlignment(SwingConstants.CENTER);
		birthCertFile.setBorder(new LineBorder(new Color(0, 0, 0)));
		birthCertFile.setBounds(117, 352, 101, 23);
		mainForm.add(birthCertFile);
		
		//2x2 ID
		JLabel IDpicLabel = new JLabel("2x2 ID picture");
		IDpicLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		IDpicLabel.setBounds(22, 398, 107, 14);
		mainForm.add(IDpicLabel);
		JButton IDpicButton = new JButton("Choose a file");
		IDpicButton.setFocusable(false);
		IDpicButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		IDpicButton.setBounds(23, 419, 95, 23);
		mainForm.add(IDpicButton);
		JLabel IDpicFile = new JLabel("New label");
		IDpicFile.setHorizontalAlignment(SwingConstants.CENTER);
		IDpicFile.setBorder(new LineBorder(new Color(0, 0, 0)));
		IDpicFile.setBounds(117, 419, 101, 23);
		mainForm.add(IDpicFile);
		
		//Good Moral
		JLabel goodMoralLabel = new JLabel("Good Moral");
		goodMoralLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		goodMoralLabel.setBounds(268, 269, 107, 14);
		mainForm.add(goodMoralLabel);
		JButton goodMoralButton = new JButton("Choose a file");
		goodMoralButton.setFocusable(false);
		goodMoralButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		goodMoralButton.setBounds(269, 290, 95, 23);
		mainForm.add(goodMoralButton);
		JLabel goodMoralFile = new JLabel("New label");
		goodMoralFile.setHorizontalAlignment(SwingConstants.CENTER);
		goodMoralFile.setBorder(new LineBorder(new Color(0, 0, 0)));
		goodMoralFile.setBounds(363, 290, 101, 23);
		mainForm.add(goodMoralFile);
		
		//Cancel button
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setOpaque(true);
		cancelButton.setForeground(new Color(48, 46, 127));
		cancelButton.setFont(new Font("Georgia", Font.PLAIN, 15));
		cancelButton.setFocusable(false);
		cancelButton.setContentAreaFilled(true);
		cancelButton.setBorder(new LineBorder(new Color(48, 46, 127), 2, true));
		cancelButton.setBackground(Color.WHITE);
		cancelButton.setBounds(531, 437, 85, 25);
		mainForm.add(cancelButton);
		
		//Submit Button
		JButton submitButton = new JButton("Submit");
		submitButton.setFont(new Font("Georgia", Font.PLAIN, 15));
		submitButton.setFocusable(false);
		submitButton.setBorder(null);
		submitButton.setBackground(new Color(251, 181, 23));
		submitButton.setBounds(626, 437, 101, 25);
		mainForm.add(submitButton);
		
		frame.setVisible(true);
		
	}

}
