package common;

import java.util.Date;

/**
 * Basic abstract class representing any kind of person.
 */
public abstract class Person {
	private String firstName;
	private String secondName;
	private Date birthDate;
	private boolean gender;
	private Address address;
	private String email;

	public Person(String firstName, String secondName, Date birthDate, boolean gender, Address address, String email) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
		this.birthDate = birthDate;
		this.gender= gender;
		this.address = address;
		this.email = email;
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
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
}
