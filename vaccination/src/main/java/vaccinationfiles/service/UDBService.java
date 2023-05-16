package vaccinationfiles.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vaccinationfiles.model.User;
import vaccinationfiles.model.Vaccine;


public class UDBService {

	public UDBService() {
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public User getUser(int id) {
		User entry = new User();
		try {
			String sql = "select * from users where id = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				entry.setUsername(rs.getString("username"));
				entry.setPassword(rs.getString("password"));
				entry.setName(rs.getString("name"));
				entry.setRole(rs.getString("role"));
				entry.setId(rs.getInt("id"));
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entry;
	}
	
	
	public User getUser(String username, String password) {
		User entry = new User();
		try {
			String sql = "select * from users where username = ? and password = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				entry.setUsername(rs.getString("username"));
				entry.setPassword(rs.getString("password"));
				entry.setName(rs.getString("name"));
				entry.setRole(rs.getString("role"));
				entry.setId(rs.getInt("id"));
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entry;
	}
	
	
	public void changeUsername(String userName, int userId) {
		try {
			String sql = "update users set name = ? where id = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setInt(2, userId);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	
	public void changePassword(String password, int userId) {
		try {
			String sql = "update users set password = ? where id = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setInt(2, userId);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	
	

  
 
	
	
//	protected area
	
	
	
	
	
	
	
	
	private String url = "jdbc:mysql://cs3.calstatela.edu/username";
	private String username = "username";
	private String password = "password";
	private Connection connection;
	
}
