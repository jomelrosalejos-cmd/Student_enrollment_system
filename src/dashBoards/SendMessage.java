package dashBoards;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SendMessage implements ActionListener{
	
	Image iconImage;
	JFrame frame;
	
	private JButton form137Button;
	private JButton goodMoralButton;
	private JButton birthCertificateButton;
	private JButton id2x2Pic;
	private JButton infoProblem;
	private JButton successButton;
	private JButton customizeMessageButton;
	private JButton closeButton;
	private RegistrarDatabaseConnection database;
	private int studentID;
	
	public SendMessage(RegistrarDatabaseConnection database, int studentID) {
		this.database = database;
		this.studentID = studentID;
		
		iconImage = new ImageIcon(getClass().getResource("/images/yobhel_logo.jpg")).getImage();
		
		frame = new JFrame("Send Notification");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(new BorderLayout(0, 0));
		frame.setIconImage(iconImage);
		frame.setBounds(100, 100, 486, 287);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		frame.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(48, 46, 127));
		panel_1.setPreferredSize(new Dimension(10, 50));
		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("✉ Send Notification to Student");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 282, 28);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		form137Button = new JButton("Form 137");
		form137Button.setForeground(new Color(46, 48, 127));
		form137Button.setBorderPainted(false);
		form137Button.setBackground(new Color(251, 181, 23));
		form137Button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		form137Button.setFocusable(false);
		form137Button.addActionListener(this);
		form137Button.setBounds(35, 35, 89, 23);
		panel_2.add(form137Button);
		
		goodMoralButton = new JButton("Good Moral");
		goodMoralButton.setBackground(new Color(251, 181, 23));
		goodMoralButton.setBorderPainted(false);
		goodMoralButton.setForeground(new Color(46, 48, 127));
		goodMoralButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		goodMoralButton.setFocusable(false);
		goodMoralButton.addActionListener(this);
		goodMoralButton.setBounds(134, 35, 89, 23);
		panel_2.add(goodMoralButton);
		
		birthCertificateButton = new JButton("Birth Cert");
		birthCertificateButton.setForeground(new Color(46, 48, 127));
		birthCertificateButton.setBackground(new Color(251, 181, 23));
		birthCertificateButton.setBorderPainted(false);
		birthCertificateButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		birthCertificateButton.setFocusable(false);
		birthCertificateButton.addActionListener(this);
		birthCertificateButton.setBounds(233, 35, 89, 23);
		panel_2.add(birthCertificateButton);
		
		id2x2Pic = new JButton("2x2 ID pic");
		id2x2Pic.setBackground(new Color(251, 181, 23));
		id2x2Pic.setBorderPainted(false);
		id2x2Pic.setForeground(new Color(46, 48, 127));
		id2x2Pic.setFont(new Font("Tahoma", Font.PLAIN, 10));
		id2x2Pic.setFocusable(false);
		id2x2Pic.addActionListener(this);
		id2x2Pic.setBounds(332, 35, 89, 23);
		panel_2.add(id2x2Pic);
		
		infoProblem = new JButton("Info Prob.");
		infoProblem.setForeground(new Color(46, 48, 127));
		infoProblem.setBackground(new Color(251, 181, 23));
		infoProblem.setBorderPainted(false);
		infoProblem.setFont(new Font("Tahoma", Font.PLAIN, 10));
		infoProblem.setFocusable(false);
		infoProblem.addActionListener(this);
		infoProblem.setBounds(183, 69, 89, 23);
		panel_2.add(infoProblem);
		
		JLabel rejectMessagesLabel = new JLabel("Rejection Messages:");
		rejectMessagesLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		rejectMessagesLabel.setBounds(10, 11, 148, 14);
		panel_2.add(rejectMessagesLabel);
		
		JLabel enrolledMessageLabel = new JLabel("Positive Messages:");
		enrolledMessageLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		enrolledMessageLabel.setBounds(10, 118, 114, 14);
		panel_2.add(enrolledMessageLabel);
		
		successButton = new JButton("Successful");
		successButton.setBorderPainted(false);
		successButton.setBackground(new Color(251, 181, 23));
		successButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		successButton.setFocusable(false);
		successButton.addActionListener(this);
		successButton.setBounds(35, 137, 89, 23);
		panel_2.add(successButton);
		
//		JLabel customizeMessageLabel = new JLabel("Customize Messages:");
//		customizeMessageLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
//		customizeMessageLabel.setBounds(158, 118, 114, 14);
//		panel_2.add(customizeMessageLabel);
		
//		customizeMessageButton = new JButton("Customize");
//		customizeMessageButton.setBackground(new Color(251, 181, 23));
//		customizeMessageButton.setForeground(new Color(46, 48, 127));
//		customizeMessageButton.setBorderPainted(false);
//		customizeMessageButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
//		customizeMessageButton.setFocusable(false);
//		customizeMessageButton.addActionListener(this);
//		customizeMessageButton.setBounds(183, 137, 89, 23);
//		panel_2.add(customizeMessageButton);
		
		closeButton = new JButton("Close");
		closeButton.setBackground(new Color(251, 181, 23));
		closeButton.setForeground(new Color(46, 48, 127));
		closeButton.setBorderPainted(false);
		closeButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		closeButton.setFocusable(false);
		closeButton.addActionListener(this);
		closeButton.setBounds(332, 137, 89, 23);
		panel_2.add(closeButton);
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == form137Button) {
		    int confirm = JOptionPane.showConfirmDialog(frame, 
		        "Send notification: INVALID FORM-137?", 
		        "Confirm", JOptionPane.YES_NO_OPTION);
		    if(confirm == JOptionPane.YES_OPTION) {
		        database.insertNotification(studentID, 1);
		        JOptionPane.showMessageDialog(frame, "Notification sent!");
		    }
		}
		if(e.getSource() == goodMoralButton) {
		    int confirm = JOptionPane.showConfirmDialog(frame, 
		        "Send notification: INVALID GOOD MORAL?", 
		        "Confirm", JOptionPane.YES_NO_OPTION);
		    if(confirm == JOptionPane.YES_OPTION) {
		        database.insertNotification(studentID, 2);
		        JOptionPane.showMessageDialog(frame, "Notification sent!");
		    }
		}
		if(e.getSource() == birthCertificateButton) {
		    int confirm = JOptionPane.showConfirmDialog(frame, 
		        "Send notification: INVALID BIRTH CERTIFICATE?", 
		        "Confirm", JOptionPane.YES_NO_OPTION);
		    if(confirm == JOptionPane.YES_OPTION) {
		        database.insertNotification(studentID, 3);
		        JOptionPane.showMessageDialog(frame, "Notification sent!");
		    }
		}
		if(e.getSource() == id2x2Pic) {
		    int confirm = JOptionPane.showConfirmDialog(frame, 
		        "Send notification: INVALID 2x2 ID Picture?", 
		        "Confirm", JOptionPane.YES_NO_OPTION);
		    if(confirm == JOptionPane.YES_OPTION) {
		        database.insertNotification(studentID, 4);
		        JOptionPane.showMessageDialog(frame, "Notification sent!");
		    }
		}
		if(e.getSource() == infoProblem) {
		    int confirm = JOptionPane.showConfirmDialog(frame, 
		        "Send notification: INFORMATION PROBLEM?", 
		        "Confirm", JOptionPane.YES_NO_OPTION);
		    if(confirm == JOptionPane.YES_OPTION) {
		        database.insertNotification(studentID, 5);
		        JOptionPane.showMessageDialog(frame, "Notification sent!");
		    }
		}
		if(e.getSource() == successButton) {
		    int confirm = JOptionPane.showConfirmDialog(frame, 
		        "Send notification: ENROLLMENT SUCCESS?", 
		        "Confirm", JOptionPane.YES_NO_OPTION);
		    if(confirm == JOptionPane.YES_OPTION) {
		        database.insertNotification(studentID, 6);
		        JOptionPane.showMessageDialog(frame, "Notification sent!");
		    }
		}
		if(e.getSource() == closeButton) {
			frame.dispose();
		}
		
	}

}
