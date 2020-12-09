package common;

import javax.persistence.*;
import java.time.LocalDate;


/**
 * Basic abstract class representing any kind of person.
 */

@Entity
public abstract class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	private String firstName;
	private String secondName;
	private LocalDate birthDate;
	private boolean gender;
	private String email;
	private String phone;

	private Address address;


	public Person(String firstName, String secondName, LocalDate birthDate, boolean gender, Address address, String email, String phone) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
		this.birthDate = birthDate;
		this.gender= gender;
		this.address = address;
		this.email = email;
		this.phone = phone;
	}

    public Person() {

    }

    //private enum Gender { MALE, FEMALE}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
