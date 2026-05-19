package dashBoards;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class EditStudentInfo implements ActionListener{
	
	JFrame frame;
	
	private JTextField passwordTextfield;
	private JTextField firstNameTextField;
	private JTextField middleNameTextField;
	private JTextField lastNameTextField;
	
	private JLabel suffixLabel;
	private JTextField suffix;
	
	private JTextField lrnTextField;
	private JTextField birthdateTextfield;
	private JComboBox comboBox;
	private JTextField phoneNumberTextfield;
	private JTextField emailTextfield;
	private JTextField usernameTextfield;
	private JComboBox enrollmentComboBox;
	
	private JTextField houseNumber;
	private JTextField street;
	private JTextField barangay;
	private JTextField municipality;
	private JTextField province;
	
	private JLabel houseNumberLabel;
	private JLabel streetLabel;
	private JLabel barangayLabel;
	private JLabel municipalityLabel;
	private JLabel provinceLabel;
	
	private int studentID;
	private int enrollmentID;
	
	JButton saveButton;
	
	RegistrarDatabaseConnection database = new RegistrarDatabaseConnection();
	
	public EditStudentInfo(int student_id){
		
		this.studentID = student_id;
		this.enrollmentID = database.getEnrollmentID(student_id);
		
		int sectionID = database.getSectionID(enrollmentID);
		
		Object []classRoomData = database.getClassInfo(sectionID);
		Object []data = database.getStudentInformation(student_id);
		
		String lastNameData = String.valueOf(data[1]);
		String lrnData = String.valueOf(data[2]);
		String birthdateData = String.valueOf(data[3]);
		String genderData = String.valueOf(data[4]);
		String phoneNumberData = String.valueOf(data[5]);
		//String addressData = String.valueOf(data[6]);
		String emailData = String.valueOf(data[7]);
		String accountUsername = String.valueOf(data[9]);
		String accountPassword = String.valueOf(data[10]);;
		String firstNameData = String.valueOf(data[11]);
		String middleNameData = String.valueOf(data[12]);
		
		String strsuffix = String.valueOf(data[13]);
		String strhouseNumber = String.valueOf(data[14]);
		String strstreet = String.valueOf(data[15]);
		String strbarangay = String.valueOf(data[16]);
		String strmunicipality = String.valueOf(data[17]);
		String strprovince = String.valueOf(data[18]);
		
		
		Image iconImage = new ImageIcon(getClass().getResource("/images/yobhel_logo.jpg")).getImage();
		
		frame = new JFrame("Edit");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(new BorderLayout(0, 0));
		frame.setIconImage(iconImage);
		frame.setBounds(100, 100, 500, 441);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		JPanel backPanel = new JPanel();
		backPanel.setBackground(new Color(240, 240, 240));
		frame.add(backPanel, BorderLayout.CENTER);
		backPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel headerPanel = new JPanel();
		headerPanel.setBackground(new Color(48, 46, 127));
		headerPanel.setPreferredSize(new Dimension(10, 30));
		backPanel.add(headerPanel, BorderLayout.NORTH);
		headerPanel.setLayout(null);
		
		JLabel editStudentInfoHeader = new JLabel("Edit Student Information");
		editStudentInfoHeader.setForeground(new Color(251, 181, 23));
		editStudentInfoHeader.setBounds(10, 9, 340, 14);
		headerPanel.add(editStudentInfoHeader);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		backPanel.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel firstName = new JLabel("First Name: ");
		firstName.setBounds(10, 17, 72, 14);
		panel.add(firstName);
		
		JLabel LRN = new JLabel("LRN: ");
		LRN.setBounds(10, 101, 72, 14);
		panel.add(LRN);
		
		JLabel birthdate = new JLabel("Birthdate: ");
		birthdate.setBounds(10, 130, 72, 14);
		panel.add(birthdate);
		
		JLabel gender = new JLabel("Gender: ");
		gender.setBounds(10, 158, 72, 14);
		panel.add(gender);
		
		JLabel phoneNumber = new JLabel("Phone number: ");
		phoneNumber.setBounds(10, 186, 102, 14);
		panel.add(phoneNumber);
		
		JLabel address = new JLabel("Address: ");
		address.setBounds(10, 224, 72, 14);
		panel.add(address);
		
		JLabel emailAddress = new JLabel("Email: ");
		emailAddress.setBounds(10, 253, 72, 14);
		panel.add(emailAddress);
		
		JLabel username = new JLabel("Username: ");
		username.setBounds(10, 280, 79, 14);
		panel.add(username);
		
		JLabel password = new JLabel("Password: ");
		password.setBounds(10, 307, 72, 14);
		panel.add(password);
		
		saveButton = new JButton("SAVE");
		saveButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		saveButton.addActionListener(this);
		saveButton.setFocusable(false);
		saveButton.setBounds(400, 330, 64, 23);
		panel.add(saveButton);
		
		firstNameTextField = new JTextField();
		firstNameTextField.setColumns(10);
		firstNameTextField.setBounds(92, 13, 270, 20);
		firstNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		firstNameTextField.setText(firstNameData);
		panel.add(firstNameTextField);
		
		middleNameTextField = new JTextField();
		middleNameTextField.setText(middleNameData);
		middleNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		middleNameTextField.setColumns(10);
		middleNameTextField.setBounds(92, 40, 270, 20);
		panel.add(middleNameTextField);
		
		lastNameTextField = new JTextField();
		lastNameTextField.setText(lastNameData);
		lastNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lastNameTextField.setColumns(10);
		lastNameTextField.setBounds(92, 68, 147, 20);
		panel.add(lastNameTextField);
		
		suffixLabel = new JLabel("Suffix:");
		suffixLabel.setBounds(255, 72, 44, 14);
		panel.add(suffixLabel);
		
		suffix = new JTextField();
		suffix.setText(strsuffix);
		suffix.setFont(new Font("Tahoma", Font.PLAIN, 11));
		suffix.setBounds(303, 68, 59, 20);
		panel.add(suffix);
		
		lrnTextField = new JTextField();
		lrnTextField.setColumns(10);
		lrnTextField.setBounds(92, 97, 270, 20);
		lrnTextField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lrnTextField.setText(lrnData);
		panel.add(lrnTextField);
		
		birthdateTextfield = new JTextField();
		birthdateTextfield.setColumns(10);
		birthdateTextfield.setBounds(92, 126, 270, 20);
		birthdateTextfield.setFont(new Font("Tahoma", Font.PLAIN, 11));
		birthdateTextfield.setText(birthdateData);
		panel.add(birthdateTextfield);
		
		String[] Gender = {"Male", "Female"};
		comboBox = new JComboBox(Gender);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setBounds(92, 154, 101, 20);
		comboBox.setSelectedItem(genderData);
		panel.add(comboBox);
		
		phoneNumberTextfield = new JTextField();
		phoneNumberTextfield.setColumns(10);
		phoneNumberTextfield.setBounds(112, 182, 250, 20);
		phoneNumberTextfield.setFont(new Font("Tahoma", Font.PLAIN, 11));
		phoneNumberTextfield.setText(phoneNumberData);
		panel.add(phoneNumberTextfield);
		
		houseNumber = new JTextField();
		houseNumber.setColumns(10);
		houseNumber.setBounds(92, 220, 43, 20);
		houseNumber.setFont(new Font("Tahoma", Font.PLAIN, 11));
		houseNumber.setText(strhouseNumber);
		panel.add(houseNumber);
		
		street = new JTextField();
		street.setText(strstreet);
		street.setFont(new Font("Tahoma", Font.PLAIN, 11));
		street.setColumns(10);
		street.setBounds(145, 220, 64, 20);
		panel.add(street);
		
		barangay = new JTextField();
		barangay.setText(strbarangay);
		barangay.setFont(new Font("Tahoma", Font.PLAIN, 11));
		barangay.setColumns(10);
		barangay.setBounds(221, 221, 64, 20);
		panel.add(barangay);
		
		municipality = new JTextField();
		municipality.setText(strmunicipality);
		municipality.setFont(new Font("Tahoma", Font.PLAIN, 11));
		municipality.setColumns(10);
		municipality.setBounds(295, 221, 75, 20);
		panel.add(municipality);
		
		province = new JTextField();
		province.setText(strprovince);
		province.setFont(new Font("Tahoma", Font.PLAIN, 11));
		province.setColumns(10);
		province.setBounds(380, 221, 72, 20);
		panel.add(province);
		
		houseNumberLabel = new JLabel("House no.");
		houseNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		houseNumberLabel.setBounds(92, 207, 61, 14);
		panel.add(houseNumberLabel);
		
		streetLabel = new JLabel("Street");
		streetLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		streetLabel.setBounds(156, 207, 53, 14);
		panel.add(streetLabel);
		
		barangayLabel = new JLabel("Barangay");
		barangayLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		barangayLabel.setBounds(221, 207, 64, 14);
		panel.add(barangayLabel);
		
		municipalityLabel = new JLabel("City/Municipality");
		municipalityLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		municipalityLabel.setBounds(295, 207, 90, 14);
		panel.add(municipalityLabel);
		
		provinceLabel = new JLabel("Province");
		provinceLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		provinceLabel.setBounds(390, 207, 64, 14);
		panel.add(provinceLabel);
		
		emailTextfield = new JTextField();
		emailTextfield.setColumns(10);
		emailTextfield.setBounds(92, 249, 270, 20);
		emailTextfield.setFont(new Font("Tahoma", Font.PLAIN, 11));
		emailTextfield.setText(emailData);
		panel.add(emailTextfield);
		
		usernameTextfield = new JTextField();
		usernameTextfield.setColumns(10);
		usernameTextfield.setBounds(92, 276, 270, 20);
		usernameTextfield.setFont(new Font("Tahoma", Font.PLAIN, 11));
		usernameTextfield.setText(accountUsername);
		panel.add(usernameTextfield);
		
		passwordTextfield = new JTextField();
		passwordTextfield.setBounds(92, 303, 270, 20);
		passwordTextfield.setFont(new Font("Tahoma", Font.PLAIN, 11));
		passwordTextfield.setText(accountPassword);
		panel.add(passwordTextfield);
		
		JLabel middleName = new JLabel("Middle Name: ");
		middleName.setBounds(9, 44, 86, 14);
		panel.add(middleName);
		
		JLabel lastName = new JLabel("Last Name: ");
		lastName.setBounds(10, 72, 79, 14);
		panel.add(lastName);
		
		JLabel lblStatus = new JLabel("Status: ");
		lblStatus.setBounds(10, 334, 72, 14);
		panel.add(lblStatus);
		
		
		String[] enrollmentStatus = {"PENDING", "ENROLLED", "REJECTED"};
		enrollmentComboBox = new JComboBox(enrollmentStatus);
		enrollmentComboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		enrollmentComboBox.setSelectedItem(database.getEnrollmentStatus(database.getEnrollmentID(studentID)));
		enrollmentComboBox.setBounds(92, 330, 101, 20);
		panel.add(enrollmentComboBox);
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == saveButton) {
			boolean hasError = false;
			
			LocalDate birthdate = null;
			String lastName = lastNameTextField.getText().trim();
			String firstName = firstNameTextField.getText().trim();
			String middleName = middleNameTextField.getText().trim();
			String phoneNumber = phoneNumberTextfield.getText().trim();
			String gender = (String) comboBox.getSelectedItem();
			String username = usernameTextfield.getText().trim();
			String password = passwordTextfield.getText().trim();
			String email = emailTextfield.getText().trim();
			String lrn = lrnTextField.getText().trim();
			//String address = addressTextfield.getText().trim()

			String status = (String) enrollmentComboBox.getSelectedItem();
			String houseNumber = this.houseNumber.getText().toUpperCase().trim();
			String street = this.street.getText().toUpperCase().trim();
			String barangay = this.barangay.getText().toUpperCase().trim();
			String municipality = this.municipality.getText().toUpperCase().trim();
			String province = this.province.getText().toUpperCase().trim();
			
			String suffix = this.suffix.getText().toUpperCase().trim();
			
			if(suffix.equals("NULL")) {
			    suffix = null;
			}
			
			if (lastName.length() > 50) {
		        JOptionPane.showMessageDialog(frame, "Last name is too long. Max 50 characters.");
		        hasError = true;}
			else if (firstName.length() > 50) {
		        JOptionPane.showMessageDialog(frame, "First name is too long. Max 50 characters.");
		        hasError = true;}
			else if (middleName.length() > 11) {
		        JOptionPane.showMessageDialog(frame, "Middle name is too long. Max 50 characters.");
		        hasError = true;}
			else if (phoneNumber.length() > 50) {
		        JOptionPane.showMessageDialog(frame, "Phone Number is too long. Max 11 Digits.");
		        hasError = true;}
			else if (username.length() > 255) {
		        JOptionPane.showMessageDialog(frame, "Username is too long. Max 50 characters.");
		        hasError = true;}
			else if (password.length() > 255) {
		        JOptionPane.showMessageDialog(frame, "Password is too long. Max 255 characters.");
		        hasError = true;}
			else if (email.length() > 255) {
		        JOptionPane.showMessageDialog(frame, "Email is too long. Max 40 characters.");
		        hasError = true;}
			else if (lrn.length() > 12) {
		        JOptionPane.showMessageDialog(frame, "LRN is too long. Max 12 characters.");
		        hasError = true;}
			
			if(hasError == false) {
				try {
					birthdate = LocalDate.parse(birthdateTextfield.getText().trim());
				}
				catch(Exception error) {
					JOptionPane.showMessageDialog(frame, "Wrong date format. Use YYYY-MM-DD");
					hasError = true;
				}
			}
			
			if(hasError == false) {
				int response = JOptionPane.showConfirmDialog(frame, "Save changes?", "Confirm", JOptionPane.YES_NO_OPTION);
					
				if(response == JOptionPane.YES_OPTION) {
				    database.updateStudentInfo(firstName, middleName, lastName, suffix, 
				            lrn, String.valueOf(birthdate), gender, phoneNumber, houseNumber, street, barangay, municipality, province, email,
				            username, password, studentID);

				    if(status.equals("ENROLLED")) {
				        database.approveAndAssignSection(enrollmentID, studentID);
				    } else {
				        database.updateEnrollmentStatus(status, database.getEnrollmentID(studentID));
				    }

				    JOptionPane.showMessageDialog(frame, "Changes have been saved");
				    frame.dispose();
				}
			}
		}
		
	}
	
}