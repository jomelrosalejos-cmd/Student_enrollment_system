package dashBoards;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class RegistrarDatabaseConnection {
	
	private static String url = "jdbc:mysql://localhost:3306/student_enrollment_db_system";
	private static String username = "root";
	private static String password = "fdgVH2731@BIRINGAN";
	
	static Connection connection;
	static {
	    try {
	    	connection = DriverManager.getConnection(url, username, password);
	    }
	    catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	
	
	
	public ArrayList<Object[]> getEnrollments(String selectedYear) {
		String query = "SELECT students.student_id, last_name, first_name, LRN, gender, "
		+ "strand_id, status FROM students INNER JOIN enrollments ON students.student_id = enrollments.student_id "
		+ "WHERE school_year = ?;";
		ArrayList<Object[]> List = new ArrayList<>();
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, selectedYear);
			ResultSet resultSet = statement.executeQuery();

			while(resultSet.next()) {
			    Object[] row = {
			        resultSet.getInt("student_id"),
			        resultSet.getString("last_name") + ", " + resultSet.getString("first_name"),
			        resultSet.getString("LRN"),
			        resultSet.getString("gender"),
			        getStrand(resultSet.getInt("strand_id")),
			        resultSet.getString("status")
			    };
			    List.add(row);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return List;
	}
	
	public ArrayList<Object[]> getPendingEnrollments(String selectedYear) {
		String query = "SELECT students.student_id, last_name, first_name, LRN, gender, strand_id, "
		+ "status FROM students INNER JOIN enrollments ON students.student_id = enrollments.student_id WHERE status = 'PENDING' AND school_year = ?;";
		ArrayList<Object[]> List = new ArrayList<>();
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, selectedYear);
			ResultSet resultSet = statement.executeQuery();

			while(resultSet.next()) {
			    Object[] row = {
			        resultSet.getInt("student_id"),
			        resultSet.getString("last_name") + ", " + resultSet.getString("first_name"),
			        resultSet.getString("LRN"),
			        resultSet.getString("gender"),
			        getStrand(resultSet.getInt("strand_id")),
			        resultSet.getString("status")
			    };
			    List.add(row);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return List;
	}
	
	public ArrayList<Object[]> getEnrolledEnrollments(String selectedYear) {
		String query = "SELECT students.student_id, last_name, first_name, LRN, gender, strand_id, status FROM students INNER JOIN enrollments ON students.student_id = enrollments.student_id WHERE status = 'ENROLLED' AND school_year = ?;";
		ArrayList<Object[]> List = new ArrayList<>();
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, selectedYear);
			ResultSet resultSet = statement.executeQuery();

			while(resultSet.next()) {
			    Object[] row = {
			        resultSet.getInt("student_id"),
			        resultSet.getString("last_name") + ", " + resultSet.getString("first_name"),
			        resultSet.getString("LRN"),
			        resultSet.getString("gender"),
			        getStrand(resultSet.getInt("strand_id")),
			        resultSet.getString("status")
			    };
			    List.add(row);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return List;
	}
	
	public ArrayList<Object[]> getRejectedEnrollments(String selectedYear) {
		String query = "SELECT students.student_id, last_name, first_name, LRN, gender, strand_id, status FROM students INNER JOIN enrollments ON students.student_id = enrollments.student_id WHERE status = 'REJECTED' AND school_year = ?;";
		ArrayList<Object[]> List = new ArrayList<>();
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, selectedYear);
			ResultSet resultSet = statement.executeQuery();

			while(resultSet.next()) {
			    Object[] row = {
			        resultSet.getInt("student_id"),
			        resultSet.getString("last_name") + ", " + resultSet.getString("first_name"),
			        resultSet.getString("LRN"),
			        resultSet.getString("gender"),
			        getStrand(resultSet.getInt("strand_id")),
			        resultSet.getString("status")
			    };
			    List.add(row);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return List;
	}
	
	public ArrayList<Object[]> searchStudent(int student_id, String selectedYear) {
		String query = "SELECT students.student_id, last_name, first_name, LRN, gender, "
		+ "strand_id, status FROM students INNER JOIN enrollments ON students.student_id = enrollments.student_id WHERE students.student_id = ? AND school_year = ?;";
		ArrayList<Object[]> List = new ArrayList<>();
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, student_id);
			statement.setString(2, selectedYear);
			ResultSet resultSet = statement.executeQuery();

			if(resultSet.next()) {
			    Object[] row = {
			        resultSet.getInt("student_id"),
			        resultSet.getString("last_name") + ", " + resultSet.getString("first_name"),
			        resultSet.getString("LRN"),
			        resultSet.getString("gender"),
			        getStrand(resultSet.getInt("strand_id")),
			        resultSet.getString("status")
			    };
			    List.add(row);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return List;
	}
	
	public Object[] getStudentInformation(int student_id) {
		String query = "SELECT student_id, last_name, first_name, middle_name, suffix, "
	            + "LRN, birthdate, gender, house_number, street, barangay, municipality, "
	            + "province, phone_number, email, user_accounts.user_id, user_name, password "
	            + "FROM students INNER JOIN user_accounts "
	            + "ON students.user_id = user_accounts.user_id "
	            + "WHERE students.student_id = ?;";
		
		Object[] studentData = new Object[19];
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, student_id);
			ResultSet resultSet = statement.executeQuery();

			if(resultSet.next()) {
				studentData[0] = resultSet.getInt("student_id");
				studentData[1] = resultSet.getString("last_name");
				studentData[2] = resultSet.getString("LRN");
				studentData[3] = resultSet.getString("birthdate");
				studentData[4] = resultSet.getString("gender");
				studentData[5] = resultSet.getString("phone_number");
				//studentData[6];
				studentData[7] = resultSet.getString("email");
				studentData[8] = resultSet.getString("user_id");
				studentData[9] = resultSet.getString("user_name");
				studentData[10] = resultSet.getString("password");
				studentData[11] = resultSet.getString("first_name");
				studentData[12] = resultSet.getString("middle_name");
				
				studentData[13] = resultSet.getString("suffix");
	            studentData[14] = resultSet.getString("house_number");
	            studentData[15] = resultSet.getString("street");
	            studentData[16] = resultSet.getString("barangay");
	            studentData[17] = resultSet.getString("municipality");
	            studentData[18] = resultSet.getString("province");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return studentData;
	}
	
	public void deleteStudentEnrollmentRecord(int student_id) {
		String query = "DELETE FROM enrollments WHERE student_id = ?;";
	
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, student_id);
			int resultSet = statement.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String getStrand(int strandID) {
		String strandName = "";
		
		switch(strandID) {
		case 1: strandName = "ABM"; break;
		case 2: strandName = "GAS"; break;
		case 3: strandName = "HUMSS"; break;
		case 4: strandName = "ICT"; break;
		case 5: strandName = "STEM"; break;
		case 6: strandName = "EIM"; break;
		}
		
		return strandName;
	}
	
	public String getFilePath(String documentType, int enrollmentID) {
		String query = "SELECT file_path FROM student_requirements WHERE enrollment_id = ? AND document_type = ?;";
		String filePath = "";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, enrollmentID);
			statement.setString(2, documentType);
			ResultSet resultSet = statement.executeQuery();

			if(resultSet.next()) {
				filePath = resultSet.getString("file_path");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return filePath;
	}
	
	public int getEnrollmentID(int student_id) {
		String query = "SELECT enrollment_id FROM enrollments WHERE student_id = ?;";
		int enrollmentID = 0;
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, student_id);
			ResultSet resultSet = statement.executeQuery();

			if(resultSet.next()) {
				enrollmentID = resultSet.getInt("enrollment_id");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return enrollmentID;
	}
	
	public int getTotalPending(String status, String selectedYear) {
		String query = "SELECT COUNT(*) AS totalPending  FROM enrollments WHERE status = ? AND school_year = ?;";
		int total = 0;
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, status);
			statement.setString(2, selectedYear);
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				total = resultSet.getInt("totalPending");
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return total;
	}
	
	public Object[] getClassInfo(int sectionID) {
		String query = "SELECT strand_id, section_name, last_name, first_name, middle_name "
				+ "FROM teachers INNER JOIN sections ON teachers.teacher_id = sections.teacher_id WHERE sections.section_id = ? ;";
		Object[] studentData = new Object[3];
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, sectionID);
			ResultSet resultSet = statement.executeQuery();

			if(resultSet.next()) {
				studentData[0] = resultSet.getString("section_name");
				studentData[1] = getStrand(resultSet.getInt("strand_id"));
				studentData[2] = resultSet.getString("last_name") + ", " + resultSet.getString("first_name") + " "+ resultSet.getString("middle_name");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return studentData;
	}
	
	public int getSectionID(int enrollmentID) {
		String query = "SELECT section_id FROM enrollments WHERE enrollment_id = ?;";
		int secionID = 0;
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, enrollmentID);
			ResultSet resultSet = statement.executeQuery();

			if(resultSet.next()) {
				secionID = resultSet.getInt("section_id");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return secionID;
	}
	
	public void setDocumentStatusToApproved(String documentType, int enrollmentID) {
		String query = "UPDATE student_requirements SET status = 'APPROVED'"
				+ "WHERE enrollment_id = ? AND document_type = ?;";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, enrollmentID);
			statement.setString(2, documentType);
			
			int resultSet = statement.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void setDocumentStatusToRejected(String documentType, int enrollmentID) {
		String query = "UPDATE student_requirements SET status = 'REJECTED'"
				+ "WHERE enrollment_id = ? AND document_type = ?;";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, enrollmentID);
			statement.setString(2, documentType);
			
			int resultSet = statement.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateStudentInfo(String firstName, String middleName, String lastName, String suffix,
	        String lrn, String birthdate, String gender, String phoneNumber, 
	        String houseNumber, String street, String barangay, String municipality, String province,
	        String email, String username, String password, int studentID) {
	    
	    String query = "UPDATE students, user_accounts SET "
	            + "students.first_name = ?, students.middle_name = ?, "
	            + "students.last_name = ?, students.suffix = ?, students.LRN = ?, students.birthdate = ?, "
	            + "students.gender = ?, students.phone_number = ?, "
	            + "students.house_number = ?, students.street = ?, students.barangay = ?, "
	            + "students.municipality = ?, students.province = ?, "
	            + "user_accounts.email = ?, "
	            + "user_accounts.user_name = ?, user_accounts.password = ? "
	            + "WHERE students.student_id = ? AND students.user_id = user_accounts.user_id;";

	    try {
	        PreparedStatement statement = connection.prepareStatement(query);
	        statement.setString(1, firstName);
	        statement.setString(2, middleName);
	        statement.setString(3, lastName);
	        statement.setString(4, suffix);
	        statement.setString(5, lrn);
	        statement.setString(6, birthdate);
	        statement.setString(7, gender);
	        statement.setString(8, phoneNumber);
	        statement.setString(9, houseNumber);
	        statement.setString(10, street);
	        statement.setString(11, barangay);
	        statement.setString(12, municipality);
	        statement.setString(13, province);
	        statement.setString(14, email);
	        statement.setString(15, username);
	        statement.setString(16, password);
	        statement.setInt(17, studentID);

	        int resultSet = statement.executeUpdate();
	    }
	    catch(SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void updateEnrollmentStatus(String status, int enrollmentID) {
		String query = "UPDATE enrollments SET status = ? "
				+ "WHERE enrollment_id = ? ;";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, status);
			statement.setInt(2, enrollmentID);
			
			int resultSet = statement.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String getEnrollmentStatus(int enrollmentID) {
		String query = "SELECT status FROM enrollments WHERE enrollment_id = ?;";
		String status = "";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, enrollmentID);
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				status = resultSet.getString("status");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	public boolean isStudentIdExist(int studentID, String selectedYear) {
		String query = "SELECT student_id FROM enrollments WHERE student_id = ? AND school_year = ?;";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, studentID);
			statement.setString(2, selectedYear);
			ResultSet resultSet = statement.executeQuery();
			
			return resultSet.next();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public void approveAndAssignSection(int enrollmentId, int studentId) {
	    try {
	        // Get student's strand
	        String getStrandQuery = "SELECT strand_id FROM students WHERE student_id = ?";
	        PreparedStatement strandStmt = connection.prepareStatement(getStrandQuery);
	        strandStmt.setInt(1, studentId);
	        ResultSet strandRs = strandStmt.executeQuery();

	        int strandId = -1;
	        if (strandRs.next()) {
	            strandId = strandRs.getInt("strand_id");
	        }

	        if (strandId == -1) {
	            JOptionPane.showMessageDialog(null, "Strand not found!");
	            return;
	        }

	        // Find available section
	        String getSectionQuery = "SELECT sections.section_id FROM sections " +
	                "WHERE sections.strand_id = ? " +
	                "AND (SELECT COUNT(*) FROM enrollments " +
	                "WHERE enrollments.section_id = sections.section_id " +
	                "AND status = 'ENROLLED') < sections.capacity " +
	                "LIMIT 1";
	        PreparedStatement sectionStmt = connection.prepareStatement(getSectionQuery);
	        sectionStmt.setInt(1, strandId);
	        ResultSet sectionRs = sectionStmt.executeQuery();

	        int sectionId = -1;
	        if (sectionRs.next()) {
	            sectionId = sectionRs.getInt("section_id");
	        }

	        if (sectionId == -1) {
	            JOptionPane.showMessageDialog(null, "No available section for this strand!");
	            return;
	        }

	        // Assign section + update status
	        String updateQuery = "UPDATE enrollments SET section_id = ?, " +
	                "status = 'ENROLLED' WHERE enrollment_id = ?";
	        PreparedStatement updateStmt = connection.prepareStatement(updateQuery);
	        updateStmt.setInt(1, sectionId);
	        updateStmt.setInt(2, enrollmentId);
	        updateStmt.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public ArrayList<String> getSchoolYears() {
	    ArrayList<String> schoolYears = new ArrayList<>();
	    String query = "SELECT DISTINCT school_year FROM enrollments ORDER BY school_year DESC;";
	    
	    try {
	        PreparedStatement statement = connection.prepareStatement(query);
	        ResultSet resultSet = statement.executeQuery();
	        
	        while(resultSet.next()) {
	            schoolYears.add(resultSet.getString("school_year"));
	        }
	    }
	    catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return schoolYears;
	}
	
	public String getRequirementsStatus(String documentType, int enrollmentID) {
	    String query = "SELECT status FROM student_requirements " +
	                   "WHERE document_type = ? AND enrollment_id = ?;";
	    
	    String status = "PENDING";
	    
	    try {
	        PreparedStatement statement = connection.prepareStatement(query);
	        statement.setString(1, documentType);
	        statement.setInt(2, enrollmentID);
	        ResultSet resultSet = statement.executeQuery();
	        
	        if(resultSet.next()) {
	            status = resultSet.getString("status");
	        }
	    }
	    catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return status;
	}
	
	public void insertNotification(int studentId, int notificationId) {
	    String query = "UPDATE student_notifications SET notification_id = ? "
	    		+ "WHERE student_id = ?";
	    try {
	        PreparedStatement stmt = connection.prepareStatement(query);
	        stmt.setInt(1, notificationId);
	        stmt.setInt(2, studentId);
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void unassignSection(int enrollmentID) {
	    String query = "UPDATE enrollments SET section_id = NULL WHERE enrollment_id = ?;";
	    try {
	        PreparedStatement statement = connection.prepareStatement(query);
	        statement.setInt(1, enrollmentID);
	        statement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
}
