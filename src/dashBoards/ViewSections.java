package dashBoards;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class ViewSections {
	
	JTable table;
	Image iconImage;
	
	public ViewSections(String selectedYear, Principal_TeacherDatabaseConnection database) {
		String selected = selectedYear;
		
		iconImage = new ImageIcon(getClass().getResource("/images/yobhel_logo.jpg")).getImage();
		
		ArrayList<Object[]> sectionRows = database.getSectionsPerStrand(selected);
	    Object[][] sectionData = sectionRows.toArray(new Object[0][]);
	    String[] sectionColumn = {"Strand", "Section", "Teacher", "Total Students"};
		
	    JFrame frame = new JFrame("View Sections");
	    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setBounds(100, 100, 500, 342);
	    frame.setIconImage(iconImage);
	    frame.setLayout(new BorderLayout(0, 0));
	    frame.setLocationRelativeTo(null);

	    JPanel panel = new JPanel();
	    panel.setBackground(new Color(255, 255, 255));
	    panel.setLayout(new BorderLayout(0, 0));

	    JPanel panel_1 = new JPanel();
	    panel_1.setBackground(new Color(48, 46, 127));
	    panel_1.setPreferredSize(new Dimension(0, 40));
	    panel.add(panel_1, BorderLayout.NORTH);
	    panel_1.setLayout(null);

	    JLabel lblNewLabel = new JLabel("Sections per Strand");
	    lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 20));
	    lblNewLabel.setForeground(new Color(251, 181, 23));
	    lblNewLabel.setBounds(10, 6, 334, 29);
	    panel_1.add(lblNewLabel);

	    JPanel panel_2 = new JPanel();
	    panel_2.setBackground(new Color(255, 255, 255));
	    panel.add(panel_2, BorderLayout.CENTER);
	    panel_2.setLayout(null);

	    JTable sectionTable = new JTable(sectionData, sectionColumn) {
	        @Override
	        public boolean isCellEditable(int row, int column) {
	            return false;
	        }
	    };
	    sectionTable.getTableHeader().setBackground(new Color(48, 46, 127));
	    sectionTable.getTableHeader().setForeground(new Color(251, 181, 23));
	    
	    JScrollPane sectionScrollPane = new JScrollPane(sectionTable);
	    sectionScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    sectionScrollPane.setBounds(29, 24, 420, 196);
	    panel_2.add(sectionScrollPane);

	    frame.add(panel);
	    frame.setVisible(true);
	}

}
