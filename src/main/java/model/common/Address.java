package model.common;

import javax.persistence.*;

/**
 * Class representing an address.
 */
@Entity
@Table(name = "addresses")
public class Address {

	@Id
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

	public Address() {

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

	@Override
	public String toString() {
		return "Address{" +
				"id=" + id +
				", postalCode=" + postalCode +
				", street='" + street + '\'' +
				", city='" + city + '\'' +
				", country='" + country + '\'' +
				'}';
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
