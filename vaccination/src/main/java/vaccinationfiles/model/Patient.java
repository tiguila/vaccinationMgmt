package vaccinationfiles.model;

import java.util.Date;

public class Patient {

	private int patientId;
	private String patientName;
	private int vaccineId;
	private String vaccineNameReceived;
	private Date firstDoseDate;
	private Date secondDoseDate;
	private int vaccineDosesRequired;
	private int vaccineDosesLeft;
	
	public Patient() {
	}
	
	public int getVaccineId() {
		return vaccineId;
	}
	public void setVaccineId(int vaccineId) {
		this.vaccineId = vaccineId;
	}

	public int getVaccineDosesRequired() {
		return vaccineDosesRequired;
	}

	public void setVaccineDosesRequired(int vaccineDosesRequired) {
		this.vaccineDosesRequired = vaccineDosesRequired;
	}

	public int getVaccineDosesLeft() {
		return vaccineDosesLeft;
	}

	public void setVaccineDosesLeft(int vaccineDosesLeft) {
		this.vaccineDosesLeft = vaccineDosesLeft;
	}

	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getVaccineNameReceived() {
		return vaccineNameReceived;
	}

	public void setVaccineNameReceived(String vaccineNameReceived) {
		this.vaccineNameReceived = vaccineNameReceived;
	}

	public Date getFirstDoseDate() {
		return firstDoseDate;
	}

	public void setFirstDoseDate(Date firstDoseDate) {
		this.firstDoseDate = firstDoseDate;
	}

	public Date getSecondDoseDate() {
		return secondDoseDate;
	}

	public void setSecondDoseDate(Date secondDoseDate) {
		this.secondDoseDate = secondDoseDate;
	}

}
