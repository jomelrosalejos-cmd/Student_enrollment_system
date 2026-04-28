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
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


public class RegistrarDashboard implements ActionListener{
	
	RegistrarDatabaseConnection database = new RegistrarDatabaseConnection();
	
	Image imageLogo;
	Image iconImage;
	
	JButton filterPendingButton;
	JButton filterEnrolledButton;
	JButton filterRejectedButton;
	
	JButton searchStudentButton;
	JButton moreInfo;

	JTable studentTable;
	
	JFrame frame;
	JButton btnLogOut;
	
	ArrayList<Object[]> row = database.getEnrollments();
	Object[][] data = row.toArray(new Object[0][]);
	String[] column = {"studentID", "Name", "LRN", "Gender", "Strand", "Status"};
	
	public RegistrarDashboard() {
		
		
		
		imageLogo = new ImageIcon(getClass().getResource("/images/yobhelBanner.jpg")).getImage();
		iconImage = new ImageIcon(getClass().getResource("/images/yobhel_logo.jpg")).getImage();
		
		frame = new JFrame("Registrar Dashboard");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout(0, 0));
		frame.setIconImage(iconImage);
		frame.setBounds(100, 100, 832, 580);
		frame.setResizable(false);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 255, 255));
		frame.add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel sidebarPanel = new JPanel();
		sidebarPanel.setBackground(new Color(48, 46, 127));
		sidebarPanel.setPreferredSize(new Dimension(180, 10));
		mainPanel.add(sidebarPanel, BorderLayout.WEST);
		sidebarPanel.setLayout(null);
		
		Image image = new ImageIcon(getClass().getResource("/images/logo_no_bg.png")).getImage();
		
		JPanel logoPanel = new JPanel() {
			@Override
		    public void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        g.drawImage(image, 10, 0, 160, 160, this);
		    }
		};
		logoPanel.setBackground(new Color(48, 46, 127));
		logoPanel.setBounds(0, 104, 180, 180);
		sidebarPanel.add(logoPanel);
		
		JPanel dashboardTitlePanel = new JPanel();
		dashboardTitlePanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(251, 181, 23), null));
		dashboardTitlePanel.setBackground(new Color(0, 0, 128));
		dashboardTitlePanel.setBounds(0, 0, 180, 62);
		sidebarPanel.add(dashboardTitlePanel);
		dashboardTitlePanel.setLayout(null);
		
		JLabel dashboardIconLabel = new JLabel("👨‍🏫");
		dashboardIconLabel.setForeground(new Color(251, 181, 23));
		dashboardIconLabel.setFont(new Font("Serif", Font.PLAIN, 22));
		dashboardIconLabel.setBounds(8, 20, 32, 28);
		dashboardTitlePanel.add(dashboardIconLabel);
		
		JLabel dashboardTitleLabel = new JLabel("Registrar Dashboard");
		dashboardTitleLabel.setForeground(new Color(255, 255, 255));
		dashboardTitleLabel.setFont(new Font("Serif", Font.BOLD, 15));
		dashboardTitleLabel.setBounds(31, 20, 167, 28);
		dashboardTitlePanel.add(dashboardTitleLabel);
		
		btnLogOut = new JButton("🚪  Log Out");
		btnLogOut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogOut.addActionListener(this);
		btnLogOut.setOpaque(false);
		btnLogOut.setHorizontalAlignment(SwingConstants.LEADING);
		btnLogOut.setForeground(new Color(255, 255, 255));
		btnLogOut.setFont(new Font("Serif", Font.PLAIN, 18));
		btnLogOut.setFocusable(false);
		btnLogOut.setContentAreaFilled(false);
		btnLogOut.setBorderPainted(false);
		btnLogOut.setBounds(0, 469, 152, 29);
		sidebarPanel.add(btnLogOut);
		
		JPanel userInfoPanel = new JPanel();
		userInfoPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(251, 181, 23), null));
		userInfoPanel.setLayout(null);
		userInfoPanel.setBackground(new Color(0, 0, 128));
		userInfoPanel.setBounds(0, 379, 180, 62);
		sidebarPanel.add(userInfoPanel);
		
		JLabel userIconLabel = new JLabel("👤");
		userIconLabel.setForeground(new Color(251, 181, 23));
		userIconLabel.setFont(new Font("Serif", Font.PLAIN, 30));
		userIconLabel.setBounds(8, 11, 30, 40);
		userInfoPanel.add(userIconLabel);
		
//		JLabel registrarNameLabel = new JLabel("name");
//		registrarNameLabel.setForeground(Color.WHITE);
//		registrarNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
//		registrarNameLabel.setBounds(42, 11, 156, 20);
//		userInfoPanel.add(registrarNameLabel);
		
		JLabel registrarRoleLabel = new JLabel("Registrar");
		registrarRoleLabel.setForeground(Color.WHITE);
		registrarRoleLabel.setBounds(50, 20, 128, 20);
		registrarRoleLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		userInfoPanel.add(registrarRoleLabel);
		
		JPanel contentPanel = new JPanel();
		contentPanel.setBackground(new Color(245, 246, 251));
		mainPanel.add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel topBarPanel = new JPanel();
		topBarPanel.setBounds(0, 0, 628, 70);
		topBarPanel.setBackground(new Color(255, 255, 255));
		topBarPanel.setPreferredSize(new Dimension(0, 70));
		contentPanel.add(topBarPanel);
		topBarPanel.setLayout(null);
		
		JLabel schoolYearTitleLabel = new JLabel("School Year · 2024–2025");
		schoolYearTitleLabel.setForeground(new Color(48, 46, 127));
		schoolYearTitleLabel.setFont(new Font("Serif", Font.PLAIN, 22));
		schoolYearTitleLabel.setBounds(45, 11, 560, 48);
		topBarPanel.add(schoolYearTitleLabel);
		
		JLabel topBarIconLabel = new JLabel("📋");
		topBarIconLabel.setForeground(new Color(48, 46, 127));
		topBarIconLabel.setBounds(12, 21, 23, 29);
		topBarPanel.add(topBarIconLabel);
		topBarIconLabel.setFont(new Font("Serif", Font.BOLD, 22));
		
		JPanel pendingCard = new JPanel();
		pendingCard.setBackground(new Color(255, 255, 255));
		pendingCard.setBounds(22, 94, 176, 52);
		contentPanel.add(pendingCard);
		pendingCard.setLayout(null);
		
		int pending = 25;
		String strPending = String.valueOf(pending);
		
		JLabel pendingValueLabel = new JLabel(strPending);
		pendingValueLabel.setForeground(new Color(0, 227, 0));
		pendingValueLabel.setFont(new Font("Segoe UI Symbol", Font.BOLD, 18));
		pendingValueLabel.setBounds(10, 7, 99, 21);
		pendingCard.add(pendingValueLabel);
		
		JLabel pendingTitleLabel = new JLabel("Pending");
		pendingTitleLabel.setBounds(10, 29, 92, 14);
		pendingCard.add(pendingTitleLabel);
		
		JPanel enrolledCard = new JPanel();
		enrolledCard.setBackground(new Color(255, 255, 255));
		enrolledCard.setBounds(228, 94, 176, 52);
		contentPanel.add(enrolledCard);
		enrolledCard.setLayout(null);
		
		JLabel enrolledTitleLabel = new JLabel("Enrolled");
		enrolledTitleLabel.setBounds(10, 29, 92, 14);
		enrolledCard.add(enrolledTitleLabel);
		
		int enrolled = 100;
		String strEnrolled = String.valueOf(enrolled);
		
		JLabel enrolledValueLabel = new JLabel(strEnrolled);
		enrolledValueLabel.setForeground(new Color(236, 167, 4));
		enrolledValueLabel.setFont(new Font("Segoe UI Symbol", Font.BOLD, 18));
		enrolledValueLabel.setBounds(10, 7, 92, 21);
		enrolledCard.add(enrolledValueLabel);
		
		JPanel rejectedCard = new JPanel();
		rejectedCard.setBackground(new Color(255, 255, 255));
		rejectedCard.setBounds(430, 94, 176, 52);
		contentPanel.add(rejectedCard);
		rejectedCard.setLayout(null);
		
		int rejected = 10;
		String strRejected = String.valueOf(rejected);
		
		JLabel rejectedValueLabel = new JLabel(strRejected);
		rejectedValueLabel.setForeground(new Color(128, 0, 128));
		rejectedValueLabel.setFont(new Font("Segoe UI Symbol", Font.BOLD, 18));
		rejectedValueLabel.setBounds(10, 7, 140, 21);
		rejectedCard.add(rejectedValueLabel);
		
		JLabel rejectedTitleLabel = new JLabel("Rejected");
		rejectedTitleLabel.setBounds(10, 29, 92, 14);
		rejectedCard.add(rejectedTitleLabel);
		
		JTextField studentSearchField = new JTextField();
		studentSearchField.setBorder(new LineBorder(new Color(171, 173, 179)));
		studentSearchField.setBounds(22, 196, 188, 20);
		contentPanel.add(studentSearchField);
		studentSearchField.setColumns(10);
		
		JLabel searchLabel = new JLabel("🔍 Search student:");
		searchLabel.setBounds(21, 177, 189, 14);
		contentPanel.add(searchLabel);
		
		studentTable = new JTable(data, column) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};	
		studentTable.getTableHeader().setBackground(new Color(48, 46, 127));
		studentTable.getTableHeader().setForeground(Color.white);
		studentTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		setTableColumnSize();
		
		JScrollPane studentTableScrollPane = new JScrollPane(studentTable);
		studentTableScrollPane.setBounds(22, 233, 584, 255);
		contentPanel.add(studentTableScrollPane);
		
		filterPendingButton = new JButton("Pending");
		filterPendingButton.setFocusable(false);
		filterPendingButton.addActionListener(this);
		filterPendingButton.setBounds(417, 195, 89, 23);
		filterPendingButton.setBounds(316, 195, 89, 23);
		contentPanel.add(filterPendingButton);
		
		filterEnrolledButton = new JButton("Enrolled");
		filterEnrolledButton.setFocusable(false);
		filterEnrolledButton.addActionListener(this);
		filterEnrolledButton.setBounds(417, 195, 89, 23);
		contentPanel.add(filterEnrolledButton);
		
		filterRejectedButton = new JButton("Rejected");
		filterRejectedButton.setFocusable(false);
		filterRejectedButton.addActionListener(this);
		filterRejectedButton.setBounds(517, 195, 89, 23);
		contentPanel.add(filterRejectedButton);
		
		searchStudentButton = new JButton("Search");
		searchStudentButton.setFocusable(false);
		searchStudentButton.addActionListener(this);
		searchStudentButton.setBounds(316, 499, 89, 23);
		contentPanel.add(searchStudentButton);
		
		JButton updateStudentButton = new JButton("Update");
		updateStudentButton.setFocusable(false);
		updateStudentButton.addActionListener(this);
		updateStudentButton.setBounds(417, 499, 89, 23);
		contentPanel.add(updateStudentButton);
		
		JButton deleteStudentButton = new JButton("Delete");
		deleteStudentButton.setFocusable(false);
		deleteStudentButton.addActionListener(this);
		deleteStudentButton.setBounds(517, 499, 89, 23);
		contentPanel.add(deleteStudentButton);
		
		moreInfo = new JButton("More Info");
		moreInfo.setFocusable(false);
		moreInfo.addActionListener(this);
		moreInfo.setBounds(22, 499, 89, 23);
		contentPanel.add(moreInfo);
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == moreInfo) {
			new ViewStudentInfo();
		}
		if(e.getSource() == filterPendingButton) {
			row = database.getPendingEnrollments();
			data = row.toArray(new Object[0][]);
			studentTable.setModel(new DefaultTableModel(data, column));
			setTableColumnSize();
		}
		if(e.getSource() == filterEnrolledButton) {
			row = database.getEnrolledEnrollments();
			data = row.toArray(new Object[0][]);
			studentTable.setModel(new DefaultTableModel(data, column));
			setTableColumnSize();
		}
		
		if(e.getSource() == btnLogOut) {
			System.exit(0);
		}
	}
	
	public void setTableColumnSize() {
		TableColumnModel columnModel = studentTable.getColumnModel();
		studentTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		columnModel.getColumn(0).setPreferredWidth(65);
		columnModel.getColumn(1).setPreferredWidth(201);
		columnModel.getColumn(2).setPreferredWidth(95);
		columnModel.getColumn(3).setPreferredWidth(80);
		columnModel.getColumn(4).setPreferredWidth(70);
		columnModel.getColumn(5).setPreferredWidth(70);
	}
	
}

