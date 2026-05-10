package dashBoards;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	
	
	
	public ArrayList<Object[]> getEnrollments() {
		String query = "SELECT students.student_id, last_name, first_name, LRN, gender, strand_id, status FROM students INNER JOIN enrollments ON students.student_id = enrollments.student_id;";
		ArrayList<Object[]> List = new ArrayList<>();
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
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
	
	public ArrayList<Object[]> getPendingEnrollments() {
		String query = "SELECT students.student_id, last_name, first_name, LRN, gender, strand_id, status FROM students INNER JOIN enrollments ON students.student_id = enrollments.student_id WHERE status = 'PENDING';";
		ArrayList<Object[]> List = new ArrayList<>();
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
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
	
	public ArrayList<Object[]> getEnrolledEnrollments() {
		String query = "SELECT students.student_id, last_name, first_name, LRN, gender, strand_id, status FROM students INNER JOIN enrollments ON students.student_id = enrollments.student_id WHERE status = 'ENROLLED';";
		ArrayList<Object[]> List = new ArrayList<>();
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
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
	
	public ArrayList<Object[]> getRejectedEnrollments() {
		String query = "SELECT students.student_id, last_name, first_name, LRN, gender, strand_id, status FROM students INNER JOIN enrollments ON students.student_id = enrollments.student_id WHERE status = 'REJECTED';";
		ArrayList<Object[]> List = new ArrayList<>();
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
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
	
	public ArrayList<Object[]> searchStudent(int student_id) {
		String query = "SELECT students.student_id, last_name, first_name, LRN, gender, strand_id, status FROM students INNER JOIN enrollments ON students.student_id = enrollments.student_id WHERE students.student_id = ?;";
		ArrayList<Object[]> List = new ArrayList<>();
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, student_id);
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
		String query = "SELECT student_id, last_name, first_name, middle_name,"
				+ "LRN, birthdate, gender, phone_number, address, email, user_accounts.user_id "
				+ "FROM students INNER JOIN user_accounts "
				+ "ON students.user_id = user_accounts.user_id "
				+ "WHERE students.student_id = ?;";
		Object[] studentData = new Object[9];
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, student_id);
			ResultSet resultSet = statement.executeQuery();

			if(resultSet.next()) {
				studentData[0] = resultSet.getInt("student_id");
				studentData[1] = resultSet.getString("last_name") + ", " + resultSet.getString("first_name") + " "+ resultSet.getString("middle_name");
				studentData[2] = resultSet.getString("LRN");
				studentData[3] = resultSet.getString("birthdate");
				studentData[4] = resultSet.getString("gender");
				studentData[5] = resultSet.getString("phone_number");
				studentData[6] = resultSet.getString("address");
				studentData[7] = resultSet.getString("email");
				studentData[8] = resultSet.getString("user_id");
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
	
	public int getTotalPending(String status) {
		String query = "SELECT COUNT(*) AS totalPending  FROM enrollments WHERE status = ?;";
		int total = 0;
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, status);
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
	
}
