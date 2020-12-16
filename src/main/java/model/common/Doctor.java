package model.common;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Class representing a doctor.
 */
@Entity
@Table(name = "doctors")
public class Doctor extends Person implements Serializable {

	@Column
	private String title;
	@Column
	private String location;
	@OneToMany
	private List<Patient> patients;

	public Doctor(String firstName, String secondName, LocalDate birthDate, char gender, Address address, String email,
			String phone, String title) {
		super(firstName, secondName, birthDate, gender, address, email, phone);
		this.title = title;
	}

	public Doctor() {
		super();
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
