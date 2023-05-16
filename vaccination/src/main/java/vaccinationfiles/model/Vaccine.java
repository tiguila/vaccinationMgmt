package vaccinationfiles.model;

import vaccinationfiles.model.Vaccine;

public class Vaccine {
	private int vaccineId;
	private String vaccineName;
	private int dosesRequired;
	private int daysBetweenDoses;
	private int totalDosesReceived;
	private int totalDosesLeft;

	public Vaccine(int vaccineId, String vaccineName, int dosesRequired, int daysBetweenDoses, int totalDosesReceived,
			int totalDosesLeft) {
		this.vaccineId = vaccineId;
		this.vaccineName = vaccineName;
		this.dosesRequired = dosesRequired;
		this.daysBetweenDoses = daysBetweenDoses;
		this.totalDosesReceived = totalDosesReceived;
		this.totalDosesLeft = totalDosesLeft;
	}
	
	public Vaccine() {
	}

	public int getDosesRequired() {
		return dosesRequired;
	}

	public void setDosesRequired(int dosesRequired) {
		this.dosesRequired = dosesRequired;
	}

	public int getDaysBetweenDoses() {
		return daysBetweenDoses;
	}

	public void setDaysBetweenDoses(int daysBetweenDoses) {
		this.daysBetweenDoses = daysBetweenDoses;
	}

	public int getTotalDosesReceived() {
		return totalDosesReceived;
	}

	public void setTotalDosesReceived(int totalDosesReceived) {
		this.totalDosesReceived = totalDosesReceived;
	}

	public int getTotalDosesLeft() {
		return totalDosesLeft;
	}

	public void setTotalDosesLeft(int totalDosesLeft) {
		this.totalDosesLeft = totalDosesLeft;
	}

	public int getVaccineId() {
		return vaccineId;
	}

	public void setVaccineId(int vaccineId) {
		this.vaccineId = vaccineId;
	}

	public String getVaccineName() {
		return vaccineName;
	}
	
	public void setVaccineName(String name) {
		this.vaccineName = name;
	}
}
