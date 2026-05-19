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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;


public class PrincipalDashboard implements ActionListener{
	
	Image imageLogo;
	Image iconImage;
	
	JFrame frame;
	JButton viewSectionsButton;
	
	JButton btnLogOut;
	
	JComboBox dateChooser;
	
	Principal_TeacherDatabaseConnection database = new Principal_TeacherDatabaseConnection();
	
	public PrincipalDashboard() {
		
		imageLogo = new ImageIcon(getClass().getResource("/images/yobhelBanner.jpg")).getImage();
		iconImage = new ImageIcon(getClass().getResource("/images/yobhel_logo.jpg")).getImage();
		
		frame = new JFrame("Student Dashboard");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout(0, 0));
		frame.setIconImage(iconImage);
		frame.setBounds(100, 100, 832, 580);
		frame.setLocationRelativeTo(null);
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
		
		JLabel dashboardTitleLabel = new JLabel("Principal Dashboard");
		dashboardTitleLabel.setForeground(new Color(255, 255, 255));
		dashboardTitleLabel.setFont(new Font("Serif", Font.BOLD, 15));
		dashboardTitleLabel.setBounds(34, 20, 167, 28);
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
		
		JLabel principalNameLabel = new JLabel("Benigno Pelaso");
		principalNameLabel.setForeground(Color.WHITE);
		principalNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		principalNameLabel.setBounds(42, 11, 119, 20);
		userInfoPanel.add(principalNameLabel);
		
		JLabel principalRoleLabel = new JLabel("Principal");
		principalRoleLabel.setForeground(Color.WHITE);
		principalRoleLabel.setBounds(42, 32, 97, 14);
		userInfoPanel.add(principalRoleLabel);
		
		JPanel contentPanel = new JPanel();
		contentPanel.setBackground(new Color(245, 246, 251));
		mainPanel.add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel topBarPanel = new JPanel();
		topBarPanel.setBounds(0, 0, 652, 70);
		topBarPanel.setBackground(new Color(255, 255, 255));
		topBarPanel.setPreferredSize(new Dimension(0, 70));
		contentPanel.add(topBarPanel);
		topBarPanel.setLayout(null);
		
		JLabel overviewTitleLabel = new JLabel("School Overview");
		overviewTitleLabel.setForeground(new Color(48, 46, 127));
		overviewTitleLabel.setFont(new Font("Serif", Font.PLAIN, 22));
		overviewTitleLabel.setBounds(45, 11, 468, 48);
		topBarPanel.add(overviewTitleLabel);
		
		dateChooser = new JComboBox();
		dateChooser.setBounds(506, 25, 112, 22);
		ArrayList<String> schoolYears = database.getSchoolYears();
		for(String year : schoolYears) {
		    dateChooser.addItem(year);
		}
		String selectedYear = String.valueOf(dateChooser.getSelectedItem());
		topBarPanel.add(dateChooser);
		
		JLabel overviewIconLabel = new JLabel("📋");
		overviewIconLabel.setForeground(new Color(48, 46, 127));
		overviewIconLabel.setBounds(12, 21, 23, 29);
		topBarPanel.add(overviewIconLabel);
		overviewIconLabel.setFont(new Font("Serif", Font.BOLD, 22));
		
		int totalStudents = 800;
		String strtotalStudents = String.valueOf(totalStudents);
		
		int classSize = 40;
		String strClassSize = String.valueOf(classSize);
		
		int totalTeacher = 70;
		String strTotalTeacher = String.valueOf(totalTeacher);
		
		String[] column = {"Strand", "Total Students"};
		int[] totalPerStrand = {
				database.getTotalByStrandAndSchoolYear(1, selectedYear),
				database.getTotalByStrandAndSchoolYear(2, selectedYear),
				database.getTotalByStrandAndSchoolYear(3, selectedYear),
				database.getTotalByStrandAndSchoolYear(4, selectedYear),
				database.getTotalByStrandAndSchoolYear(5, selectedYear),
				database.getTotalByStrandAndSchoolYear(6, selectedYear)};
		Object[][] data = {
				{"ABM", totalPerStrand[0]},
				{"GAS", totalPerStrand[1]},
				{"HUMSS", totalPerStrand[2]},
				{"ICT", totalPerStrand[3]},
				{"STEM", totalPerStrand[4]},
				{"EIM", totalPerStrand[5]}
				};
		
		BarChart chart = new BarChart(totalPerStrand, database.getTotalStudentsBySchoolYear((String) dateChooser.getSelectedItem()));
		chart.setBackground(Color.white);
		chart.setBounds(22, 211, 340, 300);
		chart.setLayout(null);
		contentPanel.add(chart);
			
		JTable strandTable = new JTable(data, column){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		strandTable.getTableHeader().setBackground(new Color(48, 46, 127));
		strandTable.getTableHeader().setForeground(new Color(251, 181, 23));
		
		JScrollPane strandTableScrollPane = new JScrollPane(strandTable);
		strandTableScrollPane.setBackground(new Color(255, 255, 255));
		strandTableScrollPane.setBounds(393, 211, 200, 119);
		contentPanel.add(strandTableScrollPane);
		
		String ABMPercentage = String.format("%.2f", 
		(double) database.getTotalByStrandAndSchoolYear(1, selectedYear) / (double) database.getTotalStudentsBySchoolYear((String) dateChooser.getSelectedItem()) * 100.0 );
		JLabel chartLabelABM = new JLabel("ABM: " + ABMPercentage + "%");
		chartLabelABM.setBounds(20, 35, 109, 14);
		chart.add(chartLabelABM);
		
		String GASPercentage = String.format("%.2f", 
		(double) database.getTotalByStrandAndSchoolYear(2, selectedYear) / (double) database.getTotalStudentsBySchoolYear((String) dateChooser.getSelectedItem()) * 100.0 );
		JLabel chartLabelGAS = new JLabel("GAS: " + GASPercentage+ "%");
		chartLabelGAS.setBounds(20, 75, 109, 14);
		chart.add(chartLabelGAS);
		
		String HUMSSPercentage = String.format("%.2f", 
		(double) database.getTotalByStrandAndSchoolYear(3, selectedYear) / (double) database.getTotalStudentsBySchoolYear((String) dateChooser.getSelectedItem()) * 100.0 );
		JLabel chartLabelHUMMS = new JLabel("HUMSS: " + HUMSSPercentage + "%");
		chartLabelHUMMS.setBounds(20, 115, 109, 14);
		chart.add(chartLabelHUMMS);
		
		String ICTPercentage = String.format("%.2f", 
		(double) database.getTotalByStrandAndSchoolYear(4, selectedYear) / (double) database.getTotalStudentsBySchoolYear((String) dateChooser.getSelectedItem()) * 100.0 );
		JLabel chartLabelICT = new JLabel("ICT: " + ICTPercentage + "%");
		chartLabelICT.setBounds(20, 155, 109, 14);
		chart.add(chartLabelICT);
		
		String STEMPercentage = String.format("%.2f", 
		(double) database.getTotalByStrandAndSchoolYear(5, selectedYear) / (double) database.getTotalStudentsBySchoolYear((String) dateChooser.getSelectedItem()) * 100.0 );
		JLabel chartLabelSTEM = new JLabel("STEM: " + STEMPercentage + "%");
		chartLabelSTEM.setBounds(20, 196, 109, 14);
		chart.add(chartLabelSTEM);
		
		String EIMPercentage = String.format("%.2f", 
		(double) database.getTotalByStrandAndSchoolYear(6, selectedYear) / (double) database.getTotalStudentsBySchoolYear((String) dateChooser.getSelectedItem()) * 100.0 );
		JLabel chartLabelEIM = new JLabel("EIM: " + EIMPercentage + "%");
		chartLabelEIM.setBounds(20, 236, 109, 14);
		chart.add(chartLabelEIM);

		JPanel totalStudentsCard = new JPanel();
		totalStudentsCard.setLayout(null);
		totalStudentsCard.setBackground(Color.WHITE);
		totalStudentsCard.setBounds(22, 81, 176, 52);
		contentPanel.add(totalStudentsCard);
		
		JLabel totalStudentsValueLabel = new JLabel(String.valueOf(database.getTotalStudentsBySchoolYear((String) dateChooser.getSelectedItem())));
		totalStudentsValueLabel.setForeground(new Color(0, 227, 0));
		totalStudentsValueLabel.setFont(new Font("Segoe UI Symbol", Font.BOLD, 18));
		totalStudentsValueLabel.setBounds(10, 7, 73, 21);
		totalStudentsCard.add(totalStudentsValueLabel);
		
		JLabel totalStudentsTitleLabel = new JLabel("Total Students");
		totalStudentsTitleLabel.setBounds(10, 29, 156, 14);
		totalStudentsCard.add(totalStudentsTitleLabel);
		
		JPanel totalSectionsCard = new JPanel();
		totalSectionsCard.setLayout(null);
		totalSectionsCard.setBackground(Color.WHITE);
		totalSectionsCard.setBounds(228, 81, 176, 52);
		contentPanel.add(totalSectionsCard);
		
		JLabel totalSectionsTitleLabel = new JLabel("Total Sections");
		totalSectionsTitleLabel.setBounds(10, 29, 92, 14);
		totalSectionsCard.add(totalSectionsTitleLabel);
		
		JLabel totalSectionsValueLabel = new JLabel(String.valueOf(database.getTotalSections()));
		totalSectionsValueLabel.setForeground(new Color(236, 167, 4));
		totalSectionsValueLabel.setFont(new Font("Segoe UI Symbol", Font.BOLD, 18));
		totalSectionsValueLabel.setBounds(10, 7, 73, 21);
		totalSectionsCard.add(totalSectionsValueLabel);
		
		JPanel totalTeachersCard = new JPanel();
		totalTeachersCard.setLayout(null);
		totalTeachersCard.setBackground(Color.WHITE);
		totalTeachersCard.setBounds(430, 81, 176, 52);
		contentPanel.add(totalTeachersCard);
		
		JLabel totalTeachersValueLabel = new JLabel(String.valueOf(database.getTotalTeachers()));
		totalTeachersValueLabel.setForeground(new Color(128, 0, 128));
		totalTeachersValueLabel.setFont(new Font("Segoe UI Symbol", Font.BOLD, 18));
		totalTeachersValueLabel.setBounds(10, 7, 140, 21);
		totalTeachersCard.add(totalTeachersValueLabel);
		
		JLabel totalTeachersTitleLabel = new JLabel("Total Teachers");
		totalTeachersTitleLabel.setBounds(10, 29, 92, 14);
		totalTeachersCard.add(totalTeachersTitleLabel);
		
		JPanel schoolYearCard = new JPanel();
		schoolYearCard.setLayout(null);
		schoolYearCard.setBackground(Color.WHITE);
		schoolYearCard.setBounds(22, 139, 176, 52);
		contentPanel.add(schoolYearCard);
		
		JLabel schoolYearValueLabel = new JLabel((String) dateChooser.getSelectedItem());
		schoolYearValueLabel.setForeground(new Color(255, 128, 128));
		schoolYearValueLabel.setFont(new Font("Segoe UI Symbol", Font.BOLD, 18));
		schoolYearValueLabel.setBounds(10, 7, 140, 21);
		schoolYearCard.add(schoolYearValueLabel);
		
		JLabel schoolYearTitleLabel = new JLabel("School Year");
		schoolYearTitleLabel.setBounds(10, 29, 92, 14);
		schoolYearCard.add(schoolYearTitleLabel);
		
		JButton refreshButton = new JButton("Refresh");
		refreshButton.setBounds(517, 488, 89, 23);
		refreshButton.setFocusable(false);
		refreshButton.addActionListener(e -> {
		    String selected = (String) dateChooser.getSelectedItem();
		    
		    // Update Total Students
		    totalStudentsValueLabel.setText(String.valueOf(
		        database.getTotalStudentsBySchoolYear(selected)));
		    
		    // Update School Year card
		    schoolYearValueLabel.setText(selected);
		    
		    // Update strand totals
		    int[] updatedTotals = {
		        database.getTotalByStrandAndSchoolYear(1, selected),
		        database.getTotalByStrandAndSchoolYear(2, selected),
		        database.getTotalByStrandAndSchoolYear(3, selected),
		        database.getTotalByStrandAndSchoolYear(4, selected),
		        database.getTotalByStrandAndSchoolYear(5, selected),
		        database.getTotalByStrandAndSchoolYear(6, selected)
		    };
		    
		    int total = database.getTotalStudentsBySchoolYear(selected);
		    
		    // Update percentage labels
		    chartLabelABM.setText("ABM: " + String.format("%.2f", (double)updatedTotals[0]/total*100) + "%");
		    chartLabelGAS.setText("GAS: " + String.format("%.2f", (double)updatedTotals[1]/total*100) + "%");
		    chartLabelHUMMS.setText("HUMSS: " + String.format("%.2f", (double)updatedTotals[2]/total*100) + "%");
		    chartLabelICT.setText("ICT: " + String.format("%.2f", (double)updatedTotals[3]/total*100) + "%");
		    chartLabelSTEM.setText("STEM: " + String.format("%.2f", (double)updatedTotals[4]/total*100) + "%");
		    chartLabelEIM.setText("EIM: " + String.format("%.2f", (double)updatedTotals[5]/total*100) + "%");

		    // Update table
		    Object[][] updatedData = {
		        {"ABM", updatedTotals[0]},
		        {"GAS", updatedTotals[1]},
		        {"HUMSS", updatedTotals[2]},
		        {"ICT", updatedTotals[3]},
		        {"STEM", updatedTotals[4]},
		        {"EIM", updatedTotals[5]}
		    };
		    strandTable.setModel(new DefaultTableModel(updatedData, column));
		    strandTable.getTableHeader().setBackground(new Color(48, 46, 127));
		    strandTable.getTableHeader().setForeground(new Color(251, 181, 23));
		    
		    // Repaint chart
		    chart.updateData(updatedTotals, total);
		    chart.repaint();
		});
		contentPanel.add(refreshButton);
		
		viewSectionsButton = new JButton("View Sections");
		viewSectionsButton.setBounds(393, 488, 120, 23);
		viewSectionsButton.setFocusable(false);
		viewSectionsButton.addActionListener(this);
		contentPanel.add(viewSectionsButton);
		
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnLogOut) {
			new LoginStaffAccess();
			frame.dispose();
		}
		if(e.getSource() == viewSectionsButton) {
			String selected = (String) dateChooser.getSelectedItem();
			new ViewSections(selected, database);
		}
		
	}

}
