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
	
}
