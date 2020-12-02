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
	
	

	public Patient(String firstName, String secondName, LocalDate birthDate, boolean gender, Address address,
			String email) {
		super(firstName, secondName, birthDate, gender, address, email);
		// TODO Auto-generated constructor stub
	}

	private int pid;
	private String healthInsuranceName;
	private List<String> diaries = new ArrayList();
	
	
	public boolean isAdult() {
		// zeilen 30 bin36 kommt in model
		LocalDate dateToday = java.time.LocalDate.now();
		LocalDate birthDate = LocalDate.of(1989, 05, 18);
		Address patAddress = new Address(2502, "Freistrasse", "Biel", "Schweiz");
		Patient pat1 = new Patient("Georgiana", "Dumitru", birthDate, false, patAddress, "random@email.com");
		
		int yearDiff = dateToday.getYear() - birthDate.getYear();
		
		if (yearDiff >= 18) {
			return true;
		} else {
			return false;
		}
		 
	}
	 
	}
