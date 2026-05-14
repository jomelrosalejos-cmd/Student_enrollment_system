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
	
	public String getSchoolYear() {
		int currentYear = java.time.LocalDate.now().getYear();
		String schoolYear = currentYear + "-" + (currentYear + 1);
		return schoolYear;
	}
	
	public int getTotalStudents() {
		String query = "SELECT COUNT(*) AS totalStudents  FROM enrollments WHERE status = 'ENROLLED';";
		int totalStudents = 0;
		
		try {
			PreparedStatement statement2 = connection.prepareStatement(query);
			ResultSet resultStudentID = statement2.executeQuery();
			if (resultStudentID.next()) {
				totalStudents = resultStudentID.getInt("totalStudents");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return totalStudents;
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
	
	public int getTotalABMstudents() {
		String query = "SELECT COUNT(*) AS totalABMstudents FROM students INNER JOIN enrollments ON students.student_id = enrollments.enrollment_id WHERE strand_id = 1 AND status = 'ENROLLED';";
		int totalABMstudents = 0;
		
		try {
			PreparedStatement statement2 = connection.prepareStatement(query);
			ResultSet resultStudentID = statement2.executeQuery();
			if (resultStudentID.next()) {
				totalABMstudents = resultStudentID.getInt("totalABMstudents");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return totalABMstudents;
	}
	
	public int getTotalGASstudents() {
		String query = "SELECT COUNT(*) AS totalGASstudents FROM students INNER JOIN enrollments"
				+ " ON students.student_id = enrollments.enrollment_id WHERE strand_id = 2 AND status = 'ENROLLED';";
		int totalGASstudents = 0;
		
		try {
			PreparedStatement statement2 = connection.prepareStatement(query);
			ResultSet resultStudentID = statement2.executeQuery();
			if (resultStudentID.next()) {
				totalGASstudents = resultStudentID.getInt("totalGASstudents");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return totalGASstudents;
	}
	
	public int getTotalHUMSSstudents() {
		String query = "SELECT COUNT(*) AS totalHUMSSstudents FROM students INNER"
				+ " JOIN enrollments ON students.student_id = enrollments.enrollment_id WHERE strand_id = 3 AND status = 'ENROLLED';";
		int totalHUMSSstudents = 0;
		
		try {
			PreparedStatement statement2 = connection.prepareStatement(query);
			ResultSet resultStudentID = statement2.executeQuery();
			if (resultStudentID.next()) {
				totalHUMSSstudents = resultStudentID.getInt("totalHUMSSstudents");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return totalHUMSSstudents;
	}
	
	public int getTotalICTstudents() {
		String query = "SELECT COUNT(*) AS totalICTstudents FROM students INNER JOIN enrollments ON "
				+ "students.student_id = enrollments.enrollment_id WHERE strand_id = 4 AND status = 'ENROLLED';";
		int totalICTstudents = 0;
		
		try {
			PreparedStatement statement2 = connection.prepareStatement(query);
			ResultSet resultStudentID = statement2.executeQuery();
			if (resultStudentID.next()) {
				totalICTstudents = resultStudentID.getInt("totalICTstudents");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return totalICTstudents;
	}
	
	public int getTotalSTEMstudents() {
		String query = "SELECT COUNT(*) AS totalSTEMstudents FROM students INNER JOIN enrollments ON "
				+ "students.student_id = enrollments.enrollment_id WHERE strand_id = 5 AND status = 'ENROLLED';";
		int totalSTEMstudents = 0;
		
		try {
			PreparedStatement statement2 = connection.prepareStatement(query);
			ResultSet resultStudentID = statement2.executeQuery();
			if (resultStudentID.next()) {
				totalSTEMstudents = resultStudentID.getInt("totalSTEMstudents");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return totalSTEMstudents;
	}
	
	public int getTotalEIMstudents() {
		String query = "SELECT COUNT(*) AS totalEIMstudents FROM students INNER JOIN enrollments ON "
				+ "students.student_id = enrollments.enrollment_id WHERE strand_id = 6 AND status = 'ENROLLED';";
		int totalEIMstudents = 0;
		
		try {
			PreparedStatement statement2 = connection.prepareStatement(query);
			ResultSet resultStudentID = statement2.executeQuery();
			if (resultStudentID.next()) {
				totalEIMstudents = resultStudentID.getInt("totalEIMstudents");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return totalEIMstudents;
	}
	
	public ArrayList<Object[]> getStudentsInSection() {
		String query = "SELECT students.student_id, last_name, first_name, middle_name, LRN, birthdate, gender "
				+ "FROM students INNER JOIN enrollments ON students.student_id = enrollments.student_id "
				+ "WHERE section_id = ?;";
		ArrayList<Object[]> List = new ArrayList<>();
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, getSectionIDByTeacher());
			ResultSet resultSet = statement.executeQuery();

			while(resultSet.next()) {
			    Object[] row = {
			        resultSet.getInt("student_id"),
			        resultSet.getString("last_name") + ", " 
			        + resultSet.getString("first_name") +" "+ resultSet.getString("middle_name"),
			        resultSet.getString("LRN"),
			        resultSet.getString("birthdate"),
			        resultSet.getString("gender"),
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
	    
	    String[] info = new String[4];
	    
	    try {
	        PreparedStatement stmt = connection.prepareStatement(query);
	        stmt.setInt(1, getSectionIDByTeacher());
	        ResultSet rs = stmt.executeQuery();
	        
	        if (rs.next()) {
	            info[0] = rs.getString("section_name");
	            info[1] = rs.getString("strand_name");
	            info[2] = rs.getString("first_name") + " " + 
	            		  rs.getString("last_name");
	            info[3] = String.valueOf(getClassSize());
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return info;
	}
	
	public int getClassSize() {
	    String query = "SELECT COUNT(*) AS classSize FROM enrollments " +
	                   "WHERE section_id = ? AND status = 'ENROLLED'";
	    try {
	        PreparedStatement stmt = connection.prepareStatement(query);
	        stmt.setInt(1, getSectionIDByTeacher());
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            return rs.getInt("classSize");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return 0;
	}
	
}
