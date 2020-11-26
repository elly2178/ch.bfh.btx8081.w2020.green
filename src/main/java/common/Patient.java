package common;
import common.Person;
import java.util.ArrayList;
import java.util.List;



/**
 * Class represents a patient.
 */
public class Patient extends Person {
	private int pid;
	private String healthInsuranceName;
	private List<String> diaries = new ArrayList();
}
