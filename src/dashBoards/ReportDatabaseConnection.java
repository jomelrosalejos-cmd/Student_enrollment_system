package dashBoards;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReportDatabaseConnection {
	private static String url = "jdbc:mysql://localhost:3306/student_enrollment_db_system";
	private static String username = "root";
	private static String password = "fdgVH2731@BIRINGAN";
	
	static Connection connection;
	static {
	    try {
	    	connection = DriverManager.getConnection(url, username, password);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	
	public int getTotalEnrolledBySchoolYear(String schoolYear) {
        String query = "SELECT COUNT(*) FROM enrollments WHERE status = 'ENROLLED' AND school_year = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, schoolYear);
            ResultSet rs = statement.executeQuery();
            if(rs.next()) return rs.getInt(1);
        } catch (SQLException e) { e.printStackTrace(); }
        return 0;
    }

    public ArrayList<String[]> getStrandsWithEnrolledStudents(String schoolYear) {
        ArrayList<String[]> list = new ArrayList<>();
        String query = "SELECT DISTINCT strands.strand_id, strands.strand_name "
                + "FROM strands "
                + "INNER JOIN students ON strands.strand_id = students.strand_id "
                + "INNER JOIN enrollments ON students.student_id = enrollments.student_id "
                + "WHERE enrollments.status = 'ENROLLED' AND enrollments.school_year = ? "
                + "ORDER BY strands.strand_id;";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, schoolYear);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                list.add(new String[]{
                    rs.getString("strand_id"),
                    rs.getString("strand_name")
                });
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    public ArrayList<String[]> getSectionsByStrand(String strandID, String schoolYear) {
        ArrayList<String[]> list = new ArrayList<>();
        String query = "SELECT DISTINCT sections.section_id, sections.section_name, "
                + "CONCAT(teachers.first_name, ' ', teachers.last_name) AS teacher_name "
                + "FROM sections "
                + "INNER JOIN teachers ON sections.teacher_id = teachers.teacher_id "
                + "INNER JOIN enrollments ON sections.section_id = enrollments.section_id "
                + "INNER JOIN students ON enrollments.student_id = students.student_id "
                + "WHERE students.strand_id = ? AND enrollments.status = 'ENROLLED' "
                + "AND enrollments.school_year = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, strandID);
            statement.setString(2, schoolYear);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                list.add(new String[]{
                    rs.getString("section_id"),
                    rs.getString("section_name"),
                    rs.getString("teacher_name")
                });
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    public ArrayList<Object[]> getEnrolledStudentsBySection(String sectionID, String schoolYear) {
        ArrayList<Object[]> list = new ArrayList<>();
        String query = "SELECT students.student_id, "
                + "CONCAT(students.last_name, ', ', students.first_name, ' ', students.middle_name) AS full_name, "
                + "students.LRN, students.gender, students.birthdate, students.phone_number, "
                + "user_accounts.email, "
                + "CONCAT(students.house_number, ' ', students.street, ' st., BRGY.', "
                + "students.barangay, ', ', students.municipality, ', ', students.province) AS address "
                + "FROM students "
                + "INNER JOIN enrollments ON students.student_id = enrollments.student_id "
                + "INNER JOIN user_accounts ON students.user_id = user_accounts.user_id "
                + "WHERE enrollments.section_id = ? AND enrollments.status = 'ENROLLED' "
                + "AND enrollments.school_year = ? "
                + "ORDER BY students.last_name;";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, sectionID);
            statement.setString(2, schoolYear);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                list.add(new Object[]{
                    rs.getInt("student_id"),
                    rs.getString("full_name"),
                    rs.getString("LRN"),
                    rs.getString("gender"),
                    rs.getString("birthdate"),
                    rs.getString("phone_number"),
                    rs.getString("email"),
                    rs.getString("address")
                });
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }
	
	
}
