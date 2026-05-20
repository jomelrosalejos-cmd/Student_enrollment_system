package dashBoards;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Principal_TeacherDatabaseConnection {
	
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
	
	private int roleID;
	private int userID;
	
	public boolean Verify (String usernameInput, String userPasswordInput) {
		String query = "SELECT * FROM user_accounts WHERE user_name = ? AND password = ?;";	
		boolean successful = false;
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, usernameInput);
			statement.setString(2, userPasswordInput);
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next()){
				successful = true;
				roleID = resultSet.getInt("role_id");
				userID = resultSet.getInt("user_id");
			}
			else{successful = false;}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return successful;
	}
	
	public int getRoleID() {
		return roleID;
	}
	
	public ArrayList<String> getSchoolYears() {
	    ArrayList<String> schoolYears = new ArrayList<>();
	    String query = "SELECT DISTINCT school_year FROM enrollments ORDER BY school_year DESC;";
	    try {
	        PreparedStatement statement = connection.prepareStatement(query);
	        ResultSet resultSet = statement.executeQuery();
	        while(resultSet.next()) schoolYears.add(resultSet.getString("school_year"));
	    } catch (SQLException e) { e.printStackTrace(); }
	    return schoolYears;
	}
	
	public int getTotalStudentsBySchoolYear(String schoolYear) {
	    String query = "SELECT COUNT(*) FROM enrollments WHERE school_year = ?;";
	    try {
	        PreparedStatement statement = connection.prepareStatement(query);
	        statement.setString(1, schoolYear);
	        ResultSet resultSet = statement.executeQuery();
	        if(resultSet.next()) return resultSet.getInt(1);
	    } catch (SQLException e) { e.printStackTrace(); }
	    return 0;
	}
	
	public int getTotalSections() {
		String query = "SELECT COUNT(*) AS totalSections FROM sections;";
		int totalSections = 0;
		
		try {
			PreparedStatement statement2 = connection.prepareStatement(query);
			ResultSet resultStudentID = statement2.executeQuery();
			if (resultStudentID.next()) {
				totalSections = resultStudentID.getInt("totalSections");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return totalSections;
	}
	
	public int getTotalTeachers() {
		String query = "SELECT COUNT(*) AS totalTeachers FROM teachers;";
		int totalTeachers = 0;
		
		try {
			PreparedStatement statement2 = connection.prepareStatement(query);
			ResultSet resultStudentID = statement2.executeQuery();
			if (resultStudentID.next()) {
				totalTeachers = resultStudentID.getInt("totalTeachers");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return totalTeachers;
	}
	
	public int getTotalByStrandAndSchoolYear(int strandID, String schoolYear) {
	    String query = "SELECT COUNT(*) FROM students s " +
	                   "INNER JOIN enrollments e ON s.student_id = e.student_id " +
	                   "WHERE s.strand_id = ? AND e.school_year = ?;";
	    try {
	        PreparedStatement statement = connection.prepareStatement(query);
	        statement.setInt(1, strandID);
	        statement.setString(2, schoolYear);
	        ResultSet resultSet = statement.executeQuery();
	        if(resultSet.next()) return resultSet.getInt(1);
	    } catch (SQLException e) { e.printStackTrace(); }
	    return 0;
	}
	
	public ArrayList<Object[]> getStudentsInSection(String selectedYear) {
	    String query = "SELECT students.student_id, last_name, first_name, middle_name, LRN, birthdate, gender, "
	            + "phone_number, house_number, street, barangay, municipality, province, email "
	            + "FROM students INNER JOIN enrollments ON students.student_id = enrollments.student_id "
	            + "INNER JOIN user_accounts ON students.user_id = user_accounts.user_id "
	            + "WHERE section_id = ? AND school_year = ?;";
	    ArrayList<Object[]> List = new ArrayList<>();
	    
	    try {
	        PreparedStatement statement = connection.prepareStatement(query);
	        statement.setInt(1, getSectionIDByTeacher());
	        statement.setString(2, selectedYear);
	        ResultSet resultSet = statement.executeQuery();

	        while(resultSet.next()) {
	            String address = resultSet.getString("house_number") + " "
	                    + resultSet.getString("street") + " st., BRGY."
	                    + resultSet.getString("barangay") + ", "
	                    + resultSet.getString("municipality") + ", "
	                    + resultSet.getString("province");
	            
	            Object[] row = {
	                resultSet.getInt("student_id"),
	                resultSet.getString("last_name") + ", " 
	                + resultSet.getString("first_name") + " " + resultSet.getString("middle_name"),
	                resultSet.getString("LRN"),
	                resultSet.getString("birthdate"),
	                resultSet.getString("gender"),
	                resultSet.getString("phone_number"),
	                resultSet.getString("email"),
	                address
	            };
	            List.add(row);
	        }
	    }
	    catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return List;
	}
	
	public int getSectionIDByTeacher() {
	    String query = "SELECT section_id FROM sections " +
	                   "WHERE teacher_id = (" +
	                   "SELECT teacher_id FROM teachers WHERE user_id = ?)";
	    try {
	        PreparedStatement stmt = connection.prepareStatement(query);
	        stmt.setInt(1, userID);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            return rs.getInt("section_id");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return -1;
	}
	
	public String[] getSectionInfo() {
	    String query = "SELECT sections.section_name, strands.strand_name, " +
	                   "teachers.first_name, teachers.last_name, teachers.middle_name " +
	                   "FROM sections " +
	                   "INNER JOIN strands ON sections.strand_id = strands.strand_id " +
	                   "INNER JOIN teachers ON sections.teacher_id = teachers.teacher_id " +
	                   "WHERE sections.section_id = ?";
	    
	    String[] info = new String[3];
	    
	    try {
	        PreparedStatement stmt = connection.prepareStatement(query);
	        stmt.setInt(1, getSectionIDByTeacher());
	        ResultSet rs = stmt.executeQuery();
	        
	        if (rs.next()) {
	            info[0] = rs.getString("section_name");
	            info[1] = rs.getString("strand_name");
	            info[2] = rs.getString("first_name") + " " + 
	            		  rs.getString("last_name");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return info;
	}
	
	public int getClassSize(String selectedYear) {
	    String query = "SELECT COUNT(*) AS classSize FROM enrollments " +
	                   "WHERE section_id = ? AND status = 'ENROLLED' AND school_year = ?;";
	    try {
	        PreparedStatement statement = connection.prepareStatement(query);
	        statement.setInt(1, getSectionIDByTeacher());
	        statement.setString(2, selectedYear);
	        ResultSet rs = statement.executeQuery();
	        if (rs.next()) {
	            return rs.getInt("classSize");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return 0;
	}
	
	public ArrayList<Object[]> searchStudent(int student_id, String selectedYear) {
	    String query = "SELECT students.student_id, last_name, first_name, middle_name, LRN, birthdate, gender, "
	            + "phone_number, house_number, street, barangay, municipality, province, email "
	            + "FROM students INNER JOIN enrollments ON students.student_id = enrollments.student_id "
	            + "INNER JOIN user_accounts ON students.user_id = user_accounts.user_id "
	            + "WHERE students.student_id = ? AND school_year = ? AND section_id = ?;";
	    ArrayList<Object[]> List = new ArrayList<>();

	    try {
	        PreparedStatement statement = connection.prepareStatement(query);
	        statement.setInt(1, student_id);
	        statement.setString(2, selectedYear);
	        statement.setInt(3, getSectionIDByTeacher());
	        ResultSet resultSet = statement.executeQuery();

	        if(resultSet.next()) {
	            String address = resultSet.getString("house_number") + " "
	                    + resultSet.getString("street") + " st., BRGY."
	                    + resultSet.getString("barangay") + ", "
	                    + resultSet.getString("municipality") + ", "
	                    + resultSet.getString("province");

	            Object[] row = {
	                resultSet.getInt("student_id"),
	                resultSet.getString("last_name") + ", " +
	                resultSet.getString("first_name") + " " +
	                resultSet.getString("middle_name"),
	                resultSet.getString("LRN"),
	                resultSet.getString("birthdate"),
	                resultSet.getString("gender"),
	                resultSet.getString("phone_number"),
	                resultSet.getString("email"),
	                address
	            };
	            List.add(row);
	        }
	    }
	    catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return List;
	}
	
	public ArrayList<Object[]> searchStudent(String studentName, String selectedYear) {
	    String query = "SELECT students.student_id, last_name, first_name, middle_name, LRN, birthdate, gender, "
	            + "phone_number, house_number, street, barangay, municipality, province, email "
	            + "FROM students INNER JOIN enrollments ON students.student_id = enrollments.student_id "
	            + "INNER JOIN user_accounts ON students.user_id = user_accounts.user_id "
	            + "WHERE students.last_name = ? AND school_year = ? AND section_id = ?;";
	    ArrayList<Object[]> List = new ArrayList<>();

	    try {
	        PreparedStatement statement = connection.prepareStatement(query);
	        statement.setString(1, studentName);
	        statement.setString(2, selectedYear);
	        statement.setInt(3, getSectionIDByTeacher());
	        ResultSet resultSet = statement.executeQuery();

	        if(resultSet.next()) {
	            String address = resultSet.getString("house_number") + " "
	                    + resultSet.getString("street") + " st., BRGY."
	                    + resultSet.getString("barangay") + ", "
	                    + resultSet.getString("municipality") + ", "
	                    + resultSet.getString("province");

	            Object[] row = {
	                resultSet.getInt("student_id"),
	                resultSet.getString("last_name") + ", " +
	                resultSet.getString("first_name") + " " +
	                resultSet.getString("middle_name"),
	                resultSet.getString("LRN"),
	                resultSet.getString("birthdate"),
	                resultSet.getString("gender"),
	                resultSet.getString("phone_number"),
	                resultSet.getString("email"),
	                address
	            };
	            List.add(row);
	        }
	    }
	    catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return List;
	}
	
	public ArrayList<Object[]> getSectionsPerStrand(String schoolYear) {
	    ArrayList<Object[]> list = new ArrayList<>();
	    String query = "SELECT strands.strand_name, sections.section_name, " +
	                   "CONCAT(teachers.first_name, ' ', teachers.last_name) AS teacher_name, " +
	                   "COUNT(enrollments.student_id) AS total_students " +
	                   "FROM sections " +
	                   "INNER JOIN strands ON sections.strand_id = strands.strand_id " +
	                   "INNER JOIN teachers ON sections.teacher_id = teachers.teacher_id " +
	                   "LEFT JOIN enrollments ON sections.section_id = enrollments.section_id " +
	                   "AND enrollments.school_year = ? " +
	                   "GROUP BY sections.section_id " +
	                   "ORDER BY strands.strand_name;";
	    try {
	        PreparedStatement statement = connection.prepareStatement(query);
	        statement.setString(1, schoolYear);
	        ResultSet resultSet = statement.executeQuery();
	        while(resultSet.next()) {
	            Object[] row = {
	                resultSet.getString("strand_name"),
	                resultSet.getString("section_name"),
	                resultSet.getString("teacher_name"),
	                resultSet.getInt("total_students")
	            };
	            list.add(row);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return list;
	}
	
}
