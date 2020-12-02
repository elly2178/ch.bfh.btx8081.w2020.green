package model;

import java.time.LocalDate;

import common.Address;
import common.Patient;

public class PatientModel {
	int ybocs;
	int mood;
	int combined = ybocs + mood;
	
	LocalDate birthDate = LocalDate.of(1989, 05, 18);
	Address patAddress = new Address(2502, "Freistrasse", "Biel", "Schweiz");
	Patient pat1 = new Patient("Georgiana", "Dumitru", birthDate, false, patAddress, "random@email.com");
	
	//calculateAVr score
	public float calculateAvarageScore() {
		int inputTime = 14;
		float avarageScore = (float) combined / inputTime;
		return avarageScore;
		
	}
}
