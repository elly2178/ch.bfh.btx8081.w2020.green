package common;
import common.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * Class represents a patient.
 */
public class Patient extends Person {
	private int pid;
	private String healthInsuranceName;
	private List<String> diaries;

	public Patient() {
		diaries = new ArrayList<>();
	}

	public boolean isAdult(){

		return true;
	}

	public int calculateAverageScore(){
		return 1;
	}
}
