package model.common;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "patients")
public class Patient extends Person implements Serializable {

	@Column
	private String healthInsuranceName;
	@OneToMany
	private List<String> diaries = new ArrayList<>();

	int ybocs;
	int mood;
	int combined = ybocs + mood;
	LocalDate birthDate = LocalDate.of(1989, 05, 18);
	LocalDate dateToday = java.time.LocalDate.now();

	public Patient(String firstName, String secondName, LocalDate birthDate, char gender, Address address, String email,
			String phone) {
		super(firstName, secondName, birthDate, gender, address, email, phone);
	}

	public Patient() {

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
}
