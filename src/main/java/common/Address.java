package common;

/**
 * Class representing an address.
 */
public class Address {

	private int postalCode;
	private String street;
	private String city;
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
