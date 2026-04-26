package dashBoards;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

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
	private int strandID;

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
		String studentIDquery = "SELECT * FROM students WHERE user_id = ?;";
		
		boolean successful = false;
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, usernameInput);
			statement.setString(2, userPasswordInput);
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next()){
				successful = true;
				userID = resultSet.getInt("user_id");
				
				PreparedStatement statement2 = connection.prepareStatement(studentIDquery);
				statement2.setInt(1, getUserID());
				ResultSet resultStudentID = statement2.executeQuery();
				if (resultStudentID.next()) {
				    studentID = resultStudentID.getInt("student_id");
				}
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
	
	public int getUserID() {
		return userID;
	}
	
	public int getStudentID() {
		return studentID;
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
