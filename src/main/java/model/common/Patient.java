package model.common;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Class representing a patient.
 */

@Entity
@Table(name = "patients")
public class Patient extends Person implements Serializable {

	@Column
	private String healthInsuranceName;
	@Column
	private String patientInsuranceId;
	@OneToMany
	private List<String> diaries = new ArrayList<>();


	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	int patientId;
	String patientInsurance;
	//String patientInsuranceId;
	int ybocs;
	int mood;
	int combined = ybocs + mood;
	LocalDate birthDate = LocalDate.of(1977, 03, 18);
	LocalDate dateToday = java.time.LocalDate.now();

	public Patient(int patientId, String firstName, String secondName, String birthDate, String gender, Address address, String email,
			String phone, String patientInsurance, String patientInsuranceId) {
		super(firstName, secondName, birthDate, gender, address, email, phone);
	}

	public Patient() {

	}
	
	// Patient ID
	public int getPatientId() {
		return patientId;
	}

	//public void setPatientId(int patientId) {
		//this.patientId = patientId;
	//}
	
	// Patient health insurance
	public String getPatientInsurance() {
		return patientInsurance;
	}

	public void setPatientInsurance(String patientInsurance) {
		this.patientInsurance = patientInsurance;
	}
	
	// Patient Insurance ID
	public String getPatientInsuranceId() {
		return patientInsuranceId;
	}

	public void setPatientInsuranceId(String patientInsuranceId) {
		this.patientInsuranceId = patientInsuranceId;
	}
	
	

	// calculateAVr score
	public float calculateAvarageScore() {
		int inputTime = 14;
		float avarageScore = (float) combined / inputTime;
		return avarageScore;

	}

	public boolean isAdult() {
		int yearDiff = dateToday.getYear() - birthDate.getYear();
		if (yearDiff >= 18) {
			System.out.println("YOU ARE AN ADULT");
			return true;
		} else {
			return false;
		}

	}

	@Override
	public String toString() {
		return "Patient{" +
				"healthInsuranceName='" + healthInsuranceName + '\'' +
				", diaries=" + diaries +
				", ybocs=" + ybocs +
				", mood=" + mood +
				", combined=" + combined +
				", birthDate=" + birthDate +
				", dateToday=" + dateToday +
				'}';

	}


	
}
