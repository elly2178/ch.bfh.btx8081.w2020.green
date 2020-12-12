package model;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import model.common.Address;
import model.common.Person;

@Entity
@Table(name = "Patients")
public class Patient extends Person{

	@Id
	private int pid;
	private String healthInsuranceName;
	private ArrayList<String> diaries = new ArrayList();
	
	int ybocs;
	int mood;
	int combined = ybocs + mood;
	LocalDate birthDate = LocalDate.of(1989, 05, 18);
	LocalDate dateToday = java.time.LocalDate.now();



	public Patient(String firstName, String secondName, LocalDate birthDate, boolean gender, Address address,
			String email, String phonenumber) {
		super(firstName, secondName, birthDate, gender, address, email, phonenumber);
		// TODO Auto-generated constructor stub
	}

	public Patient() {
		
	}

	//calculateAVr score
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
