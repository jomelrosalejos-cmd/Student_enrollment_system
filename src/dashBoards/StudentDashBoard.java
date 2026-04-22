package dashBoards;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public class StudentDashBoard {
	
	Image imageLogo;
	Image iconImage;
	
	public StudentDashBoard() {
		imageLogo = new ImageIcon(getClass().getResource("/images/yobhelBanner.jpg")).getImage();
		iconImage = new ImageIcon(getClass().getResource("/images/yobhel_logo.jpg")).getImage();
		
		JFrame frame = new JFrame("Student Dashboard");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout(0, 0));
		frame.setIconImage(iconImage);
		frame.setBounds(100, 100, 832, 580);
		frame.setResizable(false);
		
		JPanel backPanel = new JPanel();
		backPanel.setBackground(new Color(255, 255, 255));
		backPanel.setLayout(new BorderLayout(0, 0));
		frame.add(backPanel, BorderLayout.CENTER);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(new Color(48, 46, 127));
		leftPanel.setPreferredSize(new Dimension(180, 10));
		backPanel.add(leftPanel, BorderLayout.WEST);
		leftPanel.setLayout(null);
		
		Image image = new ImageIcon(getClass().getResource("/images/logo_no_bg.png")).getImage();
		
		JPanel panel_logo = new JPanel() {
			@Override
		    public void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        g.drawImage(image, 10, 0, 160, 160, this);
		    }
		};
		panel_logo.setBackground(new Color(48, 46, 127));
		panel_logo.setBounds(0, 104, 180, 180);
		leftPanel.add(panel_logo);
		
		JPanel dashBoTitlePanel = new JPanel();
		dashBoTitlePanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(251, 181, 23), null));
		dashBoTitlePanel.setBackground(new Color(0, 0, 128));
		dashBoTitlePanel.setBounds(0, 0, 180, 62);
		dashBoTitlePanel.setLayout(null);
		leftPanel.add(dashBoTitlePanel);
		
		JLabel GradHat = new JLabel("🎓");
		GradHat.setForeground(new Color(251, 181, 23));
		GradHat.setFont(new Font("Serif", Font.PLAIN, 27));
		GradHat.setBounds(8, 20, 27, 31);
		dashBoTitlePanel.add(GradHat);
		
		JLabel dashBoTitle = new JLabel("Student Dashboard");
		dashBoTitle.setForeground(new Color(255, 255, 255));
		dashBoTitle.setFont(new Font("Serif", Font.BOLD, 15));
		dashBoTitle.setBounds(40, 20, 167, 28);
		dashBoTitlePanel.add(dashBoTitle);
		
		JButton btnLogOut = new JButton("🚪  Log Out");
		btnLogOut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogOut.setOpaque(false);
		btnLogOut.setHorizontalAlignment(SwingConstants.LEADING);
		btnLogOut.setForeground(new Color(255, 255, 255));
		btnLogOut.setFont(new Font("Serif", Font.PLAIN, 18));
		btnLogOut.setFocusable(false);
		btnLogOut.setContentAreaFilled(false);
		btnLogOut.setBorderPainted(false);
		btnLogOut.setBounds(0, 469, 152, 29);
		leftPanel.add(btnLogOut);
		
		JPanel studentNamePanel = new JPanel();
		studentNamePanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(251, 181, 23), null));
		studentNamePanel.setLayout(null);
		studentNamePanel.setBackground(new Color(0, 0, 128));
		studentNamePanel.setBounds(0, 379, 180, 62);
		leftPanel.add(studentNamePanel);
		
		JLabel silhouette = new JLabel("👤");
		silhouette.setForeground(new Color(251, 181, 23));
		silhouette.setFont(new Font("Serif", Font.PLAIN, 30));
		silhouette.setBounds(8, 11, 30, 40);
		studentNamePanel.add(silhouette);
		
		JLabel studentName = new JLabel("Jomel Rosalejos");
		studentName.setForeground(Color.WHITE);
		studentName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		studentName.setBounds(42, 11, 119, 20);
		studentNamePanel.add(studentName);
		
		JLabel userRole = new JLabel("Student");
		userRole.setForeground(Color.WHITE);
		userRole.setBounds(42, 32, 49, 14);
		studentNamePanel.add(userRole);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(245, 246, 251));
		backPanel.add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(null);
		
		JPanel headerPanel = new JPanel();
		headerPanel.setBounds(0, 0, 652, 70);
		headerPanel.setBackground(new Color(255, 255, 255));
		headerPanel.setLayout(null);
		mainPanel.add(headerPanel);
		
		JLabel headerTitle = new JLabel("🏠 My Enrollment Status");
		headerTitle.setForeground(new Color(48, 46, 127));
		headerTitle.setFont(new Font("Serif", Font.PLAIN, 22));
		headerTitle.setBounds(10, 11, 333, 48);
		headerPanel.add(headerTitle);
		
		JPanel reqStatusPanel = new JPanel();
		reqStatusPanel.setBackground(new Color(255, 255, 255));
		reqStatusPanel.setBounds(20, 377, 598, 145);
		reqStatusPanel.setLayout(null);
		mainPanel.add(reqStatusPanel);
		
		JLabel requirements_statusTitle = new JLabel("Requirements Status");
		requirements_statusTitle.setFont(new Font("Tahoma", Font.PLAIN, 17));
		requirements_statusTitle.setForeground(new Color(251, 181, 23));
		requirements_statusTitle.setBounds(10, 350, 214, 27);
		mainPanel.add(requirements_statusTitle);
		
		JLabel form137Label = new JLabel("📄 Form 137 / Report Card");
		form137Label.setForeground(new Color(48, 46, 127));
		form137Label.setBounds(10, 12, 170, 14);
		reqStatusPanel.add(form137Label);
		
		JPanel linePanel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.black);
		        g.drawLine(0, 0, 570, 0);
		    }
		};
		linePanel.setOpaque(false);
		linePanel.setBounds(10, 34, 600, 2);
		reqStatusPanel.add(linePanel);
		
		JLabel submissionStatus_form137 = new JLabel("Pending");
		submissionStatus_form137.setOpaque(true);
		submissionStatus_form137.setBorder(new LineBorder(new Color(183, 151, 84)));
		submissionStatus_form137.setBackground(new Color(255, 243, 212));
		submissionStatus_form137.setForeground(new Color(183, 151, 84));
		submissionStatus_form137.setHorizontalAlignment(SwingConstants.CENTER);
		submissionStatus_form137.setBounds(497, 12, 80, 16);
		reqStatusPanel.add(submissionStatus_form137);
		
		JPanel linePanel_1 = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.black);
		        g.drawLine(0, 0, 570, 0);
			}
		};
		linePanel_1.setOpaque(false);
		linePanel_1.setBounds(10, 70, 600, 2);
		reqStatusPanel.add(linePanel_1);
		
		JLabel goodMoralLabel = new JLabel("📄 Good Moral Certificate");
		goodMoralLabel.setForeground(new Color(48, 46, 127));
		goodMoralLabel.setBounds(10, 45, 170, 14);
		reqStatusPanel.add(goodMoralLabel);
		
		JLabel submissionStatus_goodMoral = new JLabel("Pending");
		submissionStatus_goodMoral.setOpaque(true);
		submissionStatus_goodMoral.setHorizontalAlignment(SwingConstants.CENTER);
		submissionStatus_goodMoral.setForeground(new Color(183, 151, 84));
		submissionStatus_goodMoral.setBorder(new LineBorder(new Color(183, 151, 84)));
		submissionStatus_goodMoral.setBackground(new Color(255, 243, 212));
		submissionStatus_goodMoral.setBounds(497, 45, 80, 16);
		reqStatusPanel.add(submissionStatus_goodMoral);
		
		JPanel linePanel_2 = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.black);
		        g.drawLine(0, 0, 570, 0);
			}
		};
		linePanel_2.setOpaque(false);
		linePanel_2.setBounds(10, 106, 600, 2);
		reqStatusPanel.add(linePanel_2);
		
		JLabel birthCertLabel = new JLabel("📄 Birth Certificate (PSA)");
		birthCertLabel.setForeground(new Color(48, 46, 127));
		birthCertLabel.setBounds(10, 81, 170, 14);
		reqStatusPanel.add(birthCertLabel);
		JLabel submissionStatus_BirthCert = new JLabel("Pending");
		submissionStatus_BirthCert.setOpaque(true);
		submissionStatus_BirthCert.setHorizontalAlignment(SwingConstants.CENTER);
		submissionStatus_BirthCert.setForeground(new Color(183, 151, 84));
		submissionStatus_BirthCert.setBorder(new LineBorder(new Color(183, 151, 84)));
		submissionStatus_BirthCert.setBackground(new Color(255, 243, 212));
		submissionStatus_BirthCert.setBounds(497, 81, 80, 16);
		reqStatusPanel.add(submissionStatus_BirthCert);
		
		JLabel IDpicLabel = new JLabel("📄 2x2 ID Picture (2 pcs)");
		IDpicLabel.setForeground(new Color(48, 46, 127));
		IDpicLabel.setBounds(10, 119, 170, 14);
		reqStatusPanel.add(IDpicLabel);
		JLabel submissionStatus_2x2ID = new JLabel("Pending");
		submissionStatus_2x2ID.setOpaque(true);
		submissionStatus_2x2ID.setHorizontalAlignment(SwingConstants.CENTER);
		submissionStatus_2x2ID.setForeground(new Color(183, 151, 84));
		submissionStatus_2x2ID.setBorder(new LineBorder(new Color(183, 151, 84)));
		submissionStatus_2x2ID.setBackground(new Color(255, 243, 212));
		submissionStatus_2x2ID.setBounds(497, 119, 80, 16);
		reqStatusPanel.add(submissionStatus_2x2ID);
		
		JPanel enrollmentDetailsPanel = new JPanel();
		enrollmentDetailsPanel.setBackground(Color.WHITE);
		enrollmentDetailsPanel.setBounds(20, 198, 598, 141);
		mainPanel.add(enrollmentDetailsPanel);
		enrollmentDetailsPanel.setLayout(null);
		
		JLabel lrnLabel = new JLabel("LRN: ");
		lrnLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lrnLabel.setBounds(10, 11, 255, 23);
		enrollmentDetailsPanel.add(lrnLabel);
		
		JLabel strandLabel = new JLabel("Strand: ");
		strandLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		strandLabel.setBounds(10, 45, 255, 23);
		enrollmentDetailsPanel.add(strandLabel);
		
		JLabel adviserLabel = new JLabel("Adviser: ");
		adviserLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		adviserLabel.setBounds(10, 79, 255, 23);
		enrollmentDetailsPanel.add(adviserLabel);
		
		JLabel secitonLabel = new JLabel("Section: ");
		secitonLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		secitonLabel.setBounds(10, 107, 255, 23);
		enrollmentDetailsPanel.add(secitonLabel);
		
		JLabel enrollmentStatusLabel = new JLabel("Status: ");
		enrollmentStatusLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		enrollmentStatusLabel.setBounds(348, 11, 161, 23);
		enrollmentDetailsPanel.add(enrollmentStatusLabel);
		
		JLabel schoolYearLabel = new JLabel("School Year: ");
		schoolYearLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		schoolYearLabel.setBounds(348, 45, 194, 23);
		enrollmentDetailsPanel.add(schoolYearLabel);
		
		JLabel enrollmentDetailsLabel = new JLabel("Enrollment Details");
		enrollmentDetailsLabel.setForeground(new Color(251, 181, 23));
		enrollmentDetailsLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		enrollmentDetailsLabel.setBounds(10, 166, 214, 27);
		mainPanel.add(enrollmentDetailsLabel);
		
		JPanel progressPanel = new JPanel() {
			 @Override
			    protected void paintComponent(Graphics g) {
			        super.paintComponent(g);
			        Graphics2D g2d = (Graphics2D) g;
			        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			        
			        //1
			        g2d.setColor(new Color(48, 46, 127));
			        g2d.drawOval(10, 10, 30, 30);
			        g2d.setColor(Color.BLACK);
			        g2d.drawLine(40, 25, 135, 25);
			        
			        //2
			        g2d.setColor(new Color(48, 46, 127));
			        g2d.drawOval(135, 10, 30, 30);
			        g2d.setColor(Color.BLACK);
			        g2d.drawLine(165, 25, 263, 25);
			        
			        //3
			        g2d.setColor(new Color(48, 46, 127));
			        g2d.drawOval(263, 10, 30, 30);
			        g2d.setColor(Color.BLACK);
			        g2d.drawLine(293, 25, 382, 25);
			        
			        //4
			        g2d.setColor(new Color(48, 46, 127));
			        g2d.drawOval(382, 10, 30, 30);
			        g2d.setColor(Color.BLACK);
			        g2d.drawLine(412, 25, 495, 25);
			        
			        //5
			        g2d.setColor(new Color(48, 46, 127));
			        g2d.drawOval(495, 10, 30, 30);
			        
			    }
		};
		progressPanel.setBackground(new Color(245, 246, 251));
		progressPanel.setBounds(61, 79, 541, 50);
		mainPanel.add(progressPanel);
		
		JLabel step1 = new JLabel("Create an account");
		step1.setBounds(39, 129, 116, 14);
		mainPanel.add(step1);
		
		JLabel step2 = new JLabel("Submit details");
		step2.setBounds(170, 129, 90, 14);
		mainPanel.add(step2);
		JLabel step2_1 = new JLabel("& requirements");
		step2_1.setBounds(170, 141, 104, 14);
		mainPanel.add(step2_1);
		
		JLabel step3 = new JLabel("Details review");
		step3.setBounds(298, 129, 90, 14);
		mainPanel.add(step3);
		
		JLabel step4 = new JLabel("Requirements");
		step4.setBounds(420, 129, 104, 14);
		mainPanel.add(step4);
		JLabel step4_1 = new JLabel("approved");
		step4_1.setBounds(420, 140, 78, 14);
		mainPanel.add(step4_1);
		
		JLabel step5 = new JLabel("Enrolled");
		step5.setBounds(548, 129, 70, 14);
		mainPanel.add(step5);
			
		frame.setVisible(true);
	}

}
