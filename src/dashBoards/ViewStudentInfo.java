package dashBoards;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ViewStudentInfo implements ActionListener{
	
	JFrame frame;
	
	public ViewStudentInfo() {
		
		Image iconImage = new ImageIcon(getClass().getResource("/images/yobhel_logo.jpg")).getImage();
		
		frame = new JFrame("Information");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(new BorderLayout(0, 0));
		frame.setIconImage(iconImage);
		frame.setBounds(100, 100, 384, 477);
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
		
		JLabel lblNewLabel = new JLabel("Student Information");
		lblNewLabel.setForeground(new Color(251, 181, 23));
		lblNewLabel.setBounds(10, 9, 340, 14);
		headerPanel.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		backPanel.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel studentID = new JLabel("StudentID: ");
		studentID.setBounds(10, 28, 340, 14);
		panel.add(studentID);
		
		JLabel fullName = new JLabel("Full Name: ");
		fullName.setBounds(10, 44, 340, 14);
		panel.add(fullName);
		
		JLabel LRN = new JLabel("LRN: ");
		LRN.setBounds(10, 60, 340, 14);
		panel.add(LRN);
		
		JLabel birthdate = new JLabel("Birthdate: ");
		birthdate.setBounds(10, 76, 340, 14);
		panel.add(birthdate);
		
		JLabel gender = new JLabel("Gender: ");
		gender.setBounds(10, 92, 340, 14);
		panel.add(gender);
		
		JLabel phoneNumber = new JLabel("Phone number: ");
		phoneNumber.setBounds(10, 109, 340, 14);
		panel.add(phoneNumber);
		
		JLabel address = new JLabel("Address: ");
		address.setBounds(10, 125, 340, 14);
		panel.add(address);
		
		JLabel strand = new JLabel("Strand: ");
		strand.setBounds(10, 207, 340, 14);
		panel.add(strand);
		
		JLabel section = new JLabel("Section: ");
		section.setBounds(10, 191, 340, 14);
		panel.add(section);
		
		JLabel emailAddress = new JLabel("Email: ");
		emailAddress.setBounds(10, 140, 340, 14);
		panel.add(emailAddress);
		
		JLabel userID = new JLabel("User ID: ");
		userID.setBounds(10, 156, 340, 14);
		panel.add(userID);
		
		JLabel adviser = new JLabel("Adviser: ");
		adviser.setBounds(10, 221, 340, 14);
		panel.add(adviser);
		
		JLabel viewDocuLabel = new JLabel("View Documents: ");
		viewDocuLabel.setBounds(10, 253, 340, 14);
		panel.add(viewDocuLabel);
		
		JButton form137btn = new JButton("Form 137");
		form137btn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		form137btn.setFocusable(false);
		form137btn.addActionListener(this);
		form137btn.setBounds(10, 274, 89, 23);
		panel.add(form137btn);
		
		JButton birthCertBtn = new JButton("Birth Cert");
		birthCertBtn.addActionListener(this);
		birthCertBtn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		birthCertBtn.setFocusable(false);
		birthCertBtn.setBounds(10, 305, 89, 23);
		panel.add(birthCertBtn);
		
		JButton goodmoralBtn = new JButton("Good Moral");
		goodmoralBtn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		goodmoralBtn.setFocusable(false);
		goodmoralBtn.addActionListener(this);
		goodmoralBtn.setBounds(10, 335, 89, 23);
		panel.add(goodmoralBtn);
		
		JButton idPicBtn = new JButton("ID picture");
		idPicBtn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		idPicBtn.setFocusable(false);
		idPicBtn.addActionListener(this);
		idPicBtn.setBounds(10, 366, 89, 23);
		panel.add(idPicBtn);
			
		JRadioButton approvedForm137 = new JRadioButton("Approved");
		approvedForm137.setFocusable(false);
		approvedForm137.setFont(new Font("Tahoma", Font.PLAIN, 10));
		approvedForm137.setBackground(new Color(255, 255, 255));
		approvedForm137.setBounds(108, 274, 89, 23);
		approvedForm137.addActionListener(this);
		panel.add(approvedForm137);
		JRadioButton rejectedForm137 = new JRadioButton("Rejected");
		rejectedForm137.setFocusable(false);
		rejectedForm137.setFont(new Font("Tahoma", Font.PLAIN, 10));
		rejectedForm137.setBackground(Color.WHITE);
		rejectedForm137.setBounds(199, 274, 89, 23);
		rejectedForm137.addActionListener(this);
		panel.add(rejectedForm137);
		
		ButtonGroup groupForm137 = new ButtonGroup();
		groupForm137.add(approvedForm137);
		groupForm137.add(rejectedForm137);
		
		JRadioButton approvedBirthCert = new JRadioButton("Approved");
		approvedBirthCert.setFont(new Font("Tahoma", Font.PLAIN, 10));
		approvedBirthCert.setFocusable(false);
		approvedBirthCert.setBackground(Color.WHITE);
		approvedBirthCert.setBounds(108, 305, 89, 23);
		approvedBirthCert.addActionListener(this);
		panel.add(approvedBirthCert);
		JRadioButton rejectedBirthCert = new JRadioButton("Rejected");
		rejectedBirthCert.setFont(new Font("Tahoma", Font.PLAIN, 10));
		rejectedBirthCert.setFocusable(false);
		rejectedBirthCert.setBackground(Color.WHITE);
		rejectedBirthCert.setBounds(199, 305, 89, 23);
		rejectedBirthCert.addActionListener(this);
		panel.add(rejectedBirthCert);
		
		ButtonGroup groupBirthCert = new ButtonGroup();
		groupBirthCert.add(approvedBirthCert);
		groupBirthCert.add(rejectedBirthCert);
		
		JRadioButton approvedGoodMoral = new JRadioButton("Approved");
		approvedGoodMoral.setFont(new Font("Tahoma", Font.PLAIN, 10));
		approvedGoodMoral.setFocusable(false);
		approvedGoodMoral.setBackground(Color.WHITE);
		approvedGoodMoral.setBounds(108, 335, 89, 23);
		approvedGoodMoral.addActionListener(this);
		panel.add(approvedGoodMoral);
		JRadioButton rejectedGoodMoral = new JRadioButton("Rejected");
		rejectedGoodMoral.setFont(new Font("Tahoma", Font.PLAIN, 10));
		rejectedGoodMoral.setFocusable(false);
		rejectedGoodMoral.setBackground(Color.WHITE);
		rejectedGoodMoral.setBounds(199, 335, 89, 23);
		rejectedGoodMoral.addActionListener(this);
		panel.add(rejectedGoodMoral);
		
		ButtonGroup groupGoodMoral = new ButtonGroup();
		groupGoodMoral.add(approvedGoodMoral);
		groupGoodMoral.add(rejectedGoodMoral);
		
		JRadioButton approvedIDpic = new JRadioButton("Approved");
		approvedIDpic.setFont(new Font("Tahoma", Font.PLAIN, 10));
		approvedIDpic.setFocusable(false);
		approvedIDpic.setBackground(Color.WHITE);
		approvedIDpic.setBounds(108, 366, 89, 23);
		approvedIDpic.addActionListener(this);
		panel.add(approvedIDpic);	
		JRadioButton rejectedIDpic = new JRadioButton("Rejected");
		rejectedIDpic.setFont(new Font("Tahoma", Font.PLAIN, 10));
		rejectedIDpic.setFocusable(false);
		rejectedIDpic.setBackground(Color.WHITE);
		rejectedIDpic.setBounds(199, 366, 81, 23);
		rejectedIDpic.addActionListener(this);
		panel.add(rejectedIDpic);
		
		ButtonGroup groupIDpic = new ButtonGroup();
		groupIDpic.add(approvedIDpic);
		groupIDpic.add(rejectedIDpic);
		
		JButton exitButton = new JButton("EXIT");
		exitButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		exitButton.setFocusable(false);
		exitButton.setBounds(286, 366, 64, 23);
		exitButton.addActionListener(this);
		panel.add(exitButton);
		
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
}
