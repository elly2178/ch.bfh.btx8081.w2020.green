package model.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

/**
 * Class representing an address.
 */
@Entity
@Table(name = "addresses")
public class Address {

	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@Column
	private int postalCode;
	@Column
	private String street;
	@Column
	private String city;
	@Column
	private String country;

	public Address(int postalCode, String street, String city, String country) {
		this.postalCode = postalCode;
		this.street = street;
		this.city = city;
		this.country = country;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}
}
