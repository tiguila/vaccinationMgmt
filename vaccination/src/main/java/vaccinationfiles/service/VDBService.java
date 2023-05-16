package vaccinationfiles.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vaccinationfiles.model.Patient;
import vaccinationfiles.model.Vaccine;

public class VDBService {
	
	public VDBService() {
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
	
	public List<Vaccine> getVaccines() {
		List<Vaccine> vaccines = new ArrayList<Vaccine>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from vaccines");
			while (rs.next()) {
				Vaccine ve = new Vaccine();	
				ve.setVaccineId(rs.getInt("id"));
				ve.setVaccineName(rs.getString("name"));
				ve.setDosesRequired(rs.getInt("doses_required"));
				ve.setDaysBetweenDoses(rs.getInt("days_between_doses"));
				ve.setTotalDosesReceived(rs.getInt("doses_received"));
				ve.setTotalDosesLeft(rs.getInt("doses_left"));
				vaccines.add(ve);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vaccines;
	}

	public Vaccine getVaccineById(int id) {
		Vaccine entry = new Vaccine();
		try {
			String sql = "select * from vaccines where id = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				entry.setVaccineId(rs.getInt("id"));
				entry.setVaccineName(rs.getString("name"));
				entry.setDosesRequired(rs.getInt("doses_required"));
				entry.setDaysBetweenDoses(rs.getInt("days_between_doses"));
				entry.setTotalDosesReceived(rs.getInt("doses_received"));
				entry.setTotalDosesLeft(rs.getInt("doses_left"));
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entry;
	}
	
	public Vaccine getVaccineByName(String vaccineName) {
		Vaccine entry = new Vaccine();
		try {
			String sql = "select * from vaccines where name = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, vaccineName);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				entry.setVaccineId(rs.getInt("id"));
				entry.setVaccineName(rs.getString("name"));
				entry.setDosesRequired(rs.getInt("doses_required"));
				entry.setDaysBetweenDoses(rs.getInt("days_between_doses"));
				entry.setTotalDosesReceived(rs.getInt("doses_received"));
				entry.setTotalDosesLeft(rs.getInt("doses_left"));
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entry;
	}

	public Vaccine getVaccine(String vaccineName) {
		Vaccine entry = new Vaccine();
		try {
			String sql = "select * from vaccines where name = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, vaccineName);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				entry.setVaccineId(rs.getInt("id"));
				entry.setVaccineName(rs.getString("name"));
				entry.setDosesRequired(rs.getInt("doses_required"));
				entry.setDaysBetweenDoses(rs.getInt("days_between_doses"));
				entry.setTotalDosesReceived(rs.getInt("doses_received"));
				entry.setTotalDosesLeft(rs.getInt("doses_left"));
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entry;
	}

 
	public int addVaccine(String vaccineName, int dosesRequired, int daysBetweenDoses) {
		int id = 0;
		try {
			String sql = "insert into vaccines (name, doses_required, days_between_doses) values (?, ?, ?)";
			PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, vaccineName);
			pstmt.setInt(2, dosesRequired);
			pstmt.setInt(3, daysBetweenDoses);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next())
				id = rs.getInt(1);
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
 
	public void editVaccine(int vaccineId, String vaccineName, int dosesRequired, int daysBetweenDoses) {
		
		try {
			String sql = "update vaccines set name = ?, doses_required = ?, days_between_doses = ? where id = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, vaccineName);
			pstmt.setInt(2, dosesRequired);
			pstmt.setInt(3, daysBetweenDoses);
			pstmt.setInt(4, vaccineId);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	public void newDoses(String vaccineName, int doses) {
		try {
			String sql = "update vaccines set doses_received = ?, doses_left = ? where id = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, doses);
			pstmt.setInt(2, doses);
			pstmt.setString(3, vaccineName);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	public void updateTotalDosesLeft(int vaccindId, int totalDosesLeft) {
		try {
			String sql = "update vaccines set doses_left = ? where id = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, totalDosesLeft-1);
			pstmt.setInt(2, vaccindId);
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
