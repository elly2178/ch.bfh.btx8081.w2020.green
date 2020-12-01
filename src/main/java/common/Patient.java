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
	public Patient(String firstName, String secondName, Date birthDate, boolean gender, common.Address address,
			String email) {
		super(firstName, secondName, birthDate, gender, address, email);
		// TODO Auto-generated constructor stub
	}

	private int pid;
	private String healthInsuranceName;
	private List<String> diaries = new ArrayList();
	
//	Person pat1 = new Person("Georgiana", "Dumitru", Date birthDate, False, Address address, "random@email.com") {
//	};
	
	public boolean isAdult() {
		LocalDate dateToday = java.time.LocalDate.now();
		 
		 
		System.out.println("THE TIME NOW IS "+ dateToday);
		return true;
		//age = 
	}
	 // isAdult meth
	// isAdult = today - get. brithdate 
	// if isAdult >= 18 -> return true
	// else return false
	}
