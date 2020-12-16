package model.common;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Basic abstract class representing any kind of person.
 */
@Entity
@Table(name = "persons")
public abstract class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@Column
	private String firstName;
	@Column
	private String secondName;
	@Column
	private LocalDate birthDate;
	@Column
	private char gender;
	@Column
	private String email;
	@Column
	private String phone;
	@Column
	private Address address;

	public Person(String firstName, String secondName, LocalDate birthDate, char gender, Address address, String email,
			String phone) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.birthDate = birthDate;
		this.gender = gender;
		this.address = address;
		this.email = email;
		this.phone = phone;
	}

	public Person() {

	}

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

	public char isGender() {
		return gender;
	}

	public void setGender(char gender) {
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

	@Override
	public String toString() {
		return "Person{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", secondName='" + secondName + '\'' +
				", birthDate=" + birthDate +
				", gender=" + gender +
				", email='" + email + '\'' +
				", phone='" + phone + '\'' +
				", address=" + address.toString() +
				'}';
	}
}
