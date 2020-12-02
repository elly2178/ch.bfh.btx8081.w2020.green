package model;

import java.time.LocalDate;
import java.util.ArrayList;
import common.Address; 
import common.Person;

public class PatientModel extends Person{
	
	int ybocs;
	int mood;
	int combined = ybocs + mood;
	private int pid;
	private String healthInsuranceName;
	private ArrayList<String> diaries = new ArrayList();
	
	public PatientModel(String firstName, String secondName, LocalDate birthDate, boolean gender, Address address,
			String email) {
		super(firstName, secondName, birthDate, gender, address, email);
		// TODO Auto-generated constructor stub
	}

	LocalDate birthDate = LocalDate.of(1989, 05, 18);
	Address patAddress = new Address(2502, "Freistrasse", "Biel", "Schweiz");
	//Patient pat1 = new Patient("Georgiana", "Dumitru", birthDate, false, patAddress, "random@email.com");
	
	//calculateAVr score
	public float calculateAvarageScore() {
		int inputTime = 14;
		float avarageScore = (float) combined / inputTime;
		return avarageScore;
		
	}
	
	public boolean isAdult() {
		LocalDate dateToday = java.time.LocalDate.now();
		LocalDate birthDate = LocalDate.of(1989, 05, 18);
		 
		int yearDiff = dateToday.getYear() - birthDate.getYear();
				
		if (yearDiff >= 18) {
			return true;
		} else {
			return false;
		}
		 
	}
}
