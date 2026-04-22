package dashBoards;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Only an example
public class SQLConnection {
	
	String url = "jdbc:mysql://localhost:3306/student_enrollment_db_system";
	String username = "root";
	String password = "fdgVH2731@BIRINGAN";
	
	public SQLConnection(){
		
		String sql = "INSERT INTO strands (strand_name) VALUES (?)";
		
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			Statement statement = connection.createStatement();
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, "EIM");
			int rowsAffected = ps.executeUpdate();
		    ResultSet resultSet = statement.executeQuery("Select * From strands");
			
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1) + " "+ resultSet.getString(2));
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
