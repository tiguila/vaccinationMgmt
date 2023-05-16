package vaccinationfiles.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vaccinationfiles.model.Patient;

public class PDBService {
	
	public PDBService() {
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
	
	public void secondDate(int patientId) {
		try {
			String sql = "update patients set second_dose_date = ? where patient_id = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			Date date = new Date();
			pstmt.setDate(1, new java.sql.Date(date.getTime()));
			pstmt.setInt(2, patientId);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Patient getPatientById(int id) {
		Patient entry = new Patient();
		try {
			String sql = "select * from patients where patient_id = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				entry.setPatientId(rs.getInt("patient_id"));
				entry.setPatientName(rs.getString("patient_name"));
				entry.setVaccineId(rs.getInt("vaccine_id"));
				entry.setVaccineNameReceived(rs.getNString("vaccine_name"));
				entry.setFirstDoseDate(rs.getDate("first_dose_date"));
				entry.setSecondDoseDate(rs.getDate("second_dose_date"));
				entry.setVaccineDosesRequired(rs.getInt("vaccine_doses_required"));
				entry.setVaccineDosesLeft(rs.getInt("vaccine_doses_left"));
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entry;
	}
	
	public int addPatient(String patientName, int vaccineId, String vaccineName, int dosesRequired, int totalDosesLeft) {
		int id = 0;
		try {
			Date firstDoseDate = new Date();
			String sql = "insert into patients (patient_name, vaccine_id, vaccine_name, vaccine_doses_required, vaccine_doses_left, first_dose_date) values (?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, patientName);
			pstmt.setInt(2, vaccineId);
			pstmt.setString(3, vaccineName);
			pstmt.setInt(4, dosesRequired);
			pstmt.setInt(5, totalDosesLeft);
			pstmt.setDate(6, new java.sql.Date(firstDoseDate.getTime()));
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
	
	
	
	
	
	/** Done! */
	public List<Patient> getPatients() {
		List<Patient> patients = new ArrayList<Patient>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from patients");
			while (rs.next()) {
				Patient p = new Patient();
				p.setPatientId(rs.getInt("patient_id"));
				p.setPatientName(rs.getString("patient_name"));
				p.setVaccineId(rs.getInt("vaccine_id"));
				p.setVaccineNameReceived(rs.getString("vaccine_name"));
				p.setFirstDoseDate(rs.getDate("first_dose_date"));
				p.setSecondDoseDate(rs.getDate("second_dose_date"));
				p.setVaccineDosesRequired(rs.getInt("vaccine_doses_required"));
				p.setVaccineDosesLeft(rs.getInt("vaccine_doses_left"));
				patients.add(p);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return patients;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	protected area
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private String url = "jdbc:mysql://cs3.calstatela.edu/username";
	private String username = "username";
	private String password = "password";
	private Connection connection;
}
