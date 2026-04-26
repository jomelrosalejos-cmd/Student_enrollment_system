package dashBoards;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class CreateAnAccount implements ActionListener{
	
	Image imageLogo;
	Image iconImage;
	
	private JTextField userName;
	private JTextField emailAddress;
	private JTextField confirmPassword;
	private JTextField password;
	private JButton btnRegister;
	
	private JButton btnSignInHere;
	
	JFrame frame;

	public CreateAnAccount() {
		imageLogo = new ImageIcon(getClass().getResource("/images/yobhelBanner.jpg")).getImage();
		iconImage = new ImageIcon(getClass().getResource("/images/yobhel_logo.jpg")).getImage();
		
		frame = new JFrame("Create an account");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout(0, 0));
		frame.setIconImage(iconImage);
		frame.setBounds(100, 100, 832, 580);
		frame.setResizable(false);
		
		JPanel panel = new JPanel();
		frame.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(200, 10));
		panel.add(panel_1, BorderLayout.WEST);
		
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(200, 10));
		panel.add(panel_2, BorderLayout.EAST);
		
		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(0, 20));
		panel.add(panel_3, BorderLayout.SOUTH);
		
		JPanel panel_4 = new JPanel();
		panel_4.setPreferredSize(new Dimension(10, 20));
		panel.add(panel_4, BorderLayout.NORTH);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setBorder(new LineBorder(new Color(48, 46, 127)));
		panel_5.setForeground(new Color(255, 255, 255));
		panel.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(null);
		
		Image image = new ImageIcon(getClass().getResource("/images/logo_no_bg.png")).getImage();
		JPanel panel_logo = new JPanel() {
			@Override
		    public void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        g.drawImage(image, 0, 0, 139, 126, this);
		    }
		};
		panel_logo.setBackground(Color.white);
		panel_logo.setBounds(130, 11, 139, 126);
		panel_5.add(panel_logo);
		
		JLabel createAccountLabel = new JLabel("Create an Account");
		createAccountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		createAccountLabel.setBounds(130, 143, 139, 14);
		panel_5.add(createAccountLabel);
		
		userName = new JTextField();
		userName.setBounds(43, 209, 322, 28);
		panel_5.add(userName);
		userName.setColumns(10);
		
		emailAddress = new JTextField();
		emailAddress.setColumns(10);
		emailAddress.setBounds(43, 264, 322, 28);
		panel_5.add(emailAddress);
		
		confirmPassword = new JTextField();
		confirmPassword.setColumns(10);
		confirmPassword.setBounds(43, 372, 322, 28);
		panel_5.add(confirmPassword);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(43, 317, 322, 28);
		panel_5.add(password);
		
		JLabel UsernameLabel = new JLabel("Username");
		UsernameLabel.setBounds(43, 191, 322, 14);
		panel_5.add(UsernameLabel);
		
		JLabel emailAddressLabel = new JLabel("Email Address");
		emailAddressLabel.setBounds(43, 248, 322, 14);
		panel_5.add(emailAddressLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(43, 301, 322, 14);
		panel_5.add(passwordLabel);
		
		JLabel confirmPasswordLabel = new JLabel("Confirm Password");
		confirmPasswordLabel.setBounds(43, 356, 322, 14);
		panel_5.add(confirmPasswordLabel);
		
		btnRegister = new JButton("Register");
		btnRegister.setForeground(new Color(48, 46, 127));
		btnRegister.setFont(new Font("Georgia", Font.PLAIN, 15));
		btnRegister.setFocusable(false);
		btnRegister.setBorderPainted(false);
		btnRegister.setBackground(new Color(251, 181, 23));
		btnRegister.addActionListener(this);
		btnRegister.setBounds(43, 417, 322, 28);
		panel_5.add(btnRegister);
		
		JLabel alreadyHaveAccountLabel = new JLabel("Already have an account?");
		alreadyHaveAccountLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		alreadyHaveAccountLabel.setBounds(53, 456, 168, 14);
		panel_5.add(alreadyHaveAccountLabel);
		
		btnSignInHere = new JButton("Sign in here");
		btnSignInHere.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSignInHere.addActionListener(this);
		btnSignInHere.setOpaque(false);
		btnSignInHere.setHorizontalAlignment(SwingConstants.LEADING);
		btnSignInHere.setForeground(new Color(251, 181, 23));
		btnSignInHere.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSignInHere.setFocusable(false);
		btnSignInHere.setContentAreaFilled(false);
		btnSignInHere.setBorderPainted(false);
		btnSignInHere.setBounds(210, 455, 131, 17);
		panel_5.add(btnSignInHere);
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnSignInHere) {
			new LoginFrame();
			frame.dispose();
		}
		
		else if(e.getSource() == btnRegister) {
			String username = userName.getText().trim();
			String email = emailAddress.getText().trim();
			String pass = password.getText().trim();
			String confirmPass = confirmPassword.getText().trim();
			
			if (username.length() > 50) {
		        JOptionPane.showMessageDialog(frame, "Username is too long. Max 50 characters.");
		        return;}
			else if (email.length() > 40) {
		        JOptionPane.showMessageDialog(frame, "Email Address is too long. Max 40 characters.");
		        return;}
			else if (pass.length() > 255 || confirmPass.length() > 255) {
		        JOptionPane.showMessageDialog(frame, "Password is too long. Max 255 digits.");
		        return;}
			
			if(username.isEmpty() || email.isEmpty() || email.isEmpty()) {
				JOptionPane.showMessageDialog(frame, "Please fill in all required fields:", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			if(pass.equals(confirmPass)) {
				DatabaseConnection dc = new DatabaseConnection();
				dc.createNewAccount(username, pass, email);
				JOptionPane.showMessageDialog(frame, "Account successfully created");
				frame.dispose();
				new LoginFrame();
			}
			else {
				JOptionPane.showMessageDialog(frame, "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
