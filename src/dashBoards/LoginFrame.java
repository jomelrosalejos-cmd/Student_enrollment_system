package dashBoards;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LoginFrame implements ActionListener{
	
	Image imageLogo;
	Image iconImage;
	
	JFrame frame;
	
	JPasswordField passwordField;
	JTextField textField;
	
	JButton signInbutton;
	JButton linkButton;
	
	public LoginFrame(){
		
		imageLogo = new ImageIcon(getClass().getResource("/images/yobhelBanner.jpg")).getImage();
		iconImage = new ImageIcon(getClass().getResource("/images/yobhel_logo.jpg")).getImage();
				
		frame = new JFrame("Login");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout(0, 0));
		frame.setIconImage(iconImage);
		frame.setBounds(100, 100, 832, 580);
		frame.setResizable(false);
		
		JPanel leftPanel = new JPanel() {
		    @Override
		    public void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        g.drawImage(imageLogo, 0, 40, getWidth(), 450, this);
		    }
		};
		leftPanel.setBackground(Color.white);
		leftPanel.setPreferredSize(new Dimension(230, 473));
		leftPanel.setLayout(null);
		frame.add(leftPanel, BorderLayout.WEST);
		
		JPanel rightPanel = new JPanel();
		rightPanel.setBackground(new Color(48, 46, 127));
		rightPanel.setLayout(null);
		frame.add(rightPanel, BorderLayout.CENTER);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setForeground(Color.WHITE);
		usernameLabel.setFont(new Font("Consolas", Font.PLAIN, 17));
		usernameLabel.setBounds(58, 191, 106, 20);
		usernameLabel.setVisible(true);
		rightPanel.add(usernameLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Consolas", Font.PLAIN, 17));
		textField.setForeground(new Color(0, 0, 0));
		textField.setBackground(new Color(255, 255, 255));
		textField.setColumns(10);
		textField.setBounds(58, 217, 430, 30);
		
		rightPanel.add(textField);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setFont(new Font("Consolas", Font.PLAIN, 17));
		passwordLabel.setBounds(58, 279, 106, 20);
		rightPanel.add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(58, 303, 430, 30);
		rightPanel.add(passwordField);
		
		JLabel noAccLabel = new JLabel("No account yet?");
		noAccLabel.setForeground(Color.WHITE);
		noAccLabel.setFont(new Font("Consolas", Font.PLAIN, 15));
		noAccLabel.setBounds(145, 343, 136, 30);
		rightPanel.add(noAccLabel);
		
		signInbutton = new JButton("Sign in");
		signInbutton.setFocusable(false);
		signInbutton.setForeground(new Color(48, 46, 127));
		signInbutton.setBorderPainted(false);
		signInbutton.setBackground(new Color(251, 181, 23));
		signInbutton.setFont(new Font("Georgia", Font.PLAIN, 22));
		signInbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		signInbutton.setBounds(58, 396, 430, 41);
		signInbutton.addActionListener(this);
		rightPanel.add(signInbutton);
		
		JLabel headingLabel1 = new JLabel("STUDENT ENROLLMENT");
		headingLabel1.setForeground(Color.WHITE);
		headingLabel1.setFont(new Font("Serif", Font.PLAIN, 30));
		headingLabel1.setBounds(58, 76, 361, 37);
		rightPanel.add(headingLabel1);
		
		JLabel headingLabel2 = new JLabel("SYSTEM");
		headingLabel2.setForeground(Color.WHITE);
		headingLabel2.setFont(new Font("Serif", Font.PLAIN, 30));
		headingLabel2.setBounds(58, 112, 269, 37);
		rightPanel.add(headingLabel2);
		
		JLabel portalLabel = new JLabel("PORTAL ACCESS");
		portalLabel.setForeground(new Color(251, 181, 23));
		portalLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		portalLabel.setBounds(58, 47, 121, 30);
		rightPanel.add(portalLabel);
		
		linkButton = new JButton("Register here");
		linkButton.setFocusable(false);
		linkButton.setFont(new Font("Consolas", Font.BOLD, 15));
		linkButton.setHorizontalAlignment(SwingConstants.LEADING);
		linkButton.setBorderPainted(false);
		linkButton.setContentAreaFilled(false);
		linkButton.setOpaque(false);
		linkButton.setForeground(new Color(251, 181, 23));
		linkButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		linkButton.setBounds(260, 344, 149, 30);
		linkButton.addActionListener(this);
		rightPanel.add(linkButton);
		
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == signInbutton) {
			String usernameInput = textField.getText();
			char[] passwordInput = passwordField.getPassword();
			String userPasswordInput = new String(passwordInput);
			
			DatabaseConnection verify = new DatabaseConnection();
			boolean loginResult = verify.Verify(usernameInput, userPasswordInput);
			
			if(loginResult == true) {
				if(verify.getStudentID() == 0) {
					new EnrollmentForm(verify);
				}
				else {
					StudentDashBoard studentDashboard = new StudentDashBoard(verify);
					frame.dispose();
				}
				
				frame.dispose();
			}
			else {
				JOptionPane.showMessageDialog(frame, "LOGIN FAILED");
			}
			
			
		}
		
		else if(e.getSource() == linkButton) {
			new CreateAnAccount();
			frame.dispose();
		}
		
	}
	
}
