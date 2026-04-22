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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;


public class PrincipalDashboard {
	
	Image imageLogo;
	Image iconImage;
	
	public PrincipalDashboard() {
		
		imageLogo = new ImageIcon(getClass().getResource("/images/yobhelBanner.jpg")).getImage();
		iconImage = new ImageIcon(getClass().getResource("/images/yobhel_logo.jpg")).getImage();
		
		JFrame frame = new JFrame("Student Dashboard");
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
		
		JLabel dashboardTitleLabel = new JLabel("Principal Dashboard");
		dashboardTitleLabel.setForeground(new Color(255, 255, 255));
		dashboardTitleLabel.setFont(new Font("Serif", Font.BOLD, 15));
		dashboardTitleLabel.setBounds(34, 20, 167, 28);
		dashboardTitlePanel.add(dashboardTitleLabel);
		
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
		int[] totalPerStrand = {150, 100, 150, 50, 50, 300};
		Object[][] data = {
				{"ABM", totalPerStrand[0]},
				{"IA", totalPerStrand[1]},
				{"ICT", totalPerStrand[2]},
				{"HUMSS", totalPerStrand[3]},
				{"GAS", totalPerStrand[4]},
				{"STEM", totalPerStrand[5]}
				};
		
		BarChart chart = new BarChart(totalPerStrand);
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
		
		JLabel chartLabelIA = new JLabel("IA");
		chartLabelIA.setBounds(20, 75, 109, 14);
		chart.add(chartLabelIA);
		
		JLabel chartLabelICT = new JLabel("ICT");
		chartLabelICT.setBounds(20, 115, 109, 14);
		chart.add(chartLabelICT);
		
		JLabel chartLabelGAS = new JLabel("GAS");
		chartLabelGAS.setBounds(20, 155, 109, 14);
		chart.add(chartLabelGAS);
		
		JLabel chartLabelHUMSS = new JLabel("HUMSS");
		chartLabelHUMSS.setBounds(20, 196, 109, 14);
		chart.add(chartLabelHUMSS);
		
		JLabel chartLabelSTEM = new JLabel("STEM");
		chartLabelSTEM.setBounds(20, 236, 109, 14);
		chart.add(chartLabelSTEM);
		
		JLabel chartLabelABM = new JLabel("ABM");
		chartLabelABM.setBounds(20, 35, 109, 14);
		chart.add(chartLabelABM);
		
		JPanel totalStudentsCard = new JPanel();
		totalStudentsCard.setLayout(null);
		totalStudentsCard.setBackground(Color.WHITE);
		totalStudentsCard.setBounds(22, 81, 176, 52);
		contentPanel.add(totalStudentsCard);
		
		JLabel totalStudentsValueLabel = new JLabel("800");
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
		
		JLabel totalSectionsValueLabel = new JLabel("40");
		totalSectionsValueLabel.setForeground(new Color(236, 167, 4));
		totalSectionsValueLabel.setFont(new Font("Segoe UI Symbol", Font.BOLD, 18));
		totalSectionsValueLabel.setBounds(10, 7, 73, 21);
		totalSectionsCard.add(totalSectionsValueLabel);
		
		JPanel totalTeachersCard = new JPanel();
		totalTeachersCard.setLayout(null);
		totalTeachersCard.setBackground(Color.WHITE);
		totalTeachersCard.setBounds(430, 81, 176, 52);
		contentPanel.add(totalTeachersCard);
		
		JLabel totalTeachersValueLabel = new JLabel("70");
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
		
		JLabel schoolYearValueLabel = new JLabel("2024-2025");
		schoolYearValueLabel.setForeground(new Color(255, 128, 128));
		schoolYearValueLabel.setFont(new Font("Segoe UI Symbol", Font.BOLD, 18));
		schoolYearValueLabel.setBounds(10, 7, 140, 21);
		schoolYearCard.add(schoolYearValueLabel);
		
		JLabel schoolYearTitleLabel = new JLabel("School Year");
		schoolYearTitleLabel.setBounds(10, 29, 92, 14);
		schoolYearCard.add(schoolYearTitleLabel);
		
		frame.setVisible(true);
		
	}

}
