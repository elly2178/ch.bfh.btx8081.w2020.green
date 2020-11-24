package core;

public class Address {

    private int postalCode;
    private String street;
    private String city;
    private String country;

    public Address(int postalCode, String street, String city, String country){
      this.postalCode = postalCode;
      this.street = street;
      this.city = city;
      this.country = country;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
