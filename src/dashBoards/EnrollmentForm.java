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
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class EnrollmentForm implements ActionListener{
	
	Image imageLogo;
	Image iconImage;
	
	JFrame frame;
	
	//Student Information
	JTextField lastname;
	JTextField firstName;
	JTextField middleName;
	JTextField phoneNumber;
	JComboBox comboBox;
	JTextField address;
	JTextField birthdate;
	JTextField LRN;
	JComboBox comboBox_1;
	
	JLabel form137Label;
	
	//buttons
	JButton form137;
	JButton birthCertButton;
	JButton IDpicButton;
	JButton goodMoralButton;
	
	//form137 docs
	File form137File;
	String form137fileSource;
	Path form137source;
	Path form137destination;
	
	//birth certificate docs
	File birthCertFile;
	String birthCertfileSource;
	Path birthCertsource;
	Path birthCertdestination;
	
	//Good moral docs
	File goodMoralFile;
	String goodMoralfileSource;
	Path goodMoralsource;
	Path goodMoraldestination;
	
	//ID pic docs
	File idPicFile;
	String idPicfileSource;
	Path idPicsource;
	Path idPicdestination;
	
	JLabel form137FileNameDisplay;
	JLabel birthCertFileNameDisplay;
	JLabel IDpicFileNameDisplay;
	JLabel goodMoralFileNameDisplay;
	
	JButton cancelButton;
	JButton submitButton;
	
	DatabaseConnection database;
	
	public EnrollmentForm(DatabaseConnection database) {
		
		this.database = database;
		
		imageLogo = new ImageIcon(getClass().getResource("/images/yobhelBanner.jpg")).getImage();
		iconImage = new ImageIcon(getClass().getResource("/images/yobhel_logo.jpg")).getImage();
		
		frame = new JFrame("Enrollment Form");
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
		
		lastname = new JTextField();
		lastname.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lastname.setBounds(10, 61, 222, 30);
		mainForm.add(lastname);
		lastname.setColumns(10);
		
		//First Name
		JLabel firstNameLabel = new JLabel("First Name");
		firstNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		firstNameLabel.setBounds(252, 46, 90, 14);
		mainForm.add(firstNameLabel);
		firstName = new JTextField();
		firstName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		firstName.setColumns(10);
		firstName.setBounds(252, 61, 222, 30);
		mainForm.add(firstName);
		
		//Middle Name
		JLabel middleNameLabel = new JLabel("Middle Name");
		middleNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		middleNameLabel.setBounds(493, 46, 90, 14);
		mainForm.add(middleNameLabel);
		middleName = new JTextField();
		middleName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		middleName.setColumns(10);
		middleName.setBounds(493, 61, 222, 30);
		mainForm.add(middleName);
		
		//Phone Number
		JLabel phoneNumberLabel = new JLabel("Phone Number");
		phoneNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		phoneNumberLabel.setBounds(10, 167, 90, 14);
		mainForm.add(phoneNumberLabel);
		
		phoneNumber = new JTextField();
		phoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		phoneNumber.setColumns(10);
		phoneNumber.setBounds(10, 181, 201, 30);
		mainForm.add(phoneNumber);
		
		//Gender
		String[] Gender = {"Male", "Female"};
		comboBox = new JComboBox(Gender);
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
		address = new JTextField();
		address.setFont(new Font("Tahoma", Font.PLAIN, 13));
		address.setColumns(10);
		address.setBounds(281, 116, 321, 30);
		mainForm.add(address);
		
		//Birthdate
		JLabel birthdateLabel = new JLabel("Birthdate (YYYY-MM-DD)");
		birthdateLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		birthdateLabel.setBounds(132, 102, 121, 14);
		mainForm.add(birthdateLabel);
		birthdate = new JTextField();
		birthdate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		birthdate.setColumns(10);
		birthdate.setBounds(132, 116, 127, 30);
		mainForm.add(birthdate);
		
		//LRN
		JLabel LRN_label = new JLabel("LRN (Learner Reference Number)");
		LRN_label.setFont(new Font("Tahoma", Font.PLAIN, 10));
		LRN_label.setBounds(235, 167, 176, 14);
		mainForm.add(LRN_label);
		LRN = new JTextField();
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
		comboBox_1 = new JComboBox(strands);
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox_1.setBounds(472, 185, 130, 25);
		mainForm.add(comboBox_1);
		
		JLabel enrollmentReqLabel = new JLabel("Enrollment Requirements");
		enrollmentReqLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		enrollmentReqLabel.setBounds(10, 237, 222, 21);
		mainForm.add(enrollmentReqLabel);
		
		//Form137
		form137Label = new JLabel("Form 137");
		form137Label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		form137Label.setBounds(21, 269, 90, 14);
		mainForm.add(form137Label);
		form137 = new JButton("Choose a file");
		form137.setFocusable(false);
		form137.setFont(new Font("Tahoma", Font.PLAIN, 10));
		form137.addActionListener(this);
		form137.setBounds(22, 290, 95, 23);
		mainForm.add(form137);
		form137FileNameDisplay = new JLabel("No file chosen");
		form137FileNameDisplay.setBorder(new LineBorder(new Color(0, 0, 0)));
		form137FileNameDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		form137FileNameDisplay.setFont(new Font("Tahoma", Font.PLAIN, 9));
		form137FileNameDisplay.setBounds(117, 290, 101, 23);
		mainForm.add(form137FileNameDisplay);
		
		//Birth Certificate
		JLabel birthCertLabel = new JLabel("Birth Certificate");
		birthCertLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		birthCertLabel.setBounds(22, 331, 121, 14);
		mainForm.add(birthCertLabel);
		birthCertButton = new JButton("Choose a file");
		birthCertButton.setFocusable(false);
		birthCertButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		birthCertButton.setBounds(23, 352, 95, 23);
		birthCertButton.addActionListener(this);
		mainForm.add(birthCertButton);
		birthCertFileNameDisplay = new JLabel("No file chosen");
		birthCertFileNameDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		birthCertFileNameDisplay.setBorder(new LineBorder(new Color(0, 0, 0)));
		birthCertFileNameDisplay.setFont(new Font("Tahoma", Font.PLAIN, 9));
		birthCertFileNameDisplay.setBounds(117, 352, 101, 23);
		mainForm.add(birthCertFileNameDisplay);
		
		//2x2 ID
		JLabel IDpicLabel = new JLabel("2x2 ID picture");
		IDpicLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		IDpicLabel.setBounds(22, 398, 107, 14);
		mainForm.add(IDpicLabel);
		IDpicButton = new JButton("Choose a file");
		IDpicButton.setFocusable(false);
		IDpicButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		IDpicButton.setBounds(23, 419, 95, 23);
		IDpicButton.addActionListener(this);
		mainForm.add(IDpicButton);
		IDpicFileNameDisplay = new JLabel("No file chosen");
		IDpicFileNameDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		IDpicFileNameDisplay.setBorder(new LineBorder(new Color(0, 0, 0)));
		IDpicFileNameDisplay.setFont(new Font("Tahoma", Font.PLAIN, 9));
		IDpicFileNameDisplay.setBounds(117, 419, 101, 23);
		mainForm.add(IDpicFileNameDisplay);
		
		//Good Moral
		JLabel goodMoralLabel = new JLabel("Good Moral");
		goodMoralLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		goodMoralLabel.setBounds(268, 269, 107, 14);
		mainForm.add(goodMoralLabel);
		goodMoralButton = new JButton("Choose a file");
		goodMoralButton.setFocusable(false);
		goodMoralButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		goodMoralButton.setBounds(269, 290, 95, 23);
		goodMoralButton.addActionListener(this);
		mainForm.add(goodMoralButton);
		goodMoralFileNameDisplay = new JLabel("No file chosen");
		goodMoralFileNameDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		goodMoralFileNameDisplay.setBorder(new LineBorder(new Color(0, 0, 0)));
		goodMoralFileNameDisplay.setFont(new Font("Tahoma", Font.PLAIN, 9));
		goodMoralFileNameDisplay.setBounds(363, 290, 101, 23);
		mainForm.add(goodMoralFileNameDisplay);
		
		//Cancel button
		cancelButton = new JButton("Cancel");
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
		submitButton = new JButton("Submit");
		submitButton.setFont(new Font("Georgia", Font.PLAIN, 15));
		submitButton.setFocusable(false);
		submitButton.setBorder(null);
		submitButton.setBackground(new Color(251, 181, 23));
		submitButton.addActionListener(this);
		submitButton.setBounds(626, 437, 101, 25);
		mainForm.add(submitButton);
		
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == submitButton) {
			submitInformation();
		}
		
		if(e.getSource() == cancelButton) {
			frame.dispose();
			new LoginFrame();
		}
		
		if(e.getSource() == form137) {
			JFileChooser fileChooser = new JFileChooser();
			int result = fileChooser.showOpenDialog(null);
			
			if(result == JFileChooser.APPROVE_OPTION) {
		        form137File = new File(fileChooser.getSelectedFile().getAbsolutePath());
		        form137fileSource = String.valueOf(form137File);
		        form137FileNameDisplay.setText(form137File.getName());
			}
			
		}
		if(e.getSource() == birthCertButton) {
			JFileChooser fileChooser = new JFileChooser();
			int result = fileChooser.showOpenDialog(null);
			
			if(result == JFileChooser.APPROVE_OPTION) {
				birthCertFile = new File(fileChooser.getSelectedFile().getAbsolutePath());
				birthCertfileSource = String.valueOf(birthCertFile);
				birthCertFileNameDisplay.setText(birthCertFile.getName());
			}
		}
		if(e.getSource() == IDpicButton) {
			JFileChooser fileChooser = new JFileChooser();
			int result = fileChooser.showOpenDialog(null);
			
			if(result == JFileChooser.APPROVE_OPTION) {
				idPicFile = new File(fileChooser.getSelectedFile().getAbsolutePath());
				idPicfileSource = String.valueOf(idPicFile);
				IDpicFileNameDisplay.setText(idPicFile.getName());
			}
		}
		if(e.getSource() == goodMoralButton) {
			JFileChooser fileChooser = new JFileChooser();
			int result = fileChooser.showOpenDialog(null);
			
			if(result == JFileChooser.APPROVE_OPTION) {
				goodMoralFile = new File(fileChooser.getSelectedFile().getAbsolutePath());
				goodMoralfileSource = String.valueOf(goodMoralFile);
				goodMoralFileNameDisplay.setText(goodMoralFile.getName());
			}
		}
}

	
 	private void uploadForm137() {
        String folderPath = "C:\\Users\\PC\\OneDrive\\Desktop\\Form 137 uploads\\" + database.getStudentID();
        new File(folderPath).mkdirs();
        
        form137source = Paths.get(form137fileSource);
        form137destination = Paths.get(folderPath +"\\"+ form137File.getName());
        
        try {
			Files.copy(form137source, form137destination, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("Uploaded to: " + form137destination.toString());
			
		}
        catch (IOException exc) {
			exc.printStackTrace();
		}
	}

 	private void uploadBirthCert() {
        String folderPath = "C:\\Users\\PC\\OneDrive\\Desktop\\Birth Certificate uploads\\" + database.getStudentID();
        new File(folderPath).mkdirs();
        
        birthCertsource = Paths.get(birthCertfileSource);
        birthCertdestination = Paths.get(folderPath +"\\"+ birthCertFile.getName());
        
        try {
			Files.copy(birthCertsource, birthCertdestination, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("Uploaded to: " + birthCertdestination.toString());
			
		}
        catch (IOException exc) {
			exc.printStackTrace();
		}
	}
 	
 	private void uploadIDpic() {
        String folderPath = "C:\\Users\\PC\\OneDrive\\Desktop\\ID picture uploads\\" + database.getStudentID();
        new File(folderPath).mkdirs();
        
        idPicsource = Paths.get(idPicfileSource);
        idPicdestination = Paths.get(folderPath +"\\"+ idPicFile.getName());
        
        try {
			Files.copy(idPicsource, idPicdestination, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("Uploaded to: " + idPicdestination.toString());
			
		}
        catch (IOException exc) {
			exc.printStackTrace();
		}
	}
 	
 	private void uploadGoodMoral() {
        String folderPath = "C:\\Users\\PC\\OneDrive\\Desktop\\Good Moral Uploads\\" + database.getStudentID();
        new File(folderPath).mkdirs();
        
        goodMoralsource = Paths.get(goodMoralfileSource);
        goodMoraldestination = Paths.get(folderPath +"\\"+ goodMoralFile.getName());
        
        try {
			Files.copy(goodMoralsource, goodMoraldestination, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("Uploaded to: " + goodMoraldestination.toString());
			
		}
        catch (IOException exc) {
			exc.printStackTrace();
		}
	}
 	
	private void submitInformation() {
		int strandID = 0;
		boolean hasError = false;
		
		LocalDate bDate = null;
		
		String lastName = lastname.getText().toUpperCase().trim();
		String firstname = firstName.getText().toUpperCase().trim();
		String middlename = middleName.getText().toUpperCase().trim();
		String phonenumber = phoneNumber.getText().trim();
		String gender = (String) comboBox.getSelectedItem();
		String adrs = address.getText().toUpperCase().trim();
		String lrnNumber = LRN.getText().trim();
		
		String strands = (String) comboBox_1.getSelectedItem();
		switch(strands) {
			case "ABM": strandID = 1; break;
			case "GAS": strandID = 2; break;
			case "HUMSS": strandID = 3; break;
			case "ICT": strandID = 4; break;
			case "STEM": strandID = 5; break;
			case "EIM": strandID = 6; break;
		}
		
		if (lastName.length() > 50) {
	        JOptionPane.showMessageDialog(frame, "Last name is too long. Max 50 characters.");
	        hasError = true;}
		else if (firstname.length() > 50) {
	        JOptionPane.showMessageDialog(frame, "First name is too long. Max 50 characters.");
	        hasError = true;}
		else if (phonenumber.length() > 11) {
	        JOptionPane.showMessageDialog(frame, "Phone number is too long. Max 11 digits.");
	        hasError = true;}
		else if (lrnNumber.length() > 12) {
	        JOptionPane.showMessageDialog(frame, "LRN is too long. Max 12 characters.");
	        hasError = true;}
		
		if(hasError == false) {
			try {
				bDate = LocalDate.parse(birthdate.getText().trim());
			}
			catch(Exception error) {
				JOptionPane.showMessageDialog(frame, "Wrong date format. Use YYYY-MM-DD");
				hasError = true;
			}
		}
		
		if(hasError == false) {
			database.insertInformation(strandID, lrnNumber, lastName, firstname, 
					middlename, bDate, gender, adrs, phonenumber);
			
			uploadForm137();
			uploadBirthCert();
			uploadIDpic();
			uploadGoodMoral();
			database.insertEnrollment();
			database.insertDocument("Form-137",form137destination);
			database.insertDocument("Birth Certificate",birthCertdestination);
			database.insertDocument("ID Picture",idPicdestination);
			database.insertDocument("Good Moral",goodMoraldestination);
			
			new StudentDashBoard(database);
			frame.dispose();
			
		}
	}
}
