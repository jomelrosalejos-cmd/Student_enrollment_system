package dashBoards;

import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class DatabaseConnection {
	
	private static String url = "jdbc:mysql://localhost:3306/student_enrollment_db_system";
	private static String username = "root";
	private static String password = "fdgVH2731@BIRINGAN";
	
	private int userID;
	private int studentID;
	private String LRN;
	private String firstName;
	private String lastName;
	private String middleName;
	private String birthdate;
	private String gender;
	private String address;
	private String phoneNumber;
	private int strandID;
	private int enrollmentID;

	static Connection connection;
	static {
	    try {
	    	connection = DriverManager.getConnection(url, username, password);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
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
				userID = resultSet.getInt("user_id");
			}
			else{successful = false;}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return successful;
	}
	
	//Insert
	public void insertInformation(int strandID, String LRN, String lastName, String firstName, 
			String middleName, LocalDate birthdate, String gender, String address, String phoneNumber) {
		String query = "INSERT INTO students "
				+ "(user_id, strand_id, LRN, last_name, first_name, middle_name, birthdate, gender, address, phone_number) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, getUserID());
			statement.setInt(2, strandID);
			statement.setString(3, LRN);
			statement.setString(4, lastName);
			statement.setString(5, firstName);
			statement.setString(6, middleName);
			statement.setObject(7, birthdate);
			statement.setString(8, gender);
			statement.setString(9, address);
			statement.setString(10, phoneNumber);
			
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
			    System.out.println("Insert successful!");
			} else {
			    System.out.println("Insert failed — 0 rows affected.");
			}			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertEnrollment() {
		String query = "INSERT INTO enrollments (student_id, school_year) VALUES "
				+ "(?, ?);";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, getStudentID());
			statement.setString(2, "2026-2027");
			
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
			    System.out.println("Insert successful!");
			} else {
			    System.out.println("Insert failed — 0 rows affected.");
			}	
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void insertDocument(String doctype, Path form137destination) {
		String query = "INSERT INTO student_requirements (enrollment_id, file_path, document_type) VALUES "
				+ "(?, ?, ?);";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, getEnrollmentID());
			statement.setString(2, form137destination.toString());
			statement.setString(3, doctype);
			
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
			    System.out.println("Insert successful!");
			} else {
			    System.out.println("Insert failed — 0 rows affected.");
			}	
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Select
	public void studentInformation() {
		String query = "SELECT * FROM students WHERE student_id = ?;";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, getStudentID());
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				LRN = resultSet.getString("LRN");
				firstName = resultSet.getString("first_name");
				lastName = resultSet.getString("last_name");
				strandID = resultSet.getInt("strand_id");
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void createNewAccount(String username, String pass, String email) {
		String query = "INSERT INTO user_accounts (role_id, user_name, password, email) VALUES " +
						"(?, ?, ?, ?);";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, 1);
			statement.setString(2, username);
			statement.setString(3, pass);
			statement.setString(4, email);
			
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
			    System.out.println("Insert successful!");}
			else {
			    System.out.println("Insert failed — 0 rows affected.");}	
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public String getGender() {
		return gender;
	}
	public int getUserID() {
		return userID;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public String getMiddleName() {
		return middleName;
	}
	public int getStudentID() {
		String studentIDquery = "SELECT * FROM students WHERE user_id = ?;";
		
		try {
			PreparedStatement statement2 = connection.prepareStatement(studentIDquery);
			statement2.setInt(1, getUserID());
			ResultSet resultStudentID = statement2.executeQuery();
			if (resultStudentID.next()) {
			    studentID = resultStudentID.getInt("student_id");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return studentID;
	}
	
	public int getEnrollmentID() {
		String studentIDquery = "SELECT * FROM enrollments WHERE student_id = ?;";
		
		try {
			PreparedStatement statement2 = connection.prepareStatement(studentIDquery);
			statement2.setInt(1, getStudentID());
			ResultSet resultEnrollmentID = statement2.executeQuery();
			if (resultEnrollmentID.next()) {
			    enrollmentID = resultEnrollmentID.getInt("enrollment_id");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return enrollmentID;
	}
	
	public String getStrand() {
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
	
	public String getLRN() {
		return LRN;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
}