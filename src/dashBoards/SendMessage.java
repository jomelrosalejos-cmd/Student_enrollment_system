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
	
	public SendMessage() {
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
			String message = "Dear Student,\n"
					+ "\n"
					+ "Your Form 137 is not clearly readable. Kindly submit a clear hard copy to the\n"
					+ "Registrar’s Office at your earliest convenience.\n"
					+ "\n"
					+ "Thank you.\n"
					+ "";

			int result = JOptionPane.showConfirmDialog(frame, message, "Message", JOptionPane.OK_CANCEL_OPTION);
		}
		if(e.getSource() == goodMoralButton) {
			String message = "Dear Student,\n"
					+ "\r\n"
					+ "Your Certificate of Good Moral Character is not clearly readable. Kindly submit a clear\n"
					+ "hard copy to the Registrar’s Office at your earliest convenience.\n"
					+ "\n"
					+ "Thank you.\n";

			int result = JOptionPane.showConfirmDialog(frame, message, "Message", JOptionPane.OK_CANCEL_OPTION);
		}
		if(e.getSource() == birthCertificateButton) {
			String message = "Dear Student,\n"
					+ "\n"
					+ "Your Birth Certificate is not clearly readable. Kindly submit a clear hard copy to the\n"
					+ "Registrar’s Office at your earliest convenience.\n"
					+ "\n"
					+ "Thank you.\n";

			int result = JOptionPane.showConfirmDialog(frame, message, "Message", JOptionPane.OK_CANCEL_OPTION);
		}
		if(e.getSource() == id2x2Pic) {
			String message = "Dear Student,\n"
					+ "\n"
					+ "Your 2x2 ID Picture is not clearly clear or suitable for processing. Kindly submit a\n"
					+ "clear hard copy to the Registrar’s Office at your earliest convenience.\n"
					+ "\n"
					+ "Thank you.\n"
					+ "";

			int result = JOptionPane.showConfirmDialog(frame, message, "Message", JOptionPane.OK_CANCEL_OPTION);
		}
		if(e.getSource() == infoProblem) {
			String message = "Dear Student,\n"
					 	   + "\n"
					 	   + "We would like to inform you that there is an issue with your personal information on\n"
					 	   + "record. Kindly proceed to the Registrar’s Office for verification and further assistance.\n"
					 	   + "\n"
					 	   + "Thank you.";

			int result = JOptionPane.showConfirmDialog(frame, message, "Message", JOptionPane.OK_CANCEL_OPTION);
		}
		if(e.getSource() == successButton) {
			
			String message = "Dear Student,\n"
				           + "\n"
				           + "We are pleased to inform you that your enrollment has been successfully processed.\n"
				           + "Kindly submit hard copies of all required documents to the Registrar’s Office for\n"
				           + "verification and completion of your enrollment requirements.\n"
				           + "\n"
				           + "Thank you.";

	        int result = JOptionPane.showConfirmDialog(frame, message, "Message", JOptionPane.OK_CANCEL_OPTION);
		}
		if(e.getSource() == closeButton) {
			frame.dispose();
		}
		
	}

}
