package model.common;

import java.time.LocalDate;

import javax.persistence.*;

/**
 * Basic abstract class representing any kind of person.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table
public abstract class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@Column
	private String firstName;
	@Column
	private String secondName;
	@Column
	private String birthDate;
	@Column
	private String gender;
	@Column
	private String email;
	@Column
	private String phone;
	@Column
	private Address address;

	public Person(String firstName, String secondName, String birthDate, String gender, Address address, String email,
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

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String isGender() {
		return gender;
	}

	public void setGender(String gender) {
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
