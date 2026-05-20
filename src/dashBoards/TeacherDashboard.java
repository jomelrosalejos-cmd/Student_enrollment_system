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
import javax.swing.JComboBox;
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

public class TeacherDashboard implements ActionListener{
	
	Image imageLogo;
	Image iconImage;
	
	JButton searchButton;
	JButton refreshButton;
	
	JTextField searchBarForStudent;
	JTable table;
	
	JLabel headerTitle;
	JLabel classSizeNumber;
	
	ArrayList<Object[]> row;
	Object[][] data;
	
	String[] column = {"Student ID", "Name", "LRN", "Birthdate", "Gender", "Phone Number", "Email", "Address"};
	
	Principal_TeacherDatabaseConnection database;
	JComboBox schoolYearChooser;
	
	public TeacherDashboard(Principal_TeacherDatabaseConnection database) {
		this.database = database;
		
		imageLogo = new ImageIcon(getClass().getResource("/images/yobhelBanner.jpg")).getImage();
		iconImage = new ImageIcon(getClass().getResource("/images/yobhel_logo.jpg")).getImage();
		
		JFrame frame = new JFrame("Teachers Dashboard");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout(0, 0));
		frame.setIconImage(iconImage);
		frame.setBounds(100, 100, 832, 580);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		frame.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(new Color(48, 46, 127));
		leftPanel.setPreferredSize(new Dimension(180, 10));
		panel.add(leftPanel, BorderLayout.WEST);
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
		
		String[] sectionInfo = database.getSectionInfo();
		
		JPanel dashBoTitlePanel = new JPanel();
		dashBoTitlePanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(251, 181, 23), null));
		dashBoTitlePanel.setBackground(new Color(0, 0, 128));
		dashBoTitlePanel.setBounds(0, 0, 180, 62);
		leftPanel.add(dashBoTitlePanel);
		dashBoTitlePanel.setLayout(null);
		
		JLabel teacherSilhouette = new JLabel("👨‍🏫");
		teacherSilhouette.setForeground(new Color(251, 181, 23));
		teacherSilhouette.setFont(new Font("Serif", Font.PLAIN, 22));
		teacherSilhouette.setBounds(8, 20, 32, 28);
		dashBoTitlePanel.add(teacherSilhouette);
		
		JLabel dashBoardTitle = new JLabel("Teacher's Dashboard");
		dashBoardTitle.setForeground(new Color(255, 255, 255));
		dashBoardTitle.setFont(new Font("Serif", Font.BOLD, 15));
		dashBoardTitle.setBounds(31, 20, 167, 28);
		dashBoTitlePanel.add(dashBoardTitle);
		
		JPanel teacherNamePanel = new JPanel();
		teacherNamePanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(251, 181, 23), null));
		teacherNamePanel.setLayout(null);
		teacherNamePanel.setBackground(new Color(0, 0, 128));
		teacherNamePanel.setBounds(0, 379, 180, 62);
		leftPanel.add(teacherNamePanel);
		
		JLabel userSilhouette = new JLabel("👤");
		userSilhouette.setForeground(new Color(251, 181, 23));
		userSilhouette.setFont(new Font("Serif", Font.PLAIN, 30));
		userSilhouette.setBounds(8, 11, 30, 40);
		teacherNamePanel.add(userSilhouette);
		
		JLabel teacherName = new JLabel(sectionInfo[2]);
		teacherName.setForeground(Color.WHITE);
		teacherName.setFont(new Font("Tahoma", Font.PLAIN, 10));
		teacherName.setBounds(42, 11, 152, 20);
		teacherNamePanel.add(teacherName);
		
		JLabel userRole = new JLabel("Teacher");
		userRole.setForeground(Color.WHITE);
		userRole.setBounds(42, 32, 90, 14);
		teacherNamePanel.add(userRole);
		
		JButton btnLogOut = new JButton("🚪  Log Out");
		btnLogOut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginStaffAccess();
				frame.dispose();
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
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(245, 246, 251));
		panel.add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(null);
		
		JPanel headerPanel = new JPanel();
		headerPanel.setBounds(0, 0, 652, 70);
		headerPanel.setBackground(new Color(255, 255, 255));
		headerPanel.setPreferredSize(new Dimension(0, 70));
		mainPanel.add(headerPanel);
		headerPanel.setLayout(null);
		
		schoolYearChooser = new JComboBox();
		schoolYearChooser.setBounds(489, 25, 112, 22);
		ArrayList<String> schoolYears = database.getSchoolYears();
		for(String year : schoolYears) {
			schoolYearChooser.addItem(year);
		}
		headerPanel.add(schoolYearChooser);
		
		headerTitle = new JLabel("School Year · " + schoolYearChooser.getSelectedItem());
		headerTitle.setForeground(new Color(48, 46, 127));
		headerTitle.setFont(new Font("Serif", Font.PLAIN, 22));
		headerTitle.setBounds(45, 11, 468, 48);
		headerPanel.add(headerTitle);
		
		JLabel lblNewLabel_5 = new JLabel("📋");
		lblNewLabel_5.setForeground(new Color(48, 46, 127));
		lblNewLabel_5.setBounds(12, 21, 23, 29);
		headerPanel.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("Serif", Font.BOLD, 22));
		
		JPanel strandAssignmentPanel = new JPanel();
		strandAssignmentPanel.setBackground(new Color(255, 255, 255));
		strandAssignmentPanel.setBounds(22, 94, 176, 52);
		mainPanel.add(strandAssignmentPanel);
		strandAssignmentPanel.setLayout(null);
		
		JLabel strandAssigned = new JLabel(sectionInfo[1]);
		strandAssigned.setForeground(new Color(0, 227, 0));
		strandAssigned.setFont(new Font("Segoe UI Symbol", Font.BOLD, 18));
		strandAssigned.setBounds(10, 7, 107, 24);
		strandAssignmentPanel.add(strandAssigned);
		
		JLabel strandLabel = new JLabel("Strand");
		strandLabel.setBounds(10, 29, 92, 14);
		strandAssignmentPanel.add(strandLabel);
		
		JPanel classSizePanel = new JPanel();
		classSizePanel.setBackground(new Color(255, 255, 255));
		classSizePanel.setBounds(228, 94, 176, 52);
		mainPanel.add(classSizePanel);
		classSizePanel.setLayout(null);
		
		JLabel classSizeLabel = new JLabel("Class Size");
		classSizeLabel.setBounds(10, 29, 92, 14);
		classSizePanel.add(classSizeLabel);
		
		String classSize = String.valueOf(database.getClassSize((String) schoolYearChooser.getSelectedItem()));
	
		classSizeNumber = new JLabel(classSize);
		classSizeNumber.setForeground(new Color(236, 167, 4));
		classSizeNumber.setFont(new Font("Segoe UI Symbol", Font.BOLD, 18));
		classSizeNumber.setBounds(10, 7, 73, 21);
		classSizePanel.add(classSizeNumber);
		
		JPanel sectionPanel = new JPanel();
		sectionPanel.setBackground(new Color(255, 255, 255));
		sectionPanel.setBounds(430, 94, 176, 52);
		mainPanel.add(sectionPanel);
		sectionPanel.setLayout(null);
		
		JLabel sectionAssigned = new JLabel(sectionInfo[0]);
		sectionAssigned.setForeground(new Color(128, 0, 128));
		sectionAssigned.setFont(new Font("Segoe UI Symbol", Font.BOLD, 18));
		sectionAssigned.setBounds(10, 7, 140, 21);
		sectionPanel.add(sectionAssigned);
		
		JLabel sectionLabel = new JLabel("Section");
		sectionLabel.setBounds(10, 29, 92, 14);
		sectionPanel.add(sectionLabel);
		
		searchBarForStudent = new JTextField();
		searchBarForStudent.setBorder(new LineBorder(new Color(171, 173, 179)));
		searchBarForStudent.setBounds(22, 196, 188, 20);
		mainPanel.add(searchBarForStudent);
		searchBarForStudent.setColumns(10);
		
		JLabel searchStudentLabel = new JLabel("🔍 Search student:");
		searchStudentLabel.setBounds(21, 177, 189, 14);
		mainPanel.add(searchStudentLabel);
		
		row = database.getStudentsInSection((String) schoolYearChooser.getSelectedItem());
		data = row.toArray(new Object[0][]);
		
		table = new JTable(data, column) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.getTableHeader().setBackground(new Color(48, 46, 127));
		table.getTableHeader().setForeground(Color.white);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		JScrollPane scrollPane_studentList = new JScrollPane(table,
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane_studentList.setBounds(22, 233, 584, 277);
		mainPanel.add(scrollPane_studentList);
		
		refreshButton = new JButton("Refresh");
		refreshButton.setBounds(517, 195, 89, 23);
		refreshButton.setFocusable(false);
		refreshButton.addActionListener(this);
		mainPanel.add(refreshButton);
		
		searchButton = new JButton("Search");
		searchButton.setFocusable(false);
		searchButton.setBounds(209, 195, 89, 23);
		searchButton.addActionListener(this);
		mainPanel.add(searchButton);
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == refreshButton) {
			String classSize = String.valueOf(database.getClassSize((String) schoolYearChooser.getSelectedItem()));
			classSizeNumber.setText(classSize);
			
			headerTitle.setText("School Year · " + (String) schoolYearChooser.getSelectedItem());
			
			row = database.getStudentsInSection((String) schoolYearChooser.getSelectedItem());
			data = row.toArray(new Object[0][]);
			table.setModel(new DefaultTableModel(data, column));
		}
		if(e.getSource() == searchButton) {
			try {
				String selectedYear = (String) schoolYearChooser.getSelectedItem();
				
				int value = Integer.parseInt(searchBarForStudent.getText().trim());
				row = database.searchStudent(value, selectedYear);
				data = row.toArray(new Object[0][]);
				table.setModel(new DefaultTableModel(data, column));
			}
			catch(NumberFormatException n) {
				String selectedYear = (String) schoolYearChooser.getSelectedItem();
				
				String value = searchBarForStudent.getText().toUpperCase().trim();
				row = database.searchStudent(value, selectedYear);
				data = row.toArray(new Object[0][]);
				table.setModel(new DefaultTableModel(data, column));
			}
		}
		
	}
}
