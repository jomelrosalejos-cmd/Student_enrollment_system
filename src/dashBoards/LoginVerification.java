package dashBoards;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class LoginVerification {
	
	String url = "jdbc:mysql://localhost:3306/student_enrollment_db_system";
	String username = "root";
	String password = "fdgVH2731@BIRINGAN";
	
	public LoginVerification(String usernameInput, String userPasswordInput) {
		
		String query = "SELECT user_name, password FROM user_accounts WHERE user_name = ? AND password = ?;";
			
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, usernameInput);
			statement.setString(2, userPasswordInput);
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
			    System.out.println("Login success");
			    new StudentDashBoard();
			} else{
			    System.out.println("Login failed");
			    JOptionPane.showMessageDialog(null, "Login failed", "Failed", JOptionPane.INFORMATION_MESSAGE);
			}
		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
